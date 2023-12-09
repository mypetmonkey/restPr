package com.uPractice;

import static  org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

@SuppressWarnings("unused")
public class Extract_response {
	
	
	@Test
	public void test() {
		baseURI="https://api.postman.com";
		
	Response res=given()
		.header("x-api-key","PMAK-65695e66e6daac0b110283f6-66011405379bdfb029bda9d97cfdc869ab")
	.when()
		.get("/workspaces")
	.then()
	.log().ifError()
	.assertThat()
	.statusCode(200)
	.extract()
	.response();
	System.out.println("response is "+res.asString());
		
	}

}
