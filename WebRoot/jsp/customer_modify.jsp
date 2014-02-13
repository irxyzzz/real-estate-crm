<%@ page language="java" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<link rel="stylesheet" type="text/css"  href="../style/table_jui.css" />
    <link rel="stylesheet" type="text/css"  href="../style/jquery-ui-1.7.2.custom.css" />
    <script type="text/javascript" src="../js/jquery-1.3.2.min.js"></script>
    <script type="text/javascript" src="../js/jquery-ui-1.7.2.custom.min.js"></script>
    <script type="text/javascript" src="../js/customer_add.js"></script>
  </head>
  <body>
  	<div class="table_block">
    <h3>修改客户信息</h3>
    <hr>
    <form action="customerManage.do" method="post" id="modifyCustomerForm">
    	<c:set value="${requestScope.customer}" var="customer"></c:set>
		<input type="hidden" name="action" value="modifyCustomer">
		<input type="hidden" name="customerId" value="${customer.customerId }"/>
		<table>
		  <tr>
		    <td>客户姓名</td>
		    <td><input type="text" name="name" value="${customer.name }" maxlength="5"/></td>
		  </tr>  
		  <tr>
		    <td>性别</td>
		    <td>
		    	<c:if test="${customer.gender == 'M'}">
		    	<input type="radio" name="gender" value="M" checked="checked"/><label>男</label>
		    	<input type="radio" name="gender" value="F" /><label>女</label>
		    	</c:if>
		    	<c:if test="${customer.gender == 'F'}">
		    	<input type="radio" name="gender" value="M" /><label>男</label>
		    	<input type="radio" name="gender" value="F" checked="checked"/><label>女</label>
		    	</c:if>
		    </td>
		  </tr>
		  <tr>
		    <td>生日</td>
		    <td>
		    	<input type="text" name="birthday" id="birthInput" value="${customer.birth }"/>
		    </td>
		  </tr>
		  <tr>
		    <td>地址</td>
		    <td>
		    	<input type="text" name="address" value="${customer.address }" maxlength="50"/>
		    </td>
		  </tr>
		  <tr>
		    <td>婚姻</td>
		    <td>
		    	<c:if test="${customer.isMarried == false}">
		    	<input type="radio" name="married" value="N" checked="checked"/><label>未婚</label>
		    	<input type="radio" name="married" value="Y" /><label>已婚</label>
		    	</c:if>
		    	<c:if test="${customer.isMarried == true}">
		    	<input type="radio" name="married" value="N" /><label>未婚</label>
		    	<input type="radio" name="married" value="Y" checked="checked"/><label>已婚</label>
		    	</c:if>
		    </td>
		  </tr>
		  <tr>
		    <td>电话</td>
		    <td>
		    	<input type="text" name="phone" value="${customer.phone }" maxlength="15"/>
		    </td>
		  </tr>
		  <tr>
		    <td>Email</td>
		    <td>
		    	<input type="text" name="email" value="${customer.email }" maxlength="30"/>
		    </td>
		  </tr>
		  <tr>
		  <c:if test="${customer.hasHouse == false}">
		    <td>购房意向</td>
		    <td>
		    	<input type="text" name="intent" value="${customer.houseIntent }" maxlength="20"/>
		    </td>
		   </c:if>
		   <c:if test="${customer.hasHouse == true}">
		   	<td>房屋编号</td>
		    <td>
		    	<input type="text" name="intent" value="${customer.houseId }" maxlength="6"/>
		    </td>
		   </c:if>
		  </tr>
		  <tr>
		    <td>收入(月)</td>
		    <td>
		    	<c:if test="${customer.income == 'Level 1'}">
			    	<input type="radio" name="income" value="Level 1" checked="checked"/><label>2000以下</label>
			    	<input type="radio" name="income" value="Level 2" /><label>2000~3000</label>
			    	<input type="radio" name="income" value="Level 3" /><label>3000~4000</label>
			    	<input type="radio" name="income" value="Level 4" /><label>4000~5000</label>
			    	<br />
			    	<input type="radio" name="income" value="Level 5" /><label>5000~6000</label>
			    	<input type="radio" name="income" value="Level 6" /><label>6000~7000</label>
			    	<input type="radio" name="income" value="Level 7" /><label>7000~8000</label>
			    	<input type="radio" name="income" value="Level 8" /><label>8000以上</label>
		    	</c:if>
		    	<c:if test="${customer.income == 'Level 2'}">
			    	<input type="radio" name="income" value="Level 1" /><label>2000以下</label>
			    	<input type="radio" name="income" value="Level 2" checked="checked"/><label>2000~3000</label>
			    	<input type="radio" name="income" value="Level 3" /><label>3000~4000</label>
			    	<input type="radio" name="income" value="Level 4" /><label>4000~5000</label>
			    	<br />
			    	<input type="radio" name="income" value="Level 5" /><label>5000~6000</label>
			    	<input type="radio" name="income" value="Level 6" /><label>6000~7000</label>
			    	<input type="radio" name="income" value="Level 7" /><label>7000~8000</label>
			    	<input type="radio" name="income" value="Level 8" /><label>8000以上</label>
		    	</c:if>
		    	<c:if test="${customer.income == 'Level 3'}">
			    	<input type="radio" name="income" value="Level 1" /><label>2000以下</label>
			    	<input type="radio" name="income" value="Level 2" /><label>2000~3000</label>
			    	<input type="radio" name="income" value="Level 3" checked="checked"/><label>3000~4000</label>
			    	<input type="radio" name="income" value="Level 4" /><label>4000~5000</label>
			    	<br />
			    	<input type="radio" name="income" value="Level 5" /><label>5000~6000</label>
			    	<input type="radio" name="income" value="Level 6" /><label>6000~7000</label>
			    	<input type="radio" name="income" value="Level 7" /><label>7000~8000</label>
			    	<input type="radio" name="income" value="Level 8" /><label>8000以上</label>
		    	</c:if>
		    	<c:if test="${customer.income == 'Level 4'}">
			    	<input type="radio" name="income" value="Level 1" /><label>2000以下</label>
			    	<input type="radio" name="income" value="Level 2" /><label>2000~3000</label>
			    	<input type="radio" name="income" value="Level 3" /><label>3000~4000</label>
			    	<input type="radio" name="income" value="Level 4" checked="checked"/><label>4000~5000</label>
			    	<br />
			    	<input type="radio" name="income" value="Level 5" /><label>5000~6000</label>
			    	<input type="radio" name="income" value="Level 6" /><label>6000~7000</label>
			    	<input type="radio" name="income" value="Level 7" /><label>7000~8000</label>
			    	<input type="radio" name="income" value="Level 8" /><label>8000以上</label>
		    	</c:if>
		    	<c:if test="${customer.income == 'Level 5'}">
			    	<input type="radio" name="income" value="Level 1" /><label>2000以下</label>
			    	<input type="radio" name="income" value="Level 2" /><label>2000~3000</label>
			    	<input type="radio" name="income" value="Level 3" /><label>3000~4000</label>
			    	<input type="radio" name="income" value="Level 4" /><label>4000~5000</label>
			    	<br />
			    	<input type="radio" name="income" value="Level 5" checked="checked"/><label>5000~6000</label>
			    	<input type="radio" name="income" value="Level 6" /><label>6000~7000</label>
			    	<input type="radio" name="income" value="Level 7" /><label>7000~8000</label>
			    	<input type="radio" name="income" value="Level 8" /><label>8000以上</label>
		    	</c:if>
		    	<c:if test="${customer.income == 'Level 6'}">
			    	<input type="radio" name="income" value="Level 1" /><label>2000以下</label>
			    	<input type="radio" name="income" value="Level 2" /><label>2000~3000</label>
			    	<input type="radio" name="income" value="Level 3" /><label>3000~4000</label>
			    	<input type="radio" name="income" value="Level 4" /><label>4000~5000</label>
			    	<br />
			    	<input type="radio" name="income" value="Level 5" /><label>5000~6000</label>
			    	<input type="radio" name="income" value="Level 6" checked="checked"/><label>6000~7000</label>
			    	<input type="radio" name="income" value="Level 7" /><label>7000~8000</label>
			    	<input type="radio" name="income" value="Level 8" /><label>8000以上</label>
		    	</c:if>
		    	<c:if test="${customer.income == 'Level 7'}">
			    	<input type="radio" name="income" value="Level 1" /><label>2000以下</label>
			    	<input type="radio" name="income" value="Level 2" /><label>2000~3000</label>
			    	<input type="radio" name="income" value="Level 3" /><label>3000~4000</label>
			    	<input type="radio" name="income" value="Level 4" /><label>4000~5000</label>
			    	<br />
			    	<input type="radio" name="income" value="Level 5" /><label>5000~6000</label>
			    	<input type="radio" name="income" value="Level 6" /><label>6000~7000</label>
			    	<input type="radio" name="income" value="Level 7" checked="checked"/><label>7000~8000</label>
			    	<input type="radio" name="income" value="Level 8" /><label>8000以上</label>
		    	</c:if>
		    	<c:if test="${customer.income == 'Level 8'}">
			    	<input type="radio" name="income" value="Level 1" /><label>2000以下</label>
			    	<input type="radio" name="income" value="Level 2" /><label>2000~3000</label>
			    	<input type="radio" name="income" value="Level 3" /><label>3000~4000</label>
			    	<input type="radio" name="income" value="Level 4" /><label>4000~5000</label>
			    	<br />
			    	<input type="radio" name="income" value="Level 5" /><label>5000~6000</label>
			    	<input type="radio" name="income" value="Level 6" /><label>6000~7000</label>
			    	<input type="radio" name="income" value="Level 7" /><label>7000~8000</label>
			    	<input type="radio" name="income" value="Level 8" checked="checked"/><label>8000以上</label>
		    	</c:if>
		    </td>
		  </tr>
		  <tr>
		    <td>工作</td>
		    <td>
		    	<input type="text" name="job" value="${customer.job }" maxlength="10"/>
		    </td>
		  </tr>
		  <tr>
		    <td>兴趣</td>
		    <td>
		    	<textarea rows="3" cols="50" name="hobby"/> ${customer.hobby }</textarea>
		    </td>
		  </tr>
		</table>
		<a onclick="$('#modifyCustomerForm')[0].submit();" class="btn_submit" id="add_reset">提交</a>
    </form>
    </div>
  
	
  </body>
</html>
