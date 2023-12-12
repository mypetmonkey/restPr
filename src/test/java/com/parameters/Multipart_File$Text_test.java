package com.parameters;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;

import java.io.File;
import java.util.HashMap;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

@SuppressWarnings("unused")
public class Multipart_File$Text_test{

		
		@Test
		public void test_form() {
		given()
			.baseUri("https://postman-echo.com")
			.multiPart("foo1", "bar1")
			.multiPart("foo2", "bar2")

			.log().all()
			
		.when()
			.post("/post")
			
		.then()
		.assertThat()
		.statusCode(200)
			.log().all() 
			;
		}
		
		
		@Test
		public void test_file() {
			File f=new File("C:\\Users\\LENOVO\\git\\restPr\\src\\test\\resources\\git.txt");
		given()
			.baseUri("https://postman-echo.com")
			.multiPart("file", f)
			.multiPart("attribute", "{\"name\":\"txtfile\", \"id\":1234}","application/json")

			.log().all()
			
		.when()
			.post("/post")
			
		.then()
		.assertThat()
		.statusCode(200)
			.log().all() 
			;
		}
		
		
			
}
