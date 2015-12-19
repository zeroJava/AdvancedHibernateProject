package application.engine.addingDataEngine;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import application.dataClass.CityHibernate;
import application.dataClass.ClientHibernate;
import application.dataClass.components.Addresscl;
import application.dataClass.components.Phonenumber;
import application.engine.factoryEngine.Factoryengine;

public class AddClient {
	
	private ClientHibernate client;
	private SessionFactory factory;
	private Session session;

	public AddClient(String firstname, String lastname, int age, String address, long homenumber, int id)
	{
		client = new ClientHibernate(firstname, lastname);
		client.setAge(age);
		client.setAddress(new Addresscl(address));
		client.setPhonenumber(new Phonenumber(homenumber));
		client.setCityID(getCity(id));
	}
	
	public void add()
	{
		try
		{
			factory = Factoryengine.getFactory();
			session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			session.save(client);
			transaction.commit();
		}
		catch (HibernateException e)
		{
			System.out.println("ERROR");
		}
		finally
		{
			session.close();
		}
	}
	
	private CityHibernate getCity(int id) throws HibernateException
	{
		factory = Factoryengine.getFactory();
		session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		CityHibernate city = (CityHibernate) session.load(CityHibernate.class, id);
		transaction.commit();
		session.close();
		return city;	
	}
}
