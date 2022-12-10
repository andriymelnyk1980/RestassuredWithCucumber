package stepDefs;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class CRUDO_stepdef {
	
	Response response;
	RequestSpecification request;
	Map<String,Object> MapObj ;

	@Given("The base URI is {string}")
	public void the_base_URI_is(String URI) {
	    request = RestAssured.given().baseUri(URI);
	}
	
	@When("I perform the Get Operation")
	public void i_perform_the_Get_Operation() {
	   response = request.get(); 
	}
	
	@Then("Response code should be {int}")
	public void response_code_should_be(int ExeResponseCode) {
	Assert.assertEquals(ExeResponseCode, response.getStatusCode());
	
	
	}
	
	@When("I pass the name {string} and salary {string}")
	public void i_pass_the_name_and_salary(String name, String salary) {
	    // Write code here that turns the phrase above into concrete actions
		MapObj = new HashMap<String,Object>();
		MapObj.put("name", name);
		MapObj.put("salary", salary);

	}

	@When("I Perform  the Post Operation")
	public void i_Perform_the_Post_Operation() {
	    // Write code here that turns the phrase above into concrete actions
		 response =(request.contentType(ContentType.JSON).accept(ContentType.JSON).body(MapObj).post("/create"));
		 System.out.println(response.getBody().asString());

	}


}


