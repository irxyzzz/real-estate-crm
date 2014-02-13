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
    <script type="text/javascript" src="../js/dataTables/jquery.dataTables.js"></script>
   	<script type="text/javascript" src="../js/customer_buy.js"></script>
  </head>
  <body>
  	<div class="table_block">
    <h3>所有房产信息</h3>
    <hr>
    <table id="houseTable" class="display" cellpadding="0" cellspacing="0" border="0" >
  		<thead>
  			<tr>
  				<th>编号</th>
  				<th>小区</th>
  				<th>面积</th>
  				<th>位置</th>
  				<th>价格</th>
  			</tr>
  		</thead>
  		<tbody>
  			<c:forEach items="${requestScope.houses}" var="house">
  			<tr class="gradeA">
  				<td class="center">${house.stringId}</td>
  				<td class="center">
  					<a href="showResidenceInfo.do?id=${house.residenceCommunity.residenceId }">${house.residenceCommunity.name}</a>
  				</td>
  				<td class="center">${house.area}</td>
  				<td class="center">${house.position}</td>
  				<td class="center">${house.price}</td>
  			</tr>
  			</c:forEach>
  		</tbody>
  		</table>
  	<br/>	
  	<br/>	
    <h3>购买房屋登记</h3>
    <hr>
    <form action="customerManage.do" method="post" id="customerBuyForm">
    	<c:set value="${requestScope.customer}" var="customer"></c:set>
		<input type="hidden" name="action" value="customerBuy">
		<input type="hidden" name="customerId" value="${customer.customerId }"/>
		<table>
		  <tr>
		    <th>客户姓名</th>
		    <td><input type="text" name="name" value="${customer.name }" disabled="disabled"/></td>
		  </tr>  
		  <tr>
		    <th>性别</th>
		    <td>
		    	<c:if test="${customer.gender == 'M'}">
		    	<input type="radio" name="gender" value="M" checked="checked" disabled="disabled"/><label>男</label>
		    	<input type="radio" name="gender" value="F" disabled="disabled"/><label>女</label>
		    	</c:if>
		    	<c:if test="${customer.gender == 'F'}">
		    	<input type="radio" name="gender" value="M" disabled="disabled"/><label>男</label>
		    	<input type="radio" name="gender" value="F" checked="checked"/><label>女</label>
		    	</c:if>
		    </td>
		  </tr>
		  <tr>
		    <th>地址</th>
		    <td>
		    	<input type="text" name="address" value="${customer.address }" disabled="disabled"/>
		    </td>
		  </tr>
		  <tr>
		    <th>电话</th>
		    <td>
		    	<input type="text" name="phone" value="${customer.phone }" disabled="disabled"/>
		    </td>
		  </tr>
		  <tr>
		    <th>Email</th>
		    <td>
		    	<input type="text" name="email" value="${customer.email }" disabled="disabled"/>
		    </td>
		  </tr>
		  <tr>
		    <th>购房意向</th>
		    <td>
		    	<input type="text" name="intent" value="${customer.houseIntent }" disabled="disabled"/>
		    </td>
		  </tr>
		  <tr>
		    <th>工作</th>
		    <td>
		    	<input type="text" name="job" value="${customer.job }" disabled="disabled"/>
		    </td>
		  </tr>
		  <tr>
		  	<th>房屋编号</th>
		  	<td>
		  		<input type="text" name="houseId" maxlength="6"/>
		  	</td>
		  </tr>
		  <tr>
		  	<th></th>
		  	<td><br/></td>
		  </tr>
		  <tr>
		  	<th></th>
		  	<td>
		  		<a class="btn_submit" onclick="$('#customerBuyForm')[0].submit();" class="btn_submit" id="add_reset">提&emsp;交</a>
		  	</td>
		  </tr>
		</table>
		
    </form>
    </div>
  
	
  </body>
</html>
