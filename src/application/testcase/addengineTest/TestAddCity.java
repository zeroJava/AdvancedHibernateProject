package application.testcase.addengineTest;

//import static org.junit.Assert.*;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import application.dataClass.CountryHibernate;
import application.engine.addingDataEngine.AddCity;
import application.engine.addingDataEngine.AddCountry;
import application.engine.factoryEngine.Factoryengine;

public class TestAddCity {

	@Test
	public void createNewCityInANewCountry()
	{
		AddCountry Bulgeria = new AddCountry("Bulgeria", "Europe");
		Bulgeria.add();
		
		AddCity city = new AddCity("Buchares", "Bulgeria");
		city.add();
	}

	@Test
	public void createUsingExistingCountry()
	{
		SessionFactory factory = Factoryengine.getFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Query query = session.getNamedQuery(CountryHibernate.countryUsingName).setParameter("name", "PR China");
		CountryHibernate country = (CountryHibernate) query.uniqueResult();
		
		transaction.commit();
		session.close();
		
		AddCity city = new AddCity("Sofia", country.getName());
		city.add();
	}
}
