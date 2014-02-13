<%@ page language="java" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<link rel="stylesheet" type="text/css"  href="../style/table_jui.css" />
    <link rel="stylesheet" type="text/css"  href="../style/jquery-ui-1.7.2.custom.css" />
    <link rel="stylesheet" type="text/css"  href="../style/customer_show.css" />
    <link rel="stylesheet" type="text/css" href="../style/SpryTabbedPanels.css" />
    <script type="text/javascript" src="../js/jquery-1.3.2.min.js"></script>
    <script type="text/javascript" src="../js/dataTables/jquery.dataTables.js"></script>
    <script type="text/javascript" src="../js/tabPanel/SpryTabbedPanels.js"></script>
    <script type="text/javascript" src="../js/customer_show.js" ></script>
  </head>
  <body>
	<div id="TabbedPanels" class="TabbedPanels">
		<ul class="TabbedPanelsTabGroup">
		    <li class="TabbedPanelsTab" id="tab_left">员工信息</li>
		    <li class="TabbedPanelsTab" id="tab_right">主管信息</li>
	    </ul>
	    <div class="TabbedPanelsContentGroup">
	    	<div class="TabbedPanelsContent">
	    		<div class="btn_controller">
                    <a href="employeeManage.do?action=preAdminAddCustomer" class="btn_submit">添&emsp;加</a>
                    <!-- 
                    <a href="#" onclick="" class="btn_submit">批量导入</a>
                     -->
                    <span>${requestScope.errorMsg }</span>
                </div>
                <table class="display" id="inCustomerTable" cellpadding="0" cellspacing="0" border="0" >
  					<thead>
			  			<tr>
			  				<th>编号</th>
			  				<th>姓名</th>
			  				<th>性别</th>
			  				<th>电话</th>
			  				<th>部门</th>
			  				<th>地址</th>
			  				<th>生日</th>
			  				<th>选项</th>
			  			</tr>
	  				</thead>
			  		<tbody>
			  			<c:forEach items="${requestScope.employees}" var="employee">
			  			<tr class="gradeA">
			  				<td class="center">${employee.stringId}</td>
			  				<td class="center">${employee.name}</td>
			  				<td class="center">
			  					<c:if test="${employee.gender == 'M'}">男</c:if>
			  					<c:if test="${employee.gender == 'F'}">女</c:if>
			  				</td>
			  				<td class="center">${employee.phone }</td>
			  				<td class="center">
			  					<c:if test="${employee.department == 'MarketDepartment'}">市场部门</c:if>
  								<c:if test="${employee.department == 'SaleDepartment'}">销售部门</c:if>
  								<c:if test="${employee.department == 'ServiceDepartment'}">售后部门</c:if>
			  				</td>
			  				<td class="center">${employee.address }</td>
			  				<td class="center">${employee.birth }</td>
			  				<td class="center">
			  					<a href="employeeManage.do?action=adminShowDetail&id=${employee.employeeId }">详细</a>
			  					<a href="employeeManage.do?action=adminPrepareModify&id=${employee.employeeId }">修改</a>
			  					<a href="employeeManage.do?action=adminDelete&id=${employee.employeeId }">删除</a>
			  				</td>
			  			</tr>
			  			</c:forEach>
			  		</tbody>
  				</table>
	    	</div>
	    
	    	<div class="TabbedPanelsContent">
	    		<div class="btn_controller">
                    <a href="employeeManage.do?action=preAdminAddCustomer" class="btn_submit">添&emsp;加</a>
                    <!-- 
                    <a onClick="" class="btn_submit">批量导入</a>
                     -->
                    <span>${requestScope.errorMsg }</span>
                </div>
                <table class="display" id="alCustomerTable" cellpadding="0" cellspacing="0" border="0" >
  					<thead>
			  			<tr>
			  				<th>编号</th>
			  				<th>姓名</th>
			  				<th>性别</th>
			  				<th>电话</th>
			  				<th>部门</th>
			  				<th>地址</th>
			  				<th>生日</th>
			  				<th>选项</th>
			  			</tr>
	  				</thead>
			  		<tbody>
			  			<c:forEach items="${requestScope.managers}" var="employee">
			  			<tr class="gradeA">
			  				<td class="center">${employee.stringId}</td>
			  				<td class="center">${employee.name}</td>
			  				<td class="center">
			  					<c:if test="${employee.gender == 'M'}">男</c:if>
			  					<c:if test="${employee.gender == 'F'}">女</c:if>
			  				</td>
			  				<td class="center">${employee.phone }</td>
			  				<td class="center">
								<c:if test="${employee.department == 'MarketDepartment'}">市场部门</c:if>
  								<c:if test="${employee.department == 'SaleDepartment'}">销售部门</c:if>
  								<c:if test="${employee.department == 'ServiceDepartment'}">售后部门</c:if>
			  				</td>
			  				<td class="center">${employee.address }</td>
			  				<td class="center">${employee.birth }</td>
			  				<td class="center">
			  					<a href="employeeManage.do?action=adminShowDetail&id=${employee.employeeId }">详细</a>
			  					<a href="employeeManage.do?action=adminPrepareModify&id=${employee.employeeId }">修改</a>
			  					<a href="employeeManage.do?action=adminDelete&id=${employee.employeeId }">删除</a>
			  				</td>
			  			</tr>
			  			</c:forEach>
			  		</tbody>
			  	</table>
	    	</div>
	    </div>
  	</div>
  </body>
</html>
