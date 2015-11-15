package application.testcase.dataclassTest;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Before;
import org.junit.Test;

import application.dataClass.CityHibernate;
import application.dataClass.ClientHibernate;
import application.dataClass.CountryHibernate;
import application.factoryEngine.Factoryengine;

public class CheckPeristing {

	private SessionFactory factory;
	private Session session;
	private Transaction transaction;
	
	@Before
	public void setup()
	{
		Factoryengine.createSessionFactory();
		factory = Factoryengine.getFactory();
	}
	
	public void testCreateCountry()
	{
		session = factory.openSession();
		transaction = session.beginTransaction();
		
		CountryHibernate Japan = new CountryHibernate("Japan");
		
		session.save(Japan);
		transaction.commit();
		session.close();
	}
	
	//@Test
	public void testAddCityToExistingCountry()
	{
		session = factory.openSession();
		transaction = session.beginTransaction();
		
		CityHibernate mk = new CityHibernate("Milton Keynes");
		CountryHibernate uk = (CountryHibernate) session.load(CountryHibernate.class, "United Kingdom");
		mk.setCountry(uk);
		
		session.save(mk);
		
		transaction.commit();
		session.close();
		// TODO append the city and country class to make it bidirectional 
	}

	@Test
	public void testAddclientToExistingCity()
	{
		session = factory.openSession();
		transaction = session.beginTransaction();
		
		ClientHibernate jon_wayne = new ClientHibernate("Jon", "Wayne");
		CityHibernate city = (CityHibernate) session.load(CityHibernate.class, 2);
		jon_wayne.setCityID(city);
		jon_wayne.setDate(new Date());
		
		session.save(jon_wayne);
		transaction.commit();
		session.close();
	}
}
