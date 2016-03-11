package application.engine.updateEngine;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import application.dataClass.ClientHibernate;
import application.dataClass.components.Addresscl;
import application.engine.factoryEngine.Factoryengine;
import application.engine.searchEngine.SearchClient;

public class UpdateClient extends Updateengine
{
	
	//private Session session;
	private ClientHibernate client;
	
	public UpdateClient(Session session, int id)
	{
		//this.session = session;
		//client = (ClientHibernate) session.load(ClientHibernate.class, id);
		Query query = session.getNamedQuery(ClientHibernate.clientwithID).setInteger("ID", id);
		client = (ClientHibernate) query.uniqueResult();
	}
	
	@Override
	public Object getData()
	{
		// TODO Auto-generated method stub
		return null;
	}

	public void updateForename(String firstName) 
	{
		client.setFirstName(firstName);
	}
	
	public void updateSurname(String surname)
	{
		client.setLastName(surname);
	}
	
	public void updateAge(int age)
	{
		client.setAge(age);
	}
	
	public void updateHomeAddress(String address)
	{
		client.getAddress().setHomeAddress(address);
	}
	
	public void updateSecondAddress(String address)
	{
		client.getAddress().setSecondAddress(address);
	}
}
