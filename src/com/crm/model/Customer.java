package com.crm.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.crm.util.MathUtil;

/**
 * Customer entity. 
 * @author 
 */

public class Customer implements Serializable {

    // Fields

    private static final long serialVersionUID = 1L;
    
    private Integer customerId;
    private String name;
    private String gender;
    private Date birthday;
    private String address;
    private Boolean isMarried;
    private String phone;
    private String email;
    private Boolean hasHouse;
    private Integer houseId;
    private String houseIntent;
    private String income;
    private String job;
    private String hobby;
    private Set<RepairRecord> repairRecords = new HashSet<RepairRecord>(0);
    private Set<CustomerSupport> customerSupports = new HashSet<CustomerSupport>(0);
    private Set<CustomerFeedback> customerFeedbacks = new HashSet<CustomerFeedback>(0);
    private Set<EmployeeCustomer> employeeCustomers = new HashSet<EmployeeCustomer>(0);

    // Constructors

    /** default constructor */
    public Customer() {
    }

    /** minimal constructor */
    public Customer(String name, String gender, Date birthday, String phone,
	    String email) {
	this.name = name;
	this.gender = gender;
	this.birthday = birthday;
	this.phone = phone;
	this.email = email;
    }

    /** full constructor */
    public Customer(String name, String gender, Date birthday, String address,
	    Boolean isMarried, String phone, String email, Boolean hasHouse,
	    Integer houseId, String houseIntent, String income, String job,
	    String hobby, 
	    Set<RepairRecord> repairRecords, 
	    Set<CustomerSupport> customerSupports,
	    Set<CustomerFeedback> customerFeedbacks, 
	    Set<EmployeeCustomer> employeeCustomers) {
	this.name = name;
	this.gender = gender;
	this.birthday = birthday;
	this.address = address;
	this.isMarried = isMarried;
	this.phone = phone;
	this.email = email;
	this.hasHouse = hasHouse;
	this.houseId = houseId;
	this.houseIntent = houseIntent;
	this.income = income;
	this.job = job;
	this.hobby = hobby;
	this.repairRecords = repairRecords;
	this.customerSupports = customerSupports;
	this.customerFeedbacks = customerFeedbacks;
	this.employeeCustomers = employeeCustomers;
    }

    /**
     * @return the customerId
     */
    public Integer getCustomerId() {
        return customerId;
    }

    /**
     * @param customerId the customerId to set
     */
    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * @return the birthday
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * @param birthday the birthday to set
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the isMarried
     */
    public Boolean getIsMarried() {
        return isMarried;
    }

    /**
     * @param isMarried the isMarried to set
     */
    public void setIsMarried(Boolean isMarried) {
        this.isMarried = isMarried;
    }

    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the hasHouse
     */
    public Boolean getHasHouse() {
        return hasHouse;
    }

    /**
     * @param hasHouse the hasHouse to set
     */
    public void setHasHouse(Boolean hasHouse) {
        this.hasHouse = hasHouse;
    }

    /**
     * @return the houseId
     */
    public Integer getHouseId() {
        return houseId;
    }

    /**
     * @param houseId the houseId to set
     */
    public void setHouseId(Integer houseId) {
        this.houseId = houseId;
    }

    /**
     * @return the houseIntent
     */
    public String getHouseIntent() {
        return houseIntent;
    }

    /**
     * @param houseIntent the houseIntent to set
     */
    public void setHouseIntent(String houseIntent) {
        this.houseIntent = houseIntent;
    }

    /**
     * @return the income
     */
    public String getIncome() {
        return income;
    }

    /**
     * @param income the income to set
     */
    public void setIncome(String income) {
        this.income = income;
    }

    /**
     * @return the job
     */
    public String getJob() {
        return job;
    }

    /**
     * @param job the job to set
     */
    public void setJob(String job) {
        this.job = job;
    }

    /**
     * @return the hobby
     */
    public String getHobby() {
        return hobby;
    }

    /**
     * @param hobby the hobby to set
     */
    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    /**
     * @return the repairRecords
     */
    public Set<RepairRecord> getRepairRecords() {
        return repairRecords;
    }

    /**
     * @param repairRecords the repairRecords to set
     */
    public void setRepairRecords(Set<RepairRecord> repairRecords) {
        this.repairRecords = repairRecords;
    }

    /**
     * @return the customerSupports
     */
    public Set<CustomerSupport> getCustomerSupports() {
        return customerSupports;
    }

    /**
     * @param customerSupports the customerSupports to set
     */
    public void setCustomerSupports(Set<CustomerSupport> customerSupports) {
        this.customerSupports = customerSupports;
    }

    /**
     * @return the customerFeedbacks
     */
    public Set<CustomerFeedback> getCustomerFeedbacks() {
        return customerFeedbacks;
    }

    /**
     * @param customerFeedbacks the customerFeedbacks to set
     */
    public void setCustomerFeedbacks(Set<CustomerFeedback> customerFeedbacks) {
        this.customerFeedbacks = customerFeedbacks;
    }

    /**
     * @return the employeeCustomers
     */
    public Set<EmployeeCustomer> getEmployeeCustomers() {
        return employeeCustomers;
    }

    /**
     * @param employeeCustomers the employeeCustomers to set
     */
    public void setEmployeeCustomers(Set<EmployeeCustomer> employeeCustomers) {
        this.employeeCustomers = employeeCustomers;
    }

    /**
     * @return the string id
     */
    public String getStringId() {
	return MathUtil.getFormatID(this.customerId);
    }
    
    /**
     * 
     * @return the string birthday
     */
    public String getBirth() {
	SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
	return sdf.format(this.birthday);
    }
}