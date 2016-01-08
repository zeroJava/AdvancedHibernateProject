package application.dataClass;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@NamedQueries
(
	{
		@NamedQuery(name = CountryHibernate.countryUsingName, query = "from CountryHibernate country where country.name = :name")
	}
)

@Entity
@Table(name = "country")
public class CountryHibernate {
	
	public static final String countryUsingName = "countryUsingName"; 
	
	
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
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "country") // means foreign key in the city-hibernate
	public Set<CityHibernate> getCities()
	{
		// when association is bitdirectional, then it is better to use mappedby than @joincolumn for one-to-many.
		
		/* mappedby = "country" means the location of the variable in the city-hibernate which is attached to the 
		 * foreign key column for that entity classes table. 
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
