package com.reqspecification;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.hamcrest.MatcherAssert.assertThat;

import static org.hamcrest.Matchers.*;

import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

@SuppressWarnings("unused")
public class RequestSpecBuilderExample5 {
	
	@Test
	public void test() {
		
		RequestSpecBuilder builder=new RequestSpecBuilder();
		builder.setBaseUri("https://api.postman.com");
		builder.addHeader("x-api-key","PMAK-65695e66e6daac0b110283f6-66011405379bdfb029bda9d97cfdc869ab");
		builder.log(LogDetail.ALL);
		
		RestAssured.requestSpecification=builder.build();
		
		 /* rspec= RestAssured.expect()
		   .statusCode(200)
		   .contentType(ContentType.JSON)
		   .time(lessThan(3000l),TimeUnit.MILLISECONDS)
		   .body(("workspaces[0].name").toString(),equalTo("My Workspace"))
		   .log().all();*/
		ResponseSpecBuilder respBuilder=new ResponseSpecBuilder();
		respBuilder.expectStatusCode(200);
		respBuilder.expectContentType(ContentType.JSON);
		respBuilder.log(LogDetail.ALL);
		
		RestAssured.responseSpecification=respBuilder.build();
		
	}
	
	@Test
	public void test1() {
		get("/workspaces");
		//.then().spec(rspec);
	}
	
	
	@Test
	public void test2() {
		Response resp = get("/workspaces")
		.then()//.spec(rspec)
		.extract().response();
		assertThat(resp.path("workspaces[0].name").toString(),equalTo("My Workspace"));
		
	}

}
