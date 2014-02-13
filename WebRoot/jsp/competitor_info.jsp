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
    	<h3>竞争对手信息</h3>
    	<hr>
    	<span>${requestScope.errorMsg }</span>
		<table cellpadding="0" cellspacing="0" border="0" class="display" id="competitorTable">
		<thead>
			<tr>
				<th>竞争对手编号 </th>
				<th>公司编号</th>
				<th>公司名称</th>
				<th>竞争项目编号</th>
				<th>竞争项目小区</th>
				<th>竞争策略</th>
				<th>选项</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${allCompetitors}" var="competitor">
			<tr class="gradeA">
				<td class="center">${competitor.stringId}</td>
				<td class="center">${competitor.company.stringId}</td>
				<td class="center">${competitor.company.name }</td>
				<td class="center">${competitor.residenceCommunity.stringId}</td>
				<td class="center">${competitor.residenceCommunity.name}</td>
				<td class="center">${competitor.marketStrategy}</td>
				<td class="center">
					<a href="competitorManage.do?action=preModify&id=${competitor.competitorId }">修改</a>
					<a href="competitorManage.do?action=delete&id=${competitor.competitorId }">删除</a>
				</td>
			</tr>
			</c:forEach>
		</tbody>
		</table>
		</div>
		
		<!-- add a new competitor -->
		<div class="modify_block" id="modifier">
			<div class="table_header"><span>新竞争对手信息</span></div>
	  		<form action="competitorManage.do" method="post" id="addCompetitorForm">
	  		<input type="hidden" name="action" value="addCompetitor">
	  		<table width="100%" class="add_info">
	  			<tr>
	                <th scope="col">竞争公司</th>
	                <th scope="col">竞争项目小区</th>
	                <th scope="col">竞争策略描述</th>
	            </tr>
	            <tr>
	                <td>
	                    <select name="company">
	                    <c:forEach items="${competitorCompany}" var="company">
	                    	<option value="${company.companyId} ">${company.stringId}-${company.name }</option>
	                    </c:forEach>
	                    </select>
	                </td>
	                <td>
	                    <select name="residence">
	                    <c:forEach items="${competitorResidence}" var="residence">
	                    	<option value="${residence.residenceId }">${residence.stringId }-${residence.name }</option>
	                    </c:forEach>
	                    </select>
	                </td>
	                <td>
	                    <textarea rows="2" cols="50" name="marketStrategy"></textarea>
					</td>
	            </tr>
	  		</table>
	  		<div class="table_footer ui-helper-clearfix">
	            <span>添加新竞争对手信息</span>
	            <a onclick="$('#addCompetitorForm')[0].submit();" class="btn_submit">添加</a>
	        </div>
	  		</form>
		</div>
	</body>
</html>
