<%@ page language="java" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>市场人员主页</title>
    
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
        <div class="title">我的客户</div>
        <div class="content">
            <h4>管理各类客户信息查询</h4>
            <p><a href="#" onclick="document.getElementById('func_content').contentWindow.location.href='customerManage.do?action=showall'">客户信息查询</a></p>
        </div>
        
         <div class="title">竞争对手</div>
        <div class="content">
            <h4>管理员权限竞争对手信息管理</h4>
            <p><a href="#" onclick="document.getElementById('func_content').contentWindow.location.href='competitorManage.do?action=showall'">市场竞争信息</a></p>
            <p><a href="#" onclick="document.getElementById('func_content').contentWindow.location.href='competitorManage.do?action=companyShow'">竞争公司信息</a></p>
            <p><a href="#" onclick="document.getElementById('func_content').contentWindow.location.href='competitorManage.do?action=residenceShow'">竞争项目小区信息</a></p>
		</div>
        
        <div class="title">我的任务</div>
        <div class="content">
            <h4>查询自己的任务</h4>
            <p><a href="#" onclick="document.getElementById('func_content').contentWindow.location.href='assignment.do?action=show'">市场部任务查询</a></p>
		</div>
    </div>
    <!--Menu: End!-->
    
  	<!--Panel: Begin!-->
    <iframe id="func_content" src="${requestScope.content}">
    </iframe>
  </body>
  <jsp:include page="footer.jsp"></jsp:include>
</html>
