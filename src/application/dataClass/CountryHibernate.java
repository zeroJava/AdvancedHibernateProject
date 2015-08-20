package application.dataClass;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CountryHibernate {
	
	@Id
	private String name;
	private String continent;
	private int population;
	
	private Set<String> cities = new HashSet<String>();
	
	public CountryHibernate()
	{
		//
	}
	
	public CountryHibernate(String name)
	{
		this.setName(name);
	}
	
	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getContinent()
	{
		return continent;
	}
	
	public void setContinent(String continent)
	{
		this.continent = continent;
	}
	
	public int getPopulation()
	{
		return population;
	}

	public void setPopulation(int population)
	{
		this.population = population;
	}

	public Set<String> getCities()
	{
		return cities;
	}

	public void setCities(Set<String> cities)
	{
		this.cities = cities;
	}
}
