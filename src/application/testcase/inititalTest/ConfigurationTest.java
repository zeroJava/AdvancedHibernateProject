package application.testcase.inititalTest;

import static org.junit.Assert.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;

public class ConfigurationTest {

	private SessionFactory factory;
	private Session session;
	
	@Before
	public void setup()
	{
		//factory = HibernateUtilies.getSessionfactory();
	}
	
	@Test
	public void test()
	{
		fail("Not yet implemented");
	}

}
