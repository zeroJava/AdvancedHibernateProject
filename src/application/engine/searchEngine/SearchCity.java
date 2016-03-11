package application.engine.searchEngine;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import application.dataClass.CityHibernate;

public class SearchCity
{
	//private Session session;
	
	public SearchCity()
	{
		//this.session = session;
	}

	public CityHibernate cityWithID(Session session, int id)
	{
		Query query = session.getNamedQuery(CityHibernate.cityWithId).setInteger("cityID", id); 
		return (CityHibernate) query.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<CityHibernate> cityWithName(Session session, String name)
	{
		Query query = session.getNamedQuery(CityHibernate.cityWithName).setParameter("name", name);
		return query.list();
	}

	@SuppressWarnings("unchecked")
	public List<CityHibernate> cityInCountry(Session session, String country)
	{
		Query query = session.getNamedQuery(CityHibernate.citiesInCountry).setParameter("name", country);
		return query.list();
	}
}
