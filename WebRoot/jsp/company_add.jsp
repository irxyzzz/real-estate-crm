<%@ page language="java" import="java.util.*, com.crm.model.Competitor"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="../style/table_jui.css" />
		<link rel="stylesheet" type="text/css" href="../style/jquery-ui-1.7.2.custom.css" />
		<link rel="stylesheet" type="text/css" href="../style/button.css" />
		<script type="text/javascript" src="../js/jquery-1.3.2.min.js"></script>
		<script type="text/javascript" src="../js/jquery-ui-1.7.2.custom.min.js"></script>
		<script type="text/javascript" src="../js/company_add.js"></script>
	</head>
	<body>
	<div class="table_block">
    	<h3>添加竞争公司信息</h3>
    	<hr>
    	<form action="competitorManage.do" method="post" id="addCompanyForm">
			<input type="hidden" name="action" value="addCompany">
			<table>
			  <tr>
			    <th>公司名称</th>
			    <td><input type="text" name="name" maxlength="30"/> </td>
			  </tr>  
			  <tr>
			    <th>公司法人</th>
			   	<td><input type="text" name="corporation" maxlength="10"/> </td>
			  </tr>
			  <tr>
			    <th>注册时间</th>
			    <td><input type="text" name="recordTime" id="recordTime"/></td>
			  </tr>
			  <tr>
			    <th>地址</th>
			    <td><input type="text" name="address" maxlength="100"/></td>
			  </tr>
			  <tr>
			    <th>类型</th>
			   <td><input type="text" name="type" maxlength="30"/></td>
			  </tr>
			  <tr>
			    <th>主页</th>
			    <td><input type="text" name="homepage" maxlength="30"/></td>
			  </tr>
			  <tr>
			    <th>电话</th>
			    <td><input type="text" name="phone" maxlength="15"/></td>
			  </tr>
			  <tr>
			    <th>邮编</th>
			    <td><input type="text" name="post" maxlength="6"/></td>
			  </tr>
			  <tr>
			    <th>历史描述</th>
			    <td>
			    	<textarea rows="4" cols="60" name="history"></textarea>
			    </td>
			  </tr>
			  <tr>
			    <th></th>
			    <td><br/></td>
			  </tr>
			  <tr>
			    <th></th>
			    <td>
			    	<a onclick="$('#addCompanyForm')[0].submit();" class="btn_submit" id="add_reset">添加</a>
			    </td>
			  </tr>
			</table>	
    </form>
	</div>
	</body>
</html>
