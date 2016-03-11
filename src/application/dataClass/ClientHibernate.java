package application.dataClass;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import application.dataClass.components.Addresscl;
import application.dataClass.components.Phonenumber;

@NamedQueries({ @NamedQuery(name = ClientHibernate.clientwithID, query = "from ClientHibernate ch where ch.ID = :ID"),
		@NamedQuery(name = ClientHibernate.clientWithNames, query = "from ClientHibernate ch where ch.firstName = :firstName and ch.lastName = :lastName"),
		@NamedQuery(name = ClientHibernate.clientLivingInCity, query = "from ClientHibernate as ch inner join ch.cityID as city where city.name = :name")
})

@Entity
@Table(name = "client")
public class ClientHibernate
{

	public static final String clientwithID = "clientUsingID";
	public static final String clientWithNames = "clientWithName";
	public static final String clientLivingInCity = "clientLivingInCity";

	private int ID;
	private String firstName;
	private String lastName;
	private int age;
	private Addresscl address;
	private Phonenumber phonenumber;
	private CityHibernate cityID;
	private Date update;

	public ClientHibernate()
	{
		//
	}

	public ClientHibernate(String firstName, String lastName)
	{
		this.firstName = firstName;
		this.lastName = lastName;
	}

	@Id
	@GeneratedValue
	public int getID()
	{
		// @Column(name = "ID", nullable = false) // keep debugging purpose
		return ID;
	}

	public void setID(int ID)
	{
		this.ID = ID;
	}

	@Column(name = "FIRSTNAME", nullable = false)
	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	@Column(name = "LASTNAME", nullable = false)
	public String getLastName()
	{
		return lastName;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	@Column(name = "AGE", nullable = false)
	public int getAge()
	{
		return age;
	}

	public void setAge(int age)
	{
		this.age = age;
	}

	@Embedded
	public Addresscl getAddress()
	{
		return address;
	}

	public void setAddress(Addresscl address)
	{
		this.address = address;
	}

	@Embedded
	public Phonenumber getPhonenumber()
	{
		return phonenumber;
	}

	public void setPhonenumber(Phonenumber phonenumber)
	{
		this.phonenumber = phonenumber;
	}

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "CITY") // this join point is to column in the Client database table
	public CityHibernate getCityID()
	{
		return cityID;
	}

	public void setCityID(CityHibernate cityID)
	{
		this.cityID = cityID;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "UPDATED", nullable = true)
	public Date getUpdate()
	{
		return update;
	}

	public void setUpdate(Date date)
	{
		this.update = date;
	}

	public String toString()
	{
		return (this.ID + " " + this.firstName + " " + this.lastName + " " + this.cityID + " " + this.update);
	}

	public boolean equals(ClientHibernate object)
	{
		return (this.ID == object.getID() && this.firstName.equals(object.getFirstName())
				&& this.lastName.equals(object.getLastName()) && this.cityID == object.getCityID()
				&& this.update.equals(object.getUpdate()));
	}

	/*
	 * @Override public int hashCode() { final int prime = 31; int result = 1;
	 * result = prime * result + ID; result = prime * result +
	 * cityID.getcityID(); result = prime * result + ((firstName == null) ? 0 :
	 * firstName.hashCode()); result = prime * result + ((lastName == null) ? 0
	 * : lastName.hashCode()); result = prime * result + ((update == null) ? 0 :
	 * update.hashCode()); return result; }
	 */
}
