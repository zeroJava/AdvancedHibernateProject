package application.engine.addingDataEngine;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import application.engine.factoryEngine.Factoryengine;

public class Savingmechanism {
	
	public static void Savingmec(Object oject) throws HibernateException
	{
		SessionFactory factory = Factoryengine.getFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(oject);
		transaction.commit();
		session.close();
	}
}
