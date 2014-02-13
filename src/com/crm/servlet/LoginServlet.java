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
import com.crm.service.ILoginService;
import com.crm.service.impl.LoginService;

/**
 * @author lenovo
 * 
 */
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private ILoginService loginService;

    /**
     * Initialization of the servlet. <br>
     * 
     * @throws ServletException
     *             if an error occurs
     */
    public void init() throws ServletException {
	super.init();
	loginService = new LoginService();
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
	String account = request.getParameter("account");
	String password = request.getParameter("password");
	String isAdmin = request.getParameter("isAdmin");

	if (isAdmin != null && isAdmin.equals("on")) {
	    String adminName = getInitParameter("adminName");
	    String adminPass = getInitParameter("adminPassword");
	    
	    if (account.equals(adminName) && password.equals(adminPass)) {
		request.getSession().setAttribute("admin", "admin");
		request.getRequestDispatcher("index_admin.jsp").forward(request, response);
	    }
	    else {
		request.setAttribute("errorMsg", "管理员用户名或密码错误，请重新登录");
		request.getRequestDispatcher("login.jsp").forward(request,
			response);
	    }
	} else {
	    Employee employee = loginService.validateUser(account, password);

	    if (employee != null) {
		request.getSession().setAttribute("currentUser", employee);
		request.getRequestDispatcher("menuDispatcher.do?contentURL=index.do").forward(request,
			response);
	    }
	    else {
		request.setAttribute("errorMsg", "用户名或密码错误，请重新登录");
		request.getRequestDispatcher("login.jsp").forward(request,
			response);
	    }
	}

    }

    /**
     * Destruction of the servlet. <br>
     */
    public void destroy() {
	super.destroy();
	loginService = null;
    }
}
