<%@ page language="java" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <script type="text/javascript" src="../js/jquery-1.3.2.min.js"></script>
	<script type="text/javascript" src="../js/jquery-ui-1.7.2.custom.min.js"></script>
	<link rel="stylesheet" href="../style/jquery-ui-1.7.2.custom.css" type="text/css" title="ui-theme" />
	<link rel="stylesheet" type="text/css" href="../style/person_info.css">
	<link rel="stylesheet" type="text/css" href="../style/button.css">
	<script type="text/javascript">	
		$(function(){
			  $('#date').datepicker(); 
		 });
	</script>
  </head>
  <body >
  <div id="info_table">
  	<form action="employeeManage.do" method="post">
  		<input type="hidden" name="action" value="adminAdd">
  		<div>${requestScope.errorMsg }</div>
  		
  		<h3>新员工信息</h3>
  		<hr/>
  		<table>	
  			<tr>
  				<th scope="row">姓名</th>
  				<td><input type="text" name="name" maxlength="5"/></td>
  			</tr>
  			<tr>
  				<th scope="row">性别</th>
  				<td>
  					<input type="radio" name="gender" value="M" checked="checked"/><label>男</label>
  					<input type="radio" name="gender" value="F"/><label>女</label>
  				</td>
  			</tr>
  			<tr>
  				<th scope="row">生日</th>
  				<td><input type="text" name="birthday" id="date" /></td>
  			</tr>
  			<tr>
  				<th scope="row">婚姻</th>
  				<td>
					<input type="radio" name="married" value="Y" /><label>是</label>
					<input type="radio" name="married" value="N" checked="checked"/><label>否</label>
  				</td>
  			</tr>
  			<tr>
  				<th scope="row">住址</th>
  				<td><input type="text" name="address" maxlength="50"/> </td>
  			</tr>
  			<tr>
  				<th scope="row">兴趣</th>
  				<td>
  					<textarea rows="3" cols="50" name="hobby" ></textarea> 
  				</td>
  			</tr>
  			<tr>
  				<th scope="row">电话</th>
  				<td><input type="text" name="phone" maxlength="15"/> </td>
  			</tr>
  			<tr>
  				<th scope="row">E-Mail</th>
  				<td><input type="text" name="email" maxlength="30"/></td>
  			</tr>
  			<tr>
  				<th scope="row">部门</th>
  				<td>
  					<input type="radio" name="department" value="MarketDepartment" checked="checked"/>市场部门
  					<input type="radio" name="department" value="SaleDepartment"/>销售部门
  					<input type="radio" name="department" value="ServiceDepartment" />售后部门
  				</td>
  			</tr>
  			<tr>
  				<th scope="row">主管</th>
  				<td>
  					<input type="radio" name="isManager" value="Y" checked="checked"/><label>是</label>
  					<input type="radio" name="isManager" value="N" /><label>否</label>
  				</td>
  			</tr>
  			<tr>
  				<th scope="row">邮编</th>
  				<td><input type="text" name="post" maxlength="6"/></td>
  			</tr>
  			<tr>
  				<th scope="row"></th>
  				<td></td>
  			</tr>
  			<tr>
  				<td></td>
  				<td><button class="btn_submit" onclick="this.form.submit();">提&emsp;交</button> </td>
  			</tr>
  		</table>
  
  	</form>
  		</div>
  </body>
</html>
