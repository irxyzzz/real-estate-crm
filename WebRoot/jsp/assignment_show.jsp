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
		<script type="text/javascript" src="../js/assignment.js"></script>
	</head>
	<body>
		<div>${requestScope.errorMsg }</div>
		<div id='calendar' class="calendar_block"></div>
		<div id="container" class="calendar_editor">
		<div id="container">
		<table>
		<tbody>
			<tr>
				<th>标题</th>
				<td><input type="text" name="title" id="title" disabled="disabled"/> </td>
			</tr>
			<tr>
				<th>开始时间</th>
				<td><input type="text" name="dateBRange" id="dateBRange" disabled="disabled"></td>
			</tr>
			<tr>
				<th>结束时间</th>
				<td><input type="text" name="dateERange" id="dateERange" disabled="disabled"></td>
			</tr>
			<tr>
				<th>内容</th>
				<td>
					<textarea rows="3" cols="50" name="content" id="content" disabled="disabled"></textarea>
				</td>
			</tr>
			<tr>
				<th>参与人员</th>
				<td>
					<textarea rows="3" cols="50" name="partEmployee" id="partEmployee" disabled="disabled"></textarea>
				</td>
			</tr>
		</tbody>
		</table>
		</div>
		</div>
	</body>
</html>
