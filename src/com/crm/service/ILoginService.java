/**
 * 
 */
package com.crm.service;

import com.crm.model.Employee;

/**
 * 
 * @author 
 * @createTime 2010.07.26
 * @latestModifyTime 2010.07.26
 */
public interface ILoginService {
    public Employee validateUser(String account, String password);
    public String getRole(int account);
}
