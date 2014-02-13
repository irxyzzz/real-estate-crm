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
    	<h3>修改竞争项目小区信息</h3>
    	<hr>
	  	<c:set value="${residence}" var="c"></c:set>
    	<form action="competitorManage.do" method="post" id="modifyResidenceForm">
			<input type="hidden" name="action" value="modifyResidence">
			<input type="hidden" name="id" value="${c.residenceId}">
			<table>
			  <tr>
			    <th>名称</th>
			    <td><input type="text" name="name" value="${c.name }" maxlength="20"/> </td>
			  </tr>  
			  <tr>
			    <th>面积</th>
			   	<td><input type="text" name="area" value="${c.area }"  maxlength="15"/> </td>
			  </tr>
			  <tr>
			    <th>类型</th>
			    <td><input type="text" name="type"  value="${c.type }"  maxlength="20"/></td>
			  </tr>
			  <tr>
			    <th>地址</th>
			    <td><input type="text" name="address" value="${c.address }" maxlength="50" /></td>
			  </tr>
			  <tr>
			    <th>所属公司</th>
			 	<td>
			 		<select name="company">
	                    <c:forEach items="${companies}" var="company">
	                    <c:if test="${c.company.companyId == company.companyId}">
		                    <option value="${company.companyId} " selected="selected">${company.stringId}-${company.name }</option>
	                    </c:if>
	                    <option value="${company.companyId} ">${company.stringId}-${company.name }</option>
	                    </c:forEach>
	                </select>
			 	</td>
			  </tr>
			  <tr>
			    <th>描述</th>
			    <td>
			    	<textarea rows="3" cols="60" name="description">${c.description }</textarea>
			   	</td>
			  </tr>
			  <tr>
			    <th></th>
			    <td><br/></td>
			  </tr>
			  <tr>
			    <th></th>
			    <td><a onclick="$('#modifyResidenceForm')[0].submit();" class="btn_submit" id="add_reset">修改</a></td>
			  </tr>
			</table>
			
    </form>
	</div>
	</body>
</html>
