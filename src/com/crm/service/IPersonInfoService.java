/**
 * 
 */
package com.crm.service;

import com.crm.model.Employee;

/**
 * @author lenovo
 * 
 */
public interface IPersonInfoService {
    public Employee modifyInfo(int employeeId, String name, String gender,
	    String birthday, String married, String address, String hobby,
	    String phone, String email, String department, String post);
    public Employee modifyPassword(int employeeId, String oldPass, String newPass, String comfirm);
}
