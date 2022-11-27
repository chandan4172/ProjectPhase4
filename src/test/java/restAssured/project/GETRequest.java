package restAssured.project;

import static org.hamcrest.Matchers.is;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class GETRequest extends TestBase {
	
	
	@BeforeMethod
	public void createGET() {

	RestAssured.baseURI ="https://reqres.in/";
	RestAssured.basePath = "/api/users?page=2";
	logger.info("BaseURL specified");
}
	
	@Test
	public void verifyUser() {
	
		logger.info("Inside POST method");
		RestAssured.get()
		.then()
			.assertThat()
			.statusCode(200)
		.and()
			.body("data[1].email", is("janet.weaver@reqres.in"))
			.log().all();
		
		logger.info("Response Code Verified");
		
		//System.out.println(RestAssured.given().get().body().asString());
		//RestAssured.given().log().all();
	}
}