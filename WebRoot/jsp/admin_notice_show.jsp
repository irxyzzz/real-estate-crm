<%@ page language="java" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<link rel="stylesheet" type="text/css"  href="../style/table_jui.css" />
    <link rel="stylesheet" type="text/css"  href="../style/jquery-ui-1.7.2.custom.css" />
    <link rel="stylesheet" type="text/css"  href="../style/customer_show.css" />
    <link rel="stylesheet" type="text/css" href="../style/SpryTabbedPanels.css" />
    <script type="text/javascript" src="../js/jquery-1.3.2.min.js"></script>
    <script type="text/javascript" src="../js/dataTables/jquery.dataTables.js"></script>
    <script type="text/javascript" src="../js/tabPanel/SpryTabbedPanels.js"></script>
    <script type="text/javascript" src="../js/customer_show.js" ></script>
  </head>
  <body>
	<div id="TabbedPanels" class="TabbedPanels">
		<ul class="TabbedPanelsTabGroup">
		    <li class="TabbedPanelsTab" id="tab_left">系统通知</li>
		    <li class="TabbedPanelsTab" id="tab_right">公司通知</li>
	    </ul>
	    <div class="TabbedPanelsContentGroup">
	    	<div class="TabbedPanelsContent">
	    		<div class="btn_controller">
                    <span>${requestScope.errorMsg }</span>
                </div>
                <table class="display" id="inCustomerTable" cellpadding="0" cellspacing="0" border="0" >
  					<thead>
			  			<tr>
			  				<th>编号</th>
			  				<th>标题</th>
			  				<th>内容</th>
			  				<th>作者</th>
			  				<th>时间</th>
			  				<th>选项</th>
			  			</tr>
	  				</thead>
			  		<tbody>
			  			<c:forEach items="${requestScope.sysNotice}" var="notice">
			  			<tr class="gradeA">
			  				<td class="center">${notice.stringId}</td>
			  				<td class="center">${notice.title}</td>
			  				<td class="center">${notice.content }</td>
			  				<td class="center">${notice.author}</td>
			  				<td class="center">${notice.formatTime }</td>
			  				<td class="center">
			  					<a href="systemManage.do?action=del&id=${notice.noticeId }">删除</a>
							</td>
			  			</tr>
			  			</c:forEach>
			  		</tbody>
  				</table>
	    	</div>
	    
	    	<div class="TabbedPanelsContent">
	    		<div class="btn_controller">
                    <span>${requestScope.errorMsg }</span>
                </div>
                <table class="display" id="alCustomerTable" cellpadding="0" cellspacing="0" border="0" >
  					<thead>
			  			<tr>
			  				<th>编号</th>
			  				<th>标题</th>
			  				<th>内容</th>
			  				<th>作者</th>
			  				<th>时间</th>
			  				<th>选项</th>
			  			</tr>
	  				</thead>
			  		<tbody>
			  			<c:forEach items="${requestScope.manNotice}" var="notice">
			  			<tr class="gradeA">
			  				<td class="center">${notice.stringId}</td>
			  				<td class="center">${notice.title}</td>
			  				<td class="center">${notice.content }</td>
			  				<td class="center">${notice.author}</td>
			  				<td class="center">${notice.formatTime }</td>
			  				<td class="center">
			  					<a href="systemManage.do?action=del&id=${notice.noticeId }">删除</a>
							</td>
			  			</tr>
			  			</c:forEach>
			  		</tbody>
			  	</table>
	    	</div>
	    </div>
  	</div>
  	
  	
  	<div class="modify_block" id="modifier">
  		<div class="table_header"><span>新系统信息</span></div>
  		<form action="systemManage.do" method="post" id="addNoticeForm">
  		<input type="hidden" name="action" value="add">
  		<table width="100%" class="add_info">
  			<tr>
                <th scope="col">标题</th>
                <th scope="col">内容</th>
            </tr>
            <tr>
                <td>
                    <input type="text" name="title" maxlength="20"/>
                </td>
                <td>
                    <textarea rows="2" cols="60" name="content"></textarea>
				</td>
            </tr>
  		</table>
  		<div class="table_footer ui-helper-clearfix">
            <span>添加新系统信息</span>
            <a onclick="$('#addNoticeForm')[0].submit();" class="btn_submit">提交</a>
        </div>
  		</form>
  	</div>
  </body>
</html>
