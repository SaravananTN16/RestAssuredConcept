package Day4;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;
public class ParsingJSONResponseData {
	
	//aproach01
	// Without capturing Response
//	@Test
	@Test
	void testJSONResponse() {
		
		//aproach01
		
		given()
		.contentType("ContentType.JSON")
		
		.when()
		.get("https://dummyjson.com/carts")
		
		.then()
		.statusCode(200)
		.body("carts[8].products[0].title", equalTo("Leather Hand Bag"));
		
		
	}
	
	//aproach02
	// With capturing Response
	
//	@Test
	@Test
	void testJSONResponse2() {
		
		//aproach01
		
	     Response res = given()
		.contentType("ContentType.JSON")
		
		.when()
		.get("https://dummyjson.com/carts");
	
		AssertJUnit.assertEquals(res.getStatusCode(),200);  // Validations 1 
	//	Assert.assertEquals(res.header("Content-Type"),"application/json");
		String handBag = res.jsonPath().get("carts[8].products[0].title").toString();
		AssertJUnit.assertEquals(handBag, "Leather Hand Bag");
		
		
		
	}
	
	@Test
	void testJSONResponseBodyData() {
		
	
		
	     Response res = given()
		.contentType(ContentType.JSON)
		
		.when()
		.get("https://reqres.in/api/users?page=2");
	
			/*
			 * Assert.assertEquals(res.getStatusCode(),200); // Validations 1
			 * Assert.assertEquals(res.header("Content-Type"),"application/json"); String
			 * handBag = res.jsonPath().get("carts[8].products[0].title").toString();
			 * Assert.assertEquals(handBag, "Leather Hand Bag");
			 */
	     
	     // JsonObject Class
	     
	     JSONObject jo = new JSONObject(res.toString());  // converting response to json object type
	     
			/*
			 * for(int i=0;i<jo.getJSONArray("carts").length();i++) { String handBags =
			 * jo.getJSONArray("carts").getJSONObject(i).get("title").toString();
			 * System.out.println(handBags); }
			 */
	     
	     boolean status = false;
	     
	     for(int i=0;i<jo.getJSONArray("data").length();i++) 
	     {
	    	 String handBags = jo.getJSONArray("data").getJSONObject(i).get("email").toString();
	    	 
	    	 if(handBags.equals("michael.lawson@reqres.in")) {
	             
	    		 status =  true;
	    		 break;
	    	 }
	     }
		
		AssertJUnit.assertEquals(status, true);
	
	
	// validate total price of your product
	
	/*	double totalprice = 0;
		
	for(int i=0;i<jo.getJSONArray("data").length();i++) 
    {
   	 String price = jo.getJSONArray("carts").getJSONObject(i).get("title").toString();
   	 
   	 totalprice = totalprice+Double.parseDouble(price);
   	 
    }
	
	System.out.println("total price of books is: " + totalprice);
	
	}*/
}
}
