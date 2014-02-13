/**
 * 
 */
package com.crm.dao.test;

import static org.junit.Assert.fail;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.crm.dao.IAssignmentDAO;
import com.crm.dao.IAssignmentParticipantDAO;
import com.crm.dao.IEmployeeDAO;
import com.crm.dao.impl.AssignmentDAO;
import com.crm.dao.impl.AssignmentParticipantDAO;
import com.crm.dao.impl.EmployeeDAO;
import com.crm.model.Assignment;
import com.crm.model.AssignmentParticipant;

/**
 * @author lenovo
 *
 */
public class AssignmentParticipantDAOTest {
    
    private IAssignmentParticipantDAO assignmentParticipantDAO;
    private IEmployeeDAO employeeDAO;
    private IAssignmentDAO assignmentDAO;

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
	assignmentParticipantDAO = new AssignmentParticipantDAO();
	employeeDAO = new EmployeeDAO();
	assignmentDAO = new AssignmentDAO();
    }

    /**
     * @throws java.lang.Exception
     */
    @After
    public void tearDown() throws Exception {
	assignmentParticipantDAO = null;
	employeeDAO = null;
	assignmentDAO = null;
    }

    /**
     * Test method for {@link com.crm.dao.impl.AssignmentParticipantDAO#save(com.crm.model.AssignmentParticipant)}.
     */
    @Test
    public void testSave() {
	Assignment assignment = new Assignment();
	assignment.setTitle("某某营销计划2");
	assignment.setContent("这是营销计划的内容2");
	assignment.setBeginTime(new Timestamp(new Date().getTime() - 7*24*3600*1000));
	assignment.setEndTime(new Timestamp(new Date().getTime() + 7*24*3600*1000));
	assignment.setIsComplement(false);
	assignmentDAO.save(assignment);
	
	AssignmentParticipant ap1 = new AssignmentParticipant();
	ap1.setAssignment(assignment);
	ap1.setEmployee(employeeDAO.findById(1));
	AssignmentParticipant ap2 = new AssignmentParticipant();
	ap2.setAssignment(assignment);
	ap2.setEmployee(employeeDAO.findById(3));
	
	assignmentParticipantDAO.save(ap1);
	assignmentParticipantDAO.save(ap2);
	
	
    }

    /**
     * Test method for {@link com.crm.dao.impl.AssignmentParticipantDAO#delete(com.crm.model.AssignmentParticipant)}.
     */
    @Test
    public void testDelete() {
	assignmentParticipantDAO.delete(assignmentParticipantDAO.findById(3));
    }

    /**
     * Test method for {@link com.crm.dao.impl.AssignmentParticipantDAO#findById(java.lang.Integer)}.
     */
    @Test
    public void testFindById() {
	fail("Not yet implemented"); // TODO
    }

    /**
     * Test method for {@link com.crm.dao.impl.AssignmentParticipantDAO#findByExample(com.crm.model.AssignmentParticipant)}.
     */
    @Test
    public void testFindByExample() {
	fail("Not yet implemented"); // TODO
    }

    /**
     * Test method for {@link com.crm.dao.impl.AssignmentParticipantDAO#findByProperty(java.lang.String, java.lang.Object)}.
     */
    @Test
    public void testFindByProperty() {
	fail("Not yet implemented"); // TODO
    }

    /**
     * Test method for {@link com.crm.dao.impl.AssignmentParticipantDAO#findAll()}.
     */
    @Test
    public void testFindAll() {
	List<AssignmentParticipant> aps = assignmentParticipantDAO.findAll();
	for (AssignmentParticipant ap : aps) {
	    System.out.println(ap.getAssignment().getContent());
	    System.out.println(ap.getEmployee().getName());
	}
	
    }

    /**
     * Test method for {@link com.crm.dao.impl.AssignmentParticipantDAO#merge(com.crm.model.AssignmentParticipant)}.
     */
    @Test
    public void testMerge() {
	fail("Not yet implemented"); // TODO
    }

    /**
     * Test method for {@link com.crm.dao.impl.AssignmentParticipantDAO#attachDirty(com.crm.model.AssignmentParticipant)}.
     */
    @Test
    public void testAttachDirty() {
	AssignmentParticipant ap = assignmentParticipantDAO.findById(3);
	ap.setEmployee(employeeDAO.findById(5));
	
	assignmentParticipantDAO.attachDirty(ap);
    }

    /**
     * Test method for {@link com.crm.dao.impl.AssignmentParticipantDAO#attachClean(com.crm.model.AssignmentParticipant)}.
     */
    @Test
    public void testAttachClean() {
	fail("Not yet implemented"); // TODO
    }

}
