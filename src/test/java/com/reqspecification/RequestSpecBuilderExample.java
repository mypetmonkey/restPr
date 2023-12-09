package com.reqspecification;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.hamcrest.MatcherAssert.assertThat;

import static org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.*;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RequestSpecBuilderExample {
	
	RequestSpecification req;
	
	@BeforeClass
	public void before() {
		
		RequestSpecBuilder  rsb=new RequestSpecBuilder();
		rsb.setBaseUri("https://api.postman.com");
		rsb.addHeader("x-api-key", "PMAK-65695e66e6daac0b110283f6-66011405379bdfb029bda9d97cfdc869ab");
		rsb.log(LogDetail.ALL); 
		
		   req = rsb.build();
		   
	}
	
	@Test
	public void test() {
		Response resp = given().spec(req)
				.header("dummyhd","dummyHeader")
				.get("/workspaces").then().log().all().extract().response();
		assertThat(resp.getStatusCode(),is(equalTo(200)));
		assertThat(resp.path("workspaces[0].name").toString(),equalTo("My Workspace"));
	
	}

}
