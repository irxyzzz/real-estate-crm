/**
 * 
 */
package com.crm.dao.test;

import static org.junit.Assert.fail;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.crm.dao.IAssignmentDAO;
import com.crm.dao.IEmployeeDAO;
import com.crm.dao.impl.AssignmentDAO;
import com.crm.dao.impl.EmployeeDAO;
import com.crm.model.Assignment;
import com.crm.model.AssignmentParticipant;

/**
 * @author
 * 
 */
public class AssignmentDAOTest {

    private IAssignmentDAO assignmentDAO;
    private IEmployeeDAO employeeDAO;

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
	assignmentDAO = new AssignmentDAO();
	employeeDAO = new EmployeeDAO();
    }

    /**
     * @throws java.lang.Exception
     */
    @After
    public void tearDown() throws Exception {
	assignmentDAO = null;
	employeeDAO = null;
    }

    /**
     * Test method for
     * {@link com.crm.dao.impl.AssignmentDAO#save(com.crm.model.Assignment)}.
     */
    @Test
    public void testSave() {

	// for (int i = 0; i < 5; i++) {
	//	    
	// Assignment assignment = new Assignment();
	// assignment.setContent("任务计划安排" + i);
	// assignment.setBeginTime(new Timestamp((new Date()).getTime()));
	// assignment.setEndTime(new Timestamp((new Date()).getTime()));
	// assignment.setAssignmentParticipants(null);
	// assignment.setTitle("任务标题" + i);
	// assignment.setIsComplement(false);
	//
	// assignmentDAO.save(assignment);
	// }

	Assignment assignment = new Assignment();
	assignment.setContent("促销计划,折扣售房，促销计划,折扣售房");
	assignment.setBeginTime(new Timestamp((new Date()).getTime() - 1*24*3600*1000));
	assignment.setEndTime(new Timestamp((new Date()).getTime() + 2*24*3600*1000));
	
	AssignmentParticipant ap1 = new AssignmentParticipant();
	ap1.setAssignment(assignment);
	ap1.setEmployee(employeeDAO.findById(1));
	AssignmentParticipant ap2 = new AssignmentParticipant();
	ap2.setAssignment(assignment);
	ap2.setEmployee(employeeDAO.findById(6));
	Set<AssignmentParticipant> aps = new HashSet<AssignmentParticipant>();
	aps.add(ap1);
	aps.add(ap2);
	assignment.setAssignmentParticipants(aps);
	
	assignment.setTitle("促销计划");
	assignment.setIsComplement(false);

	assignmentDAO.save(assignment);
    }

    /**
     * Test method for
     * {@link com.crm.dao.impl.AssignmentDAO#delete(com.crm.model.Assignment)}.
     */
    @Test
    public void testDelete() {
	List<Assignment> assignment = (List<Assignment>) assignmentDAO
		.findByTitle("HAhA");
	if (assignment.size() > 0) {
	    assignmentDAO.delete(assignment.get(0));
	} else {
	    System.out.println("Not found the data");
	}

    }

    /**
     * Test method for
     * {@link com.crm.dao.impl.AssignmentDAO#findById(java.lang.Integer)}.
     */
    @Test
    public void testFindById() {
	fail("Not yet implemented"); // TODO
    }

    /**
     * Test method for
     * {@link com.crm.dao.impl.AssignmentDAO#findByProperty(java.lang.String, java.lang.Object)}
     * .
     */
    @Test
    public void testFindByProperty() {
	fail("Not yet implemented"); // TODO
    }

    /**
     * Test method for {@link com.crm.dao.impl.AssignmentDAO#findAll()}.
     */
    @Test
    public void testFindAll() {
	List<Assignment> assignments = assignmentDAO.findAll();

	for (Assignment assignment : assignments) {
	    System.out.println(assignment.getTitle());
	    System.out.println(assignment.getContent());
	    System.out.println(assignment.getBeginTime());
	    System.out.println(assignment.getEndTime());
	}
    }

    /**
     * Test method for
     * {@link com.crm.dao.impl.AssignmentDAO#merge(com.crm.model.Assignment)}.
     */
    @Test
    public void testMerge() {
	fail("Not yet implemented"); // TODO
    }

    /**
     * Test method for
     * {@link com.crm.dao.impl.AssignmentDAO#attachDirty(com.crm.model.Assignment)}
     * .
     */
    @Test
    public void testAttachDirty() {
	List<Assignment> assignments = assignmentDAO.findAll();
	for (Assignment assignment : assignments) {
	    assignment.setContent(assignment.getContent() + "修改测试");
	    assignmentDAO.attachDirty(assignment);
	}

    }

    /**
     * Test method for
     * {@link com.crm.dao.impl.AssignmentDAO#attachClean(com.crm.model.Assignment)}
     * .
     */
    @Test
    public void testAttachClean() {
	fail("Not yet implemented"); // TODO
    }

}
