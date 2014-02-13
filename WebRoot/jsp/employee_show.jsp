<%@ page language="java" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<link rel="stylesheet" type="text/css"  href="../style/table_jui.css" />
    <link rel="stylesheet" type="text/css"  href="../style/jquery-ui-1.7.2.custom.css" />
    <link rel="stylesheet" type="text/css"  href="../style/employee_show.css">
    <script type="text/javascript" src="../js/jquery-1.3.2.min.js"></script>
    <script type='text/javascript' src='../js/jquery-ui-1.7.2.custom.min.js'></script>
    <script type="text/javascript" src="../js/dataTables/jquery.dataTables.js"></script>
    <script type="text/javascript" src="../js/employee_show.js" ></script>
  </head>
  <body>
  
  	<div class="table_block">
  		<h3>
  			<c:if test="${sessionScope.currentUser.department == 'SaleDepartment'}">销售部门员工信息</c:if>
  			<c:if test="${sessionScope.currentUser.department == 'MarketDepartment'}">市场部门员工信息</c:if>
  			<c:if test="${sessionScope.currentUser.department == 'ServiceDepartment'}">售后部门员工信息</c:if>
  		</h3>
        <hr>
           <span>${requestScope.errorMsg }</span>
        <table id="employeeTable" cellpadding="0" cellspacing="0" border="0" >
	  		<thead>
	  			<tr>
	  				<th>编号</th>
	  				<th>姓名</th>
	  				<th>性别</th>
	  				<th>电话</th>
	  				<th>Email</th>
	  				<th>地址</th>
	  				<th>生日</th>
	  				<th>选项</th>
	  			</tr>
	  		</thead>
	  		<tbody>
	  			<c:forEach items="${requestScope.departmentEmployees}" var="employee">
	  			<tr class="gradeA">
	  				<td class="center">${employee.stringId}</td>
	  				<td class="center">${employee.name}</td>
	  				<td class="center">
	  					<c:if test="${employee.gender == 'M'}">男</c:if>
	  					<c:if test="${employee.gender == 'F'}">女</c:if>
	  				</td>
	  				<td class="center">${employee.phone }</td>
	  				<td class="center">${employee.email }</td>
	  				<td class="center">${employee.address }</td>
	  				<td class="center">${employee.birth }</td>
	  				<td class="center">
	  					<a href="employeeManage.do?action=showDetail&id=${employee.employeeId }">详细</a>
	  					<a href="employeeManage.do?action=prepareModify&id=${employee.employeeId }">修改</a>
	  					<a href="employeeManage.do?action=delete&id=${employee.employeeId }">删除</a>
	  				</td>
	  			</tr>
	  			</c:forEach>
	  		</tbody>
  		</table>
  	</div>
  	
  	<div class="modify_block" id="modifier">
  		<div class="table_header"><span>新员工信息</span></div>
  		<form action="employeeManage.do" method="post" id="addEmployeeForm">
  		<input type="hidden" name="action" value="addEmployee">
  		<table width="100%" class="add_info">
  			<tr>
                <th scope="col">姓名</th>
                <th scope="col">性别</th>
                <th scope="col">电话</th>
	  			<th scope="col">Email</th>
	  			<th scope="col">地址</th>
	  			<th scope="col">生日</th>
                <th scope="col">婚姻</th>
                <th scope="col">邮编</th>
                <th scope="col">兴趣</th>
            </tr>
            <tr>
                <td>
                    <input type="text" name="name" />
                </td>
                <td>
                    <input type="radio" name="gender" value="M"/><label>男</label>
                    <input type="radio" name="gender" value="F"/><label>女</label>
                </td>
                <td>
                    <input type="text" name="phone" />
                </td>
                <td>
                    <input type="text" name="email" />
                </td>
                <td>
                    <input type="text" name="address" />
                </td>
                <td>
                    <input type="text" name="birthday" id="birthInput"/>
                </td>
                <td>
                    <input type="radio" name="married" value="Y"/><label>已婚</label>
                    <input type="radio" name="married" value="N"/><label>未婚</label>
                </td>
                <td>
                    <input type="text" name="post" />
                </td>
                <td>
                    <textarea rows="2" name="hobby"></textarea>
				</td>
            </tr>
  		</table>
  		<div class="table_footer ui-helper-clearfix">
            <span>添加新员工信息</span>
            <a onclick="$('#addEmployeeForm')[0].submit();" class="btn_submit">提交</a>
        </div>
  		</form>
  	</div>
  	
  	<div class="spacer"></div>
  </body>
</html>
