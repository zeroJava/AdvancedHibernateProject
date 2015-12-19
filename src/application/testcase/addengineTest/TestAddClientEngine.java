package application.testcase.addengineTest;

//import static org.junit.Assert.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;

import application.engine.addingDataEngine.AddClient;
import application.engine.factoryEngine.Factoryengine;

public class TestAddClientEngine {

	@SuppressWarnings("unused")
	private SessionFactory factory;
	@SuppressWarnings("unused")
	private Session session;
	private AddClient client;
	
	@Before
	public void before()
	{
		factory = Factoryengine.getFactory();
	}
	
	@Test
	public void testAdding_A_Client()
	{
		client = new AddClient("Jonathan", "Blezzus", 25, "75 lingdon street", 147259964L , 1);
		client.add();
	}
	
	//@Test
}
