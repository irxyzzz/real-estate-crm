<%@ page language="java" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<link rel="stylesheet" type="text/css"  href="../style/table_jui.css" />
    <link rel="stylesheet" type="text/css"  href="../style/jquery-ui-1.7.2.custom.css" />
    <link rel="stylesheet" type="text/css"  href="../style/customer_care.css" />
    <script type="text/javascript" src="../js/jquery-1.3.2.min.js"></script>
    <script type="text/javascript" src="../js/jquery-ui-1.7.2.custom.min.js"></script>
    <script type="text/javascript" src="../js/dataTables/jquery.dataTables.js"></script>
    <script type="text/javascript" src="../js/customer_care_m.js" ></script>
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
  				<th>选项</th>
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
  				<td class="center">
  				<c:if test="${care.stringId != '100000'}">
  					<a href="customerManage.do?action=delCare&id=${care.customerCareId}">删除</a>
  				</c:if> 	
  				</td>
  			</tr>
  			</c:forEach>
  		</tbody>
  	</table>
  	</div>
  	
  	<div class="modify_block" id="modifier">
  		<div class="table_header"><span>新关怀计划</span></div>
  		<form action="customerManage.do" method="post" id="addCareForm">
  		<input type="hidden" name="action" value="addCare">
  		<table width="100%" class="add_info">
  			<tr>
                <th scope="col">主题</th>
                <th scope="col">描述</th>
                <th scope="col">活动时间</th>
	  			<th scope="col">活动形式</th>
	  			<th scope="col">客户类型</th>
            </tr>
            <tr>
                <td>
                    <input type="text" name="title" maxlength="20"/>
                </td>
                <td>
                   <textarea rows="3" cols="50" name="description"></textarea>
                </td>
                <td>
                    <input type="text" name="activeTime" id="activeTime">
                </td>
                <td>
                    <input type="text" name="activeForm" maxlength="20">
                </td>
                <td>
                    <input type="text" name="customerType" maxlength="20">
                </td>
            </tr>
  		</table>
  		<div class="table_footer ui-helper-clearfix">
            <span>添加关怀计划</span>
            <a onclick="$('#addCareForm')[0].submit();" class="btn_submit">添加</a>
        </div>
  		</form>
  	</div>
  </body>
</html>
