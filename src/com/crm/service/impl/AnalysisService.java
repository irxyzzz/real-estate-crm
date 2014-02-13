/**
 * 
 */
package com.crm.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.crm.dao.ICustomerDAO;
import com.crm.dao.ICustomerFeedbackDAO;
import com.crm.dao.ICustomerSupportDAO;
import com.crm.dao.IEmployeeDAO;
import com.crm.dao.IHouseDAO;
import com.crm.dao.IRepairRecordDAO;
import com.crm.dao.impl.CustomerDAO;
import com.crm.dao.impl.CustomerFeedbackDAO;
import com.crm.dao.impl.CustomerSupportDAO;
import com.crm.dao.impl.EmployeeDAO;
import com.crm.dao.impl.HouseDAO;
import com.crm.dao.impl.RepairRecordDAO;
import com.crm.model.Customer;
import com.crm.model.CustomerFeedback;
import com.crm.model.CustomerSupport;
import com.crm.model.Employee;
import com.crm.model.House;
import com.crm.model.RepairRecord;
import com.crm.model.ResidenceCommunity;
import com.crm.service.IAnalysisService;
import com.crm.service.ICustomerService;

/**
 * @author lenovo
 * 
 */
public class AnalysisService implements IAnalysisService {
    private static String DEL = "#$";
    private ICustomerDAO customerDAO;
    private ICustomerService customerService;
    private IHouseDAO houseDAO;
    private ICustomerSupportDAO customerSupportDAO;
    private IRepairRecordDAO repairRecordDAO;
    private ICustomerFeedbackDAO customerFeedbackDAO;
    private IEmployeeDAO employeeDAO;

