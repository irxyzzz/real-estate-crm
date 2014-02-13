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
import com.crm.dao.IEmployeeDAO;
import com.crm.dao.IRepairRecordDAO;
import com.crm.dao.impl.CustomerDAO;
import com.crm.dao.impl.EmployeeDAO;
import com.crm.dao.impl.RepairRecordDAO;
import com.crm.model.Customer;
import com.crm.model.RepairRecord;

/**
 * @author lenovo
 *
 */
public class RepairRecordDAOTest {
    private IRepairRecordDAO repairRecordDAO;
    private ICustomerDAO customerDAO;
    private IEmployeeDAO employeeDAO;

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
	repairRecordDAO = new RepairRecordDAO();
	employeeDAO = new EmployeeDAO();
	customerDAO = new CustomerDAO();
    }

    /**
     * @throws java.lang.Exception
     */
    @After
    public void tearDown() throws Exception {
	repairRecordDAO = null;
	employeeDAO = null;
	customerDAO = null;
    }

    /**
     * Test method for {@link com.crm.dao.impl.RepairRecordDAO#save(com.crm.model.RepairRecord)}.
     */
    @Test
    public void testSave() {
	
	
	Random random = new Random();
	List<Customer> cs = new ArrayList<Customer>();
	List<Customer> all = customerDAO.findAll();
	for (Customer c : all) {
	    if (c.getHasHouse()) {
		cs.add(c);
	    }
	}
	
	
	for (int i = 1; i < 50; i++) {
	    RepairRecord rr = new RepairRecord();
	    Timestamp t = new Timestamp(new Date().getTime() - random.nextInt(210)*24*3600*1000);
	    rr.setBeginTime(t);
	    int index = random.nextInt(cs.size());
	    rr.setCustomer(cs.get(index));
	    rr.setEmployee(employeeDAO.findById(8));
	    rr.setDecription("水管坏了");
	    rr.setEndTime(new Timestamp(t.getTime() + random.nextInt(7)*24*3600*1000));
	    rr.setHandle("明天拍维修工");
	    rr.setNewHandle("同意");
	    
	    repairRecordDAO.save(rr);
	}
    }

    /**
     * Test method for {@link com.crm.dao.impl.RepairRecordDAO#delete(com.crm.model.RepairRecord)}.
     */
    @Test
    public void testDelete() {
	repairRecordDAO.delete(repairRecordDAO.findById(5));
    }

    /**
     * Test method for {@link com.crm.dao.impl.RepairRecordDAO#findById(java.lang.Integer)}.
     */
    @Test
    public void testFindById() {
	fail("Not yet implemented"); // TODO
    }

    /**
     * Test method for {@link com.crm.dao.impl.RepairRecordDAO#findByExample(com.crm.model.RepairRecord)}.
     */
    @Test
    public void testFindByExample() {
	fail("Not yet implemented"); // TODO
    }

    /**
     * Test method for {@link com.crm.dao.impl.RepairRecordDAO#findByProperty(java.lang.String, java.lang.Object)}.
     */
    @Test
    public void testFindByProperty() {
	fail("Not yet implemented"); // TODO
    }

    /**
     * Test method for {@link com.crm.dao.impl.RepairRecordDAO#findByDecription(java.lang.Object)}.
     */
    @Test
    public void testFindByDecription() {
	fail("Not yet implemented"); // TODO
    }

    /**
     * Test method for {@link com.crm.dao.impl.RepairRecordDAO#findByHandle(java.lang.Object)}.
     */
    @Test
    public void testFindByHandle() {
	fail("Not yet implemented"); // TODO
    }

    /**
     * Test method for {@link com.crm.dao.impl.RepairRecordDAO#findByIsVerify(java.lang.Object)}.
     */
    @Test
    public void testFindByIsVerify() {
	fail("Not yet implemented"); // TODO
    }

    /**
     * Test method for {@link com.crm.dao.impl.RepairRecordDAO#findByNewHandle(java.lang.Object)}.
     */
    @Test
    public void testFindByNewHandle() {
	fail("Not yet implemented"); // TODO
    }

    /**
     * Test method for {@link com.crm.dao.impl.RepairRecordDAO#findAll()}.
     */
    @Test
    public void testFindAll() {
	List<RepairRecord> rrs = repairRecordDAO.findAll();
	for (RepairRecord rr : rrs) {
	    System.out.println(rr.getEmployee().getName());
	    System.out.println(rr.getCustomer().getName());
	    System.out.println(rr.getDecription());
	    System.out.println(rr.getBeginTime());
	    System.out.println(rr.getEndTime());
	    System.out.println(rr.getHandle());
	}
    }

    /**
     * Test method for {@link com.crm.dao.impl.RepairRecordDAO#merge(com.crm.model.RepairRecord)}.
     */
    @Test
    public void testMerge() {
	fail("Not yet implemented"); // TODO
    }

    /**
     * Test method for {@link com.crm.dao.impl.RepairRecordDAO#attachDirty(com.crm.model.RepairRecord)}.
     */
    @Test
    public void testAttachDirty() {
	Random random = new Random();
	List<RepairRecord> rrs = repairRecordDAO.findAll();
	for (RepairRecord rr : rrs) {
	    int days = random.nextInt(2000);
	    System.out.println(days);
	    rr.setBeginTime(new Timestamp(new Date().getTime() - days * 24 * 3600 *1000));
	    rr.setEndTime(new Timestamp(new Date().getTime() - days * 24 * 3600 *1000));
	    
	    repairRecordDAO.attachDirty(rr);
	}
    }

    /**
     * Test method for {@link com.crm.dao.impl.RepairRecordDAO#attachClean(com.crm.model.RepairRecord)}.
     */
    @Test
    public void testAttachClean() {
	fail("Not yet implemented"); // TODO
    }

}
