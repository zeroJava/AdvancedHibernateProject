package application.testcase.searchengineTest;

import static org.junit.Assert.*;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import application.dataClass.CountryHibernate;
import application.engine.factoryEngine.Factoryengine;
import application.engine.searchEngine.SearchCountry;

public class SearchCountryTest
{
	private SessionFactory factory;
	private Session session;
	
	@Before
	public void setup()
	{
		factory = Factoryengine.getFactory();
	}
	
	@Test
	public void searchcountry_using_nametest()
	{
		String name = "United Kingdom";
		
		session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		
		SearchCountry search = new SearchCountry(session);
		CountryHibernate country = search.countryWithName(name);
		
		transaction.commit();
		session.close();
		
		assertNotNull(country);
		System.out.println("searchcountry_using_nametest()\n" + country);
	}
	
	@Test
	public void searchcountry_using_continenttest()
	{
		String continent = "Europe";
		
		session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		
		SearchCountry search = new SearchCountry(session);
		List<CountryHibernate> countries = search.countriesInContient(continent);
		
		transaction.commit();
		session.close();
		
		assertNotNull("searchcountry_using_continenttest()", countries);
		for(CountryHibernate country : countries)
		{
			System.out.println(country);
		}
	}
	
	@Test
	public void searchcountry_using_name_dont_exist()
	{
		String name = "Johnland";
		
		session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		
		SearchCountry search = new SearchCountry(session);
		CountryHibernate country = search.countryWithName(name);
		
		transaction.commit();
		session.close();
		
		Assert.assertNull(country);
	}
	
	@Test
	public void searchcountry_from_nonexisting_continent()
	{
		String continent = "Dfvdfklvkl";
		//List<CountryHibernate> dummy;
		
		session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		
		SearchCountry search = new SearchCountry(session);
		List<CountryHibernate> countries = search.countriesInContient(continent);
		
		transaction.commit();
		session.close();
		
		assertTrue(countries.isEmpty());
	}
}
