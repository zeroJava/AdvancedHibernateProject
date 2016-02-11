package application.engine.searchEngine;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import application.dataClass.ClientHibernate;

public class SearchClient
{
	private Session session;
	
	public SearchClient(Session session)
	{
		this.session = session;
	}
	
	@SuppressWarnings("unchecked")
	public List<ClientHibernate> clientWithID(int id)
	{
		Query query = session.getNamedQuery(ClientHibernate.clientwithID).setInteger("ID", id);
		return query.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<ClientHibernate> clientsWithNames(String firstname, String lastname)
	{
		/* Criteria criteria = session.createCriteria(ClientHibernate.class, "client");
		criteria.add(Restrictions.eq("client.firstName", firstname)); // Restrictions.eq means equals
		criteria.add(Restrictions.eq("client.lastName", lastname));*/
		
		Query query = session.getNamedQuery(ClientHibernate.clientWithNames).setParameter("firstName", firstname)
				.setParameter("lastName", lastname);
		return query.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<ClientHibernate> clientsLivingInCity(String city)
	{
		Criteria criteria = session.createCriteria(ClientHibernate.class, "client");
		criteria.createAlias("client.cityID", "city");
		//criteria.createAlias("city.name", "cityname");
		criteria.add(Restrictions.eq("city.name", city));
		
		//Query query = session.getNamedQuery(ClientHibernate.clientLivingInCity).setParameter("name", city);	
		
		return criteria.list();
	}
}
