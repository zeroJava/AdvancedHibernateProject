package application.testcase.dataclassTest;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;

import application.dataClass.CityHibernate;
import application.dataClass.CountryHibernate;
import application.factoryEngine.Factoryengine;

public class CheckPeristing {

	private SessionFactory factory;
	private Session session;
	
	@Before
	public void setup()
	{
		Factoryengine.createSessionFactory();
		factory = Factoryengine.getFactory();
	}
	
	@Test
	public void test()
	{
		session = factory.openSession();
		CountryHibernate uk = new CountryHibernate("United Kingdom");
		Set<CityHibernate> citiesUK = new HashSet<CityHibernate>();
		citiesUK.add(new CityHibernate("London"));
		citiesUK.add(new CityHibernate("Manchester"));
		uk.setCities(citiesUK);
		// TODO append the city and country class to make it bidirectional 
	}

}
