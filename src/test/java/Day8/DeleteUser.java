package Day8;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

import org.testng.ITestContext;
public class DeleteUser {
	
	@Test
	void test_DeleteUser(ITestContext context) {
		
		String bearerToken = "ce0d90b530b4a7dc9705df8ec04d5d2c46986f18358763af68dbccbab33a9e1c";
		
		//https:gorest.co.in/public/v2/users
		int id = (Integer) context.getAttribute("user_id"); 
		
		 given()
		
		.header("Authorization","Bearer "+bearerToken)
		.pathParam("id", id)
		
		.when()
		.delete("https://gorest.co.in/public/v2/users/{id}")
		
		.then()
		.statusCode(204)
		.log().all();
		
	}

}
