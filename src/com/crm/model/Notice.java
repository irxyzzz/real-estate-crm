package com.crm.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import com.crm.util.MathUtil;

/**
 * Notice entity. 
 * @author 
 */

public class Notice implements Serializable, Comparable<Notice> {
    private static final long serialVersionUID = 1L;

    private Integer noticeId;
    private String title;
    private String content;
    private Timestamp recordTime;
    private String classify;
    private String author;

    // Constructors

    /** default constructor */
    public Notice() {
    }

    /** full constructor */
    public Notice(String title, String content, Timestamp recordTime,
	    String classify, String author) {
	this.title = title;
	this.content = content;
	this.recordTime = recordTime;
	this.classify = classify;
	this.author = author;
    }

    // Property accessors

    public Integer getNoticeId() {
	return this.noticeId;
    }

    public void setNoticeId(Integer noticeId) {
	this.noticeId = noticeId;
    }

    public String getTitle() {
	return this.title;
    }

    public void setTitle(String title) {
	this.title = title;
    }

    public String getContent() {
	return this.content;
    }

    public void setContent(String content) {
	this.content = content;
    }

    public Timestamp getRecordTime() {
	return this.recordTime;
    }

    public void setRecordTime(Timestamp recordTime) {
	this.recordTime = recordTime;
    }

    public String getClassify() {
	return this.classify;
    }

    public void setClassify(String classify) {
	this.classify = classify;
    }

    public String getAuthor() {
	return this.author;
    }

    public void setAuthor(String author) {
	this.author = author;
    }

    /* (non-Javadoc)
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    public int compareTo(Notice o) {
	long time1 = this.getRecordTime().getTime();
	long time2 = o.getRecordTime().getTime();

	if (time1 < time2) {
	    return 1;
	} else if (time1 > time2) {
	    return -1;
	} else {
	    return 0;
	}
    }
    
    @SuppressWarnings("deprecation")
    public String getTime() {
	return this.recordTime.toLocaleString();
    }
    
    public String getFormatTime() {
	SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
	return sdf.format(this.recordTime);
    }
    
    public String getStringId() {
	return MathUtil.getFormatID(this.noticeId);
    }
}