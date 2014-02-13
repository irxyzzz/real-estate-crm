<%@ page language="java" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>用户使用手册</title>
 
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
    <iframe id="func_content" src="help.jsp">
    </iframe>
  </body>
  <jsp:include page="footer.jsp"></jsp:include>
</html>
