import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC_001_GET_Request {

	
	@Test
	void getWeatherDetails() {
		
		//specify base URI
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		
		//Request object
		RequestSpecification httprequest =  RestAssured.given();
		
		//Response object to store the response
	    Response response =   httprequest.request(Method.GET,"/Hyderabad"); //specify the path parameter ie, city name
		     
		   //print response in console window
	    // resposne is recieved in JSON format need to convert it into string 
	      String responseBody =   response.getBody().asString();
	      System.out.println("Response body is :" +responseBody);
		       
	}
}
