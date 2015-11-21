package application.engine.configEngine;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class ConfigurationEngine extends Configuration{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ConfigurationEngine()
	{
		super();
		configure();
	}

	public SessionFactory buildSessionFactory() throws HibernateException
	{
		//ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(super.getProperties()).build();
		return super.buildSessionFactory(serviceRegistry);
	}
	
	
}
