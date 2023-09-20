package crudWithBDD;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class UpdateRepo {
	
	@Test
	public void updaterepo() {
		baseURI="https://api.github.com";
		HashMap<Object, Object> hm=new HashMap<Object, Object>();
		hm.put("name", "myrest");
		hm.put("description", "i am atest engineer");
		
		given()
		.auth().oauth2("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")
		.contentType(ContentType.JSON)
		.body(hm)
		
		.when()
		.patch("/repos/mypetmonkey/Myrestreo256")
		
		.then()
		.assertThat()
		.statusCode(200)
		.contentType(ContentType.JSON)
		.time(Matchers.lessThan(1900l),TimeUnit.MILLISECONDS)
		.log().all();
		
		
	}

}
