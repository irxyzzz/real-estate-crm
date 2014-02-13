package com.crm.dao.impl;

import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.crm.dao.IAssignmentParticipantDAO;
import com.crm.hibernate.BaseHibernateDAO;
import com.crm.model.AssignmentParticipant;

/**
 * A data access object (DAO) providing persistence and search support for
 * TaskParticipantList entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.crm.model.AssignmentParticipant
 * @author 
 */

public class AssignmentParticipantDAO extends BaseHibernateDAO implements IAssignmentParticipantDAO {
    private static final Logger log = LoggerFactory
	    .getLogger(AssignmentParticipantDAO.class);

    // property constants

    /* (non-Javadoc)
     * @see com.crm.dao.impl.IAssignmentParticipantDAO#save(com.crm.model.AssignmentParticipant)
     */
    public void save(AssignmentParticipant transientInstance) {
	log.debug("saving AssignmentParticipant instance");
	
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
     * @see com.crm.dao.impl.IAssignmentParticipantDAO#delete(com.crm.model.AssignmentParticipant)
     */
    public void delete(AssignmentParticipant persistentInstance) {
	log.debug("deleting AssignmentParticipant instance");
	
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
     * @see com.crm.dao.impl.IAssignmentParticipantDAO#findById(java.lang.Integer)
     */
    public AssignmentParticipant findById(java.lang.Integer id) {
	log.debug("getting AssignmentParticipant instance with id: " + id);
	try {
	    AssignmentParticipant instance = (AssignmentParticipant) getSession()
		    .get("com.crm.model.AssignmentParticipant", id);
	    return instance;
	} catch (RuntimeException re) {
	    log.error("get failed", re);
	    throw re;
	}
    }

    /* (non-Javadoc)
     * @see com.crm.dao.impl.IAssignmentParticipantDAO#findByExample(com.crm.model.AssignmentParticipant)
     */
    @SuppressWarnings("unchecked")
    public List<AssignmentParticipant> findByExample(AssignmentParticipant instance) {
	log.debug("finding AssignmentParticipant instance by example");
	try {
	    List<AssignmentParticipant> results = getSession().createCriteria(
		    "com.crm.model.AssignmentParticipant").add(
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
     * @see com.crm.dao.impl.IAssignmentParticipantDAO#findByProperty(java.lang.String, java.lang.Object)
     */
    @SuppressWarnings("unchecked")
    public List<AssignmentParticipant> findByProperty(String propertyName, Object value) {
	log.debug("finding AssignmentParticipant instance with property: "
		+ propertyName + ", value: " + value);
	try {
	    String queryString = "from AssignmentParticipant as model where model."
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
     * @see com.crm.dao.impl.IAssignmentParticipantDAO#findAll()
     */
    @SuppressWarnings("unchecked")
    public List<AssignmentParticipant> findAll() {
	log.debug("finding all AssignmentParticipant instances");
	try {
	    String queryString = "from AssignmentParticipant";
	    Query queryObject = getSession().createQuery(queryString);
	    return queryObject.list();
	} catch (RuntimeException re) {
	    log.error("find all failed", re);
	    throw re;
	}
    }

    /* (non-Javadoc)
     * @see com.crm.dao.impl.IAssignmentParticipantDAO#merge(com.crm.model.AssignmentParticipant)
     */
    public AssignmentParticipant merge(AssignmentParticipant detachedInstance) {
	log.debug("merging TaskParticipantList instance");
	
	Session session;
	try {
	    session = getSession();
	    session.beginTransaction();
	    AssignmentParticipant result = (AssignmentParticipant) session
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
     * @see com.crm.dao.impl.IAssignmentParticipantDAO#attachDirty(com.crm.model.AssignmentParticipant)
     */
    public void attachDirty(AssignmentParticipant instance) {
	log.debug("attaching dirty TaskParticipantList instance");
	
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
     * @see com.crm.dao.impl.IAssignmentParticipantDAO#attachClean(com.crm.model.AssignmentParticipant)
     */
    public void attachClean(AssignmentParticipant instance) {
	log.debug("attaching clean AssignmentParticipant instance");
	
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