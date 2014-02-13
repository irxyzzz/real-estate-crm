/**
 * 
 */
package com.crm.dao;

import java.util.List;

import com.crm.model.CustomerFeedback;

/**
 * @author lenovo
 *
 */
public interface ICustomerFeedbackDAO {

    public abstract void save(CustomerFeedback transientInstance);

    public abstract void delete(CustomerFeedback persistentInstance);

    public abstract CustomerFeedback findById(java.lang.Integer id);

    public abstract List<CustomerFeedback> findByExample(
	    CustomerFeedback instance);

    public abstract List<CustomerFeedback> findByProperty(String propertyName,
	    Object value);

    public abstract List<CustomerFeedback> findByMarkSeller(Object markSeller);

    public abstract List<CustomerFeedback> findByAdviceSeller(
	    Object adviceSeller);

    public abstract List<CustomerFeedback> findByMarkEnvironment(
	    Object markEnvironment);

    public abstract List<CustomerFeedback> findByMarkTenement(
	    Object markTenement);

    public abstract List<CustomerFeedback> findByMarkTraffic(Object markTraffic);

    public abstract List<CustomerFeedback> findByMarkAll(Object markAll);

    public abstract List<CustomerFeedback> findAll();

    public abstract CustomerFeedback merge(CustomerFeedback detachedInstance);

    public abstract void attachDirty(CustomerFeedback instance);

    public abstract void attachClean(CustomerFeedback instance);

}