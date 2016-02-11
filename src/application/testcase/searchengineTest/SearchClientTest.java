package application.testcase.searchengineTest;

//import static org.junit.Assert.*;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Before;
import org.junit.Test;

import application.dataClass.ClientHibernate;
import application.engine.factoryEngine.Factoryengine;
import application.engine.searchEngine.SearchClient;

public class SearchClientTest
{

	private SessionFactory factory;
	private Session session;
	
	@Before
	public void setup()
	{
		factory = Factoryengine.getFactory();
	}
	
	@Test
	public void test_searchclient_using_id()
	{
		session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		
		SearchClient search = new SearchClient(session);
		List<ClientHibernate> clients = search.clientWithID(2);
		
		transaction.commit();
		session.close();
		
		System.out.println("test_searchclient_using_id");
		for(ClientHibernate client : clients)
		{
			System.out.println(client);
		}
	}
	
	@Test
	public void test_searchclient_with_names()
	{
		String firstname = "Jon";
		String lastname = "Snow";
		
		session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		
		SearchClient search = new SearchClient(session);
		List<ClientHibernate> clients = search.clientsWithNames(firstname, lastname);
		
		transaction.commit();
		session.close();
		
		System.out.println("test_searchclient_with_names");
		for(ClientHibernate client : clients)
		{
			System.out.println(client);
		}
	}
	
	@Test
	public void test_searchclient_using_cityname()
	{
		String cityname = "London";
		
		session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		
		SearchClient search = new SearchClient(session);
		List<ClientHibernate> clients = search.clientsLivingInCity(cityname);
		
		transaction.commit();
		session.close();
		
		System.out.println("test_searchclient_using_cityname");
		for(ClientHibernate client : clients)
		{
			System.out.println(client);
		}
	}
}
