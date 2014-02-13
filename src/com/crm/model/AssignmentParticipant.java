package com.crm.model;

import java.io.Serializable;

/**
 * TaskParticipantList entity. 
 * @author 
 */

public class AssignmentParticipant implements Serializable {

    // Fields

    private static final long serialVersionUID = 1L;
    private Integer assignmentParticipantId;
    private Assignment assignment;
    private Employee employee;

    // Constructors

    /** default constructor */
    public AssignmentParticipant() {
    }

    /** full constructor */
    public AssignmentParticipant(Assignment assignment, Employee employee) {
	this.assignment = assignment;
	this.employee = employee;
    }

    /**
     * @return the assignmentParticipantId
     */
    public Integer getAssignmentParticipantId() {
        return assignmentParticipantId;
    }

    /**
     * @param assignmentParticipantId the assignmentParticipantId to set
     */
    public void setAssignmentParticipantId(Integer assignmentParticipantId) {
        this.assignmentParticipantId = assignmentParticipantId;
    }

    /**
     * @return the assignment
     */
    public Assignment getAssignment() {
        return assignment;
    }

    /**
     * @param assignment the assignment to set
     */
    public void setAssignment(Assignment assignment) {
        this.assignment = assignment;
    }

    /**
     * @return the employee
     */
    public Employee getEmployee() {
        return employee;
    }

    /**
     * @param employee the employee to set
     */
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
    
}