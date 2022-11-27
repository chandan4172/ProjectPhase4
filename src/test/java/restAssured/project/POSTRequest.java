package restAssured.project;

import static org.hamcrest.Matchers.is;

import java.util.HashMap;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class POSTRequest extends TestBase {

public static HashMap<String, String> map = new HashMap<String, String>();
	
	@BeforeMethod
	public void createPOSTData() {
		
		map.put("id", "786");
		map.put("email", "ameygirkar@google.com");
		map.put("first_name", "Amey");
		map.put("last_name", "Girkar");
		map.put("avatar", "https://reqres.in/img/faces/1-image.jpg");
		
		RestAssured.baseURI = "https://reqres.in";
		RestAssured.basePath = "/api/users";
		logger.info("BaseURL specified");
	}
	
	@Test
	public void verifyResponse() {
		logger.info("Inside POST method");
		RestAssured
			.given()
				.contentType("application/json")
				.body(map)
			.when()
				.post()
			.then()
				.assertThat()
				.statusCode(201)
			.and()
				.body("email", is("ameygirkar@google.com"))
				.log().all();
		logger.info("Response Code Verified");
		
		
		
		//System.out.println(RestAssured.given().get().body().asString());

		
	}
	
}
