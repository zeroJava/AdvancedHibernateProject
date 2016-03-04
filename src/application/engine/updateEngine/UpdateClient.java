package application.engine.updateEngine;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import application.dataClass.ClientHibernate;
import application.engine.factoryEngine.Factoryengine;
import application.engine.searchEngine.SearchClient;

public class UpdateClient extends Updateengine
{
	
	private Session session;
	private ClientHibernate client;
	
	public UpdateClient(Session session, int id)
	{
		this.session = session;
	}
	
	private ClientHibernate retrieveClient(int id)
	{
		SessionFactory factory = Factoryengine.getFactory();
		Session tempsession = factory.openSession();
		Transaction transaction = tempsession.beginTransaction();
		
		SearchClient search = new SearchClient(session);
		client = search.clientWithID(id);
		
		transaction.commit();
		session.close();
		
		return client;
	}

	@Override
	public Object getData()
	{
		// TODO Auto-generated method stub
		return null;
	}

	public void setValues() {
		// TODO Auto-generated method stub
		
	}
}
