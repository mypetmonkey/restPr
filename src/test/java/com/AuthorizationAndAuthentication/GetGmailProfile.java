package com.AuthorizationAndAuthentication;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class GetGmailProfile {
	
	RequestSpecification reqspec;
	ResponseSpecification respspec;
	String access_token="ya29.a0AfB_byA9w99GgnGK33ME9DmwbucGm31PpvsrtDFYbzln_v_cfNLKO3swRf0wcF0A7FH3M0XcdF7hU9DoaCWb5PsHXOAVQws7V7rOKTvl8WgeCVCrexf20tkmCohKIO3q6yV0x0H933rANF_hYc9XeGV0_EP6B85po4MzHQaCgYKAbsSARISFQHGX2MiAYo3q6Yf3THos0DujP4XbQ0173";
	
	@BeforeClass
	public void configure() {
		RequestSpecBuilder reqBuilder=new RequestSpecBuilder()
				.setBaseUri("https://gmail.googleapis.com")
				.addHeader("Authorization","Bearer "+access_token)
				.setContentType(ContentType.JSON)
				.log(LogDetail.ALL);
		reqspec=reqBuilder.build();
		
		
		ResponseSpecBuilder respbuilder=new ResponseSpecBuilder()
				.expectStatusCode(200)
				.expectContentType(ContentType.JSON)
				.log(LogDetail.ALL);
		respspec=respbuilder.build();
				
	}

	@Test
	public void test() {
		given(reqspec)
		.basePath("/gmail/v1")
		.pathParam("userId","rajhansmehtaa@gmail.com")
		
		.when()
		.get("/users/{userId}/profile")		
		
		.then().spec(respspec);
		
		
	}
}
