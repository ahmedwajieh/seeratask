package resources;
//enum is special class in java which has collection of constants or  methods
public enum APIResources {

	SearchHotelResource("/enigma/search/async"),
	SearchFlightsResource("/flights/flight/search");


	private String resource;
	
	APIResources(String resource)
	{
		this.resource=resource;
	}
	
	public String getResource()
	{
		return resource;
	}
	

}
