package application.testcase.addengineTest;

//import static org.junit.Assert.*;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Before;
import org.junit.Test;

import application.dataClass.CityHibernate;
import application.engine.addingDataEngine.AddClient;
import application.engine.factoryEngine.Factoryengine;

public class TestAddClientEngine
{

	private SessionFactory factory;
	private Session session;
	private Transaction transaction;

	private CityHibernate city;

	@Before
	public void before()
	{
		factory = Factoryengine.getFactory();
		session = factory.openSession();
		transaction = session.beginTransaction();
		Query query = session.getNamedQuery(CityHibernate.cityWithId).setInteger("cityID", 4);
		city = (CityHibernate) query.uniqueResult();
		transaction.commit();
		session.close();
	}

	@Test
	public void Adding_A_Client()
	{
		AddClient client = new AddClient("Next", "Red", 29, "75 lidon Road", 147259964L, city);
		client.add();
	}

	@Test
	public void CreatingOjectAndSettingSecondAddress()
	{
		session = factory.openSession();
		transaction = session.beginTransaction();
		Query query = session.getNamedQuery(CityHibernate.cityWithId).setInteger("cityID", 4);
		city = (CityHibernate) query.uniqueResult();
		transaction.commit();
		session.close();

		AddClient client = new AddClient("Jam", "Jimm", 25, "96 Lipen Street", 68561478523694L, city);
		client.setSecondAddress("71 BEVL");
		client.add();
	}

	@Test
	public void CreatingOjectAndSettingMobileNumber()
	{
		session = factory.openSession();
		transaction = session.beginTransaction();
		Query query = session.getNamedQuery(CityHibernate.cityWithId).setInteger("cityID", 4);
		city = (CityHibernate) query.uniqueResult();
		transaction.commit();
		session.close();

		AddClient client = new AddClient("Jon", "Snow", 30, "100 North Street", 44753159348264L, city);
		client.setMobileNumber(4479315483465L);
		client.add();
	}

	@Test
	public void settingSecondAddress_and_settingMobile_InExistingObject()
	{
		AddClient clientTs = new AddClient("Jonathan", "Blezzus", 25, "75 lingdon Street", 147259964L, city);
		clientTs.setSecondAddress("95 Belim Road");
		clientTs.setMobileNumber(4476365962666L);
		clientTs.add();
	}

	@Test
	public void testf()
	{
		session = factory.openSession();
		transaction = session.beginTransaction();
		Query query = session.getNamedQuery(CityHibernate.cityWithId).setInteger("cityID", 4);
		city = (CityHibernate) query.uniqueResult();
		transaction.commit();
		session.close();

		AddClient client = new AddClient("Jop", "now", 30, "100 SAP Street", 44753159348264L, city);
		client.setSecondAddress("95 Belim Road");
		client.setMobileNumber(4476365962666L);
		client.add();
	}
}
