/**
 * 
 */
package com.crm.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.crm.dao.IEmployeeCustomerDAO;
import com.crm.dao.IEmployeeDAO;
import com.crm.dao.impl.EmployeeCustomerDAO;
import com.crm.dao.impl.EmployeeDAO;
import com.crm.model.Customer;
import com.crm.model.Employee;
import com.crm.model.EmployeeCustomer;
import com.crm.service.IEmployeeService;
import com.crm.util.DateUtil;
import com.crm.util.MathUtil;

/**
 * @author lenovo
 * 
 */
public class EmployeeService implements IEmployeeService {
    private IEmployeeDAO employeeDAO;
    private IEmployeeCustomerDAO employeeCustomerDAO;

    public EmployeeService() {
	this.employeeDAO = new EmployeeDAO();
	this.employeeCustomerDAO = new EmployeeCustomerDAO();
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.crm.service.IEmployeeService#getRandomServiceEmployee()
     */
    public Employee getRandomServiceEmployee() {
	List<Employee> employees = getServiceEmployees();
	int index = MathUtil.getRandom(employees.size());

	return employees.get(index);
    }
    
    /* (non-Javadoc)
     * @see com.crm.service.IEmployeeService#getRandomSaleEmployee()
     */
    public Employee getRandomSaleEmployee() {
	List<Employee> employees = getSaleEmployees();
	int index = MathUtil.getRandom(employees.size()); 
	return employees.get(index);
    }


    /*
     * (non-Javadoc)
     * 
     * @see com.crm.service.IEmployeeService#getServiceEmployees()
     */
    public List<Employee> getServiceEmployees() {
	List<Employee> serviceEmployees = new ArrayList<Employee>();

	List<Employee> allEmployees = employeeDAO.findAll();
	for (Employee employee : allEmployees) {
	    if (employee.getDepartment() != null
		    && employee.getDepartment().equals("ServiceDepartment")) {
		serviceEmployees.add(employee);
	    }
	}

	return serviceEmployees;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.crm.service.IEmployeeService#getEmployeeCustomers()
     */
    public List<Customer> getEmployeeCustomers(int emplpyeeId) {
	Employee employee = employeeDAO.findById(emplpyeeId);
	List<Customer> customers = new ArrayList<Customer>();

	if (employee != null && employee.getIsManager()) {
	    List<EmployeeCustomer> ecs = employeeCustomerDAO.findAll();
	    for (EmployeeCustomer ec : ecs) {
		if (ec.getEmployee().getDepartment().equals("SaleDepartment")) {
		    customers.add(ec.getCustomer());
		}
	    }
	} else {
	    List<EmployeeCustomer> ecs = employeeCustomerDAO.findAll();
	    for (EmployeeCustomer ec : ecs) {
		if (ec.getEmployee().getEmployeeId() == emplpyeeId) {
		    customers.add(ec.getCustomer());
		}
	    }
	}

	return customers;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.crm.service.IEmployeeService#getSaleEmployees()
     */
    public List<Employee> getSaleEmployees() {
	List<Employee> saleEmployees = new ArrayList<Employee>();

	List<Employee> allEmployees = employeeDAO.findAll();
	for (Employee employee : allEmployees) {
	    if (employee.getDepartment() != null
		    && employee.getDepartment().equals("SaleDepartment")) {
		saleEmployees.add(employee);
	    }
	}

	return saleEmployees;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.crm.service.IEmployeeService#isManger(int)
     */
    public boolean isManger(int emplpyeeId) {
	return employeeDAO.findById(emplpyeeId).getIsManager();
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.crm.service.IEmployeeService#getMarketEmployees()
     */
    public List<Employee> getMarketEmployees() {
	List<Employee> marketEmployees = new ArrayList<Employee>();

	List<Employee> allEmployees = employeeDAO.findAll();
	for (Employee employee : allEmployees) {
	    if (employee.getDepartment() != null
		    && employee.getDepartment().equals("MarketDepartment")) {
		marketEmployees.add(employee);
	    }
	}

	return marketEmployees;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.crm.service.IEmployeeService#getDepartmentEmployees(int)
     */
    public List<Employee> getDepartmentEmployees(int employeeId) {
	List<Employee> employees = new ArrayList<Employee>();
	Employee manager = employeeDAO.findById(employeeId);

	List<Employee> allEmployees = employeeDAO.findAll();
	for (Employee employee : allEmployees) {
	    if (employee.getDepartment() != null
		    && employee.getDepartment().equals(manager.getDepartment())
		    && !employee.getIsManager()) {
		employees.add(employee);
	    }
	}

	return employees;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.crm.service.IEmployeeService#addEmployee(int, java.lang.String,
     * java.lang.String, java.lang.String, java.lang.String, java.lang.String,
     * java.lang.String, java.lang.String, java.lang.String, java.lang.String)
     */
    public boolean addEmployee(int employeeId, String name, String gender,
	    String phone, String email, String address, String birthday,
	    String married, String post, String hobby) {

	Employee employee = employeeDAO.findById(employeeId);
	if (name != null && gender != null && phone != null && email != null
		&& address != null && birthday != null && married != null) {
	    Employee newEmployee = new Employee();
	    newEmployee.setAddress(address);
	    newEmployee.setBirthday(DateUtil.toDateFormat(birthday));
	    newEmployee.setComeTime(new Date());
	    newEmployee.setDepartment(employee.getDepartment());
	    newEmployee.setEmail(email);
	    newEmployee.setGender(gender);
	    newEmployee.setHobby(hobby);
	    newEmployee.setIsManager(false);
	    if (married.equals("Y")) {
		newEmployee.setIsMarried(true);
	    } else {
		newEmployee.setIsMarried(false);
	    }
	    newEmployee.setName(name);
	    newEmployee.setPassword("000000");
	    newEmployee.setPhone(phone);
	    newEmployee.setPost(post);

	    employeeDAO.save(newEmployee);
	    return true;
	}

	return false;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.crm.service.IEmployeeService#getEmployee(String)
     */
    public Employee getEmployee(String employeeId) {
	if (employeeId != null) {
	    try {
		int id = Integer.parseInt(employeeId);
		Employee employee = employeeDAO.findById(id);

		return employee;
	    } catch (NumberFormatException nfe) {
		System.err.println(nfe.getMessage());
		return null;
	    }
	}
	return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.crm.service.IEmployeeService#deleteEmployee(java.lang.String)
     */
    public boolean deleteEmployee(String emplpyeeId) {
	if (emplpyeeId != null) {
	    try {
		int id = Integer.parseInt(emplpyeeId);
		Employee employee = employeeDAO.findById(id);

		employeeDAO.delete(employee);
		return true;
	    } catch (NumberFormatException nfe) {
		System.out.print(nfe.getMessage());
		return false;
	    }
	}
	return false;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.crm.service.IEmployeeService#modifyInfo(java.lang.String,
     * java.lang.String, java.lang.String, java.lang.String, java.lang.String,
     * java.lang.String, java.lang.String, java.lang.String, java.lang.String,
     * java.lang.String, java.lang.String)
     */
    public boolean modifyEmployee(String employeeId, String name,
	    String gender, String birthday, String married, String address,
	    String hobby, String phone, String email, String department,
	    String post) {
	Employee employee;
	try {
	    int id = Integer.parseInt(employeeId);
	    employee = employeeDAO.findById(id);

	    if (name != null && !name.equals("")) {
		employee.setName(name);
	    }

	    if (gender != null && !gender.equals("")) {
		employee.setGender(gender);
	    }

	    if (birthday != null && !birthday.equals("")) {
		Date birth = DateUtil.toDateFormat(birthday);
		if (birth != null) {
		    employee.setBirthday(birth);
		}
	    }

	    if (married != null && !married.equals("")) {
		if (married.equals("Y")) {
		    employee.setIsMarried(true);
		} else {
		    employee.setIsMarried(false);
		}
	    }

	    if (address != null && !address.equals("")) {
		employee.setAddress(address);
	    }

	    if (hobby != null && !hobby.equals("")) {
		employee.setHobby(hobby);
	    }

	    if (phone != null && !phone.equals("")) {
		employee.setPhone(phone);
	    }

	    if (email != null && !email.equals("")) {
		employee.setEmail(email);
	    }

	    if (department != null && !department.equals("")) {
		employee.setDepartment(department);
	    }

	    if (post != null && !post.equals("")) {
		employee.setPost(post);
	    }

	    employeeDAO.attachDirty(employee);

	} catch (NumberFormatException nfe) {
	    System.out.println(nfe.getMessage());
	    return false;
	}

	return false;
    }

    /* (non-Javadoc)
     * @see com.crm.service.IEmployeeService#getAllEmployees()
     */
    public List<Employee> getAllEmployees() {
	List<Employee> employees = new ArrayList<Employee>();
	List<Employee> all = employeeDAO.findAll();
	for (Employee employee : all) {
	    if (!employee.getIsManager()) {
		employees.add(employee);
	    }
	}
	return employees;
    }

    /* (non-Javadoc)
     * @see com.crm.service.IEmployeeService#getAllManagers()
     */
    public List<Employee> getAllManagers() {
	List<Employee> employees = new ArrayList<Employee>();
	List<Employee> all = employeeDAO.findAll();
	for (Employee employee : all) {
	    if (employee.getIsManager()) {
		employees.add(employee);
	    }
	}
	return employees;
    }

    /* (non-Javadoc)
     * @see com.crm.service.IEmployeeService#adminModifyEmployee(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
     */
    public boolean adminModifyEmployee(String employeeId, String name,
	    String gender, String birthday, String married, String address,
	    String hobby, String phone, String email, String department,
	    String post, String password, String isMarried) {
	Employee employee;
	try {
	    int id = Integer.parseInt(employeeId);
	    employee = employeeDAO.findById(id);

	    if (name != null && !name.equals("")) {
		employee.setName(name);
	    }

	    if (gender != null && !gender.equals("")) {
		employee.setGender(gender);
	    }

	    if (birthday != null && !birthday.equals("")) {
		Date birth = DateUtil.toDateFormat(birthday);
		if (birth != null) {
		    employee.setBirthday(birth);
		}
	    }

	    if (married != null && !married.equals("")) {
		if (married.equals("Y")) {
		    employee.setIsMarried(true);
		} else {
		    employee.setIsMarried(false);
		}
	    }

	    if (address != null && !address.equals("")) {
		employee.setAddress(address);
	    }

	    if (hobby != null && !hobby.equals("")) {
		employee.setHobby(hobby);
	    }

	    if (phone != null && !phone.equals("")) {
		employee.setPhone(phone);
	    }

	    if (email != null && !email.equals("")) {
		employee.setEmail(email);
	    }

	    if (department != null && !department.equals("")) {
		employee.setDepartment(department);
	    }

	    if (post != null && !post.equals("")) {
		employee.setPost(post);
	    }
	    
	    if (password != null && !password.equals("")) {
		employee.setPassword(password);
	    }
	    
	    if (isMarried != null && !isMarried.equals("")) {
		if (isMarried.equals("Y")) {
		    employee.setIsManager(true);
		}
		else {
		    employee.setIsManager(false);
		}
	    }

	    employeeDAO.attachDirty(employee);

	} catch (NumberFormatException nfe) {
	    System.out.println(nfe.getMessage());
	    return false;
	}

	return false;
    }

    /* (non-Javadoc)
     * @see com.crm.service.IEmployeeService#adminAddEmployee(int, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
     */
    public boolean adminAddEmployee(String name, String gender,
	    String phone, String email, String address, String birthday,
	    String married, String post, String hobby, String department,
	    String manager) {
	if (name != null && gender != null && phone != null && email != null
		&& address != null && birthday != null && married != null
		&& manager != null && department != null) {
	    Employee newEmployee = new Employee();
	    newEmployee.setAddress(address);
	    newEmployee.setBirthday(DateUtil.toDateFormat(birthday));
	    newEmployee.setComeTime(new Date());
	    newEmployee.setDepartment(department);
	    newEmployee.setEmail(email);
	    newEmployee.setGender(gender);
	    newEmployee.setHobby(hobby);
	    newEmployee.setIsManager(false);
	    if (married.equals("Y")) {
		newEmployee.setIsMarried(true);
	    } else {
		newEmployee.setIsMarried(false);
	    }
	    if (manager.equals("Y")) {
		newEmployee.setIsManager(true);
	    }
	    else {
		newEmployee.setIsManager(false);
	    }
	    newEmployee.setName(name);
	    newEmployee.setPassword("000000");
	    newEmployee.setPhone(phone);
	    newEmployee.setPost(post);

	    employeeDAO.save(newEmployee);
	    return true;
	}

	return false;
    }

    
}
