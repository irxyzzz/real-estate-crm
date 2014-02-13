<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>错误页面</title>
	<link rel="stylesheet" type="text/css" href="../style/error_master.css"/>
	<script language="javascript">
		function relocateContent() {
			var availHeight = window.innerHeight-98;
			var contentHeight = document.getElementById('content').clientHeight;
			var availWidth = window.innerWidth;
			var contentWidth = document.getElementById('content').clientWidth;
			if(availHeight <= contentHeight) {
				document.getElementById('content').style.top = 49+'px';
			} else {
				document.getElementById('content').style.top = 49+((availHeight-contentHeight)/2)+'px';
			}
			if(availWidth <= 790) {
				document.getElementById('content').style.left = 0+'px';
			} else  {
				document.getElementById('content').style.left = ((availWidth-contentWidth)/2)+'px';
			}
		}
	</script>
  </head>
  
  <body onload="relocateContent();">
    <div id="content">
    	<h3>Sorry,你请求的资源不存在</h3>
    	<hr />
    	<img width="600" height="420" src="../style/image/404Error.png" />
	</div>
  </body>
</html>
