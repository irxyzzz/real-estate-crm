package com.crm.dao.impl;

import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.crm.dao.IEmployeeDAO;
import com.crm.hibernate.BaseHibernateDAO;
import com.crm.model.Employee;

/**
 * A data access object (DAO) providing persistence and search support for
 * Employee entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.crm.model.Employee
 * @author 
 */

public class EmployeeDAO extends BaseHibernateDAO implements IEmployeeDAO {
    private static final Logger log = LoggerFactory
	    .getLogger(EmployeeDAO.class);
    // property constants
    public static final String NAME = "name";
    public static final String GENDER = "gender";
    public static final String IS_MARRIED = "isMarried";
    public static final String ADDRESS = "address";
    public static final String HOBBY = "hobby";
    public static final String PHONE = "phone";
    public static final String EMAIL = "email";
    public static final String DEPARTMENT = "department";
    public static final String POST = "post";
    public static final String IS_MANAGER = "isManager";

    /* (non-Javadoc)
     * @see com.crm.dao.impl.IEmployeeDAO#save(com.crm.model.Employee)
     */
    public void save(Employee transientInstance) {
	log.debug("saving Employee instance");
	
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
     * @see com.crm.dao.impl.IEmployeeDAO#delete(com.crm.model.Employee)
     */
    public void delete(Employee persistentInstance) {
	log.debug("deleting Employee instance");

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
     * @see com.crm.dao.impl.IEmployeeDAO#findById(java.lang.Integer)
     */
    public Employee findById(java.lang.Integer id) {
	log.debug("getting Employee instance with id: " + id);
	try {
	    Employee instance = (Employee) getSession().get(
		    "com.crm.model.Employee", id);
	    return instance;
	} catch (RuntimeException re) {
	    log.error("get failed", re);
	    throw re;
	}
    }

    /* (non-Javadoc)
     * @see com.crm.dao.impl.IEmployeeDAO#findByExample(com.crm.model.Employee)
     */
    @SuppressWarnings("unchecked")
    public List<Employee> findByExample(Employee instance) {
	log.debug("finding Employee instance by example");
	try {
	    List<Employee> results = getSession()
		    .createCriteria("com.crm.model.Employee").add(
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
     * @see com.crm.dao.impl.IEmployeeDAO#findByProperty(java.lang.String, java.lang.Object)
     */
    @SuppressWarnings("unchecked")
    public List<Employee> findByProperty(String propertyName, Object value) {
	log.debug("finding Employee instance with property: " + propertyName
		+ ", value: " + value);
	try {
	    String queryString = "from Employee as model where model."
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
     * @see com.crm.dao.impl.IEmployeeDAO#findByName(java.lang.Object)
     */
    public List<Employee> findByName(Object name) {
	return findByProperty(NAME, name);
    }

    /* (non-Javadoc)
     * @see com.crm.dao.impl.IEmployeeDAO#findByGender(java.lang.Object)
     */
    public List<Employee> findByGender(Object gender) {
	return findByProperty(GENDER, gender);
    }

    /* (non-Javadoc)
     * @see com.crm.dao.impl.IEmployeeDAO#findByIsMarried(java.lang.Object)
     */
    public List<Employee> findByIsMarried(Object isMarried) {
	return findByProperty(IS_MARRIED, isMarried);
    }

    /* (non-Javadoc)
     * @see com.crm.dao.impl.IEmployeeDAO#findByAddress(java.lang.Object)
     */
    public List<Employee> findByAddress(Object address) {
	return findByProperty(ADDRESS, address);
    }

    /* (non-Javadoc)
     * @see com.crm.dao.impl.IEmployeeDAO#findByHobby(java.lang.Object)
     */
    public List<Employee> findByHobby(Object hobby) {
	return findByProperty(HOBBY, hobby);
    }

    /* (non-Javadoc)
     * @see com.crm.dao.impl.IEmployeeDAO#findByPhone(java.lang.Object)
     */
    public List<Employee> findByPhone(Object phone) {
	return findByProperty(PHONE, phone);
    }

    /* (non-Javadoc)
     * @see com.crm.dao.impl.IEmployeeDAO#findByEmail(java.lang.Object)
     */
    public List<Employee> findByEmail(Object email) {
	return findByProperty(EMAIL, email);
    }

    /* (non-Javadoc)
     * @see com.crm.dao.impl.IEmployeeDAO#findByDepartment(java.lang.Object)
     */
    public List<Employee> findByDepartment(Object department) {
	return findByProperty(DEPARTMENT, department);
    }

    /* (non-Javadoc)
     * @see com.crm.dao.impl.IEmployeeDAO#findByPost(java.lang.Object)
     */
    public List<Employee> findByPost(Object post) {
	return findByProperty(POST, post);
    }

    /* (non-Javadoc)
     * @see com.crm.dao.impl.IEmployeeDAO#findByIsManager(java.lang.Object)
     */
    public List<Employee> findByIsManager(Object isManager) {
	return findByProperty(IS_MANAGER, isManager);
    }

    /* (non-Javadoc)
     * @see com.crm.dao.impl.IEmployeeDAO#findAll()
     */
    @SuppressWarnings("unchecked")
    public List<Employee> findAll() {
	log.debug("finding all Employee instances");
	try {
	    String queryString = "from Employee";
	    Query queryObject = getSession().createQuery(queryString);
	    return queryObject.list();
	} catch (RuntimeException re) {
	    log.error("find all failed", re);
	    throw re;
	}
    }

    /* (non-Javadoc)
     * @see com.crm.dao.impl.IEmployeeDAO#merge(com.crm.model.Employee)
     */
    public Employee merge(Employee detachedInstance) {
	log.debug("merging Employee instance");
	
	Session session;
	try {
	    session = getSession();
	    session.beginTransaction();
	    Employee result = (Employee) session.merge(detachedInstance);
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
     * @see com.crm.dao.impl.IEmployeeDAO#attachDirty(com.crm.model.Employee)
     */
    public void attachDirty(Employee instance) {
	log.debug("attaching dirty Employee instance");
	
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
     * @see com.crm.dao.impl.IEmployeeDAO#attachClean(com.crm.model.Employee)
     */
    public void attachClean(Employee instance) {
	log.debug("attaching clean Employee instance");
	
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