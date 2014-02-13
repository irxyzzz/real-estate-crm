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
import com.crm.dao.ICompetitorDAO;
import com.crm.dao.IResidenceCommunityDAO;
import com.crm.dao.impl.CompanyDAO;
import com.crm.dao.impl.CompetitorDAO;
import com.crm.dao.impl.ResidenceCommunityDAO;
import com.crm.model.Competitor;

/**
 * @author lenovo
 * 
 */
public class CompetitorDAOTest {

    private ICompetitorDAO competitorDAO;
    private ICompanyDAO companyDAO;
    private IResidenceCommunityDAO residenceCommunityDAO;

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
	competitorDAO = new CompetitorDAO();
	companyDAO = new CompanyDAO();
	residenceCommunityDAO = new ResidenceCommunityDAO();
    }

    /**
     * @throws java.lang.Exception
     */
    @After
    public void tearDown() throws Exception {
	competitorDAO = null;
	companyDAO = null;
	residenceCommunityDAO = null;
    }

    /**
     * Test method for
     * {@link com.crm.dao.impl.CompetitorDAO#save(com.crm.model.Competitor)}.
     */
    @Test
    public void testSave() {
	for (int i = 1; i < 6; i++) {
	    Competitor competitor = new Competitor();
	    competitor.setCompany(companyDAO.findById(4));
	    competitor.setResidenceCommunity(residenceCommunityDAO.findById(4));
	    competitor.setMarketStrategy("某某营销策略" + i);

	    competitorDAO.save(competitor);
	}
    }

    /**
     * Test method for
     * {@link com.crm.dao.impl.CompetitorDAO#delete(com.crm.model.Competitor)}.
     */
    @Test
    public void testDelete() {
	Competitor competitor = competitorDAO.findById(5);
	competitorDAO.delete(competitor);
	
    }

    /**
     * Test method for
     * {@link com.crm.dao.impl.CompetitorDAO#findById(java.lang.Integer)}.
     */
    @Test
    public void testFindById() {
	fail("Not yet implemented"); // TODO
    }

    /**
     * Test method for
     * {@link com.crm.dao.impl.CompetitorDAO#findByExample(com.crm.model.Competitor)}
     * .
     */
    @Test
    public void testFindByExample() {
	fail("Not yet implemented"); // TODO
    }

    /**
     * Test method for
     * {@link com.crm.dao.impl.CompetitorDAO#findByProperty(java.lang.String, java.lang.Object)}
     * .
     */
    @Test
    public void testFindByProperty() {
	fail("Not yet implemented"); // TODO
    }

    /**
     * Test method for
     * {@link com.crm.dao.impl.CompetitorDAO#findByMarketStrategy(java.lang.Object)}
     * .
     */
    @Test
    public void testFindByMarketStrategy() {
	fail("Not yet implemented"); // TODO
    }

    /**
     * Test method for {@link com.crm.dao.impl.CompetitorDAO#findAll()}.
     */
    @Test
    public void testFindAll() {
	List<Competitor> competitors = competitorDAO.findAll(); 
	for (Competitor competitor : competitors) {
	    System.out.println(competitor.getCompetitorId());
	    System.out.println(competitor.getCompany().getName());
	    System.out.println(competitor.getResidenceCommunity().getName());
	    System.out.println(competitor.getMarketStrategy());
	}
    }

    /**
     * Test method for
     * {@link com.crm.dao.impl.CompetitorDAO#merge(com.crm.model.Competitor)}.
     */
    @Test
    public void testMerge() {
	fail("Not yet implemented"); // TODO
    }

    /**
     * Test method for
     * {@link com.crm.dao.impl.CompetitorDAO#attachDirty(com.crm.model.Competitor)}
     * .
     */
    @Test
    public void testAttachDirty() {
	Competitor competitor = competitorDAO.findById(4);
	competitor.setMarketStrategy(competitor.getMarketStrategy() + "+Modified");
	competitorDAO.attachDirty(competitor);
    }

    /**
     * Test method for
     * {@link com.crm.dao.impl.CompetitorDAO#attachClean(com.crm.model.Competitor)}
     * .
     */
    @Test
    public void testAttachClean() {
	fail("Not yet implemented"); // TODO
    }

}
