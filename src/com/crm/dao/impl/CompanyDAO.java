package com.crm.dao.impl;

import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.crm.dao.ICompanyDAO;
import com.crm.hibernate.BaseHibernateDAO;
import com.crm.model.Company;

/**
 * A data access object (DAO) providing persistence and search support for
 * Company entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.crm.model.Company
 * @author 
 */

public class CompanyDAO extends BaseHibernateDAO implements ICompanyDAO {
    private static final Logger log = LoggerFactory.getLogger(CompanyDAO.class);
    // property constants
    public static final String NAME = "name";
    public static final String CORPORATION = "corporation";
    public static final String ADDRESS = "address";
    public static final String TYPE = "type";
    public static final String HOME_PAGE = "homePage";
    public static final String TELEPHONE = "telephone";
    public static final String POSTCARD = "postcard";
    public static final String HISTORY = "history";

    /* (non-Javadoc)
     * @see com.crm.dao.impl.ICompanyDAO#save(com.crm.model.Company)
     */
    public void save(Company transientInstance) {
	log.debug("saving Company instance");
	
	Session session ;
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
     * @see com.crm.dao.impl.ICompanyDAO#delete(com.crm.model.Company)
     */
    public void delete(Company persistentInstance) {
	log.debug("deleting Company instance");
	
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
     * @see com.crm.dao.impl.ICompanyDAO#findById(java.lang.Integer)
     */
    public Company findById(java.lang.Integer id) {
	log.debug("getting Company instance with id: " + id);
	try {
	    Company instance = (Company) getSession().get(
		    "com.crm.model.Company", id);
	    return instance;
	} catch (RuntimeException re) {
	    log.error("get failed", re);
	    throw re;
	}
    }

    /* (non-Javadoc)
     * @see com.crm.dao.impl.ICompanyDAO#findByExample(com.crm.model.Company)
     */
    @SuppressWarnings("unchecked")
    public List<Company> findByExample(Company instance) {
	log.debug("finding Company instance by example");
	try {
	    List<Company> results = getSession().createCriteria("com.crm.model.Company")
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
     * @see com.crm.dao.impl.ICompanyDAO#findByProperty(java.lang.String, java.lang.Object)
     */
    @SuppressWarnings("unchecked")
    public List<Company> findByProperty(String propertyName, Object value) {
	log.debug("finding Company instance with property: " + propertyName
		+ ", value: " + value);
	try {
	    String queryString = "from Company as model where model."
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
     * @see com.crm.dao.impl.ICompanyDAO#findByName(java.lang.Object)
     */
    public List<Company> findByName(Object name) {
	return findByProperty(NAME, name);
    }

    /* (non-Javadoc)
     * @see com.crm.dao.impl.ICompanyDAO#findByCorporation(java.lang.Object)
     */
    public List<Company> findByCorporation(Object corporation) {
	return findByProperty(CORPORATION, corporation);
    }

    /* (non-Javadoc)
     * @see com.crm.dao.impl.ICompanyDAO#findByAddress(java.lang.Object)
     */
    public List<Company> findByAddress(Object address) {
	return findByProperty(ADDRESS, address);
    }

    /* (non-Javadoc)
     * @see com.crm.dao.impl.ICompanyDAO#findByType(java.lang.Object)
     */
    public List<Company> findByType(Object type) {
	return findByProperty(TYPE, type);
    }

    /* (non-Javadoc)
     * @see com.crm.dao.impl.ICompanyDAO#findByHomePage(java.lang.Object)
     */
    public List<Company> findByHomePage(Object homePage) {
	return findByProperty(HOME_PAGE, homePage);
    }

    /* (non-Javadoc)
     * @see com.crm.dao.impl.ICompanyDAO#findByTelephone(java.lang.Object)
     */
    public List<Company> findByTelephone(Object telephone) {
	return findByProperty(TELEPHONE, telephone);
    }

    /* (non-Javadoc)
     * @see com.crm.dao.impl.ICompanyDAO#findByPostcard(java.lang.Object)
     */
    public List<Company> findByPostcard(Object postcard) {
	return findByProperty(POSTCARD, postcard);
    }

    /* (non-Javadoc)
     * @see com.crm.dao.impl.ICompanyDAO#findByHistory(java.lang.Object)
     */
    public List<Company> findByHistory(Object history) {
	return findByProperty(HISTORY, history);
    }

    /* (non-Javadoc)
     * @see com.crm.dao.impl.ICompanyDAO#findAll()
     */
    @SuppressWarnings("unchecked")
    public List<Company> findAll() {
	log.debug("finding all Company instances");
	try {
	    String queryString = "from Company";
	    Query queryObject = getSession().createQuery(queryString);
	    return queryObject.list();
	} catch (RuntimeException re) {
	    log.error("find all failed", re);
	    throw re;
	}
    }

    /* (non-Javadoc)
     * @see com.crm.dao.impl.ICompanyDAO#merge(com.crm.model.Company)
     */
    public Company merge(Company detachedInstance) {
	log.debug("merging Company instance");
	
	Session session;
	try {
	    session = getSession();
	    session.beginTransaction();
	    Company result = (Company) session.merge(detachedInstance);
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
     * @see com.crm.dao.impl.ICompanyDAO#attachDirty(com.crm.model.Company)
     */
    public void attachDirty(Company instance) {
	log.debug("attaching dirty Company instance");
	
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
     * @see com.crm.dao.impl.ICompanyDAO#attachClean(com.crm.model.Company)
     */
    public void attachClean(Company instance) {
	log.debug("attaching clean Company instance");
	
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