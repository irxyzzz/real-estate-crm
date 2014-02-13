package com.crm.hibernate;

import org.hibernate.Session;


/**
 * Data access interface for domain model
 * @author 
 */
public interface IBaseHibernateDAO {
	public Session getSession();
}