package application.testcase.addengineTest;

//import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import application.engine.addingDataEngine.AddClient;

public class TestAddClientEngine
{
	private int city;

	@Before
	public void before()
	{
		city = 4;
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
		AddClient client = new AddClient("Jam", "Jimm", 25, "96 Lipen Street", 68561478523694L, city);
		client.setSecondAddress("71 BEVL");
		client.add();
	}

	@Test
	public void CreatingOjectAndSettingMobileNumber()
	{
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
		AddClient client = new AddClient("Jop", "now", 30, "100 SAP Street", 44753159348264L, city);
		client.setSecondAddress("95 Belim Road");
		client.setMobileNumber(4476365962666L);
		client.add();
	}
}
