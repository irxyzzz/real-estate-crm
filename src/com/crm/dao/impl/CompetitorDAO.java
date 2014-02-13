package com.crm.dao.impl;

import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.crm.dao.ICompetitorDAO;
import com.crm.hibernate.BaseHibernateDAO;
import com.crm.model.Competitor;

/**
 * A data access object (DAO) providing persistence and search support for
 * CompetitorInfo entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.crm.model.Competitor
 * @author 
 */

public class CompetitorDAO extends BaseHibernateDAO implements ICompetitorDAO {
    private static final Logger log = LoggerFactory
	    .getLogger(CompetitorDAO.class);
    // property constants
    public static final String MARKET_STRATEGY = "marketStrategy";

    /* (non-Javadoc)
     * @see com.crm.dao.impl.ICompetitorDAO#save(com.crm.model.Competitor)
     */
    public void save(Competitor transientInstance) {
	log.debug("saving CompetitorInfo instance");
	
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
     * @see com.crm.dao.impl.ICompetitorDAO#delete(com.crm.model.Competitor)
     */
    public void delete(Competitor persistentInstance) {
	log.debug("deleting CompetitorInfo instance");
	
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
     * @see com.crm.dao.impl.ICompetitorDAO#findById(java.lang.Integer)
     */
    public Competitor findById(java.lang.Integer id) {
	log.debug("getting Competitor instance with id: " + id);
	try {
	    Competitor instance = (Competitor) getSession().get(
		    "com.crm.model.Competitor", id);
	    return instance;
	} catch (RuntimeException re) {
	    log.error("get failed", re);
	    throw re;
	}
    }

    /* (non-Javadoc)
     * @see com.crm.dao.impl.ICompetitorDAO#findByExample(com.crm.model.Competitor)
     */
    @SuppressWarnings("unchecked")
    public List<Competitor> findByExample(Competitor instance) {
	log.debug("finding Competitor instance by example");
	try {
	    List<Competitor> results = getSession().createCriteria(
		    "com.crm.model.Competitor").add(
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
     * @see com.crm.dao.impl.ICompetitorDAO#findByProperty(java.lang.String, java.lang.Object)
     */
    @SuppressWarnings("unchecked")
    public List<Competitor> findByProperty(String propertyName, Object value) {
	log.debug("finding Competitor instance with property: "
		+ propertyName + ", value: " + value);
	try {
	    String queryString = "from Competitor as model where model."
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
     * @see com.crm.dao.impl.ICompetitorDAO#findByMarketStrategy(java.lang.Object)
     */
    public List<Competitor> findByMarketStrategy(Object marketStrategy) {
	return findByProperty(MARKET_STRATEGY, marketStrategy);
    }

    /* (non-Javadoc)
     * @see com.crm.dao.impl.ICompetitorDAO#findAll()
     */
    @SuppressWarnings("unchecked")
    public List<Competitor> findAll() {
	log.debug("finding all Competitor instances");
	try {
	    String queryString = "from Competitor";
	    Query queryObject = getSession().createQuery(queryString);
	    return queryObject.list();
	} catch (RuntimeException re) {
	    log.error("find all failed", re);
	    throw re;
	}
    }

    /* (non-Javadoc)
     * @see com.crm.dao.impl.ICompetitorDAO#merge(com.crm.model.Competitor)
     */
    public Competitor merge(Competitor detachedInstance) {
	log.debug("merging Competitor instance");
	
	Session session;
	try {
	    session = getSession();
	    session.beginTransaction();
	    Competitor result = (Competitor) session.merge(
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
     * @see com.crm.dao.impl.ICompetitorDAO#attachDirty(com.crm.model.Competitor)
     */
    public void attachDirty(Competitor instance) {
	log.debug("attaching dirty Competitor instance");
	
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
     * @see com.crm.dao.impl.ICompetitorDAO#attachClean(com.crm.model.Competitor)
     */
    public void attachClean(Competitor instance) {
	log.debug("attaching clean Competitor instance");
	
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