/**
 * 
 */
package com.crm.dao.test;

import static org.junit.Assert.fail;

import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.crm.dao.IEmployeeDAO;
import com.crm.dao.impl.EmployeeDAO;
import com.crm.model.Employee;

/**
 * @author lenovo
 * 
 */
public class EmployeeDAOTest {

    private IEmployeeDAO employeeDAO;

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
	employeeDAO = new EmployeeDAO();
    }

    /**
     * @throws java.lang.Exception
     */
    @After
    public void tearDown() throws Exception {
	employeeDAO = null;
    }

    /**
     * Test method for
     * {@link com.crm.dao.impl.EmployeeDAO#save(com.crm.model.Employee)}.
     */
    @Test
    public void testSave() {

	for (int i = 0; i < 5; i++) {
	    Employee employee = new Employee();
	    employee.setName("张"+i);
	    employee.setBirthday(new Date());
	    employee.setIsManager(false);
	    employee.setAddress("某某小区某某路"+i);
	    employee.setComeTime(new Date());
	    employee.setDepartment("销售部");
	    employee.setEmail("xx@xx.com");
	    employee.setGender("M");
	    employee.setHobby("打球打球打球");
	    employee.setIsMarried(false);
	    employee.setPhone("12312354321");
	    employee.setPost("720201");
	    
	    employeeDAO.save(employee);
	}

    }

    /**
     * Test method for
     * {@link com.crm.dao.impl.EmployeeDAO#delete(com.crm.model.Employee)}.
     */
    @Test
    public void testDelete() {
	List<Employee> employees = employeeDAO.findAll();
	if (employees.size() > 4) {
	    employeeDAO.delete(employees.get(4));
	}
	else {
	    System.out.println("Not Found Data");
	}   
    }

    /**
     * Test method for
     * {@link com.crm.dao.impl.EmployeeDAO#findById(java.lang.Integer)}.
     */
    @Test
    public void testFindById() {
	fail("Not yet implemented"); // TODO
    }

    /**
     * Test method for
     * {@link com.crm.dao.impl.EmployeeDAO#findByExample(com.crm.model.Employee)}
     * .
     */
    @Test
    public void testFindByExample() {
	fail("Not yet implemented"); // TODO
    }

    /**
     * Test method for
     * {@link com.crm.dao.impl.EmployeeDAO#findByProperty(java.lang.String, java.lang.Object)}
     * .
     */
    @Test
    public void testFindByProperty() {
	fail("Not yet implemented"); // TODO
    }

    /**
     * Test method for
     * {@link com.crm.dao.impl.EmployeeDAO#findByName(java.lang.Object)}.
     */
    @Test
    public void testFindByName() {
	fail("Not yet implemented"); // TODO
    }

    /**
     * Test method for
     * {@link com.crm.dao.impl.EmployeeDAO#findByGender(java.lang.Object)}.
     */
    @Test
    public void testFindByGender() {
	fail("Not yet implemented"); // TODO
    }

    /**
     * Test method for
     * {@link com.crm.dao.impl.EmployeeDAO#findByIsMarried(java.lang.Object)}.
     */
    @Test
    public void testFindByIsMarried() {
	fail("Not yet implemented"); // TODO
    }

    /**
     * Test method for
     * {@link com.crm.dao.impl.EmployeeDAO#findByAddress(java.lang.Object)}.
     */
    @Test
    public void testFindByAddress() {
	fail("Not yet implemented"); // TODO
    }

    /**
     * Test method for
     * {@link com.crm.dao.impl.EmployeeDAO#findByHobby(java.lang.Object)}.
     */
    @Test
    public void testFindByHobby() {
	fail("Not yet implemented"); // TODO
    }

    /**
     * Test method for
     * {@link com.crm.dao.impl.EmployeeDAO#findByPhone(java.lang.Object)}.
     */
    @Test
    public void testFindByPhone() {
	fail("Not yet implemented"); // TODO
    }

    /**
     * Test method for
     * {@link com.crm.dao.impl.EmployeeDAO#findByEmail(java.lang.Object)}.
     */
    @Test
    public void testFindByEmail() {
	fail("Not yet implemented"); // TODO
    }

    /**
     * Test method for
     * {@link com.crm.dao.impl.EmployeeDAO#findByDepartment(java.lang.Object)}.
     */
    @Test
    public void testFindByDepartment() {
	fail("Not yet implemented"); // TODO
    }

    /**
     * Test method for
     * {@link com.crm.dao.impl.EmployeeDAO#findByPost(java.lang.Object)}.
     */
    @Test
    public void testFindByPost() {
	fail("Not yet implemented"); // TODO
    }

    /**
     * Test method for
     * {@link com.crm.dao.impl.EmployeeDAO#findByIsManager(java.lang.Object)}.
     */
    @Test
    public void testFindByIsManager() {
	fail("Not yet implemented"); // TODO
    }

    /**
     * Test method for {@link com.crm.dao.impl.EmployeeDAO#findAll()}.
     */
    @Test
    public void testFindAll() {
	List<Employee> employees = employeeDAO.findAll();
	for (Employee employee : employees) {
	    System.out.println("=====================");
	    System.out.println(employee.getEmployeeId());
	    System.out.println(employee.getName());
	    System.out.println(employee.getDepartment());
	    System.out.println(employee.getGender());
	    System.out.println(employee.getEmail());
	    System.out.println(employee.getAddress());
	    System.out.println(employee.getComeTime());
	    System.out.println(employee.getHobby());
	    System.out.println(employee.getPhone());
	    
	}
    }

    /**
     * Test method for
     * {@link com.crm.dao.impl.EmployeeDAO#merge(com.crm.model.Employee)}.
     */
    @Test
    public void testMerge() {
	fail("Not yet implemented"); // TODO
    }

    /**
     * Test method for
     * {@link com.crm.dao.impl.EmployeeDAO#attachDirty(com.crm.model.Employee)}.
     */
    @Test
    public void testAttachDirty() {
	List<Employee> employees = employeeDAO.findAll();
	for (Employee employee : employees) {
	    employee.setAddress(employee.getAddress()+"#Modified");
	    employeeDAO.attachDirty(employee);
	}
    }

    /**
     * Test method for
     * {@link com.crm.dao.impl.EmployeeDAO#attachClean(com.crm.model.Employee)}.
     */
    @Test
    public void testAttachClean() {
	fail("Not yet implemented"); // TODO
    }

}
