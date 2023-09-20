package crudWithBDD;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class Deleterepo {
	
	@Test
	public void deleteRepo() {
		baseURI="https://api.github.com";
		
	given()
	.auth().oauth2("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")
	
	.when()
	.delete("/repos/mypetmonkey/myrest")
	
	.then()
	.assertThat()
	// .statusCode(204)
	.log().all();
	}

}
