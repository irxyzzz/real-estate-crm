package com.crm.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.crm.dao.ICompanyDAO;
import com.crm.dao.ICompetitorDAO;
import com.crm.dao.IResidenceCommunityDAO;
import com.crm.dao.impl.CompanyDAO;
import com.crm.dao.impl.CompetitorDAO;
import com.crm.dao.impl.ResidenceCommunityDAO;
import com.crm.model.Company;
import com.crm.model.Competitor;
import com.crm.model.ResidenceCommunity;
import com.crm.service.ICompetitorService;
import com.crm.util.DateUtil;

public class CompetitorService implements ICompetitorService {
    private ICompetitorDAO competitorDAO;
    private ICompanyDAO companyDAO;
    private IResidenceCommunityDAO residenceCommunityDAO;

    public CompetitorService() {
	competitorDAO = new CompetitorDAO();
	companyDAO = new CompanyDAO();
	residenceCommunityDAO = new ResidenceCommunityDAO();
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.crm.service.ICompetitorInfoService#getAllCompetitors()
     */
    public List<Competitor> getAllCompetitors() {
	List<Competitor> allCompetitors = competitorDAO.findAll();
	return allCompetitors;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.crm.service.ICompetitorService#getAllCompetiorCompany()
     */
    public List<Company> getAllCompetiorCompany() {
	List<Company> allCompanies = companyDAO.findAll();
	Company own = companyDAO.findById(1);
	allCompanies.remove(own);
	return allCompanies;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.crm.service.ICompetitorService#getAllCompetitorRC()
     */
    public List<ResidenceCommunity> getAllCompetitorRC() {
	List<ResidenceCommunity> rcs = new ArrayList<ResidenceCommunity>();
	List<ResidenceCommunity> all = residenceCommunityDAO.findAll();
	for (ResidenceCommunity rc : all) {
	    if (rc.getCompany().getCompanyId() != 1) {
		rcs.add(rc);
	    }
	}
	return rcs;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.crm.service.ICompetitorService#deleteCompetitor(java.lang.String)
     */
    public boolean deleteCompetitor(String id) {
	if (id != null) {
	    try {
		int cId = Integer.parseInt(id);
		Competitor c = competitorDAO.findById(cId);
		competitorDAO.delete(c);
		return true;
	    } catch (NumberFormatException nfe) {
		System.err.println(nfe.getMessage());
		return false;
	    }
	}
	return false;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.crm.service.ICompetitorService#getCompetitor(java.lang.String)
     */
    public Competitor getCompetitor(String id) {
	if (id != null) {
	    try {
		int cId = Integer.parseInt(id);
		Competitor c = competitorDAO.findById(cId);
		return c;
	    } catch (NumberFormatException nfe) {
		System.err.println(nfe.getMessage());
		return null;
	    }
	}
	return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.crm.service.ICompetitorService#addCompetitor(java.lang.String,
     * java.lang.String, java.lang.String)
     */
    public boolean addCompetitor(String companey, String residence,
	    String strategy) {
	if (companey != null && residence != null && strategy != null) {
	    try {
		int companyId = Integer.parseInt(companey.trim());
		int residenceId = Integer.parseInt(residence.trim());
		Company c = companyDAO.findById(companyId);
		ResidenceCommunity rc = residenceCommunityDAO
			.findById(residenceId);

		Competitor competitor = new Competitor();
		competitor.setCompany(c);
		competitor.setResidenceCommunity(rc);
		competitor.setMarketStrategy(strategy);

		competitorDAO.save(competitor);
		return true;

	    } catch (NumberFormatException nfe) {
		System.err.println(nfe.getMessage());
		return false;
	    }
	}
	return false;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.crm.service.ICompetitorService#modifyCompetitor(java.lang.String,
     * java.lang.String, java.lang.String, java.lang.String)
     */
    public boolean modifyCompetitor(String id, String companey,
	    String residence, String strategy) {
	if (id != null && companey != null && residence != null
		&& strategy != null) {
	    try {
		int companyId = Integer.parseInt(companey);
		int residenceId = Integer.parseInt(residence);
		int competitorId = Integer.parseInt(id);
		Company c = companyDAO.findById(companyId);
		ResidenceCommunity rc = residenceCommunityDAO
			.findById(residenceId);

		Competitor competitor = competitorDAO.findById(competitorId);
		if (c.getCompanyId() != competitor.getCompany().getCompanyId()) {
		    competitor.setCompany(c);
		}
		if (rc.getResidenceId() != competitor.getResidenceCommunity()
			.getResidenceId()) {
		    competitor.setResidenceCommunity(rc);
		}
		competitor.setMarketStrategy(strategy);

		competitorDAO.attachDirty(competitor);
		return true;

	    } catch (NumberFormatException nfe) {
		System.err.println(nfe.getMessage());
		return false;
	    }
	}
	return false;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.crm.service.ICompetitorService#addCompany(java.lang.String,
     * java.lang.String, java.lang.String, java.lang.String, java.lang.String,
     * java.lang.String, java.lang.String, java.lang.String, java.lang.String)
     */
    public boolean addCompany(String name, String corporation,
	    String recordTime, String address, String type, String homepage,
	    String phone, String post, String history) {
	if (name != null && recordTime != null) {
	    Company company = new Company();
	    company.setAddress(address);
	    company.setCorporation(corporation);
	    company.setHistory(history);
	    company.setHomePage(homepage);
	    company.setName(name);
	    company.setPostcard(post);
	    company.setRecordDate(DateUtil.toDateFormat(recordTime));
	    company.setTelephone(phone);
	    company.setType(type);

	    companyDAO.save(company);
	    return true;
	}
	return false;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.crm.service.ICompetitorService#deleteCompany(java.lang.String)
     */
    public boolean deleteCompany(String companyID) {
	if (companyID != null && !companyID.equals("")) {
	    try {
		int id = Integer.parseInt(companyID);
		Company c = companyDAO.findById(id);
		companyDAO.delete(c);
		return true;
	    } catch (NumberFormatException nfe) {
		System.err.println(nfe.getMessage());
		return false;
	    }
	}

	return false;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.crm.service.ICompetitorService#getCompany(java.lang.String)
     */
    public Company getCompany(String companyId) {
	if (companyId != null && !companyId.equals("")) {
	    try {
		int id = Integer.parseInt(companyId);
		Company c = companyDAO.findById(id);
		return c;
	    } catch (NumberFormatException nfe) {
		System.err.println(nfe.getMessage());
		return null;
	    }
	}
	return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.crm.service.ICompetitorService#modifyCompany(java.lang.String,
     * java.lang.String, java.lang.String, java.lang.String, java.lang.String,
     * java.lang.String, java.lang.String, java.lang.String, java.lang.String,
     * java.lang.String)
     */
    public boolean modifyCompany(String id, String name, String corporation,
	    String recordTime, String address, String type, String homepage,
	    String phone, String post, String history) {
	if (id != null && name != null && recordTime != null) {
	    try {
		int cId = Integer.parseInt(id);
		Company company = companyDAO.findById(cId);
		company.setAddress(address);
		company.setCorporation(corporation);
		company.setHistory(history);
		company.setHomePage(homepage);
		company.setName(name);
		company.setPostcard(post);
		company.setRecordDate(DateUtil.toDateFormat(recordTime));
		company.setTelephone(phone);
		company.setType(type);

		companyDAO.attachDirty(company);
		return true;
	    } catch (NumberFormatException nfe) {
		System.err.println(nfe.getMessage());
		return false;
	    }

	}
	return false;
    }

    /* (non-Javadoc)
     * @see com.crm.service.ICompetitorService#getResidenceCommunities()
     */
    public List<ResidenceCommunity> getResidenceCommunities() {
	List<ResidenceCommunity> rsc = new ArrayList<ResidenceCommunity>();
	List<ResidenceCommunity> all= residenceCommunityDAO.findAll();
	for (ResidenceCommunity rc : all) {
	    if (rc.getCompany().getCompanyId() != 1) {
		rsc.add(rc);
	    }
	}
	return rsc;
    }

    /* (non-Javadoc)
     * @see com.crm.service.ICompetitorService#deleteResidence(java.lang.String)
     */
    public boolean deleteResidence(String residenceId) {
	if (residenceId != null && !residenceId.equals("")) {
	    try {
		int id = Integer.parseInt(residenceId);
		ResidenceCommunity rc = residenceCommunityDAO.findById(id);
		residenceCommunityDAO.delete(rc);
		return true;
	    } catch (NumberFormatException nfe) {
		System.err.println(nfe.getMessage());
		return false;
	    }
	}

	return false;
    }

    /* (non-Javadoc)
     * @see com.crm.service.ICompetitorService#getResidenceCommunity(java.lang.String)
     */
    public ResidenceCommunity getResidenceCommunity(String rId) {
	if (rId != null && !rId.equals("")) {
	    try {
		int id = Integer.parseInt(rId);
		ResidenceCommunity rc = residenceCommunityDAO.findById(id);
		return rc;
	    } catch (NumberFormatException nfe) {
		System.err.println(nfe.getMessage());
		return null;
	    }
	}

	return null;
    }

    /* (non-Javadoc)
     * @see com.crm.service.ICompetitorService#addResidence(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
     */
    public boolean addResidence(String name, String area, String type,
	    String address, String company, String description) {
	if (name != null && area != null && type != null && address != null 
		&& company != null && description != null) {
	    try {
		double dArea = Double.parseDouble(area);
		int id = Integer.parseInt(company.trim());
		ResidenceCommunity rc = new ResidenceCommunity();
		rc.setAddress(address);
		rc.setArea(dArea);
		rc.setDescription(description);
		rc.setName(name);
		rc.setType(type);
		rc.setCompany(companyDAO.findById(id));
		
		residenceCommunityDAO.save(rc);
		return true;
	    } catch (NumberFormatException e) {
		System.err.println(e.getMessage());
		return false;
	    }
	}
	return false;
    }

    /* (non-Javadoc)
     * @see com.crm.service.ICompetitorService#modifyResidence(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
     */
    public boolean modifyResidence(String id, String name, String area,
	    String type, String address, String company, String description) {
	if (id != null && name != null && area != null && type != null && address != null 
		&& company != null && description != null) {
	    try {
		double dArea = Double.parseDouble(area);
		int cId = Integer.parseInt(company.trim());
		int rId = Integer.parseInt(id);
		ResidenceCommunity rc = residenceCommunityDAO.findById(rId);
		
		rc.setAddress(address);
		rc.setArea(dArea);
		rc.setDescription(description);
		rc.setName(name);
		rc.setType(type);
		rc.setCompany(companyDAO.findById(cId));
		
		residenceCommunityDAO.attachDirty(rc);
		return true;
	    } catch (NumberFormatException e) {
		System.err.println(e.getMessage());
		return false;
	    }
	}
	return false;
    }

}
