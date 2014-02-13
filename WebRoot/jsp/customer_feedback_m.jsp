<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <link rel="stylesheet" type="text/css"  href="../style/table_jui.css" />
  <link rel="stylesheet" type="text/css"  href="../style/jquery-ui-1.7.2.custom.css" />
  <link rel="stylesheet" type="text/css"  href="../style/customer_feedback.css" />
  <script type="text/javascript" src="../js/jquery-1.3.2.min.js"></script>
  <script type="text/javascript" src="../js/dataTables/jquery.dataTables.js"></script>
  <script type="text/javascript" src="../js/feedback.js" ></script>
</head>
  <body>
  	<div class="table_block">
    <h3>客户反馈信息</h3>
    <hr>
    <span>${requestScope.errorMsg }</span>
  	<table id="feedbackTable" cellpadding="0" cellspacing="0" border="0" >
      <thead>
        <tr align="center">
		  <th>编号</th>
		  <th>客户编号</th>
		  <th>客户姓名</th>
		  <th>员工</th>
	  	  <th>员工评分</th>
	  	  <th>小区环境</th>
	  	  <th>小区物业</th>
	  	  <th>交通情况</th>
	  	  <th>总体</th>
	      <th>建议</th>
	      <th>时间</th>
	      <th>选项</th>
	    </tr>
      </thead>
      <tbody>
		<c:forEach items="${requestScope.customerFeedbacks}" var="CustomerFeedback">
	  	  <tr align="center">
	        <td>${CustomerFeedback.customerFeedbackId}</td>
	    	<td>${CustomerFeedback.customer.customerId}</td>
	    	<td>${CustomerFeedback.customer.name}</td>
	    	<td>${CustomerFeedback.employee.name}</td>
	    	<td>
			  <c:if test="${CustomerFeedback.markSeller == 1}">60以下</c:if>
			  <c:if test="${CustomerFeedback.markSeller == 2}">60~70</c:if>
			  <c:if test="${CustomerFeedback.markSeller == 3}">70~80</c:if>
			  <c:if test="${CustomerFeedback.markSeller == 4}">80~90</c:if>
			  <c:if test="${CustomerFeedback.markSeller == 5}">90~100</c:if>
			  <c:if test="${CustomerFeedback.markSeller < 1}">error</c:if>
			  <c:if test="${CustomerFeedback.markSeller > 5}">error</c:if> </td>
	    	<td>
			  <c:if test="${CustomerFeedback.markEnvironment == 1}">60以下</c:if>
			  <c:if test="${CustomerFeedback.markEnvironment == 2}">60~70</c:if>
			  <c:if test="${CustomerFeedback.markEnvironment == 3}">70~80</c:if>
			  <c:if test="${CustomerFeedback.markEnvironment == 4}">80~90</c:if>
			  <c:if test="${CustomerFeedback.markEnvironment == 5}">90~100</c:if>
			  <c:if test="${CustomerFeedback.markEnvironment < 1}">error</c:if>
			  <c:if test="${CustomerFeedback.markEnvironment > 5}">error</c:if> </td>
	   		<td>
			  <c:if test="${CustomerFeedback.markTenement == 1}">60以下</c:if>
			  <c:if test="${CustomerFeedback.markTenement == 2}">60~70</c:if>
			  <c:if test="${CustomerFeedback.markTenement == 3}">70~80</c:if>
			  <c:if test="${CustomerFeedback.markTenement == 4}">80~90</c:if>
			  <c:if test="${CustomerFeedback.markTenement == 5}">90~100</c:if>
			  <c:if test="${CustomerFeedback.markTenement < 1}">error</c:if>
			  <c:if test="${CustomerFeedback.markTenement > 5}">error</c:if> </td>
	    	<td>
			  <c:if test="${CustomerFeedback.markTraffic == 1}">60以下</c:if>
			  <c:if test="${CustomerFeedback.markTraffic == 2}">60~70</c:if>
			  <c:if test="${CustomerFeedback.markTraffic == 3}">70~80</c:if>
			  <c:if test="${CustomerFeedback.markTraffic == 4}">80~90</c:if>
			  <c:if test="${CustomerFeedback.markTraffic == 5}">90~100</c:if>
			  <c:if test="${CustomerFeedback.markTraffic < 1}">error</c:if>
			  <c:if test="${CustomerFeedback.markTraffic > 5}">error</c:if> </td>
	    	<td>
			  <c:if test="${CustomerFeedback.markAll == 1}">60以下</c:if>
			  <c:if test="${CustomerFeedback.markAll == 2}">60~70</c:if>
			  <c:if test="${CustomerFeedback.markAll == 3}">70~80</c:if>
			  <c:if test="${CustomerFeedback.markAll == 4}">80~90</c:if>
			  <c:if test="${CustomerFeedback.markAll == 5}">90~100</c:if>
			  <c:if test="${CustomerFeedback.markAll < 1}">error</c:if>
			  <c:if test="${CustomerFeedback.markAll > 5}">error</c:if> </td>
	    	<td>${CustomerFeedback.adviceSeller}</td>
	    	<td>${CustomerFeedback.time}</td>
	    	<td>
	    		<a href="customerManage.do?action=deleteFeedback&id=${CustomerFeedback.customerFeedbackId}">删除</a>
			</td>
	  	  </tr>
        </c:forEach>
      </tbody>
    </table>
    </div>
</body>
</html>