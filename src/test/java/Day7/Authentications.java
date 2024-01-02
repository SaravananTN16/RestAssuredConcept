package Day7;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

public class Authentications {
	
	//@Test(priority = 0)
	@Test
	void testbasicAuthentication() {
		
		given()
		.auth().basic("postman", "password")
		
		
		.when()
		.get("https://postman-echo.com/basic-auth")
		
		.then()
		.statusCode(200)
		.body("authenticated", equalTo(true))
		.log().all();
		
		
		
		
	}
	
	//@Test(priority = 1)
	@Test
	void testDigestAuthentications() {
		
		given()
		.auth().digest("postman", "password")
		
		
		.when()
		.get("https://postman-echo.com/basic-auth")
		
		.then()
		.statusCode(200)
		.body("authenticated", equalTo(true))
		.log().all();
	}
	
	

	//@Test(priority = 2)
       @Test
	void testPreeemptivecAuthentications() {
		
		given()
		.auth().preemptive().basic("postman", "password")
		
		.when()
		.get("https://postman-echo.com/basic-auth")
		
		.then()
		.statusCode(200)
		.body("authenticated", equalTo(true))
		.log().all();
	}
	
	//@Test(priority = 3)
	@Test
	void testBearerTokenAuthentications() {
		
		
		String bearerToken = "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";
		
		
		given()
		
		.headers("Authorization","Bearer "+bearerToken)
		
		
		.when()
		
		.get("https://api.github.com/user/repos")
		
		.then()
		.statusCode(200)
		.log().all();
		
		
	}
	
    //This oauth01 Authentications
//	@Test(priority = 3)
	@Test
	void testOAth01Authentications() {
		
	
		
		
		given()
		
		.auth().oauth("consumerKey","consumerSecrat","accesToken","tokenSecrate")

		.when()
		
		.get("")
		
		.then()
		.statusCode(200)
		.log().all();
		
	}
	
	 //This oauth01 Authentications
	//	@Test(priority = 3)
		@Test
		void testOAth02Authentications() {

			
			given()
			
			.auth().oauth2("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")
			
			

			.when()
			
			.get("https://api.github.com/user/repos")
			
			.then()
			.statusCode(200)
			.log().all();
			
		}
		
		@Test(priority = 1)
		void testAPIKeyAuthentications() {

		//	https://api.openweathermap.org/data/2.5/forecast/daily?q=Delhi&units=metric&cnt=7
			
			given()
			
			// queryparam you can pass key and keyValue
			.queryParam("appid", "fe9c5cddb7e01d747b4611c3fc9eaf2c")
			
			.pathParam("myPath", "data/2.5/forecast/daily")
			
			.queryParam("q", "Delhi")

			.queryParam("units", "metric")
			
			.queryParam("cnt", "7")
			
			.when()
			
			.get("https://api.openweathermap.org/{myPath)")
			
			.then()
			
			.statusCode(200)
			.log().all();
			
		}
		
		

}
