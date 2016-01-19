package application.engine.addingDataEngine;

import application.dataClass.CountryHibernate;

public class AddCountry extends Addengine
{

	private CountryHibernate country;

	public AddCountry(String name, String continent)
	{
		country = new CountryHibernate(name);
		country.setContinent(continent);
	}

	@Override
	public Object getData()
	{
		return country;
	}

	public CountryHibernate getCountry()
	{
		return country;
	}
}
