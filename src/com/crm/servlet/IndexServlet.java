/**
 * 
 */
package com.crm.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crm.model.Notice;
import com.crm.service.INoticeService;
import com.crm.service.impl.NoticeService;

/**
 * @author lenovo
 *
 */
public class IndexServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private INoticeService noticeService;

    /**
     * Destruction of the servlet. <br>
     */
    public void destroy() {
	super.destroy(); // Just puts "destroy" string in log
	noticeService = null;
    }

    /**
     * The doGet method of the servlet. <br>
     *
     * This method is called when a form has its tag value method equals to get.
     * 
     * @param request the request send by the client to the server
     * @param response the response send by the server to the client
     * @throws ServletException if an error occurred
     * @throws IOException if an error occurred
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	doPost(request, response);
    }

    /**
     * The doPost method of the servlet. <br>
     *
     * This method is called when a form has its tag value method equals to post.
     * 
     * @param request the request send by the client to the server
     * @param response the response send by the server to the client
     * @throws ServletException if an error occurred
     * @throws IOException if an error occurred
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	List<Notice> companyNotices = noticeService.getLatestCompanyNotice();
	List<Notice> systemNotices = noticeService.getLatestSystemNotice();
	
	request.setAttribute("companyNotices", companyNotices);
	request.setAttribute("systemNotices", systemNotices);
	
	request.getRequestDispatcher("index.jsp").forward(request,
		response);
    }

    /**
     * Initialization of the servlet. <br>
     *
     * @throws ServletException if an error occurs
     */
    public void init() throws ServletException {
	super.init();
	noticeService = new NoticeService();
    }

}
