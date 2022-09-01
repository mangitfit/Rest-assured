import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.baseURI;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
public class SoapXMLRequest {

	@Test
	public void ValidateSoapXML() throws IOException{

		//importing Add.xml file into our project
		File file = new File("./SoapRequest/Add.xml"); //passing the path of file
		
		if(file.exists()) {
			System.out.println(">>File exists");
		}
		FileInputStream fis = new FileInputStream(file);
		   String requestBody  =      IOUtils.toString(fis,"UTF-8");
		
		baseURI = "http://dneonline.com/";
		
		given().contentType("text/xml").
		accept(ContentType.XML).
		body(requestBody).
		when().post("/calculator.asmx").
		then().statusCode(200).log().all();
	}
}
