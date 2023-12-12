package com.jsonschemavalidate;

import static  org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

import io.restassured.module.jsv.JsonSchemaValidator;

import static io.restassured.RestAssured.*;

@SuppressWarnings("unused")
public class Validate_Json_Schema {
	
	@Test
	public void test() {

		given()
		.baseUri("https://postman-echo.com")
		.log().all()
		
		.when()
		.get("/get")
		
		.then()
		.assertThat()
		.statusCode(200)
		.body(JsonSchemaValidator.matchesJsonSchemaInClasspath("EchoJsonSchema.json"))
		.log().all()
		;
	}

}
