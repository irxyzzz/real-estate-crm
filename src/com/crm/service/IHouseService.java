/**
 * 
 */
package com.crm.service;

import java.util.List;

import com.crm.model.Employee;
import com.crm.model.House;
import com.crm.model.ResidenceCommunity;

/**
 * @author lenovo
 * 
 */
public interface IHouseService {
    public List<House> getAllHouseByEmployee(int employeeId);

    public List<Employee> getServiceEmployee();

    public boolean addNewHouseInfo(int employeeId, String residenceId,
	    String position, String area, String price);

    public House getHouse(String stringId);

    public boolean deleteHouse(String stringId);

    public boolean modifyHouseInfo(String houseId, String residenceId,
	    String position, String area, String price, String isSale,
	    String saleCustomer);
    
    public List<ResidenceCommunity> getResidenceCommunities();

}
