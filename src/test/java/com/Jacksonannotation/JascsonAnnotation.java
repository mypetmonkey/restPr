package com.Jacksonannotation;


import static org.hamcrest.Matchers.*;

import java.util.*;
import java.util.concurrent.TimeUnit;
import static org.hamcrest.MatcherAssert.assertThat;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.pojo.SimplePojo;
import com.pojo.Workspace;
import com.pojo.WorkspaceRoute;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class JascsonAnnotation {
	@BeforeClass
	public void before() {
		RequestSpecBuilder builder=new RequestSpecBuilder()
		.setBaseUri("https://api.postman.com")
		.addHeader("x-api-key","PMAK-65695e66e6daac0b110283f6-66011405379bdfb029bda9d97cfdc869ab")
		//.addHeader("x-mock-match-request-body","true")
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
		Workspace workspace=new Workspace("Pojoworkspace","personal"," pojo test");
		HashMap<String,String> hs=new HashMap<String, String>();
		workspace.setHs(hs);
		WorkspaceRoute wroute=new WorkspaceRoute(workspace);
		
		WorkspaceRoute deserializedws = given()
		.body(wroute)
		
		
		.when()
		.post("/workspaces")
		
		.then().spec(responseSpecification)
		.extract().response().as(WorkspaceRoute.class);
		
		assertThat(deserializedws.getWorkspace().getName(),equalTo(wroute.getWorkspace().getName()));
		
		assertThat(deserializedws.getWorkspace().getId(),matchesPattern("^[a-z0-9-]{36}$"));

	
		
		
		
		
	}


}

