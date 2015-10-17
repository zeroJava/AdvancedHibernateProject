package application.factoryEngine;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class Factoryengine {

	private static SessionFactory sessionFactory;
	
	public static void createSessionFactory() throws HibernateException
	{
		
		Configuration configuration = new Configuration().configure();
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
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
