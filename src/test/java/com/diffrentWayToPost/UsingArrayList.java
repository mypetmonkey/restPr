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

public class UsingArrayList {

	
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
	
	@Test
	public void test() {
		
		HashMap<String, String> obj51=new HashMap<String, String>();
		obj51.put("id","5001");
		obj51.put("type","None");
		
		HashMap<String, String> obj52=new HashMap<String, String>();
		obj52.put("id","5002");
		obj52.put("type","Glazed");
		
		List<Map<String,String>> jsonList=new ArrayList<Map<String,String>>();
		jsonList.add(obj51);
		jsonList.add(obj52);
		
		given()
		    .body(jsonList)
		.when()
		    .post("/post")
		.then()
		.log().all()
		;
		
	}
	
}
