package com.crm.dao.impl;

import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.crm.dao.ICustomerDAO;
import com.crm.hibernate.BaseHibernateDAO;
import com.crm.model.Customer;

/**
 * A data access object (DAO) providing persistence and search support for
 * Customer entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.crm.model.Customer
 * @author 
 */

public class CustomerDAO extends BaseHibernateDAO implements ICustomerDAO {
    private static final Logger log = LoggerFactory
	    .getLogger(CustomerDAO.class);
    // property constants
    public static final String NAME = "name";
    public static final String GENDER = "gender";
    public static final String ADDRESS = "address";
    public static final String IS_MARRIED = "isMarried";
    public static final String PHONE = "phone";
    public static final String EMAIL = "email";
    public static final String HAS_HOUSE = "hasHouse";
    public static final String HOUSE_ID = "houseId";
    public static final String HOUSE_INTENT = "houseIntent";
    public static final String INCOME = "income";
    public static final String JOB = "job";
    public static final String HOBBY = "hobby";

    /* (non-Javadoc)
     * @see com.crm.dao.impl.ICustomerDAO#save(com.crm.model.Customer)
     */
    public void save(Customer transientInstance) {
	log.debug("saving Customer instance");
	
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
     * @see com.crm.dao.impl.ICustomerDAO#delete(com.crm.model.Customer)
     */
    public void delete(Customer persistentInstance) {
	log.debug("deleting Customer instance");
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
     * @see com.crm.dao.impl.ICustomerDAO#findById(java.lang.Integer)
     */
    public Customer findById(java.lang.Integer id) {
	log.debug("getting Customer instance with id: " + id);
	try {
	    Customer instance = (Customer) getSession().get(
		    "com.crm.model.Customer", id);
	    return instance;
	} catch (RuntimeException re) {
	    log.error("get failed", re);
	    throw re;
	}
    }

    /* (non-Javadoc)
     * @see com.crm.dao.impl.ICustomerDAO#findByExample(com.crm.model.Customer)
     */
    @SuppressWarnings("unchecked")
    public List<Customer> findByExample(Customer instance) {
	log.debug("finding Customer instance by example");
	try {
	    List<Customer> results = getSession()
		    .createCriteria("com.crm.model.Customer").add(
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
     * @see com.crm.dao.impl.ICustomerDAO#findByProperty(java.lang.String, java.lang.Object)
     */
    @SuppressWarnings("unchecked")
    public List<Customer> findByProperty(String propertyName, Object value) {
	log.debug("finding Customer instance with property: " + propertyName
		+ ", value: " + value);
	try {
	    String queryString = "from Customer as model where model."
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
     * @see com.crm.dao.impl.ICustomerDAO#findByName(java.lang.Object)
     */
    public List<Customer> findByName(Object name) {
	return findByProperty(NAME, name);
    }

    /* (non-Javadoc)
     * @see com.crm.dao.impl.ICustomerDAO#findByGender(java.lang.Object)
     */
    public List<Customer> findByGender(Object gender) {
	return findByProperty(GENDER, gender);
    }

    /* (non-Javadoc)
     * @see com.crm.dao.impl.ICustomerDAO#findByAddress(java.lang.Object)
     */
    public List<Customer> findByAddress(Object address) {
	return findByProperty(ADDRESS, address);
    }

    /* (non-Javadoc)
     * @see com.crm.dao.impl.ICustomerDAO#findByIsMarried(java.lang.Object)
     */
    public List<Customer> findByIsMarried(Object isMarried) {
	return findByProperty(IS_MARRIED, isMarried);
    }

    /* (non-Javadoc)
     * @see com.crm.dao.impl.ICustomerDAO#findByPhone(java.lang.Object)
     */
    public List<Customer> findByPhone(Object phone) {
	return findByProperty(PHONE, phone);
    }

    /* (non-Javadoc)
     * @see com.crm.dao.impl.ICustomerDAO#findByEmail(java.lang.Object)
     */
    public List<Customer> findByEmail(Object email) {
	return findByProperty(EMAIL, email);
    }

    /* (non-Javadoc)
     * @see com.crm.dao.impl.ICustomerDAO#findByHasHouse(java.lang.Object)
     */
    public List<Customer> findByHasHouse(Object hasHouse) {
	return findByProperty(HAS_HOUSE, hasHouse);
    }

    /* (non-Javadoc)
     * @see com.crm.dao.impl.ICustomerDAO#findByHouseId(java.lang.Object)
     */
    public List<Customer> findByHouseId(Object houseId) {
	return findByProperty(HOUSE_ID, houseId);
    }

    /* (non-Javadoc)
     * @see com.crm.dao.impl.ICustomerDAO#findByHouseIntent(java.lang.Object)
     */
    public List<Customer> findByHouseIntent(Object houseIntent) {
	return findByProperty(HOUSE_INTENT, houseIntent);
    }

    /* (non-Javadoc)
     * @see com.crm.dao.impl.ICustomerDAO#findByIncome(java.lang.Object)
     */
    public List<Customer> findByIncome(Object income) {
	return findByProperty(INCOME, income);
    }

    /* (non-Javadoc)
     * @see com.crm.dao.impl.ICustomerDAO#findByJob(java.lang.Object)
     */
    public List<Customer> findByJob(Object job) {
	return findByProperty(JOB, job);
    }

    /* (non-Javadoc)
     * @see com.crm.dao.impl.ICustomerDAO#findByHobby(java.lang.Object)
     */
    public List<Customer> findByHobby(Object hobby) {
	return findByProperty(HOBBY, hobby);
    }

    /* (non-Javadoc)
     * @see com.crm.dao.impl.ICustomerDAO#findAll()
     */
    @SuppressWarnings("unchecked")
    public List<Customer> findAll() {
	log.debug("finding all Customer instances");
	try {
	    String queryString = "from Customer";
	    Query queryObject = getSession().createQuery(queryString);
	    return queryObject.list();
	} catch (RuntimeException re) {
	    log.error("find all failed", re);
	    throw re;
	}
    }

    /* (non-Javadoc)
     * @see com.crm.dao.impl.ICustomerDAO#merge(com.crm.model.Customer)
     */
    public Customer merge(Customer detachedInstance) {
	log.debug("merging Customer instance");
	
	Session session;
	try {
	    session = getSession();
	    session.beginTransaction();
	    Customer result = (Customer) session.merge(detachedInstance);
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
     * @see com.crm.dao.impl.ICustomerDAO#attachDirty(com.crm.model.Customer)
     */
    public void attachDirty(Customer instance) {
	log.debug("attaching dirty Customer instance");
	
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
     * @see com.crm.dao.impl.ICustomerDAO#attachClean(com.crm.model.Customer)
     */
    public void attachClean(Customer instance) {
	log.debug("attaching clean Customer instance");
	
	Session session;
	try {
	    session = getSession();
	    session.beginTransaction();
	    getSession().lock(instance, LockMode.NONE);
	    session.getTransaction().commit();
	    session.close();
	    
	    log.debug("attach successful");
	} catch (RuntimeException re) {
	    log.error("attach failed", re);
	    throw re;
	}
    }
}