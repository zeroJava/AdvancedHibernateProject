package application.testcase.dataclassTest;

//import static org.junit.Assert.*;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.junit.Before;
import org.junit.Test;

import application.dataClass.CityHibernate;
import application.dataClass.ClientHibernate;
import application.engine.factoryEngine.Factoryengine;

public class TestNamequeryClient {

	private SessionFactory factory;
	private Session session;
	
	@Before
	public void setup()
	{
		factory = Factoryengine.getFactory();
	}
	
	@Test
	public void test()
	{
		session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		Criteria client = session.createCriteria(ClientHibernate.class, "client");
		//client.createAlias("client.firstName", "firstname");
		//client.createAlias("client.lastName", "lastname");
		client.add(Restrictions.eq("client.firstName", "jam")); // eq means equal
		client.add(Restrictions.eq("client.lastName", "Jimm"));
		@SuppressWarnings("unchecked")
		List<ClientHibernate> list = client.list();
		
		for(ClientHibernate cl : list)
		{
			System.out.println(cl);
		}
		
		transaction.commit();
		session.close();
	}
	
	@Test
	public void testNamedqueryForClientUsingName()
	{
		session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		Query client = session.getNamedQuery(ClientHibernate.clientWithNames).setParameter("firstName", "Jam").setParameter("lastName", "Jimm");
		@SuppressWarnings("unchecked")
		List<ClientHibernate> list = client.list();
		
		for(ClientHibernate cl : list)
		{
			System.out.println(cl);
		}
		
		transaction.commit();
		session.close();
	}

	@Test
	public void testNamequeryForclientUsingID()
	{
		session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.getNamedQuery(ClientHibernate.clientUsingID).setInteger("ID", 1);
		ClientHibernate client = (ClientHibernate) query.uniqueResult();
		System.out.println("client address: \n" + client.getAddress().getHomeAddress());
		transaction.commit();
		session.close();
		
		System.out.println();
	}
	
	@Test
	public void testNamequeryForcity()
	{
		session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.getNamedQuery(CityHibernate.UsingId).setInteger("cityID", 1);
		CityHibernate city = (CityHibernate) query.uniqueResult();
		transaction.commit();
		session.close();
		
		System.out.println("city: \n" + city.getcityID() + "\n" + city.getName());
	}
}
