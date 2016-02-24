package application.testcase.updateengineTest;

//import static org.junit.Assert.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;

import application.engine.factoryEngine.Factoryengine;
import application.engine.updateEngine.UpdateClient;

public class UpdateClientTest
{
	private SessionFactory factory;
	private Session session;

	@Before
	public void setup()
	{
		factory = Factoryengine.getFactory();
	}
	
	@Test
	public void test_updating_details_of__exisitincustomer()
	{
		UpdateClient client = new UpdateClient(session, int id);
		client.setValues();
		client.setUpdate();
	}
}
