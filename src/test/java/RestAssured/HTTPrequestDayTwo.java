package RestAssured;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import com.google.gson.JsonObject;

import POJO_PostRequest.POJO_PostRequest;
import io.restassured.http.Header;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

/* 
 * Different ways to create POST request body 
 1)Post request body using Hashmap
 2)Post request body creation using org.JSON
 3)Post request body creation using POJO class
 4)Post request body using External json file data
 * 
 * */

public class HTTPrequestDayTwo {

//	1)Post request body using Hashmap

	// int id;
//	@Test(priority = 0)
	@Test
	void testPostusingHashMap() {

		HashMap data = new HashMap();

		data.put("name", "morpheus");
		data.put("job", "leader");

		// We use multiple values
		// String courseArr[] = {"C","C++","Java"};
		// data.put("course", courseArr);

		given().contentType("application/json").body(data)

				.when().post("https://reqres.in/api/login")

				.then().statusCode(200).body("name", equalTo("morpheus")).body("job", equalTo("leader"))
				// .body("phone",equalTo(""))
				// .body("course[0]",equalTo("C"))
				// .body("course[1]",equalTo("C++"))
				// .header("content-Type","application/json; charset=utf-8")
				.log().all();
	}

	// deleting student records
//	@Test(priority = 1)
	@Test
	void testDelete() {

		given()

				.when().delete("https://reqres.in/api/login")

				.then()

				.statusCode(204).log().all();

	}

//	2)Post request body creation using org.JSON

//	@Test(priority = 1)
	@Test
	void testPostusingOrgJson() {

		JSONObject data = new JSONObject();
		
		data.put("name", "morpheus");
		data.put("job", "leader");

		

		given().contentType("application/json").body(data.toString()) // Not taratly pass data to pass a string 

				.when().post("https://reqres.in/api/users")

				.then().statusCode(201).body("name", equalTo("morpheus")).body("job", equalTo("leader"))
				// .body("phone",equalTo(""))
				// .body("course[0]",equalTo("C"))
				// .body("course[1]",equalTo("C++"))
				// .header("content-Type","application/json; charset=utf-8")
				.log().all();
	}

	// deleting student records
//	@Test(priority = 2)
	@Test
	void testJsonDelete() {

		given()

				.when().delete("https://reqres.in/api/users")

				.then()

				.statusCode(204).log().all();

	}
	
	// 3)Post request body creation using POJO class
	
	//@Test(priority = 1)
	@Test
	void testPostusingPOJOClass() {
 
		POJO_PostRequest data = new POJO_PostRequest();
		data.setName("morpheus");
		data.setJob("leader");
		/*
		 * String courseArr[]= {"C","C++","Java"}; data.setCourses(courseArr);
		 */
	
	

		

		given().contentType("application/json").body(data) // Not taratly pass data to pass a string 

				.when().post("https://reqres.in/api/users")

				.then().statusCode(201).body("name", equalTo("morpheus")).body("job", equalTo("leader"))
				// .body("phone",equalTo(""))
				// .body("course[0]",equalTo("C"))
				// .body("course[1]",equalTo("C++"))
				// .header("content-Type","application/json; charset=utf-8")
				.log().all();
	}

	// deleting student records
//	@Test(priority = 2)
	@Test
	void testPOJODelete() {

		given()

				.when().delete("https://reqres.in/api/users")

				.then()

				.statusCode(204).log().all();

	}
	
	// 4)Post request body using External json file data
	
	@Test(priority = 1)
	void testPostusingExternalJsonFile() throws FileNotFoundException {
 
	
		File f = new File(".//body.json");  // File we're referring the file 
		
		FileReader fr = new FileReader(f);  // get the file
		
		JSONTokener jt = new JSONTokener(fr);  //
		
		JSONObject data = new JSONObject(jt);

		

		given()
		.contentType("application/json").body(data.toString()) // Not taratly pass data to pass a string 

				.when().post("https://reqres.in/api/users")

				.then().statusCode(201).body("name", equalTo("morpheus")).body("job", equalTo("leader"))
				// .body("phone",equalTo(""))
				// .body("course[0]",equalTo("C"))
				// .body("course[1]",equalTo("C++"))
				// .header("content-Type","application/json; charset=utf-8")
				.log().all();
	}

	// deleting student records
	@Test(priority = 2)
	void testExternalJsonDelete() {

		given()

				.when().delete("https://reqres.in/api/users")

				.then()

				.statusCode(204).log().all();

	}
	
	
}
