/**
 * 
 */
package com.crm.dao.test;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.crm.dao.ICompanyDAO;
import com.crm.dao.IResidenceCommunityDAO;
import com.crm.dao.impl.CompanyDAO;
import com.crm.dao.impl.ResidenceCommunityDAO;
import com.crm.model.Company;
import com.crm.model.ResidenceCommunity;

/**
 * @author lenovo
 * 
 */
public class ResidenceCommunityDAOTest {

    private IResidenceCommunityDAO residenceCommunityDAO;
    private ICompanyDAO companyDAO;

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
	residenceCommunityDAO = new ResidenceCommunityDAO();
	companyDAO = new CompanyDAO();
    }

    /**
     * @throws java.lang.Exception
     */
    @After
    public void tearDown() throws Exception {
	residenceCommunityDAO = null;
	companyDAO = null;
    }

    /**
     * Test method for
     * {@link com.crm.dao.impl.ResidenceCommunityDAO#save(com.crm.model.ResidenceCommunity)}
     * .
     */
    @Test
    public void testSave() {
	for (int i = 1; i < 6; i++) {
	    ResidenceCommunity residenceCommunity = new ResidenceCommunity();
	    
	    if (i < 3) {
		residenceCommunity.setName("塔瓦诺小区" + i);
		residenceCommunity.setCompany(companyDAO.findById(2));
		residenceCommunity.setAddress("西安市区友谊路" + i);
		residenceCommunity.setArea(189.22);
		residenceCommunity.setType("住宅");
	    } else {
		residenceCommunity.setName("里尼小区" + i);
		residenceCommunity.setCompany(companyDAO.findById(3));
		residenceCommunity.setAddress("西安市区大学路" + i);
		residenceCommunity.setArea(123.22);
		residenceCommunity.setType("商务");
	    }
	    
	    residenceCommunityDAO.save(residenceCommunity);
	}

    }

    /**
     * Test method for
     * {@link com.crm.dao.impl.ResidenceCommunityDAO#delete(com.crm.model.ResidenceCommunity)}
     * .
     */
    @Test
    public void testDelete() {
	List<ResidenceCommunity> residenceCommunity = residenceCommunityDAO.findAll();
	if (residenceCommunity.size() > 4) {
	    residenceCommunityDAO.delete(residenceCommunity.get(4));
	}
	else {
	    System.out.println("Not found data");
	}
    }

    /**
     * Test method for
     * {@link com.crm.dao.impl.ResidenceCommunityDAO#findById(java.lang.Integer)}
     * .
     */
    @Test
    public void testFindById() {
	fail("Not yet implemented"); // TODO
    }

    /**
     * Test method for
     * {@link com.crm.dao.impl.ResidenceCommunityDAO#findByExample(com.crm.model.ResidenceCommunity)}
     * .
     */
    @Test
    public void testFindByExample() {
	fail("Not yet implemented"); // TODO
    }

    /**
     * Test method for
     * {@link com.crm.dao.impl.ResidenceCommunityDAO#findByProperty(java.lang.String, java.lang.Object)}
     * .
     */
    @Test
    public void testFindByProperty() {
	fail("Not yet implemented"); // TODO
    }

    /**
     * Test method for
     * {@link com.crm.dao.impl.ResidenceCommunityDAO#findByName(java.lang.Object)}
     * .
     */
    @Test
    public void testFindByName() {
	fail("Not yet implemented"); // TODO
    }

    /**
     * Test method for
     * {@link com.crm.dao.impl.ResidenceCommunityDAO#findByAddress(java.lang.Object)}
     * .
     */
    @Test
    public void testFindByAddress() {
	fail("Not yet implemented"); // TODO
    }

    /**
     * Test method for
     * {@link com.crm.dao.impl.ResidenceCommunityDAO#findByArea(java.lang.Object)}
     * .
     */
    @Test
    public void testFindByArea() {
	fail("Not yet implemented"); // TODO
    }

    /**
     * Test method for
     * {@link com.crm.dao.impl.ResidenceCommunityDAO#findByType(java.lang.Object)}
     * .
     */
    @Test
    public void testFindByType() {
	fail("Not yet implemented"); // TODO
    }

    /**
     * Test method for
     * {@link com.crm.dao.impl.ResidenceCommunityDAO#findByDescription(java.lang.Object)}
     * .
     */
    @Test
    public void testFindByDescription() {
	fail("Not yet implemented"); // TODO
    }

    /**
     * Test method for {@link com.crm.dao.impl.ResidenceCommunityDAO#findAll()}.
     */
    @Test
    public void testFindAll() {
	List<ResidenceCommunity> residenceCommunities = residenceCommunityDAO.findAll();
	for (ResidenceCommunity residenceCommunity : residenceCommunities) {
	    System.out.println(residenceCommunity.getName());
	    System.out.println(residenceCommunity.getAddress());
	    System.out.println(residenceCommunity.getType());
	    System.out.println(residenceCommunity.getArea());
	    System.out.println("Company :" + residenceCommunity.getCompany().getName());
	}
    }

    /**
     * Test method for
     * {@link com.crm.dao.impl.ResidenceCommunityDAO#merge(com.crm.model.ResidenceCommunity)}
     * .
     */
    @Test
    public void testMerge() {
	fail("Not yet implemented"); // TODO
    }

    /**
     * Test method for
     * {@link com.crm.dao.impl.ResidenceCommunityDAO#attachDirty(com.crm.model.ResidenceCommunity)}
     * .
     */
    @Test
    public void testAttachDirty() {
	List<ResidenceCommunity> residenceCommunities = residenceCommunityDAO.findAll();
	for (ResidenceCommunity residenceCommunity : residenceCommunities) {
	    residenceCommunity.setName(residenceCommunity.getName()+"Modified");
	    
	    Company company = residenceCommunity.getCompany();
	    if (company.getCompanyId() == 1) {
		residenceCommunity.setCompany(companyDAO.findById(3));
	    }
	    if (company.getCompanyId() == 2) {
		residenceCommunity.setCompany(companyDAO.findById(4));
	    }
	    
	    residenceCommunityDAO.attachDirty(residenceCommunity);
	}
    }

    /**
     * Test method for
     * {@link com.crm.dao.impl.ResidenceCommunityDAO#attachClean(com.crm.model.ResidenceCommunity)}
     * .
     */
    @Test
    public void testAttachClean() {
	fail("Not yet implemented"); // TODO
    }

}
