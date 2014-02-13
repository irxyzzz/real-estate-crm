<%@ page language="java" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <link rel="stylesheet" type="text/css" href="../style/weatherfeed.css" />
	<link rel="stylesheet" type="text/css" href="../style/frame_func_front.css" />
	<script src="../js/weather_js/jquery.min.js" type="text/javascript"></script>
	<script src="../js/weather_js/jquery.zweatherfeed.min.js" type="text/javascript"></script>
	<script src="../js/indexContent.js" type="text/javascript"></script>
  </head>
  <body onload="resizeBoard()" onresize="resizeBoard()">
  	<div id="weather_panel"></div>
    <div id="newsboard_system">
    	<div class="btn_controller">
        <h3>系统公告</h3>
        	<c:if test="${sessionScope.currentUser == null}">
        	<c:if test="${sessionScope.admin != null}">
        	<a href="systemManage.do?action=showSysNotice"class="btn_submit">添&emsp;加</a>
        	</c:if>
        	</c:if>
        </div>
        <c:forEach items="${requestScope.systemNotices}" var="notice">
        	<div class="newsitem">
        		<a href="#">${notice.title}</a>
        		<c:if test="${sessionScope.currentUser == null}">
	        		<c:if test="${sessionScope.admin != null}">
	        		<a href="systemManage.do?action=delSysNotice&id=${notice.noticeId}">
	        		<img src="../style/image/btn_delete.png" width="23" height="23" class="btn_delete" 
	        			onclick="window.location.href=''" />
	        		</a>
	        		</c:if>
	        	</c:if>
        		<span class="newstime">${notice.time }</span>
        		<div class="newsdetail">
       		 		<p>${notice.content }</p>
       		 		<p>管理员 ${notice.author }&emsp; ${notice.time }</p>
       		 	</div>
        	</div>
        </c:forEach>
    </div>
    <div id="newsboard_company">
    	<div class="btn_controller">
        <h3>公司通知</h3>
        <c:if test="${sessionScope.currentUser.isManager == true}">
        	<a href="systemManage.do?action=noticeAdd"class="btn_submit">添&emsp;加</a> 
        </c:if>
        </div>
        <c:forEach items="${requestScope.companyNotices}" var="notice">
        	<div class="newsitem">
        		<a href="#">${notice.title}</a>
        		<c:if test="${sessionScope.currentUser.isManager == true}">
        			<img src="../style/image/btn_delete.png" width="23" height="23" class="btn_delete"
        				onclick="window.location.href='systemManage.do?action=delManNotice&id=${notice.noticeId}&name=${notice.author}'"  />
        		</c:if>
        		<span class="newstime">${notice.time }</span>
        		<div class="newsdetail">
       		 		<p>${notice.content }</p>
       		 		<p>${notice.author }&emsp;${notice.time }</p>
       		 	</div>
        	</div>
        </c:forEach>
    </div>
  </body>
</html>
