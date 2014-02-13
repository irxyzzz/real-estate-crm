package com.crm.dao.impl;

import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.crm.dao.IResidenceCommunityDAO;
import com.crm.hibernate.BaseHibernateDAO;
import com.crm.model.ResidenceCommunity;

/**
 * A data access object (DAO) providing persistence and search support for
 * ResidenceCommunity entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.crm.model.ResidenceCommunity
 * @author 
 */

public class ResidenceCommunityDAO extends BaseHibernateDAO implements IResidenceCommunityDAO {
    private static final Logger log = LoggerFactory
	    .getLogger(ResidenceCommunityDAO.class);
    // property constants
    public static final String NAME = "name";
    public static final String ADDRESS = "address";
    public static final String AREA = "area";
    public static final String TYPE = "type";
    public static final String DESCRIPTION = "description";

    /* (non-Javadoc)
     * @see com.crm.dao.impl.IResidenceCommunityDAO#save(com.crm.model.ResidenceCommunity)
     */
    public void save(ResidenceCommunity transientInstance) {
	log.debug("saving ResidenceCommunity instance");
	
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
     * @see com.crm.dao.impl.IResidenceCommunityDAO#delete(com.crm.model.ResidenceCommunity)
     */
    public void delete(ResidenceCommunity persistentInstance) {
	log.debug("deleting ResidenceCommunity instance");
	
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
     * @see com.crm.dao.impl.IResidenceCommunityDAO#findById(java.lang.Integer)
     */
    public ResidenceCommunity findById(java.lang.Integer id) {
	log.debug("getting ResidenceCommunity instance with id: " + id);
	try {
	    ResidenceCommunity instance = (ResidenceCommunity) getSession()
		    .get("com.crm.model.ResidenceCommunity", id);
	    return instance;
	} catch (RuntimeException re) {
	    log.error("get failed", re);
	    throw re;
	}
    }

    /* (non-Javadoc)
     * @see com.crm.dao.impl.IResidenceCommunityDAO#findByExample(com.crm.model.ResidenceCommunity)
     */
    @SuppressWarnings("unchecked")
    public List<ResidenceCommunity> findByExample(ResidenceCommunity instance) {
	log.debug("finding ResidenceCommunity instance by example");
	try {
	    List<ResidenceCommunity> results = getSession().createCriteria(
		    "com.crm.model.ResidenceCommunity").add(
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
     * @see com.crm.dao.impl.IResidenceCommunityDAO#findByProperty(java.lang.String, java.lang.Object)
     */
    @SuppressWarnings("unchecked")
    public List<ResidenceCommunity> findByProperty(String propertyName, Object value) {
	log.debug("finding ResidenceCommunity instance with property: "
		+ propertyName + ", value: " + value);
	try {
	    String queryString = "from ResidenceCommunity as model where model."
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
     * @see com.crm.dao.impl.IResidenceCommunityDAO#findByName(java.lang.Object)
     */
    public List<ResidenceCommunity> findByName(Object name) {
	return findByProperty(NAME, name);
    }

    /* (non-Javadoc)
     * @see com.crm.dao.impl.IResidenceCommunityDAO#findByAddress(java.lang.Object)
     */
    public List<ResidenceCommunity> findByAddress(Object address) {
	return findByProperty(ADDRESS, address);
    }

    /* (non-Javadoc)
     * @see com.crm.dao.impl.IResidenceCommunityDAO#findByArea(java.lang.Object)
     */
    public List<ResidenceCommunity> findByArea(Object area) {
	return findByProperty(AREA, area);
    }

    /* (non-Javadoc)
     * @see com.crm.dao.impl.IResidenceCommunityDAO#findByType(java.lang.Object)
     */
    public List<ResidenceCommunity> findByType(Object type) {
	return findByProperty(TYPE, type);
    }

    /* (non-Javadoc)
     * @see com.crm.dao.impl.IResidenceCommunityDAO#findByDescription(java.lang.Object)
     */
    public List<ResidenceCommunity> findByDescription(Object description) {
	return findByProperty(DESCRIPTION, description);
    }

    /* (non-Javadoc)
     * @see com.crm.dao.impl.IResidenceCommunityDAO#findAll()
     */
    @SuppressWarnings("unchecked")
    public List<ResidenceCommunity> findAll() {
	log.debug("finding all ResidenceCommunity instances");
	try {
	    String queryString = "from ResidenceCommunity";
	    Query queryObject = getSession().createQuery(queryString);
	    return queryObject.list();
	} catch (RuntimeException re) {
	    log.error("find all failed", re);
	    throw re;
	}
    }

    /* (non-Javadoc)
     * @see com.crm.dao.impl.IResidenceCommunityDAO#merge(com.crm.model.ResidenceCommunity)
     */
    public ResidenceCommunity merge(ResidenceCommunity detachedInstance) {
	log.debug("merging ResidenceCommunity instance");
	
	Session session;
	try {
	    session = getSession();
	    session.beginTransaction();
	    ResidenceCommunity result = (ResidenceCommunity) session
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
     * @see com.crm.dao.impl.IResidenceCommunityDAO#attachDirty(com.crm.model.ResidenceCommunity)
     */
    public void attachDirty(ResidenceCommunity instance) {
	log.debug("attaching dirty ResidenceCommunity instance");
	
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
     * @see com.crm.dao.impl.IResidenceCommunityDAO#attachClean(com.crm.model.ResidenceCommunity)
     */
    public void attachClean(ResidenceCommunity instance) {
	log.debug("attaching clean ResidenceCommunity instance");
	
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