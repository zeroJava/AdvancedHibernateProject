package application.dataClass;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "city")
public class CityHibernate {
	
	
	private int cityID;
	private String name;
	private CountryHibernate country;
	
	
	private Set<ClientHibernate> clients = new HashSet<ClientHibernate>();
	
	public CityHibernate()
	{
		//
	}
	
	public CityHibernate(String name)
	{
		setName(name);
	}
	
	@Id
	@GeneratedValue
	@Column(name = "ID")
	public int getcityID()
	{
		return cityID;
	}
	
	public void setcityID(int iD)
	{
		this.cityID = iD;
	}
	
	@Column(name = "NAME") 
	public String getName()
	{
		/* @column annotation links the variable from the persistant class to the sql table. */
		
		/* It's good practice to put the the @column annotation on the getter method, rather than directly the variable 
		 * because process of retrieving data is faster this way */
		
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "COUNTRY") // will be joining to the name column in the country table foreign key
	public CountryHibernate getCountry()
	{
		return country;
	}
	
	public void setCountry(CountryHibernate country)
	{
		this.country = country;
	}
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "cityID") // mappeedby cityId means foreign key in the entity clienthibernate class
	public Set<ClientHibernate> getClients()
	{
		return clients;
	}

	public void setClients(Set<ClientHibernate> clients)
	{
		this.clients = clients;
	}

	public String toString()
	{
		return (this.cityID + " " + this.name + " " + this.country);
	}
	
	public boolean equals(CityHibernate object)
	{
		return (this.cityID == object.getcityID() && this.name.equals(object.getName()) 
					&& this.country.equals(object.getCountry()) );
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + cityID;
		result = prime * result
				+ ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
}
