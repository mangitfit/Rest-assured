/*import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClassPath;
import org.testng.annotations.Test;

public class JSONSchemaValidator {

	
	@Test
		public void testGet() {
			
			baseURI = "https://reqres.in/api";
			
			given().get("/users?page=2").
			then().
			assertThat().body(matchesJsonSchemaInClasspath("schema.json")).  //schema.JSON file name
			statusCode(200).
			body("data[1].first_name",equalTo("Lindsay")).
		    body("data.first_name",hasItems("Michael","Lindsay"));
		}
		
}
*/