package com.CRUDoperationwithBDD;

import static org.hamcrest.Matchers.*;

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
public class PostMethodBDDANDNONBDD {
	
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
		
		String payload="{\r\n"
				+ "    \"workspace\": {\r\n"
				+ "        \"name\": \"PostWorkspace\",\r\n"
				+ "        \"type\": \"personal\",\r\n"
				+ "        \"description\": \"testing that can help\"\r\n"
				+ "        \r\n"
				+ "    }\r\n"
				+ "}";
		
	//BDD Style	
	/*given()
	.body(payload)
	.when()
	.post("/workspaces")
	
	.then()
	.assertThat()
	.body("workspace.name".toString(),equalTo("PostWorkspace"),
			"workspace.id",matchesPattern("^[a-z0-9-]{36}$"));*/
		
		//NONBDD Style
		
		Response resp = with()
		.body(payload)
		.post("/workspaces");
		assertThat(resp.<String>path("workspace.name"),equalTo("PostWorkspace"));
		assertThat(resp.<String>path("workspace.id"),matchesPattern("^[a-z0-9-]{36}$"));
		
		
        		
		
	}

}
