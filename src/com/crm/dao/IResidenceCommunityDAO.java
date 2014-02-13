/**
 * 
 */
package com.crm.dao;

import java.util.List;

import com.crm.model.ResidenceCommunity;

/**
 * @author lenovo
 *
 */
public interface IResidenceCommunityDAO {

    public abstract void save(ResidenceCommunity transientInstance);

    public abstract void delete(ResidenceCommunity persistentInstance);

    public abstract ResidenceCommunity findById(java.lang.Integer id);

    public abstract List<ResidenceCommunity> findByExample(
	    ResidenceCommunity instance);

    public abstract List<ResidenceCommunity> findByProperty(
	    String propertyName, Object value);

    public abstract List<ResidenceCommunity> findByName(Object name);

    public abstract List<ResidenceCommunity> findByAddress(Object address);

    public abstract List<ResidenceCommunity> findByArea(Object area);

    public abstract List<ResidenceCommunity> findByType(Object type);

    public abstract List<ResidenceCommunity> findByDescription(
	    Object description);

    public abstract List<ResidenceCommunity> findAll();

    public abstract ResidenceCommunity merge(ResidenceCommunity detachedInstance);

    public abstract void attachDirty(ResidenceCommunity instance);

    public abstract void attachClean(ResidenceCommunity instance);

}