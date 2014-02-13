package com.crm.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.crm.util.MathUtil;

/**
 * Company entity. 
 * 
 * @author
 */

public class Company implements Serializable {

    // Fields

    private static final long serialVersionUID = 1L;

    private Integer companyId;
    private String name;
    private String corporation;
    private Date recordDate;
    private String address;
    private String type;
    private String homePage;
    private String telephone;
    private String postcard;
    private String history;
    private Set<Competitor> competitorInfos = new HashSet<Competitor>(0);
    private Set<ResidenceCommunity> residenceCommunities = new HashSet<ResidenceCommunity>(0);

    // Constructors

    /** default constructor */
    public Company() {
    }

    /** minimal constructor */
    public Company(String name) {
	this.name = name;
    }

    /** full constructor */
    public Company(String name, String corporation, Date recordDate,
	    String address, String type, String homePage, String telephone,
	    String postcard, String history, Set<Competitor> competitorInfos,
	    Set<ResidenceCommunity> residenceCommunities) {
	this.name = name;
	this.corporation = corporation;
	this.recordDate = recordDate;
	this.address = address;
	this.type = type;
	this.homePage = homePage;
	this.telephone = telephone;
	this.postcard = postcard;
	this.history = history;
	this.competitorInfos = competitorInfos;
	this.residenceCommunities = residenceCommunities;
    }

    /**
     * @return the companyId
     */
    public Integer getCompanyId() {
        return companyId;
    }

    /**
     * @param companyId the companyId to set
     */
    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the corporation
     */
    public String getCorporation() {
        return corporation;
    }

    /**
     * @param corporation the corporation to set
     */
    public void setCorporation(String corporation) {
        this.corporation = corporation;
    }

    /**
     * @return the recordDate
     */
    public Date getRecordDate() {
        return recordDate;
    }

    /**
     * @param recordDate the recordDate to set
     */
    public void setRecordDate(Date recordDate) {
        this.recordDate = recordDate;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the homePage
     */
    public String getHomePage() {
        return homePage;
    }

    /**
     * @param homePage the homePage to set
     */
    public void setHomePage(String homePage) {
        this.homePage = homePage;
    }

    /**
     * @return the telephone
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * @param telephone the telephone to set
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    /**
     * @return the postcard
     */
    public String getPostcard() {
        return postcard;
    }

    /**
     * @param postcard the postcard to set
     */
    public void setPostcard(String postcard) {
        this.postcard = postcard;
    }

    /**
     * @return the history
     */
    public String getHistory() {
        return history;
    }

    /**
     * @param history the history to set
     */
    public void setHistory(String history) {
        this.history = history;
    }

    /**
     * @return the competitorInfos
     */
    public Set<Competitor> getCompetitorInfos() {
        return competitorInfos;
    }

    /**
     * @param competitorInfos the competitorInfos to set
     */
    public void setCompetitorInfos(Set<Competitor> competitorInfos) {
        this.competitorInfos = competitorInfos;
    }

    /**
     * @return the residenceCommunities
     */
    public Set<ResidenceCommunity> getResidenceCommunities() {
        return residenceCommunities;
    }

    /**
     * @param residenceCommunities the residenceCommunities to set
     */
    public void setResidenceCommunities(Set<ResidenceCommunity> residenceCommunities) {
        this.residenceCommunities = residenceCommunities;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
	Company company = (Company)obj;
	if (this.address.equals(company.getAddress())
		&& this.corporation.equals(company.getCorporation())
		&& this.history.equals(company.getHistory())
		&& this.homePage.equals(company.getHomePage())
		&& this.name.equals(company.getName())
		&& this.postcard.equals(company.getPostcard())
		&& this.telephone.equals(company.getTelephone())
		&& this.type.equals(company.getType())) {
	    
	    return true;
	}
	return false;
    }
    
    /**
     * @return the string id
     */
    public String getStringId() {
        return MathUtil.getFormatID(this.companyId);
    }
    
    /**
     * @return the string time
     */
    public String getTime() {
	SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
	return sdf.format(this.recordDate);
    }
}