/**
 * 
 */
package com.crm.dao;

import java.util.List;

import com.crm.model.Employee;

/**
 * @author lenovo
 *
 */
public interface IEmployeeDAO {

    public abstract void save(Employee transientInstance);

    public abstract void delete(Employee persistentInstance);

    public abstract Employee findById(java.lang.Integer id);

    public abstract List<Employee> findByExample(Employee instance);

    public abstract List<Employee> findByProperty(String propertyName,
	    Object value);

    public abstract List<Employee> findByName(Object name);

    public abstract List<Employee> findByGender(Object gender);

    public abstract List<Employee> findByIsMarried(Object isMarried);

    public abstract List<Employee> findByAddress(Object address);

    public abstract List<Employee> findByHobby(Object hobby);

    public abstract List<Employee> findByPhone(Object phone);

    public abstract List<Employee> findByEmail(Object email);

    public abstract List<Employee> findByDepartment(Object department);

    public abstract List<Employee> findByPost(Object post);

    public abstract List<Employee> findByIsManager(Object isManager);

    public abstract List<Employee> findAll();

    public abstract Employee merge(Employee detachedInstance);

    public abstract void attachDirty(Employee instance);

    public abstract void attachClean(Employee instance);

}