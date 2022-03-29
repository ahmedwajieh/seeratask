Feature: Validate Flight Search API.

	## Search Flight by hardcoded data
	Scenario Outline: Verify that Search Flight API is working.
		Given User wants to Search Flights where origin is "<origin>" and destination is "<destination>" and depart date is "<departDate>" and return date is "<returnDate>" and class is "<classType>" and number of passengers is "<passengers>"
		When API resource is "SearchFlightsResource" and Http Method is "GET"
		Then Response status code should be 200
		Examples:
		|origin|destination|departDate|returnDate|classType|passengers|
		|AMM|CAI|2022-04-05|2022-04-20|Economy|2|

	## Search Flight roundTrip only
	Scenario Outline: Verify that Search Flight API is working.
		Given User wants to Search Flights where origin is "<origin>" and destination is "<destination>" and depart date is "<departDate>" and return date is "<returnDate>" and class is "<classType>" and number of passengers is "<passengers>"
		When API resource is "SearchFlightsResource" and Http Method is "GET"
		Then Response status code should be 200
		Examples:
			|origin|destination|departDate|returnDate|classType|passengers|
			|AMM|CAI|2022-04-05||First|2|



	

	
	
	
	
	
	

	
	
	