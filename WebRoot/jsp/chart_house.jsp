<%@ page language="java" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<link rel="stylesheet" href="../style/jquery-ui.css" />
    <script type="text/javascript" src="../js/jquery-1.3.2.min.js"></script>
    <script type="text/javascript" src="../js/jquery-ui-1.7.2.custom.min.js"></script>
    <script type="text/javascript" src="../js/jscharts_mb.js"></script>
    <script type="text/javascript" src="../js/chart_house.js" ></script>
  </head>
  <body>
  
  <div class="table_block">
  	<div id="jQueryUIAccordion">
  		<h3><a href="#">房屋年度销售分布</a></h3>
  		<div id="monthContainer">${month}</div>
        
        <h3><a href="#">客户选购房屋价格分布</a></h3>
        <div id="priceContainer">${price}</div>
        
        <h3><a href="#">客户选购房屋面积分布</a></h3>
        <div id="areaContainer">${area}</div>
    </div>
  </div>
  </body>
</html>
