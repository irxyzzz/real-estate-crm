<%@ page language="java" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<link rel="stylesheet" href="../style/jquery-ui.css" />
    <script type="text/javascript" src="../js/jquery-1.3.2.min.js"></script>
    <script type="text/javascript" src="../js/jquery-ui-1.7.2.custom.min.js"></script>
    <script type="text/javascript" src="../js/jscharts_mb.js"></script>
    <script type="text/javascript" src="../js/chart_feedback.js" ></script>
  </head>
  <body>
  
  <div class="table_block">
  	<div id="jQueryUIAccordion">

        <h3><a href="#">客户反馈总体评价分布</a></h3>
        <div id="allContainer">${all}</div>
        
        <h3><a href="#">客户反馈小区环境评价分布</a></h3>
        <div id="environmentContainer">${environment}</div>
        
        <h3><a href="#">客户反馈小区物业评价分布</a></h3>
        <div id="tenementContainer">${tenement}</div>
        
        <h3><a href="#">客户反馈周边交通评价分布</a></h3>
        <div id="trafficContainer">${traffic}</div>
        
        <h3><a href="#">客户反馈销售部门评价分布</a></h3>
  		<div id="saleContainer">${sale}</div>
        
        <h3><a href="#">客户反馈销售员工评价分布</a></h3>
        <div id="indSaleContainer">${indSale}</div>
 
    </div>
  </div>
  </body>
</html>
