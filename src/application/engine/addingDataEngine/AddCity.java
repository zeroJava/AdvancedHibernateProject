package application.engine.addingDataEngine;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import application.dataClass.CityHibernate;
import application.dataClass.CountryHibernate;
import application.engine.factoryEngine.Factoryengine;
import application.engine.searchEngine.SearchCountry;

public class AddCity extends Addengine
{

	private CityHibernate city;

	public AddCity(String name, String country)
	{
		city = new CityHibernate(name);
		city.setCountry(getCountry(country));
	}

	@Override
	public Object getData()
	{
		return city;
	}

	private CountryHibernate getCountry(String cnty)
	{
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in); // temp
		CountryHibernate country = null;

		SessionFactory factory = Factoryengine.getFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		SearchCountry search = new SearchCountry(session);
		country = search.countryWithName(cnty);

		transaction.commit();
		session.close();

		if (country != null)
		{
			return country;
		}

		System.out.println("Add county and continenmt"); // temp
		AddCountry addcountry = new AddCountry(input.nextLine(), input.nextLine());
		addcountry.add();
		country = addcountry.getCountry();

		return country;
	}

	public CityHibernate getCity()
	{
		return city;
	}
}
