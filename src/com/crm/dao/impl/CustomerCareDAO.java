package com.crm.dao.impl;

import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.crm.dao.ICustomerCareDAO;
import com.crm.hibernate.BaseHibernateDAO;
import com.crm.model.CustomerCare;

/**
 * A data access object (DAO) providing persistence and search support for
 * CareActivity entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.crm.model.CustomerCare
 * @author 
 */

public class CustomerCareDAO extends BaseHibernateDAO implements ICustomerCareDAO {
    private static final Logger log = LoggerFactory
	    .getLogger(CustomerCareDAO.class);
    // property constants
    public static final String TITLE = "title";
    public static final String DECRIPTION = "decription";
    public static final String FORM = "form";
    public static final String CUSTOMER_TYPE = "customerType";

    /* (non-Javadoc)
     * @see com.crm.dao.impl.ICustomerCareDAO#save(com.crm.model.CustomerCare)
     */
    public void save(CustomerCare transientInstance) {
	log.debug("saving CareActivity instance");
	
	Session session;
	try {
	    session = getSession();
	    session.beginTransaction();
	    session.save(transientInstance);
	    session.getTransaction().commit();
	    session.close();
	    log.debug("save successful");
	} catch (RuntimeException re) {
	    log.error("save failed", re);
	    throw re;
	}
    }

    /* (non-Javadoc)
     * @see com.crm.dao.impl.ICustomerCareDAO#delete(com.crm.model.CustomerCare)
     */
    public void delete(CustomerCare persistentInstance) {
	log.debug("deleting CustomerCare instance");
	Session session;
	try {
	    session = getSession();
	    session.beginTransaction();
	    session.delete(persistentInstance);
	    session.getTransaction().commit();
	    session.close();
	    log.debug("delete successful");
	} catch (RuntimeException re) {
	    log.error("delete failed", re);
	    throw re;
	}
    }

    /* (non-Javadoc)
     * @see com.crm.dao.impl.ICustomerCareDAO#findById(java.lang.Integer)
     */
    public CustomerCare findById(java.lang.Integer id) {
	log.debug("getting CustomerCare instance with id: " + id);
	Session session;
	try {
	    session = getSession();
	    session.beginTransaction();
	    CustomerCare instance = (CustomerCare) session.get(
		    "com.crm.model.CustomerCare", id);
	    session.getTransaction().commit();
	    session.close();
	    return instance;
	} catch (RuntimeException re) {
	    log.error("get failed", re);
	    throw re;
	}
    }

    /* (non-Javadoc)
     * @see com.crm.dao.impl.ICustomerCareDAO#findByExample(com.crm.model.CustomerCare)
     */
    @SuppressWarnings("unchecked")
    public List<CustomerCare> findByExample(CustomerCare instance) {
	log.debug("finding CustomerCare instance by example");
	try {
	    List<CustomerCare> results = getSession().createCriteria(
		    "com.crm.model.CustomerCare").add(Example.create(instance))
		    .list();
	    log.debug("find by example successful, result size: "
		    + results.size());
	    return results;
	} catch (RuntimeException re) {
	    log.error("find by example failed", re);
	    throw re;
	}
    }

    /* (non-Javadoc)
     * @see com.crm.dao.impl.ICustomerCareDAO#findByProperty(java.lang.String, java.lang.Object)
     */
    @SuppressWarnings("unchecked")
    public List<CustomerCare> findByProperty(String propertyName, Object value) {
	log.debug("finding CustomerCare instance with property: "
		+ propertyName + ", value: " + value);
	try {
	    String queryString = "from CustomerCare as model where model."
		    + propertyName + "= ?";
	    Query queryObject = getSession().createQuery(queryString);
	    queryObject.setParameter(0, value);
	    return queryObject.list();
	} catch (RuntimeException re) {
	    log.error("find by property name failed", re);
	    throw re;
	}
    }

    /* (non-Javadoc)
     * @see com.crm.dao.impl.ICustomerCareDAO#findByTitle(java.lang.Object)
     */
    public List<CustomerCare> findByTitle(Object title) {
	return findByProperty(TITLE, title);
    }

    /* (non-Javadoc)
     * @see com.crm.dao.impl.ICustomerCareDAO#findByDecription(java.lang.Object)
     */
    public List<CustomerCare> findByDecription(Object decription) {
	return findByProperty(DECRIPTION, decription);
    }

    /* (non-Javadoc)
     * @see com.crm.dao.impl.ICustomerCareDAO#findByForm(java.lang.Object)
     */
    public List<CustomerCare> findByForm(Object form) {
	return findByProperty(FORM, form);
    }

    /* (non-Javadoc)
     * @see com.crm.dao.impl.ICustomerCareDAO#findByCustomerType(java.lang.Object)
     */
    public List<CustomerCare> findByCustomerType(Object customerType) {
	return findByProperty(CUSTOMER_TYPE, customerType);
    }

    /* (non-Javadoc)
     * @see com.crm.dao.impl.ICustomerCareDAO#findAll()
     */
    @SuppressWarnings("unchecked")
    public List<CustomerCare> findAll() {
	log.debug("finding all CustomerCare instances");
	try {
	    String queryString = "from CustomerCare";
	    Query queryObject = getSession().createQuery(queryString);
	    return queryObject.list();
	} catch (RuntimeException re) {
	    log.error("find all failed", re);
	    throw re;
	}
    }

    /* (non-Javadoc)
     * @see com.crm.dao.impl.ICustomerCareDAO#merge(com.crm.model.CustomerCare)
     */
    public CustomerCare merge(CustomerCare detachedInstance) {
	log.debug("merging CustomerCare instance");
	
	Session session;
	try {
	    session = getSession();
	    session.beginTransaction();
	    CustomerCare result = (CustomerCare) session.merge(
		    detachedInstance);
	    session.getTransaction().commit();
	    session.close();
	    log.debug("merge successful");
	    return result;
	} catch (RuntimeException re) {
	    log.error("merge failed", re);
	    throw re;
	}
    }

    /* (non-Javadoc)
     * @see com.crm.dao.impl.ICustomerCareDAO#attachDirty(com.crm.model.CustomerCare)
     */
    public void attachDirty(CustomerCare instance) {
	log.debug("attaching dirty CustomerCare instance");
	Session session;
	try {
	    session = getSession();
	    session.beginTransaction();
	    session.saveOrUpdate(instance);
	    session.getTransaction().commit();
	    session.close();
	    
	    log.debug("attach successful");
	} catch (RuntimeException re) {
	    log.error("attach failed", re);
	    throw re;
	}
    }

    /* (non-Javadoc)
     * @see com.crm.dao.impl.ICustomerCareDAO#attachClean(com.crm.model.CustomerCare)
     */
    public void attachClean(CustomerCare instance) {
	log.debug("attaching clean CustomerCare instance");
	
	Session session;
	try {
	    session = getSession();
	    session.beginTransaction();
	    session.lock(instance, LockMode.NONE);
	    session.getTransaction().commit();
	    session.close();
	    
	    log.debug("attach successful");
	} catch (RuntimeException re) {
	    log.error("attach failed", re);
	    throw re;
	}
    }
}