/**
 * 
 */
package com.crm.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.crm.dao.IEmployeeDAO;
import com.crm.dao.INoticeDAO;
import com.crm.dao.impl.EmployeeDAO;
import com.crm.dao.impl.NoticeDAO;
import com.crm.model.Employee;
import com.crm.model.Notice;
import com.crm.service.ISystemService;

/**
 * @author lenovo
 *
 */
public class SystemService implements ISystemService {
    private INoticeDAO noticeDAO;
    private IEmployeeDAO employeeDAO;
    
    public SystemService() {
	noticeDAO = new NoticeDAO();
	employeeDAO = new EmployeeDAO();
    }

    /* (non-Javadoc)
     * @see com.crm.service.ISystemService#getManagerNotices()
     */
    public List<Notice> getManagerNotices() {
	List<Notice> notices = new ArrayList<Notice>();
	List<Notice> all = noticeDAO.findAll();
	for(Notice n : all) {
	    if (n.getClassify().equals("Manager")) {
		notices.add(n);
	    }
	}
	return notices;
    }

    /* (non-Javadoc)
     * @see com.crm.service.ISystemService#getSystemNotices()
     */
    public List<Notice> getSystemNotices() {
	List<Notice> notices = new ArrayList<Notice>();
	List<Notice> all = noticeDAO.findAll();
	for(Notice n : all) {
	    if (n.getClassify().equals("System")) {
		notices.add(n);
	    }
	}
	return notices;
    }

    /* (non-Javadoc)
     * @see com.crm.service.ISystemService#deleteNotice(java.lang.String)
     */
    public boolean deleteNotice(String noticeId) {
	if (noticeId != null) {
	    try {
		int id = Integer.parseInt(noticeId);
		Notice notice = noticeDAO.findById(id);
		noticeDAO.delete(notice);
		return true;
	    }
	    catch (NumberFormatException nfe) {
		System.err.println(nfe);
		return false;
	    }
	}
	return false;
    }

    /* (non-Javadoc)
     * @see com.crm.service.ISystemService#addSystemNotice(java.lang.String, java.lang.String)
     */
    public boolean addSystemNotice(String title, String content) {
	if(title != null && content != null ) {
	    Notice notice = new Notice();
	    notice.setAuthor("admin");
	    notice.setClassify("System");
	    notice.setContent(content);
	    notice.setRecordTime(new Timestamp(new Date().getTime()));
	    notice.setTitle(title);
	    
	    noticeDAO.save(notice);
	    return true;
	}
	return false;
    }

    /* (non-Javadoc)
     * @see com.crm.service.ISystemService#addCompanyNotice(java.lang.String, java.lang.String)
     */
    public boolean addCompanyNotice(int employeeId, String title, String content) {
	Employee manager = employeeDAO.findById(employeeId);
	if(title != null && content != null ) {
	    Notice notice = new Notice();
	    notice.setAuthor(manager.getName());
	    notice.setClassify("Manager");
	    notice.setContent(content);
	    notice.setRecordTime(new Timestamp(new Date().getTime()));
	    notice.setTitle(title);
	    
	    noticeDAO.save(notice);
	    return true;
	}
	return false;
    }
}
