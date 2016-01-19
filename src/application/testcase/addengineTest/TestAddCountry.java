package application.testcase.addengineTest;

//import static org.junit.Assert.*;

import org.junit.Test;

import application.engine.addingDataEngine.AddCountry;

public class TestAddCountry
{

	@Test
	public void test()
	{
		AddCountry country = new AddCountry("PR China", "Asia");
		country.add();
	}
}
