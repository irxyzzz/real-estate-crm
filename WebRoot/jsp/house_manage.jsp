<%@ page language="java" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <link rel="stylesheet" type="text/css"  href="../style/table_jui.css" />
    <link rel="stylesheet" type="text/css"  href="../style/jquery-ui-1.7.2.custom.css" />
    <script type="text/javascript" src="../js/jquery-1.3.2.min.js"></script>
    <script type="text/javascript" src="../js/dataTables/jquery.dataTables.js"></script>
    <script type="text/javascript" src="../js/houseManage.js" ></script>
  </head>
  <body>
  	<div class="table_block">
  		<h3>房产信息</h3>
        <hr>
        <div class="btn_controller">
            <a href="" onclick="" class="btn_submit">批量导入</a>
            <span>${requestScope.errorMsg }</span>
        </div>
        <table id="houseTable" class="display" cellpadding="0" cellspacing="0" border="0" >
  		<thead>
  			<tr>
  				<th>编号</th>
  				<th>小区</th>
  				<th>面积</th>
  				<th>位置</th>
  				<th>价格</th>
  				<th>是否售出</th>
  				<th>售出时间</th>
  				<th>户主</th>
  				<th>选项</th>
  			</tr>
  		</thead>
  		<tbody>
  			<c:forEach items="${requestScope.houses}" var="house">
  			<tr class="gradeA">
  				<td class="center">${house.stringId}</td>
  				<td class="center">
  					<a href="showResidenceInfo.do?id=${house.residenceCommunity.residenceId }">${house.residenceCommunity.name}</a>
  				</td>
  				<td class="center">${house.area}</td>
  				<td class="center">${house.position}</td>
  				<td class="center">${house.price}</td>
  				<c:if test="${house.isSale == true }">
  					<td class="center">是</td>
  					<td class="center">${house.time}</td>
  					<td class="center">
  						<a href="">${house.customerId}</a>
  					</td>
  				</c:if>
  				<c:if test="${house.isSale == false }">
  					<td class="center">否</td>
  					<td class="center"></td>
  					<td class="center"></td>
  				</c:if>
  				<td class="center">
  					<a href="houseManage.do?action=prepareModify&id=${house.houseId}&customerId=${house.customerId}">修改</a>
  					<a href="houseManage.do?action=delete&id=${house.houseId}">删除</a>
  				</td>
  			</tr>
  			</c:forEach>
  		</tbody>
  		</table>
        
        <div class="modify_block" id="modifier">
        	<div class="table_header"><span>添加新房产信息</span></div>
        	<form action="houseManage.do" method="post" id="addHouse">
		  		<input type="hidden" name="action" value="add">
		  		<table width="100%" class="add_info">
		  			<tr>
                    	<th scope="col">所属小区</th>
                   	 	<th scope="col">位置</th>
                   		<th scope="col">面积</th>
                    	<th scope="col">价格</th>
                	</tr>
                	<tr>
	                    <td>
	                        <select name="residence">
		  					<c:forEach items="${requestScope.ownResidence}" var="res">
		  						<option value="${res.residenceId}">${res.name }</option>
		  					</c:forEach>
		  					</select>
	                    </td>
	                    <td>
	                        <input type="text" name="position"/>
	                    </td>
	                    <td>
	                        <input type="text" name="area" />
	                    </td>
	                    <td>
	                        <input type="text" name="price"/>
	                    </td>
                	</tr>
		  		</table>
		  		<div class="table_footer ui-helper-clearfix">
	                <span>添加新房产信息</span>
	                <a href="#" onclick="$('#addHouse')[0].submit();" class="btn_submit" id="add_reset">提交</a>
           		</div>
  			</form>
        </div>
  	</div>
  
  	<div class="spacer"></div>
  	
  </body>
</html>
