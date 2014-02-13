/**
 * 
 */
package com.crm.dao;

import java.util.List;

import com.crm.model.Competitor;

/**
 * @author lenovo
 *
 */
public interface ICompetitorDAO {

    public abstract void save(Competitor transientInstance);

    public abstract void delete(Competitor persistentInstance);

    public abstract Competitor findById(java.lang.Integer id);

    public abstract List<Competitor> findByExample(Competitor instance);

    public abstract List<Competitor> findByProperty(String propertyName,
	    Object value);

    public abstract List<Competitor> findByMarketStrategy(Object marketStrategy);

    public abstract List<Competitor> findAll();

    public abstract Competitor merge(Competitor detachedInstance);

    public abstract void attachDirty(Competitor instance);

    public abstract void attachClean(Competitor instance);

}