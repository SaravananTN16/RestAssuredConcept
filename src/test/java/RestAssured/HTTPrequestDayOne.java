package RestAssured;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

public class HTTPrequestDayOne {

	int id;

	@Test(priority = 1)
	public void getUser() {

		given()

				.when()

				.get("https://reqres.in/api/users?page=2")

				.then()

				.statusCode(200).body("page", equalTo(2)).log().all();

	}

	@Test(priority = 2)
	void createUser() {

		HashMap<String, String> data = new HashMap<String, String>();
		data.put("name", "pavan");
		data.put("job", "trainer");

		id = given().contentType("application/json").body(data)

				.when().post("https://reqres.in/api/users").jsonPath().getInt("id"); // Getting particulare values

		
		
		/*
		 * .then() .statusCode(201) .log().all();
		 */

	}

	@Test(priority = 3, dependsOnMethods = { "createUser" })
	void updateUser() {

		HashMap data = new HashMap();
		data.put("name", "Saravanan");
		data.put("job", "Teacher");

		given().contentType("application/json").body(data)

				.when().put("https://reqres.in/api/users/" +id)

				.then().statusCode(200).log().all();

	}

	@Test(priority = 4)
	void deleteUser() {

		when().delete("https://reqres.in/api/users/" + id)

				.then().statusCode(204).log().all();

	}

}
