import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;  // .* lagane ke baad RestAssured.get likhne ki jarurat nahi


import io.restassured.response.Response;
import junit.framework.Assert;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class GetRequest {

	@Test
	public void test_1() {
		
		Response response = get("https://reqres.in/api/users?page=2"); //this URL
		
		   System.out.println(response.getStatusCode());   
		    System.out.println(response.getTime());  
		    System.out.println(response.getBody().asString()); // JSON to string
		    System.out.println(response.getHeader("content-type"));
		    
		 int statcode =   response.getStatusCode();
		 
		 Assert.assertEquals(200, statcode);
	}
	
	@Test
	public void test_2() {
		
	   baseURI = "https://reqres.in/api";
		given().get("/users?page=2").then().statusCode(200).body("data[1].id", equalTo(8)).log().all();  //same which we used in previous test

	   //log.all - to get the complete response in the console
	}

	
	
	
}
