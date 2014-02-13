/**
 * 
 */
package com.crm.dao;

import java.util.List;

import com.crm.model.EmployeeCustomer;

/**
 * @author lenovo
 *
 */
public interface IEmployeeCustomerDAO {

    public abstract void save(EmployeeCustomer transientInstance);

    public abstract void delete(EmployeeCustomer persistentInstance);

    public abstract EmployeeCustomer findById(java.lang.Integer id);

    public abstract List<EmployeeCustomer> findByExample(
	    EmployeeCustomer instance);

    public abstract List<EmployeeCustomer> findByProperty(String propertyName,
	    Object value);

    public abstract List<EmployeeCustomer> findAll();

    public abstract EmployeeCustomer merge(EmployeeCustomer detachedInstance);

    public abstract void attachDirty(EmployeeCustomer instance);

    public abstract void attachClean(EmployeeCustomer instance);

}