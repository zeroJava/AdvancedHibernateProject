package application.testcase.updateengineTest;

import static org.junit.Assert.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;

import application.dataClass.CityHibernate;
import application.engine.factoryEngine.Factoryengine;

public class UpdateCityTest 
{
	private SessionFactory factory;
	private Session session;
	
	@Before
	public void setup()
	{
		factory = Factoryengine.getFactory();
		sess
	}

	@Test
	public void update_exiting_city_test_() 
	{
		CityHibernate city = 
	}

}
