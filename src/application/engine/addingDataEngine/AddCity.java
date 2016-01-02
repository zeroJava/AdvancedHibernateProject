package application.engine.addingDataEngine;

import application.dataClass.CityHibernate;

public class AddCity {
	
	private CityHibernate city;
		
	public AddCity(String name, String country)
	{
		city = new CityHibernate(name);
		city.setCountry(country);
		
	}
	
	
}
