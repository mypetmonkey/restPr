
package com.parameters;

import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;

import java.util.HashMap;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

@SuppressWarnings("unused")
public class PathParamater {
	
	@Test
	public void test() {
	given()
		.baseUri("https://reqres.in")
		.pathParam("pid", 2)
		.log().all()
		
	.when()
		.get("/api/users/{pid}")
		
	.then()
	.assertThat()
	.statusCode(200)
		.log().all() 
		;
		
	}

}
