package api;

import static io.restassured.http.ContentType.JSON;
import static io.restassured.http.ContentType.TEXT;

import org.apache.http.HttpHeaders;
import org.apache.http.HttpStatus;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Specifications {

	public static RequestSpecification requestSpecification(String url) {
		return new RequestSpecBuilder()
				.setBaseUri(url)
				.setContentType(JSON)
				.build();
	}

	public static ResponseSpecification successResponseSpecification() {
		return new ResponseSpecBuilder()
				.expectContentType(JSON)
				.expectHeader(HttpHeaders.CONNECTION, "keep-alive")
				.expectStatusCode(HttpStatus.SC_OK)
				.build();
	}

	public static ResponseSpecification createdResponseSpecification() {
		return new ResponseSpecBuilder()
				.expectContentType(JSON)
				.expectHeader(HttpHeaders.CONNECTION, "keep-alive")
				.expectStatusCode(HttpStatus.SC_CREATED)
				.build();
	}

	public static ResponseSpecification productNotFound() {
		return new ResponseSpecBuilder()
				.expectContentType(TEXT)
				.expectHeader(HttpHeaders.CONNECTION, "keep-alive")
				.expectStatusCode(HttpStatus.SC_NOT_FOUND)
				.build();
	}

	public static void installSpecification(RequestSpecification request, ResponseSpecification response) {
		RestAssured.requestSpecification = request;
		RestAssured.responseSpecification = response;
	}

	public static void installSpecification(RequestSpecification request) {
		RestAssured.requestSpecification = request;
	}
}
