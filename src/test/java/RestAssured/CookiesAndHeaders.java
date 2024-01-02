package RestAssured;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class CookiesAndHeaders {
	
	//@Test(priority = 0)
	void cookiesDemo() {
		
		given()
		
		.when()
		.get("https://www.google.com/")
		
		.then()
		.cookie("AEC","Ackid1QOb_TWRa3t13RoESvZaf_1tH2kAHdyn96lxPoGAOk7oUi8wt_qXKk")
		.log().all();
	}
	
	@Test(priority = 1)
	void getcookiesInfo() {
		
		Response res = given()
		
		.when()
		.get("https://www.google.com/"); // entire respones go to res variables
		
	     //  get single cookie informations
		 //  String cookie_values = res.getCookie("AEC");
		 //  System.out.println("The value of Cookies is " + cookie_values);
		
		// get all cookies informations
		
		Map<String, String> cookies_Values = res.getCookies();
		
		// System.out.println(cookies_Values.keySet()); // cookies name only display by using keySet() 
		
		for(String key : cookies_Values.keySet()) {
			
			String cookie = res.getCookie(key);
			
			System.out.println(key + "      " + cookie);
			
		}
		
	}
	
	

}
