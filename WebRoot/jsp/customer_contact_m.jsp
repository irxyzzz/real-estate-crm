<%@ page language="java" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<link rel="stylesheet" type="text/css"  href="../style/table_jui.css" />
    <link rel="stylesheet" type="text/css"  href="../style/jquery-ui-1.7.2.custom.css" />
    <link rel="stylesheet" type="text/css"  href="../style/customer_contact.css">
    <script type="text/javascript" src="../js/jquery-1.3.2.min.js"></script>
    <script type="text/javascript" src="../js/dataTables/jquery.dataTables.js"></script>
    <script type="text/javascript" src="../js/customer_contact_m.js" ></script>
  </head>
  <body>
  	<div class="table_block">
  		<h3>联系记录</h3>
        <hr>
           <span>${requestScope.errorMsg }</span>
        <table id="contactTable" cellpadding="0" cellspacing="0" border="0" >
	  		<thead>
	  			<tr>
	  				<th>编号</th>
	  				<th>客户</th>
	  				<th>内容</th>
	  				<th>回复</th>
	  				<th>联系时间</th>
	  				<th>选项</th>
	  			</tr>
	  		</thead>
	  		<tbody>
	  			<c:forEach items="${requestScope.css}" var="cs">
	  			<tr class="gradeA">
	  				<td class="center">${cs.stringId}</td>
	  				<td class="center">${cs.customer.name}</td>
	  				<td class="center">${cs.content}</td>
	  				<td class="center">${cs.reply }</td>
	  				<td class="center">${cs.time}</td>
	  				<td class="center"><a href="customerManage.do?action=delContact&id=${cs.customerSupportId }">删除</a></td>
	  			</tr>
	  			</c:forEach>
	  		</tbody>
  		</table>
  	</div>
  	
  	<div class="modify_block" id="modifier">
  		<div class="table_header"><span>添加新联系记录</span></div>
  		<form action="customerManage.do" method="post">
  		<input type="hidden" name="action" value="addContact">
  		<table width="100%" class="add_info">
  			<tr>
                <th scope="col">客户</th>
                <th scope="col">内容</th>
                <th scope="col">回复</th>
            </tr>
            <tr>
                <td>
                    <select name="customerId">
  					<c:forEach items="${requestScope.myCustomers}" var="customer">
  						<option value="${customer.customerId }">${customer.name }</option>
  					</c:forEach>
  					</select>
                </td>
                <td>
                    <textarea rows="2" cols="50" name="content"></textarea>
                </td>
                <td>
                    <textarea rows="2" cols="50" name="reply"></textarea>
				</td>
            </tr>
  		</table>
  		<div class="table_footer ui-helper-clearfix">
            <span>添加单项回复</span>
            <a onclick="this.form.submit();" class="btn_submit" id="add_reset">提交</a>
        </div>
  		</form>
  	</div>
  	
  	<div class="spacer"></div>
  </body>
</html>
