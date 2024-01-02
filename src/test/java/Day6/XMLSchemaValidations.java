package Day6;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import io.restassured.matcher.RestAssuredMatchers;

public class XMLSchemaValidations {
	
	
	void xmlValidations() {
		
		given()
		
		.when()
		.get("")
		
		.then()
		
		.assertThat().body(RestAssuredMatchers.matchesXsdInClasspath("XMLSchemaValidations.xsd"));
	}
	
	

}
