<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css"  href="../style/table_jui.css" />
	<link rel="stylesheet" type="text/css"  href="../style/jquery-ui-1.7.2.custom.css" />
	<link rel="stylesheet" type="text/css"  href="../style/button.css" />
  	<script type="text/javascript" src="../js/jquery-1.3.2.min.js"></script>
  	<script type="text/javascript" src="../js/jquery-ui-1.7.2.custom.min.js"></script>
  	<script type="text/javascript" src="../js/customer_repair.js"></script>
</head>
<body>
  	<div class="table_block">
    <h3>添加客户报修信息</h3>
    <hr>
	<form action="customerManage.do" method="post" id="addRepairRecordForm">
		<input type="hidden" name="action" value="addRepairRecord">
		<table>
		  <tr>
		    <th>客户编号：</th>
		    <td><select name="customerId">
		        <c:forEach items="${requestScope.alreadyCustomers}" var="customer">
		  		  <option value="${customer.customerId}">${customer.stringId}-${customer.name}</option>
		  		</c:forEach>
		  	  </select></td>
		  </tr>  
		  <tr>
		    <th>故障描述：</th>
		    <td>
		    	<textarea rows="3" cols="50" name="description"></textarea>
		    </td>
		  </tr>
		  <tr>
		    <th>开始时间：</th>
		    <td>
		    	<input type="text" name="beginTime" value="${requestScope.beginTime }" disabled="disabled" />
		    </td>
		  </tr>
		  <tr>
		    <th>处理方案：</th>
		    <td>
		    	<textarea rows="3" cols="50" name="handle" ></textarea>
		    </td>
		  </tr>
		  <tr>
		    <th>计划完成时间：</th>
		    <td>
		    	<input type="text" name="endTime" id="endTime" value="${requestScope.defaultEndTime }"/>
		    </td>
		  </tr>
		  <tr>
		    <th></th>
		    <td><br></td>
		  </tr>
		  <tr>
		    <th></th>
		    <td>
		    	<a href="#" onclick="$('#addRepairRecordForm')[0].submit();" class="btn_submit" id="add_reset">提交</a>
		    </td>
		  </tr>
		</table>
	</form>
</div>
</body>
</html>