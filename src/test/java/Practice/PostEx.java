package Practice;

import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class PostEx {
	@Test
	public void test() {
		JSONObject j=new JSONObject();
		j.put("name", "morpheus");
		j.put("job", "leader");
		
		given()
		.body(j)
		.contentType(ContentType.JSON)
		
		. when()
		.post("https://reqres.in/api/users ")
		
		.then()
		.assertThat()
		.statusCode(201)
		.time(Matchers.lessThan(3000l),TimeUnit.MILLISECONDS)
		.body("name", Matchers.equalTo("morpheus"))
		//.body("id",Matchers.equalTo("705"))
		.statusLine("HTTP/1.1 201 Created")
		.log().all();
		
	}

}
