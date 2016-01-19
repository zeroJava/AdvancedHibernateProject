package application.dataClass.components;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Phonenumber
{

	private long homePhone;
	private long mobilePhone;

	public Phonenumber()
	{
		//
	}

	public Phonenumber(long homePhone)
	{
		this.homePhone = homePhone;
	}

	public Phonenumber(long homePhone, long mobilePhone)
	{
		this.homePhone = homePhone;
		this.mobilePhone = mobilePhone;
	}

	@Column(name = "TELEPHONE", nullable = false)
	public long getHomePhone()
	{
		return homePhone;
	}

	public void setHomePhone(long homePhone)
	{
		this.homePhone = homePhone;
	}

	@Column(name = "MOBILE", nullable = true)
	public long getMobilePhone()
	{
		return mobilePhone;
	}

	public void setMobilePhone(long mobilePhone)
	{
		this.mobilePhone = mobilePhone;
	}
}
