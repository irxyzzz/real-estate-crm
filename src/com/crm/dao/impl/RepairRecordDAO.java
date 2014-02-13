package com.crm.dao.impl;

import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.crm.dao.IRepairRecordDAO;
import com.crm.hibernate.BaseHibernateDAO;
import com.crm.model.RepairRecord;

/**
 * A data access object (DAO) providing persistence and search support for
 * RepairRecord entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.crm.model.RepairRecord
 * @author 
 */

public class RepairRecordDAO extends BaseHibernateDAO implements IRepairRecordDAO {
    private static final Logger log = LoggerFactory
	    .getLogger(RepairRecordDAO.class);
    // property constants
    public static final String DECRIPTION = "decription";
    public static final String HANDLE = "handle";
    public static final String IS_VERIFY = "isVerify";
    public static final String NEW_HANDLE = "newHandle";

    /* (non-Javadoc)
     * @see com.crm.dao.impl.IRepairRecordDAO#save(com.crm.model.RepairRecord)
     */
    public void save(RepairRecord transientInstance) {
	log.debug("saving RepairRecord instance");
	
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
     * @see com.crm.dao.impl.IRepairRecordDAO#delete(com.crm.model.RepairRecord)
     */
    public void delete(RepairRecord persistentInstance) {
	log.debug("deleting RepairRecord instance");
	
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
     * @see com.crm.dao.impl.IRepairRecordDAO#findById(java.lang.Integer)
     */
    public RepairRecord findById(java.lang.Integer id) {
	log.debug("getting RepairRecord instance with id: " + id);
	try {
	    RepairRecord instance = (RepairRecord) getSession().get(
		    "com.crm.model.RepairRecord", id);
	    return instance;
	} catch (RuntimeException re) {
	    log.error("get failed", re);
	    throw re;
	}
    }

    /* (non-Javadoc)
     * @see com.crm.dao.impl.IRepairRecordDAO#findByExample(com.crm.model.RepairRecord)
     */
    @SuppressWarnings("unchecked")
    public List<RepairRecord> findByExample(RepairRecord instance) {
	log.debug("finding RepairRecord instance by example");
	try {
	    List<RepairRecord> results = getSession().createCriteria(
		    "com.crm.model.RepairRecord").add(Example.create(instance))
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
     * @see com.crm.dao.impl.IRepairRecordDAO#findByProperty(java.lang.String, java.lang.Object)
     */
    @SuppressWarnings("unchecked")
    public List<RepairRecord> findByProperty(String propertyName, Object value) {
	log.debug("finding RepairRecord instance with property: "
		+ propertyName + ", value: " + value);
	try {
	    String queryString = "from RepairRecord as model where model."
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
     * @see com.crm.dao.impl.IRepairRecordDAO#findByDecription(java.lang.Object)
     */
    public List<RepairRecord> findByDecription(Object decription) {
	return findByProperty(DECRIPTION, decription);
    }

    /* (non-Javadoc)
     * @see com.crm.dao.impl.IRepairRecordDAO#findByHandle(java.lang.Object)
     */
    public List<RepairRecord> findByHandle(Object handle) {
	return findByProperty(HANDLE, handle);
    }

    /* (non-Javadoc)
     * @see com.crm.dao.impl.IRepairRecordDAO#findByIsVerify(java.lang.Object)
     */
    public List<RepairRecord> findByIsVerify(Object isVerify) {
	return findByProperty(IS_VERIFY, isVerify);
    }

    /* (non-Javadoc)
     * @see com.crm.dao.impl.IRepairRecordDAO#findByNewHandle(java.lang.Object)
     */
    public List<RepairRecord> findByNewHandle(Object newHandle) {
	return findByProperty(NEW_HANDLE, newHandle);
    }

    /* (non-Javadoc)
     * @see com.crm.dao.impl.IRepairRecordDAO#findAll()
     */
    @SuppressWarnings("unchecked")
    public List<RepairRecord> findAll() {
	log.debug("finding all RepairRecord instances");
	try {
	    String queryString = "from RepairRecord";
	    Query queryObject = getSession().createQuery(queryString);
	    return queryObject.list();
	} catch (RuntimeException re) {
	    log.error("find all failed", re);
	    throw re;
	}
    }

    /* (non-Javadoc)
     * @see com.crm.dao.impl.IRepairRecordDAO#merge(com.crm.model.RepairRecord)
     */
    public RepairRecord merge(RepairRecord detachedInstance) {
	log.debug("merging RepairRecord instance");
	
	Session session;
	try {
	    session = getSession();
	    session.beginTransaction();
	    RepairRecord result = (RepairRecord) session.merge(
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
     * @see com.crm.dao.impl.IRepairRecordDAO#attachDirty(com.crm.model.RepairRecord)
     */
    public void attachDirty(RepairRecord instance) {
	log.debug("attaching dirty RepairRecord instance");
	
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
     * @see com.crm.dao.impl.IRepairRecordDAO#attachClean(com.crm.model.RepairRecord)
     */
    public void attachClean(RepairRecord instance) {
	log.debug("attaching clean RepairRecord instance");
	
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