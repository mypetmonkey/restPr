package com.parameters;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.config.EncoderConfig;

public class Form_param_url_encoded {

	@Test
	public void test_form() {
	given()
		.baseUri("https://postman-echo.com")
		.config(config().encoderConfig(EncoderConfig.encoderConfig()
				.appendDefaultContentCharsetToContentTypeIfUndefined(false)))
		.formParam("key1", "value1")
		.formParam("key 2", "value 2")
		.log().all()
		
	.when()
		.post("/post")
		
	.then()
	.assertThat()
	.statusCode(200)
		.log().all() 
		;
	}
	
	
}
