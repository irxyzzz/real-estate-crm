/**
 * 
 */
package com.crm.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import com.crm.dao.INoticeDAO;
import com.crm.dao.impl.NoticeDAO;
import com.crm.model.Notice;
import com.crm.service.INoticeService;

/**
 * @author lenovo
 * 
 */
public class NoticeService implements INoticeService {
    private static int THREE_DAY = 3 * 24 * 3600 * 1000;
    private INoticeDAO noticeDAO;

    public NoticeService() {
	noticeDAO = new NoticeDAO();
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.crm.service.INoticeService#getLatestNotice()
     */
    public List<Notice> getLatestCompanyNotice() {
	List<Notice> latestNotices = new ArrayList<Notice>();

	// 获取最近3天的最新信息
	List<Notice> allNotices = noticeDAO.findAll();
	for (Notice notice : allNotices) {
	    if (notice.getClassify().equals("Manager")
		    && notice.getRecordTime().after(
			    new Date(new Date().getTime() - THREE_DAY))) {
		latestNotices.add(notice);
	    }
	}
	
	// 公司信息按时间排序
	if (latestNotices.size() > 1) {
	    Collections.sort(latestNotices);
	}

	return latestNotices;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.crm.service.INoticeService#getLatestSystemNotice()
     */
    public List<Notice> getLatestSystemNotice() {
	List<Notice> latestNotices = new ArrayList<Notice>();

	// 获取最近3天的最新信息
	List<Notice> allNotices = noticeDAO.findAll();
	for (Notice notice : allNotices) {
	    if (notice.getClassify().equals("System")
		    && notice.getRecordTime().after(
			    new Date(new Date().getTime() - THREE_DAY))) {
		latestNotices.add(notice);
	    }
	}
	
	// 系统信息按时间排序
	if (latestNotices.size() > 1) {
	    Collections.sort(latestNotices);
	}

	return latestNotices;
    }

}
