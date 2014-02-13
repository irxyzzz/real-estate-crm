<%@ page language="java" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <script type="text/javascript" src="../js/jquery-1.3.2.min.js"></script>
	<script type="text/javascript" src="../js/jquery-ui-1.7.2.custom.min.js"></script>
	<link rel="stylesheet" href="../style/jquery-ui-1.7.2.custom.css" type="text/css" title="ui-theme" />
	<link rel="stylesheet" type="text/css" href="../style/person_info.css"/>
	<link rel="stylesheet" type="text/css" href="../style/button.css"/>
  </head>
  <body >
  
  	<form action="systemManage.do" method="post">
  		<input type="hidden" name="action" value="managerNoticeAdd">
  		<div id="info_table">
  		<h3>新公司通知信息</h3>
  		<hr/>
  		<table>	
  			<tr>
  				<th scope="row">标题</th>
  				<td><input type="text" name="title" maxlength="20"/></td>
  			</tr>
  			<tr>
  				<th scope="row">内容</th>
  				<td>
  					<textarea rows="6" cols="50" name="content" ></textarea> 
  				</td>
  			</tr>
  			<tr>
  				<td></td>
  				<td><a class="btn_submit" onclick="this.form.submit();">提&emsp;交</a> </td>
  			</tr>
  		</table>
  	</div>
  	</form>
  </body>
</html>