    public AnalysisService() {
	customerDAO = new CustomerDAO();
	customerService = new CustomerService();
	houseDAO = new HouseDAO();
	customerSupportDAO = new CustomerSupportDAO();
	repairRecordDAO = new RepairRecordDAO();
	customerFeedbackDAO = new CustomerFeedbackDAO();
	employeeDAO = new EmployeeDAO();
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.crm.service.IAnalysisService#showCustomerCountsByGender()
     */
    public String showCustomerCountsByGender(int employeeId) {
	int maleCountIntent = 0;
	int femaleCountIntent = 0;
	int intentAll = 0;
	int maleCountAlready = 0;
	int femaleCountAlready = 0;
	int alreadyAll = 0;
	List<Customer> allIntent = customerService
		.getIntentCustomers(employeeId);
	List<Customer> allAlready = customerService
		.getAlreadyCustomers(employeeId);

	intentAll = allIntent.size();
	alreadyAll = allAlready.size();

	for (Customer c : allIntent) {
	    if (c.getGender().trim().equals("M")) {
		maleCountIntent++;
	    } else {
		femaleCountIntent++;
	    }
	}

	for (Customer c : allAlready) {
	    if (c.getGender().trim().equals("M")) {
		maleCountAlready++;
	    } else {
		femaleCountAlready++;
	    }
	}

	// get result
	double intentMale;
	double intentFemale;
	double alMale;
	double alFemale;
	if (intentAll != 0) {
	    intentMale = 1.0 * maleCountIntent / intentAll;
	    intentFemale = 1.0 * femaleCountIntent / intentAll;
	} else {
	    intentMale = 0;
	    intentFemale = 0;
	}
	if (alreadyAll != 0) {
	    alMale = 1.0 * maleCountAlready / alreadyAll;
	    alFemale = 1.0 * femaleCountAlready / alreadyAll;
	} else {
	    alMale = 0;
	    alFemale = 0;
	}

	StringBuffer sb = new StringBuffer();
	sb.append("['" + "潜在客户-男'," + intentMale + "]");
	sb.append(DEL);
	sb.append("['" + "潜在客户-女'," + intentFemale + "]");
	sb.append(DEL);
	sb.append("['" + "已有客户-男'," + alMale + "]");
	sb.append(DEL);
	sb.append("['" + "已有客户-女'," + alFemale + "]");

	return sb.toString();
    }

    @SuppressWarnings("deprecation")
    private int getAge(Date birthday) {
	int age = 0;
	age = new Date().getYear() - birthday.getYear();
	return age;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.crm.service.IAnalysisService#showCustomerCountsByAge()
     */
    public String showCustomerCountsByAge() {
	List<Customer> all = customerDAO.findAll();
	int level1 = 0;
	int level2 = 0;
	int level3 = 0;
	int level4 = 0;
	int level5 = 0;
	int level6 = 0;
	int level7 = 0;
	int level8 = 0;
	int level9 = 0;
	for (Customer customer : all) {
	    int age = getAge(customer.getBirthday());
	    if (age >= 20 && age <= 25) {
		level1++;
	    } else if (age > 25 && age <= 30) {
		level2++;
	    } else if (age > 30 && age <= 35) {
		level3++;
	    } else if (age > 35 && age <= 40) {
		level4++;
	    } else if (age > 40 && age <= 45) {
		level5++;
	    } else if (age > 45 && age <= 50) {
		level6++;
	    } else if (age > 50 && age <= 55) {
		level7++;
	    } else if (age > 55 && age <= 60) {
		level8++;
	    } else {
		level9++;
	    }
	}

	StringBuffer sb = new StringBuffer();
	sb.append("['" + "20~25'," + level1 + "]");
	sb.append(DEL);
	sb.append("['" + "25~30'," + level2 + "]");
	sb.append(DEL);
	sb.append("['" + "30~35'," + level3 + "]");
	sb.append(DEL);
	sb.append("['" + "35~40'," + level4 + "]");
	sb.append(DEL);
	sb.append("['" + "40~45'," + level5 + "]");
	sb.append(DEL);
	sb.append("['" + "45~50'," + level6 + "]");
	sb.append(DEL);
	sb.append("['" + "50~55'," + level7 + "]");
	sb.append(DEL);
	sb.append("['" + "55~60'," + level8 + "]");
	sb.append(DEL);
	sb.append("['" + "60以上'," + level9 + "]");

	return sb.toString();
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.crm.service.IAnalysisService#showCustomerCountsByMarry()
     */
    public String showCustomerCountsByMarry() {
	List<Customer> all = customerDAO.findAll();
	int level1 = 0;
	int level2 = 0;
	for (Customer c : all) {
	    if (c.getIsMarried()) {
		level1++;
	    } else {
		level2++;
	    }
	}

	StringBuffer sb = new StringBuffer();
	sb.append("['" + "已婚'," + level1 + "]");
	sb.append(DEL);
	sb.append("['" + "未婚'," + level2 + "]");

	return sb.toString();
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.crm.service.IAnalysisService#showCustomerCountsByIncom()
     */
    public String showCustomerCountsByIncom() {
	List<Customer> all = customerDAO.findAll();
	int leve1 = 0;
	int leve2 = 0;
	int leve3 = 0;
	int leve4 = 0;
	int leve5 = 0;
	int leve6 = 0;
	int leve7 = 0;
	int leve8 = 0;
	int leve = all.size();

	for (Customer customer : all) {
	    String income = customer.getIncome();
	    if (income.trim().equals("Level 1")) {
		leve1++;
	    } else if (income.trim().equals("Level 2")) {
		leve2++;
	    } else if (income.trim().equals("Level 3")) {
		leve3++;
	    } else if (income.trim().equals("Level 4")) {
		leve4++;
	    } else if (income.trim().equals("Level 5")) {
		leve5++;
	    } else if (income.trim().equals("Level 6")) {
		leve6++;
	    } else if (income.trim().equals("Level 7")) {
		leve7++;
	    } else {
		leve8++;
	    }
	}

	double dLevel1 = 1.0 * leve1 / leve * 100;
	double dLevel2 = 1.0 * leve2 / leve * 100;
	double dLevel3 = 1.0 * leve3 / leve * 100;
	double dLevel4 = 1.0 * leve4 / leve * 100;
	;
	double dLevel5 = 1.0 * leve5 / leve * 100;
	double dLevel6 = 1.0 * leve6 / leve * 100;
	double dLevel7 = 1.0 * leve7 / leve * 100;
	double dLevel8 = 1.0 * leve8 / leve * 100;

	StringBuffer sb = new StringBuffer();
	sb.append("['" + "2000以下'," + dLevel1 + "]");
	sb.append(DEL);
	sb.append("['" + "2000~3000'," + dLevel2 + "]");
	sb.append(DEL);
	sb.append("['" + "3000~4000'," + dLevel3 + "]");
	sb.append(DEL);
	sb.append("['" + "4000~5000'," + dLevel4 + "]");
	sb.append(DEL);
	sb.append("['" + "5000~6000'," + dLevel5 + "]");
	sb.append(DEL);
	sb.append("['" + "6000~7000'," + dLevel6 + "]");
	sb.append(DEL);
	sb.append("['" + "7000~8000'," + dLevel7 + "]");
	sb.append(DEL);
	sb.append("['" + "8000以上'," + dLevel8 + "]");

	return sb.toString();
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.crm.service.IAnalysisService#showCustomerCountsByHobby()
     */
    public String showCustomerCountsByHobby() {
	List<Customer> all = customerDAO.findAll();
	int level1 = 0;
	int level2 = 0;
	int level3 = 0;
	int level4 = 0;
	int level5 = 0;
	int level = all.size();
	for (Customer c : all) {
	    String hobby = c.getHobby();
	    if (hobby.contains("旅游")) {
		level1++;
	    } else if (hobby.contains("看书")) {
		level2++;
	    } else if (hobby.contains("游泳")) {
		level3++;
	    } else if (hobby.contains("运动")) {
		level4++;
	    } else if (hobby.contains("电影") || hobby.contains("音乐")) {
		level5++;
	    } else {

	    }
	}

	double dLevel1 = 1.0 * level1 / level * 100;
	double dLevel2 = 1.0 * level2 / level * 100;
	double dLevel3 = 1.0 * level3 / level * 100;
	double dLevel4 = 1.0 * level4 / level * 100;
	double dLevel5 = 1.0 * level5 / level * 100;

	StringBuffer sb = new StringBuffer();
	sb.append("['" + "旅游'," + dLevel1 + "]");
	sb.append(DEL);
	sb.append("['" + "阅读'," + dLevel2 + "]");
	sb.append(DEL);
	sb.append("['" + "游泳'," + dLevel3 + "]");
	sb.append(DEL);
	sb.append("['" + "体育'," + dLevel4 + "]");
	sb.append(DEL);
	sb.append("['" + "娱乐'," + dLevel5 + "]");

	return sb.toString();
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.crm.service.IAnalysisService#showCustomerCountsByJob()
     */
    public String showCustomerCountsByJob() {
	List<Customer> all = customerDAO.findAll();
	int level1 = 0;
	int level2 = 0;
	int level3 = 0;
	int level4 = 0;
	int level5 = 0;
	int level = all.size();
	for (Customer c : all) {
	    String job = c.getJob();
	    if (job.contains("白领")) {
		level1++;
	    } else if (job.contains("蓝领")) {
		level2++;
	    } else if (job.contains("教师")) {
		level3++;
	    } else if (job.contains("经理")) {
		level4++;
	    } else if (job.contains("个体")) {
		level5++;
	    } else {

	    }
	}

	double dLevel1 = 1.0 * level1 / level;
	double dLevel2 = 1.0 * level2 / level;
	double dLevel3 = 1.0 * level3 / level;
	double dLevel4 = 1.0 * level4 / level;
	double dLevel5 = 1.0 * level5 / level;

	StringBuffer sb = new StringBuffer();
	sb.append("['" + "白领'," + dLevel1 + "]");
	sb.append(DEL);
	sb.append("['" + "蓝领'," + dLevel2 + "]");
	sb.append(DEL);
	sb.append("['" + "教师'," + dLevel3 + "]");
	sb.append(DEL);
	sb.append("['" + "经理'," + dLevel4 + "]");
	sb.append(DEL);
	sb.append("['" + "个体'," + dLevel5 + "]");

	return sb.toString();
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.crm.service.IAnalysisService#showHouseCountsByMonth()
     */
    @SuppressWarnings("deprecation")
    public String showHouseCountsByMonth() {
	int level1 = 0;
	int level2 = 0;
	int level3 = 0;
	int level4 = 0;
	int level5 = 0;
	int level6 = 0;
	int level7 = 0;
	int level8 = 0;
	int level9 = 0;
	int level10 = 0;
	int level11 = 0;
	int level12 = 0;
	List<House> all = houseDAO.findAll();
	for (House h : all) {
	    if (h.getIsSale()) {
		int m = h.getSaleTime().getMonth() + 1;
		switch (m) {
		case 1:
		    level1++;
		    break;
		case 2:
		    level2++;
		    break;
		case 3:
		    level3++;
		    break;
		case 4:
		    level4++;
		    break;
		case 5:
		    level5++;
		    break;
		case 6:
		    level6++;
		    break;
		case 7:
		    level7++;
		    break;
		case 8:
		    level8++;
		    break;
		case 9:
		    level9++;
		    break;
		case 10:
		    level10++;
		    break;
		case 11:
		    level11++;
		    break;
		case 12:
		    level12++;
		    break;
		default:
		    break;
		}
	    }
	}
	StringBuffer sb = new StringBuffer();
	sb.append("[" + 1 + "," + level1 + "]");
	sb.append(DEL);
	sb.append("[" + 2 + "," + level2 + "]");
	sb.append(DEL);
	sb.append("[" + 3 + "," + level3 + "]");
	sb.append(DEL);
	sb.append("[" + 4 + "," + level4 + "]");
	sb.append(DEL);
	sb.append("[" + 5 + "," + level5 + "]");
	sb.append(DEL);
	sb.append("[" + 6 + "," + level6 + "]");
	sb.append(DEL);
	sb.append("[" + 7 + "," + level7 + "]");
	sb.append(DEL);
	sb.append("[" + 8 + "," + level8 + "]");
	sb.append(DEL);
	sb.append("[" + 9 + "," + level9 + "]");
	sb.append(DEL);
	sb.append("[" + 10 + "," + level10 + "]");
	sb.append(DEL);
	sb.append("[" + 11 + "," + level11 + "]");
	sb.append(DEL);
	sb.append("[" + 12 + "," + level12 + "]");
	return sb.toString();
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.crm.service.IAnalysisService#showHouseCountsByArea()
     */
    public String showHouseCountsByArea() {
	int level1 = 0;
	int level2 = 0;
	int level3 = 0;
	int level4 = 0;
	int level5 = 0;
	int level6 = 0;
	List<House> all = houseDAO.findAll();
	for (House h : all) {
	    if (h.getIsSale()) {
		double area = h.getArea();
		if (area > 50 && area <= 70) {
		    level1++;
		} else if (area > 70 && area <= 90) {
		    level2++;
		} else if (area > 90 && area <= 110) {
		    level3++;
		} else if (area > 110 && area <= 130) {
		    level4++;
		} else if (area > 130 && area <= 150) {
		    level5++;
		} else {
		    level6++;
		}
	    }
	}

	StringBuffer sb = new StringBuffer();
	sb.append("['" + "50~70'," + level1 + "]");
	sb.append(DEL);
	sb.append("['" + "70~90'," + level2 + "]");
	sb.append(DEL);
	sb.append("['" + "90~110'," + level3 + "]");
	sb.append(DEL);
	sb.append("['" + "110~130'," + level4 + "]");
	sb.append(DEL);
	sb.append("['" + "130~150'," + level5 + "]");
	sb.append(DEL);
	sb.append("['" + "150以上'," + level6 + "]");

	return sb.toString();
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.crm.service.IAnalysisService#showHouseCountsByPrice()
     */
    public String showHouseCountsByPrice() {

	int level1 = 0;
	int level2 = 0;
	int level3 = 0;
	int level4 = 0;
	int level5 = 0;
	int level6 = 0;
	List<House> all = houseDAO.findAll();
	for (House h : all) {
	    if (h.getIsSale()) {
		double price = h.getPrice();
		if (price > 1500 && price <= 2500) {
		    level1++;
		} else if (price > 2500 && price <= 3500) {
		    level2++;
		} else if (price > 3500 && price <= 4500) {
		    level3++;
		} else if (price > 4500 && price <= 5500) {
		    level4++;
		} else if (price > 5500 && price <= 6500) {
		    level5++;
		} else {
		    level6++;
		}
	    }
	}

	StringBuffer sb = new StringBuffer();
	sb.append("['" + "1500~2500'," + level1 + "]");
	sb.append(DEL);
	sb.append("['" + "2500~3500'," + level2 + "]");
	sb.append(DEL);
	sb.append("['" + "3500~4500'," + level3 + "]");
	sb.append(DEL);
	sb.append("['" + "4500~5500'," + level4 + "]");
	sb.append(DEL);
	sb.append("['" + "5500~6500'," + level5 + "]");
	sb.append(DEL);
	sb.append("['" + "6500以上'," + level6 + "]");

	return sb.toString();
    }

    /* (non-Javadoc)
     * @see com.crm.service.IAnalysisService#showContactCountsByLastMonth()
     */
    @SuppressWarnings("deprecation")
    public String showContactCountsByLastMonth() {
	Date now = new Date();
	int lastMonth = now.getMonth();
	if (lastMonth == 0) {
	    lastMonth = 1;
	}
	
	int level1 = 0;
	int level2 = 0;
	int level3 = 0;
	int level4 = 0;
	int level5 = 0;
	int level6 = 0;
	
	List<CustomerSupport> all = customerSupportDAO.findAll();
	for (CustomerSupport cs : all) {
	    int month = cs.getRecordTime().getMonth() + 1;
	    if (month == lastMonth) {
		int date = cs.getRecordTime().getDate();
		switch (date) {
		case 1:
		case 2:
		case 3:
		case 4:
		case 5:
		    level1++;
		    break;
		case 6:
		case 7:
		case 8:
		case 9:
		case 10:
		    level2++;
		    break;
		case 11:
		case 12:
		case 13:
		case 14:
		case 15:
		    level3++;
		    break;
		case 16:
		case 17:
		case 18:
		case 19:
		case 20:
		    level4++;
		    break;
		case 21:
		case 22:
		case 23:
		case 24:
		case 25:
		    level5++;
		    break;
		case 26:
		case 27:
		case 28:
		case 29:
		case 30:
		case 31:
		    level6++;
		    break;
		default:
		    break;
		}
	    }
	}
	StringBuffer sb = new StringBuffer();
	sb.append("[" + 5 + "," + level1 + "]");
	sb.append(DEL);
	sb.append("[" + 10 + "," + level2 + "]");
	sb.append(DEL);
	sb.append("[" + 15 + "," + level3 + "]");
	sb.append(DEL);
	sb.append("[" + 20 + "," + level4 + "]");
	sb.append(DEL);
	sb.append("[" + 25 + "," + level5 + "]");
	sb.append(DEL);
	sb.append("[" + 30 + "," + level6 + "]");
	return sb.toString();
    }

    /* (non-Javadoc)
     * @see com.crm.service.IAnalysisService#showFixCountsByMonth()
     */
    @SuppressWarnings("deprecation")
    public String showFixCountsByMonth() {
	Date now = new Date();
	int lastMonth = now.getMonth();
	if (lastMonth == 0) {
	    lastMonth = 1;
	}
	
	int level1 = 0;
	int level2 = 0;
	int level3 = 0;
	int level4 = 0;
	int level5 = 0;
	int level6 = 0;
	
	List<RepairRecord> all = repairRecordDAO.findAll();
	for (RepairRecord cs : all) {
	    int month = cs.getBeginTime().getMonth() + 1;
	    if (month == lastMonth) {
		int date = cs.getBeginTime().getDate();
		switch (date) {
		case 1:
		case 2:
		case 3:
		case 4:
		case 5:
		    level1++;
		    break;
		case 6:
		case 7:
		case 8:
		case 9:
		case 10:
		    level2++;
		    break;
		case 11:
		case 12:
		case 13:
		case 14:
		case 15:
		    level3++;
		    break;
		case 16:
		case 17:
		case 18:
		case 19:
		case 20:
		    level4++;
		    break;
		case 21:
		case 22:
		case 23:
		case 24:
		case 25:
		    level5++;
		    break;
		case 26:
		case 27:
		case 28:
		case 29:
		case 30:
		case 31:
		    level6++;
		    break;
		default:
		    break;
		}
	    }
	}
	StringBuffer sb = new StringBuffer();
	sb.append("[" + 5 + "," + level1 + "]");
	sb.append(DEL);
	sb.append("[" + 10 + "," + level2 + "]");
	sb.append(DEL);
	sb.append("[" + 15 + "," + level3 + "]");
	sb.append(DEL);
	sb.append("[" + 20 + "," + level4 + "]");
	sb.append(DEL);
	sb.append("[" + 25 + "," + level5 + "]");
	sb.append(DEL);
	sb.append("[" + 30 + "," + level6 + "]");
	return sb.toString();
    }

    /* (non-Javadoc)
     * @see com.crm.service.IAnalysisService#showFixCountsByResidence()
     */
    public String showFixCountsByResidence() {
	int level1 = 0;
	int level2 = 0;
	int level3 = 0;
	int level4 = 0;
	List<RepairRecord> rrs = repairRecordDAO.findAll();
	Set<Customer> cs = new HashSet<Customer>();
	for(RepairRecord rr : rrs) {
	    cs.add(rr.getCustomer());
	}
	List<House> allHouse = houseDAO.findAll();
	for(House h : allHouse) {
	    ResidenceCommunity rc = h.getResidenceCommunity();
	    int rcid = rc.getResidenceId();
	    int customerId = h.getCustomerId();
	    Iterator<Customer> iter = cs.iterator();
	    while(iter.hasNext()) {
		int id = iter.next().getCustomerId();
		if (id == customerId) {
		    if (rcid == 1) {
			level1 ++;
		    }
		    else if (rcid == 2){
			level2 ++;
		    }
		    else if (rcid == 3){
			level3 ++;
		    }
		    else  {
			level4 ++;
		    }
		}
	    }
	}
	
	StringBuffer sb = new StringBuffer();
	sb.append("['" + "天辉小区1'," + level1 + "]");
	sb.append(DEL);
	sb.append("['" + "天辉小区2'," + level2 + "]");
	sb.append(DEL);
	sb.append("['" + "天辉小区3'," + level3 + "]");
	sb.append(DEL);
	sb.append("['" + "天辉小区4'," + level4 + "]");
	return sb.toString();
    }

    /* (non-Javadoc)
     * @see com.crm.service.IAnalysisService#showValueAll()
     */
    public String showValueAll() {
	List<CustomerFeedback> cfs = customerFeedbackDAO.findAll();
	int level1 = 0;
	int level2 = 0;
	int level3 = 0;
	int level4 = 0;
	int level5 = 0;
	for (CustomerFeedback cf : cfs) {
	    int all = cf.getMarkAll();
	    switch (all) {
	    case 1: level1 ++ ; break;
	    case 2: level2 ++ ; break;
	    case 3: level3 ++ ; break;
	    case 4: level4 ++ ; break;
	    case 5: level5 ++ ; break;
	    default:
		break;
	    }
	}
	StringBuffer sb = new StringBuffer();
	sb.append("['" + "60以下'," + level1 + "]");
	sb.append(DEL);
	sb.append("['" + "60~70'," + level2 + "]");
	sb.append(DEL);
	sb.append("['" + "70~80'," + level3 + "]");
	sb.append(DEL);
	sb.append("['" + "80~90'," + level4 + "]");
	sb.append(DEL);
	sb.append("['" + "90~100'," + level5 + "]");
	return sb.toString();
    }

    /* (non-Javadoc)
     * @see com.crm.service.IAnalysisService#showValueEmvironment()
     */
    public String showValueEmvironment() {
	List<CustomerFeedback> cfs = customerFeedbackDAO.findAll();
	int level1 = 0;
	int level2 = 0;
	int level3 = 0;
	int level4 = 0;
	int level5 = 0;
	for (CustomerFeedback cf : cfs) {
	    int all = cf.getMarkEnvironment();
	    switch (all) {
	    case 1: level1 ++ ; break;
	    case 2: level2 ++ ; break;
	    case 3: level3 ++ ; break;
	    case 4: level4 ++ ; break;
	    case 5: level5 ++ ; break;
	    default:
		break;
	    }
	}
	StringBuffer sb = new StringBuffer();
	sb.append("['" + "60以下'," + level1 + "]");
	sb.append(DEL);
	sb.append("['" + "60~70'," + level2 + "]");
	sb.append(DEL);
	sb.append("['" + "70~80'," + level3 + "]");
	sb.append(DEL);
	sb.append("['" + "80~90'," + level4 + "]");
	sb.append(DEL);
	sb.append("['" + "90~100'," + level5 + "]");
	return sb.toString();
    }

    /* (non-Javadoc)
     * @see com.crm.service.IAnalysisService#showValueIndiSale()
     */
    public String showValueIndiSale() {
	List<CustomerFeedback> cfs = customerFeedbackDAO.findAll();
	List<Employee> all = employeeDAO.findAll();
	List<Employee> sales = new ArrayList<Employee>();
	for (Employee employee : all) {
	    if (!employee.getIsManager() && employee.getDepartment().equals("SaleDepartment")) {
		sales.add(employee);
	    }
	}
	
	Map<String, Integer> levels = new HashMap<String, Integer>();
	for (Employee e : sales) {
	    levels.put(e.getName(), 0);
	}
	
	for (Employee e : sales) {
	    int employeeId = e.getEmployeeId();
	    for (CustomerFeedback cf : cfs) {
		int eId = cf.getEmployee().getEmployeeId();
		if (eId == employeeId) {
		    int temp = levels.get(e.getName()) + 1;
		    levels.put(e.getName(), temp );
		}
	    }
	}
	
	StringBuffer sb = new StringBuffer();
	Set<String> employeeNames = levels.keySet();
	int size = 0;
	Iterator<String> iter = employeeNames.iterator();
	while(iter.hasNext()) {
	    size ++;
	    String name = iter.next();
	    int level = levels.get(name);
	    sb.append("['" + name + "'," + level + "]");
	    if (size < employeeNames.size()) {
		sb.append(DEL);
	    }
	}
	
	
	return sb.toString();
    }

    /* (non-Javadoc)
     * @see com.crm.service.IAnalysisService#showValueSale()
     */
    public String showValueSale() {
	List<CustomerFeedback> cfs = customerFeedbackDAO.findAll();
	int level1 = 0;
	int level2 = 0;
	int level3 = 0;
	int level4 = 0;
	int level5 = 0;
	for (CustomerFeedback cf : cfs) {
	    int all = cf.getMarkSeller();
	    switch (all) {
	    case 1: level1 ++ ; break;
	    case 2: level2 ++ ; break;
	    case 3: level3 ++ ; break;
	    case 4: level4 ++ ; break;
	    case 5: level5 ++ ; break;
	    default:
		break;
	    }
	}
	StringBuffer sb = new StringBuffer();
	sb.append("['" + "60以下'," + level1 + "]");
	sb.append(DEL);
	sb.append("['" + "60~70'," + level2 + "]");
	sb.append(DEL);
	sb.append("['" + "70~80'," + level3 + "]");
	sb.append(DEL);
	sb.append("['" + "80~90'," + level4 + "]");
	sb.append(DEL);
	sb.append("['" + "90~100'," + level5 + "]");
	return sb.toString();
    }

    /* (non-Javadoc)
     * @see com.crm.service.IAnalysisService#showValueTenement()
     */
    public String showValueTenement() {
	List<CustomerFeedback> cfs = customerFeedbackDAO.findAll();
	int level1 = 0;
	int level2 = 0;
	int level3 = 0;
	int level4 = 0;
	int level5 = 0;
	for (CustomerFeedback cf : cfs) {
	    int all = cf.getMarkTenement();
	    switch (all) {
	    case 1: level1 ++ ; break;
	    case 2: level2 ++ ; break;
	    case 3: level3 ++ ; break;
	    case 4: level4 ++ ; break;
	    case 5: level5 ++ ; break;
	    default:
		break;
	    }
	}
	StringBuffer sb = new StringBuffer();
	sb.append("['" + "60以下'," + level1 + "]");
	sb.append(DEL);
	sb.append("['" + "60~70'," + level2 + "]");
	sb.append(DEL);
	sb.append("['" + "70~80'," + level3 + "]");
	sb.append(DEL);
	sb.append("['" + "80~90'," + level4 + "]");
	sb.append(DEL);
	sb.append("['" + "90~100'," + level5 + "]");
	return sb.toString();
    }

    /* (non-Javadoc)
     * @see com.crm.service.IAnalysisService#showValueTraffic()
     */
    public String showValueTraffic() {
	List<CustomerFeedback> cfs = customerFeedbackDAO.findAll();
	int level1 = 0;
	int level2 = 0;
	int level3 = 0;
	int level4 = 0;
	int level5 = 0;
	for (CustomerFeedback cf : cfs) {
	    int all = cf.getMarkTraffic();
	    switch (all) {
	    case 1: level1 ++ ; break;
	    case 2: level2 ++ ; break;
	    case 3: level3 ++ ; break;
	    case 4: level4 ++ ; break;
	    case 5: level5 ++ ; break;
	    default:
		break;
	    }
	}
	StringBuffer sb = new StringBuffer();
	sb.append("['" + "60以下'," + level1 + "]");
	sb.append(DEL);
	sb.append("['" + "60~70'," + level2 + "]");
	sb.append(DEL);
	sb.append("['" + "70~80'," + level3 + "]");
	sb.append(DEL);
	sb.append("['" + "80~90'," + level4 + "]");
	sb.append(DEL);
	sb.append("['" + "90~100'," + level5 + "]");
	return sb.toString();
    }

}
