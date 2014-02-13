package com.crm.util.test;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.crm.dao.IAssignmentDAO;
import com.crm.model.Assignment;
import com.crm.util.DAOFactory;

/**
 * 
 * @author 
 *
 */
public class DAOFactoryTest {
    private DAOFactory daoFactory;

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
	daoFactory = DAOFactory.getInstance();
    }

    /**
     * @throws java.lang.Exception
     */
    @After
    public void tearDown() throws Exception {
	daoFactory = null;
    }

    /**
     * Test method for {@link com.crm.util.DAOFactory#getDAO(java.lang.String)}.
     */
    @Test
    public void testGetDAO() {
	IAssignmentDAO assignmentDAO = (IAssignmentDAO) daoFactory.getDAO("assignmentDao");
	
	List<Assignment>  as = assignmentDAO.findAll();
	for (Assignment a : as) {
	    System.out.println(a.getTitle());
	}
    }

}
