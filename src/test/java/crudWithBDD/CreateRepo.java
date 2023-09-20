package crudWithBDD;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateRepo {
	public static int random() {
		Random ran=new Random();
		int random=ran.nextInt(1000);
		return random;
	}
	
	@Test
	public void createRepo() {
		baseURI="https://api.github.com";
		JSONObject j=new JSONObject();
		j.put("name", "Myrestreo"+CreateRepo.random());
		j.put("description","my name is rajhans");
		
		given()
		.auth().oauth2("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")
		.body(j)
		.contentType(ContentType.JSON)
       
		.when()
		.post("/user/repos")
		
		.then()
		.assertThat()
		.contentType(ContentType.JSON)
		.statusCode(201)
		.statusLine("HTTP/1.1 201 Created")
		.time(Matchers.lessThan(4000l),TimeUnit.MILLISECONDS)
		.log().all();
		
		
		
	}

}
