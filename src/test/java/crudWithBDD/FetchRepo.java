package crudWithBDD;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class FetchRepo {
	
	@Test
	public void fetchRepo() {
		baseURI="https://api.github.com";
		given()
		.auth().oauth2("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")
		
		.when()
		.get("/repos/mypetmonkey/Myrestreo256")
		
		.then()
		.assertThat()
		.statusCode(200)
		 
		.contentType(ContentType.JSON)
		.time(Matchers.lessThan(1800l),TimeUnit.MILLISECONDS)
		
		.log().all();
	
	}

}
