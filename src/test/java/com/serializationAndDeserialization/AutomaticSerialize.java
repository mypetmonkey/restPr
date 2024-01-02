package com.serializationAndDeserialization;

import static org.hamcrest.Matchers.*;

import java.util.*;
import java.util.concurrent.TimeUnit;
import static org.hamcrest.MatcherAssert.assertThat;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;


@SuppressWarnings("unused")
public class AutomaticSerialize {
	
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
	public void test() throws JsonProcessingException {
		LinkedHashMap<String, Object> mainObj=new LinkedHashMap<String, Object>();
		LinkedHashMap<String, String> subObj=new LinkedHashMap<String, String>();
		subObj.put("name", "myThirdWorkspaceSeriAutomatic");
		subObj.put("type", "personal");
		subObj.put("description", "testing the app");
		mainObj.put("workspace", subObj);
		
    ObjectMapper omap=new ObjectMapper();
   String body = omap.writeValueAsString(mainObj);
    
		
		given()
		     .body(body)
		.when()
		     .post("/workspaces")
		   
  
		.then()
		.log().all()
		;
	}

}