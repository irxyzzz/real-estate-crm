/**
 * 
 */
package com.crm.dao;

import java.util.List;

import com.crm.model.AssignmentParticipant;

/**
 * @author 
 *
 */
public interface IAssignmentParticipantDAO {

    public abstract void save(AssignmentParticipant transientInstance);

    public abstract void delete(AssignmentParticipant persistentInstance);

    public abstract AssignmentParticipant findById(java.lang.Integer id);

    public abstract List<AssignmentParticipant> findByExample(
	    AssignmentParticipant instance);

    public abstract List<AssignmentParticipant> findByProperty(
	    String propertyName, Object value);

    public abstract List<AssignmentParticipant> findAll();

    public abstract AssignmentParticipant merge(
	    AssignmentParticipant detachedInstance);

    public abstract void attachDirty(AssignmentParticipant instance);

    public abstract void attachClean(AssignmentParticipant instance);

}