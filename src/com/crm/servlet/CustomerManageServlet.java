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

import com.crm.model.Customer;
import com.crm.model.CustomerCare;
import com.crm.model.CustomerFeedback;
import com.crm.model.CustomerSupport;
import com.crm.model.Employee;
import com.crm.model.House;
import com.crm.model.RepairRecord;
import com.crm.service.ICustomerService;
import com.crm.service.IEmployeeService;
import com.crm.service.IHouseService;
import com.crm.service.impl.CustomerService;
import com.crm.service.impl.EmployeeService;
import com.crm.service.impl.HouseService;

/**
 * @author lenovo
 *
 */
public class CustomerManageServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private ICustomerService customerService;
    private IEmployeeService employeeService;
    private IHouseService houseService;

    /**
     * Destruction of the servlet. <br>
     */
    public void destroy() {
	super.destroy(); // Just puts "destroy" string in log
	customerService = null;
	employeeService = null;
	houseService = null;
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
	    if (action.equals("showall")) {	// show all customer info.
		List<Customer> intentCustomer = customerService.getIntentCustomers(user.getEmployeeId());
		List<Customer> alreadyCustomer = customerService.getAlreadyCustomers(user.getEmployeeId());
		request.setAttribute("intentCustomer", intentCustomer);
		request.setAttribute("alreadyCustomer", alreadyCustomer);
		
		request.getRequestDispatcher("customer_show.jsp").forward(request, response);
	    }
	    else if (action.equals("preAddCustomer")) {
		Employee saleEmployee = employeeService.getRandomSaleEmployee();
		Employee serviceEmployee = employeeService.getRandomServiceEmployee();
		request.setAttribute("saleEmployee", saleEmployee);
		request.setAttribute("serviceEmployee", serviceEmployee);
		
		request.getRequestDispatcher("customer_add.jsp").forward(request, response);
	    }
	    else if (action.equals("addCustomer")) {
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String birthday = request.getParameter("birthday");
		String address = request.getParameter("address");
		String married = request.getParameter("married");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String intent = request.getParameter("intent");
		String income = request.getParameter("income");
		String job = request.getParameter("job");
		String hobby = request.getParameter("hobby");
		String saleEmployeeId = request.getParameter("saleEmployeeId");
		String serviceEmployeeId = request.getParameter("serviceEmployeeId");
		
		boolean result = customerService.addCustomer(user.getEmployeeId(), name, gender, birthday, address, married, phone, email, intent, income, job, hobby, saleEmployeeId, serviceEmployeeId);
		if (result) {
		    request.getRequestDispatcher("customerManage.do?action=showall").forward(request, response);
		}
		else {
		    request.setAttribute("errorMsg", "添加客户失败");
		    request.getRequestDispatcher("customerManage.do?action=showall").forward(request, response);
		}
		
		
	    }
	    else if (action.equals("preModify")) {
		String id = request.getParameter("id");
		Customer customer = customerService.getCustomer(id);
		if(customer != null) {
		    request.setAttribute("customer", customer);
		    request.getRequestDispatcher("customer_modify.jsp").forward(request, response);
		}
		else {
		    request.setAttribute("errorMsg", "操作失败");
		    request.getRequestDispatcher("customerManage.do?action=showall").forward(request, response);
		}
		
	    }
	    else if (action.equals("modifyCustomer")) {
		String id = request.getParameter("customerId");
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String birthday = request.getParameter("birthday");
		String address = request.getParameter("address");
		String married = request.getParameter("married");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String intent = request.getParameter("intent");
		String income = request.getParameter("income");
		String job = request.getParameter("job");
		String hobby = request.getParameter("hobby");
		
		boolean result = customerService.modifyCustomer(user.getEmployeeId(), id, name, gender, birthday, address, married, phone, email, intent, income, job, hobby);
		if (result) {
		    request.getRequestDispatcher("customerManage.do?action=showall").forward(request, response);
		}
		else {
		    request.setAttribute("errorMsg", "修改客户失败");
		    request.getRequestDispatcher("customerManage.do?action=showall").forward(request, response);
		}
		
	    }
	    else if (action.equals("preBuy")) {
		String id = request.getParameter("id");
		Customer customer = customerService.getCustomer(id);
		List<House> houses = houseService.getAllHouseByEmployee(user.getEmployeeId());
		if(customer != null) {
		    request.setAttribute("customer", customer);
		    request.setAttribute("houses", houses);
		    request.getRequestDispatcher("customer_buy.jsp").forward(request, response);
		}
		else {
		    request.setAttribute("errorMsg", "操作失败");
		    request.getRequestDispatcher("customerManage.do?action=showall").forward(request, response);
		}
		
	    }
	    else if (action.equals("customerBuy")) {
		String customerId = request.getParameter("customerId");
		String houseId = request.getParameter("houseId");
		
		boolean result = customerService.buyHouse(customerId, houseId);
		if (result) {
		    request.getRequestDispatcher("customerManage.do?action=showall").forward(request, response);
		}
		else {
		    request.setAttribute("errorMsg", "操作失败");
		    request.getRequestDispatcher("customerManage.do?action=showall").forward(request, response);
		}
		
	    }
	    else if (action.equals("deleteCustomer")) {
		String id = request.getParameter("id");
		boolean result = customerService.deleteCustomer(id);
		if (result) {
		    request.getRequestDispatcher("customerManage.do?action=showall").forward(request, response);
		}
		else {
		    request.setAttribute("errorMsg", "操作失败");
		    request.getRequestDispatcher("customerManage.do?action=showall").forward(request, response);
		}
	    }
	    else if (action.equals("contact")) {	// 显示当前员工的所有联系记录
		List<CustomerSupport> css = customerService.getCustomerSupports(user.getEmployeeId());
		List<Customer> myCustomers = employeeService.getEmployeeCustomers(user.getEmployeeId());
		request.setAttribute("css", css);
		request.setAttribute("myCustomers", myCustomers);
		
		request.getRequestDispatcher("customer_contact.jsp").forward(request, response);
	    }
	    else if (action.equals("showAllContact")) {		// 显示所有的联系记录
		List<CustomerSupport> css = customerService.getCustomerSupports(user.getEmployeeId());
		List<Customer> myCustomers = employeeService.getEmployeeCustomers(user.getEmployeeId());
		request.setAttribute("css", css);
		request.setAttribute("myCustomers", myCustomers);
		
		request.getRequestDispatcher("customer_contact_m.jsp").forward(request, response);
	    }
	    else if (action.equals("addContact")) {	// 添加一条联系记录
		String customerId = request.getParameter("customerId");
		String content = request.getParameter("content");
		String reply = request.getParameter("reply");
		
		boolean result = customerService.addCustomerSupport(user.getEmployeeId(), customerId, content, reply);
		if (result) {
		    if (employeeService.isManger(user.getEmployeeId())) {
			request.getRequestDispatcher("customerManage.do?action=showAllContact").forward(request, response);
		    }
		    else {
			request.getRequestDispatcher("customerManage.do?action=contact").forward(request, response);
		    }
		    
		}
		else {
		    if (employeeService.isManger(user.getEmployeeId())) {
			request.setAttribute("errorMsg", "添加失败");
			request.getRequestDispatcher("customerManage.do?action=showAllContact").forward(request, response);
		    }
		    else {
			request.setAttribute("errorMsg", "添加失败");
			request.getRequestDispatcher("customerManage.do?action=contact").forward(request, response);
		    }
		    
		}
	    }
	    else if (action.equals("delContact")) {	// 删除一条联系记录
		String contactId = request.getParameter("id");
		
		boolean result = customerService.deleteCustomerSupport(contactId);
		if(result) {
		    if (employeeService.isManger(user.getEmployeeId())) {
			request.getRequestDispatcher("customerManage.do?action=showAllContact").forward(request, response);
		    }
		    else {
			request.getRequestDispatcher("customerManage.do?action=contact").forward(request, response);
		    }
		}
		else {
		    if (employeeService.isManger(user.getEmployeeId())) {
			request.setAttribute("errorMsg", "删除错误");
			request.getRequestDispatcher("customerManage.do?action=showAllContact").forward(request, response);
		    }
		    else {
			request.setAttribute("errorMsg", "删除错误");
			request.getRequestDispatcher("customerManage.do?action=contact").forward(request, response);
		    }
		}
	    }
	    else if (action.equals("care")) {		// 显示客户关怀计划
		List<CustomerCare> ccs = customerService.getCustomerCares();
		request.setAttribute("customerCares", ccs);
		
		request.getRequestDispatcher("customer_care.jsp").forward(request, response);
	    }
	    else if (action.equals("careManage")) {	// 主管页面显示客户关怀计划
		List<CustomerCare> ccs = customerService.getCustomerCares();
		request.setAttribute("customerCares", ccs);
		
		request.getRequestDispatcher("customer_care_m.jsp").forward(request, response);
	    }
	    else if (action.equals("addCare")) {	// 添加客户关怀计划
		String title = request.getParameter("title");
		String description = request.getParameter("description");
		String activeTime = request.getParameter("activeTime");
		String activeForm = request.getParameter("activeForm");
		String customerType = request.getParameter("customerType");
		
		boolean result = customerService.addCustomerCare(title, description, activeTime, activeForm, customerType);
		if (result) {
		    request.getRequestDispatcher("customerManage.do?action=careManage").forward(request, response);
		}
		else {
		    request.setAttribute("errorMsg", "添加失败");
		    request.getRequestDispatcher("customerManage.do?action=careManage").forward(request, response);
		}
		
	    }
	    else if (action.equals("delCare")) {	// 删除客户关怀计划
		String careId = request.getParameter("id");
		
		boolean result = customerService.delCustomerCare(careId);
		if (result) {
		    request.getRequestDispatcher("customerManage.do?action=careManage").forward(request, response);
		}
		else {
		    request.setAttribute("errorMsg", "删除失败");
		    request.getRequestDispatcher("customerManage.do?action=careManage").forward(request, response);
		}
	    }
	    else if (action.equals("fix")) {
		List<RepairRecord> rrs = customerService.getRepairRecords(user.getEmployeeId());
		request.setAttribute("repairRecords", rrs);
		
		request.getRequestDispatcher("customer_repair.jsp").forward(request, response);
	    }
	    else if (action.equals("manageFix")) {
		
		List<RepairRecord> rrs1 = customerService.getUnverifyRepairRecords(user.getEmployeeId());
		List<RepairRecord> rrs2 = customerService.getVerifyRepairRecords(user.getEmployeeId());
		request.setAttribute("unverifyRepairRecords", rrs1);
		request.setAttribute("verifyRepairRecords", rrs2);
		
		request.getRequestDispatcher("customer_repair_m.jsp").forward(request, response);
	    }
	    else if (action.equals("deleteRepair")) {
		String repairId = request.getParameter("id");
		boolean result = customerService.deleteRepairRecord(repairId);
		if (result) {
		    request.getRequestDispatcher("customerManage.do?action=fix").forward(request, response);
		}
		else {
		    request.setAttribute("errorMsg", "删除失败");
		    request.getRequestDispatcher("customerManage.do?action=fix").forward(request, response);
		}
	    }
	    else if (action.equals("preAddRepairRecord")) {
		List<Customer> customers = customerService.getAlreadyCustomers(user.getEmployeeId());
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		request.setAttribute("beginTime", sdf.format(new Date()));
		request.setAttribute("defaultEndTime", sdf.format(new Date(new Date().getTime() + 3*24*3600*1000)));
		request.setAttribute("alreadyCustomers", customers);
		
		request.getRequestDispatcher("customer_repair_add.jsp").forward(request, response);
	    }
	    else if (action.equals("addRepairRecord")){
		String customerId = request.getParameter("customerId");
		String description = request.getParameter("description");
		String handle = request.getParameter("handle");
		String endTime = request.getParameter("endTime");
		
		boolean result = customerService.addRepairRecord(user.getEmployeeId(), customerId, description, handle, endTime);
		if (result) {
		    request.getRequestDispatcher("customerManage.do?action=fix").forward(request, response);
		}
		else {
		    request.setAttribute("errorMsg", "添加报修失败");
		    request.getRequestDispatcher("customerManage.do?action=fix").forward(request, response);
		}
	    }
	    else if (action.equals("preVerify")) {
		String id = request.getParameter("id");
		RepairRecord rr = customerService.getRepairRecord(id);
		if (rr != null) {
		    request.setAttribute("repairRecord", rr);
		    request.getRequestDispatcher("customer_repair_verify.jsp").forward(request, response);
		}
		else {
		    request.setAttribute("errorMsg", "参数错误");
		    request.getRequestDispatcher("customerManage.do?action=manageFix").forward(request, response);
		}
		
	    }
	    else if (action.equals("verify")) {
		String id = request.getParameter("id");
		String verify = request.getParameter("verify");
		String newHandle = request.getParameter("newHandle");
		
		boolean result = customerService.verifyRepairRecord(id, verify, newHandle);
		if (result) {
		    request.getRequestDispatcher("customerManage.do?action=manageFix").forward(request, response);
		}
		else {
		    request.setAttribute("errorMsg", "审核失败");
		    request.getRequestDispatcher("customerManage.do?action=manageFix").forward(request, response);
		}
		
	    }
	    else if (action.equals("feedback")) {
		List<CustomerFeedback> cfs = customerService.getCustomerFeedback();
		request.setAttribute("customerFeedbacks", cfs);
		
		request.getRequestDispatcher("customer_feedback.jsp").forward(request, response);
	    }
	    else if (action.equals("manageFeedback")) {
		List<CustomerFeedback> cfs = customerService.getCustomerFeedback();
		request.setAttribute("customerFeedbacks", cfs);
		
		request.getRequestDispatcher("customer_feedback_m.jsp").forward(request, response);
	    }
	    else if (action.equals("preAddFeedback")) {
		List<Customer> customers = customerService.getAlreadyCustomers(user.getEmployeeId());
		List<Employee> employees = employeeService.getSaleEmployees(); 
		request.setAttribute("customers", customers);
		request.setAttribute("employees", employees);
		request.getRequestDispatcher("customer_feedback_add.jsp").forward(request, response);
	    }
	    else if (action.equals("addFeedback")){
		String customerId = request.getParameter("customerId");
		String employeeId = request.getParameter("employeeId");
		String markforSellerStr = request.getParameter("MarkforSeller");
		String markForEnvironmentStr = request.getParameter("MarkForEnvironment");
		String markForTenementStr = request.getParameter("MarkForTenement");
		String markForTrafficStr = request.getParameter("MarkForTraffic");
		String totalMarkStr = request.getParameter("TotalMark");
		String advice = request.getParameter("Advice");
		
		boolean result = customerService.addCustomerFeedback(customerId, employeeId, markforSellerStr, markForEnvironmentStr, markForTenementStr, markForTrafficStr, totalMarkStr, advice);
		if (result) {
		    request.getRequestDispatcher("customerManage.do?action=feedback").forward(request, response);
		}
		else {
		    request.setAttribute("errorMsg", "添加失败");
		    request.getRequestDispatcher("customerManage.do?action=feedback").forward(request, response);
		}
		
	    }
	    else if (action.equals("deleteFeedback")) {
		String id = request.getParameter("id");
		
		boolean result = customerService.deleteCustomerFeedback(id);
		if (result) {
		    request.getRequestDispatcher("customerManage.do?action=feedback").forward(request, response);
		}
		else {
		    request.setAttribute("errorMsg", "删除失败");
		    request.getRequestDispatcher("customerManage.do?action=feedback").forward(request, response);
		}
		
	    }
	    else {
		request.setAttribute("errorMsg", "参数错误");
		request.getRequestDispatcher("customerManage.do?action=showall").forward(request, response);
	    }
	}
	
    }

    /**
     * Initialization of the servlet. <br>
     *
     * @throws ServletException if an error occurs
     */
    public void init() throws ServletException {
	super.init();
	customerService = new CustomerService();
	employeeService = new EmployeeService();
	houseService = new HouseService();
    }

}
