<%@ page language="java" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<title>个人信息</title>
	<link rel="stylesheet" href="../style/jquery-ui-1.7.2.custom.css" type="text/css" title="ui-theme" />
	<link rel="stylesheet" type="text/css" href="../style/person_info.css">
  </head>
  <body >
  
  	<form action="personModifyPassword.do" method="post" id="passForm">
  		<div id="info_table">
  		<h3>账户&emsp;${sessionScope.currentUser.name }&emsp;密码修改</h3>
  			<hr/>
  			<div>${requestScope.errorMsg }</div>
  		<table>
  			<tr>
  				<th scope="row">原密码</th>
  				<td><input type="password" name="oldPassword" maxlength="8"/></td>
  			</tr>
  			<tr>
  				<th scope="row">新密码</th>
  				<td><input type="password" name="newPassword" maxlength="8"/></td>
  			</tr>
  			<tr>
  				<th scope="row">密码确认</th>
  				<td><input type="password" name="passwordConfirm" maxlength="8"/></td>
  			</tr>
  			<tr>
  				<td></td>
  				<td><br></td>
  			</tr>
  			<tr>
  				<td></td>
  				<td><a class="btn_submit" href="#" onclick="document.getElementById('passForm').submit();">修&emsp;改</a></td>
  			</tr>
  		</table>
  	</div>
  	</form>
  </body>
</html>
