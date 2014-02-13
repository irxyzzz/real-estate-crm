/**
 * 
 */
package com.crm.service.impl;

import com.crm.dao.IEmployeeDAO;
import com.crm.model.Employee;
import com.crm.service.ILoginService;
import com.crm.util.DAOFactory;

/**
 * @author lenovo
 * 
 */
public class LoginService implements ILoginService {

    private IEmployeeDAO employeeDAO;

    public LoginService() {
	this.employeeDAO = (IEmployeeDAO) DAOFactory.getInstance().getDAO(
		"employeeDao");
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.crm.service.ILoginService#validate(java.lang.String,
     * java.lang.String)
     */
    public Employee validateUser(String account, String password) {
	Employee employee = null;

	if (account != null && password != null && !account.equals("")
		&& !password.equals("") && account.length() == 6) {
	    String strId = account.substring(1);
	    try {
		int id = Integer.parseInt(strId);
		employee = employeeDAO.findById(id);
		if (employee != null && employee.getPassword().equals(password)) {
		    return employee;
		} else {
		    return null;
		}

	    } catch (NumberFormatException e) {
		System.err.println("账号不是数字");
		return null;
	    }

	}

	return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.crm.service.ILoginService#getRole(java.lang.String)
     */
    public String getRole(int account) {
	String result;
	Employee employee = null;
	employee = employeeDAO.findById(account);
	
	if (employee != null) {
	    result = employee.getDepartment() + "&" + employee.getIsManager();
	} else {
	    result = "";
	}

	return result;
    }

}
