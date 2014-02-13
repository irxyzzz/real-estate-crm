package com.crm.dao.impl;

import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.crm.dao.IAssignmentDAO;
import com.crm.hibernate.BaseHibernateDAO;
import com.crm.model.Assignment;

/**
 * A data access object (DAO) providing persistence and search support for Task
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.crm.model.Assignment
 * @author 
 */

public class AssignmentDAO extends BaseHibernateDAO implements IAssignmentDAO {
    private static final Logger log = LoggerFactory.getLogger(AssignmentDAO.class);
    // property constants
    public static final String TITLE = "title";
    public static final String CONTENT = "content";
    public static final String IS_COMPLEMENT = "isComplement";

    /* (non-Javadoc)
     * @see com.crm.dao.impl.IAssignmentDAO#save(com.crm.model.Assignment)
     */
    public void save(Assignment transientInstance) {
	log.debug("saving Task instance");
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
     * @see com.crm.dao.impl.IAssignmentDAO#delete(com.crm.model.Assignment)
     */
    public void delete(Assignment persistentInstance) {
	log.debug("deleting Task instance");
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
     * @see com.crm.dao.impl.IAssignmentDAO#findById(java.lang.Integer)
     */
    public Assignment findById(java.lang.Integer id) {
	log.debug("getting Task instance with id: " + id);
	Session session;
	try {
	    session = getSession();
	    session.beginTransaction();
	    Assignment instance = (Assignment) session.get("com.crm.model.Assignment", id);
	    session.getTransaction().commit();
	    session.close();
	    return instance;
	} catch (RuntimeException re) {
	    log.error("get failed", re);
	    throw re;
	}
    }

    /* (non-Javadoc)
     * @see com.crm.dao.impl.IAssignmentDAO#findByExample(com.crm.model.Assignment)
     */
    @SuppressWarnings("unchecked")
    public List<Assignment> findByExample(Assignment instance) {
	log.debug("finding Task instance by example");
	Session session;
	try {
	    session = getSession();
	    session.beginTransaction();
	    List<Assignment> results = session.createCriteria("com.crm.model.Assignment")
		    .add(Example.create(instance)).list();
	    session.getTransaction().commit();
	    session.close();
	    log.debug("find by example successful, result size: "
		    + results.size());
	    return results;
	} catch (RuntimeException re) {
	    log.error("find by example failed", re);
	    throw re;
	}
    }

    /* (non-Javadoc)
     * @see com.crm.dao.impl.IAssignmentDAO#findByProperty(java.lang.String, java.lang.Object)
     */
    @SuppressWarnings("unchecked")
    public List<Assignment> findByProperty(String propertyName, Object value) {
	log.debug("finding Task instance with property: " + propertyName
		+ ", value: " + value);
	
	Session session;
	try {
	    session = getSession();
	    String queryString = "from Assignment as model where model."
		    + propertyName + "= ?";
	    session.beginTransaction();
	    
	    Query queryObject = session.createQuery(queryString);
	    queryObject.setParameter(0, value);
	    List<Assignment> assignments = queryObject.list();
	    session.getTransaction().commit();
	    session.close();
	    
	    return assignments;
	    
	} catch (RuntimeException re) {
	    log.error("find by property name failed", re);
	    throw re;
	}
    }

    /* (non-Javadoc)
     * @see com.crm.dao.impl.IAssignmentDAO#findByTitle(java.lang.Object)
     */
    public List<Assignment> findByTitle(Object title) {
	return findByProperty(TITLE, title);
    }

    /* (non-Javadoc)
     * @see com.crm.dao.impl.IAssignmentDAO#findByContent(java.lang.Object)
     */
    public List<Assignment> findByContent(Object content) {
	return findByProperty(CONTENT, content);
    }

    /* (non-Javadoc)
     * @see com.crm.dao.impl.IAssignmentDAO#findByIsComplement(java.lang.Object)
     */
    public List<Assignment> findByIsComplement(Object isComplement) {
	return findByProperty(IS_COMPLEMENT, isComplement);
    }

    /* (non-Javadoc)
     * @see com.crm.dao.impl.IAssignmentDAO#findAll()
     */
    @SuppressWarnings("unchecked")
    public List<Assignment> findAll() {
	log.debug("finding all Task instances");
	try {
	    String queryString = "from Assignment";
	    Query queryObject = getSession().createQuery(queryString);
	    return queryObject.list();
	} catch (RuntimeException re) {
	    log.error("find all failed", re);
	    throw re;
	}
    }

    /* (non-Javadoc)
     * @see com.crm.dao.impl.IAssignmentDAO#merge(com.crm.model.Assignment)
     */
    public Assignment merge(Assignment detachedInstance) {
	log.debug("merging Task instance");
	Session session;
	try {
	    session = getSession();
	    
	    session.beginTransaction();
	    Assignment result = (Assignment) session.merge(detachedInstance);
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
     * @see com.crm.dao.impl.IAssignmentDAO#attachDirty(com.crm.model.Assignment)
     */
    public void attachDirty(Assignment instance) {
	log.debug("attaching dirty Task instance");
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
     * @see com.crm.dao.impl.IAssignmentDAO#attachClean(com.crm.model.Assignment)
     */
    public void attachClean(Assignment instance) {
	log.debug("attaching clean Task instance");
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