/**
 * 
 */
package com.crm.dao.test;

import static org.junit.Assert.fail;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.crm.dao.ICustomerDAO;
import com.crm.dao.IEmployeeCustomerDAO;
import com.crm.dao.IEmployeeDAO;
import com.crm.dao.impl.CustomerDAO;
import com.crm.dao.impl.EmployeeCustomerDAO;
import com.crm.dao.impl.EmployeeDAO;
import com.crm.model.Customer;
import com.crm.model.Employee;
import com.crm.model.EmployeeCustomer;

/**
 * @author lenovo
 *
 */
public class EmployeeCustomerDAOTest {
    
    private IEmployeeCustomerDAO employeeCustomerDAO;
    private IEmployeeDAO employeeDAO;
    private ICustomerDAO customerDAO;

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
	employeeCustomerDAO = new EmployeeCustomerDAO();
	employeeDAO = new EmployeeDAO();
	customerDAO = new CustomerDAO();
	
    }

    /**
     * @throws java.lang.Exception
     */
    @After
    public void tearDown() throws Exception {
	employeeCustomerDAO = null;
	customerDAO = null;
	employeeDAO = null;
    }

    /**
     * Test method for {@link com.crm.dao.impl.EmployeeCustomerDAO#save(com.crm.model.EmployeeCustomer)}.
     */
    @Test
    public void testSave() {
	EmployeeCustomer ec = new EmployeeCustomer();
	Employee employee = new Employee();
	employee.setName("测试级联添加员工");
	Customer customer = new Customer();
	customer.setName("测试级联添加客户");
	customer.setGender("M");
	customer.setBirthday(new Date());
	customer.setPhone("12312341234");
	customer.setEmail("xu@xx.com");
	ec.setCustomer(customer);
	ec.setEmployee(employee);
	employeeCustomerDAO.save(ec);
    }

    /**
     * Test method for {@link com.crm.dao.impl.EmployeeCustomerDAO#delete(com.crm.model.EmployeeCustomer)}.
     */
    @Test
    public void testDelete() {
	EmployeeCustomer ec = employeeCustomerDAO.findById(1);
	employeeCustomerDAO.delete(ec);
    }

    /**
     * Test method for {@link com.crm.dao.impl.EmployeeCustomerDAO#findById(java.lang.Integer)}.
     */
    @Test
    public void testFindById() {
	fail("Not yet implemented"); // TODO
    }

    /**
     * Test method for {@link com.crm.dao.impl.EmployeeCustomerDAO#findByExample(com.crm.model.EmployeeCustomer)}.
     */
    @Test
    public void testFindByExample() {
	fail("Not yet implemented"); // TODO
    }

    /**
     * Test method for {@link com.crm.dao.impl.EmployeeCustomerDAO#findByProperty(java.lang.String, java.lang.Object)}.
     */
    @Test
    public void testFindByProperty() {
	fail("Not yet implemented"); // TODO
    }

    /**
     * Test method for {@link com.crm.dao.impl.EmployeeCustomerDAO#findAll()}.
     */
    @Test
    public void testFindAll() {
	List<EmployeeCustomer> ecs = employeeCustomerDAO.findAll();
	for (EmployeeCustomer ec : ecs) {
	    System.out.println(ec.getEmployee().getName());
	    System.out.println(ec.getCustomer().getName());
	}
	System.out.println("==============");
	System.out.println(employeeDAO.findById(1).getName()+"管理的客户如下");
	Set<EmployeeCustomer> e = employeeDAO.findById(1).getEmployeeCustomers();
	Iterator<EmployeeCustomer> iter = e.iterator();
	while (iter.hasNext()) {
	    System.out.println(iter.next().getCustomer().getName());
	}
    }

    /**
     * Test method for {@link com.crm.dao.impl.EmployeeCustomerDAO#merge(com.crm.model.EmployeeCustomer)}.
     */
    @Test
    public void testMerge() {
	fail("Not yet implemented"); // TODO
    }

    /**
     * Test method for {@link com.crm.dao.impl.EmployeeCustomerDAO#attachDirty(com.crm.model.EmployeeCustomer)}.
     */
    @Test
    public void testAttachDirty() {
	
	EmployeeCustomer ec = employeeCustomerDAO.findById(2);
	ec.setEmployee(employeeDAO.findById(2));
	ec.setCustomer(customerDAO.findById(2));
	employeeCustomerDAO.attachDirty(ec);
    }

    /**
     * Test method for {@link com.crm.dao.impl.EmployeeCustomerDAO#attachClean(com.crm.model.EmployeeCustomer)}.
     */
    @Test
    public void testAttachClean() {
	fail("Not yet implemented"); // TODO
    }

}
