/**
 * 
 */
package com.crm.dao;

import java.util.List;

import com.crm.model.Notice;

/**
 * @author lenovo
 *
 */
public interface INoticeDAO {

    public abstract void save(Notice transientInstance);

    public abstract void delete(Notice persistentInstance);

    public abstract Notice findById(java.lang.Integer id);

    public abstract List<Notice> findByExample(Notice instance);

    public abstract List<Notice> findByProperty(String propertyName,
	    Object value);

    public abstract List<Notice> findByTitle(Object title);

    public abstract List<Notice> findByContent(Object content);

    public abstract List<Notice> findByClassify(Object classify);

    public abstract List<Notice> findByAuthor(Object author);

    public abstract List<Notice> findAll();

    public abstract Notice merge(Notice detachedInstance);

    public abstract void attachDirty(Notice instance);

    public abstract void attachClean(Notice instance);

}