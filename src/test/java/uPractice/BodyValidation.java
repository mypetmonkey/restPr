package uPractice;

import static org.hamcrest.Matchers.*;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class BodyValidation {
	
	@Test
	public void test() {
	Response resp = given()
	     .baseUri("https://api.postman.com")
	     .header("x-api-key","PMAK-65695e66e6daac0b110283f6-66011405379bdfb029bda9d97cfdc869ab")
		 .log().all()		
	.when()
	    .get("/workspaces");
		
		
	resp.then()
		.log().ifError()
		.assertThat()
		.statusCode(200)
		.time(lessThan(8000l),TimeUnit.MILLISECONDS)
		.body("workspaces.name",hasItems("My Workspace","Team Workspace","myfirst","Uworkspace")
				,"workspaces.type",hasItems("personal","team"),
				"workspaces.size()",equalTo(4),
				"workspaces[0].name",equalTo("My Workspace"),
				"workspaces[0].name",is(equalTo("My Workspace")),
				"workspaces.name",hasItem("myfirst")

				)
		
		
		.log().all();
	
	List<String> name=resp.jsonPath().get("workspaces.name");
	System.out.println(name);
	}

}
