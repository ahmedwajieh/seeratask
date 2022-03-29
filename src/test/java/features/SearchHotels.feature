Feature: Validate Hotel Search API.
	@ValidateHotelSearch

	## Search Hotel by hardcoded data
	Scenario Outline: Verify that Search is returns spId when data is valid.
		Given User wants to Search Hotel where checkIn date is "<checkInDate>" and checkOut date is "<checkOutDate>" and adults number is "<numberOfAdults>" and childs ages is "<childsAges>" and placeId is "<placeId>"
		When API resource is "SearchHotelResource" and Http Method is "POST"
		Then Response status code should be 200
		Then Response body should contains "sId" property
		Examples:
		|checkInDate|checkOutDate|numberOfAdults|childsAges|placeId|
		|2022-05-15|2022-05-25|2|8,11,9|ChIJrRnTjtx5_IgRPSii63qm5Sw|

	## Search Hotel by Random checkin & checkout date within 30 days
	Scenario Outline: Verify that Search is returns spId using random checkIn and checkOut dates.
		Given User wants to Search Hotel where adults number is "<numberOfAdults>" and childs ages is "<childsAges>" and placeId is "<placeId>"
		When API resource is "SearchHotelResource" and Http Method is "POST"
		Then Response status code should be 200
		Then Response body should contains "sId" property
		Examples:
			|numberOfAdults|childsAges|placeId|
			|2|8,11,9|ChIJrRnTjtx5_IgRPSii63qm5Sw|

	## Search hotel where placeId is empty
	Scenario Outline: Verify that Search API is throwing 400 if placeId is filled.
		Given User wants to Search Hotel where checkIn date is "<checkInDate>" and checkOut date is "<checkOutDate>" and adults number is "<numberOfAdults>" and childs ages is "<childsAges>" and placeId is "<placeId>"
		When API resource is "SearchHotelResource" and Http Method is "POST"
		Then Response status code should be 400
		Examples:
			|checkInDate|checkOutDate|numberOfAdults|childsAges|placeId|
			|2022-05-15|2022-05-25|2|12,11,9||

	## Search Hotel where Place Id is invalid
	Scenario Outline: Verify that Search API is throwing 400 if placeId is not valid.
		Given User wants to Search Hotel where checkIn date is "<checkInDate>" and checkOut date is "<checkOutDate>" and adults number is "<numberOfAdults>" and childs ages is "<childsAges>" and placeId is "<placeId>"
		When API resource is "SearchHotelResource" and Http Method is "POST"
		Then Response status code should be 400
		Examples:
			|checkInDate|checkOutDate|numberOfAdults|childsAges|placeId|
			|2022-05-15|2022-05-25|2|12,11,9|invalidPlaceId|

	## Search Hotel where child ages are greater than 11
	Scenario Outline: Verify that child ages should not be greater than 11.
		Given User wants to Search Hotel where checkIn date is "<checkInDate>" and checkOut date is "<checkOutDate>" and adults number is "<numberOfAdults>" and childs ages is "<childsAges>" and placeId is "<placeId>"
		When API resource is "SearchHotelResource" and Http Method is "POST"
		Then Response status code should be 400
		Examples:
			|checkInDate|checkOutDate|numberOfAdults|childsAges|placeId|
			|2022-05-15|2022-05-25|2|12,11,9|ChIJrRnTjtx5_IgRPSii63qm5Sw|

	## Search Hotel where checkin is not filled
	Scenario Outline: Verify that checkIn date should not be empty.
		Given User wants to Search Hotel where checkIn date is "<checkInDate>" and checkOut date is "<checkOutDate>" and adults number is "<numberOfAdults>" and childs ages is "<childsAges>" and placeId is "<placeId>"
		When API resource is "SearchHotelResource" and Http Method is "POST"
		Then Response status code should be 400
		Examples:
			|checkInDate|checkOutDate|numberOfAdults|childsAges|placeId|
			||2022-05-25|2|12,11,9|ChIJrRnTjtx5_IgRPSii63qm5Sw|

	## Search Hotel where checkin date is greater than checkout date
	Scenario Outline: Verify that checkin date should not be greather than checkoutDate.
		Given User wants to Search Hotel where checkIn date is "<checkInDate>" and checkOut date is "<checkOutDate>" and adults number is "<numberOfAdults>" and childs ages is "<childsAges>" and placeId is "<placeId>"
		When API resource is "SearchHotelResource" and Http Method is "POST"
		Then Response status code should be 400
		Examples:
			|checkInDate|checkOutDate|numberOfAdults|childsAges|placeId|
			|2022-06-12|2022-05-25|2|12,11,9|ChIJrRnTjtx5_IgRPSii63qm5Sw|


	

	
	
	
	
	
	

	
	
	