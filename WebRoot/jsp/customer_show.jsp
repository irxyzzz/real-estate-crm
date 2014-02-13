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
		    <li class="TabbedPanelsTab" id="tab_left">潜在客户</li>
		    <li class="TabbedPanelsTab" id="tab_right">已有客户</li>
	    </ul>
	    <div class="TabbedPanelsContentGroup">
	    	<div class="TabbedPanelsContent">
	    		<div class="btn_controller">
	    			<c:if test="${sessionScope.currentUser.department == 'MarketDepartment'}">
                    <a href="customerManage.do?action=preAddCustomer" class="btn_submit">添&emsp;加</a>
                    <!-- 
                    <a href="#" onclick="" class="btn_submit">批量导入</a>
                     -->
                    </c:if>
                    <span>${requestScope.errorMsg }</span>
                </div>
                <table class="display" id="inCustomerTable" cellpadding="0" cellspacing="0" border="0" >
  					<thead>
  					<tr>
  						<th>编号</th>
  						<th>姓名</th>
  						<th>性别</th>
  						<th>电话</th>
  						<th>工作</th>
  						<th>收入</th>
  						<th>Email</th>
  						<th>购房意向</th>
  						<th>兴趣</th>
  						<th>婚姻</th>
  						<c:if test="${sessionScope.currentUser.department == 'MarketDepartment'}">
  							<th>选项</th>
  						</c:if>
  						<c:if test="${sessionScope.currentUser.department == 'SaleDepartment'}">
  							<th>选项</th>
  						</c:if>
  						
  					</tr>
  					</thead>
  					<tbody>
  					<c:forEach items="${requestScope.intentCustomer}" var="customer">
  						<tr class="gradeA">
	  						<td class="center">${customer.stringId}</td>
	  						<td class="center">${customer.name}</td>
	  						<td class="center">
	  							<c:if test="${customer.gender == 'M'}">男</c:if>
	  							<c:if test="${customer.gender == 'F'}">女</c:if>
	  						</td>
	  						<td class="center">${customer.phone}</td>
	  						<td class="center">${customer.job }</td>
	  						<td class="center">${customer.income}</td>
	  						<td class="center">${customer.email}</td>
		  					<td class="center">${customer.houseIntent }</td>
		  					<td class="center">${customer.hobby}</td>
	  						<td class="center">
	  							<c:if test="${customer.isMarried == true}">已婚</c:if>
	  							<c:if test="${customer.isMarried == false}">未婚</c:if>
	  						</td>
	  						
	  						<c:if test="${sessionScope.currentUser.department == 'MarketDepartment'}">
	  							<td>
	  							<a href="customerManage.do?action=preModify&id=${customer.customerId }">修改</a>
	  							<a href="customerManage.do?action=deleteCustomer&id=${customer.customerId }">删除</a>
	  							</td>
	  						</c:if>
	  						<c:if test="${sessionScope.currentUser.department == 'SaleDepartment'}">
	  							<td>
	  							<a href="customerManage.do?action=preBuy&id=${customer.customerId }">买房</a>
	  							</td>
	  						</c:if>
  					</tr>
  					</c:forEach>
  					</tbody>
  				</table>
	    	</div>
	    
	    	<div class="TabbedPanelsContent">
	    		<div class="btn_controller">
	    		<c:if test="${sessionScope.currentUser.department == 'MarketDepartment'}">
                    <a href="customerManage.do?action=preAddCustomer" class="btn_submit">添&emsp;加</a>
                    <!-- 
                    <a href="#" onclick="" class="btn_submit">批量导入</a>
                     -->
                </c:if>
                    <span>${requestScope.errorMsg }</span>
                </div>
                <table class="display" id="alCustomerTable" cellpadding="0" cellspacing="0" border="0" >
  					<thead>
  					<tr>
  						<th>编号</th>
  						<th>姓名</th>
  						<th>性别</th>
  						<th>电话</th>
		  				<th>工作</th>
		  				<th>收入</th>
		  				<th>Email</th>
		  				<th>房屋编号</th>
		  				<th>兴趣</th>
		  				<th>婚姻</th>
		  				<c:if test="${sessionScope.currentUser.department == 'MarketDepartment'}">
  							<th>选项</th>
  						</c:if>
  					</tr>
			  		</thead>
			  		<tbody>
			  			<c:forEach items="${requestScope.alreadyCustomer}" var="customer">
			  			<tr class="gradeA">
			  				<td class="center">${customer.stringId}</td>
			  				<td class="center">${customer.name}</td>
			  				<td class="center">
			  					<c:if test="${customer.gender == 'M'}">男</c:if>
			  					<c:if test="${customer.gender == 'F'}">女</c:if>
			  				</td>
			  				<td class="center">${customer.phone}</td>
			  				<td class="center">${customer.job }</td>
			  				<td class="center">${customer.income}</td>
			  				<td class="center">${customer.email}</td>
			  				<td class="center">
			  					<a href="">${customer.houseId }</a>
			  				</td>
			  				<td class="center">${customer.hobby}</td>
			  				<td class="center">
			  					<c:if test="${customer.isMarried == true}">已婚</c:if>
			  					<c:if test="${customer.isMarried == false}">未婚</c:if>
			  				</td>
		  					<c:if test="${sessionScope.currentUser.department == 'MarketDepartment'}">
		  						<td>
		  						<a href="customerManage.do?action=preModify&id=${customer.customerId }">修改</a>
		  						<a href="customerManage.do?action=deleteCustomer&id=${customer.customerId }">删除</a>
		  						</td>
		  					</c:if>
			  			</tr>
			  			</c:forEach>
			  		</tbody>
			  	</table>
	    	</div>
	    </div>
  	</div>
  </body>
</html>
