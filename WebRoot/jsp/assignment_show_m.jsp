<%@ page language="java" pageEncoding="utf-8"
	contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="../style/calendar_master.css" />
		<link rel='stylesheet' type='text/css' href="../style/calendar_theme.css"/>
		<link rel='stylesheet' type='text/css' href='../style/fullcalendar.css' />
		<script type='text/javascript' src='../js/jquery-1.3.2.min.js'></script>
		<script type='text/javascript' src='../js/jquery-ui-1.7.2.custom.min.js'></script>
		<script type='text/javascript' src='../js/fullcalendar.min.js'></script>
		<script type="text/javascript" src="../js/assignment_m.js"></script>
	</head>
	<body>
		<div>${requestScope.errorMsg}</div>
		<!-- Calendar DIV -->
		<div id='calendar' class="calendar_block"></div>

		<!-- Modify And Show Assignment Dialog DIV -->
		<div id="dialogContainer1" class="calendar_editor">
		<form action="assignment.do" method="post" id="modifyAssignmentForm">
		<input type="hidden" name="action" value="modifyAssignment">
		<input type="hidden" name="assignmentId" id="assignmentId" />
		<table>
		<tbody>
			<tr>
				<th>标题</th>
				<td><input type="text" name="title" id="title"/> </td>
				
			</tr>
			<tr>
				<th>开始时间</th>
				<td><input type="text" name="beginTime" id="beginTime"></td>
			</tr>
			<tr>
				<th>结束时间</th>
				<td><input type="text" name="endTime" id="endTime"></td>
			</tr>
			<tr>
				<th>内容</th>
				<td>
					<textarea rows="3" cols="50" name="content" id="content"></textarea>
				</td>
			</tr>
			<tr>
				<th>部门员工</th>
				<td>
					<select>
					<c:forEach items="${requestScope.employees}" var="employee">
						<option value="${employee.name }">${employee.stringId }-${employee.name }</option>
					</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<th>参与人员</th>
				<td>
					<textarea rows="3" cols="50" name="partEmployee" id="partEmployee"></textarea>
				</td>
			</tr>
			<tr>
				<th></th>
				<td>
					<input type="checkbox" name="delete"/><label>删除</label>
				</td>
			</tr>
		</tbody>
		</table>
		</form>
		</div>
		
		<!-- Add Assignment Dialog DIV -->
		<div id="dialogContainer2" class="calendar_editor">
		<form action="assignment.do" method="post" id="addAssignmentForm">
		<input type="hidden" name="action" value="addAssignment">
		<table>
		<tbody>
			<tr>
				<th>标题</th>
				<td><input type="text" name="title" id="title" maxlength="20"/> </td>
			</tr>
			<tr>
				<th>开始时间</th>
				<td><input type="text" name="beginTimeNew" id="beginTimeNew"></td>
			</tr>
			<tr>
				<th>结束时间</th>
				<td><input type="text" name="endTimeNew" id="endTimeNew"></td>
			</tr>
			<tr>
				<th>内容</th>
				<td>
					<textarea rows="3" cols="50" name="content" id="content"></textarea>
				</td>
			</tr>
			<tr>
				<th>部门员工</th>
				<td>
					<select>
					<c:forEach items="${requestScope.employees}" var="employee">
						<option value="${employee.name }">${employee.stringId }-${employee.name }</option>
					</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<th>参与人员(格式输入)</th>
				<td>
					<textarea rows="3" cols="50" name="partEmployee" id="partEmployee"></textarea>
				</td>
			</tr>
		</tbody>
		</table>
		</form>
		</div>
	</body>
</html>
