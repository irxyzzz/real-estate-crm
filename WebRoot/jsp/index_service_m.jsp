<%@ page language="java" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>售后主管主页</title>
    
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
        <div class="title">我的员工</div>
        <div class="content">
            <h4>管理售后部门员工</h4>
            <p><a href="#" onclick="document.getElementById('func_content').contentWindow.location.href='employeeManage.do?action=show'">部门员工信息</a></p>
        </div>
        
        <div class="title">我的客户</div>
        <div class="content">
            <h4>管理分析我的客户信息</h4>
            <p><a href="#" onclick="document.getElementById('func_content').contentWindow.location.href='customerManage.do?action=showall'">客户信息</a></p>
            <p><a href="#" onclick="document.getElementById('func_content').contentWindow.location.href='customerManage.do?action=manageFix'">客户报修记录</a></p>
            <p><a href="#" onclick="document.getElementById('func_content').contentWindow.location.href='customerManage.do?action=manageFeedback'">客户反馈信息</a></p>
            <p><a href="#" onclick="document.getElementById('func_content').contentWindow.location.href='customerManage.do?action=careManage'">客户关怀信计划</a></p>
            <p><a href="#" onclick="document.getElementById('func_content').contentWindow.location.href='analysisManage.do?action=fixAll'">客户报修信息分析</a></p>
            <p><a href="#" onclick="document.getElementById('func_content').contentWindow.location.href='analysisManage.do?action=feedbackAll'">客户反馈信息分析</a></p>
        </div>
        
        <div class="title">部门任务</div>
        <div class="content">
            <h4>管理售后部门员工任务</h4>
            <p><a href="#" onclick="document.getElementById('func_content').contentWindow.location.href='assignment.do?action=showManage'">售后部门任务管理</a></p>
		</div>
    </div>
    <!--Menu: End!-->

    <!--Panel: Begin!-->
    <iframe id="func_content" src="${requestScope.content}">
    </iframe>
  </body>
  <jsp:include page="footer.jsp"></jsp:include>
</html>
