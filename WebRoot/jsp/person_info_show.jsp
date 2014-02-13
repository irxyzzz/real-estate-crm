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
	  	<h3>账户&emsp;${sessionScope.currentUser.name }&emsp;详细信息</h3>
  			<hr/>
  		<table>		
  			<tr>
  				<th scope="row">账户ID</th>
  				<td>${sessionScope.currentUser.stringId }</td>
  			</tr>
  			<tr>
  				<th scope="row">姓名</th>
  				<td>${sessionScope.currentUser.name } </td>
  			</tr>
  			<tr>
  				<th scope="row">性别</th>
  				<td>
  					<c:if test="${sessionScope.currentUser.gender == 'M' }">
  						<input type="radio" name="gender" value="M" checked="checked"  />男
  						<input type="radio" name="gender" value="F"  />女
  					</c:if>
  					<c:if test="${sessionScope.currentUser.gender == 'F' }">
  						<input type="radio" name="gender" value="M"  />男
  						<input type="radio" name="gender" value="F" checked="checked" />女
  					</c:if> 
  				</td>
  			</tr>
  			<tr>
  				<th scope="row">生日</th>
  				<td>${sessionScope.currentUser.birth }</td>
  			</tr>
  			<tr>
  				<th scope="row">婚姻</th>
  				<td>
  					<c:if test="${sessionScope.currentUser.isMarried == true}">
  						<input type="radio" name="married" value="Y" checked="checked"/>是
  						<input type="radio" name="married" value="N"  />否
  					</c:if>
  					<c:if test="${sessionScope.currentUser.isMarried == false}">
  						<input type="radio" name="married" value="Y"  />是
  						<input type="radio" name="married" value="N" checked="checked" />否
  					</c:if> 
  				</td>
  			</tr>
  			<tr>
  				<th scope="row">住址</th>
  				<td>${sessionScope.currentUser.address }</td>
  			</tr>
  			<tr>
  				<th scope="row">兴趣</th>
  				<td>
  					<textarea rows="3" cols="50" name="hobby" disabled="disabled">${sessionScope.currentUser.hobby }</textarea> 
  				</td>
  			</tr>
  			<tr>
  				<th scope="row">进入公司时间</th>
  				<td>${sessionScope.currentUser.strComeTime } </td>
  			</tr>
  			<tr>
  				<th scope="row">电话</th>
  				<td>${sessionScope.currentUser.phone}</td>
  			</tr>
  			<tr>
  				<th scope="row">E-Mail</th>
  				<td>${sessionScope.currentUser.email}</td>
  			</tr>
  			<tr>
  				<th scope="row">部门</th>
  				<td>
  					<c:if test="${sessionScope.currentUser.department == 'MarketDepartment'}">市场部门</c:if>
  					<c:if test="${sessionScope.currentUser.department == 'SaleDepartment'}">销售部门</c:if>
  					<c:if test="${sessionScope.currentUser.department == 'ServiceDepartment'}">售后部门</c:if>
  				</td>
  			</tr>
  			<tr>
  				<th scope="row">邮编</th>
  				<td>${sessionScope.currentUser.post}</td>
  			</tr>
  			<tr>
  				<th scope="row"></th>
  				<td><br /></td>
  			</tr>
  			<tr>
  				<th scope="row"><a class="btn_submit" href="person_info_modify.jsp">信息不对?</a></th>
  				<td><a class="btn_submit" href="person_info_password.jsp">修改密码</a></td>
  			</tr>
  		</table>
  		<br/>
  	</div>
  </body>
</html>
