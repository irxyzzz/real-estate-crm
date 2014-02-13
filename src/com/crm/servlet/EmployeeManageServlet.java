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
import com.crm.service.IEmployeeService;
import com.crm.service.impl.EmployeeService;

/**
 * @author lenovo
 *
 */
public class EmployeeManageServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private IEmployeeService employeeService;

    /**
     * Destruction of the servlet. <br>
     */
    public void destroy() {
	super.destroy(); // Just puts "destroy" string in log
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
	if (action != null) {
	    if (action.equals("show")) {	// 显示本部门所有的员工
		List<Employee> departmentEmployees = employeeService.getDepartmentEmployees(user.getEmployeeId());
		
		request.setAttribute("departmentEmployees", departmentEmployees);
		
		request.getRequestDispatcher("employee_show.jsp").forward(request, response);
	    }
	    else if (action.equals("addEmployee")) {
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String birthday = request.getParameter("birthday");
		String married = request.getParameter("married");
		String post = request.getParameter("post");
		String hobby = request.getParameter("hobby");
		
		boolean result = employeeService.addEmployee(user.getEmployeeId(), name, gender, phone, email, address, birthday, married, post, hobby);
		
		if(result) {
		    request.getRequestDispatcher("employeeManage.do?action=show").forward(request, response);
		}
		else {
		    request.setAttribute("errorMsg", "添加错误");
		    request.getRequestDispatcher("employeeManage.do?action=show").forward(request, response);
		}
	    }
	    else if (action.equals("showDetail")) {
		String id = request.getParameter("id");
		Employee employee = employeeService.getEmployee(id);
		
		if (employee != null) {
		    request.setAttribute("employeeDetail", employee);
		    request.getRequestDispatcher("employee_detail.jsp").forward(request, response); 
		}
		else {
		    request.setAttribute("errorMsg", "查询详细信息失败");
		    request.getRequestDispatcher("employeeManage.do?action=show").forward(request, response);
		}
	    }
	    else if (action.equals("prepareModify")){
		String id = request.getParameter("id");
				
		Employee employee = employeeService.getEmployee(id);
		
		if (employee != null) {
		    request.setAttribute("employeeDetail", employee);
		    request.getRequestDispatcher("employee_modify.jsp").forward(request, response); 
		}
		else {
		    request.setAttribute("errorMsg", "员工信息获取失败");
		    request.getRequestDispatcher("employeeManage.do?action=show").forward(request, response);
		}
	    }
	    else if (action.equals("modify")) {
		String employeeId = request.getParameter("employeeId");
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String birthday = request.getParameter("birthday");
		String married = request.getParameter("married");
		String address = request.getParameter("address");
		String hobby = request.getParameter("hobby");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String department = request.getParameter("department");
		String post = request.getParameter("post");
		
		boolean result = employeeService.modifyEmployee(employeeId, name, gender, birthday, married, address, hobby, phone, email, department, post);
		if (result) {
		    request.getRequestDispatcher("employeeManage.do?action=show").forward(request, response);
		}
		else {
		    request.setAttribute("errorMsg", "修改失败");
		    request.getRequestDispatcher("employeeManage.do?action=show").forward(request, response);
		}
		
	    }
	    else if (action.equals("delete")) {
		String id = request.getParameter("id");
		
		boolean result = employeeService.deleteEmployee(id);
		if (result) {
		    request.getRequestDispatcher("employeeManage.do?action=show").forward(request, response);
		}
		else {
		    request.setAttribute("errorMsg", "删除失败");
		    request.getRequestDispatcher("employeeManage.do?action=show").forward(request, response);
		}
		
	    }
	    else if (action.equals("adminEmployeeShow")) {
		List<Employee> employees = employeeService.getAllEmployees();
		List<Employee> managers = employeeService.getAllManagers();
		request.setAttribute("employees", employees);
		request.setAttribute("managers", managers);
		
		request.getRequestDispatcher("admin_employee_show.jsp").forward(request, response);
		
	    }
	    else if (action.equals("adminShowDetail")) {
		String id = request.getParameter("id");
		Employee employee = employeeService.getEmployee(id);
		
		if (employee != null) {
		    request.setAttribute("employeeDetail", employee);
		    request.getRequestDispatcher("admin_employee_detail.jsp").forward(request, response); 
		}
		else {
		    request.setAttribute("errorMsg", "查询详细信息失败");
		    request.getRequestDispatcher("employeeManage.do?action=adminEmployeeShow").forward(request, response);
		}
	    }
	    else if (action.equals("adminDelete")) {
		String id = request.getParameter("id");
		
		boolean result = employeeService.deleteEmployee(id);
		if (result) {
		    request.getRequestDispatcher("employeeManage.do?action=adminEmployeeShow").forward(request, response);
		}
		else {
		    request.setAttribute("errorMsg", "删除失败");
		    request.getRequestDispatcher("employeeManage.do?action=adminEmployeeShow").forward(request, response);
		}
	    }
	    else if (action.equals("adminPrepareModify")) {
		String id = request.getParameter("id");
		
		Employee employee = employeeService.getEmployee(id);
		
		if (employee != null) {
		    request.setAttribute("employeeDetail", employee);
		    request.getRequestDispatcher("admin_employee_modify.jsp").forward(request, response); 
		}
		else {
		    request.setAttribute("errorMsg", "员工信息获取失败");
		    request.getRequestDispatcher("employeeManage.do?action=adminEmployeeShow").forward(request, response);
		}
	    }
	    else if (action.equals("preAdminAddCustomer")) {
		request.getRequestDispatcher("admin_employee_add.jsp").forward(request, response);
	    }
	    else if (action.equals("adminModify")) {
		String employeeId = request.getParameter("employeeId");
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String birthday = request.getParameter("birthday");
		String married = request.getParameter("married");
		String address = request.getParameter("address");
		String hobby = request.getParameter("hobby");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String department = request.getParameter("department");
		String post = request.getParameter("post");
		String password = request.getParameter("password");
		String isManager = request.getParameter("isManager");
		
		boolean result = employeeService.adminModifyEmployee(employeeId, name, gender, birthday, married, address, hobby, phone, email, department, post, password, isManager);
		if (result) {
		    request.getRequestDispatcher("employeeManage.do?action=adminEmployeeShow").forward(request, response);
		}
		else {
		    request.setAttribute("errorMsg", "修改失败");
		    request.getRequestDispatcher("employeeManage.do?action=adminEmployeeShow").forward(request, response);
		}
		
	    }
	    else if (action.equals("adminAdd")) {
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String birthday = request.getParameter("birthday");
		String married = request.getParameter("married");
		String post = request.getParameter("post");
		String hobby = request.getParameter("hobby");
		String department = request.getParameter("department");
		String isManager = request.getParameter("isManager");
		
		boolean result = employeeService.adminAddEmployee(name, gender, phone, email, address, birthday, married, post, hobby, department, isManager);
		if(result) {
		    request.getRequestDispatcher("employeeManage.do?action=adminEmployeeShow").forward(request, response);
		}
		else {
		    request.setAttribute("errorMsg", "添加错误");
		    request.getRequestDispatcher("employeeManage.do?action=adminEmployeeShow").forward(request, response);
		}
	    }
	    else {
		request.setAttribute("errorMsg", "action参数错误");
		request.getRequestDispatcher("employeeManage.do?action=show").forward(request, response);
	    }
	}
	else {
	    request.setAttribute("errorMsg", "没有Action请求参数");
	    request.getRequestDispatcher("employeeManage.do?action=show").forward(request, response);
	}
	
    }

    /**
     * Initialization of the servlet. <br>
     *
     * @throws ServletException if an error occurs
     */
    public void init() throws ServletException {
	super.init();
	employeeService = new EmployeeService();
    }

}
