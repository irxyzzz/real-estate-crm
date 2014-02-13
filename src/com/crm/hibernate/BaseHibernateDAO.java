package com.crm.hibernate;

import org.hibernate.Session;


/**
 * Data access object (DAO) for domain model
 * @author
 */
public class BaseHibernateDAO implements IBaseHibernateDAO {
	
	public Session getSession() {
		return HibernateSessionFactory.getSession();
	}
	
}