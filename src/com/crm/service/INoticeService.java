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
public interface INoticeService {
    
    public List<Notice> getLatestCompanyNotice();
    public List<Notice> getLatestSystemNotice();
}
