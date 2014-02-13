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
import com.crm.service.IAnalysisService;
import com.crm.service.impl.AnalysisService;

/**
 * @author lenovo
 *
 */
public class AnalysisManageServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private IAnalysisService analysisService;

    /**
     * Destruction of the servlet. <br>
     */
    public void destroy() {
	super.destroy(); // Just puts "destroy" string in log
	analysisService = null;
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
	    if (action.equals("customerAll")) {
		String gender = analysisService.showCustomerCountsByGender(user.getEmployeeId());
		request.setAttribute("gender", gender);
		String age = analysisService.showCustomerCountsByAge();
		request.setAttribute("age", age);
		String marry = analysisService.showCustomerCountsByMarry();
		request.setAttribute("marry", marry);
		String income = analysisService.showCustomerCountsByIncom();
		request.setAttribute("income", income);
		String job = analysisService.showCustomerCountsByJob();
		request.setAttribute("job", job);
		String hobby = analysisService.showCustomerCountsByHobby();
		request.setAttribute("hobby", hobby);
		request.getRequestDispatcher("chart_customer.jsp").forward(request, response);
	    }
	    else if (action.equals("houseAll")) {
		String month = analysisService.showHouseCountsByMonth();
		String area = analysisService.showHouseCountsByArea();
		String price = analysisService.showHouseCountsByPrice();
		request.setAttribute("month", month);
		request.setAttribute("area", area);
		request.setAttribute("price", price);
		
		request.getRequestDispatcher("chart_house.jsp").forward(request, response);
	    }
	    else if (action.equals("contactAll")) {
		String contact = analysisService.showContactCountsByLastMonth();
		request.setAttribute("contact", contact);
		
		request.getRequestDispatcher("chart_contact.jsp").forward(request, response);
	    }
	    else if (action.equals("fixAll")) {
		String fixMonth = analysisService.showFixCountsByMonth();
		String fixRC = analysisService.showFixCountsByResidence();
		request.setAttribute("fixMonth", fixMonth);
		request.setAttribute("fixRC", fixRC);
		
		request.getRequestDispatcher("chart_fix.jsp").forward(request, response);
	    }
	    else if (action.equals("feedbackAll")) {
		String all = analysisService.showValueAll();
		String environment = analysisService.showValueEmvironment();
		String indSale = analysisService.showValueIndiSale();
		String sale = analysisService.showValueSale();
		String tenement = analysisService.showValueTenement();
		String traffic = analysisService.showValueTraffic();
		request.setAttribute("all", all);
		request.setAttribute("environment", environment);
		request.setAttribute("indSale", indSale);
		request.setAttribute("sale", sale);
		request.setAttribute("tenement", tenement);
		request.setAttribute("traffic", traffic);
		
		request.getRequestDispatcher("chart_feedback.jsp").forward(request, response);
		
	    }
	    else {
		
	    }
	}
	else {
	    
	}
    }

    /**
     * Initialization of the servlet. <br>
     *
     * @throws ServletException if an error occurs
     */
    public void init() throws ServletException {
	super.init();
	analysisService = new AnalysisService();
    }

}
