package application.engine.addingDataEngine;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import application.engine.factoryEngine.Factoryengine;

public class Savingmechanism
{

	private static SessionFactory factory;
	private static Session session;
	private static Transaction transaction;

	public static void Savingmec(Object oject) throws HibernateException
	{
		try
		{
			factory = Factoryengine.getFactory();
			Session session = factory.openSession();
			transaction = session.beginTransaction();
			session.save(oject);
			transaction.commit();
		}
		catch (HibernateException e)
		{
			System.out.println("Error ");
		}
		finally
		{
			session.close();
		}
	}
}
