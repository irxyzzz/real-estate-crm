package com.crm.dao.impl;

import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.crm.dao.ICustomerFeedbackDAO;
import com.crm.hibernate.BaseHibernateDAO;
import com.crm.model.CustomerFeedback;

/**
 * A data access object (DAO) providing persistence and search support for
 * CustomerFeedback entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.crm.model.CustomerFeedback
 * @author 
 */

public class CustomerFeedbackDAO extends BaseHibernateDAO implements ICustomerFeedbackDAO {
    private static final Logger log = LoggerFactory
	    .getLogger(CustomerFeedbackDAO.class);
    // property constants
    public static final String MARK_SELLER = "markSeller";
    public static final String ADVICE_SELLER = "adviceSeller";
    public static final String MARK_ENVIRONMENT = "markEnvironment";
    public static final String MARK_TENEMENT = "markTenement";
    public static final String MARK_TRAFFIC = "markTraffic";
    public static final String MARK_ALL = "markAll";

    /* (non-Javadoc)
     * @see com.crm.dao.impl.ICustomerFeedbackDAO#save(com.crm.model.CustomerFeedback)
     */
    public void save(CustomerFeedback transientInstance) {
	log.debug("saving CustomerFeedback instance");
	
	Session session;
	try {
	    session = getSession();
	    session.beginTransaction();
	    getSession().save(transientInstance);
	    session.getTransaction().commit();
	    session.close();
	    
	    log.debug("save successful");
	} catch (RuntimeException re) {
	    log.error("save failed", re);
	    throw re;
	}
    }

    /* (non-Javadoc)
     * @see com.crm.dao.impl.ICustomerFeedbackDAO#delete(com.crm.model.CustomerFeedback)
     */
    public void delete(CustomerFeedback persistentInstance) {
	log.debug("deleting CustomerFeedback instance");
	
	Session session;
	try {
	    session = getSession();
	    session.beginTransaction();
	    getSession().delete(persistentInstance);
	    session.getTransaction().commit();
	    session.close();
	    
	    log.debug("delete successful");
	} catch (RuntimeException re) {
	    log.error("delete failed", re);
	    throw re;
	}
    }

    /* (non-Javadoc)
     * @see com.crm.dao.impl.ICustomerFeedbackDAO#findById(java.lang.Integer)
     */
    public CustomerFeedback findById(java.lang.Integer id) {
	log.debug("getting CustomerFeedback instance with id: " + id);
	try {
	    CustomerFeedback instance = (CustomerFeedback) getSession().get(
		    "com.crm.model.CustomerFeedback", id);
	    return instance;
	} catch (RuntimeException re) {
	    log.error("get failed", re);
	    throw re;
	}
    }

    /* (non-Javadoc)
     * @see com.crm.dao.impl.ICustomerFeedbackDAO#findByExample(com.crm.model.CustomerFeedback)
     */
    @SuppressWarnings("unchecked")
    public List<CustomerFeedback> findByExample(CustomerFeedback instance) {
	log.debug("finding CustomerFeedback instance by example");
	try {
	    List<CustomerFeedback> results = getSession().createCriteria(
		    "com.crm.model.CustomerFeedback").add(
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
     * @see com.crm.dao.impl.ICustomerFeedbackDAO#findByProperty(java.lang.String, java.lang.Object)
     */
    @SuppressWarnings("unchecked")
    public List<CustomerFeedback> findByProperty(String propertyName, Object value) {
	log.debug("finding CustomerFeedback instance with property: "
		+ propertyName + ", value: " + value);
	try {
	    String queryString = "from CustomerFeedback as model where model."
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
     * @see com.crm.dao.impl.ICustomerFeedbackDAO#findByMarkSeller(java.lang.Object)
     */
    public List<CustomerFeedback> findByMarkSeller(Object markSeller) {
	return findByProperty(MARK_SELLER, markSeller);
    }

    /* (non-Javadoc)
     * @see com.crm.dao.impl.ICustomerFeedbackDAO#findByAdviceSeller(java.lang.Object)
     */
    public List<CustomerFeedback> findByAdviceSeller(Object adviceSeller) {
	return findByProperty(ADVICE_SELLER, adviceSeller);
    }

    /* (non-Javadoc)
     * @see com.crm.dao.impl.ICustomerFeedbackDAO#findByMarkEnvironment(java.lang.Object)
     */
    public List<CustomerFeedback> findByMarkEnvironment(Object markEnvironment) {
	return findByProperty(MARK_ENVIRONMENT, markEnvironment);
    }

    /* (non-Javadoc)
     * @see com.crm.dao.impl.ICustomerFeedbackDAO#findByMarkTenement(java.lang.Object)
     */
    public List<CustomerFeedback> findByMarkTenement(Object markTenement) {
	return findByProperty(MARK_TENEMENT, markTenement);
    }

    /* (non-Javadoc)
     * @see com.crm.dao.impl.ICustomerFeedbackDAO#findByMarkTraffic(java.lang.Object)
     */
    public List<CustomerFeedback> findByMarkTraffic(Object markTraffic) {
	return findByProperty(MARK_TRAFFIC, markTraffic);
    }

    /* (non-Javadoc)
     * @see com.crm.dao.impl.ICustomerFeedbackDAO#findByMarkAll(java.lang.Object)
     */
    public List<CustomerFeedback> findByMarkAll(Object markAll) {
	return findByProperty(MARK_ALL, markAll);
    }

    /* (non-Javadoc)
     * @see com.crm.dao.impl.ICustomerFeedbackDAO#findAll()
     */
    @SuppressWarnings("unchecked")
    public List<CustomerFeedback> findAll() {
	log.debug("finding all CustomerFeedback instances");
	try {
	    String queryString = "from CustomerFeedback";
	    Query queryObject = getSession().createQuery(queryString);
	    return queryObject.list();
	} catch (RuntimeException re) {
	    log.error("find all failed", re);
	    throw re;
	}
    }

    /* (non-Javadoc)
     * @see com.crm.dao.impl.ICustomerFeedbackDAO#merge(com.crm.model.CustomerFeedback)
     */
    public CustomerFeedback merge(CustomerFeedback detachedInstance) {
	log.debug("merging CustomerFeedback instance");
	
	Session session;
	try {
	    session = getSession();
	    session.beginTransaction();
	    CustomerFeedback result = (CustomerFeedback) session.merge(
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
     * @see com.crm.dao.impl.ICustomerFeedbackDAO#attachDirty(com.crm.model.CustomerFeedback)
     */
    public void attachDirty(CustomerFeedback instance) {
	log.debug("attaching dirty CustomerFeedback instance");
	
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
     * @see com.crm.dao.impl.ICustomerFeedbackDAO#attachClean(com.crm.model.CustomerFeedback)
     */
    public void attachClean(CustomerFeedback instance) {
	log.debug("attaching clean CustomerFeedback instance");
	
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