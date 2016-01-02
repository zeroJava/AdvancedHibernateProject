package application.engine.addingDataEngine;

import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import application.dataClass.CityHibernate;
import application.dataClass.ClientHibernate;
import application.dataClass.components.Addresscl;
import application.dataClass.components.Phonenumber;
import application.engine.factoryEngine.Factoryengine;

public class AddClient extends Addengine{
	
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
		client.setDate(new Date());
	}
	
	public void setSecondAddress(String secondadrees) 
	{
		if(client.getAddress() != null)
		{
			client.getAddress().setSecondAddress(secondadrees);
		}
	}
	
	public void setMobileNumber(long number)
	{
		if(client.getPhonenumber() != null)
		{
			client.getPhonenumber().setMobilePhone(number);
		}
	}
	
	@Override
	public Object getData()
	{
		return client;
	}
		
	private CityHibernate getCity(int id) throws HibernateException
	{
		/* When using a method with a throws with an exception class, normally you are forced to surround it with 
		 * a try-catch block where ever the method is being used. 
		 * but with HibernateException, it bends the rule, and you are not forced to use getCity inside a 
		 * try-catch block
		 */
		factory = Factoryengine.getFactory();
		session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		CityHibernate city = (CityHibernate) session.load(CityHibernate.class, id);
		transaction.commit();
		session.close();
		return city;	
	}
}
