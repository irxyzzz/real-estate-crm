<%@ page language="java" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<title>个人信息</title>
    <script type="text/javascript" src="../js/jquery-1.3.2.min.js"></script>
	<script type="text/javascript" src="../js/jquery-ui-1.7.2.custom.min.js"></script>
	<script type="text/javascript" src="../js/daterangepicker/daterangepicker.jQuery.js"></script>
	<link rel="stylesheet" href="../style/ui.daterangepicker.css" type="text/css" />
	<link rel="stylesheet" href="../style/jquery-ui-1.7.2.custom.css" type="text/css" title="ui-theme" />
	<link rel="stylesheet" type="text/css" href="../style/person_info.css">
	<script type="text/javascript">	
		$(function(){
			  $('#date').datepicker(); 
		 });
	</script>
  </head>
  <body >
  
  	<form action="personInfoModify.do" method="post" id="passForm">
  		<div>${requestScope.errorMsg }</div>
  		<div id="info_table">
  		<h3>账户&emsp;${sessionScope.currentUser.name }&emsp;信息修改</h3>
  			<hr/>
  		<table>
  			<tr>
  				<th scope="row">账户ID</th>
  				<td>${sessionScope.currentUser.stringId }</td>
  			</tr>
  			<tr>
  				<th scope="row">姓名</th>
  				<td><input type="text" name="name" maxlength="5" value="${sessionScope.currentUser.name }" /></td>
  			</tr>
  			<tr>
  				<th scope="row">性别</th>
  				<td>
  					<c:if test="${sessionScope.currentUser.gender == 'M' }">
  						<input type="radio" name="gender" value="M" checked="checked"/>男
  						<input type="radio" name="gender" value="F"/>女
  					</c:if>
  					<c:if test="${sessionScope.currentUser.gender == 'F' }">
  						<input type="radio" name="gender" value="M" />男
  						<input type="radio" name="gender" value="F" checked="checked"/>女
  					</c:if> 
  				</td>
  			</tr>
  			<tr>
  				<th scope="row">生日</th>
  				<td><input type="text" value="${sessionScope.currentUser.birth }" 
  						name="birthday" id="date" /></td>
  			</tr>
  			<tr>
  				<th scope="row">婚姻</th>
  				<td>
  					<c:if test="${sessionScope.currentUser.isMarried == true}">
  						<input type="radio" name="married" value="Y" checked="checked"/>是
  						<input type="radio" name="married" value="N" />否
  					</c:if>
  					<c:if test="${sessionScope.currentUser.isMarried == false}">
  						<input type="radio" name="married" value="Y" />是
  						<input type="radio" name="married" value="N" checked="checked"/>否
  					</c:if> 
  				</td>
  			</tr>
  			<tr>
  				<th scope="row">住址</th>
  				<td><input type="text" name="address" value="${sessionScope.currentUser.address }" maxlength="50"/> </td>
  			</tr>
  			<tr>
  				<th scope="row">兴趣</th>
  				<td>
  					<textarea rows="3" cols="50" name="hobby" >${sessionScope.currentUser.hobby }</textarea> 
  				</td>
  			</tr>
  			<tr>
  				<th scope="row">进入公司时间</th>
  				<td>${sessionScope.currentUser.strComeTime } </td>
  			</tr>
  			<tr>
  				<th scope="row">电话</th>
  				<td><input type="text" name="phone" value="${sessionScope.currentUser.phone}" maxlength="15"/> </td>
  			</tr>
  			<tr>
  				<th scope="row">E-Mail</th>
  				<td><input type="text" name="email" value="${sessionScope.currentUser.email}" maxlength="30"/></td>
  			</tr>
  			<tr>
  				<th scope="row">部门</th>
  				<td>
  					<c:if test="${sessionScope.currentUser.department == 'MarketDepartment'}">
  						<input type="radio" name="department" value="MarketDepartment" checked="checked" disabled="disabled"/>市场部门
  						<input type="radio" name="department" value="SaleDepartment" disabled="disabled"/>销售部门
  						<input type="radio" name="department" value="ServiceDepartment" disabled="disabled"/>售后部门
  					</c:if>
  					<c:if test="${sessionScope.currentUser.department == 'SaleDepartment'}">
  						<input type="radio" name="department" value="MarketDepartment" disabled="disabled"/>市场部门
  						<input type="radio" name="department" value="SaleDepartment" checked="checked" disabled="disabled"/>销售部门
  						<input type="radio" name="department" value="ServiceDepartment" disabled="disabled"/>售后部门
  					</c:if>
  					<c:if test="${sessionScope.currentUser.department == 'ServiceDepartment'}">
  						<input type="radio" name="department" value="MarketDepartment" disabled="disabled"/>市场部门
  						<input type="radio" name="department" value="SaleDepartment" disabled="disabled"/>销售部门
  						<input type="radio" name="department" value="ServiceDepartment" checked="checked" disabled="disabled"/>售后部门
  					</c:if>
  				</td>
  			</tr>
  			<tr>
  				<th scope="row">邮编</th>
  				<td><input type="text" name="post" value="${sessionScope.currentUser.post}" maxlength="6"/></td>
  			</tr>
  			<tr>
  				<td></td>
  				<td><br></td>
  			</tr>
  			<tr>
  				<td></td>
  				<td><a class="btn_submit" href="#" onclick="document.getElementById('passForm').submit()">修&emsp;改</a></td>
  			</tr>
  		</table>
  	</div>
  	</form>
  </body>
</html>
