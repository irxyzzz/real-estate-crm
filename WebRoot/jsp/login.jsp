<%@ page language="java" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>登录页面</title>
    <link href="../style/login_content.css" rel="stylesheet" type="text/css" />
    <link href="../style/header.css" rel="stylesheet" type="text/css" />
    <link href="../style/footer.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="../js/login/jquery.tab.js"></script>
	<script type="text/javascript" src="../js/login/jquery.label.js"></script>
	<script type="text/javascript" src="../js/login/jquery.featureList.js"></script>
	<script type="text/javascript" src="../js/login/jquery.slidinglabel.js"></script>
	<script type="text/javascript" src="../js/login/login.js"></script>
  </head>
  <jsp:include page="header.jsp"></jsp:include>
  <body onload="relocateContent();" onresize="relocateContent();">
    <div id="content">
		<h1>欢迎使用房产客户关系管理系统</h1>
		<p>请先登录，或点击&nbsp;<a href="help_container.jsp" target="_blank">这里</a>&nbsp;查看帮助文档</p>
		<hr>
		<div id="feature_list">
			<ul id="tabs">
				<li>
					<a href="javascript:;" class="">
						<img src="../style/image/login/icon_login.png">
						<h3>用户登录</h3>
						<span>新用户请先注册</span>
					</a>
				</li>
				<li>
					<a href="javascript:;" class="">
						<img src="../style/image/login/icon_funcInfo.png">
						<h3>软件介绍</h3>
						<span>房产CRM功能概况</span>
					</a>
				</li>
				<li>
					<a href="javascript:;" class="">
						<img src="../style/image/login/icon_usingFeel.png">
						<h3>使用体验</h3>
						<span>电子办公带来的全新体验</span>
					</a>
				</li>
			</ul>
			<ul id="output">
				<li id="login_tab_output">
                	<form action="login.do" method="post" id="login"> 
                		<div>${errorMsg }</div>
                        <div id="username" class="slider"> 
                            <label for="username">账&nbsp;&nbsp;号</label> 
                            <input type="text" id="name" name="account"> 
                        </div>
                        <div id="password" class="slider"> 
                            <label for="password">密&nbsp;&nbsp;码</label> 
                            <input type="password" id="pass" name="password"> 
                        </div>
                        <button class="btn_submit" onclick="this.form.submit();">确&emsp;认</button>
                        <input type="checkbox" id="admin_check" name="isAdmin"/><label for="admin_check">管理员</label>
                    </form>
					<a class="corner_link" href="#">密码找回</a>
				</li>
				<li style="display: list-item; opacity: 1;">
					<img src="../style/image/login/sample2.jpg">
					<a class="corner_link" href="#">详细信息</a>
				</li>
				<li style="display: list-item; opacity: 1;">
					<img src="../style/image/login/sample3.jpg">
					<a class="corner_link" href="#">详细信息</a>
				</li>
			</ul>
		</div>
	</div>
  </body>
  <jsp:include page="footer.jsp"></jsp:include>
</html>
