/**
 * 
 */
package com.crm.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import com.crm.dao.IEmployeeDAO;
import com.crm.dao.IHouseDAO;
import com.crm.dao.IResidenceCommunityDAO;
import com.crm.dao.impl.EmployeeDAO;
import com.crm.dao.impl.HouseDAO;
import com.crm.dao.impl.ResidenceCommunityDAO;
import com.crm.model.Employee;
import com.crm.model.House;
import com.crm.model.ResidenceCommunity;
import com.crm.service.IEmployeeService;
import com.crm.service.IHouseService;

/**
 * @author lenovo
 * 
 */
public class HouseService implements IHouseService {
    private IHouseDAO houseDao;
    private IEmployeeDAO employeeDAO;
    private IEmployeeService employeeService;
    private IResidenceCommunityDAO residenceCommunityDAO;

    public HouseService() {
	houseDao = new HouseDAO();
	employeeDAO = new EmployeeDAO();
	employeeService = new EmployeeService();
	residenceCommunityDAO = new ResidenceCommunityDAO();
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.crm.service.IHouseService#getAllHouseInfo()
     */
    public List<House> getAllHouseByEmployee(int employeeId) {
	List<House> houses = new ArrayList<House>();
	Employee employee = employeeDAO.findById(employeeId);
	if (employee.getIsManager()) {
	    houses = houseDao.findAll();
	}
	else {
	    List<House> allHouses = houseDao.findAll();
	    for (House house : allHouses) {
		if (house.getEmployeeBySaleEmployee().getEmployeeId() == employeeId) {
		    houses.add(house);
		}
	    }
	}
	

	Collections.sort(houses);

	return houses;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.crm.service.IHouseService#getServiceEmployee()
     */
    public List<Employee> getServiceEmployee() {
	List<Employee> serviceEmployees = new ArrayList<Employee>();

	List<Employee> allEmployees = employeeDAO.findAll();
	for (Employee employee : allEmployees) {
	    if (employee.getDepartment().trim().equals("ServiceDepartment")) {
		serviceEmployees.add(employee);
	    }
	}

	return serviceEmployees;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.crm.service.IHouseService#addNewHouseInfo(int)
     */
    public boolean addNewHouseInfo(int employeeId, String residenceId,
	    String position, String area, String price) {
	Employee saleEmployee = employeeDAO.findById(employeeId);
	Employee serviceEmployee = employeeService.getRandomServiceEmployee();

	if (residenceId != null && position != null && area != null
		&& price != null) {
	    try {
		int iResidenceId = Integer.parseInt(residenceId);
		double dArea = Double.parseDouble(area);
		double dPrice = Double.parseDouble(price);
		ResidenceCommunity rc = residenceCommunityDAO
			.findById(iResidenceId);

		House house = new House();
		house.setArea(dArea);
		house.setCustomerId(0);
		house.setEmployeeBySaleEmployee(saleEmployee); // 设置管理的销售人员
		house.setEmployeeByASEmployee(serviceEmployee); // 设置管理的售后人员
		house.setIsSale(false);
		house.setPosition(position);
		house.setPrice(dPrice);
		house.setResidenceCommunity(rc);

		houseDao.save(house);

		return true;

	    } catch (NumberFormatException nfe) {
		System.err.println(nfe.getMessage());
		return false;
	    }
	}

	return false;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.crm.service.IHouseService#getHouse(int)
     */
    public House getHouse(String stringId) {
	if (stringId != null && !stringId.equals("")) {
	    try {
		int id = Integer.parseInt(stringId);
		House house = houseDao.findById(id);
		return house;
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
     * @see com.crm.service.IHouseService#deleteHouse(java.lang.String)
     */
    public boolean deleteHouse(String stringId) {
	if (stringId != null && !stringId.equals("")) {
	    try {
		int id = Integer.parseInt(stringId);
		House house = houseDao.findById(id);
		houseDao.delete(house);
		return true;
	    } catch (NumberFormatException nfe) {
		System.err.println(nfe.getMessage());
		return false;
	    }
	}
	return false;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.crm.service.IHouseService#modifyHouseInfo(int, java.lang.String,
     * java.lang.String, java.lang.String, java.lang.String, java.lang.String)
     */
    public boolean modifyHouseInfo(String houseId, String residenceId,
	    String position, String area, String price, String isSale, String saleCustomer) {
	
	boolean result = false;
	try {
	    House house;
	    if (houseId != null && !houseId.equals("")) {
		int id = Integer.parseInt(houseId);
		house = houseDao.findById(id);
		
		if (residenceId != null && position != null && area != null
			&& price != null && isSale != null) {
		    int iResidenceId = Integer.parseInt(residenceId);
		    double dArea = Double.parseDouble(area);
		    double dPrice = Double.parseDouble(price);
		    int iCustomerId;
		    if (saleCustomer != null) {
			iCustomerId = Integer.parseInt(saleCustomer);
		    }
		    else {
			iCustomerId = 0;
		    }
		    
		    ResidenceCommunity rc = residenceCommunityDAO.findById(iResidenceId);
		    
		    house.setArea(dArea);
		    house.setPosition(position);
		    house.setPrice(dPrice);
		    house.setResidenceCommunity(rc);
		    if (isSale.equals("Y")) {
			house.setIsSale(true);
			house.setCustomerId(iCustomerId);
			house.setSaleTime(new Timestamp(new Date().getTime()));
		    }
		    else {
			house.setIsSale(false);
			house.setCustomerId(0);
		    }
		    
		    houseDao.attachDirty(house);   
		    result = true;
		}
	    }
	} catch (NumberFormatException nfe) {
	    System.err.println(nfe.getMessage());
	    return result;
	}
	return result;
    }

    /* (non-Javadoc)
     * @see com.crm.service.IHouseService#getResidenceCommunities()
     */
    public List<ResidenceCommunity> getResidenceCommunities() {
	List<ResidenceCommunity> rcs = new ArrayList<ResidenceCommunity>();
	List<ResidenceCommunity> all = residenceCommunityDAO.findAll();
	for (ResidenceCommunity rc : all) {
	    if (rc.getCompany().getCompanyId() == 1) {	// 本公司ID默认为1
		rcs.add(rc);
	    }
	    
	}
	return rcs;
    }

}
