import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

public class GetAndPostExamples {

	//@Test
	public void testGet() {
		
		baseURI = "https://reqres.in/api";
		
		given().get("/users?page=2").then().statusCode(200).body("data[1].first_name",equalTo("Lindsay")).
		                                                   body("data.first_name",hasItems("Michael","Lindsay"));
	}
	
	
	@Test
	public void testPost() {
		//Note:- Post and PUT  requests needs body as well
	
		//{
	 //   "name": "morpheus",
	  //  "job": "leader"
	//}
		//above shown are <key,value> pairs hence using HashMap
		HashMap<String ,Object> map = new  HashMap<String ,Object>();
//		map.put("name", "Manthan");
//		map.put("job", "leader");
//		System.out.println(map);
		
		JSONObject request = new JSONObject(map);
		request.put("name", "manthan");
		request.put("job", "leader");
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
	     post("/users").then().statusCode(201).log().all();
	}
}
