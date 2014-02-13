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

import com.crm.model.Customer;
import com.crm.model.Employee;
import com.crm.model.House;
import com.crm.model.ResidenceCommunity;
import com.crm.service.ICustomerService;
import com.crm.service.IEmployeeService;
import com.crm.service.IHouseService;
import com.crm.service.IResidenceCommunityService;
import com.crm.service.impl.CustomerService;
import com.crm.service.impl.EmployeeService;
import com.crm.service.impl.HouseService;
import com.crm.service.impl.ResidenceCommunityService;

/**
 * @author lenovo
 *
 */
public class HouseManageServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private IHouseService houseService;
    private IResidenceCommunityService residenceCommunityService;
    private ICustomerService customerService;
    private IEmployeeService employeeService;

    /**
     * Destruction of the servlet. <br>
     */
    public void destroy() {
	super.destroy(); // Just puts "destroy" string in log
	houseService = null;
	residenceCommunityService = null;
	customerService = null;
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
	request.setCharacterEncoding("UTF-8");
	
	Employee user = (Employee) request.getSession().getAttribute("currentUser");
	
	String action = request.getParameter("action");
	if (action != null) {
	    if (action.equals("showall")) {	// 显示所有房屋信息的请求
		
		List<House> houses = houseService.getAllHouseByEmployee(user.getEmployeeId());
		request.setAttribute("houses", houses);
		List<ResidenceCommunity> rcs = residenceCommunityService.getAllOwnResidenceCommunities();
		request.setAttribute("ownResidence", rcs);
		
		request.getRequestDispatcher("house_manage.jsp").forward(request, response);
	    }
	    else if (action.equals("manageShowAll")) {
		
		List<House> houses = houseService.getAllHouseByEmployee(user.getEmployeeId());
		request.setAttribute("houses", houses);
		
		request.getRequestDispatcher("house_manage_m.jsp").forward(request, response);
	    }
	    else if (action.equals("add")) {	
		String residenceId = request.getParameter("residence");
		String position = request.getParameter("position");
		String area = request.getParameter("area");
		String price = request.getParameter("price");
		
		boolean result = houseService.addNewHouseInfo(user.getEmployeeId(), residenceId, position, area, price);
		
		if (result) {
		    request.getRequestDispatcher("houseManage.do?action=showall").forward(request, response);
		}
		else {
		    request.setAttribute("errorMsg", "未添加成功");
		    request.getRequestDispatcher("houseManage.do?action=showall").forward(request, response);
		}
	    }
	    else if (action.equals("prepareModify")) {
		String stringId = request.getParameter("id");
		String strCustomerId = request.getParameter("customerId");
		House house = houseService.getHouse(stringId);
		Customer customer = customerService.getCustomer(strCustomerId);
		List<Customer> employeeCustomers = employeeService.getEmployeeCustomers(user.getEmployeeId());
		List<House> houses = houseService.getAllHouseByEmployee(user.getEmployeeId());
		
		if (house != null) {
		    List<ResidenceCommunity> rcs = residenceCommunityService.getAllOwnResidenceCommunities();
		    request.setAttribute("ownResidence", rcs);
		    request.setAttribute("house", house);
		    request.setAttribute("customer", customer);
		    request.setAttribute("employeeCustomers", employeeCustomers);
		    request.setAttribute("houses", houses);
		    
		    request.getRequestDispatcher("house_modify.jsp").forward(request, response);
		}
		else {
		    request.setAttribute("errorMsg", "参数错误");
		    request.getRequestDispatcher("houseManage.do?action=showall").forward(request, response);
		}
	    }
	    else if (action.equals("delete")) {
		String stringId = request.getParameter("id");
		boolean result = houseService.deleteHouse(stringId);
		if (result) {
		    request.getRequestDispatcher("houseManage.do?action=showall").forward(request, response);
		}
		else {
		    request.setAttribute("errorMsg", "删除错误");
		    request.getRequestDispatcher("houseManage.do?action=showall").forward(request, response);
		}
	    }
	    else if (action.equals("modify")) {
		String houseId = request.getParameter("houseId");
		String residence = request.getParameter("residence");
		String position = request.getParameter("position");
		String price = request.getParameter("price");
		String area = request.getParameter("area");
		String isSale = request.getParameter("isSale");
		String saleCustomer = request.getParameter("saleCustomer");
		
		boolean result = houseService.modifyHouseInfo(houseId, residence, position, area, price, isSale, saleCustomer);
		if (result) {
		    request.getRequestDispatcher("houseManage.do?action=showall").forward(request, response);
		}
		else {
		    request.setAttribute("errorMsg", "未修改成功");
		    request.getRequestDispatcher("houseManage.do?action=showall").forward(request, response);
		}
	    }
	    else {
		request.setAttribute("errorMsg", "非法的请求参数");
		request.getRequestDispatcher("houseManage.do?action=showall").forward(request, response);
	    }
	}
	else {
	    request.setAttribute("errorMsg", "系统错误，请求格式非法");
	    request.getRequestDispatcher("houseManage.do?action=showall").forward(request, response);
	}
	
    }

    /**
     * Initialization of the servlet. <br>
     *
     * @throws ServletException if an error occurs
     */
    public void init() throws ServletException {
	super.init();
	houseService = new HouseService();
	residenceCommunityService = new ResidenceCommunityService();
	customerService = new CustomerService();
	employeeService = new EmployeeService();
    }

}
