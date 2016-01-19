package application.engine.configEngine;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class ConfigurationEngine
{

	/**
	 * 
	 */

	private Configuration configuration;

	public ConfigurationEngine()
	{
		configuration = new Configuration();
	}

	public ConfigurationEngine config()
	{
		configuration.configure();
		return this;
	}

	public SessionFactory buildSessionFactory() throws HibernateException
	{
		// ServiceRegistry serviceRegistry = new
		// StandardServiceRegistryBuilder().applySettings(super.getProperties()).build();
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();
		return configuration.buildSessionFactory(serviceRegistry);
	}

}
