/**
 * 
 */
package com.crm.service.impl;

import java.util.Date;

import com.crm.dao.IEmployeeDAO;
import com.crm.dao.impl.EmployeeDAO;
import com.crm.model.Employee;
import com.crm.service.IPersonInfoService;
import com.crm.util.DateUtil;

/**
 * @author lenovo
 *
 */
public class PersonInfoService implements IPersonInfoService {
    private IEmployeeDAO employeeDAO;
    
    public PersonInfoService() {
	employeeDAO = new EmployeeDAO();
    }

    /* (non-Javadoc)
     * @see com.crm.service.IPersonInfoService#modifyInfo(com.crm.model.Employee, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
     */
    public Employee modifyInfo(int employeeId, String name, String gender,
	    String birthday, String married, String address, String hobby,
	    String phone, String email, String department, String post) {
	
	Employee employee = employeeDAO.findById(employeeId);
	
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
	    }
	    else {
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
	
	return employee;
    }

    /* (non-Javadoc)
     * @see com.crm.service.IPersonInfoService#modifyPassword(java.lang.String, java.lang.String, java.lang.String)
     */
    public Employee modifyPassword(int id, String oldPass, String newPass,
	    String comfirm) {
	Employee employee = employeeDAO.findById(id);
	if (oldPass != null && newPass != null && comfirm != null
		&& !oldPass.equals("") && !newPass.equals("") && !comfirm.equals("")) {
	    if (employee.getPassword().trim().equals(oldPass)) {
		if (newPass.equals(comfirm)) {
		    employee.setPassword(newPass);
		    
		    employeeDAO.attachDirty(employee);
		    
		    return employee;
		}
		else {
		    return null;
		}
	    }
	    else {
		return null;
	    } 
	}
	return null;
    }

}
