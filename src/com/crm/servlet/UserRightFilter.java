/**
 * 
 */
package com.crm.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.crm.model.Employee;

/**
 * @author
 * 
 */
public class UserRightFilter implements Filter {

    /*
     * (non-Javadoc)
     * 
     * @see javax.servlet.Filter#destroy()
     */
    public void destroy() {
    }

    /*
     * (non-Javadoc)
     * 
     * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest,
     * javax.servlet.ServletResponse, javax.servlet.FilterChain)
     */
    public void doFilter(ServletRequest request, ServletResponse response,
	    FilterChain chain) throws IOException, ServletException {

	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");

	HttpServletRequest req = (HttpServletRequest) request;
	HttpServletResponse res = (HttpServletResponse) response;
	
	HttpSession session = req.getSession();
	Employee o = (Employee) session.getAttribute("currentUser");
	Object admin = session.getAttribute("admin");
	
	String url = req.getRequestURI();		// 获取当前请求的URI

	if ((o == null && admin == null) && !url.endsWith("login.jsp") 	// 对URL地址为此结尾的文件不过滤
		&& url.indexOf("login.do") < 0 		// 对URL地址中包含此字符串的文件不过滤
		&& url.indexOf("logout.do") < 0 
		&& url.indexOf("help.jsp") < 0 
		&& url.indexOf("help_container.jsp") < 0 
		&& url.indexOf("/images/") < 0
		&& url.indexOf("/image/") < 0) {
	    
	    res.sendRedirect(req.getContextPath() + "/index.jsp");
	} 
	else {
	    chain.doFilter(request, response);
	    res.setHeader("Cache-Control", "no-store");
	    res.setDateHeader("Expires", 0);
	    res.setHeader("Pragma", "no-cache");
	    res.flushBuffer();
	}

    }

    /*
     * (non-Javadoc)
     * 
     * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
     */
    public void init(FilterConfig arg0) throws ServletException {
    }

}
