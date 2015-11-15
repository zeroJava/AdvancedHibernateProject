package application.dataClass;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "client")
public class ClientHibernate {
	
	
	private int ID;
	private String firstName;
	private String lastName;
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
	
	public ClientHibernate(String firstName, String lastName, CityHibernate cityID)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.cityID = cityID;
	}
	
	@Id
	@GeneratedValue
	public int getID()
	{
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
	@Column(name = "UPDATED", nullable = false)
	public Date getDate()
	{
		return update;
	}
	
	public void setDate(Date date)
	{
		this.update = date;
	}
	
	public String toString()
	{
		return (this.ID + " " + this.firstName + " " + this.lastName + " " + this.cityID + " " + this.update);
	}
	
	public boolean equals(ClientHibernate object)
	{
		return ( this.ID == object.getID() && this.firstName.equals(object.getFirstName()) 
					&& this.lastName.equals(object.getLastName()) && this.cityID == object.getCityID()
					&& this.update.equals(object.getDate()) );
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ID;
		result = prime * result + cityID.getcityID();
		result = prime * result
				+ ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result
				+ ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((update == null) ? 0 : update.hashCode());
		return result;
	}
}
