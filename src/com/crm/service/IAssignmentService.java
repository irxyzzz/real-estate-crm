/**
 * 
 */
package com.crm.service;

import java.util.List;

import com.crm.model.Assignment;

/**
 * @author lenovo
 *
 */
public interface IAssignmentService {
    
    public List<Assignment> getEmployeeAssignments(int employeeId);
    public String getJSONEmployeeAssignments(int employeeId);
    public String getAssignmentEmployees(int assignmentId);
    public boolean addAssignment(String title, String content, String beginTime,
	    				String endTime, String partEmployees);
    public boolean modifyAssignment(String assignmentId, String title, 
	String content, String beginTime, String endTime, String partEmployees);
    
    public boolean deleteAssignment(String assignmentId);
}
