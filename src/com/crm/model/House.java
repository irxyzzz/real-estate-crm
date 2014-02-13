package com.crm.model;

import java.io.Serializable;
import java.sql.Timestamp;

import com.crm.util.MathUtil;

/**
 * House entity. 
 * @author 
 */

public class House implements Serializable, Comparable<House> {

    // Fields

    private static final long serialVersionUID = 1L;

    private Integer houseId;
    private Employee employeeByASEmployee;
    private Employee employeeBySaleEmployee;
    private ResidenceCommunity residenceCommunity;
    private Double area;
    private String position;
    private Double price;
    private Boolean isSale;
    private Integer customerId;
    private Timestamp saleTime;

    // Constructors

    /** default constructor */
    public House() {
	this.customerId = 0;
	this.isSale = false;
    }

    /** minimal constructor */
    public House(Employee employeeByAsEmployee,
	    Employee employeeBySaleEmployee,
	    ResidenceCommunity residenceCommunity, Double area,
	    String position, Double price) {
	this.employeeByASEmployee = employeeByAsEmployee;
	this.employeeBySaleEmployee = employeeBySaleEmployee;
	this.residenceCommunity = residenceCommunity;
	this.area = area;
	this.position = position;
	this.price = price;
    }

    /** full constructor */
    public House(Employee employeeByAsEmployee,
	    Employee employeeBySaleEmployee,
	    ResidenceCommunity residenceCommunity, Double area,
	    String position, Double price, Boolean isSale, Integer customerId) {
	this.employeeByASEmployee = employeeByAsEmployee;
	this.employeeBySaleEmployee = employeeBySaleEmployee;
	this.residenceCommunity = residenceCommunity;
	this.area = area;
	this.position = position;
	this.price = price;
	this.isSale = isSale;
	this.customerId = customerId;
    }

    /**
     * @return the houseId
     */
    public Integer getHouseId() {
        return houseId;
    }

    /**
     * @param houseId the houseId to set
     */
    public void setHouseId(Integer houseId) {
        this.houseId = houseId;
    }

    /**
     * @return the employeeByASEmployee
     */
    public Employee getEmployeeByASEmployee() {
        return employeeByASEmployee;
    }

    /**
     * @param employeeByASEmployee the employeeByASEmployee to set
     */
    public void setEmployeeByASEmployee(Employee employeeByASEmployee) {
        this.employeeByASEmployee = employeeByASEmployee;
    }

    /**
     * @return the employeeBySaleEmployee
     */
    public Employee getEmployeeBySaleEmployee() {
        return employeeBySaleEmployee;
    }

    /**
     * @param employeeBySaleEmployee the employeeBySaleEmployee to set
     */
    public void setEmployeeBySaleEmployee(Employee employeeBySaleEmployee) {
        this.employeeBySaleEmployee = employeeBySaleEmployee;
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
     * @return the area
     */
    public Double getArea() {
        return area;
    }

    /**
     * @param area the area to set
     */
    public void setArea(Double area) {
        this.area = area;
    }

    /**
     * @return the position
     */
    public String getPosition() {
        return position;
    }

    /**
     * @param position the position to set
     */
    public void setPosition(String position) {
        this.position = position;
    }

    /**
     * @return the price
     */
    public Double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * @return the isSale
     */
    public Boolean getIsSale() {
        return isSale;
    }

    /**
     * @param isSale the isSale to set
     */
    public void setIsSale(Boolean isSale) {
        this.isSale = isSale;
    }

    /**
     * @return the customerId
     */
    public Integer getCustomerId() {
        return customerId;
    }

    /**
     * @param customerId the customerId to set
     */
    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    /**
     * @param saleTime the saleTime to set
     */
    public void setSaleTime(Timestamp saleTime) {
	this.saleTime = saleTime;
    }

    /**
     * @return the saleTime
     */
    public Timestamp getSaleTime() {
	return saleTime;
    }

    /* (non-Javadoc)
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    public int compareTo(House o) {
	double area1 = this.getArea();
	double area2 = o.getArea();

	if (area1 < area2) {
	    return 1;
	} else if (area1 > area2) {
	    return -1;
	} else {
	    return 0;
	}
    }

    /**
     * @return the string id
     */
    public String getStringId() {
	return MathUtil.getFormatID(this.houseId);
    }
    
    /**
     * @return the string time
     */
    @SuppressWarnings("deprecation")
    public String getTime() {
	return this.saleTime.toLocaleString();
    }

}