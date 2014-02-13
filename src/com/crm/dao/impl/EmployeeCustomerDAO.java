package com.crm.dao.impl;

import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.crm.dao.IEmployeeCustomerDAO;
import com.crm.hibernate.BaseHibernateDAO;
import com.crm.model.EmployeeCustomer;

/**
 * A data access object (DAO) providing persistence and search support for
 * EmployeeCustomerList entities. Transaction control of the save(), update()
 * and delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.crm.model.EmployeeCustomer
 * @author 
 */

public class EmployeeCustomerDAO extends BaseHibernateDAO implements IEmployeeCustomerDAO {
    private static final Logger log = LoggerFactory
	    .getLogger(EmployeeCustomerDAO.class);

    // property constants

    /* (non-Javadoc)
     * @see com.crm.dao.impl.IEmployeeCustomerDAO#save(com.crm.model.EmployeeCustomer)
     */
    public void save(EmployeeCustomer transientInstance) {
	log.debug("saving EmployeeCustomerList instance");
	
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
     * @see com.crm.dao.impl.IEmployeeCustomerDAO#delete(com.crm.model.EmployeeCustomer)
     */
    public void delete(EmployeeCustomer persistentInstance) {
	log.debug("deleting EmployeeCustomerList instance");
	
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
     * @see com.crm.dao.impl.IEmployeeCustomerDAO#findById(java.lang.Integer)
     */
    public EmployeeCustomer findById(java.lang.Integer id) {
	log.debug("getting EmployeeCustomerList instance with id: " + id);
	try {
	    EmployeeCustomer instance = (EmployeeCustomer) getSession()
		    .get("com.crm.model.EmployeeCustomer", id);
	    return instance;
	} catch (RuntimeException re) {
	    log.error("get failed", re);
	    throw re;
	}
    }

    /* (non-Javadoc)
     * @see com.crm.dao.impl.IEmployeeCustomerDAO#findByExample(com.crm.model.EmployeeCustomer)
     */
    @SuppressWarnings("unchecked")
    public List<EmployeeCustomer> findByExample(EmployeeCustomer instance) {
	log.debug("finding EmployeeCustomer instance by example");
	try {
	    List<EmployeeCustomer> results = getSession().createCriteria(
		    "com.crm.model.EmployeeCustomer").add(
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
     * @see com.crm.dao.impl.IEmployeeCustomerDAO#findByProperty(java.lang.String, java.lang.Object)
     */
    @SuppressWarnings("unchecked")
    public List<EmployeeCustomer> findByProperty(String propertyName, Object value) {
	log.debug("finding EmployeeCustomer instance with property: "
		+ propertyName + ", value: " + value);
	try {
	    String queryString = "from EmployeeCustomer as model where model."
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
     * @see com.crm.dao.impl.IEmployeeCustomerDAO#findAll()
     */
    @SuppressWarnings("unchecked")
    public List<EmployeeCustomer> findAll() {
	log.debug("finding all EmployeeCustomer instances");
	try {
	    String queryString = "from EmployeeCustomer";
	    Query queryObject = getSession().createQuery(queryString);
	    return queryObject.list();
	} catch (RuntimeException re) {
	    log.error("find all failed", re);
	    throw re;
	}
    }

    /* (non-Javadoc)
     * @see com.crm.dao.impl.IEmployeeCustomerDAO#merge(com.crm.model.EmployeeCustomer)
     */
    public EmployeeCustomer merge(EmployeeCustomer detachedInstance) {
	log.debug("merging EmployeeCustomer instance");
	
	Session session;
	try {
	    session = getSession();
	    session.beginTransaction();
	    EmployeeCustomer result = (EmployeeCustomer) session
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
     * @see com.crm.dao.impl.IEmployeeCustomerDAO#attachDirty(com.crm.model.EmployeeCustomer)
     */
    public void attachDirty(EmployeeCustomer instance) {
	log.debug("attaching dirty EmployeeCustomer instance");
	
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
     * @see com.crm.dao.impl.IEmployeeCustomerDAO#attachClean(com.crm.model.EmployeeCustomer)
     */
    public void attachClean(EmployeeCustomer instance) {
	log.debug("attaching clean EmployeeCustomer instance");
	

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