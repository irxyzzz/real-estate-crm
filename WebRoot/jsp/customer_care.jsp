<%@ page language="java" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<link rel="stylesheet" type="text/css"  href="../style/table_jui.css" />
    <link rel="stylesheet" type="text/css"  href="../style/jquery-ui-1.7.2.custom.css" />
    <link rel="stylesheet" type="text/css"  href="../style/customer_care.css" />
    <script type="text/javascript" src="../js/jquery-1.3.2.min.js"></script>
    <script type="text/javascript" src="../js/dataTables/jquery.dataTables.js"></script>
    <script type="text/javascript" src="../js/customer_care.js" ></script>
  </head>
  <body>
  	<div class="table_block">
  	<h3>客户关乎计划</h3>
  	<hr/>
  	<span>${requestScope.errorMsg }</span>
  	<table id="customerCareTable" cellpadding="0" cellspacing="0" border="0" >
  		<thead>
  			<tr>
  				<th>编号</th>
  				<th>主题</th>
  				<th>描述</th>
  				<th>活动时间</th>
  				<th>活动形式</th>
  				<th>客户类型</th>
  			</tr>
  		</thead>
  		<tbody>
  			<c:forEach items="${requestScope.customerCares}" var="care">
  			<tr class="gradeA">
  				<td class="center">${care.stringId}</td>
  				<td class="center">${care.title}</td>
  				<td class="center">${care.decription}</td>
  				<td class="center">${care.time }</td>
  				<td class="center">${care.form}</td>
  				<td class="center">${care.customerType}</td>
  			</tr>
  			</c:forEach>
  		</tbody>
  	</table>
  	</div>
  </body>
</html>
