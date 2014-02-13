package com.crm.service;

import java.util.List;

import com.crm.model.Company;
import com.crm.model.Competitor;
import com.crm.model.ResidenceCommunity;

public interface ICompetitorService {
    List<Competitor> getAllCompetitors();

    List<Company> getAllCompetiorCompany();

    List<ResidenceCommunity> getAllCompetitorRC();

    Competitor getCompetitor(String id);

    boolean deleteCompetitor(String id);

    boolean addCompetitor(String companey, String residence, String strategy);

    boolean modifyCompetitor(String id, String companey, String residence,
	    String strategy);

    boolean addCompany(String name, String corporation, String recordTime,
	    String address, String type, String homepage, String phone,
	    String post, String history);

    boolean deleteCompany(String companyID);

    public Company getCompany(String companyId);

    boolean modifyCompany(String id, String name, String corporation,
	    String recordTime, String address, String type, String homepage,
	    String phone, String post, String history);

    public List<ResidenceCommunity> getResidenceCommunities();

    public boolean deleteResidence(String residenceId);

    public ResidenceCommunity getResidenceCommunity(String rId);

    public boolean addResidence(String name, String area, String type,
	    String address, String company, String description);
    public boolean modifyResidence(String id, String name, String area, String type,
	    String address, String company, String description);
}
