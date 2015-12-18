package application.engine.addingDataEngine;

import application.dataClass.ClientHibernate;
import application.dataClass.components.Addresscl;
import application.dataClass.components.Phonenumber;

public class AddClientengine {
	
	private ClientHibernate client;

	public AddClientengine(String firstname, String lastname, int age, String address, long homenumber)
	{
		client = new ClientHibernate(firstname, lastname);
		client.setAge(age);
		client.setAddress(new Addresscl(address));
		client.setPhonenumber(new Phonenumber(homenumber));
	}
}
