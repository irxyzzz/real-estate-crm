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
public class PersonInfoPasswordServlet extends HttpServlet {
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
	String oldPassword = request.getParameter("oldPassword");
	String newPassword = request.getParameter("newPassword");
	String passwordConfirm = request.getParameter("passwordConfirm");
	Employee user = (Employee) request.getSession().getAttribute("currentUser");
	Employee e = personInfoService.modifyPassword(user.getEmployeeId(), oldPassword, newPassword, passwordConfirm);
	if (e != null) {
	    request.getSession().setAttribute("currentUser", e);
	    request.getRequestDispatcher("person_info_show.jsp").forward(request, response);
	}
	else {
	    request.setAttribute("errorMsg", "修改失败");
	    request.getRequestDispatcher("person_info_password.jsp").forward(request, response);
	}
    }

    /**
     * Initialization of the servlet. <br>
     *
     * @throws ServletException if an error occurs
     */
    public void init() throws ServletException {
	super.init();
	personInfoService = new PersonInfoService();
    }

}
