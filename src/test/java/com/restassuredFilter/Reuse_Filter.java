package com.restassuredFilter;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.PrintStream;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Reuse_Filter {
	
	RequestSpecification request;
	ResponseSpecification response;
	
	@BeforeClass
	public void test() throws Throwable {
		PrintStream stream=new PrintStream(new File("restassured.log"));
		RequestSpecBuilder builder=new RequestSpecBuilder()
		.addFilter(new RequestLoggingFilter(stream))
		.addFilter(new ResponseLoggingFilter(stream));
		
		  request=builder.build();
		  
		  ResponseSpecBuilder responsebuilder=new ResponseSpecBuilder();
		  response=responsebuilder.build();
		
	}

	
	@Test
	public void filter_Test() {
		
		
		
	given(request)
	
		.baseUri("https://postman-echo.com")
		//.log().all()
		
		.when()
		.get("/get")
		
	.then().spec(response)
		//.log().all()
		.assertThat()
		.statusCode(200)
		;
		
	}
}
