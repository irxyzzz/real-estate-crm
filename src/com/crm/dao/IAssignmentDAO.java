/**
 * 
 */
package com.crm.dao;

import java.util.List;

import com.crm.model.Assignment;

/**
 * @author 
 *
 */
public interface IAssignmentDAO {

    public abstract void save(Assignment transientInstance);

    public abstract void delete(Assignment persistentInstance);

    public abstract Assignment findById(java.lang.Integer id);

    public abstract List<Assignment> findByExample(Assignment instance);

    public abstract List<Assignment> findByProperty(String propertyName,
	    Object value);

    public abstract List<Assignment> findByTitle(Object title);

    public abstract List<Assignment> findByContent(Object content);

    public abstract List<Assignment> findByIsComplement(Object isComplement);

    public abstract List<Assignment> findAll();

    public abstract Assignment merge(Assignment detachedInstance);

    public abstract void attachDirty(Assignment instance);

    public abstract void attachClean(Assignment instance);

}