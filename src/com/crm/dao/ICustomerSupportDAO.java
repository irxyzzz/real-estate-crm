/**
 * 
 */
package com.crm.dao;

import java.util.List;

import com.crm.model.CustomerSupport;

/**
 * @author lenovo
 *
 */
public interface ICustomerSupportDAO {

    public abstract void save(CustomerSupport transientInstance);

    public abstract void delete(CustomerSupport persistentInstance);

    public abstract CustomerSupport findById(java.lang.Integer id);

    public abstract List<CustomerSupport> findByExample(CustomerSupport instance);

    public abstract List<CustomerSupport> findByProperty(String propertyName,
	    Object value);

    public abstract List<CustomerSupport> findByContent(Object content);

    public abstract List<CustomerSupport> findByReply(Object reply);

    public abstract List<CustomerSupport> findAll();

    public abstract CustomerSupport merge(CustomerSupport detachedInstance);

    public abstract void attachDirty(CustomerSupport instance);

    public abstract void attachClean(CustomerSupport instance);

}