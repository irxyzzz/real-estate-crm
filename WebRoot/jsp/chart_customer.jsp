<%@ page language="java" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<link rel="stylesheet" href="../style/jquery-ui.css" />
    <script type="text/javascript" src="../js/jquery-1.3.2.min.js"></script>
    <script type="text/javascript" src="../js/jquery-ui-1.7.2.custom.min.js"></script>
    <script type="text/javascript" src="../js/jscharts_mb.js"></script>
    <script type="text/javascript" src="../js/chart_customer.js" ></script>
  </head>
  <body>
  
  <div class="table_block">
  	<div id="jQueryUIAccordion">

        <h3><a href="#">客户收入分布</a></h3>
        <div id="incomeContainer">${income}</div>
        
        <h3><a href="#">客户职业分布</a></h3>
        <div id="jobContainer">${job}</div>
        
        <h3><a href="#">客户年龄分布</a></h3>
        <div id="ageContainer">${age}</div>
        
        <h3><a href="#">客户爱好分布</a></h3>
        <div id="hobbyContainer">${hobby}</div>
        
        <h3><a href="#">客户性别分布</a></h3>
  		<div id="genderContainer">${gender}</div>
        
        <h3><a href="#">客户婚姻分布</a></h3>
        <div id="marryContainer">${marry}</div>
 
    </div>
  </div>
  </body>
</html>
