package application.engine.factoryEngine;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;

import application.engine.configEngine.ConfigurationEngine;

public class Factoryengine {

	private static SessionFactory sessionFactory;
	
	public static void createSessionFactory() throws HibernateException
	{
		ConfigurationEngine configuration = new ConfigurationEngine();
		sessionFactory = configuration.buildSessionFactory();
	}
	
	public static SessionFactory getFactory() throws HibernateException
	{
		if(sessionFactory == null)
		{
			createSessionFactory();
		}
		
		return sessionFactory;
	}
}
