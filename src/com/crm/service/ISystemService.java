/**
 * 
 */
package com.crm.service;

import java.util.List;

import com.crm.model.Notice;

/**
 * @author lenovo
 *
 */
public interface ISystemService {
    public List<Notice> getSystemNotices();
    public List<Notice>	getManagerNotices();
    boolean deleteNotice(String noticeId);
    boolean addSystemNotice(String title, String content);
    boolean addCompanyNotice(int employeeId, String title, String content);
}
