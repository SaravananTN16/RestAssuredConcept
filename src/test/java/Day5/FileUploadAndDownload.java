package Day5;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;

public class FileUploadAndDownload {
	
	void singleFileUpload() {
		
		
		File file = new File("/home/saravanans/FilesUpload/FileUpload.txt");
	
		given()
		.multiPart("file",file)
		.contentType("mulipart/form-data")
	
		.when()
		
		.post("http://localhost:8080/uploadFile")
		
		.then()
		.statusCode(200)
		.body("fileName", equalTo("uploadFile.txt"))
		.log().all();
		
	}
	
void mulitpleFileUpload() {
		
		
		File file1 = new File("/home/saravanans/FilesUpload/FileUpload.txt");
		File file2 = new File("/home/saravanans/FilesUpload/FileUpload.txt");
		
		//File filearr[] = {file1,file2}; This is when you use mulitple files
	
		given()
		//.multiPart("files",file1)
		//.contentType("mulipart/form-data")
		
		.multiPart("files",file1)
		.multiPart("files",file2)
		.contentType("mulipart/form-data")
	
		.when()
		
		.post("http://localhost:8080/uploadFile")
		
		.then()
		.statusCode(200)
		.body("[0].fileName", equalTo("uploadFile.txt"))
		.body("[1].fileName", equalTo("uploadFile.txt"))
		.log().all();
		
	}
//File download
      void fileDownload() {
	
    	  given() 
    	  
    	  .when()
    	  
    	  .get("http://localhost:8080/downloadFile/test1.txt")
    	  
    	  .then()
    	  .statusCode(200)
    	  .log().body();
}

}
