package application.engine.addingDataEngine;

import java.util.Date;
import java.util.Scanner;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import application.dataClass.CityHibernate;
import application.dataClass.ClientHibernate;
import application.dataClass.components.Addresscl;
import application.dataClass.components.Phonenumber;
import application.engine.factoryEngine.Factoryengine;
import application.engine.searchEngine.SearchCity;

public class AddClient extends Addengine
{

	private ClientHibernate client;

	public AddClient(String firstname, String lastname, int age, String address, long homenumber, int city)
	{
		client = new ClientHibernate(firstname, lastname);
		client.setAge(age);
		client.setAddress(new Addresscl(address));
		client.setPhonenumber(new Phonenumber(homenumber));
		client.setCityID(getCity(city));
		client.setDate(new Date());
	}

	public void setSecondAddress(String secondadrees)
	{
		if (client.getAddress() != null)
		{
			client.getAddress().setSecondAddress(secondadrees);
		}
	}

	public void setMobileNumber(long number)
	{
		if (client.getPhonenumber() != null)
		{
			client.getPhonenumber().setMobilePhone(number);
		}
	}

	@Override
	public Object getData()
	{
		return client;
	}

	private CityHibernate getCity(int cityid) throws HibernateException
	{
		/*
		 * When using a method with a throws with an exception class, normally
		 * you are forced to surround it with a try-catch block where ever the
		 * method is being used. but with HibernateException, it bends the rule,
		 * and you are not forced to use getCity inside a try-catch block
		 */
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		CityHibernate value = null;
		
		SessionFactory factory = Factoryengine.getFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		
		SearchCity city = new SearchCity(session);
		value = city.cityWithID(cityid);
		
		transaction.commit();
		session.close();

		if (value != null)
		{
			// System.out.println(value);
			return value;
		}

		System.out.println("ebetr city anem and country name");
		String ci = input.nextLine();
		String co = input.nextLine();
		AddCity newcity = new AddCity(ci, co);
		newcity.add();

		return newcity.getCity();
	}
}
