package com.crm.model;

import java.io.Serializable;

/**
 * EmployeeCustomerList entity. 
 * @author 
 */

public class EmployeeCustomer implements Serializable {

    // Fields
    
    private static final long serialVersionUID = 1L;
    private Integer employeeCustomerId;
    private Employee employee;
    private Customer customer;

    // Constructors

    /** default constructor */
    public EmployeeCustomer() {
    }

    /** full constructor */
    public EmployeeCustomer(Employee employee, Customer customer) {
	this.employee = employee;
	this.customer = customer;
    }

    /**
     * @return the employeeCustomerId
     */
    public Integer getEmployeeCustomerId() {
        return employeeCustomerId;
    }

    /**
     * @param employeeCustomerId the employeeCustomerId to set
     */
    public void setEmployeeCustomerId(Integer employeeCustomerId) {
        this.employeeCustomerId = employeeCustomerId;
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

    // Property accessors
    
    
}