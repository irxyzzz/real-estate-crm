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
    	<h3>竞争项目小区信息</h3>
    	<hr>
        <span>${requestScope.errorMsg }</span>
		<table cellpadding="0" cellspacing="0" border="0" class="display" id="competitorTable">
		<thead>
			<tr>
				<th>编号 </th>
				<th>名称</th>
				<th>面积</th>
				<th>类型</th>
				<th>地址</th>
				<th>所属公司</th>
				<th>描述</th>
				<th>选项</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${residenceCommunities}" var="rc">
			<tr class="gradeA">
				<td class="center">${rc.stringId}</td>
				<td class="center">${rc.name}</td>
				<td class="center">${rc.area}</td>
				<td class="center">${rc.type}</td>
				<td class="center">${rc.address}</td>
				<td class="center">${rc.company.name}</td>
				<td class="center">${rc.description}</td>
				<td class="center">
					<a href="competitorManage.do?action=preResidenceModify&id=${rc.residenceId }">修改</a>
					<a href="competitorManage.do?action=delResidence&id=${rc.residenceId }">删除</a>
				</td>
			</tr>
			</c:forEach>
		</tbody>
		</table>
		</div>
		
		<!-- add a new competitor -->
		<div class="modify_block" id="modifier">
			<div class="table_header"><span>竞争项目小区信息</span></div>
	  		<form action="competitorManage.do" method="post" id="addResidenceForm">
	  		<input type="hidden" name="action" value="addResidence">
	  		<table width="100%" class="add_info">
	  			<tr>
	                <th scope="col">名称</th>
					<th scope="col">面积</th>
					<th scope="col">类型</th>
					<th scope="col">地址</th>
					<th scope="col">所属公司</th>
					<th scope="col">描述</th>
	            </tr>
	            <tr>
	            	<td>
	            		<input type="text" name="name" maxlength="15"/>
	            	</td>
	            	<td>
	            		<input type="text" name="area" maxlength="15"/>
	            	</td>
	            	<td>
	            		<input type="text" name="type" maxlength="15"/>
	            	</td>
	            	<td>
	            		<input type="text" name="address" maxlength="50"/>
	            	</td>
	                <td>
	                    <select name="company">
	                    <c:forEach items="${companies}" var="company">
	                    	<option value="${company.companyId} ">${company.stringId}-${company.name }</option>
	                    </c:forEach>
	                    </select>
	                </td>
	                <td>
	                    <textarea rows="2" cols="50" name="description"></textarea>
					</td>
	            </tr>
	  		</table>
	  		<div class="table_footer ui-helper-clearfix">
	            <span>添加新竞争项目小区信息</span>
	            <a onclick="$('#addResidenceForm')[0].submit();" class="btn_submit">添加</a>
	        </div>
	  		</form>
		</div>
	</body>
</html>
