package Day6;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

//Pojo --- Serilize --> JSON Object -- de-serialize --- Pojo

public class SerializationAndDeSerializations {
	
	@Test(priority = 0)
	void serialization() throws JsonProcessingException {
		
		//Craete java object using POJO class
		POJO_Serializations pojoserialization = new POJO_Serializations();
		pojoserialization.setId(288042);
		pojoserialization.setName("id-4v2m26t");
		pojoserialization.setEmail("id-4v2m26t@gmail.com");
		pojoserialization.setLocation("Shanghai");
		
		//Convert java object -- > json object (serialization)
		
		ObjectMapper objMapper = new ObjectMapper();
		String jsondata = objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(objMapper);
		System.out.println(jsondata);
		
	}
	
	//Json -- POJO (de-serializations)
	
	@Test(priority = 1)
	void deSerialization() throws JsonMappingException, JsonProcessingException {
		
		String jsondata = "  {\n"
				+ "    \"id\": 288042,\n"
				+ "    \"name\": \"id-4v2m26t\",\n"
				+ "    \"email\": \"id-4v2m26t@gmail.com\",\n"
				+ "    \"location\": \"Shanghai\"\n"
				+ "  }";
		
		// Convert json data --> Pojo object
		
		ObjectMapper objectmapper = new ObjectMapper();
		
		POJO_Serializations readValue = objectmapper.readValue(jsondata,POJO_Serializations.class);  // convert json to pojo
		
		System.out.println("Name : " + readValue.getName());
		System.out.println("ID : " + readValue.getId());
		System.out.println("ID : " + readValue.getEmail());
		System.out.println("ID : " + readValue.getLocation());
		
	//	readValue.getCourse()[0];  This is like mulitple vaues get
		
		
	}
	
	
	

}
