package application.engine.updateEngine;

import org.hibernate.Session;

public abstract class Updateengine
{
	public void setUpdate(Session session)
	{
		System.out.println("In update engine class, beginnig update");
		session.update(getData());
		System.out.println("In update engine class, update complete");
	}
	
	public abstract Object getData();
}
