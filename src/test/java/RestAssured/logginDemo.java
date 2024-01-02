package RestAssured;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


public class logginDemo {
	
	@Test
	void testLogs() {
		
		
		given()
		
		.when()
		.get("https://reqres.in/api/users?page=2")
		
		.then()
		.log().headers();       //.log().all();  it's used to all response display in console like body,header,cookies etc..	
		                        // .log().body(); it's only print body 
		                        // .log().cookies() this only print cookies in response
		                        // .log().headers() this only print header in response
	}

}
