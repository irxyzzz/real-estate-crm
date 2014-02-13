/**
 * 
 */
package com.crm.dao.test;

import static org.junit.Assert.fail;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.crm.dao.ICustomerDAO;
import com.crm.dao.ICustomerSupportDAO;
import com.crm.dao.IEmployeeDAO;
import com.crm.dao.impl.CustomerDAO;
import com.crm.dao.impl.CustomerSupportDAO;
import com.crm.dao.impl.EmployeeDAO;
import com.crm.model.CustomerSupport;

/**
 * @author lenovo
 *
 */
public class CustomerSupportDAOTest {
    
    private ICustomerSupportDAO customerSupportDAO;
    private ICustomerDAO customerDAO;
    private IEmployeeDAO employeeDAO;

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
	customerSupportDAO = new CustomerSupportDAO();
	customerDAO = new CustomerDAO();
	employeeDAO = new EmployeeDAO();
    }

    /**
     * @throws java.lang.Exception
     */
    @After
    public void tearDown() throws Exception {
	this.customerDAO = null;
	this.customerSupportDAO = null;
	this.employeeDAO = null;
    }

    /**
     * Test method for {@link com.crm.dao.impl.CustomerSupportDAO#save(com.crm.model.CustomerSupport)}.
     */
    @Test
    public void testSave() {
	for (int i = 1; i < 15; i++) {
	    CustomerSupport cs = new CustomerSupport();
	    cs.setCustomer(customerDAO.findById(10 + i));
	    cs.setEmployee(employeeDAO.findById(1));
	    cs.setContent("联系内容");
	    cs.setReply("回复内容");
	    cs.setRecordTime(new Timestamp(new Date().getTime() - (7 + i) * 24 * 3600 * 1000));
	    
	    customerSupportDAO.save(cs);
	}
	 
    }

    /**
     * Test method for {@link com.crm.dao.impl.CustomerSupportDAO#delete(com.crm.model.CustomerSupport)}.
     */
    @Test
    public void testDelete() {
	customerSupportDAO.delete(customerSupportDAO.findById(5));
    }

    /**
     * Test method for {@link com.crm.dao.impl.CustomerSupportDAO#findById(java.lang.Integer)}.
     */
    @Test
    public void testFindById() {
	fail("Not yet implemented"); // TODO
    }

    /**
     * Test method for {@link com.crm.dao.impl.CustomerSupportDAO#findByExample(com.crm.model.CustomerSupport)}.
     */
    @Test
    public void testFindByExample() {
	fail("Not yet implemented"); // TODO
    }

    /**
     * Test method for {@link com.crm.dao.impl.CustomerSupportDAO#findByProperty(java.lang.String, java.lang.Object)}.
     */
    @Test
    public void testFindByProperty() {
	fail("Not yet implemented"); // TODO
    }

    /**
     * Test method for {@link com.crm.dao.impl.CustomerSupportDAO#findByContent(java.lang.Object)}.
     */
    @Test
    public void testFindByContent() {
	fail("Not yet implemented"); // TODO
    }

    /**
     * Test method for {@link com.crm.dao.impl.CustomerSupportDAO#findByReply(java.lang.Object)}.
     */
    @Test
    public void testFindByReply() {
	fail("Not yet implemented"); // TODO
    }

    /**
     * Test method for {@link com.crm.dao.impl.CustomerSupportDAO#findAll()}.
     */
    @Test
    public void testFindAll() {
	List<CustomerSupport> css = customerSupportDAO.findAll();
	for (CustomerSupport cs : css) {
	    System.out.println(cs.getEmployee().getName());
	    System.out.println(cs.getCustomer().getName());
	    System.out.println(cs.getContent());
	    System.out.println(cs.getRecordTime());
	}
    }

    /**
     * Test method for {@link com.crm.dao.impl.CustomerSupportDAO#merge(com.crm.model.CustomerSupport)}.
     */
    @Test
    public void testMerge() {
	fail("Not yet implemented"); // TODO
    }

    /**
     * Test method for {@link com.crm.dao.impl.CustomerSupportDAO#attachDirty(com.crm.model.CustomerSupport)}.
     */
    @SuppressWarnings("deprecation")
    @Test
    public void testAttachDirty() {
	List<CustomerSupport> css = customerSupportDAO.findAll();
	Random random = new Random();
	for (CustomerSupport cs : css) {
	    Timestamp d = cs.getRecordTime();
	    d.setDate(random.nextInt(30)+1);
	    cs.setRecordTime(d);
	}
	
    }

    /**
     * Test method for {@link com.crm.dao.impl.CustomerSupportDAO#attachClean(com.crm.model.CustomerSupport)}.
     */
    @Test
    public void testAttachClean() {
	fail("Not yet implemented"); // TODO
    }

}
