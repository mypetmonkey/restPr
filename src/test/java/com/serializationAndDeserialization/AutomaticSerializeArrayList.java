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

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

@SuppressWarnings("unused")
public class AutomaticSerializeArrayList {

	
	@BeforeClass
	public void before() {
		RequestSpecBuilder builder=new RequestSpecBuilder()
		.setBaseUri("https://905ae3ba-f50f-4584-a3ce-10c490d7d077.mock.pstmn.io")
		.addHeader("x-mock-match-request-body","true")
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
	
	@Test(enabled=false)
	public void test() throws JsonProcessingException {
		
		HashMap<String, String> obj51=new HashMap<String, String>();
		obj51.put("id","5001");
		obj51.put("type","None");
		
		HashMap<String, String> obj52=new HashMap<String, String>();
		obj52.put("id","5002");
		obj52.put("type","Glazed");
		
		List<Map<String,String>> jsonList=new ArrayList<Map<String,String>>();
		jsonList.add(obj51);
		jsonList.add(obj52);
		
		String omap=new ObjectMapper().writeValueAsString(jsonList);
		
		given()
		    .body(omap)
		.when()
		    .post("/post")
		.then()
		.log().all()
		;
		
	}
	
	
	@Test
	public void test2() throws JsonProcessingException {
		
		ObjectMapper omap=new ObjectMapper();
		ArrayNode anode = omap.createArrayNode();
		
		ObjectNode obj5001 = omap.createObjectNode();
		obj5001.put("id","5001");
		obj5001.put("type","None");
		
		ObjectNode obj5002 = omap.createObjectNode();
		obj5002.put("id","5002");
		obj5002.put("type","Glazed");
		
		anode.add(obj5001);
		anode.add(obj5002);
		
		String jsonList = omap.writeValueAsString(anode);
		
		given()
		    .body(jsonList)
		.when()
		    .post("/post")
		.then()
		.log().all()
		;
		
	}
}

