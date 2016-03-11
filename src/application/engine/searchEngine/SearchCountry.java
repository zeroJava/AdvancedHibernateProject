package application.engine.searchEngine;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import application.dataClass.CountryHibernate;

public class SearchCountry
{
	
	public static CountryHibernate countryWithName(Session session, String name)
	{
		Query query = session.getNamedQuery(CountryHibernate.countryUsingName).setParameter("name", name);
		return (CountryHibernate)query.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public static List<CountryHibernate> countriesInContient(Session session, String continent)
	{
		Query query = session.getNamedQuery(CountryHibernate.countriesInContinent).setParameter("conti", continent);
		return query.list();
	}
}
