/**
 * 
 */
package com.crm.service;

import java.util.List;

import com.crm.model.Customer;
import com.crm.model.CustomerCare;
import com.crm.model.CustomerFeedback;
import com.crm.model.CustomerSupport;
import com.crm.model.RepairRecord;

/**
 * @author lenovo
 * 
 */
public interface ICustomerService {
    public Customer getCustomer(String strigId);

    public List<Customer> getIntentCustomers(int employeeId);

    public List<Customer> getAlreadyCustomers(int employeeId);

    public boolean addCustomer(int employeeId, String name, String gender,
	    String birthday, String address, String married, String phone,
	    String email, String intent, String income, String job,
	    String hobby, String saleEmployeeId, String serviceEmployeeId);
    
    public boolean modifyCustomer(int employeeId, String customerId, String name, String gender,
	    String birthday, String address, String married, String phone,
	    String email, String intent, String income, String job,
	    String hobby);
    
    public boolean deleteCustomer(String customerId);

    public boolean isEmployeeCustomer(int employeeId, int customerId);

    public List<CustomerSupport> getCustomerSupports(int employeeId);

    public boolean addCustomerSupport(int employeeId, String customerId,
	    String content, String reply);

    public boolean deleteCustomerSupport(String customerSupportId);

    public List<CustomerCare> getCustomerCares();

    public boolean addCustomerCare(String title, String description,
	    String activeTime, String activeForm, String customerType);

    public boolean delCustomerCare(String customerCareId);

    public List<CustomerFeedback> getCustomerFeedback();

    public boolean deleteCustomerFeedback(String cfId);

    public boolean addCustomerFeedback(String customerId, String employeeId,
	    String markforSeller, String markForEnvironment,
	    String markForTenement, String markForTraffic, String totalMark,
	    String advice);

    public List<RepairRecord> getRepairRecords(int employeeId);

    public List<RepairRecord> getVerifyRepairRecords(int employeeId);

    public List<RepairRecord> getUnverifyRepairRecords(int employeeId);

    public boolean deleteRepairRecord(String repairRecordId);

    public boolean addRepairRecord(int employeeId, String customerId,
	    String description, String handle, String endTime);

    public RepairRecord getRepairRecord(String repairId);

    public boolean verifyRepairRecord(String repairId, String verify,
	    String newHandle);
    
    public boolean buyHouse(String customerId, String housrId);
}
