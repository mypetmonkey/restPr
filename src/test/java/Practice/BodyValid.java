package Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.List;

public class BodyValid {
	
	@Test
	public void test() {
		int exp=705;
		
		Response resp = given()
		.get("https://reqres.in/api/users");
		boolean flag=true;
		
		List<Integer> ids = resp.jsonPath().get("data.id");
		for(Integer temp:ids) {
			if(temp==exp)
				flag=true;
			
		}
		Assert.assertTrue(flag);
		System.out.println("verified that id is available");
		resp.then()
		.log()
		.ifError()
		.log().all();
		
		
		 
	}

}
