package com.crm.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.crm.util.MathUtil;

/**
 * ResidenceCommunity entity. 
 * @author 
 */

public class ResidenceCommunity implements Serializable {

    private static final long serialVersionUID = 1L;
    // Fields

    private Integer residenceId;
    private Company company;
    private String name;
    private String address;
    private Double area;
    private String type;
    private String description;
    private Set<Competitor> competitorInfos = new HashSet<Competitor>(0);
    private Set<House> houses = new HashSet<House>(0);

    // Constructors

    /** default constructor */
    public ResidenceCommunity() {
    }

    /** minimal constructor */
    public ResidenceCommunity(Company company, String name, String address) {
	this.company = company;
	this.name = name;
	this.address = address;
    }

    /** full constructor */
    public ResidenceCommunity(Company company, String name, String address,
	    Double area, String type, String description, Set<Competitor> competitorInfos,
	    Set<House> houses) {
	this.company = company;
	this.name = name;
	this.address = address;
	this.area = area;
	this.type = type;
	this.description = description;
	this.competitorInfos = competitorInfos;
	this.houses = houses;
    }

    // Property accessors

    public Integer getResidenceId() {
	return this.residenceId;
    }

    public void setResidenceId(Integer residenceId) {
	this.residenceId = residenceId;
    }

    public Company getCompany() {
	return this.company;
    }

    public void setCompany(Company company) {
	this.company = company;
    }

    public String getName() {
	return this.name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getAddress() {
	return this.address;
    }

    public void setAddress(String address) {
	this.address = address;
    }

    public Double getArea() {
	return this.area;
    }

    public void setArea(Double area) {
	this.area = area;
    }

    public String getType() {
	return this.type;
    }

    public void setType(String type) {
	this.type = type;
    }

    public String getDescription() {
	return this.description;
    }

    public void setDescription(String description) {
	this.description = description;
    }

    public Set<Competitor> getCompetitorInfos() {
	return this.competitorInfos;
    }

    public void setCompetitorInfos(Set<Competitor> competitorInfos) {
	this.competitorInfos = competitorInfos;
    }

    public Set<House> getHouses() {
	return this.houses;
    }

    public void setHouses(Set<House> houses) {
	this.houses = houses;
    }
    
    public String getStringId() {
	return MathUtil.getFormatID(this.residenceId);
    }

}