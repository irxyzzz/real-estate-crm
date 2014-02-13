/**
 * 
 */
package com.crm.service;

/**
 * @author lenovo
 *
 */
public interface IAnalysisService {
    public String showCustomerCountsByGender(int employeeId);
    public String showCustomerCountsByAge();
    public String showCustomerCountsByMarry();
    public String showCustomerCountsByIncom();
    public String showCustomerCountsByJob();
    public String showCustomerCountsByHobby();
    
    public String showHouseCountsByMonth();
    public String showHouseCountsByArea();
    public String showHouseCountsByPrice();
    
    public String showContactCountsByLastMonth();
    
    public String showFixCountsByMonth();
    public String showFixCountsByResidence();
    
    public String showValueSale();
    public String showValueEmvironment();
    public String showValueTenement();
    public String showValueTraffic();
    public String showValueAll();
    public String showValueIndiSale();
}
