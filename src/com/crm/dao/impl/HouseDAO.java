package com.crm.dao.impl;

import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.crm.dao.IHouseDAO;
import com.crm.hibernate.BaseHibernateDAO;
import com.crm.model.House;

/**
 * A data access object (DAO) providing persistence and search support for House
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.crm.model.House
 * @author 
 */

public class HouseDAO extends BaseHibernateDAO implements IHouseDAO {
    private static final Logger log = LoggerFactory.getLogger(HouseDAO.class);
    // property constants
    public static final String AREA = "area";
    public static final String POSITION = "position";
    public static final String PRICE = "price";
    public static final String IS_SALE = "isSale";
    public static final String CUSTOMER_ID = "customerId";

    /* (non-Javadoc)
     * @see com.crm.dao.impl.IHouseDAO#save(com.crm.model.House)
     */
    public void save(House transientInstance) {
	log.debug("saving House instance");
	
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
     * @see com.crm.dao.impl.IHouseDAO#delete(com.crm.model.House)
     */
    public void delete(House persistentInstance) {
	log.debug("deleting House instance");
	
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
     * @see com.crm.dao.impl.IHouseDAO#findById(java.lang.Integer)
     */
    public House findById(java.lang.Integer id) {
	log.debug("getting House instance with id: " + id);
	try {
	    House instance = (House) getSession()
		    .get("com.crm.model.House", id);
	    return instance;
	} catch (RuntimeException re) {
	    log.error("get failed", re);
	    throw re;
	}
    }

    /* (non-Javadoc)
     * @see com.crm.dao.impl.IHouseDAO#findByExample(com.crm.model.House)
     */
    @SuppressWarnings("unchecked")
    public List<House> findByExample(House instance) {
	log.debug("finding House instance by example");
	try {
	    List<House> results = getSession().createCriteria("com.crm.model.House")
		    .add(Example.create(instance)).list();
	    log.debug("find by example successful, result size: "
		    + results.size());
	    return results;
	} catch (RuntimeException re) {
	    log.error("find by example failed", re);
	    throw re;
	}
    }

    /* (non-Javadoc)
     * @see com.crm.dao.impl.IHouseDAO#findByProperty(java.lang.String, java.lang.Object)
     */
    @SuppressWarnings("unchecked")
    public List<House> findByProperty(String propertyName, Object value) {
	log.debug("finding House instance with property: " + propertyName
		+ ", value: " + value);
	try {
	    String queryString = "from House as model where model."
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
     * @see com.crm.dao.impl.IHouseDAO#findByArea(java.lang.Object)
     */
    public List<House>  findByArea(Object area) {
	return findByProperty(AREA, area);
    }

    /* (non-Javadoc)
     * @see com.crm.dao.impl.IHouseDAO#findByPosition(java.lang.Object)
     */
    public List<House> findByPosition(Object position) {
	return findByProperty(POSITION, position);
    }

    /* (non-Javadoc)
     * @see com.crm.dao.impl.IHouseDAO#findByPrice(java.lang.Object)
     */
    public List<House> findByPrice(Object price) {
	return findByProperty(PRICE, price);
    }

    /* (non-Javadoc)
     * @see com.crm.dao.impl.IHouseDAO#findByIsSale(java.lang.Object)
     */
    public List<House> findByIsSale(Object isSale) {
	return findByProperty(IS_SALE, isSale);
    }

    /* (non-Javadoc)
     * @see com.crm.dao.impl.IHouseDAO#findByCustomerId(java.lang.Object)
     */
    public List<House> findByCustomerId(Object customerId) {
	return findByProperty(CUSTOMER_ID, customerId);
    }

    /* (non-Javadoc)
     * @see com.crm.dao.impl.IHouseDAO#findAll()
     */
    @SuppressWarnings("unchecked")
    public List<House> findAll() {
	log.debug("finding all House instances");
	try {
	    String queryString = "from House";
	    Query queryObject = getSession().createQuery(queryString);
	    return queryObject.list();
	} catch (RuntimeException re) {
	    log.error("find all failed", re);
	    throw re;
	}
    }

    /* (non-Javadoc)
     * @see com.crm.dao.impl.IHouseDAO#merge(com.crm.model.House)
     */
    public House merge(House detachedInstance) {
	log.debug("merging House instance");
	
	Session session;
	try {
	    session = getSession();
	    session.beginTransaction();
	    House result = (House) session.merge(detachedInstance);
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
     * @see com.crm.dao.impl.IHouseDAO#attachDirty(com.crm.model.House)
     */
    public void attachDirty(House instance) {
	log.debug("attaching dirty House instance");
	
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
     * @see com.crm.dao.impl.IHouseDAO#attachClean(com.crm.model.House)
     */
    public void attachClean(House instance) {
	log.debug("attaching clean House instance");
	
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