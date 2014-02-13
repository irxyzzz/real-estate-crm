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

import com.crm.model.Company;
import com.crm.model.Competitor;
import com.crm.model.ResidenceCommunity;
import com.crm.service.ICompetitorService;
import com.crm.service.impl.CompetitorService;

/**
 * @author lenovo
 *
 */
public class CompetitorManageServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ICompetitorService competitorService;

    /**
     * Destruction of the servlet. <br>
     */
    public void destroy() {
	super.destroy(); // Just puts "destroy" string in log
	competitorService = null;
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
//	Employee user = (Employee) request.getSession().getAttribute("currentUser");
	String action = request.getParameter("action");
	
	if (action != null) {
	    if (action.equals("showall")) {
		List<Competitor> all = competitorService.getAllCompetitors();
		List<Company> competitorCompany = competitorService.getAllCompetiorCompany();
		List<ResidenceCommunity> rcs = competitorService.getAllCompetitorRC();
		request.setAttribute("allCompetitors", all);
		request.setAttribute("competitorResidence", rcs);
		request.setAttribute("competitorCompany", competitorCompany);
		
		request.getRequestDispatcher("competitor_info.jsp").forward(request, response);
	    }
	    else if (action.equals("addCompetitor")) {
		String company = request.getParameter("company");
		String residence = request.getParameter("residence");
		String marketStrategy = request.getParameter("marketStrategy");
		
		boolean result = competitorService.addCompetitor(company, residence, marketStrategy);
		
		if (result) {
		    request.getRequestDispatcher("competitorManage.do?action=showall").forward(request, response);
		}
		else {
		    request.setAttribute("errorMsg", "添加失败");
		    request.getRequestDispatcher("competitorManage.do?action=showall").forward(request, response);
		}
		
	    }
	    else if (action.equals("preModify")) {
		String id = request.getParameter("id");
		Competitor competitor = competitorService.getCompetitor(id);
		List<Company> competitorCompany = competitorService.getAllCompetiorCompany();
		List<ResidenceCommunity> rcs = competitorService.getAllCompetitorRC();
		
		if (competitor != null) {
		    request.setAttribute("competitorResidence", rcs);
		    request.setAttribute("competitorCompany", competitorCompany);
		    request.setAttribute("competitor", competitor);
		    request.getRequestDispatcher("competitor_modify.jsp").forward(request, response);
		}
		else {
		    request.setAttribute("errorMsg", "操作失败");
		    request.getRequestDispatcher("competitorManage.do?action=showall").forward(request, response);
		}
	    }
	    else if (action.equals("modify")) {
		String id = request.getParameter("id");
		String company = request.getParameter("company");
		String residence = request.getParameter("residence");
		String marketStrategy = request.getParameter("marketStrategy");
		
		boolean result = competitorService.modifyCompetitor(id, company, residence, marketStrategy);
		if (result) {
		    request.getRequestDispatcher("competitorManage.do?action=showall").forward(request, response);
		}
		else {
		    request.setAttribute("errorMsg", "修改失败");
		    request.getRequestDispatcher("competitorManage.do?action=showall").forward(request, response);
		}
	    }
	    else if (action.equals("delete")) {
		String id = request.getParameter("id");
		boolean result = competitorService.deleteCompetitor(id);
		if (result) {
		    request.getRequestDispatcher("competitorManage.do?action=showall").forward(request, response);
		}
		else {
		    request.setAttribute("errorMsg", "删除失败");
		    request.getRequestDispatcher("competitorManage.do?action=showall").forward(request, response);
		}
	    }
	    else if (action.equals("companyShow")) {
		List<Company> companies = competitorService.getAllCompetiorCompany();
		request.setAttribute("companies", companies);
		
		request.getRequestDispatcher("company_info.jsp").forward(request, response);
	    }
	    else if (action.equals("preAddCompany")) {
		
		request.getRequestDispatcher("company_add.jsp").forward(request, response);
	    }
	    else if (action.equals("addCompany")) {
		String name = request.getParameter("name");
		String corporation = request.getParameter("corporation");
		String recordTime = request.getParameter("recordTime");
		String address = request.getParameter("address");
		String type = request.getParameter("type");
		String homepage = request.getParameter("homepage");
		String phone = request.getParameter("phone");
		String post = request.getParameter("post");
		String history = request.getParameter("history");
		
		boolean result = competitorService.addCompany(name, corporation, recordTime, address, type, homepage, phone, post, history);
		if (result) {
		    request.getRequestDispatcher("competitorManage.do?action=companyShow").forward(request, response);
		}
		else {
		    request.setAttribute("errorMsg", "添加失败");
		    request.getRequestDispatcher("competitorManage.do?action=companyShow").forward(request, response);
		}
		
	    }
	    else if (action.equals("delCompany")) {
		String id = request.getParameter("id");
		boolean result = competitorService.deleteCompany(id);
		if (result) {
		    request.getRequestDispatcher("competitorManage.do?action=companyShow").forward(request, response);
		}
		else {
		    request.setAttribute("errorMsg", "删除失败");
		    request.getRequestDispatcher("competitorManage.do?action=companyShow").forward(request, response);
		}
	    }
	    else if (action.equals("detailCompany")) {
		String id = request.getParameter("id");
		Company company = competitorService.getCompany(id);
		if (company != null) {
		    request.setAttribute("company", company);
		    request.getRequestDispatcher("company_detail.jsp").forward(request, response);
		}
		else {
		    request.setAttribute("errorMsg", "操作失败");
		    request.getRequestDispatcher("competitorManage.do?action=companyShow").forward(request, response);
		}
	    }
	    else if (action.equals("preCompanyModify")) {
		String id = request.getParameter("id");
		Company company = competitorService.getCompany(id);
		if (company != null) {
		    request.setAttribute("company", company);
		    request.getRequestDispatcher("company_modify.jsp").forward(request, response);
		}
		else {
		    request.setAttribute("errorMsg", "操作失败");
		    request.getRequestDispatcher("competitorManage.do?action=companyShow").forward(request, response);
		}
		
	    }
	    else if (action.equals("modifyCompany")) {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String corporation = request.getParameter("corporation");
		String recordTime = request.getParameter("recordTime");
		String address = request.getParameter("address");
		String type = request.getParameter("type");
		String homepage = request.getParameter("homepage");
		String phone = request.getParameter("phone");
		String post = request.getParameter("post");
		String history = request.getParameter("history");
		
		boolean result = competitorService.modifyCompany(id, name, corporation, recordTime, address, type, homepage, phone, post, history);
		if (result) {
		    request.getRequestDispatcher("competitorManage.do?action=companyShow").forward(request, response);
		}
		else {
		    request.setAttribute("errorMsg", "修改失败");
		    request.getRequestDispatcher("competitorManage.do?action=companyShow").forward(request, response);
		}
	    }
	    else if (action.equals("residenceShow")) {
		List<ResidenceCommunity> residenceCommunities = competitorService.getResidenceCommunities();
		List<Company> companies = competitorService.getAllCompetiorCompany();
		request.setAttribute("residenceCommunities", residenceCommunities);
		request.setAttribute("companies", companies);
	    
		request.getRequestDispatcher("residence_info.jsp").forward(request, response);
	    }
	    else if (action.equals("preResidenceModify")) {
		String id = request.getParameter("id");
		ResidenceCommunity rc = competitorService.getResidenceCommunity(id);
		List<Company> companies = competitorService.getAllCompetiorCompany();
		
		if (rc != null) {
		    request.setAttribute("residence", rc);
		    request.setAttribute("companies", companies);
		    request.getRequestDispatcher("residence_modify.jsp").forward(request, response);
		}
		else {
		    request.setAttribute("errorMsg", "操作失败");
		    request.getRequestDispatcher("competitorManage.do?action=residenceShow").forward(request, response);
		}
	    }
	    else if (action.equals("delResidence")) {
		String id = request.getParameter("id");
		boolean result = competitorService.deleteResidence(id);
		if (result) {
		    request.getRequestDispatcher("competitorManage.do?action=residenceShow").forward(request, response);
		}
		else {
		    request.setAttribute("errorMsg", "删除失败");
		    request.getRequestDispatcher("competitorManage.do?action=residenceShow").forward(request, response);
		}
	    }
	    else if (action.equals("addResidence")) {
		String name = request.getParameter("name");
		String area = request.getParameter("area");
		String type = request.getParameter("type");
		String address = request.getParameter("address");
		String company = request.getParameter("company");
		String description = request.getParameter("description");
		
		boolean result = competitorService.addResidence(name, area, type, address, company, description);
		if (result) {
		    request.getRequestDispatcher("competitorManage.do?action=residenceShow").forward(request, response);
		}
		else {
		    request.setAttribute("errorMsg", "添加失败");
		    request.getRequestDispatcher("competitorManage.do?action=residenceShow").forward(request, response);
		}
		
	    }
	    else if (action.equals("modifyResidence")) {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String area = request.getParameter("area");
		String type = request.getParameter("type");
		String address = request.getParameter("address");
		String company = request.getParameter("company");
		String description = request.getParameter("description");
		
		boolean result = competitorService.modifyResidence(id, name, area, type, address, company, description);
		if (result) {
		    request.getRequestDispatcher("competitorManage.do?action=residenceShow").forward(request, response);
		}
		else {
		    request.setAttribute("errorMsg", "修改失败");
		    request.getRequestDispatcher("competitorManage.do?action=residenceShow").forward(request, response);
		}
	    }
	    else {
		request.setAttribute("errorMsg", "Action请求参数错误");
		request.getRequestDispatcher("competitorManage.do?action=showall").forward(request, response);
	    }
	}
	else {
	    request.setAttribute("errorMsg", "无Action请求参数");
	    request.getRequestDispatcher("competitorManage.do?action=showall").forward(request, response);
	}
    }

    /**
     * Initialization of the servlet. <br>
     *
     * @throws ServletException if an error occurs
     */
    public void init() throws ServletException {
	super.init();
	competitorService = new CompetitorService();
    }

}
