/**
 * 
 */
package com.crm.dao.test;

import static org.junit.Assert.fail;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.crm.dao.ICustomerDAO;
import com.crm.dao.ICustomerFeedbackDAO;
import com.crm.dao.IEmployeeDAO;
import com.crm.dao.impl.CustomerDAO;
import com.crm.dao.impl.CustomerFeedbackDAO;
import com.crm.dao.impl.EmployeeDAO;
import com.crm.model.Customer;
import com.crm.model.CustomerFeedback;
import com.crm.model.Employee;

/**
 * @author lenovo
 *
 */
public class CustomerFeedbackDAOTest {
    
    private ICustomerFeedbackDAO customerFeedbackDAO;
    private IEmployeeDAO employeeDAO;
    private ICustomerDAO customerDAO;

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
	customerFeedbackDAO = new CustomerFeedbackDAO();
	employeeDAO = new EmployeeDAO();
	customerDAO = new CustomerDAO();
    }

    /**
     * @throws java.lang.Exception
     */
    @After
    public void tearDown() throws Exception {
	customerDAO = null;
	employeeDAO = null;
	customerFeedbackDAO = null;
    }

    /**
     * Test method for {@link com.crm.dao.impl.CustomerFeedbackDAO#save(com.crm.model.CustomerFeedback)}.
     */
    @Test
    public void testSave() {
	Random random = new Random();
	List<Employee> sales = new ArrayList<Employee>();
	for (Employee e : employeeDAO.findAll()) {
	    if (!e.getIsManager() && e.getDepartment().equals("SaleDepartment")) {
		sales.add(e);
	    }
	}
	for (int i = 1; i < 50; i++) {
	    CustomerFeedback cf = new CustomerFeedback();
	    
	    cf.setAdviceSeller("销售服务态度很好");
	    if (random.nextInt(2) == 1) {
		cf.setCustomer(customerDAO.findById(5));
	    }
	    else {
		cf.setCustomer(customerDAO.findById(1));
	    }
	    
	    
	    cf.setEmployee(sales.get(random.nextInt(sales.size())));
	    
	    cf.setMarkAll(random.nextInt(5) + 1);
	    cf.setMarkEnvironment(random.nextInt(5) + 1);
	    cf.setMarkSeller(random.nextInt(5) + 1);
	    cf.setMarkTenement(random.nextInt(5) + 1);
	    cf.setMarkTraffic(random.nextInt(5) + 1);
	    
	    cf.setRecordTime(new Timestamp(new Date().getTime() - random.nextInt(250) * 24 * 3600 * 1000));
	    
	    customerFeedbackDAO.save(cf);
	}
    }

    /**
     * Test method for {@link com.crm.dao.impl.CustomerFeedbackDAO#delete(com.crm.model.CustomerFeedback)}.
     */
    @Test
    public void testDelete() {
	CustomerFeedback cf = customerFeedbackDAO.findById(5);
	customerFeedbackDAO.delete(cf);	
	
	List<CustomerFeedback> cfs = customerFeedbackDAO.findAll();
	for (CustomerFeedback cfe : cfs) {
	    System.out.println(cfe.getCustomer().getName());
	    System.out.println(cfe.getEmployee().getName());
	    System.out.println(cfe.getMarkAll());
	    System.out.println(cfe.getRecordTime());
	}
    }

    /**
     * Test method for {@link com.crm.dao.impl.CustomerFeedbackDAO#findById(java.lang.Integer)}.
     */
    @Test
    public void testFindById() {
	fail("Not yet implemented"); // TODO
    }

    /**
     * Test method for {@link com.crm.dao.impl.CustomerFeedbackDAO#findByExample(com.crm.model.CustomerFeedback)}.
     */
    @Test
    public void testFindByExample() {
	fail("Not yet implemented"); // TODO
    }

    /**
     * Test method for {@link com.crm.dao.impl.CustomerFeedbackDAO#findByProperty(java.lang.String, java.lang.Object)}.
     */
    @Test
    public void testFindByProperty() {
	fail("Not yet implemented"); // TODO
    }

    /**
     * Test method for {@link com.crm.dao.impl.CustomerFeedbackDAO#findByMarkSeller(java.lang.Object)}.
     */
    @Test
    public void testFindByMarkSeller() {
	fail("Not yet implemented"); // TODO
    }

    /**
     * Test method for {@link com.crm.dao.impl.CustomerFeedbackDAO#findByAdviceSeller(java.lang.Object)}.
     */
    @Test
    public void testFindByAdviceSeller() {
	fail("Not yet implemented"); // TODO
    }

    /**
     * Test method for {@link com.crm.dao.impl.CustomerFeedbackDAO#findByMarkEnvironment(java.lang.Object)}.
     */
    @Test
    public void testFindByMarkEnvironment() {
	fail("Not yet implemented"); // TODO
    }

    /**
     * Test method for {@link com.crm.dao.impl.CustomerFeedbackDAO#findByMarkTenement(java.lang.Object)}.
     */
    @Test
    public void testFindByMarkTenement() {
	fail("Not yet implemented"); // TODO
    }

    /**
     * Test method for {@link com.crm.dao.impl.CustomerFeedbackDAO#findByMarkTraffic(java.lang.Object)}.
     */
    @Test
    public void testFindByMarkTraffic() {
	fail("Not yet implemented"); // TODO
    }

    /**
     * Test method for {@link com.crm.dao.impl.CustomerFeedbackDAO#findByMarkAll(java.lang.Object)}.
     */
    @Test
    public void testFindByMarkAll() {
	fail("Not yet implemented"); // TODO
    }

    /**
     * Test method for {@link com.crm.dao.impl.CustomerFeedbackDAO#findAll()}.
     */
    @Test
    public void testFindAll() {
	List<CustomerFeedback> cfs = customerFeedbackDAO.findAll();
	for (CustomerFeedback cf : cfs) {
	    System.out.println(cf.getCustomer().getName());
	    System.out.println(cf.getEmployee().getName());
	    System.out.println(cf.getMarkAll());
	    System.out.println(cf.getRecordTime());
	}
    }

    /**
     * Test method for {@link com.crm.dao.impl.CustomerFeedbackDAO#merge(com.crm.model.CustomerFeedback)}.
     */
    @Test
    public void testMerge() {
	fail("Not yet implemented"); // TODO
    }

    /**
     * Test method for {@link com.crm.dao.impl.CustomerFeedbackDAO#attachDirty(com.crm.model.CustomerFeedback)}.
     */
    @Test
    public void testAttachDirty() {
	List<CustomerFeedback> cfs = customerFeedbackDAO.findAll();
	Random random = new Random();
	List<Customer> cs = new ArrayList<Customer>();
	for (Customer c : customerDAO.findAll()) {
	    if (c.getHasHouse()) {
		cs.add(c);
	    }
	}
	
//	System.out.println("Modify before");
	for (CustomerFeedback cf : cfs) {
	    cf.setCustomer(cs.get(random.nextInt(cs.size())));
	    customerFeedbackDAO.attachDirty(cf);
	}
	
//	for (CustomerFeedback cf : cfs) {
//	    cf.setMarkAll(4);
//	    customerFeedbackDAO.attachDirty(cf);
//	}
//	
//	System.out.println("Modify after");
//	cfs = customerFeedbackDAO.findAll();
//	for (CustomerFeedback cf : cfs) {
//	    System.out.println(cf.getMarkAll());
//	}
    }

    /**
     * Test method for {@link com.crm.dao.impl.CustomerFeedbackDAO#attachClean(com.crm.model.CustomerFeedback)}.
     */
    @Test
    public void testAttachClean() {
	fail("Not yet implemented"); // TODO
    }

}
