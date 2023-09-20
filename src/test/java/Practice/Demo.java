package Practice;

import org.hamcrest.Matchers;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import static io.restassured.module.jsv.JsonSchemaValidator.*;



public class Demo {
	@Test
	public void test()
	
//	
	{
		
		JSONObject j=new JSONObject();
		j.put("tourist_name","Tourist123");
		j.put("tourist_email", "raju"+Demo.random()+"@gmail.com");
		j.put("tourist_location", "Mumbai");
		
   Response resp = given()
		.body(j)
		.contentType(ContentType.JSON)
		.post("http://restapi.adequateshop.com/api/Tourist");
   
   int bid=resp.jsonPath().get("id");
   System.out.println(bid);
		
	
		resp. then()
		.assertThat()
		.body(matchesJsonSchemaInClasspath("jsonschema.txt"))
		.statusCode(201)
		.time(Matchers.lessThan(6000l),TimeUnit.MILLISECONDS)
		.log().all();
		
		
		given()
		.pathParam("bnkid", bid)
		
		.when()
		.get("http://restapi.adequateshop.com/api/Tourist/{bnkid}")
		
		.then()
		.assertThat()
	    .body(matchesJsonSchemaInClasspath("jsonschema.txt"))
		.log().all();
	 
		
}
	
	
	public static int random() {
		Random ran=new Random();
		int random=ran.nextInt();
		return random;
	}
	
	
	
	
	
	
	
	
	
	
	
}
