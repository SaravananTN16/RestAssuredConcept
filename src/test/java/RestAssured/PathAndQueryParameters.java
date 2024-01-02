package RestAssured;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class PathAndQueryParameters {
	
	//https://reqres.in/api/users?page=2&id=5
	
	@Test
	void testQueryParameters() {
		
		
		given()
		.pathParam("myPath", "users") // path parameters just like a variable
		.queryParam("page", 2)  //Query Parameters Not variable
		.queryParam("id", 5)  //Query Parameters  Not variable
		
		.when()
		.get("https://reqres.in/api/{myPath}")
		
		.then()
		.statusCode(200)
		.log().all();
		
	}

}
