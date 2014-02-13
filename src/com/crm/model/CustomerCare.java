package com.crm.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import com.crm.util.MathUtil;

/**
 * CareActivity entity. 
 * @author 
 */

public class CustomerCare implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Integer customerCareId;
    private String title;
    private String decription;
    private Timestamp activityTime;
    private String form;
    private String customerType;

    // Constructors

    /** default constructor */
    public CustomerCare() {
    }

    /** minimal constructor */
    public CustomerCare(String title, Timestamp activityTime) {
	this.title = title;
	this.activityTime = activityTime;
    }

    /** full constructor */
    public CustomerCare(String title, String decription,
	    Timestamp activityTime, String form, String customerType) {
	this.title = title;
	this.decription = decription;
	this.activityTime = activityTime;
	this.form = form;
	this.customerType = customerType;
    }

    /**
     * @return the customerCareId
     */
    public Integer getCustomerCareId() {
        return customerCareId;
    }

    /**
     * @param customerCareId the customerCareId to set
     */
    public void setCustomerCareId(Integer customerCareId) {
        this.customerCareId = customerCareId;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the decription
     */
    public String getDecription() {
        return decription;
    }

    /**
     * @param decription the decription to set
     */
    public void setDecription(String decription) {
        this.decription = decription;
    }

    /**
     * @return the activityTime
     */
    public Timestamp getActivityTime() {
        return activityTime;
    }

    /**
     * @param activityTime the activityTime to set
     */
    public void setActivityTime(Timestamp activityTime) {
        this.activityTime = activityTime;
    }

    /**
     * @return the form
     */
    public String getForm() {
        return form;
    }

    /**
     * @param form the form to set
     */
    public void setForm(String form) {
        this.form = form;
    }

    /**
     * @return the customerType
     */
    public String getCustomerType() {
        return customerType;
    }

    /**
     * @param customerType the customerType to set
     */
    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    /**
     * @return the string id
     */
    public String getStringId() {
        return MathUtil.getFormatID(this.customerCareId);
    }
    
    /**
     * @return the string time
     */
    public String getTime() {
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(this.activityTime);
    }
}