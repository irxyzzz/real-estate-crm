package com.crm.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.crm.util.MathUtil;

/**
 * Employee entity. 
 * @author 
 */

public class Employee implements Serializable {

    // Fields

    private static final long serialVersionUID = 1L;

    private Integer employeeId;
    private String name;
    private String gender;
    private Date birthday;
    private Boolean isMarried;
    private String address;
    private String hobby;
    private Date comeTime;
    private String phone;
    private String email;
    private String department;
    private String post;
    private Boolean isManager;
    private String password;
    private Set<RepairRecord> repairRecords = new HashSet<RepairRecord>(0);
    private Set<Employee> housesForSaleEmployee = new HashSet<Employee>(0);
    private Set<CustomerFeedback> customerFeedbacks = new HashSet<CustomerFeedback>(0);
    private Set<AssignmentParticipant> assignmentParticipants = new HashSet<AssignmentParticipant>(0);
    private Set<Employee> housesForASEmployee = new HashSet<Employee>(0);
    private Set<CustomerSupport> customerSupports = new HashSet<CustomerSupport>(0);
    private Set<EmployeeCustomer> employeeCustomers = new HashSet<EmployeeCustomer>(0);

    // Constructors

    /** default constructor */
    public Employee() {
    }

    /** minimal constructor */
    public Employee(String name) {
	this.name = name;
    }

    /** full constructor */
    public Employee(String name, String gender, Date birthday,
	    Boolean isMarried, String address, String hobby, Date comeTime,
	    String phone, String email, String department, String post,
	    Boolean isManager, 
	    Set<RepairRecord> repairRecords, 
	    Set<Employee> housesForSaleEmployee,
	    Set<CustomerFeedback> customerFeedbacks, 
	    Set<AssignmentParticipant> assignmentParticipants,
	    Set<Employee> housesForASEmployee, 
	    Set<CustomerSupport> customerSupports,
	    Set<EmployeeCustomer> employeeCustomers) {
	this.name = name;
	this.gender = gender;
	this.birthday = birthday;
	this.isMarried = isMarried;
	this.address = address;
	this.hobby = hobby;
	this.comeTime = comeTime;
	this.phone = phone;
	this.email = email;
	this.department = department;
	this.post = post;
	this.isManager = isManager;
	this.repairRecords = repairRecords;
	this.housesForSaleEmployee = housesForSaleEmployee;
	this.customerFeedbacks = customerFeedbacks;
	this.assignmentParticipants = assignmentParticipants;
	this.housesForASEmployee = housesForASEmployee;
	this.customerSupports = customerSupports;
	this.employeeCustomers = employeeCustomers;
    }

    /**
     * @return the employeeId
     */
    public Integer getEmployeeId() {
        return employeeId;
    }

    /**
     * @param employeeId the employeeId to set
     */
    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
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
     * @return the comeTime
     */
    public Date getComeTime() {
        return comeTime;
    }

    /**
     * @param comeTime the comeTime to set
     */
    public void setComeTime(Date comeTime) {
        this.comeTime = comeTime;
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
     * @return the department
     */
    public String getDepartment() {
        return department;
    }

    /**
     * @param department the department to set
     */
    public void setDepartment(String department) {
        this.department = department;
    }

    /**
     * @return the post
     */
    public String getPost() {
        return post;
    }

    /**
     * @param post the post to set
     */
    public void setPost(String post) {
        this.post = post;
    }

    /**
     * @return the isManager
     */
    public Boolean getIsManager() {
        return isManager;
    }

    /**
     * @param isManager the isManager to set
     */
    public void setIsManager(Boolean isManager) {
        this.isManager = isManager;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
	this.password = password;
    }

    /**
     * @return the password
     */
    public String getPassword() {
	return password;
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
     * @return the housesForSaleEmployee
     */
    public Set<Employee> getHousesForSaleEmployee() {
        return housesForSaleEmployee;
    }

    /**
     * @param housesForSaleEmployee the housesForSaleEmployee to set
     */
    public void setHousesForSaleEmployee(Set<Employee> housesForSaleEmployee) {
        this.housesForSaleEmployee = housesForSaleEmployee;
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
     * @return the assignmentParticipants
     */
    public Set<AssignmentParticipant> getAssignmentParticipants() {
        return assignmentParticipants;
    }

    /**
     * @param assignmentParticipants the assignmentParticipants to set
     */
    public void setAssignmentParticipants(
    	Set<AssignmentParticipant> assignmentParticipants) {
        this.assignmentParticipants = assignmentParticipants;
    }

    /**
     * @return the housesForASEmployee
     */
    public Set<Employee> getHousesForASEmployee() {
        return housesForASEmployee;
    }

    /**
     * @param housesForASEmployee the housesForASEmployee to set
     */
    public void setHousesForASEmployee(Set<Employee> housesForASEmployee) {
        this.housesForASEmployee = housesForASEmployee;
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
     * @return the string birthday
     */
    @SuppressWarnings("deprecation")
    public String getBirth() {
	return (birthday.getMonth() + 1) + "/" + birthday.getDate()  + "/" + (birthday.getYear()+1900);
    }
    
    /**
     * @return the string come time.
     */
    @SuppressWarnings("deprecation")
    public String getStrComeTime() {
	return (comeTime.getYear() + 1900) + "-" + comeTime.getMonth() + "-" + comeTime.getDate();
    }
    
    /**
     * @return the string Id.
     */
    public String getStringId() {
	return MathUtil.getFormatID(this.employeeId);
    }
}