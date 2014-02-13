<%@ page language="java" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<title>管理员主页</title>
  	
  	<link rel="stylesheet" type="text/css" href="../style/main_frame.css">
    <link rel="stylesheet" type="text/css" href="../style/header.css" />
    <link rel="stylesheet" type="text/css" href="../style/footer.css" />
    <script type="text/javascript" src="../js/menu_accord/moo.1.2.core.js"></script>
    <script type="text/javascript" src="../js/menu_accord/moo.1.2.more.js"></script>
    <script type="text/javascript" src="../js/menu_accord/accord.js"></script>
    <script type="text/javascript" src="../js/index.js"></script>
  </head>
  <jsp:include page="header.jsp"></jsp:include>
  <body onload="resizeFrame()" onresize="resizeFrame()">
  	<!--Menu: Begin!-->
	<div id="accordion">
        <div class="title">员工管理</div>
        <div class="content">
            <h4>管理员权限员工管理</h4>
            <p><a href="#" onclick="document.getElementById('func_content').contentWindow.location.href='employeeManage.do?action=adminEmployeeShow'">所有员工信息</a></p>
        </div>
        
        
        <div class="title">系统管理</div>
        <div class="content">
            <h4>管理员权限系统信息管理</h4>
            <p><a href="#" onclick="document.getElementById('func_content').contentWindow.location.href='systemManage.do?action=showSysNotice'">系统公告</a></p>
		</div>
		

    </div>
    <!--Menu: End!-->

    <!--Panel: Begin!-->
    <iframe id="func_content" src="index.do">
    </iframe>
    <!--Panel: End!-->
  </body>
  <jsp:include page="footer.jsp"></jsp:include>
</html>
