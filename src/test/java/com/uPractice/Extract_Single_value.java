package com.uPractice;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import static org.hamcrest.Matchers.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Extract_Single_value {
	
	@Test
	public void test() {
		baseURI="https://api.postman.com";
	String name=given()
		.header("x-api-key","PMAK-65695e66e6daac0b110283f6-66011405379bdfb029bda9d97cfdc869ab")
	.when()
		.get("/workspaces")
	.then()
	.log().ifError()
	.assertThat()
	.statusCode(200)
	.extract()
	//.response().asString();
	.response().path("workspaces[2].name");
	System.out.println("workspace name is "+name);
	Assert.assertEquals(name,"myfirst");
	//assertThat(name, equalTo("myfirst"));
	
	
	//System.out.println("workspace name is "+JsonPath.from(res).getString("workspaces[4].name"));
	//System.out.println("workspace name is "+res.path("workspaces[4].name"));
	//System.out.println("workspace name is "+res.jsonPath().getString("workspaces[4].name"));

		
	}

}
