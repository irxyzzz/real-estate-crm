<%@ page language="java" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<link rel="stylesheet" type="text/css"  href="../style/table_jui.css" />
    <link rel="stylesheet" type="text/css"  href="../style/jquery-ui-1.7.2.custom.css" />
    <link rel="stylesheet" type="text/css"  href="../style/button.css" />
    <script type="text/javascript" src="../js/jquery-1.3.2.min.js"></script>
    <script type="text/javascript" src="../js/jquery-ui-1.7.2.custom.min.js"></script>
    <script type="text/javascript" src="../js/customer_add.js"></script>
  </head>
  <body>
  	<div class="table_block">
    <h3>添加客户信息</h3>
    <hr>
    <form action="customerManage.do" method="post" id="addCustomerForm">
		<input type="hidden" name="action" value="addCustomer">
		<table>
		  <tr>
		    <th>客户姓名</th>
		    <td><input type="text" name="name" maxlength="5"/> </td>
		  </tr>  
		  <tr>
		    <th>性别</th>
		    <td>
		    	<input type="radio" name="gender" value="M" checked="checked"/><label>男</label>
		    	<input type="radio" name="gender" value="F" /><label>女</label>
		    </td>
		  </tr>
		  <tr>
		    <th>生日</th>
		    <td>
		    	<input type="text" name="birthday" id="birthInput"/>
		    </td>
		  </tr>
		  <tr>
		    <th>地址</th>
		    <td>
		    	<input type="text" name="address" maxlength="100"/>
		    </td>
		  </tr>
		  <tr>
		    <th>婚姻</th>
		    <td>
		    	<input type="radio" name="married" value="N" checked="checked"/><label>未婚</label>
		    	<input type="radio" name="married" value="Y" /><label>已婚</label>
		    </td>
		  </tr>
		  <tr>
		    <th>电话</th>
		    <td>
		    	<input type="text" name="phone" maxlength="15"/>
		    </td>
		  </tr>
		  <tr>
		    <th>Email</th>
		    <td>
		    	<input type="text" name="email" maxlength="30"/>
		    </td>
		  </tr>
		  <tr>
		    <th>购房意向</th>
		    <td>
		    	<input type="text" name="intent" maxlength="20"/>
		    </td>
		  </tr>
		  <tr>
		    <th>收入(月)</th>
		    <td>
		    	<input type="radio" name="income" value="Level 1" checked="checked"/><label>2000以下</label>
		    	<input type="radio" name="income" value="Level 2" /><label>2000~3000</label>
		    	<input type="radio" name="income" value="Level 3" /><label>3000~4000</label>
		    	<input type="radio" name="income" value="Level 4" /><label>4000~5000</label>
		    	<br />
		    	<input type="radio" name="income" value="Level 5" /><label>5000~6000</label>
		    	<input type="radio" name="income" value="Level 6" /><label>6000~7000</label>
		    	<input type="radio" name="income" value="Level 7" /><label>7000~8000</label>
		    	<input type="radio" name="income" value="Level 8" /><label>8000以上</label>
		    </td>
		  </tr>
		  <tr>
		    <th>工作</th>
		    <td>
		    	<input type="text" name="job" maxlength="10"/>
		    </td>
		  </tr>
		  <tr>
		    <th>兴趣</th>
		    <td>
		    	<textarea rows="3" cols="50" name="hobby" /></textarea>
		    </td>
		  </tr>
		  <tr>
		    <th>随机销售人员</th>
		    <td>
			    <input type="hidden" name="saleEmployeeId" value="${requestScope.saleEmployee.employeeId }"/>
		    	<input type="text" name="saleEmployee" value="${requestScope.saleEmployee.name }" disabled="disabled"/>
		    </td>
		  </tr>
		  <tr>
		    <th>随机售后人员</th>
		    <td>
		    	<input type="hidden" name="serviceEmployeeId" value="${requestScope.serviceEmployee.employeeId }"/>
		    	<input type="text" name="serviceEmployee" value="${requestScope.serviceEmployee.name }" disabled="disabled"/>
		    </td>
		  </tr>
		  <tr>
		  	<th></th>
		  	<td><br/></td>
		  </tr>
		  <tr>
		  	<th></th>
		  	<td><a onclick="$('#addCustomerForm')[0].submit();" class="btn_submit" id="add_reset">提交</a></td>
		  </tr>
		</table>
		
    </form>
    </div>
  
	
  </body>
</html>
