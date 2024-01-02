package com.postman.collection;

import static org.hamcrest.Matchers.*;

import java.util.*;
import java.util.concurrent.TimeUnit;
import static org.hamcrest.MatcherAssert.assertThat;

import org.json.JSONException;
import org.skyscreamer.jsonassert.Customization;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.skyscreamer.jsonassert.ValueMatcher;
import org.skyscreamer.jsonassert.comparator.CustomComparator;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.pojo.SimplePojo;
import com.pojo.collection.Collection;
import com.pojo.collection.CollectionRoot;
import com.pojo.collection.Info;
import com.pojo.collection.Item;
import com.pojo.collection.Request;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

@SuppressWarnings("unused")


public class CreateCollection {
	@BeforeClass
	public void before() { 
		RequestSpecBuilder builder=new RequestSpecBuilder()
		.setBaseUri("https://api.getpostman.com")
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
	public void test() throws JsonProcessingException, JSONException {
		Request request=new Request("get","get testing action");
		Info info=new Info("Samplecollectionpojo","https://schema.getpostman.com/json/collection/v2.1.0/collection.json");
        Item i=new Item(request);
		
		List<Item> req=new ArrayList<Item>();
         req.add(i);
	
		
		
		
		Collection allCollection=new Collection(info,req);
		
		CollectionRoot root=new CollectionRoot(allCollection);
		
	 String cuid = given()
		.body(root)
		
	.when()
		.post("/collections")
		
	.then().spec(responseSpecification).log().ifError()
		 .extract().response()
		 .path("collection.uid")
		 
		;
		

	
	CollectionRoot	croot=given()
		.pathParam("uid", cuid)

	.when()
		.get("/collections/{uid}")
	
	.then().spec(responseSpecification)
		.extract().response()
		.as(CollectionRoot.class)
		;
	
	ObjectMapper omap=new ObjectMapper();
	 String crootstr = omap.writeValueAsString(root);
	 String Deserializedroot = omap.writeValueAsString(croot);
	 
	 JSONAssert.assertEquals(crootstr, Deserializedroot, new CustomComparator(JSONCompareMode.LENIENT,
			 new Customization("collection.item[*].item[*].request.url",new ValueMatcher<Object>() {
				
				@Override
				public boolean equal(Object o1, Object o2) {
					// TODO Auto-generated method stub
					return true;
				}
			})));
	 
	 
	}


}

