/**
 * 
 */
package com.crm.service;

import java.util.List;

import com.crm.model.Customer;
import com.crm.model.Employee;

/**
 * @author lenovo
 * 
 */
public interface IEmployeeService {
    public Employee getRandomServiceEmployee();

    public Employee getRandomSaleEmployee();

    public Employee getEmployee(String employeeId);

    public List<Employee> getServiceEmployees();

    public List<Employee> getSaleEmployees();

    public List<Employee> getMarketEmployees();

    public List<Employee> getAllEmployees();

    public List<Employee> getAllManagers();

    public List<Employee> getDepartmentEmployees(int employeeId);

    public List<Customer> getEmployeeCustomers(int emplpyeeId);

    public boolean isManger(int emplpyeeId);

    public boolean addEmployee(int employeeId, String name, String gender,
	    String phone, String email, String address, String birthday,
	    String married, String post, String hobby);

    public boolean modifyEmployee(String employeeId, String name,
	    String gender, String birthday, String married, String address,
	    String hobby, String phone, String email, String department,
	    String post);
    
    public boolean adminModifyEmployee(String employeeId, String name,
	    String gender, String birthday, String married, String address,
	    String hobby, String phone, String email, String department,
	    String post, String password, String isMarried);
    
    public boolean adminAddEmployee(String name, String gender,
	    String phone, String email, String address, String birthday,
	    String married, String post, String hobby, String department, String isManager);

    public boolean deleteEmployee(String emplpyeeId);
}
