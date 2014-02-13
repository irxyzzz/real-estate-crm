/**
 * 
 */
package com.crm.dao.test;

import static org.junit.Assert.fail;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.crm.dao.ICustomerCareDAO;
import com.crm.dao.impl.CustomerCareDAO;
import com.crm.model.CustomerCare;

/**
 * @author lenovo
 * 
 */
public class CustomerCareDAOTest {

    private ICustomerCareDAO customerCareDAO;

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
	customerCareDAO = new CustomerCareDAO();
    }

    /**
     * @throws java.lang.Exception
     */
    @After
    public void tearDown() throws Exception {
	customerCareDAO = null;
    }

    /**
     * Test method for
     * {@link com.crm.dao.impl.CustomerCareDAO#save(com.crm.model.CustomerCare)}
     * .
     */
    @Test
    public void testSave() {
	for (int i = 1; i < 6; i++) {
	    CustomerCare care = new CustomerCare();
	    care.setTitle("端午节活动" + i);
	    care.setForm("发邮件");
	    care.setDecription("活动描述");
	    care.setActivityTime(new Timestamp(new Date().getTime()));
	    care.setCustomerType("购房用户");
	    
	    customerCareDAO.save(care);
	}
    }

    /**
     * Test method for
     * {@link com.crm.dao.impl.CustomerCareDAO#delete(com.crm.model.CustomerCare)}
     * .
     */
    @Test
    public void testDelete() {
	fail("Not yet implemented"); // TODO
    }

    /**
     * Test method for
     * {@link com.crm.dao.impl.CustomerCareDAO#findById(java.lang.Integer)}.
     */
    @Test
    public void testFindById() {
	fail("Not yet implemented"); // TODO
    }

    /**
     * Test method for
     * {@link com.crm.dao.impl.CustomerCareDAO#findByExample(com.crm.model.CustomerCare)}
     * .
     */
    @Test
    public void testFindByExample() {
	fail("Not yet implemented"); // TODO
    }

    /**
     * Test method for
     * {@link com.crm.dao.impl.CustomerCareDAO#findByProperty(java.lang.String, java.lang.Object)}
     * .
     */
    @Test
    public void testFindByProperty() {
	fail("Not yet implemented"); // TODO
    }

    /**
     * Test method for
     * {@link com.crm.dao.impl.CustomerCareDAO#findByTitle(java.lang.Object)}.
     */
    @Test
    public void testFindByTitle() {
	fail("Not yet implemented"); // TODO
    }

    /**
     * Test method for
     * {@link com.crm.dao.impl.CustomerCareDAO#findByDecription(java.lang.Object)}
     * .
     */
    @Test
    public void testFindByDecription() {
	fail("Not yet implemented"); // TODO
    }

    /**
     * Test method for
     * {@link com.crm.dao.impl.CustomerCareDAO#findByForm(java.lang.Object)}.
     */
    @Test
    public void testFindByForm() {
	fail("Not yet implemented"); // TODO
    }

    /**
     * Test method for
     * {@link com.crm.dao.impl.CustomerCareDAO#findByCustomerType(java.lang.Object)}
     * .
     */
    @Test
    public void testFindByCustomerType() {
	fail("Not yet implemented"); // TODO
    }

    /**
     * Test method for {@link com.crm.dao.impl.CustomerCareDAO#findAll()}.
     */
    @Test
    public void testFindAll() {
	List<CustomerCare> ccs = customerCareDAO.findAll();
	for (CustomerCare cc : ccs) {
	    System.out.println(cc.getTitle());
	    System.out.println(cc.getActivityTime());
	    System.out.println(cc.getDecription());
	    System.out.println(cc.getCustomerType());
	    System.out.println(cc.getForm());
	}
    }

    /**
     * Test method for
     * {@link com.crm.dao.impl.CustomerCareDAO#merge(com.crm.model.CustomerCare)}
     * .
     */
    @Test
    public void testMerge() {
	fail("Not yet implemented"); // TODO
    }

    /**
     * Test method for
     * {@link com.crm.dao.impl.CustomerCareDAO#attachDirty(com.crm.model.CustomerCare)}
     * .
     */
    @Test
    public void testAttachDirty() {
	List<CustomerCare> ccs = customerCareDAO.findAll();
	for (CustomerCare cc : ccs) {
	    cc.setTitle(cc.getTitle() + "+Modified");
	    customerCareDAO.attachDirty(cc);
	}
	
	ccs = customerCareDAO.findAll();
	for (CustomerCare cc: ccs) {
	    System.out.println(cc.getTitle());
	}
	
    }

    /**
     * Test method for
     * {@link com.crm.dao.impl.CustomerCareDAO#attachClean(com.crm.model.CustomerCare)}
     * .
     */
    @Test
    public void testAttachClean() {
	fail("Not yet implemented"); // TODO
    }

}
