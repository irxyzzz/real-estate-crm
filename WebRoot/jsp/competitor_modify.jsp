<%@ page language="java" import="java.util.*, com.crm.model.Competitor"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="../style/table_jui.css" />
		<link rel="stylesheet" type="text/css" href="../style/jquery-ui-1.7.2.custom.css" />
		<link rel="stylesheet" type="text/css" href="../style/competitor_info.css" />
		<link rel="stylesheet" type="text/css" href="../style/button.css" />
		<script type="text/javascript" src="../js/jquery-1.3.2.min.js"></script>
		<script type="text/javascript" src="../js/dataTables/jquery.dataTables.js"></script>
		<script type="text/javascript" src="../js/competitor_info.js"></script>
	</head>
	<body>
	<div class="table_block">
    	<h3>竞争对手信息</h3>
    	<hr>
    	<form action=competitorManage.do method="post" id="modifyCompetitorForm">
			<c:set value="${requestScope.competitor}" var="competitor"></c:set>
			<input type="hidden" name="action" value="modify">
			<input type="hidden" name="id" value="${competitor.competitorId }"/>
			<table>
			  <tr>
			    <th>竞争公司: </th>
			    <td>
			  		<select name="company">
	                <c:forEach items="${competitorCompany}" var="company">
	                	<c:if test="${competitor.company.companyId == company.companyId}">
	                		<option value="${company.companyId}" selected="selected">${company.stringId}-${company.name }</option>
	                	</c:if>
	                  	<option value="${company.companyId} ">${company.stringId}-${company.name }</option>
	                </c:forEach>
	                    </select>
				</td>
			  </tr>  
			  <tr>
			    <th>竞争项目小区：</th>
			    <td>
			  		<select name="residence">
	                <c:forEach items="${competitorResidence}" var="residence">
	                	<c:if test="${competitor.residenceCommunity.residenceId == residence.residenceId}">
	                	<option value="${residence.residenceId }" selected="selected">${residence.stringId }-${residence.name }</option>
	                	</c:if>
	                  	<option value="${residence.residenceId }">${residence.stringId }-${residence.name }</option>
	                </c:forEach>
	                </select>
				</td>
			  </tr>
			  <tr>
			    <th>竞争策略描述：</th>
			    <td>
			    	 <textarea rows="4" cols="60" name="marketStrategy" >${competitor.marketStrategy }</textarea>
			    </td>
			  </tr>
			  <tr>
			    <th></th>
			    <td><br/></td>
			  </tr>
			  <tr>
			    <th></th>
			    <td><a onclick="$('#modifyCompetitorForm')[0].submit();" class="btn_submit" id="add_reset">修改</a></td>
			  </tr>
			</table>
			
		</form>
	</div>
	</body>
</html>
