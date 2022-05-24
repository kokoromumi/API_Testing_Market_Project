package api;

import static io.restassured.RestAssured.given;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import beans.Board;
import io.restassured.RestAssured;
import io.restassured.mapper.ObjectMapperType;
import utils.ApiProperties;

public class MarketApi {

	private static final String BASE_URL = ApiProperties.getInstance().getProperty("path");
	private static final String PRODUCT_PATH = BASE_URL + "/api/product";
	private static final String PRODUCTS_PATH = BASE_URL + "/api/products";
	private static final String CATEGORY_PATH = BASE_URL + "/api/category";

	public static CategoryResponse createNewCategory(Category category) {
		Specifications.installSpecification(Specifications.requestSpecification(BASE_URL), Specifications.createdResponseSpecification());
		return new Gson().fromJson(
				RestAssured
						.given()
						.body(category, ObjectMapperType.GSON)
						.when()
						.post(CATEGORY_PATH)
						.prettyPeek().asString().trim(), new TypeToken<CategoryResponse>() {}.getType());
	}

	public static CategoryResponse changeExistingCategoryName(String id, String newName) {
		Specifications.installSpecification(Specifications.requestSpecification(BASE_URL), Specifications.successResponseSpecification());
		return given()
				.with()
				.queryParam("name",newName)
				.log().all()
				.patch(CATEGORY_PATH + "/" + id)
				.andReturn().as(CategoryResponse.class);
	}

	public static void deleteCategory(String id) {
		Specifications.installSpecification(Specifications.requestSpecification(BASE_URL), Specifications.successResponseSpecification());
		RestAssured
				.given()
                .with()
                .log().all()
				.when()
                .delete(CATEGORY_PATH + "/" + id);
	}

	public static ProductResponse createNewProduct(Product product) {
		Specifications.installSpecification(Specifications.requestSpecification(BASE_URL), Specifications.createdResponseSpecification());
		return new Gson().fromJson(
				RestAssured
						.given()
						.body(product, ObjectMapperType.GSON)
						.when()
						.post(PRODUCT_PATH)
						.prettyPeek().asString().trim(), new TypeToken<ProductResponse>() {}.getType());
	}

	public static ProductResponse getProduct(String id) {
		Specifications.installSpecification(Specifications.requestSpecification(BASE_URL), Specifications.successResponseSpecification());
		return given()
				.with()
				.log().all()
				.when()
				.get(PRODUCT_PATH + "/" + id)
				.as(ProductResponse.class);
	}

	public static List<ProductResponse> getProductsList() {
		Specifications.installSpecification(Specifications.requestSpecification(BASE_URL), Specifications.successResponseSpecification());
		return given()
				.with()
				.log().all()
				.when()
				.get(PRODUCTS_PATH)
				.then().log().all()
				.extract().body().jsonPath().getList("values", ProductResponse.class);
	}

	public static void deleteProduct(String id) {
		RestAssured
				.given()
				.with()
				.log().all()
				.when()
				.delete(PRODUCT_PATH + "/" + id);
	}

	public static ProductResponse changeExistingProductDiscount(String id, String newDiscount) {
		Specifications.installSpecification(Specifications.requestSpecification(BASE_URL), Specifications.successResponseSpecification());
		return given()
				.with()
				.queryParam("discount", newDiscount)
				.log().all()
				.patch(PRODUCT_PATH + "/" + id)
				.andReturn().as(ProductResponse.class);
	}
}

