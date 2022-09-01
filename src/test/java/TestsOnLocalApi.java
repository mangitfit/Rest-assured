import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
public class TestsOnLocalApi {

	//@Test
	public void get() {
		
		baseURI = "http://localhost:3000";
		given().get("/users").then().statusCode(200).log().all();
	}
	
	//@Test
	public void post() {  //Adding data needs bpdy content also
		
		//creating JSON obhject first
		JSONObject request = new JSONObject();
		
		request.put("firstName", "Thomas");
		request.put("LastName", "Edison");
		request.put("subjectId",1);
		
		baseURI = "http://localhost:3000";
		given().contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(request.toJSONString())
		.when()
		.post("/users")
		.then()
		.statusCode(201)
		.log().all();
		
	}
@Test	
public void put() {  // Update data needs bpdy content also
		
		//creating JSON obhject first
		JSONObject request = new JSONObject();
		
		request.put("firstName", "Albert");
		request.put("LastName", "Einstein");
		request.put("subjectId",2);
		
		baseURI = "http://localhost:3000";
		given().contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(request.toJSONString())
		.when()
		.put("/users/4")
		.then()
		.statusCode(200)
		.log().all();
		
	}
}
