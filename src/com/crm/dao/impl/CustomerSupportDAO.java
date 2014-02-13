package com.crm.dao.impl;

import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.crm.dao.ICustomerSupportDAO;
import com.crm.hibernate.BaseHibernateDAO;
import com.crm.model.CustomerSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * CustomerConnection entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.crm.model.CustomerSupport
 * @author 

 */

public class CustomerSupportDAO extends BaseHibernateDAO implements ICustomerSupportDAO {
    private static final Logger log = LoggerFactory
	    .getLogger(CustomerSupportDAO.class);
    // property constants
    public static final String CONTENT = "content";
    public static final String REPLY = "reply";

    /* (non-Javadoc)
     * @see com.crm.dao.impl.ICustomerSupportDAO#save(com.crm.model.CustomerSupport)
     */
    public void save(CustomerSupport transientInstance) {
	log.debug("saving CustomerConnection instance");
	
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
     * @see com.crm.dao.impl.ICustomerSupportDAO#delete(com.crm.model.CustomerSupport)
     */
    public void delete(CustomerSupport persistentInstance) {
	log.debug("deleting CustomerConnection instance");
	
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
     * @see com.crm.dao.impl.ICustomerSupportDAO#findById(java.lang.Integer)
     */
    public CustomerSupport findById(java.lang.Integer id) {
	log.debug("getting CustomerSupport instance with id: " + id);
	try {
	    CustomerSupport instance = (CustomerSupport) getSession()
		    .get("com.crm.model.CustomerSupport", id);
	    return instance;
	} catch (RuntimeException re) {
	    log.error("get failed", re);
	    throw re;
	}
    }

    /* (non-Javadoc)
     * @see com.crm.dao.impl.ICustomerSupportDAO#findByExample(com.crm.model.CustomerSupport)
     */
    @SuppressWarnings("unchecked")
    public List<CustomerSupport> findByExample(CustomerSupport instance) {
	log.debug("finding CustomerSupport instance by example");
	try {
	    List<CustomerSupport> results = getSession().createCriteria(
		    "com.crm.model.CustomerSupport").add(
		    Example.create(instance)).list();
	    log.debug("find by example successful, result size: "
		    + results.size());
	    return results;
	} catch (RuntimeException re) {
	    log.error("find by example failed", re);
	    throw re;
	}
    }

    /* (non-Javadoc)
     * @see com.crm.dao.impl.ICustomerSupportDAO#findByProperty(java.lang.String, java.lang.Object)
     */
    @SuppressWarnings("unchecked")
    public List<CustomerSupport> findByProperty(String propertyName, Object value) {
	log.debug("finding CustomerSupport instance with property: "
		+ propertyName + ", value: " + value);
	try {
	    String queryString = "from CustomerSupport as model where model."
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
     * @see com.crm.dao.impl.ICustomerSupportDAO#findByContent(java.lang.Object)
     */
    public List<CustomerSupport> findByContent(Object content) {
	return findByProperty(CONTENT, content);
    }

    /* (non-Javadoc)
     * @see com.crm.dao.impl.ICustomerSupportDAO#findByReply(java.lang.Object)
     */
    public List<CustomerSupport> findByReply(Object reply) {
	return findByProperty(REPLY, reply);
    }

    /* (non-Javadoc)
     * @see com.crm.dao.impl.ICustomerSupportDAO#findAll()
     */
    @SuppressWarnings("unchecked")
    public List<CustomerSupport> findAll() {
	log.debug("finding all CustomerSupport instances");
	try {
	    String queryString = "from CustomerSupport";
	    Query queryObject = getSession().createQuery(queryString);
	    return queryObject.list();
	} catch (RuntimeException re) {
	    log.error("find all failed", re);
	    throw re;
	}
    }

    /* (non-Javadoc)
     * @see com.crm.dao.impl.ICustomerSupportDAO#merge(com.crm.model.CustomerSupport)
     */
    public CustomerSupport merge(CustomerSupport detachedInstance) {
	log.debug("merging CustomerSupport instance");
	
	Session session;
	try {
	    session = getSession();
	    session.beginTransaction();
	    CustomerSupport result = (CustomerSupport) session
		    .merge(detachedInstance);
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
     * @see com.crm.dao.impl.ICustomerSupportDAO#attachDirty(com.crm.model.CustomerSupport)
     */
    public void attachDirty(CustomerSupport instance) {
	log.debug("attaching dirty CustomerSupport instance");
	

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
     * @see com.crm.dao.impl.ICustomerSupportDAO#attachClean(com.crm.model.CustomerSupport)
     */
    public void attachClean(CustomerSupport instance) {
	log.debug("attaching clean CustomerSupport instance");
	
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