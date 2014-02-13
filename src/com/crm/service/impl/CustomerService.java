/**
 * 
 */
package com.crm.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.crm.dao.ICustomerCareDAO;
import com.crm.dao.ICustomerDAO;
import com.crm.dao.ICustomerFeedbackDAO;
import com.crm.dao.ICustomerSupportDAO;
import com.crm.dao.IEmployeeCustomerDAO;
import com.crm.dao.IEmployeeDAO;
import com.crm.dao.IHouseDAO;
import com.crm.dao.IRepairRecordDAO;
import com.crm.dao.impl.CustomerCareDAO;
import com.crm.dao.impl.CustomerDAO;
import com.crm.dao.impl.CustomerFeedbackDAO;
import com.crm.dao.impl.CustomerSupportDAO;
import com.crm.dao.impl.EmployeeCustomerDAO;
import com.crm.dao.impl.EmployeeDAO;
import com.crm.dao.impl.HouseDAO;
import com.crm.dao.impl.RepairRecordDAO;
import com.crm.model.Customer;
import com.crm.model.CustomerCare;
import com.crm.model.CustomerFeedback;
import com.crm.model.CustomerSupport;
import com.crm.model.Employee;
import com.crm.model.EmployeeCustomer;
import com.crm.model.House;
import com.crm.model.RepairRecord;
import com.crm.service.ICustomerService;
import com.crm.util.DateUtil;

/**
 * @author lenovo
 * 
 */
public class CustomerService implements ICustomerService {
    private ICustomerDAO customerDAO;
    private ICustomerSupportDAO customerSupportDAO;
    private ICustomerCareDAO customerCareDAO;
    private IEmployeeDAO employeeDAO;
    private ICustomerFeedbackDAO customerFeedbackDAO;
    private IRepairRecordDAO repairRecordDAO;
    private IEmployeeCustomerDAO employeeCustomerDAO;
    private IHouseDAO houseDAO;

