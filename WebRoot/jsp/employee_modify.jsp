<%@ page language="java" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<title>个人信息</title>
    <script type="text/javascript" src="../js/jquery-1.3.2.min.js"></script>
	<script type="text/javascript" src="../js/jquery-ui-1.7.2.custom.min.js"></script>
	<link rel="stylesheet" href="../style/jquery-ui-1.7.2.custom.css" type="text/css" title="ui-theme" />
	<link rel="stylesheet" type="text/css" href="../style/person_info.css">
	<script type="text/javascript">	
		$(function(){
			  $('#date').datepicker(); 
		 });
	</script>
  </head>
  <body >
  
  	<form action="employeeManage.do" method="post">
  
  		<c:set value="${requestScope.employeeDetail}" var="employee" scope="request"></c:set>
  		<input type="hidden" name="action" value="modify">
  		<input type="hidden" name="employeeId" value="${employee.employeeId }">
  		
  		<div>${requestScope.errorMsg }</div>
  
  		<div id="info_table">
  		<table>
  			<h3>员工&emsp;${employee.name }&emsp;信息修改</h3>
  			<hr/>
  			<tr>
  				<th scope="row">账户ID</th>
  				<td>${employee.stringId }</td>
  			</tr>
  			<tr>
  				<th scope="row">姓名</th>
  				<td><input type="text" name="name" value="${employee.name }" /></td>
  			</tr>
  			<tr>
  				<th scope="row">性别</th>
  				<td>
  					<c:if test="${employee.gender == 'M' }">
  						<input type="radio" name="gender" value="M" checked="checked"/>男
  						<input type="radio" name="gender" value="F"/>女
  					</c:if>
  					<c:if test="${employee.gender == 'F' }">
  						<input type="radio" name="gender" value="M" />男
  						<input type="radio" name="gender" value="F" checked="checked"/>女
  					</c:if> 
  				</td>
  			</tr>
  			<tr>
  				<th scope="row">生日</th>
  				<td><input type="text" value="${employee.birth }" 
  						name="birthday" id="date" /></td>
  			</tr>
  			<tr>
  				<th scope="row">婚姻</th>
  				<td>
  					<c:if test="${employee.isMarried == true}">
  						<input type="radio" name="married" value="Y" checked="checked"/>是
  						<input type="radio" name="married" value="N" />否
  					</c:if>
  					<c:if test="${employee.isMarried == false}">
  						<input type="radio" name="married" value="Y" />是
  						<input type="radio" name="married" value="N" checked="checked"/>否
  					</c:if> 
  				</td>
  			</tr>
  			<tr>
  				<th scope="row">住址</th>
  				<td><input type="text" name="address" value="${employee.address }"/> </td>
  			</tr>
  			<tr>
  				<th scope="row">兴趣</th>
  				<td>
  					<textarea rows="3" cols="50" name="hobby" >${employee.hobby }</textarea> 
  				</td>
  			</tr>
  			<tr>
  				<th scope="row">进入公司时间</th>
  				<td>${employee.strComeTime } </td>
  			</tr>
  			<tr>
  				<th scope="row">电话</th>
  				<td><input type="text" name="phone" value="${employee.phone}"/> </td>
  			</tr>
  			<tr>
  				<th scope="row">E-Mail</th>
  				<td><input type="text" name="email" value="${employee.email}"/></td>
  			</tr>
  			<tr>
  				<th scope="row">部门</th>
  				<td>
  					<c:if test="${employee.department == 'MarketDepartment'}">
  						<input type="radio" name="department" value="MarketDepartment" checked="checked"/>市场部门
  						<input type="radio" name="department" value="SaleDepartment"/>销售部门
  						<input type="radio" name="department" value="ServiceDepartment"/>售后部门
  					</c:if>
  					<c:if test="${employee.department == 'SaleDepartment'}">
  						<input type="radio" name="department" value="MarketDepartment" />市场部门
  						<input type="radio" name="department" value="SaleDepartment" checked="checked"/>销售部门
  						<input type="radio" name="department" value="ServiceDepartment"/>售后部门
  					</c:if>
  					<c:if test="${employee.department == 'ServiceDepartment'}">
  						<input type="radio" name="department" value="MarketDepartment" />市场部门
  						<input type="radio" name="department" value="SaleDepartment"/>销售部门
  						<input type="radio" name="department" value="ServiceDepartment" checked="checked"/>售后部门
  					</c:if>
  				</td>
  			</tr>
  			<tr>
  				<th scope="row">邮编</th>
  				<td><input type="text" name="post" value="${employee.post}"/></td>
  			</tr>
  			<tr>
  				<td></td>
  				<td><button class="btn_submit" onclick="this.form.submit();">提&emsp;交</button> </td>
  			</tr>
  		</table>
  	</div>
  	</form>
  </body>
</html>
