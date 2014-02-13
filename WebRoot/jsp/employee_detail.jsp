<%@ page language="java" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<title>个人信息</title>
  	<link rel="stylesheet" type="text/css" href="../style/person_info.css">
  </head>
  <body >
  	<div id="info_table">
  		<c:set value="${requestScope.employeeDetail}" var="employee" scope="request"></c:set>
  		<table>
  			<h3>${employee.name }&emsp;详细信息</h3>
  			<hr/>
  			<tr>
  				<th scope="row">账户ID</th>
  				<td>${employee.stringId }</td>
  			</tr>
  			<tr>
  				<th scope="row">姓名</th>
  				<td>${employee.name } </td>
  			</tr>
  			<tr>
  				<th scope="row">性别</th>
  				<td>
  					<c:if test="${employee.gender == 'M' }">
  						<input type="radio" name="gender" value="M" checked="checked"  /><label>男</label>
  						<input type="radio" name="gender" value="F" /><label>女</label>
  					</c:if>
  					<c:if test="${employee.gender == 'F' }">
  						<input type="radio" name="gender" value="M"  /><label>男</label>
  						<input type="radio" name="gender" value="F" checked="checked" /><label>女</label>
  					</c:if> 
  				</td>
  			</tr>
  			<tr>
  				<th scope="row">生日</th>
  				<td>${employee.birth }</td>
  			</tr>
  			<tr>
  				<th scope="row">婚姻</th>
  				<td>
  					<c:if test="${employee.isMarried == true}">
  						<input type="radio" name="married" value="Y" checked="checked"/><label>是</label>
  						<input type="radio" name="married" value="N"  /><label>否</label>
  					</c:if>
  					<c:if test="${employee.isMarried == false}">
  						<input type="radio" name="married" value="Y"  /><label>是</label>
  						<input type="radio" name="married" value="N" checked="checked" /><label>否</label>
  					</c:if> 
  				</td>
  			</tr>
  			<tr>
  				<th scope="row">住址</th>
  				<td>${employee.address }</td>
  			</tr>
  			<tr>
  				<th scope="row">兴趣</th>
  				<td>
  					<textarea rows="3" cols="50" name="hobby" disabled="disabled">${employee.hobby }</textarea> 
  				</td>
  			</tr>
  			<tr>
  				<th scope="row">进入公司时间</th>
  				<td>${employee.strComeTime } </td>
  			</tr>
  			<tr>
  				<th scope="row">电话</th>
  				<td>${employee.phone}</td>
  			</tr>
  			<tr>
  				<th scope="row">E-Mail</th>
  				<td>${employee.email}</td>
  			</tr>
  			<tr>
  				<th scope="row">部门</th>
  				<td>
  					<c:if test="${employee.department == 'MarketDepartment'}">市场部门</c:if>
  					<c:if test="${employee.department == 'SaleDepartment'}">销售部门</c:if>
  					<c:if test="${employee.department == 'ServiceDepartment'}">售后部门</c:if>
  				</td>
  			</tr>
  			<tr>
  				<th scope="row">邮编</th>
  				<td>${employee.post}</td>
  			</tr>
  		</table>
  		<a class="btn_submit" href="employeeManage.do?action=prepareModify&id=${employee.employeeId }">修&emsp;改</a>
  	</div>
  </body>
</html>
