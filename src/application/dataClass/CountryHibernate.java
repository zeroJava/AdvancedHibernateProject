package application.dataClass;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
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
	@Column(name = "NAME")
	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	@Column(name = "CONTINENT")
	public String getContinent()
	{
		return continent;
	}
	
	public void setContinent(String continent)
	{
		this.continent = continent;
	}
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="COUNTRY")
	public Set<CityHibernate> getCities()
	{
		// the "city id" indicates the column name which is in the city database table
		/* joincolumn basically means foreign key of this table/entity pointing to the other table/entities public key 
		 * name indicate the column name we are going to use
		 * the columns in question, would be the CityHibernate columns because that columns will the connecting point to the entity class/table.
		 */
		return cities;
	}

	public void setCities(Set<CityHibernate> cities)
	{
		this.cities = cities;
	}
	
	public String toString()
	{
		return (this.name + " " + this.continent);
	}
	
	public boolean equals(CountryHibernate object)
	{
		return (this.name.equals(object.getName()) && this.continent.equals(object.getContinent()) );
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
		return result;
	}	
}
