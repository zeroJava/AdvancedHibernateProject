package application.engine.searchEngine;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import application.dataClass.CityHibernate;

public class SearchCity
{
	private Session session;
	
	public SearchCity(Session session)
	{
		this.session = session;
	}

	public CityHibernate cityWithID(int id)
	{
		Query query = session.getNamedQuery(CityHibernate.cityWithId).setInteger("cityID", id); 
		return (CityHibernate) query.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<CityHibernate> cityWithName(String name)
	{
		Query query = session.getNamedQuery(CityHibernate.cityWithName).setParameter("name", name);
		return query.list();
	}

	@SuppressWarnings("unchecked")
	public List<CityHibernate> cityInCountry(String country)
	{
		Query query = session.getNamedQuery(CityHibernate.citiesInCountry).setParameter("name", country);
		return query.list();
	}
}
