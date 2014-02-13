package com.crm.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Set;
/**
 * Task entity. 
 * @author 
 */

public class Assignment implements Serializable {

    // Fields

    private static final long serialVersionUID = 1L;

    private Integer assignmentId;
    private String title;
    private String content;
    private Timestamp beginTime;
    private Timestamp endTime;
    private Boolean isComplement;
    private Set<AssignmentParticipant> assignmentParticipants = new HashSet<AssignmentParticipant>(0);

    // Constructors

    /** default constructor */
    public Assignment() {
    }

    /** minimal constructor */
    public Assignment(String title, String content, Timestamp beginTime,
	    Timestamp endTime, Boolean isComplement) {
	this.setTitle(title);
	this.setContent(content);
	this.setBeginTime(beginTime);
	this.setEndTime(endTime);
	this.setIsComplement(isComplement);
    }

    /** full constructor */
    public Assignment(String title, String content, Timestamp beginTime,
	    Timestamp endTime, Boolean isComplement, 
	    Set<AssignmentParticipant> assignmentParticipants) {
	this.setTitle(title);
	this.setContent(content);
	this.setBeginTime(beginTime);
	this.setEndTime(endTime);
	this.setIsComplement(isComplement);
	this.setAssignmentParticipants(assignmentParticipants);
    }

   
    /**
     * @param assignmentId the assignmentId to set
     */
    public void setAssignmentId(Integer assignmentId) {
	this.assignmentId = assignmentId;
    }

    /**
     * @return the assignmentId
     */
    public Integer getAssignmentId() {
	return assignmentId;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
	this.title = title;
    }

    /**
     * @return the title
     */
    public String getTitle() {
	return title;
    }

    /**
     * @param content the content to set
     */
    public void setContent(String content) {
	this.content = content;
    }

    /**
     * @return the content
     */
    public String getContent() {
	return content;
    }

    /**
     * @param beginTime the beginTime to set
     */
    public void setBeginTime(Timestamp beginTime) {
	this.beginTime = beginTime;
    }

    /**
     * @return the beginTime
     */
    public Timestamp getBeginTime() {
	return beginTime;
    }

    /**
     * @param endTime the endTime to set
     */
    public void setEndTime(Timestamp endTime) {
	this.endTime = endTime;
    }

    /**
     * @return the endTime
     */
    public Timestamp getEndTime() {
	return endTime;
    }

    /**
     * @param isComplement the isComplement to set
     */
    public void setIsComplement(Boolean isComplement) {
	this.isComplement = isComplement;
    }

    /**
     * @return the isComplement
     */
    public Boolean getIsComplement() {
	return isComplement;
    }

    /**
     * @param assignmentParticipants the assignmentParticipants to set
     */
    public void setAssignmentParticipants(Set<AssignmentParticipant> assignmentParticipants) {
	this.assignmentParticipants = assignmentParticipants;
    }

    /**
     * @return the assignmentParticipants
     */
    public Set<AssignmentParticipant> getAssignmentParticipants() {
	return assignmentParticipants;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
	Assignment o = (Assignment) obj;
	if (o.getIsComplement().equals(this.getIsComplement())
		&& o.getBeginTime().equals(this.getBeginTime())
		&& o.getContent().equals(this.getContent())
		&& o.getEndTime().equals(this.getEndTime())
		&& o.getTitle().equals(this.getTitle())) {
	    return true;
	}
	return false;
    }
    
    /**
     * @return the string beginTime
     */
    public String getStringBeginTime() {
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	return sdf.format(this.beginTime);
    }

    /**
     * @return the string endTime
     */
    public String getStringEndTime() {
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	return sdf.format(this.endTime);
    }

}