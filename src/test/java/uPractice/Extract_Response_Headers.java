package uPractice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;

@SuppressWarnings("unused")
public class Extract_Response_Headers {
	
	@Test
	public void test() {
		Map<String,String> headers=new HashMap<String, String>();
		headers.put("header","value1");
		headers.put("x-mock-match-request-headers", "header");
		
		Headers extheaders = given()
		.baseUri("https://905ae3ba-f50f-4584-a3ce-10c490d7d077.mock.pstmn.io")
		.headers(headers)
		
		.when()
		.get("/get")
		
		
		.then()
		.log().all()
		.assertThat()
		.statusCode(200)
		.extract()
		.headers();
		
		System.out.println("header name :"+extheaders.get("respHeader").getName());
		System.out.println("header value :"+extheaders.get("respHeader").getValue());
		
		for(Header h:extheaders)
		{
			System.out.print("header name-->"+h.getName());
			System.out.println("header value--> "+h.getValue());
		}
		
		
		
		List<String> l=extheaders.getValues("multiValueHeader");
		System.out.println(l);

		
		
	}

}
