<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<link rel="stylesheet" type="text/css"  href="../style/table_jui.css" />
  		<link rel="stylesheet" type="text/css"  href="../style/jquery-ui-1.7.2.custom.css" />
  		<link rel="stylesheet" type="text/css"  href="../style/button.css" />
  		<script type="text/javascript" src="../js/jquery-1.3.2.min.js"></script>
	</head>
  	<body>
    <div class="modify_block" id="modifier">
    	<h3>添加反馈信息</h3>
    	<hr>
    	<form action="customerManage.do" method="post" id="addFeedbackForm">
    	<input type="hidden" name="action" value="addFeedback"/>
		<table width="100%" class="add_info">
		  <tr>
		    <th>客户编号：</th>
		    <td><select name="customerId">
		        <c:forEach items="${requestScope.customers}" var="customer">
		  		  <option value="${customer.customerId}">${customer.name}</option>
		  		</c:forEach>
		  	  	</select>
		  	</td>
		  </tr>
		  <tr>
		    <th>评价员工：</th>
		    <td><select name="employeeId">
		        <c:forEach items="${requestScope.employees}" var="employee">
		  		  <option value="${employee.employeeId}">${employee.name}</option>
		  		</c:forEach>
		  	  	</select>
		  	</td>
		  </tr>
		  
		  <tr>
		    <th>销售人员评分：</th>
		    <td><input type="radio" value="1" name="MarkforSeller"/>60以下
		        <input type="radio" value="2" name="MarkforSeller"/>60~70
		        <input type="radio" value="3" name="MarkforSeller"/>70~80
		        <input type="radio" value="4" name="MarkforSeller"/>80~90
		        <input type="radio" value="5" name="MarkforSeller"/>90~100</td>
		  </tr>
		
		  <tr>
		   	<th>小区环境评分：</th>
		    <td><input type="radio" value="1" name="MarkForEnvironment"/>60以下
		        <input type="radio" value="2" name="MarkForEnvironment"/>60~70
		        <input type="radio" value="3" name="MarkForEnvironment"/>70~80
		        <input type="radio" value="4" name="MarkForEnvironment"/>80~90
		        <input type="radio" value="5" name="MarkForEnvironment"/>90~100</td>
		  </tr>
		
		  <tr>
		    <th>小区物业评分：</th>
		    <td><input type="radio" value="1" name="MarkForTenement"/>60以下
		        <input type="radio" value="2" name="MarkForTenement"/>60~70
		        <input type="radio" value="3" name="MarkForTenement"/>70~80
		        <input type="radio" value="4" name="MarkForTenement"/>80~90
		        <input type="radio" value="5" name="MarkForTenement"/>90~100</td>
		  </tr>
		
		  <tr>
		    <th>交通情况评分：</th>
		    <td><input type="radio" value="1" name="MarkForTraffic"/>60以下
		        <input type="radio" value="2" name="MarkForTraffic"/>60~70
		        <input type="radio" value="3" name="MarkForTraffic"/>70~80
		        <input type="radio" value="4" name="MarkForTraffic"/>80~90
		        <input type="radio" value="5" name="MarkForTraffic"/>90~100</td>
		  </tr>
		
		  <tr>
		    <th>总体评分：</th>
		    <td><input type="radio" value="1" name="TotalMark"/>60以下
		        <input type="radio" value="2" name="TotalMark"/>60~70
		        <input type="radio" value="3" name="TotalMark"/>70~80
		        <input type="radio" value="4" name="TotalMark"/>80~90
		        <input type="radio" value="5" name="TotalMark"/>90~100</td>
		  </tr>
		
		  <tr>
		    <th>销售人员建议：</th>
		    <td><textarea rows="2" name="Advice"></textarea> </td>
		  </tr>	
		  <tr>
		    <th></th>
		    <td><br/></td>
		  </tr>	
		  <tr>
		    <th></th>
		    <td><a class="btn_submit" onclick="$('#addFeedbackForm')[0].submit();" class="btn_submit" id="add_reset">提&emsp;交</a></td>
		  </tr>	
		</table>
		<br>
		</form>
		<br/>
    </div>
</body>
</html>