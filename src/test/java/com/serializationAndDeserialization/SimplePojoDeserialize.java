package com.serializationAndDeserialization;

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

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;


@SuppressWarnings("unused")
public class SimplePojoDeserialize {

	@BeforeClass
	public void before() {
		RequestSpecBuilder builder=new RequestSpecBuilder()
		.setBaseUri("https://905ae3ba-f50f-4584-a3ce-10c490d7d077.mock.pstmn.io")
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
	public void test() throws JsonProcessingException {
		SimplePojo pojo=new  SimplePojo("value1","value2");
//		SimplePojo pojo=new SimplePojo();
//		pojo.setKey1("value1");
//		pojo.setKey2("value2");
		
		
		SimplePojo deserPojo = given()
		.body(pojo)
		.when()
		.post("/simplePojo")
		
		.then().spec(responseSpecification)
		.extract().response().as(SimplePojo.class);
		
		
		ObjectMapper omap=new ObjectMapper();
		String deserPojoStr=omap.writeValueAsString(deserPojo);
		String simplePojoStr=omap.writeValueAsString(pojo);
		assertThat(omap.readTree(deserPojoStr),equalTo(omap.readTree(simplePojoStr)));
		
		
		
		
	}
}
