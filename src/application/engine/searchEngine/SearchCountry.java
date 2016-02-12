package application.engine.searchEngine;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import application.dataClass.CountryHibernate;

public class SearchCountry
{
	private Session session;
	
	public SearchCountry(Session session)
	{
		this.session = session;
	}
	
	public CountryHibernate countryWithName(String name)
	{
		Query query = session.getNamedQuery(CountryHibernate.countryUsingName).setParameter("name", name);
		return (CountryHibernate)query.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<CountryHibernate> countriesInContient(String continent)
	{
		Query query = session.getNamedQuery(CountryHibernate.countriesInContinent).setParameter("conti", continent);
		return query.list();
	}
}
