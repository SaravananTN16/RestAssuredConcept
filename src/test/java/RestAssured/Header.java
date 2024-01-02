package RestAssured;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.http.Headers;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


public class Header {
	
	@Test(priority = 0)
		void headerDemo() {
			
			given()
			
			.when()
			.get("https://www.google.com/")
			
			.then()
			.header("Content-Type", "text/html; charset=ISO-8859-1")
			.header("Content-Encoding", "gzip")
			.header("Server", "gws")
			.log().headers(); // use headers method all header is get
		}
	
	/*@Test(priority = 0)
	void GetSingleheader() {
		
		Response res = given()
		
		.when()
		.get("https://www.google.com/");
		
		// get single header informations
		
		
		  String headerValues = res.getHeader("Content-Type");
		  System.out.println("This is Header values " + headerValues);
		 
		
		// get all header informations
		
		Headers headers = res.getHeaders();
		
		for(Header getHeaders : headers) {
			
			System.out.println(getHeaders.getName() + "  " +getHeaders.getValue());
			
		}*/
		
	

}
