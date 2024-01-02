package com.restassuredFilter;

import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

import org.testng.annotations.Test;

import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;

import static io.restassured.RestAssured.*;

@SuppressWarnings("unused")
public class Filter_Example {
	
	@Test
	public void filter_Test() throws FileNotFoundException {
		
		PrintStream stream=new PrintStream(new File("restassured.log"));
		
		
	given()
	
		.baseUri("https://postman-echo.com")
		//.log().all()
		.filter(new RequestLoggingFilter(LogDetail.BODY,stream))
		.filter(new ResponseLoggingFilter(LogDetail.STATUS,stream))
		
		
	.when()
		.get("/get")
		
		
	.then()
		//.log().all()
		.assertThat()
		.statusCode(200)
		;
		
	}

}
