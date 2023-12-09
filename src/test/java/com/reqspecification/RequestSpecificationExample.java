package com.reqspecification;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

@SuppressWarnings("unused")
public class RequestSpecificationExample {
	
	RequestSpecification reqspec;
	
	@BeforeClass
	public void beforeclass() {
		
		reqspec = given().// with().
		baseUri("https://api.postman.com")
		.header("x-api-key","PMAK-65695e66e6daac0b110283f6-66011405379bdfb029bda9d97cfdc869ab")
		.log().all();
		
	}
	
	@Test
	public void test2() {
		Response resp = reqspec.get("/workspaces").then().log().all().extract().response();
		assertThat(resp.statusCode(),is(equalTo(200)));
		assertThat(resp.path("workspaces[0].name").toString(),equalTo("My Workspace"));
		
	}
	
	@Test(enabled = false)
	public void test() {
		
	given(reqspec)
		//given().spec(reqspec)
		.when()
		.get("/workspaces")
		
		.then()
		.log().all()
		.assertThat()
		.statusCode(200);
		
	}

}
