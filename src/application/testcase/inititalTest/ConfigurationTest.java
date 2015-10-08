package application.testcase.inititalTest;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.junit.Test;

public class ConfigurationTest {

	private Configuration configuration;
	private SessionFactory factory;
	private Session session;
	
	@Test
	public void testConfiguarion()
	{
		try
		{
			configuration = new Configuration().configure();
		}
		catch(HibernateException he)
		{
			System.out.println(he.getMessage());
		}
	}
	
	@Test
	public void test()
	{
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		factory = configuration.buildSessionFactory(serviceRegistry);
		session = factory.openSession();
		session.close();
	}

}
