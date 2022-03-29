package steps;

import constants.ClassType;
import daos.FindHotelsRequest;
import io.cucumber.java.en.Given;
import io.restassured.specification.RequestSpecification;
import models.FlightSearch;
import resources.APIResources;
import steps.commons.CommonSteps;
import java.io.IOException;
import java.util.Locale;

import static io.restassured.RestAssured.given;

public class FlightsSteps{

	private FindHotelsRequest searchHotelsPayload = new FindHotelsRequest();
	private final CommonSteps commonSteps;
	public FlightsSteps(CommonSteps commonSteps) {
		this.commonSteps = commonSteps;
	}

@Given("User wants to Search Flights where origin is {string} and destination is {string} and depart date is {string} and return date is {string} and class is {string} and number of passengers is {string}")
public void SearchFlights(String origin, String destination, String departDate, String returnDate, String cabinType, String adults) throws IOException, NoSuchFieldException, IllegalAccessException {

	ClassType classType = ClassType.valueOf(cabinType.toUpperCase());
	FlightSearch objSearchFlight = new FlightSearch(origin,destination,departDate,returnDate,classType.getClassType(),adults);
	commonSteps.testContext().set("REQUEST_SPECIFICATION",	given().spec(commonSteps.testContext().buildRequestV3())
					.queryParam("query",objSearchFlight.buildQuery()));

}

}
