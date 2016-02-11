package application.testcase.searchengineTest;

//import static org.junit.Assert.*;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Before;
import org.junit.Test;

import application.dataClass.CityHibernate;
import application.engine.factoryEngine.Factoryengine;
import application.engine.searchEngine.SearchCity;

public class SearchCityTest
{
	private SessionFactory factory;
	private Session session;
	
	@Before
	public void setup()
	{
		factory = Factoryengine.getFactory();
	}
	
	@Test
	public void searchcity_using_id_test()
	{
		session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		
		SearchCity search = new SearchCity(session);
		CityHibernate city = search.cityWithID(4);
		
		transaction.commit();
		session.close();
		
		System.out.println("searchcity_using_id_test");
		System.out.println(city);
	}
	
	@Test
	public void searchcity_using_name_test()
	{
		String name = "London";
		
		session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		
		SearchCity search = new SearchCity(session);
		List<CityHibernate> cities = search.cityWithName(name);
		
		transaction.commit();
		session.close();
		
		System.out.println("searchcity_using_name_test");
		for(CityHibernate city : cities)
		{
			System.out.println(city);
		}
	}
	
	@Test
	public void searchcity_using_country_test()
	{
		String country = "Germany";
		
		session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		
		SearchCity search = new SearchCity(session);
		List<CityHibernate> cities = search.cityInCountry(country);
		
		transaction.commit();
		session.close();
		
		System.out.println("searchcity_using_name_test");
		for(CityHibernate city : cities)
		{
			System.out.println(city);
		}
	}
}
