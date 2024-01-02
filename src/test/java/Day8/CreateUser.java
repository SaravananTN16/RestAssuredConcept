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

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.google.gson.JsonObject;

public class CreateUser {
	
	
	@Test
	void test_CreateUser(ITestContext context) {
		
		Faker faker = new Faker();
		
		JSONObject data = new JSONObject();
		
		data.put("name", faker.name().fullName());
		data.put("gender", "Male");
		data.put("email", faker.internet().emailAddress());
		data.put("status", "inactive");
		
		String bearerToken = "ce0d90b530b4a7dc9705df8ec04d5d2c46986f18358763af68dbccbab33a9e1c";
		
		//https:gorest.co.in/public/v2/users
     	int id = given()
		.header("Authorization","Bearer "+bearerToken)
		.contentType("application/json")
		.body(data.toString())
	
		.when() 
		.post("https://gorest.co.in/public/v2/users")
		.jsonPath().getInt("id");
	
	     System.out.println("Generate Id " + id);
		
	context.setAttribute("user_id", id);  // This test level executions
	// context.getSuite().setAttribute("user_id", id); // This suite level executions
	
	}

}
