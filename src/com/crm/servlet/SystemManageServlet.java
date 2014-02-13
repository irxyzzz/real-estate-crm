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

import com.crm.model.Employee;
import com.crm.model.Notice;
import com.crm.service.ISystemService;
import com.crm.service.impl.SystemService;

/**
 * @author lenovo
 *
 */
public class SystemManageServlet extends HttpServlet {
    
    private static final long serialVersionUID = 1L;
    private ISystemService systemService;
    
    /**
     * Destruction of the servlet. <br>
     */
    public void destroy() {
	super.destroy(); // Just puts "destroy" string in log
	systemService = null;
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
	request.setCharacterEncoding("utf-8");
	Employee user = (Employee) request.getSession().getAttribute("currentUser");
	String action = request.getParameter("action");
	if (action != null) {
	    if (action.equals("showSysNotice")) {
		List<Notice> sysNotice = systemService.getSystemNotices();
		List<Notice> manNotice = systemService.getManagerNotices();
		request.setAttribute("sysNotice", sysNotice);
		request.setAttribute("manNotice", manNotice);
		
		request.getRequestDispatcher("admin_notice_show.jsp").forward(request, response);
	    }
	    else if (action.equals("del")) {
		String id = request.getParameter("id");
		
		boolean result = systemService.deleteNotice(id);
		if (result) {
		    
		    request.getRequestDispatcher("systemManage.do?action=showSysNotice").forward(request, response);
		}
		else {
		    request.setAttribute("errorMsg", "删除通知失败");
		    request.getRequestDispatcher("systemManage.do?action=showSysNotice").forward(request, response);
		}
	    }
	    else if (action.equals("add")) {
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		boolean result = systemService.addSystemNotice(title, content);
		if (result) {
		    
		    request.getRequestDispatcher("systemManage.do?action=showSysNotice").forward(request, response);
		}
		else {
		    request.setAttribute("errorMsg", "添加通知失败");
		    request.getRequestDispatcher("systemManage.do?action=showSysNotice").forward(request, response);
		}
	    }
	    else if (action.equals("noticeAdd")) {
		request.getRequestDispatcher("notice_add.jsp").forward(request, response);
	    }
	    else if (action.equals("managerNoticeAdd")) {
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		boolean result = systemService.addCompanyNotice(user.getEmployeeId(), title, content);
		if (result) {
		    
		    request.getRequestDispatcher("index.do").forward(request, response);
		}
		else {
		    request.setAttribute("errorMsg", "添加通知失败");
		    request.getRequestDispatcher("index.do").forward(request, response);
		}
	    }
	    else if (action.equals("delSysNotice")) {
		String id = request.getParameter("id");
		
		boolean result = systemService.deleteNotice(id);
		if (result) {    
		    request.getRequestDispatcher("index.do").forward(request, response);
		}
		else {
		    request.setAttribute("errorMsg", "删除通知失败");
		    request.getRequestDispatcher("index.do").forward(request, response);
		}
	    }
	    else if (action.equals("delManNotice")) {
		String id = request.getParameter("id");
		String name = new String(request.getParameter("name").getBytes("iso8859-1"),"UTF-8");;
		String currentname = user.getName();
		if (name!= null && name.trim().equals(currentname)) {
		    boolean result = systemService.deleteNotice(id);
		    if (result) {    
			request.getRequestDispatcher("index.do").forward(request, response);
		    }
		    else {
			request.setAttribute("errorMsg", "删除通知失败");
			request.getRequestDispatcher("index.do").forward(request, response);
		    }
		}
		else {
		    request.getRequestDispatcher("index.do").forward(request, response);
		}

	    }
	    else {
		request.setAttribute("errorMsg", "action参数错误");
		request.getRequestDispatcher("systemManage.do?action=showSysNotice").forward(request, response);
	    }
	}
	else {
	    request.setAttribute("errorMsg", "无action参数");		
	    request.getRequestDispatcher("systemManage.do?action=showSysNotice").forward(request, response);
	}
    }

    /**
     * Initialization of the servlet. <br>
     *
     * @throws ServletException if an error occurs
     */
    public void init() throws ServletException {
	super.init();
	systemService = new SystemService();
    }

}
