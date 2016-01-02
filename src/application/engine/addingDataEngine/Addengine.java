package application.engine.addingDataEngine;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import application.engine.factoryEngine.Factoryengine;

public abstract class Addengine {
	
	public Addengine()
	{
		
	}

	public void add()
	{
		try
		{
			SessionFactory factory = Factoryengine.getFactory();
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			session.save(getData());
			transaction.commit();
			session.close();
		}
		catch(HibernateException e)
		{
			System.out.println("Could not add client, due to error in transactional phase ");
		}
	}
	
	public abstract Object getData();
}
