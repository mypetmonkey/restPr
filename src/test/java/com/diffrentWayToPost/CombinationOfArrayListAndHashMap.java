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
public class CombinationOfArrayListAndHashMap {

	
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
		
		List<Integer> idNum=new  ArrayList<Integer>();
		idNum.add(5);
		idNum.add(9);
		
		HashMap<String ,Object> better2=new HashMap<String, Object>();
		better2.put("id",idNum);
		better2.put("type","Chocolate");
		
		HashMap<String ,Object> better1=new HashMap<String, Object>();
		better1.put("id","1001");
		better1.put("type","Regular");
		
		List<HashMap<String, Object>> batter=new ArrayList<HashMap<String,Object>>();
		batter.add(better1);
		batter.add(better2);
		
		Map<String, List<HashMap<String, Object>>> batters=new HashMap<>();
		batters.put("batter",batter);
		
		List<String> typeal=new ArrayList<String>();
		typeal.add("test1");
		typeal.add("test2");
		
		HashMap<String,Object> topping2=new  HashMap<>();
		topping2.put("id","5002");
		topping2.put("type",typeal);
		
		HashMap<String, Object> topping1=new HashMap<String, Object>();
		topping1.put("id","5001");
		topping1.put("type","None");
		
		List<HashMap<String, Object>> toppingal=new ArrayList<>();
		toppingal.add(topping1);
		toppingal.add(topping2);
		
		LinkedHashMap<String,Object> mainBody=new  LinkedHashMap<String, Object>();
		mainBody.put("id","0001");
		mainBody.put("type","donut");
		mainBody.put("name","Cake");
		mainBody.put("ppu",0.55);
		mainBody.put("batters",batters);
		mainBody.put("topping",toppingal);
		
		System.out.println(mainBody);
		
		
		
		given()
		.body(mainBody)
		
		.when()
		.post("/postComplexJson")
		
		.then().log().all();
				
		

		
		
		
	}
}
