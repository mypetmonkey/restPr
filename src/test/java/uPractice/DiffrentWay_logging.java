package uPractice;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.config;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsInAnyOrder;
import org.testng.annotations.Test;

import io.restassured.config.LogConfig;

public class DiffrentWay_logging {

	
	@Test
	public void test() {
		baseURI="https://api.postman.com";
		given()
		.header("x-api-key","PMAK-65695e66e6daac0b110283f6-66011405379bdfb029bda9d97cfdc869ab")
		//.log().all()
		//.log().ifValidationFails()
		.config(config.logConfig(LogConfig.logConfig().blacklistHeader("x-api-key")))

		//.config(config.logConfig(LogConfig.logConfig().enableLoggingOfRequestAndResponseIfValidationFails()))
         .log().all()
		.when()
		.get("/workspaces/")
		.then()
		//.log().ifError()
		//.log().ifValidationFails()
		.assertThat()
		.statusCode(200)
		.body("workspaces.name",contains("My Workspace","Team Workspace","myfirst","Uworkspace"))
		.body("workspaces.name",containsInAnyOrder("Team Workspace","My Workspace","myfirst","Uworkspace"))
		.log().all()
		
		;
		
	}
}
