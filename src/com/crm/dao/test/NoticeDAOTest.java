/**
 * 
 */
package com.crm.dao.test;

import static org.junit.Assert.fail;

import java.sql.Timestamp;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.crm.dao.INoticeDAO;
import com.crm.dao.impl.NoticeDAO;
import com.crm.model.Notice;

/**
 * @author lenovo
 *
 */
public class NoticeDAOTest {
    
    private INoticeDAO noticeDAO;

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
	noticeDAO = new NoticeDAO();
    }

    /**
     * @throws java.lang.Exception
     */
    @After
    public void tearDown() throws Exception {
	noticeDAO = null;
    }

    /**
     * Test method for {@link com.crm.dao.impl.NoticeDAO#save(com.crm.model.Notice)}.
     */
    @Test
    public void testSave() {
	for (int i = 1; i < 4; i++) {
	    Notice notice = new Notice();
	    notice.setTitle("开会通知" + i);
	    notice.setContent("2010.7.29下午开会,119会议室");
	    notice.setClassify("Manager");
	    notice.setAuthor("市场主管");
	    notice.setRecordTime(new Timestamp(new Date().getTime()));
	    noticeDAO.save(notice);
	}
	for (int i = 1; i < 4; i++) {
	    Notice notice = new Notice();
	    notice.setTitle("系统通知" + i);
	    notice.setContent("2010.7.29系统更新通知，届时封闭系统");
	    notice.setClassify("System");
	    notice.setAuthor("Admin");
	    notice.setRecordTime(new Timestamp(new Date().getTime()));
	    noticeDAO.save(notice);
	}
    }

    /**
     * Test method for {@link com.crm.dao.impl.NoticeDAO#delete(com.crm.model.Notice)}.
     */
    @Test
    public void testDelete() {
	fail("Not yet implemented"); // TODO
    }

    /**
     * Test method for {@link com.crm.dao.impl.NoticeDAO#findById(java.lang.Integer)}.
     */
    @Test
    public void testFindById() {
	fail("Not yet implemented"); // TODO
    }

    /**
     * Test method for {@link com.crm.dao.impl.NoticeDAO#findByExample(com.crm.model.Notice)}.
     */
    @Test
    public void testFindByExample() {
	fail("Not yet implemented"); // TODO
    }

    /**
     * Test method for {@link com.crm.dao.impl.NoticeDAO#findByProperty(java.lang.String, java.lang.Object)}.
     */
    @Test
    public void testFindByProperty() {
	fail("Not yet implemented"); // TODO
    }

    /**
     * Test method for {@link com.crm.dao.impl.NoticeDAO#findByTitle(java.lang.Object)}.
     */
    @Test
    public void testFindByTitle() {
	fail("Not yet implemented"); // TODO
    }

    /**
     * Test method for {@link com.crm.dao.impl.NoticeDAO#findByContent(java.lang.Object)}.
     */
    @Test
    public void testFindByContent() {
	fail("Not yet implemented"); // TODO
    }

    /**
     * Test method for {@link com.crm.dao.impl.NoticeDAO#findByClassify(java.lang.Object)}.
     */
    @Test
    public void testFindByClassify() {
	fail("Not yet implemented"); // TODO
    }

    /**
     * Test method for {@link com.crm.dao.impl.NoticeDAO#findByAuthor(java.lang.Object)}.
     */
    @Test
    public void testFindByAuthor() {
	fail("Not yet implemented"); // TODO
    }

    /**
     * Test method for {@link com.crm.dao.impl.NoticeDAO#findAll()}.
     */
    @Test
    public void testFindAll() {
	fail("Not yet implemented"); // TODO
    }

    /**
     * Test method for {@link com.crm.dao.impl.NoticeDAO#merge(com.crm.model.Notice)}.
     */
    @Test
    public void testMerge() {
	fail("Not yet implemented"); // TODO
    }

    /**
     * Test method for {@link com.crm.dao.impl.NoticeDAO#attachDirty(com.crm.model.Notice)}.
     */
    @Test
    public void testAttachDirty() {
	fail("Not yet implemented"); // TODO
    }

    /**
     * Test method for {@link com.crm.dao.impl.NoticeDAO#attachClean(com.crm.model.Notice)}.
     */
    @Test
    public void testAttachClean() {
	fail("Not yet implemented"); // TODO
    }

}
