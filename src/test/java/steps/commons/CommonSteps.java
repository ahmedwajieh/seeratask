package steps.commons;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import resources.APIResources;
import resources.HttpMethod;
import utils.Helper;
import utils.ITestContext;

import static utils.ITestContext.CONTEXT;


import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class CommonSteps{
	public ITestContext testContext() {
		return CONTEXT;
	}

	@When("API resource is {string} and Http Method is {string}")
	public void api_resource_is_and_http_method_is(String apiResource, String httpMethod){
		APIResources resource = APIResources.valueOf(apiResource);
		HttpMethod method = HttpMethod.valueOf(httpMethod);

		switch (method) {
			case POST:

				testContext().setResponse(testContext().getRequest().when().post(resource.getResource()));
				break;

			case GET:
				testContext().setResponse(testContext().getRequest().when().get(resource.getResource()));
				break;

			case PUT:
				testContext().setResponse(testContext().getRequest().when().put(resource.getResource()));
				testContext().setJsonPathResponse();
				break;

			case DELETE:
				testContext().setResponse(testContext().getRequest().when().delete(resource.getResource()));

				break;

			default:
				System.out.println("ERROR, METHOD NOT SUPPORTED");
				break;
		}

	}

	@Then("^Response status code should be (.*)$")
	public void response_status_code_should_be(int statusCode) {

		testContext().getResponse().then().assertThat().statusCode(statusCode).extract().response();

	}

	@Then("Response body should contains {string} property")
	public void response_body_should_contains_property(String property) {

		Assert.assertTrue(Helper.verifyPropertyInResponse(property,testContext().getResponse()));
	}
}
