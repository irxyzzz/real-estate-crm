/**
 * 
 */
package com.crm.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crm.model.Employee;
import com.crm.service.IAssignmentService;
import com.crm.service.IEmployeeService;
import com.crm.service.impl.AssignmentService;
import com.crm.service.impl.EmployeeService;

/**
 * @author lenovo
 *
 */
public class AssignmentManageServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private IAssignmentService assignmentService;
    private IEmployeeService employeeService;

    /**
     * Destruction of the servlet. <br>
     */
    public void destroy() {
	super.destroy(); // Just puts "destroy" string in log
	assignmentService = null;
	employeeService = null;
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
	
	if (action.equals("show")) {	// 普通用户显示任务查血页面	  
	    SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
	    request.setAttribute("now", sdf.format(new Date()));	  
	    
	    request.getRequestDispatcher("assignment_show.jsp").forward(request, response);
	}
	else if (action.equals("showManage")) {		// 主管用户显示任务查血页面
	    List<Employee> employees = employeeService.getDepartmentEmployees(user.getEmployeeId());
	    SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
	    request.setAttribute("now", sdf.format(new Date()));
	    request.setAttribute("employees", employees);
	    
	    request.getRequestDispatcher("assignment_show_m.jsp").forward(request, response);
	}
	else if (action.equals("getEvent")) {	// 任务页面获取用户任务事件
	    String result = assignmentService.getJSONEmployeeAssignments(user.getEmployeeId());
	    System.out.println(result);
	    
	    response.setCharacterEncoding("utf-8");
	    response.getWriter().write(result);
	}
	else if (action.equals("addAssignment")) {
	    String title = request.getParameter("title");
	    String content = request.getParameter("content");
	    String beginTime = request.getParameter("beginTimeNew");
	    String endTime = request.getParameter("endTimeNew");
	    String participant = request.getParameter("partEmployee");
	    
	    boolean result = assignmentService.addAssignment(title, content, beginTime, endTime, participant);
	    if (result) {
		request.getRequestDispatcher("assignment.do?action=showManage").forward(request, response);
	    }
	    else {
		request.setAttribute("errorMsg", "添加任务失败");
		request.getRequestDispatcher("assignment.do?action=showManage").forward(request, response);
	    }
	    
	}
	else if (action.equals("modifyAssignment")) {	// 修改或删除操作
	    String assignmentId = request.getParameter("assignmentId");
	    String title = request.getParameter("title");
	    String content = request.getParameter("content");
	    String beginTime = request.getParameter("beginTime");
	    String endTime = request.getParameter("endTime");
	    String participant = request.getParameter("partEmployee");
	    String delete = request.getParameter("delete");
	    if (delete != null && delete.equals("on")) {
		boolean result = assignmentService.deleteAssignment(assignmentId);
		if (result) {
		    request.getRequestDispatcher("assignment.do?action=showManage").forward(request, response);
		}
		else {
		    request.setAttribute("errorMsg", "删除失败");
		    request.getRequestDispatcher("assignment.do?action=showManage").forward(request, response);
		}
	    }
	    else {
		boolean result = assignmentService.modifyAssignment(assignmentId, title, content, beginTime, endTime, participant);
		if (result) {
		    request.getRequestDispatcher("assignment.do?action=showManage").forward(request, response);
		}
		else {
		    request.setAttribute("errorMsg", "修改任务失败");
		    request.getRequestDispatcher("assignment.do?action=showManage").forward(request, response);
		}
	    }
	}
	else {
	    SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
	    request.setAttribute("now", sdf.format(new Date()));	  
	    request.setAttribute("errorMsg", "参数错误");
	    
	    request.getRequestDispatcher("assignment_show.jsp").forward(request, response);
	}
    }

    /**
     * Initialization of the servlet. <br>
     *
     * @throws ServletException if an error occurs
     */
    public void init() throws ServletException {
	super.init();
	assignmentService = new AssignmentService();
	employeeService = new EmployeeService();
    }

}
