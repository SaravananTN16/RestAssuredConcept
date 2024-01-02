package Day8;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.security.cert.CertPathParameters;

import org.testng.ITestContext;
import org.testng.annotations.Test;

public class GetUser {
	
	@Test
	void test_GetUser(ITestContext context) {
		
		int id = (Integer) context.getAttribute("user_id"); //This should come from create user request
		
		String bearerToken = "ce0d90b530b4a7dc9705df8ec04d5d2c46986f18358763af68dbccbab33a9e1c";
		
		given() 
		.header("Authorization" , "Bearer "+bearerToken)
		.pathParam("id", id)
		
		.when()
		.get("https://gorest.co.in/public/v2/users/{id}")
		
		.then()
		.statusCode(200)
		.log().all();
		
	}

}
