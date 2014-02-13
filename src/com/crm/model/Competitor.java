package com.crm.model;

import java.io.Serializable;

import com.crm.util.MathUtil;

/**
 * CompetitorInfo entity. 
 * @author 
 */

public class Competitor implements Serializable {

    // Fields

    private static final long serialVersionUID = 1L;
    private Integer competitorId;
    private Company company;
    private ResidenceCommunity residenceCommunity;
    private String marketStrategy;

    // Constructors

    /** default constructor */
    public Competitor() {
    }

    /** minimal constructor */
    public Competitor(Company company, ResidenceCommunity residenceCommunity) {
	this.company = company;
	this.residenceCommunity = residenceCommunity;
    }

    /** full constructor */
    public Competitor(Company company,
	    ResidenceCommunity residenceCommunity, String marketStrategy) {
	this.company = company;
	this.residenceCommunity = residenceCommunity;
	this.marketStrategy = marketStrategy;
    }

    /**
     * @return the competitorId
     */
    public Integer getCompetitorId() {
        return competitorId;
    }

    /**
     * @param competitorId the competitorId to set
     */
    public void setCompetitorId(Integer competitorId) {
        this.competitorId = competitorId;
    }

    /**
     * @return the company
     */
    public Company getCompany() {
        return company;
    }

    /**
     * @param company the company to set
     */
    public void setCompany(Company company) {
        this.company = company;
    }

    /**
     * @return the residenceCommunity
     */
    public ResidenceCommunity getResidenceCommunity() {
        return residenceCommunity;
    }

    /**
     * @param residenceCommunity the residenceCommunity to set
     */
    public void setResidenceCommunity(ResidenceCommunity residenceCommunity) {
        this.residenceCommunity = residenceCommunity;
    }

    /**
     * @return the marketStrategy
     */
    public String getMarketStrategy() {
        return marketStrategy;
    }

    /**
     * @param marketStrategy the marketStrategy to set
     */
    public void setMarketStrategy(String marketStrategy) {
        this.marketStrategy = marketStrategy;
    }

    /**
     * @return the marketStrategy
     */
    public String getStringId() {
        return MathUtil.getFormatID(this.competitorId);
    }
}