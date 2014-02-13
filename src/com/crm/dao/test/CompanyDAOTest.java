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

import com.crm.dao.ICompanyDAO;
import com.crm.dao.impl.CompanyDAO;
import com.crm.model.Company;

/**
 * @author lenovo
 * 
 */
public class CompanyDAOTest {

    private ICompanyDAO companyDAO;

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
	companyDAO = new CompanyDAO();
    }

    /**
     * @throws java.lang.Exception
     */
    @After
    public void tearDown() throws Exception {
	companyDAO = null;
    }

    /**
     * Test method for
     * {@link com.crm.dao.impl.CompanyDAO#save(com.crm.model.Company)}.
     */
    @Test
    public void testSave() {

	for (int i = 1; i < 6; i++) {

	    Company company = new Company();
	    company.setName("XX房地产公司" + i);
	    company.setRecordDate(new Date());

	    companyDAO.save(company);
	}

    }

    /**
     * Test method for
     * {@link com.crm.dao.impl.CompanyDAO#delete(com.crm.model.Company)}.
     */
    @Test
    public void testDelete() {
	List<Company> company = companyDAO.findByName("XX房地产公司5");
	if (company.size() > 0) {
	    companyDAO.delete(company.get(0)); 
	}
	else {
	    System.out.println("Not found the data");
	}
	
    }

    /**
     * Test method for
     * {@link com.crm.dao.impl.CompanyDAO#findById(java.lang.Integer)}.
     */
    @Test
    public void testFindById() {
	fail("Not yet implemented"); // TODO
    }

    /**
     * Test method for
     * {@link com.crm.dao.impl.CompanyDAO#findByExample(com.crm.model.Company)}.
     */
    @Test
    public void testFindByExample() {
	fail("Not yet implemented"); // TODO
    }

    /**
     * Test method for
     * {@link com.crm.dao.impl.CompanyDAO#findByProperty(java.lang.String, java.lang.Object)}
     * .
     */
    @Test
    public void testFindByProperty() {
	fail("Not yet implemented"); // TODO
    }

    /**
     * Test method for
     * {@link com.crm.dao.impl.CompanyDAO#findByName(java.lang.Object)}.
     */
    @Test
    public void testFindByName() {
	fail("Not yet implemented"); // TODO
    }

    /**
     * Test method for
     * {@link com.crm.dao.impl.CompanyDAO#findByCorporation(java.lang.Object)}.
     */
    @Test
    public void testFindByCorporation() {
	fail("Not yet implemented"); // TODO
    }

    /**
     * Test method for
     * {@link com.crm.dao.impl.CompanyDAO#findByAddress(java.lang.Object)}.
     */
    @Test
    public void testFindByAddress() {
	fail("Not yet implemented"); // TODO
    }

    /**
     * Test method for
     * {@link com.crm.dao.impl.CompanyDAO#findByType(java.lang.Object)}.
     */
    @Test
    public void testFindByType() {
	fail("Not yet implemented"); // TODO
    }

    /**
     * Test method for
     * {@link com.crm.dao.impl.CompanyDAO#findByHomePage(java.lang.Object)}.
     */
    @Test
    public void testFindByHomePage() {
	fail("Not yet implemented"); // TODO
    }

    /**
     * Test method for
     * {@link com.crm.dao.impl.CompanyDAO#findByTelephone(java.lang.Object)}.
     */
    @Test
    public void testFindByTelephone() {
	fail("Not yet implemented"); // TODO
    }

    /**
     * Test method for
     * {@link com.crm.dao.impl.CompanyDAO#findByPostcard(java.lang.Object)}.
     */
    @Test
    public void testFindByPostcard() {
	fail("Not yet implemented"); // TODO
    }

    /**
     * Test method for
     * {@link com.crm.dao.impl.CompanyDAO#findByHistory(java.lang.Object)}.
     */
    @Test
    public void testFindByHistory() {
	fail("Not yet implemented"); // TODO
    }

    /**
     * Test method for {@link com.crm.dao.impl.CompanyDAO#findAll()}.
     */
    @Test
    public void testFindAll() {
	List<Company> companys = companyDAO.findAll();
	
	for (Company company : companys) {
	    
	    System.out.println(company.getName());
	    System.out.println(company.getRecordDate());
	}
    }

    /**
     * Test method for
     * {@link com.crm.dao.impl.CompanyDAO#merge(com.crm.model.Company)}.
     */
    @Test
    public void testMerge() {
	fail("Not yet implemented"); // TODO
    }

    /**
     * Test method for
     * {@link com.crm.dao.impl.CompanyDAO#attachDirty(com.crm.model.Company)}.
     */
    @Test
    public void testAttachDirty() {
	List<Company> companys = companyDAO.findAll();
	for (Company company : companys) {
	    company.setName(company.getName() + "+Modified");
	    companyDAO.attachDirty(company);
	}
	for (Company company : companyDAO.findAll()) {
	    System.out.println(company.getName());
	}
	
    }

    /**
     * Test method for
     * {@link com.crm.dao.impl.CompanyDAO#attachClean(com.crm.model.Company)}.
     */
    @Test
    public void testAttachClean() {
	fail("Not yet implemented"); // TODO
    }

}
