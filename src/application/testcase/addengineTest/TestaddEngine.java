package application.testcase.addengineTest;

//import static org.junit.Assert.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;

import application.engine.addingDataEngine.AddClientengine;
import application.engine.factoryEngine.Factoryengine;

public class TestaddEngine {

	private SessionFactory factory;
	private Session session;
	private AddClientengine client;
	
	@Before
	public void before()
	{
		factory = Factoryengine.getFactory();
	}
	
	@Test
	public void testAdding_A_Client()
	{
		long nu = 015L;
		client = new AddClientengine("Jonathan", "Blezzus", 25, "75 lingdon street", 01234567); // amend client class, by adding components
	}
}
