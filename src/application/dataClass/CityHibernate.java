package application.dataClass;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "city")
public class CityHibernate {
	
	private int cityID;
	private String name;
	private String country;
	private int population;
	//private Date update;
	
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
	@Column(name = "city_id")
	public int getcityID()
	{
		return cityID;
	}
	
	public void setcityID(int iD)
	{
		this.cityID = iD;
	}
	
	@Column(name = "name") 
	@ManyToOne
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
	
	@Column(name = "country")
	public String getCountry()
	{
		return country;
	}
	
	public void setCountry(String country)
	{
		this.country = country;
	}
	
	@Column(name = "population")
	public int getPopulation()
	{
		return population;
	}
	
	public void setPopulation(int population)
	{
		this.population = population;
	}
	
	public String toString()
	{
		return (this.cityID + " " + this.name + " " + this.country + " " + this.population);
	}
	
	public boolean equals(CityHibernate object)
	{
		return (this.cityID == object.getcityID() && this.name.equals(object.getName()) 
					&& this.country.equals(object.getCountry()) && this.population == object.getPopulation() );
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
		result = prime * result + population;
		return result;
	}
}
