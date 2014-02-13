/**
 * 
 */
package com.crm.dao;

import java.util.List;

import com.crm.model.Customer;

/**
 * @author lenovo
 *
 */
public interface ICustomerDAO {

    public abstract void save(Customer transientInstance);

    public abstract void delete(Customer persistentInstance);

    public abstract Customer findById(java.lang.Integer id);

    public abstract List<Customer> findByExample(Customer instance);

    public abstract List<Customer> findByProperty(String propertyName,
	    Object value);

    public abstract List<Customer> findByName(Object name);

    public abstract List<Customer> findByGender(Object gender);

    public abstract List<Customer> findByAddress(Object address);

    public abstract List<Customer> findByIsMarried(Object isMarried);

    public abstract List<Customer> findByPhone(Object phone);

    public abstract List<Customer> findByEmail(Object email);

    public abstract List<Customer> findByHasHouse(Object hasHouse);

    public abstract List<Customer> findByHouseId(Object houseId);

    public abstract List<Customer> findByHouseIntent(Object houseIntent);

    public abstract List<Customer> findByIncome(Object income);

    public abstract List<Customer> findByJob(Object job);

    public abstract List<Customer> findByHobby(Object hobby);

    public abstract List<Customer> findAll();

    public abstract Customer merge(Customer detachedInstance);

    public abstract void attachDirty(Customer instance);

    public abstract void attachClean(Customer instance);

}