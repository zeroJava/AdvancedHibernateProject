package application.engine.addingDataEngine;

import java.util.Date;
import java.util.Scanner;

import org.hibernate.HibernateException;

import application.dataClass.CityHibernate;
import application.dataClass.ClientHibernate;
import application.dataClass.components.Addresscl;
import application.dataClass.components.Phonenumber;

public class AddClient extends Addengine
{

	private ClientHibernate client;

	public AddClient(String firstname, String lastname, int age, String address, long homenumber, CityHibernate city)
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

	private CityHibernate getCity(CityHibernate cityda) throws HibernateException
	{
		/*
		 * When using a method with a throws with an exception class, normally
		 * you are forced to surround it with a try-catch block where ever the
		 * method is being used. but with HibernateException, it bends the rule,
		 * and you are not forced to use getCity inside a try-catch block
		 */
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		CityHibernate value = cityda;

		if (value != null)
		{
			// System.out.println(value);
			return value;
		}

		System.out.println("ebetr city anem and country name");
		String ci = input.nextLine();
		String co = input.nextLine();
		AddCity city = new AddCity(ci, co);
		city.add();

		return city.getCity();
	}
}
