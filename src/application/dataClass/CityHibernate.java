package application.dataClass;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "city")
public class CityHibernate {
	
	@Id
	private int cityID;
	@Column()
	private String name;
	private int countryName;
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
	
	public int getcityID()
	{
		return cityID;
	}
	
	public void setcityID(int iD)
	{
		this.cityID = iD;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public int getCountryName()
	{
		return countryName;
	}
	
	public void setCountryName(int countryID)
	{
		this.countryName = countryID;
	}
	
	public int getPopulation()
	{
		return population;
	}
	
	public void setPopulation(int population)
	{
		this.population = population;
	}
}
