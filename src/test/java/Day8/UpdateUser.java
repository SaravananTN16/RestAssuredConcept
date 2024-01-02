package Day8;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class UpdateUser {
	
	@Test
	void test_UpdateUser(ITestContext context) {
		
			Faker faker = new Faker();
			
			JSONObject data = new JSONObject();
			
			data.put("name", faker.name().fullName());
			data.put("gender", "FeMale");
			data.put("email", faker.internet().emailAddress());
			data.put("status", "active");
			
			String bearerToken = "ce0d90b530b4a7dc9705df8ec04d5d2c46986f18358763af68dbccbab33a9e1c";
			
			//https:gorest.co.in/public/v2/users
			int id = (Integer) context.getAttribute("user_id"); 
			
		   given()
			.header("Authorization","Bearer "+bearerToken)
			.contentType("application/json")
			.body(data.toString())
			.pathParam("id", id)
			
		
			.when() 
			.put("https://gorest.co.in/public/v2/users/{id}")
			
			.then()
			.statusCode(200)
			.log().all();
			
		
		
		
		
	}

}
