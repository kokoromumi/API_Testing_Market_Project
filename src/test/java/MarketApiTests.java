import java.util.ArrayList;
import java.util.Collections;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import api.*;

public class MarketApiTests {

	@Test
	public void checkNewCategoryIsCreated() {
		Category newCategory = new Category(RandomStringUtils.randomAlphabetic(6), RandomStringUtils.randomAlphabetic(7), true);
		CategoryResponse createdCategory = MarketApi.createNewCategory(newCategory);

		SoftAssert softly = new SoftAssert();
		softly.assertEquals(newCategory.getName(), createdCategory.getName());
		softly.assertEquals(newCategory.getBrand(), createdCategory.getBrand());
		softly.assertEquals(newCategory.getVisibility(), createdCategory.getVisibility());
		softly.assertAll();
	}

	@Test
	public void changeCategoryTest() {

	}

	@Test
	public void deleteCategoryTest() {

	}

	@Test
	public void checkNewProductIsCreated() {
		ArrayList<Category> categories = new ArrayList<>();
		Collections.addAll(categories, new Category(RandomStringUtils.randomAlphabetic(6), RandomStringUtils.randomAlphabetic(7), true));
		Product product = new Product(RandomUtils.nextInt(1, 20), categories, RandomUtils.nextInt(0, 50), true, RandomStringUtils.randomAlphabetic(6), RandomUtils.nextInt(0, 50));
		ProductResponse createdProduct = MarketApi.createNewProduct(product);

		SoftAssert softly = new SoftAssert();
		softly.assertEquals(product.getName(), createdProduct.getProductName());
		softly.assertEquals(product.getAmount(), createdProduct.getAmount());
		softly.assertEquals(product.getVisibility(), createdProduct.getVisibility());
		softly.assertEquals(product.getCategories(), createdProduct.getCategories());
		softly.assertEquals(product.getDiscount(), createdProduct.getDiscount());
		softly.assertEquals(product.getPercentDiscount(), createdProduct.getPercentDiscount());
		softly.assertAll();
	}

	@Test
	public void getProductsListTest() {

	}

	@Test
	public void getProductByNameTest() {

	}

	@Test
	public void changeProductByIdTest() {

	}

	@Test
	public void deleteProductByIdTest() {

	}
}
