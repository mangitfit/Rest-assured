import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PutPatchDeleteExamples {
	@Test
	public void testPUT() {
		//Note:- Post and PUT  requests needs body as well
	
		//{
	 //   "name": "morpheus",
	  //  "job": "leader"
	//}
	
		JSONObject request = new JSONObject();
		request.put("name", "manthan");   //body
		request.put("job", "leader");    //body
		System.out.println(request.toJSONString());
		
		//sending actual post request
		baseURI = "https://reqres.in/api";
	
	     given().
	     //Header optional
	     header("Content-Type","application/json").
	     contentType(ContentType.JSON)  //request bhej rae hain in JSON type
	     .accept(ContentType.JSON).   //response bhi json type me chahiye
	     
	     body(request.toJSONString()).
	     when().
	     put("/users/2").then().statusCode(200).log().all();
}
	
	@Test
	public void testPATCH() {
		//Note:- Post and PUT  requests needs body as well
	
		//{
	 //   "name": "morpheus",
	  //  "job": "leader"
	//}
	
		JSONObject request = new JSONObject();
		request.put("name", "manthan");   //body
		request.put("job", "leader");    //body
		System.out.println(request.toJSONString());
		
		//sending actual post request
		baseURI = "https://reqres.in";
	
	     given().
	     //Header optional
	     header("Content-Type","application/json").
	     contentType(ContentType.JSON)  //request bhej rae hain in JSON type
	     .accept(ContentType.JSON).   //response bhi json type me chahiye
	     
	     body(request.toJSONString()).
	     when().
	     patch("/api/users/2").then().statusCode(200).log().all();
}
	
	@Test
	public void testDelete() {  //no body required
		//Note:- Post and PUT  requests needs body as well
	
		//{
	 //   "name": "morpheus",
	  //  "job": "leader"
	//}
	
		/*JSONObject request = new JSONObject();
		request.put("name", "manthan");   //body
		request.put("job", "leader");    //body
		System.out.println(request.toJSONString());*/
		
		//sending actual post request
		baseURI = "https://reqres.in";
	
	   
	     when().
	     delete("/api/users/2").then().statusCode(204).log().all(); //status code for delete 204
}
}
