package Day5;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Iterator;
import java.util.List;

public class ParsingXMLResponse {
	
	//http://restapi.adequateshop.com/api/Traveler
	//http://restapi.adequateshop.com/api/Traveler?page=1
	
	//@Test
	void textXMLResponse() {
		
		//approach 01
		
		given()
		
		.when()
		.get("http://restapi.adequateshop.com/api/Traveler?page=1")
	
		
		.then()
		.statusCode(200)
	//	.header("Content-Type","application/xml")
		.body("TravelerinformationResponse.page", equalTo("1"))
		.body("TravelerinformationResponse.travelers.Travelerinformation[0].name", equalTo("Developer"));
	}

//	@Test
	void Approach01() {
		
	Response res = given()
		
		.when()
		.get("http://restapi.adequateshop.com/api/Traveler?page=1");
		AssertJUnit.assertEquals(res.getStatusCode(), 200);
		AssertJUnit.assertEquals(res.header("Content-Type"),"application/xml; charset=utf-8");
		String pageNo = res.xmlPath().get("TravelerinformationResponse.page").toString();
		AssertJUnit.assertEquals(pageNo, "1");
		
		String tavelarName = res.xmlPath().get("TravelerinformationResponse.travelers.Travelerinformation[0].name");
		AssertJUnit.assertEquals(tavelarName, "Developer");
		
	}
	
	@Test
	void xmlValidations() {
		
	Response res = given()
		
		.when()
		.get("http://restapi.adequateshop.com/api/Traveler?page=1");
	
	// if you want to convert data only in string format we use toString() method 
    // if you want to convert entire response change to string format we use asString() method 
	
	XmlPath xmlobj = new XmlPath(res.asString());  	
	List<String> traveller = xmlobj.getList("TravelerinformationResponse.travelers.Travelerinformation");
	AssertJUnit.assertEquals(traveller.size(), 10);
	
	//Verify traveler name is present in response
	
	List<String> traveller_name = xmlobj.getList("TravelerinformationResponse.travelers.Travelerinformation.name");
	
	boolean status = false;
			
    for(String travellerName : traveller_name) {
	
	// System.out.println(travellerName);  // get all Name
    	
    	if(travellerName.equals("Developer")) {
    		
    		status = true;
    		break;
    	}
	
}
	
    AssertJUnit.assertEquals(status, true);
	
	
		
	}
}
