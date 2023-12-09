package com.uPractice;

import org.testng.annotations.Test;


import static io.restassured.RestAssured.*;

public class Delete_workspace {
	
	@Test
	public void test() {
		baseURI="https://api.postman.com";
		given()
		.header("x-api-key","PMAK-65695e66e6daac0b110283f6-66011405379bdfb029bda9d97cfdc869ab")
		
		.when()
		.delete("/workspaces/ff36d98f-1b72-4145-8007-ac7c8cd9d5b4")
		
		.then()
		.log().ifError()
		.assertThat()
		.statusCode(200)
		.log().all()
		;
		
	}

}
