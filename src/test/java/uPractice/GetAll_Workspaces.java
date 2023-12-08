package uPractice;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class GetAll_Workspaces {

	
	@Test
	public void test() {
		baseURI="https://api.postman.com";
		given()
		.header("x-api-key","PMAK-65695e66e6daac0b110283f6-66011405379bdfb029bda9d97cfdc869ab")
		.when()
		.get("/workspaces/")
		.then()
		.log().ifError()
		.assertThat()
		.statusCode(200)
		.log().all()
		;
		
	}
}
