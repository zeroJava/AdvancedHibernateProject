package application.testcase.inititalTest;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import application.engine.factoryEngine.Factoryengine;

public class ConfigurationTest
{

	@SuppressWarnings("unused")
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
		catch (HibernateException he)
		{
			System.out.println(he.getMessage());
		}
	}

	@Test
	public void testUtil()
	{
		Factoryengine.createSessionFactory();
		factory = Factoryengine.getFactory();
	}

	@Test
	public void test()
	{
		factory = Factoryengine.getFactory();
		session = factory.openSession();
		session.close();
	}
}
