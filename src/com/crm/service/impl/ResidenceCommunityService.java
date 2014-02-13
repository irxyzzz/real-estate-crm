/**
 * 
 */
package com.crm.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.crm.dao.ICompanyDAO;
import com.crm.dao.IResidenceCommunityDAO;
import com.crm.dao.impl.CompanyDAO;
import com.crm.dao.impl.ResidenceCommunityDAO;
import com.crm.model.Company;
import com.crm.model.ResidenceCommunity;
import com.crm.service.IResidenceCommunityService;

/**
 * @author lenovo
 *
 */
public class ResidenceCommunityService implements IResidenceCommunityService {
    
    private IResidenceCommunityDAO residenceCommunityDAO;
    private ICompanyDAO companyDAO;
    
    public ResidenceCommunityService() {
	this.residenceCommunityDAO = new ResidenceCommunityDAO();
	this.companyDAO = new CompanyDAO();
    }

    /* (non-Javadoc)
     * @see com.crm.servlet.IResidenceCommunityService#getAllOwnResidenceCommunities()
     */
    public List<ResidenceCommunity> getAllOwnResidenceCommunities() {
	List<ResidenceCommunity> residenceCommunities = new ArrayList<ResidenceCommunity>();
	
	Company ownCompany = companyDAO.findById(1);	// 默认第一个为本公司的信息
	List<ResidenceCommunity> allCommunities = residenceCommunityDAO.findAll();
	for (ResidenceCommunity rc : allCommunities) {	// 找出本公司的所有小区
	    if (rc.getCompany().equals(ownCompany)) {
		residenceCommunities.add(rc);
	    }
	}
	
	return residenceCommunities;
    }

}
