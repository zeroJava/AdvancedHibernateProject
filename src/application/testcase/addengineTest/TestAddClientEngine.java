package application.testcase.addengineTest;

//import static org.junit.Assert.*;

import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;

import application.engine.addingDataEngine.AddClient;
import application.engine.factoryEngine.Factoryengine;

public class TestAddClientEngine {

	@SuppressWarnings("unused")
	private SessionFactory factory;
	private AddClient clientTs;
	
	@Before
	public void before()
	{
		factory = Factoryengine.getFactory();
		clientTs = new AddClient("Jonathan", "Blezzus", 25, "75 lingdon Street", 147259964L , 1);
	}
	
	@Test
	public void Adding_A_Client()
	{
		AddClient client = new AddClient("Next", "Red", 29, "75 lidon Road", 147259964L , 1);
		client.add();
	}
	
	@Test
	public void CreatingOjectAndSettingSecondAddress()
	{
		AddClient client = new AddClient("Jam", "Jimm", 25, "96 Lipen Street", 68561478523694L, 1);
		client.setSecondAddress("71 BEVL");
		client.add();
	}
	
	@Test
	public void CreatingOjectAndSettingMobileNumber()
	{
		AddClient client = new AddClient("Jon", "Snow", 30, "100 North Street", 44753159348264L, 1);
		client.setMobileNumber(4479315483465L);
		client.add();
	}
	
	@Test
	public void settingSecondAddress_and_settingMobile_InExistingObject()
	{
		clientTs.setSecondAddress("95 Belim Road");
		clientTs.setMobileNumber(4476365962666L);
		clientTs.add();
	}
	
	@Test
	public void testf()
	{
		AddClient client = new AddClient("Jop", "now", 30, "100 SAP Street", 44753159348264L, 56);
		client.setSecondAddress("95 Belim Road");
		client.setMobileNumber(4476365962666L);
		client.add();
	}
}
