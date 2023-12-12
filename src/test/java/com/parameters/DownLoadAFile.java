package com.parameters;


import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

@SuppressWarnings("unused")
public class DownLoadAFile {
	
	@Test(enabled=false)
	public void test_form() throws IOException {
	byte[] fileD=given()
		.baseUri("https://raw.githubusercontent.com")
		.log().all()
		
	.when()
		.post("/appium/appium/master/packages/appium/sample-code/apps/ApiDemos-debug.apk")
		
	.then()
		//.log().all()
		.extract().response().asByteArray()
		;
	
	  System.out.println("file apk size is  "+fileD.length);
	
	FileOutputStream fos=new FileOutputStream(new File("api demos.apk"));
	fos.write(fileD);
	fos.close();
	
	}
	
	
	
	@Test(enabled=true)
	public void test_form2() throws IOException {
	 InputStream  is = given()
		.baseUri("https://raw.githubusercontent.com")
		.log().all()
		
	.when()
		.get("/appium/appium/master/packages/appium/sample-code/apps/ApiDemos-debug.apk")
		
	.then()
		.log().all()
		.extract().response().asInputStream()
		;
	
	 // System.out.println("file apk size is  "+is.);
	
	FileOutputStream fos=new FileOutputStream(new File("api demos2.apk"));
	byte[] b=new byte[is.available()];
	is.read(b);
	fos.write(b);
	fos.close();
	
	}

}
