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

import com.crm.dao.ICustomerDAO;
import com.crm.dao.IHouseDAO;
import com.crm.dao.impl.CustomerDAO;
import com.crm.dao.impl.HouseDAO;
import com.crm.model.Customer;
import com.crm.model.House;

/**
 * @author lenovo
 * 
 */
public class CustomerDAOTest {
    private ICustomerDAO customerDAO;
    private IHouseDAO houseDao;

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
	customerDAO = new CustomerDAO();
	houseDao = new HouseDAO();
    }

    /**
     * @throws java.lang.Exception
     */
    @After
    public void tearDown() throws Exception {
	customerDAO = null;
    }

    /**
     * Test method for
     * {@link com.crm.dao.impl.CustomerDAO#save(com.crm.model.Customer)}.
     */
    @Test
    public void testSave() {
	for (int i = 1; i < 11; i++) {
	    Customer customer = new Customer();
	    customer.setName("李" + i);
	    customer.setAddress("天湖路" + i);
	    customer.setBirthday(new Date());
	    customer.setEmail("dd@dd.com");
	    customer.setGender("F");
	    customer.setHasHouse(true);
	    customer.setHouseId(i);
	    customer.setHobby("看书");
	    customer.setIncome("Level 2");
	    customer.setIsMarried(false);
	    customer.setJob("白领");
	    customer.setPhone("12345678978");
	    
	    customerDAO.save(customer);
	}

    }

    /**
     * Test method for
     * {@link com.crm.dao.impl.CustomerDAO#delete(com.crm.model.Customer)}.
     */
    @Test
    public void testDelete() {
	List<Customer> customers = customerDAO.findAll(); 
	if (customers.size()>4) {
	    customerDAO.delete(customers.get(4));
	}
	else {
	    System.out.println("Not found the data");
	}
    }

    /**
     * Test method for
     * {@link com.crm.dao.impl.CustomerDAO#findById(java.lang.Integer)}.
     */
    @Test
    public void testFindById() {
	fail("Not yet implemented"); // TODO
    }

    /**
     * Test method for
     * {@link com.crm.dao.impl.CustomerDAO#findByExample(com.crm.model.Customer)}
     * .
     */
    @Test
    public void testFindByExample() {
	fail("Not yet implemented"); // TODO
    }

    /**
     * Test method for
     * {@link com.crm.dao.impl.CustomerDAO#findByProperty(java.lang.String, java.lang.Object)}
     * .
     */
    @Test
    public void testFindByProperty() {
	fail("Not yet implemented"); // TODO
    }

    /**
     * Test method for
     * {@link com.crm.dao.impl.CustomerDAO#findByName(java.lang.Object)}.
     */
    @Test
    public void testFindByName() {
	fail("Not yet implemented"); // TODO
    }

    /**
     * Test method for
     * {@link com.crm.dao.impl.CustomerDAO#findByGender(java.lang.Object)}.
     */
    @Test
    public void testFindByGender() {
	fail("Not yet implemented"); // TODO
    }

    /**
     * Test method for
     * {@link com.crm.dao.impl.CustomerDAO#findByAddress(java.lang.Object)}.
     */
    @Test
    public void testFindByAddress() {
	fail("Not yet implemented"); // TODO
    }

    /**
     * Test method for
     * {@link com.crm.dao.impl.CustomerDAO#findByIsMarried(java.lang.Object)}.
     */
    @Test
    public void testFindByIsMarried() {
	fail("Not yet implemented"); // TODO
    }

    /**
     * Test method for
     * {@link com.crm.dao.impl.CustomerDAO#findByPhone(java.lang.Object)}.
     */
    @Test
    public void testFindByPhone() {
	fail("Not yet implemented"); // TODO
    }

    /**
     * Test method for
     * {@link com.crm.dao.impl.CustomerDAO#findByEmail(java.lang.Object)}.
     */
    @Test
    public void testFindByEmail() {
	fail("Not yet implemented"); // TODO
    }

    /**
     * Test method for
     * {@link com.crm.dao.impl.CustomerDAO#findByHasHouse(java.lang.Object)}.
     */
    @Test
    public void testFindByHasHouse() {
	fail("Not yet implemented"); // TODO
    }

    /**
     * Test method for
     * {@link com.crm.dao.impl.CustomerDAO#findByHouseId(java.lang.Object)}.
     */
    @Test
    public void testFindByHouseId() {
	fail("Not yet implemented"); // TODO
    }

    /**
     * Test method for
     * {@link com.crm.dao.impl.CustomerDAO#findByHouseIntent(java.lang.Object)}.
     */
    @Test
    public void testFindByHouseIntent() {
	fail("Not yet implemented"); // TODO
    }

    /**
     * Test method for
     * {@link com.crm.dao.impl.CustomerDAO#findByIncome(java.lang.Object)}.
     */
    @Test
    public void testFindByIncome() {
	fail("Not yet implemented"); // TODO
    }

    /**
     * Test method for
     * {@link com.crm.dao.impl.CustomerDAO#findByJob(java.lang.Object)}.
     */
    @Test
    public void testFindByJob() {
	fail("Not yet implemented"); // TODO
    }

    /**
     * Test method for
     * {@link com.crm.dao.impl.CustomerDAO#findByHobby(java.lang.Object)}.
     */
    @Test
    public void testFindByHobby() {
	fail("Not yet implemented"); // TODO
    }

    /**
     * Test method for {@link com.crm.dao.impl.CustomerDAO#findAll()}.
     */
    @Test
    public void testFindAll() {
	List<Customer> customers = customerDAO.findAll();
	for (Customer customer : customers) {
	    System.out.println("===================");
	    System.out.println(customer.getName());
	    System.out.println(customer.getAddress());
	    System.out.println(customer.getEmail());
	    System.out.println(customer.getGender());
	    System.out.println(customer.getHobby());
	    System.out.println(customer.getHouseIntent());
	    System.out.println(customer.getIncome());
	    System.out.println(customer.getJob());
	    System.out.println(customer.getPhone());
	    System.out.println(customer.getBirthday());
	    System.out.println(customer.getIsMarried());
	}
    }

    /**
     * Test method for
     * {@link com.crm.dao.impl.CustomerDAO#merge(com.crm.model.Customer)}.
     */
    @Test
    public void testMerge() {
	fail("Not yet implemented"); // TODO
    }

    /**
     * Test method for
     * {@link com.crm.dao.impl.CustomerDAO#attachDirty(com.crm.model.Customer)}.
     */
    @Test
    public void testAttachDirty() {
//	List<Customer> customers = customerDAO.findAll();
//	Random random = new Random();
//	for (Customer customer : customers) {
//	    int i = random.nextInt(2);
//	    if (i == 1) {
//		customer.setIsMarried(false);
//	    }
//	    else {
//		customer.setIsMarried(true);
//	    }
//	    customerDAO.attachDirty(customer);
//	}
	
//	for (Customer customer : customers) {
//	    int i = random.nextInt(8);
//	    if (i == 1) {
//		customer.setIncome("Level 1");
//	    }
//	    else if (i == 2){
//		customer.setIncome("Level 2");
//	    }
//	    else if (i == 3){
//		customer.setIncome("Level 3");
//	    }
//	    else if (i == 4){
//		customer.setIncome("Level 4");
//	    }
//	    else if (i == 5){
//		customer.setIncome("Level 5");
//	    }
//	    else if (i == 6){
//		customer.setIncome("Level 6");
//	    }
//	    else if (i == 7){
//		customer.setIncome("Level 7");
//	    }
//	    else {
//		customer.setIncome("Level 8");
//	    }
//	    customerDAO.attachDirty(customer);
//	}
	
//	for (Customer customer : customers) {
//	    int i = random.nextInt(5);
//	    if (i == 1) {
//		customer.setJob("经理");
//	    }
//	    else if (i == 2){
//		customer.setJob("白领");
//	    }
//	    else if (i == 3){
//		customer.setJob("教师");
//	    }
//	    else if (i == 4){
//		customer.setJob("蓝领");
//	    }
//	    else {
//		customer.setJob("个体");
//	    }
//	    customerDAO.attachDirty(customer);
//	}
//	
//	for (Customer customer : customers) {
//	    int i = random.nextInt(6);
//	    if (i == 1) {
//		customer.setHobby("外出旅游");
//	    }
//	    else if (i == 2){
//		customer.setHobby("安静的看书");
//	    }
//	    else if (i == 3){
//		customer.setHobby("室外游泳");
//	    }
//	    else if (i == 4){
//		customer.setHobby("体育运动");
//	    }
//	    else if (i == 5){
//		customer.setHobby("看看电影");
//	    }
//	    else {
//		customer.setHobby("听听音乐");
//	    }
//	    customerDAO.attachDirty(customer);
//	}
	
	
	List<House> house = houseDao.findAll();
	for(House h: house) {
	    if (h.getIsSale()) {
		int houseId = h.getHouseId();
		int customerId = h.getCustomerId();
		Customer c = customerDAO.findById(customerId);
		c.setHasHouse(true);
		c.setHouseId(houseId);
		customerDAO.attachDirty(c);
	    }
	}
    }

    /**
     * Test method for
     * {@link com.crm.dao.impl.CustomerDAO#attachClean(com.crm.model.Customer)}.
     */
    @Test
    public void testAttachClean() {
	fail("Not yet implemented"); // TODO
    }

}
