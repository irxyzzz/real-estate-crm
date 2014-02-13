/**
 * 
 */
package com.crm.dao;

import java.util.List;

import com.crm.model.CustomerCare;

/**
 * @author lenovo
 *
 */
public interface ICustomerCareDAO {

    public abstract void save(CustomerCare transientInstance);

    public abstract void delete(CustomerCare persistentInstance);

    public abstract CustomerCare findById(java.lang.Integer id);

    public abstract List<CustomerCare> findByExample(CustomerCare instance);

    public abstract List<CustomerCare> findByProperty(String propertyName,
	    Object value);

    public abstract List<CustomerCare> findByTitle(Object title);

    public abstract List<CustomerCare> findByDecription(Object decription);

    public abstract List<CustomerCare> findByForm(Object form);

    public abstract List<CustomerCare> findByCustomerType(Object customerType);

    public abstract List<CustomerCare> findAll();

    public abstract CustomerCare merge(CustomerCare detachedInstance);

    public abstract void attachDirty(CustomerCare instance);

    public abstract void attachClean(CustomerCare instance);

}