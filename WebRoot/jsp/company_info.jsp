<%@ page language="java" import="java.util.*, com.crm.model.Competitor"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="../style/table_jui.css" />
		<link rel="stylesheet" type="text/css" href="../style/jquery-ui-1.7.2.custom.css" />
		<link rel="stylesheet" type="text/css" href="../style/competitor_info.css" />
		<script type="text/javascript" src="../js/jquery-1.3.2.min.js"></script>
		<script type="text/javascript" src="../js/dataTables/jquery.dataTables.js"></script>
		<script type="text/javascript" src="../js/competitor_info.js"></script>
	</head>
	<body>
	<div class="table_block">
    	<h3>竞争公司信息信息</h3>
    	<hr>
    	<div class="btn_controller">
	    	<a href="competitorManage.do?action=preAddCompany" class="btn_submit">添&emsp;加</a>
          	<span>${requestScope.errorMsg }</span>
        </div>
		<table cellpadding="0" cellspacing="0" border="0" class="display" id="competitorTable">
		<thead>
			<tr>
				<th>编号 </th>
				<th>名称</th>
				<th>法人</th>
				<th>注册日期</th>
				<th>地址</th>
				<th>类型</th>
				<th>电话</th>
				<th>选项</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${companies}" var="company">
			<tr class="gradeA">
				<td class="center">${company.stringId}</td>
				<td class="center">${company.name}</td>
				<td class="center">${company.corporation}</td>
				<td class="center">${company.time}</td>
				<td class="center">${company.address}</td>
				<td class="center">${company.type}</td>
				<td class="center">${company.telephone}</td>
				<td class="center">
					<a href="competitorManage.do?action=detailCompany&id=${company.companyId }">详细</a>
					<a href="competitorManage.do?action=preCompanyModify&id=${company.companyId }">修改</a>
					<a href="competitorManage.do?action=delCompany&id=${company.companyId }">删除</a>
				</td>
			</tr>
			</c:forEach>
		</tbody>
		</table>
		</div>
	</body>
</html>
