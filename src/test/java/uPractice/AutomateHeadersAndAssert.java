package uPractice;

import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;

import static io.restassured.RestAssured.*;

@SuppressWarnings("unused")
public class AutomateHeadersAndAssert{
	
	@Test
	public void test() {
		baseURI="https://905ae3ba-f50f-4584-a3ce-10c490d7d077.mock.pstmn.io";
		//Header h=new Header("header","value2");
		//Header h2=new Header("x-mock-match-request-headers", "header");
      //Headers headers=new Headers(h,h2)	;	
		
		Map<String,String> headers=new HashMap<String, String>();
		headers.put("header","value1");
		headers.put("x-mock-match-request-headers", "header");
		
		
		given()
		//.header("header","value2")
		//.header("x-mock-match-request-headers", "header")
		
		//.header(h)
		//.header(h2)
		
		.headers(headers)
		
		//.header("multiValueHeader","value1","value2")
		.log().all()
		
		.when()
		.get("/get")
		
		.then()
		.log().all()
		.assertThat()
		.header("respHeader","resValue1")
		.headers("Connection","keep-alive",
				"respHeader","resValue1",
				"Vary","Accept-Encoding")
		
		.statusCode(200);
	}

}
