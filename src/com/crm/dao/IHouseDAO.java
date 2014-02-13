/**
 * 
 */
package com.crm.dao;

import java.util.List;

import com.crm.model.House;

/**
 * @author lenovo
 *
 */
public interface IHouseDAO {

    public abstract void save(House transientInstance);

    public abstract void delete(House persistentInstance);

    public abstract House findById(java.lang.Integer id);

    public abstract List<House> findByExample(House instance);

    public abstract List<House> findByProperty(String propertyName, Object value);

    public abstract List<House> findByArea(Object area);

    public abstract List<House> findByPosition(Object position);

    public abstract List<House> findByPrice(Object price);

    public abstract List<House> findByIsSale(Object isSale);

    public abstract List<House> findByCustomerId(Object customerId);

    public abstract List<House> findAll();

    public abstract House merge(House detachedInstance);

    public abstract void attachDirty(House instance);

    public abstract void attachClean(House instance);

}