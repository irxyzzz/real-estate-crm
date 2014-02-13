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
    	<h3>竞争公司信息</h3>
    	<hr>
    	<c:set value="${company}" var="c"></c:set>
    	<table>
			  <tr>
			    <th>公司名称</th>
			    <td>${c.name }</td>
			  </tr>  
			  <tr>
			    <th>公司法人</th>
			   	<td>${c.corporation }</td>
			  </tr>
			  <tr>
			    <th>注册时间</th>
			    <td>${c.time }</td>
			  </tr>
			  <tr>
			    <th>地址</th>
			    <td>${c.address }</td>
			  </tr>
			  <tr>
			    <th>类型</th>
			   <td>${c.type }</td>
			  </tr>
			  <tr>
			    <th>主页</th>
			    <td>${c.homePage }</td>
			  </tr>
			  <tr>
			    <th>电话</th>
			    <td>${c.telephone }</td>
			  </tr>
			  <tr>
			    <th>邮编</th>
			    <td>${c.postcard }</td>
			  </tr>
			  <tr>
			    <th>历史描述</th>
			    <td>
			    	${c.history }
			    </td>
			  </tr>
			  <tr>
			    <th></th>
			    <td>
			    	<br/>
			    </td>
			  </tr>
			   <tr>
			    <th></th>
			    <td>
			    	<a href="competitorManage.do?action=preCompanyModify&id=${company.companyId }" class="btn_submit" id="add_reset">修改</a>
			    </td>
			  </tr>
		</table>
		
	</div>
	</body>
</html>
