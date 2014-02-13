/**
 * 
 */
package com.crm.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crm.model.Employee;
import com.crm.service.IPersonInfoService;
import com.crm.service.impl.PersonInfoService;

/**
 * @author lenovo
 * 
 */
public class PersonInfoModifyServlet extends HttpServlet {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private IPersonInfoService personInfoService;

    /**
     * Destruction of the servlet. <br>
     */
    public void destroy() {
	super.destroy(); // Just puts "destroy" string in log
	personInfoService = null;
    }

    /**
     * The doGet method of the servlet. <br>
     * 
     * This method is called when a form has its tag value method equals to get.
     * 
     * @param request
     *            the request send by the client to the server
     * @param response
     *            the response send by the server to the client
     * @throws ServletException
     *             if an error occurred
     * @throws IOException
     *             if an error occurred
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	doPost(request, response);
    }

    /**
     * The doPost method of the servlet. <br>
     * 
     * This method is called when a form has its tag value method equals to
     * post.
     * 
     * @param request
     *            the request send by the client to the server
     * @param response
     *            the response send by the server to the client
     * @throws ServletException
     *             if an error occurred
     * @throws IOException
     *             if an error occurred
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	request.setCharacterEncoding("utf-8");
	
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

	Employee user = (Employee) request.getSession().getAttribute(
		"currentUser");

	Employee result = personInfoService.modifyInfo(user.getEmployeeId(), name, gender, birthday, married,
		address, hobby, phone, email, department, post);
	
	if (result != null) {
	    request.getSession().setAttribute("currentUser", result);
	    request.getRequestDispatcher("person_info_show.jsp").forward(request, response);
	}
	else {
	    request.setAttribute("errorMsg", "修改个人信息失败");
	    request.getRequestDispatcher("person_info_modify.jsp").forward(request, response);
	}

    }

    /**
     * Initialization of the servlet. <br>
     * 
     * @throws ServletException
     *             if an error occurs
     */
    public void init() throws ServletException {
	super.init();
	personInfoService = new PersonInfoService();
    }

}
