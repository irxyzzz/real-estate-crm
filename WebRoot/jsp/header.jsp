<%@ page language="java" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<div id="header">
    	<span class="menu_left">房产CRM系统 |</span>
       
        <c:if test="${sessionScope.currentUser != null}">
        	<span class="menu_left">欢迎你，
        		<c:if test="${sessionScope.currentUser.department == 'SaleDepartment'}">销售部门</c:if>
      			<c:if test="${sessionScope.currentUser.department == 'MarketDepartment'}">市场部门</c:if>
      			<c:if test="${sessionScope.currentUser.department == 'ServiceDepartment'}">售后部门</c:if>
        		<c:if test="${sessionScope.currentUser.isManager == true }">主管</c:if>
        		<c:if test="${sessionScope.currentUser.isManager == false}">员工</c:if>
        	</span>
        	<span class="menu_left">${sessionScope.currentUser.name}</span>
        	<span class="menu_left"><a href="menuDispatcher.do?contentURL=index.do">首页</a></span>
        	<span class="menu_left"><a href="personInfo.do">我的账户</a></span>
        	<span class="menu_left"><a href="logout.do">注销</a></span>
        </c:if>
       
      	<c:if test="${sessionScope.currentUser == null}">
      		 <c:if test="${sessionScope.admin != null}">
        		<span class="menu_left">欢迎你，管理员</span>
        		<span class="menu_left">${sessionScope.admin}</span>
        		<span class="menu_left"><a href="index_admin.jsp">首页</a></span>
        		<span class="menu_left"><a href="logout.do">注销</a></span>
        	</c:if>
        	<c:if test="${sessionScope.admin == null}">
      			<span class="menu_left">菜单：</span>
      			<span class="menu_left"><a href="login.jsp">登录</a></span>
    		</c:if>
      	</c:if>
      	
        <span class="menu_right"><a href="help_container.jsp" target="_blank">帮助</a></span>
        <span class="menu_right"><a href="http://www.google.com" target="_blank">外部链接</a></span>
</div>