package com.diffrentWayToPost;

import static org.hamcrest.Matchers.*;

import java.util.*;
import java.util.concurrent.TimeUnit;
import static org.hamcrest.MatcherAssert.assertThat;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;


@SuppressWarnings("unused")
public class UsingHashMap {
	
	@BeforeClass
	public void before() {
		RequestSpecBuilder builder=new RequestSpecBuilder()
		.setBaseUri("https://api.postman.com")
		.addHeader("x-api-key","PMAK-65695e66e6daac0b110283f6-66011405379bdfb029bda9d97cfdc869ab")
		.setContentType(ContentType.JSON)
		.log(LogDetail.ALL);
		
		RestAssured.requestSpecification = builder.build();
		
		ResponseSpecBuilder respbuilder=new ResponseSpecBuilder()
				.expectStatusCode(200)
				.expectContentType(ContentType.JSON)
				.expectResponseTime(lessThan(6000l), TimeUnit.MILLISECONDS)
				.log(LogDetail.ALL);
		
		RestAssured.responseSpecification=respbuilder.build();
		
		
	}
	
	@Test
	public void test() {
		LinkedHashMap<String, Object> mainObj=new LinkedHashMap<String, Object>();
		LinkedHashMap<String, String> subObj=new LinkedHashMap<String, String>();
		subObj.put("name", "myThirdWorkspace");
		subObj.put("type", "personal");
		subObj.put("description", "testing the app");
		mainObj.put("workspace", subObj);

		
		given()
		     .body(mainObj)
		.when()
		     .post("/workspaces")
		   
  
		.then()
		.log().all()
		;
	}

}
