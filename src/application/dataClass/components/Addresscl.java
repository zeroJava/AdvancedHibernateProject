package application.dataClass.components;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Addresscl
{

	private String homeAddress;
	private String secondAddress;

	public Addresscl()
	{
		//
	}

	public Addresscl(String firstAddress)
	{
		this.homeAddress = firstAddress;
	}

	public Addresscl(String firstAddress, String secondAddress)
	{
		this.homeAddress = firstAddress;
		this.secondAddress = secondAddress;
	}

	@Column(name = "HOME_ADDRESS", nullable = false)
	public String getHomeAddress()
	{
		return homeAddress;
	}

	public void setHomeAddress(String homeAddress)
	{
		this.homeAddress = homeAddress;
	}

	@Column(name = "SECOND_ADDRESS", nullable = true)
	public String getSecondAddress()
	{
		return secondAddress;
	}

	public void setSecondAddress(String secondAddress)
	{
		this.secondAddress = secondAddress;
	}
}
