package uPractice;

import static io.restassured.RestAssured.*;

import static org.hamcrest.Matchers.*;

import java.util.Collections;

import org.testng.annotations.Test;

import io.restassured.config.LogConfig;

public class Valiadte_response_body_hamcrest {

	

	@Test
	public void test() {
		baseURI="https://api.postman.com";
		
		given()
		.header("x-api-key","PMAK-65695e66e6daac0b110283f6-66011405379bdfb029bda9d97cfdc869ab")
		//.log().all()
		//.log().ifValidationFails()
		.config(config.logConfig(LogConfig.logConfig().enableLoggingOfRequestAndResponseIfValidationFails()))
		
		
		.when()
		.get("/workspaces/")
		
		
		.then()
		//.log().ifValidationFails()
		.assertThat()
		.statusCode(200)
		//Check All element in strict order
		.body("workspaces.name",contains("My Workspace","Team Workspace","myfirst","Uworkspace"))
		//check all element in any order
		.body("workspaces.name",containsInAnyOrder("Team Workspace","My Workspace","myfirst","Uworkspace"))
       // check if it is empty
		// .body("workspaces.name",empty())
		
		 // check if it is not empty
		.body("workspaces.name", is(not(empty())))
		 // check if it is not empty array
		.body("workspaces.name", is(not(emptyArray())))
		//check size
		.body("workspaces.name",hasSize(4))
		//check the given suffix
		//.body("workspaces.name",everyItem(startsWith("my")))
		
		//check if map has specified key
		.body("workspaces[0]",hasKey("name"))
		//check if map has specified value
		.body("workspaces[0]",hasValue("My Workspace"))
		//check if map has specified entry
		.body("workspaces[0]",hasEntry("type", "personal"))
		//check if empty
		//.body("workspaces[0]",equalTo(Collections.EMPTY_MAP))
		//check if not empty
		.body("workspaces[0]",not(equalTo(Collections.EMPTY_MAP)))
		//matches if all matchers matches
		.body("workspaces[0].name",allOf(startsWith("My"),containsString("Workspace")))
		//matches if any matchers matches
		


		//.log().all()
		
		;
		
	}
}
