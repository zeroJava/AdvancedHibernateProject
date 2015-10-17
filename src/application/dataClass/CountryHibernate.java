package application.dataClass;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "country")
public class CountryHibernate {
	
	private String name;
	private String continent;
	private int population;
	
	private Set<CityHibernate> cities = new HashSet<CityHibernate>();
	
	public CountryHibernate()
	{
		//
	}
	
	public CountryHibernate(String name)
	{
		this.setName(name);
	}
	
	@Id
	@Column(name = "name")
	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	@Column(name = "continent")
	public String getContinent()
	{
		return continent;
	}
	
	public void setContinent(String continent)
	{
		this.continent = continent;
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

	// TODO append the city and country class to make it bidirectional 
	@OneToMany
	@JoinColumn(name="name") // the "name" indicates the column name in the database table
	public Set<CityHibernate> getCities()
	{
		return cities;
	}

	public void setCities(Set<CityHibernate> cities)
	{
		this.cities = cities;
	}
	
	public String toString()
	{
		return (this.name + " " + this.continent + " " + this.population);
	}
	
	public boolean equals(CountryHibernate object)
	{
		return (this.name.equals(object.getName()) && this.continent.equals(object.getContinent()) 
					&& this.population == object.getPopulation() );
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cities == null) ? 0 : cities.hashCode());
		result = prime * result
				+ ((continent == null) ? 0 : continent.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + population;
		return result;
	}	
}
