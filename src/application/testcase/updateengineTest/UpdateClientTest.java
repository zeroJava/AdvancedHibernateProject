package application.testcase.updateengineTest;

//import static org.junit.Assert.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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
		session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		UpdateClient client = new UpdateClient(session, 10);
		client.updateForename("Jeen");
		client.updateHomeAddress("82 Buffolo Street");
		client.setUpdate(session);
		transaction.commit();
		session.close();
	}
}
