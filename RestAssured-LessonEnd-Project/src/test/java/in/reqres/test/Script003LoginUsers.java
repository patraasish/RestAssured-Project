package in.reqres.test;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Script003LoginUsers {

	
	
	
	@Test
	public void Login_User() {

		/*
		 * {
	    "email": "eve.holt@reqres.in",
	    "password": "cityslicka"
			}
		 * */

		JSONObject body = new JSONObject();
		
		body.put("email", "eve.holt@reqres.in");
		body.put("password", "cityslicka");
		
		String jsonBody=body.toString();
			
		//https://reqres.in/api/register
		Response response = RestAssured
				.given()
				.baseUri("https://reqres.in")
				.basePath("/api/login")
				.contentType("application/json")
				.body(jsonBody)
				.when()
				.post()
				.then()
				.statusCode(200)
				.extract()
				.response();
	
		System.out.println(response.getBody().asPrettyString());
		System.out.println("Status Code " + response.getStatusCode());
		System.out.println("Response Time: "+response.getTime());
		System.out.println("Content Type: "+response.getHeader("Content-Type"));
		int expectStatusCode = 200;
		int ActualStatusCode = response.getStatusCode();
		Assert.assertEquals(expectStatusCode, ActualStatusCode);
	}
}
