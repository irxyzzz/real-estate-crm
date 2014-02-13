package com.crm.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import com.crm.util.MathUtil;

/**
 * RepairRecord entity. 
 * @author 
 */

public class RepairRecord implements Serializable {

    // Fields
    
    private static final long serialVersionUID = 1L;
    
    private Integer repairRecordId;
    private Employee employee;
    private Customer customer;
    private String decription;
    private String handle;
    private Boolean isVerify;
    private String newHandle;
    private Timestamp beginTime;
    private Timestamp endTime;

    // Constructors

    /** default constructor */
    public RepairRecord() {
	this.isVerify = false;
    }

    /** full constructor */
    public RepairRecord(Employee employee, Customer customer,
	    String decription, String handle, Boolean isVerify, String newHandle) {
	this.employee = employee;
	this.customer = customer;
	this.decription = decription;
	this.handle = handle;
	this.isVerify = isVerify;
	this.newHandle = newHandle;
    }

    // Property accessors

    public Integer getRepairRecordId() {
	return this.repairRecordId;
    }

    public void setRepairRecordId(Integer repairRecordId) {
	this.repairRecordId = repairRecordId;
    }

    public Employee getEmployee() {
	return this.employee;
    }

    public void setEmployee(Employee employee) {
	this.employee = employee;
    }

    public Customer getCustomer() {
	return this.customer;
    }

    public void setCustomer(Customer customer) {
	this.customer = customer;
    }

    public String getDecription() {
	return this.decription;
    }

    public void setDecription(String decription) {
	this.decription = decription;
    }

    public String getHandle() {
	return this.handle;
    }

    public void setHandle(String handle) {
	this.handle = handle;
    }

    public Boolean getIsVerify() {
	return this.isVerify;
    }

    public void setIsVerify(Boolean isVerify) {
	this.isVerify = isVerify;
    }

    public String getNewHandle() {
	return this.newHandle;
    }

    public void setNewHandle(String newHandle) {
	this.newHandle = newHandle;
    }

    /**
     * @param beginTime the beginTime to set
     */
    public void setBeginTime(Timestamp beginTime) {
	this.beginTime = beginTime;
    }

    /**
     * @return the beginTime
     */
    public Timestamp getBeginTime() {
	return beginTime;
    }

    /**
     * @param endTime the endTime to set
     */
    public void setEndTime(Timestamp endTime) {
	this.endTime = endTime;
    }

    /**
     * @return the endTime
     */
    public Timestamp getEndTime() {
	return endTime;
    }
    
    /**
     * @return the string beginTime
     */
    public String getStringBeginTime(){
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
	return sdf.format(this.beginTime);
    }
    
    /**
     * @return the string beginTime
     */
    public String getStringEndTime(){
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
	return sdf.format(this.endTime);
    }

    /**
     * @return the string di
     */
    public String getStringId() {
	return MathUtil.getFormatID(this.repairRecordId);
    }

}