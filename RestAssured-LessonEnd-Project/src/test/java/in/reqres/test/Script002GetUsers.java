package in.reqres.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Script002GetUsers {
	
	@Test
	public void getUsers() {

		
		//https://reqres.in/api/users
		Response response = RestAssured
				.given()
				.baseUri("https://reqres.in")
				.basePath("/api/users")
				.contentType("application/json")
				.when()
				.get()
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
