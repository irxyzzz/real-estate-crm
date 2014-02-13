/**
 * 
 */
package com.crm.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.sf.json.JSONObject;

import com.crm.dao.IAssignmentDAO;
import com.crm.dao.IAssignmentParticipantDAO;
import com.crm.dao.IEmployeeDAO;
import com.crm.dao.impl.AssignmentDAO;
import com.crm.dao.impl.AssignmentParticipantDAO;
import com.crm.dao.impl.EmployeeDAO;
import com.crm.model.Assignment;
import com.crm.model.AssignmentParticipant;
import com.crm.model.Employee;
import com.crm.service.IAssignmentService;
import com.crm.util.DateUtil;
import com.crm.util.MathUtil;

/**
 * @author lenovo
 * 
 */
public class AssignmentService implements IAssignmentService {
    private IAssignmentDAO assignmentDAO;
    private IAssignmentParticipantDAO assignmentParticipantDAO;
    private IEmployeeDAO employeeDAO;

    public AssignmentService() {
	assignmentDAO = new AssignmentDAO();
	assignmentParticipantDAO = new AssignmentParticipantDAO();
	employeeDAO = new EmployeeDAO();
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.crm.service.IAssignmentService#getEmployeeAssignments()
     */
    public List<Assignment> getEmployeeAssignments(int employeeId) {
	List<Assignment> myAssignments = new ArrayList<Assignment>();

	Employee employee = employeeDAO.findById(employeeId);
	if (employee.getIsManager()) { // 如果是主管
	    List<Assignment> allAssignments = assignmentDAO.findAll();
	    List<AssignmentParticipant> aps = assignmentParticipantDAO
		    .findAll();
	    List<AssignmentParticipant> myAps = new ArrayList<AssignmentParticipant>();
	    for (AssignmentParticipant ap : aps) {
		if (ap.getEmployee().getDepartment().equals(employee.getDepartment())) {
		    myAps.add(ap);
		}
	    }

	    for (Assignment a : allAssignments) {
		for (AssignmentParticipant ap : myAps) {
		    if (ap.getAssignment().getAssignmentId() == a
			    .getAssignmentId()) {
			myAssignments.add(a);
			break;
		    }
		}
	    }
	} else { // 是员工
	    List<AssignmentParticipant> myAps = new ArrayList<AssignmentParticipant>();
	    List<AssignmentParticipant> aps = assignmentParticipantDAO
		    .findAll();
	    for (AssignmentParticipant ap : aps) {
		if (ap.getEmployee().getEmployeeId() == employeeId) {
		    myAps.add(ap);
		}
	    }

	    List<Assignment> allAssignments = assignmentDAO.findAll();
	    for (Assignment a : allAssignments) {
		for (AssignmentParticipant ap : myAps) {
		    if (ap.getAssignment().getAssignmentId() == a
			    .getAssignmentId()) {
			myAssignments.add(a);
			break;
		    }
		}
	    }
	}

	return myAssignments;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.crm.service.IAssignmentService#getJSONEmployeeAssignments(int)
     */
    public String getJSONEmployeeAssignments(int employeeId) {
	String result;
	List<Assignment> assignments = getEmployeeAssignments(employeeId);
	List<JSONObject> jsonAssignments = new ArrayList<JSONObject>();

	for (Assignment assignment : assignments) {
	    JSONObject json = new JSONObject();
	    json.put("id", assignment.getAssignmentId());
	    json.put("title", assignment.getTitle());
	    json.put("start", assignment.getStringBeginTime());
	    json.put("end", assignment.getStringEndTime());
	    json.put("content", assignment.getContent());
	    json.put("participant", getAssignmentEmployees(assignment
		    .getAssignmentId()));
	    // json.put("allDay", "false");
	    jsonAssignments.add(json);
	}
	result = jsonAssignments.toString();
	return result;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.crm.service.IAssignmentService#getAssignmentEmployees(int)
     */
    public String getAssignmentEmployees(int assignmentId) {
	String result;
	StringBuffer sb = new StringBuffer();
	Map<Integer, String> part = new HashMap<Integer, String>();
	List<AssignmentParticipant> all = assignmentParticipantDAO.findAll();
	for (AssignmentParticipant ap : all) {
	    if (ap.getAssignment().getAssignmentId() == assignmentId) {
//		sb.append(MathUtil
//			.getFormatID(ap.getEmployee().getEmployeeId())
//			+ "-" + ap.getEmployee().getName() + ",");
		part.put(ap.getEmployee().getEmployeeId(), ap.getEmployee().getName());
	    }
	}
	
	Set<Integer> keys = part.keySet();
	Iterator<Integer> iter = keys.iterator();
	while(iter.hasNext()) {
	    int key = iter.next();
	    String id = MathUtil.getFormatID(key);
	    String name = part.get(key);
	    sb.append(id + "-" + name + ",");
	}

	result = sb.toString();
	result = result.substring(0, result.length() - 1);

	return result;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.crm.service.IAssignmentService#addAssignment(java.lang.String,
     * java.lang.String, java.lang.String, java.lang.String, java.lang.String)
     */
    public boolean addAssignment(String title, String content,
	    String beginTime, String endTime, String partEmployees) {
	if (title != null && content != null && beginTime != null
		&& endTime != null && partEmployees != null
		&& !title.equals("") && !content.equals("")
		&& !beginTime.equals("")
		&& !endTime.equals("") && !partEmployees.equals("")) {
	    Assignment assignment = new Assignment();
	    assignment.setTitle(title);
	    assignment.setContent(content);
	    assignment.setBeginTime(new Timestamp(DateUtil.toDateFormat(
		    beginTime).getTime()));
	    assignment.setEndTime(new Timestamp(DateUtil.toDateFormat(endTime)
		    .getTime()));

	    Set<AssignmentParticipant> aps = new HashSet<AssignmentParticipant>();
	    try {
		String[] participant = partEmployees.split(",");
		for (int i = 0; i < participant.length; i++) {
		    // get the employee id
		    String[] info = participant[i].split("-");
		    int id = Integer.parseInt(info[0].substring(1));
		    Employee e = employeeDAO.findById(id); // get employee

		    AssignmentParticipant ap = new AssignmentParticipant();
		    ap.setAssignment(assignment);
		    ap.setEmployee(e);

		    aps.add(ap);
		}

		assignment.setAssignmentParticipants(aps);
		assignment.setIsComplement(false);

		assignmentDAO.save(assignment);
		return true;

	    } catch (NumberFormatException e) {
		System.err.println(e.getMessage());
		return false;
	    }
	}

	return false;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.crm.service.IAssignmentService#modifyAssignment(java.lang.String,
     * java.lang.String, java.lang.String, java.lang.String, java.lang.String,
     * java.lang.String)
     */
    public boolean modifyAssignment(String assignmentId, String title,
	    String content, String beginTime, String endTime,
	    String partEmployees) {
	if (assignmentId != null && title != null && content != null
		&& beginTime != null && endTime != null
		&& partEmployees != null
		&& !title.equals("") && !content.equals("")
		&& !beginTime.equals("")
		&& !endTime.equals("") && !partEmployees.equals("")) {
	    try {
		int assId = Integer.parseInt(assignmentId);
		Assignment assignment = assignmentDAO.findById(assId);
		assignment.setTitle(title);
		assignment.setContent(content);
		assignment.setBeginTime(new Timestamp(DateUtil.toDateFormat(
			beginTime).getTime()));
		assignment.setEndTime(new Timestamp(DateUtil.toDateFormat(
			endTime).getTime()));

		Set<AssignmentParticipant> aps = new HashSet<AssignmentParticipant>();

		String[] participant = partEmployees.split(",");
		for (int i = 0; i < participant.length; i++) {
		    // get the employee id
		    String[] info = participant[i].split("-");
		    int id = Integer.parseInt(info[0].substring(1));
		    Employee e = employeeDAO.findById(id); // get employee

		    AssignmentParticipant ap = new AssignmentParticipant();
		    ap.setAssignment(assignment);
		    ap.setEmployee(e);

		    aps.add(ap);
		}
		
		assignment.setAssignmentParticipants(aps);
		assignment.setIsComplement(false);

		assignmentDAO.attachDirty(assignment);
		
		return true;

	    } catch (NumberFormatException e) {
		System.err.println(e.getMessage());
		return false;
	    }
	}

	return false;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.crm.service.IAssignmentService#deleteAssignment(java.lang.String)
     */
    public boolean deleteAssignment(String assignmentId) {
	if (assignmentId != null && !assignmentId.equals("")) {
	    try {
		int id = Integer.parseInt(assignmentId);
		Assignment assignment = assignmentDAO.findById(id);
		
		assignmentDAO.delete(assignment);
		
		return true;
	    } catch (NumberFormatException nfe) {
		System.err.println(nfe.getMessage());
		return false;
	    }
	}

	return false;
    }

}
