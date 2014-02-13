/**
 * 
 */
package com.crm.dao;

import java.util.List;

import com.crm.model.RepairRecord;

/**
 * @author lenovo
 *
 */
public interface IRepairRecordDAO {

    public abstract void save(RepairRecord transientInstance);

    public abstract void delete(RepairRecord persistentInstance);

    public abstract RepairRecord findById(java.lang.Integer id);

    public abstract List<RepairRecord> findByExample(RepairRecord instance);

    public abstract List<RepairRecord> findByProperty(String propertyName,
	    Object value);

    public abstract List<RepairRecord> findByDecription(Object decription);

    public abstract List<RepairRecord> findByHandle(Object handle);

    public abstract List<RepairRecord> findByIsVerify(Object isVerify);

    public abstract List<RepairRecord> findByNewHandle(Object newHandle);

    public abstract List<RepairRecord> findAll();

    public abstract RepairRecord merge(RepairRecord detachedInstance);

    public abstract void attachDirty(RepairRecord instance);

    public abstract void attachClean(RepairRecord instance);

}