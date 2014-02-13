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

import com.crm.dao.IEmployeeDAO;
import com.crm.dao.IHouseDAO;
import com.crm.dao.IResidenceCommunityDAO;
import com.crm.dao.impl.EmployeeDAO;
import com.crm.dao.impl.HouseDAO;
import com.crm.dao.impl.ResidenceCommunityDAO;
import com.crm.model.House;
import com.crm.util.MathUtil;

/**
 * @author lenovo
 *
 */
public class HouseDAOTest {
    
    private IHouseDAO houseDAO;
    private IResidenceCommunityDAO residenceCommunityDAO;
    private IEmployeeDAO employeeDAO;

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
	houseDAO = new HouseDAO();
	residenceCommunityDAO = new ResidenceCommunityDAO();
	employeeDAO = new EmployeeDAO();
    }

    /**
     * @throws java.lang.Exception
     */
    @After
    public void tearDown() throws Exception {
	houseDAO = null;
	residenceCommunityDAO = null;
	employeeDAO = null;
    }

    /**
     * Test method for {@link com.crm.dao.impl.HouseDAO#save(com.crm.model.House)}.
     */
    @SuppressWarnings("deprecation")
    @Test
    public void testSave() {
	Random random = new Random();
	for (int i = 1; i < 30; i++) {
	    House house = new House();
	    house.setArea(MathUtil.getRandomArea(50, 500));
	    if (random.nextInt(2) == 1) {
		house.setEmployeeByASEmployee(employeeDAO.findById(4));
	    }
	    else {
		house.setEmployeeByASEmployee(employeeDAO.findById(8));
	    }
	    if (random.nextInt(2) == 1) {
		house.setEmployeeBySaleEmployee(employeeDAO.findById(1));
	    }
	    else {
		house.setEmployeeBySaleEmployee(employeeDAO.findById(5));
	    }
	    house.setIsSale(true);
	    int m = random.nextInt(12) + 1;
	    int y = random.nextInt(30) + 1;
	    house.setSaleTime(new Timestamp(new Date(2010,m,y).getTime()));
	    house.setPosition("3d205");
	    house.setPrice(MathUtil.getRandomPrice(1500, 10000));
	    house.setResidenceCommunity(residenceCommunityDAO.findById(random.nextInt(4) + 1));
	    house.setCustomerId(36 + random.nextInt(5));
	    houseDAO.save(house);
	}
    }

    /**
     * Test method for {@link com.crm.dao.impl.HouseDAO#delete(com.crm.model.House)}.
     */
    @Test
    public void testDelete() {
	houseDAO.delete(houseDAO.findById(5));
    }

    /**
     * Test method for {@link com.crm.dao.impl.HouseDAO#findById(java.lang.Integer)}.
     */
    @Test
    public void testFindById() {
	fail("Not yet implemented"); // TODO
    }

    /**
     * Test method for {@link com.crm.dao.impl.HouseDAO#findByExample(com.crm.model.House)}.
     */
    @Test
    public void testFindByExample() {
	fail("Not yet implemented"); // TODO
    }

    /**
     * Test method for {@link com.crm.dao.impl.HouseDAO#findByProperty(java.lang.String, java.lang.Object)}.
     */
    @Test
    public void testFindByProperty() {
	fail("Not yet implemented"); // TODO
    }

    /**
     * Test method for {@link com.crm.dao.impl.HouseDAO#findByArea(java.lang.Object)}.
     */
    @Test
    public void testFindByArea() {
	fail("Not yet implemented"); // TODO
    }

    /**
     * Test method for {@link com.crm.dao.impl.HouseDAO#findByPosition(java.lang.Object)}.
     */
    @Test
    public void testFindByPosition() {
	fail("Not yet implemented"); // TODO
    }

    /**
     * Test method for {@link com.crm.dao.impl.HouseDAO#findByPrice(java.lang.Object)}.
     */
    @Test
    public void testFindByPrice() {
	fail("Not yet implemented"); // TODO
    }

    /**
     * Test method for {@link com.crm.dao.impl.HouseDAO#findByIsSale(java.lang.Object)}.
     */
    @Test
    public void testFindByIsSale() {
	fail("Not yet implemented"); // TODO
    }

    /**
     * Test method for {@link com.crm.dao.impl.HouseDAO#findByCustomerId(java.lang.Object)}.
     */
    @Test
    public void testFindByCustomerId() {
	fail("Not yet implemented"); // TODO
    }

    /**
     * Test method for {@link com.crm.dao.impl.HouseDAO#findAll()}.
     */
    @Test
    public void testFindAll() {
	List<House> houses = houseDAO.findAll();
	for (House house : houses) {
	    System.out.println(house.getArea());
	    System.out.println(house.getEmployeeByASEmployee().getName());
	    System.out.println(house.getIsSale());
	    System.out.println(house.getSaleTime());
	    System.out.println(house.getPosition());
	}
    }

    /**
     * Test method for {@link com.crm.dao.impl.HouseDAO#merge(com.crm.model.House)}.
     */
    @Test
    public void testMerge() {
	fail("Not yet implemented"); // TODO
    }

    /**
     * Test method for {@link com.crm.dao.impl.HouseDAO#attachDirty(com.crm.model.House)}.
     */
    @SuppressWarnings("deprecation")
    @Test
    public void testAttachDirty() {
	List<House> allHouse = houseDAO.findAll();
	Random random = new Random();
	for (House house: allHouse) {
	    if (house.getIsSale()) {
		int m = random.nextInt(12) + 1;
		int y = random.nextInt(30) + 1;
		house.setSaleTime(new Timestamp(new Date(110,m,y).getTime()));
		houseDAO.attachDirty(house);
	    }
	}
	
	
    }

    /**
     * Test method for {@link com.crm.dao.impl.HouseDAO#attachClean(com.crm.model.House)}.
     */
    @Test
    public void testAttachClean() {
	fail("Not yet implemented"); // TODO
    }

}
