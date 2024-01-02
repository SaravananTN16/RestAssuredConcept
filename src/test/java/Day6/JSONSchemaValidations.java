package Day6;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.module.jsv.JsonSchemaValidator;

//Response - validations is a data validations
//Schema – validations is a type of data validations

public class JSONSchemaValidations {
	
	
	@Test
	void jsonSchemaValidations()
	{

		//JsonSchema validator
		//http://restapi.adequateshop.com/api/Customer
		
		given()
		
		.when()
		.get("http://restapi.adequateshop.com/api/Customer")
		
		.then()
		.assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("JsonSchemaValidations.json"));
	}
	
	
	

}