    public CustomerService() {
	customerDAO = new CustomerDAO();
	customerSupportDAO = new CustomerSupportDAO();
	employeeDAO = new EmployeeDAO();
	customerCareDAO = new CustomerCareDAO();
	customerFeedbackDAO = new CustomerFeedbackDAO();
	repairRecordDAO = new RepairRecordDAO();
	employeeCustomerDAO = new EmployeeCustomerDAO();
	houseDAO = new HouseDAO();
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.crm.service.ICustomerService#getCustomer(java.lang.String)
     */
    public Customer getCustomer(String stringId) {
	if (stringId != null && !stringId.equals("")) {
	    try {
		int id = Integer.parseInt(stringId);
		if (id != 0) {
		    Customer customer = customerDAO.findById(id);
		    return customer;
		} else {
		    return null;
		}
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
     * @see com.crm.service.ICustomerService#getAllCustomers()
     */
    public List<Customer> getIntentCustomers(int employeeId) {
	List<Customer> intentCustomers = new ArrayList<Customer>();
	Employee employee = employeeDAO.findById(employeeId);
	if (employee != null && employee.getIsManager()) {
	    List<Customer> allCustomer = customerDAO.findAll();
	    for (Customer customer : allCustomer) {
		if (!customer.getHasHouse()) {
		    intentCustomers.add(customer);
		}
	    }
	} else {
	    List<Customer> allCustomer = customerDAO.findAll();
	    for (Customer customer : allCustomer) {
		if (!customer.getHasHouse() && isEmployeeCustomer(employeeId, customer.getCustomerId())) {
		    intentCustomers.add(customer);
		}
	    }
	}

	return intentCustomers;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.crm.service.ICustomerService#getAlreadyCustomers()
     */
    public List<Customer> getAlreadyCustomers(int employeeId) {
	List<Customer> alreadyCustomers = new ArrayList<Customer>();

	Employee employee = employeeDAO.findById(employeeId);
	if (employee != null && employee.getIsManager()) {
	    List<Customer> allCustomer = customerDAO.findAll();
	    for (Customer customer : allCustomer) {
		if (customer.getHasHouse()) {
		    alreadyCustomers.add(customer);
		}
	    }
	} else {
	    List<Customer> allCustomer = customerDAO.findAll();
	    for (Customer customer : allCustomer) {
		if (customer.getHasHouse() && isEmployeeCustomer(employeeId, customer.getCustomerId())) {
		    alreadyCustomers.add(customer);
		}
	    }
	}

	return alreadyCustomers;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.crm.service.ICustomerService#isEmployeeCustomer(int)
     */
    public boolean isEmployeeCustomer(int employeeId, int customerId) {
	List<EmployeeCustomer> ecs = employeeCustomerDAO.findAll();
	for (EmployeeCustomer ec : ecs) {
	    if (ec.getEmployee().getEmployeeId() == employeeId
		    && ec.getCustomer().getCustomerId() == customerId) {
		return true;
	    }
	}
	return false;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.crm.service.ICustomerService#getCustomerSupports()
     */
    public List<CustomerSupport> getCustomerSupports(int employeeId) {
	Employee employee = employeeDAO.findById(employeeId);
	List<CustomerSupport> css = new ArrayList<CustomerSupport>();

	if (employee != null && employee.getIsManager()) {
	    List<CustomerSupport> allCss = customerSupportDAO.findAll();
	    css.addAll(allCss);
	} else {
	    List<CustomerSupport> allCss = customerSupportDAO.findAll();
	    for (CustomerSupport cs : allCss) {
		if (cs.getEmployee().getEmployeeId() == employeeId) {
		    css.add(cs);
		}
	    }
	}
	return css;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.crm.service.ICustomerService#addCustomerSupport(int,
     * java.lang.String, java.lang.String, java.lang.String)
     */
    public boolean addCustomerSupport(int employeeId, String customerId,
	    String content, String reply) {
	if (customerId != null && content != null && reply != null) {
	    try {
		int id = Integer.parseInt(customerId);
		Employee employee = employeeDAO.findById(employeeId);
		Customer customer = customerDAO.findById(id);

		CustomerSupport cs = new CustomerSupport();
		cs.setEmployee(employee);
		cs.setCustomer(customer);
		cs.setContent(content);
		cs.setReply(reply);
		cs.setRecordTime(new Timestamp(new Date().getTime()));

		customerSupportDAO.save(cs);

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
     * @see com.crm.service.ICustomerService#deleteCustomerSupport(int)
     */
    public boolean deleteCustomerSupport(String customerSupportId) {
	if (customerSupportId != null && !customerSupportId.equals("")) {
	    try {
		int id = Integer.parseInt(customerSupportId);
		CustomerSupport cs = customerSupportDAO.findById(id);
		customerSupportDAO.delete(cs);
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
     * @see com.crm.service.ICustomerService#getCustomerCares()
     */
    @SuppressWarnings("deprecation")
    public List<CustomerCare> getCustomerCares() {
	List<CustomerCare> showCares = new ArrayList<CustomerCare>();
	List<CustomerCare> all = customerCareDAO.findAll();
	Date today = new Date();
	Date date;
	for (CustomerCare cc : all) {
	    date = cc.getActivityTime();
	    if (date.after(today)) {
		showCares.add(cc);
	    }
	}
	
	List<Customer> allCustomers = customerDAO.findAll();
	Date birthday;
	int todayMonth = today.getMonth();
	int day = today.getDate();
	for (Customer c : allCustomers) {		// 显示当月，今天以前的客户客户生日
	    birthday = c.getBirthday();
	    if (birthday.getMonth() == todayMonth && day < birthday.getDate() ) {
		CustomerCare cc = new CustomerCare();
		cc.setTitle("客户生日");
		cc.setForm("生日祝福");
		cc.setDecription(c.getName() + "的生日要到了，送上祝福吧");
		cc.setCustomerType("已有用户");
		cc.setActivityTime(new Timestamp(new Date(today.getYear(), today.getMonth(), birthday.getDate()).getTime()));
		cc.setCustomerCareId(00000);
		showCares.add(cc);
	    }
	}
	
	return showCares;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.crm.service.ICustomerService#addCustomerCare(java.lang.String,
     * java.lang.String, java.lang.String, java.lang.String, java.lang.String)
     */
    public boolean addCustomerCare(String title, String description,
	    String activeTime, String activeForm, String customerType) {
	if (title != null && description != null && activeTime != null
		&& activeForm != null && customerType != null) {
	    CustomerCare customerCare = new CustomerCare();
	    customerCare.setTitle(title);
	    customerCare.setDecription(description);
	    customerCare.setActivityTime(new Timestamp(DateUtil.toDateFormat(
		    activeTime).getTime()));
	    customerCare.setForm(activeForm);
	    customerCare.setCustomerType(customerType);

	    customerCareDAO.save(customerCare);
	    return true;
	}

	return false;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.crm.service.ICustomerService#delCustomerCare(java.lang.String)
     */
    public boolean delCustomerCare(String customerCareId) {
	if (customerCareId != null && !customerCareId.equals("")) {
	    try {
		int id = Integer.parseInt(customerCareId);
		CustomerCare cc = customerCareDAO.findById(id);
		customerCareDAO.delete(cc);
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
     * @see com.crm.service.ICustomerService#getCustomerFeedback(int)
     */
    public List<CustomerFeedback> getCustomerFeedback() {
	List<CustomerFeedback> cfs = customerFeedbackDAO.findAll();
	return cfs;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.crm.service.ICustomerService#deleteCustomerFeedback(java.lang.String)
     */
    public boolean deleteCustomerFeedback(String cfId) {
	if (cfId != null) {
	    try {
		int id = Integer.parseInt(cfId);
		CustomerFeedback cf = customerFeedbackDAO.findById(id);
		customerFeedbackDAO.delete(cf);
		return true;
	    } catch (NumberFormatException nfe) {
		System.out.println(nfe.getMessage());
		return false;
	    }
	}
	return false;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.crm.service.ICustomerService#addCustomerFeedback(java.lang.String,
     * java.lang.String, java.lang.String, java.lang.String, java.lang.String,
     * java.lang.String, java.lang.String, java.lang.String)
     */
    public boolean addCustomerFeedback(String customerId, String employeeId,
	    String markforSeller, String markForEnvironment,
	    String markForTenement, String markForTraffic, String totalMark,
	    String advice) {
	if (customerId != null && employeeId != null && markforSeller != null
		&& markForEnvironment != null && markForTenement != null
		&& markForTraffic != null && totalMark != null) {
	    try {
		int cId = Integer.parseInt(customerId);
		int eId = Integer.parseInt(employeeId);
		Employee employee = employeeDAO.findById(eId);
		Customer customer = customerDAO.findById(cId);
		CustomerFeedback cf = new CustomerFeedback();
		cf.setAdviceSeller(advice);
		cf.setCustomer(customer);
		cf.setEmployee(employee);
		cf.setMarkAll(Integer.parseInt(totalMark));
		cf.setMarkEnvironment(Integer.parseInt(markForEnvironment));
		cf.setMarkSeller(Integer.parseInt(markforSeller));
		cf.setMarkTenement(Integer.parseInt(markForTenement));
		cf.setMarkTraffic(Integer.parseInt(markForTraffic));
		cf.setRecordTime(new Timestamp(new Date().getTime()));

		customerFeedbackDAO.attachDirty(cf);
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
     * @see com.crm.service.ICustomerService#getRepairRecords(int)
     */
    public List<RepairRecord> getRepairRecords(int employeeId) {
	Employee employee = employeeDAO.findById(employeeId);
	List<RepairRecord> rrs = new ArrayList<RepairRecord>();
	if (employee != null && employee.getIsManager()) {
	    rrs.addAll(repairRecordDAO.findAll());
	} else {
	    List<RepairRecord> allRR = repairRecordDAO.findAll();
	    for (RepairRecord rr : allRR) {
		if (rr.getEmployee().getEmployeeId() == employeeId) {
		    rrs.add(rr);
		}
	    }
	}
	return rrs;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.crm.service.ICustomerService#deleteRepairRecord(java.lang.String)
     */
    public boolean deleteRepairRecord(String repairRecordId) {
	if (repairRecordId != null) {
	    try {
		int id = Integer.parseInt(repairRecordId);
		RepairRecord rr = repairRecordDAO.findById(id);
		repairRecordDAO.delete(rr);
		return true;
	    } catch (NumberFormatException nfe) {
		System.out.println(nfe.getMessage());
		return false;
	    }
	}
	return false;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.crm.service.ICustomerService#addRepairRecord(int,
     * java.lang.String, java.lang.String, java.lang.String, java.lang.String,
     * java.lang.String)
     */
    public boolean addRepairRecord(int employeeId, String customerId,
	    String description, String handle, String endTime) {
	if (customerId != null && description != null && endTime != null
		&& handle != null) {
	    try {
		int cId = Integer.parseInt(customerId);
		Employee employee = employeeDAO.findById(employeeId);
		Customer customer = customerDAO.findById(cId);
		RepairRecord rr = new RepairRecord();
		rr.setBeginTime(new Timestamp(new Date().getTime()));
		rr.setEndTime(new Timestamp(DateUtil.toDateFormat(endTime)
			.getTime()));
		rr.setCustomer(customer);
		rr.setEmployee(employee);
		rr.setDecription(description);
		rr.setHandle(handle);
		rr.setIsVerify(false);
		rr.setNewHandle("");

		repairRecordDAO.save(rr);
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
     * @see com.crm.service.ICustomerService#getUnverifyRepairRecords(int)
     */
    public List<RepairRecord> getUnverifyRepairRecords(int employeeId) {
	List<RepairRecord> rrs = new ArrayList<RepairRecord>();
	Employee employee = employeeDAO.findById(employeeId);
	if (employee != null && employee.getIsManager()) {
	    List<RepairRecord> allRR = repairRecordDAO.findAll();
	    for (RepairRecord rr : allRR) {
		if (!rr.getIsVerify()) {
		    rrs.add(rr);
		}
	    }
	}
	return rrs;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.crm.service.ICustomerService#getVerifyRepairRecords(int)
     */
    public List<RepairRecord> getVerifyRepairRecords(int employeeId) {
	List<RepairRecord> rrs = new ArrayList<RepairRecord>();
	Employee employee = employeeDAO.findById(employeeId);
	if (employee != null && employee.getIsManager()) {
	    List<RepairRecord> allRR = repairRecordDAO.findAll();
	    for (RepairRecord rr : allRR) {
		if (rr.getIsVerify()) {
		    rrs.add(rr);
		}
	    }
	}
	return rrs;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.crm.service.ICustomerService#getRepairRecord(java.lang.String)
     */
    public RepairRecord getRepairRecord(String repairId) {
	if (repairId != null && !repairId.equals("")) {
	    try {
		int id = Integer.parseInt(repairId);
		RepairRecord rr = repairRecordDAO.findById(id);

		return rr;
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
     * @see
     * com.crm.service.ICustomerService#verifyRepairRecord(java.lang.String,
     * java.lang.String, java.lang.String)
     */
    public boolean verifyRepairRecord(String repairId, String verify,
	    String newHandle) {
	if (repairId != null) {
	    try {
		int id = Integer.parseInt(repairId);
		RepairRecord rr = repairRecordDAO.findById(id);
		if (verify != null && verify.equals("on")) {
		    rr.setIsVerify(true);
		    if (newHandle != null && !"".equals(newHandle)) {
			rr.setNewHandle(newHandle);
		    } else {
			rr.setNewHandle("同意原处理方案");
		    }
		} else {
		    if (newHandle != null && !"".equals(newHandle)) {
			rr.setIsVerify(true);
			rr.setNewHandle(newHandle);
		    } else {
			rr.setNewHandle("");
		    }
		}
		repairRecordDAO.attachDirty(rr);
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
     * @see com.crm.service.ICustomerService#addCustomer(int, java.lang.String,
     * java.lang.String, java.lang.String, java.lang.String, java.lang.String,
     * java.lang.String, java.lang.String, java.lang.String, java.lang.String,
     * java.lang.String, java.lang.String, java.lang.String, java.lang.String)
     */
    public boolean addCustomer(int employeeId, String name, String gender,
	    String birthday, String address, String married, String phone,
	    String email, String intent, String income, String job,
	    String hobby, String saleEmployeeId, String serviceEmployeeId) {

	if (saleEmployeeId != null && serviceEmployeeId != null && name != null
		&& gender != null && birthday != null && phone != null
		&& email != null) {
	    try {
		int saleId = Integer.parseInt(saleEmployeeId);
		int serviceId = Integer.parseInt(serviceEmployeeId);
		Employee saleEmployee = employeeDAO.findById(saleId);
		Employee serviceEmployee = employeeDAO.findById(serviceId);
		Employee marketEmployee = employeeDAO.findById(employeeId);

		Customer c = new Customer();
		c.setAddress(address);
		c.setBirthday(DateUtil.toDateFormat(birthday));
		c.setEmail(email);
		c.setGender(gender);
		c.setHasHouse(false);
		c.setHobby(hobby);
		c.setHouseId(0);
		c.setHouseIntent(intent);
		c.setIncome(income);
		c.setIncome(income);
		if (married != null && married.equals("Y")) {
		    c.setIsMarried(true);
		} else {
		    c.setIsMarried(false);
		}
		c.setJob(job);
		c.setName(name);
		c.setPhone(phone);

		customerDAO.save(c);

		EmployeeCustomer ec1 = new EmployeeCustomer();
		ec1.setCustomer(c);
		ec1.setEmployee(saleEmployee);
		EmployeeCustomer ec2 = new EmployeeCustomer();
		ec2.setCustomer(c);
		ec2.setEmployee(serviceEmployee);
		EmployeeCustomer ec3 = new EmployeeCustomer();
		ec3.setCustomer(c);
		ec3.setEmployee(marketEmployee);
		employeeCustomerDAO.save(ec1);
		employeeCustomerDAO.save(ec2);
		employeeCustomerDAO.save(ec3);

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
     * @see com.crm.service.ICustomerService#modifyCustomer(int,
     * java.lang.String, java.lang.String, java.lang.String, java.lang.String,
     * java.lang.String, java.lang.String, java.lang.String, java.lang.String,
     * java.lang.String, java.lang.String, java.lang.String)
     */
    public boolean modifyCustomer(int employeeId, String customerId,
	    String name, String gender, String birthday, String address,
	    String married, String phone, String email, String intent,
	    String income, String job, String hobby) {

	Employee employee = employeeDAO.findById(employeeId);
	if (employee != null
		&& employee.getDepartment().equals("MarketDepartment")) {

	    if (customerId != null && name != null && gender != null
		    && birthday != null && phone != null && email != null) {

		try {
		    int id = Integer.parseInt(customerId);
		    Customer c = customerDAO.findById(id);
		    c.setAddress(address);
		    c.setBirthday(DateUtil.toDateFormat(birthday));
		    c.setEmail(email);
		    c.setGender(gender);
		    if (c.getHasHouse()) {
			c.setHasHouse(true);
		    }
		    else {
			c.setHasHouse(false);
		    }
		    
		    c.setHobby(hobby);
		    c.setHouseId(0);
		    c.setHouseIntent(intent);
		    c.setIncome(income);
		    if (married != null && married.equals("Y")) {
			c.setIsMarried(true);
		    } else {
			c.setIsMarried(false);
		    }
		    c.setJob(job);
		    c.setName(name);
		    c.setPhone(phone);

		    customerDAO.attachDirty(c);

		    return true;

		} catch (NumberFormatException nfe) {
		    System.err.println(nfe.getMessage());
		    return false;
		}
	    }
	    return false;
	} else {

	    return false;
	}
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.crm.service.ICustomerService#buyHouse(java.lang.String,
     * java.lang.String)
     */
    public boolean buyHouse(String customerId, String houseId) {
	if (customerId != null && houseId != null
		&& !customerId.equals("") && !houseId.equals("") 
		&& houseId.length() == 6) {
	    try {
		int cId = Integer.parseInt(customerId.trim());
		int hId = Integer.parseInt(houseId.trim().substring(1));
		House house = houseDAO.findById(hId);
		Customer customer = customerDAO.findById(cId);
		if (house != null && customer != null) { 
		    house.setIsSale(true);
		    house.setCustomerId(cId);
		    house.setSaleTime(new Timestamp(new Date().getTime()));
		    houseDAO.attachDirty(house);
		    
		    customer.setHasHouse(true);
		    customer.setHouseId(hId);
		    customerDAO.attachDirty(customer);
		}
		else {
		    return false;
		}
		return true;
	    } catch (NumberFormatException nfe) {
		System.err.println(nfe.getMessage());
		return false;
	    }
	}
	return false;
    }

    /* (non-Javadoc)
     * @see com.crm.service.ICustomerService#deleteCustomer(java.lang.String)
     */
    public boolean deleteCustomer(String customerId) {
	if (customerId != null && !customerId.equals("")) {
	    try {
		int id = Integer.parseInt(customerId);
		Customer c = customerDAO.findById(id);
		customerDAO.delete(c);
		return true;
	    } catch (NumberFormatException nfe) {
		System.err.println(nfe.getMessage());
		return false;
	    }
	}
	return false;
    }
}
