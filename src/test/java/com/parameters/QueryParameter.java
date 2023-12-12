package com.parameters;

import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

@SuppressWarnings("unused")
public class QueryParameter {
	
	@Test
	public void test() {
		
		HashMap<String,String> param=new HashMap<String, String>();
		param.put("bar1", "foo1");
		param.put("bar2", "foo2");
		param.put("bar3", "foo3");

		
	given()
		.baseUri("https://postman-echo.com")
//		.queryParam("foo1", "bar1")
//		.queryParam("foo2", "bar2")
//		.param("raj", "hans")
		
		.queryParams(param)
		.log().all()
		
	.when()
		.get("/get")
	.then()
	
		.log().all()
		.statusCode(200)
		.assertThat();
		;
		
	}
	
	@Test
	public void  multiValueParameters_test() {
		
		HashMap<String,String> param=new HashMap<String, String>();
		param.put("bar1", "foo1");
		param.put("bar2", "foo2");
		param.put("bar3", "foo3;foo4;foo5");

		
	given()
		.baseUri("https://postman-echo.com")
//		.queryParam("foo1", "bar1")
//		.queryParam("foo2", "bar2")
//		.param("raj", "hans")
		
		.queryParams(param)
		.log().all()
		
	.when()
		.get("/get")
	.then()
	
		.log().all()
		.statusCode(200)
		.assertThat();
		;
		
	}

}
