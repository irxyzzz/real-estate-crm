/**
 * 
 */
package com.crm.dao;

import java.util.List;

import com.crm.model.Company;

/**
 * @author lenovo
 *
 */
public interface ICompanyDAO {

    public abstract void save(Company transientInstance);

    public abstract void delete(Company persistentInstance);

    public abstract Company findById(java.lang.Integer id);

    public abstract List<Company> findByExample(Company instance);

    public abstract List<Company> findByProperty(String propertyName,
	    Object value);

    public abstract List<Company> findByName(Object name);

    public abstract List<Company> findByCorporation(Object corporation);

    public abstract List<Company> findByAddress(Object address);

    public abstract List<Company> findByType(Object type);

    public abstract List<Company> findByHomePage(Object homePage);

    public abstract List<Company> findByTelephone(Object telephone);

    public abstract List<Company> findByPostcard(Object postcard);

    public abstract List<Company> findByHistory(Object history);

    public abstract List<Company> findAll();

    public abstract Company merge(Company detachedInstance);

    public abstract void attachDirty(Company instance);

    public abstract void attachClean(Company instance);

}