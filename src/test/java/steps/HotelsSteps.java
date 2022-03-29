package steps;

import daos.FindHotelsRequest;
import io.cucumber.java.en.Given;
import steps.commons.CommonSteps;
import utils.Helper;


import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class HotelsSteps {


private FindHotelsRequest searchHotelsPayload = new FindHotelsRequest();
private final CommonSteps commonSteps;

	public HotelsSteps(CommonSteps commonSteps) {
		this.commonSteps = commonSteps;
	}


	@Given("User wants to Search Hotel where checkIn date is {string} and checkOut date is {string} and adults number is {string} and childs ages is {string} and placeId is {string}")
public void SearchHotels(String checkInDate, String checkOutDate, String adultsNumber, String childAges, String placeId) throws IOException {

	commonSteps.testContext().set("REQUEST_SPECIFICATION",	given().spec(commonSteps.testContext().buildRequestV1())
			.body(searchHotelsPayload.buildSearchHotelsRequest(checkInDate,checkOutDate,adultsNumber,childAges,placeId)));
}

	@Given("User wants to Search Hotel where adults number is {string} and childs ages is {string} and placeId is {string}")
	public void searchHotelByRandomDates(String adults, String childs, String placeId) throws IOException {

		ArrayList<LocalDate> reservationDate = Helper.generateCheckInAndCheckOutDate();

		String checkInDate = reservationDate.get(0).toString();
		String checkOutDate = reservationDate.get(1).toString();

		System.out.println("checkin : "+checkInDate);
		System.out.println("checkout : " +checkOutDate);
		SearchHotels(checkInDate,checkOutDate,adults,childs,placeId);

	}
}
