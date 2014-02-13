package com.crm.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * CustomerFeedback entity. 
 * @author 
 */

public class CustomerFeedback implements Serializable {

    // Fields
    private static final long serialVersionUID = 1L;

    private Integer customerFeedbackId;
    private Employee employee;
    private Customer customer;
    private Integer markSeller;
    private String adviceSeller;
    private Integer markEnvironment;
    private Integer markTenement;
    private Integer markTraffic;
    private Integer markAll;
    private Timestamp recordTime;

    // Constructors

    /** default constructor */
    public CustomerFeedback() {
	this.recordTime = new Timestamp(new Date().getTime());
    }

    /** minimal constructor */
    public CustomerFeedback(Employee employee, Customer customer,
	    Integer markSeller, Integer markEnvironment, Integer markTenement,
	    Integer markTraffic, Integer markAll) {
	this.employee = employee;
	this.customer = customer;
	this.markSeller = markSeller;
	this.markEnvironment = markEnvironment;
	this.markTenement = markTenement;
	this.markTraffic = markTraffic;
	this.markAll = markAll;
    }

    /** full constructor */
    public CustomerFeedback(Employee employee, Customer customer,
	    Integer markSeller, String adviceSeller, Integer markEnvironment,
	    Integer markTenement, Integer markTraffic, Integer markAll) {
	this.employee = employee;
	this.customer = customer;
	this.markSeller = markSeller;
	this.adviceSeller = adviceSeller;
	this.markEnvironment = markEnvironment;
	this.markTenement = markTenement;
	this.markTraffic = markTraffic;
	this.markAll = markAll;
    }

    /**
     * @return the customerFeedbackId
     */
    public Integer getCustomerFeedbackId() {
        return customerFeedbackId;
    }

    /**
     * @param customerFeedbackId the customerFeedbackId to set
     */
    public void setCustomerFeedbackId(Integer customerFeedbackId) {
        this.customerFeedbackId = customerFeedbackId;
    }

    /**
     * @return the employee
     */
    public Employee getEmployee() {
        return employee;
    }

    /**
     * @param employee the employee to set
     */
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    /**
     * @return the customer
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * @param customer the customer to set
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    /**
     * @return the markSeller
     */
    public Integer getMarkSeller() {
        return markSeller;
    }

    /**
     * @param markSeller the markSeller to set
     */
    public void setMarkSeller(Integer markSeller) {
        this.markSeller = markSeller;
    }

    /**
     * @return the adviceSeller
     */
    public String getAdviceSeller() {
        return adviceSeller;
    }

    /**
     * @param adviceSeller the adviceSeller to set
     */
    public void setAdviceSeller(String adviceSeller) {
        this.adviceSeller = adviceSeller;
    }

    /**
     * @return the markEnvironment
     */
    public Integer getMarkEnvironment() {
        return markEnvironment;
    }

    /**
     * @param markEnvironment the markEnvironment to set
     */
    public void setMarkEnvironment(Integer markEnvironment) {
        this.markEnvironment = markEnvironment;
    }

    /**
     * @return the markTenement
     */
    public Integer getMarkTenement() {
        return markTenement;
    }

    /**
     * @param markTenement the markTenement to set
     */
    public void setMarkTenement(Integer markTenement) {
        this.markTenement = markTenement;
    }

    /**
     * @return the markTraffic
     */
    public Integer getMarkTraffic() {
        return markTraffic;
    }

    /**
     * @param markTraffic the markTraffic to set
     */
    public void setMarkTraffic(Integer markTraffic) {
        this.markTraffic = markTraffic;
    }

    /**
     * @return the markAll
     */
    public Integer getMarkAll() {
        return markAll;
    }

    /**
     * @param markAll the markAll to set
     */
    public void setMarkAll(Integer markAll) {
        this.markAll = markAll;
    }

    /**
     * @param recordTime the recordTime to set
     */
    public void setRecordTime(Timestamp recordTime) {
	this.recordTime = recordTime;
    }

    /**
     * @return the recordTime
     */
    public Timestamp getRecordTime() {
	return recordTime;
    }
    /**
     * @return the string recordTime
     */
    public String getTime() {
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	return sdf.format(recordTime);
    }
}