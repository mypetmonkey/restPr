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
		.delete("/workspaces/a5b64ed2-fe30-4dcf-89a9-b768d5cc5420")
		
		.then()
		.log().ifError()
		.assertThat()
		.statusCode(200)
		.log().all()
		;
		
	}

}
