package com.crm.model;

import java.io.Serializable;
import java.sql.Timestamp;

import com.crm.util.MathUtil;

/**
 * CustomerConnection entity. 
 * @author 
 */

public class CustomerSupport implements Serializable {

    // Fields

    private static final long serialVersionUID = 1L;
    private Integer customerSupportId;
    private Employee employee;
    private Customer customer;
    private String content;
    private Timestamp recordTime;
    private String reply;

    // Constructors

    /** default constructor */
    public CustomerSupport() {
    }

    /** minimal constructor */
    public CustomerSupport(Employee employee, Customer customer,
	    String content, Timestamp recordTime) {
	this.employee = employee;
	this.customer = customer;
	this.content = content;
	this.recordTime = recordTime;
    }

    /** full constructor */
    public CustomerSupport(Employee employee, Customer customer,
	    String content, Timestamp recordTime, String reply) {
	this.employee = employee;
	this.customer = customer;
	this.content = content;
	this.recordTime = recordTime;
	this.reply = reply;
    }

    /**
     * @return the customerSupportId
     */
    public Integer getCustomerSupportId() {
        return customerSupportId;
    }

    /**
     * @param customerSupportId the customerSupportId to set
     */
    public void setCustomerSupportId(Integer customerSupportId) {
        this.customerSupportId = customerSupportId;
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
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content the content to set
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * @return the recordTime
     */
    public Timestamp getRecordTime() {
        return recordTime;
    }

    /**
     * @param recordTime the recordTime to set
     */
    public void setRecordTime(Timestamp recordTime) {
        this.recordTime = recordTime;
    }

    /**
     * @return the reply
     */
    public String getReply() {
        return reply;
    }

    /**
     * @param reply the reply to set
     */
    public void setReply(String reply) {
        this.reply = reply;
    }

    /**
     * @return the string id
     */
    public String getStringId() {
	return MathUtil.getFormatID(this.customerSupportId);
    }
    
    /**
     * 
     * @return the string birthday
     */
    @SuppressWarnings("deprecation")
    public String getTime() {
	return (recordTime.getYear() + 1900)+ "-" + (recordTime.getMonth()+1) + "-" + recordTime.getDate();
    }
}