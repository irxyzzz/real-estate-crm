<%@ page language="java" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<link rel="stylesheet" type="text/css"  href="../style/table_jui.css" />
    <link rel="stylesheet" type="text/css"  href="../style/jquery-ui-1.7.2.custom.css" />
    <script type="text/javascript" src="../js/jquery-1.3.2.min.js"></script>
    <script type="text/javascript" src="../js/dataTables/jquery.dataTables.js"></script>
  	<script type="text/javascript" src="../js/houseManage.js"></script>
  </head>
  <body>
  
  	<div class="table_block">
  		<h3>房产信息修改</h3>
        <hr>
        <span>${requestScope.errorMsg }</span>
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
  			</tr>
  			</c:forEach>
  		</tbody>
  		</table>
  	</div>
  	
  	<div class="modify_block" id="modifier">
  		<div class="table_header"><span>修改房产信息</span></div>
  		
  		<form action="houseManage.do" method="post" id="modifyHouse">
  			<input type="hidden" name="action" value="modify">
  			<c:set value="${requestScope.house}" var="house"></c:set>
  			<input type="hidden" name="houseId" value="${house.houseId }">
  		<table width="100%" class="add_info">
  			<tr>
                <th scope="col">所属小区</th>
                <th scope="col">位置</th>
                <th scope="col">面积</th>
                <th scope="col">价格</th>
                <th scope="col">售出</th>
                <th scope="col">户主</th>
                <th scope="col">售房时间</th>
            </tr>
            <tr>
                <td>
                    <select name="residence">
  					<c:forEach items="${requestScope.ownResidence}" var="res">
  						<c:if test="${res.residenceId == house.residenceCommunity.residenceId}">
  							<option value="${res.residenceId}" selected="selected">${res.name }</option>
  						</c:if>
  						<option value="${res.residenceId}" >${res.name }</option>
  					</c:forEach>
  					</select>
                </td>
                <td>
                    <input type="text" name="position" value="${house.position}"/>
                </td>
                <td>
                  	<input type="text" name="area" value="${house.area}"/>
				</td>
                <td>
                    <input type="text" name="price" value="${house.price}"/>
                </td>
                <td>
                    <c:if test="${house.isSale == true}">
  						<input type="radio" name="isSale" value="Y" checked="checked" />是
  						<input type="radio" name="isSale" value="N" />否
  					</c:if>
  					<c:if test="${house.isSale == false}">
  						<input type="radio" name="isSale" value="Y" onclick="HouseManage.saleDetail(this.value, 'customersSelect')"/>是
  						<input type="radio" name="isSale" value="N" checked="checked" onclick="HouseManage.saleDetail(this.value, 'customersSelect')"/>否
  					</c:if> 
               </td>
               <td>
               		<c:if test="${house.isSale == false}">
	               		<select name="saleCustomer" id="customersSelect" disabled="disabled">
	  					<c:forEach items="${requestScope.employeeCustomers}" var="cus">
	  						<option value="${cus.customerId }">${cus.name }</option>
	  					</c:forEach>
	  					</select>
               		</c:if>
               		<c:if test="${house.isSale == true}">
               			<c:if test="${house.customerId != 0}">
  							<a href="">${requestScope.customer.name }</a>
  						</c:if>
               		</c:if>
               </td>
               <td>
               		<c:if test="${house.isSale == true}">
               			 ${house.time }
               		</c:if>
               		<c:if test="${house.isSale == false}">
               			
               		</c:if>
                                    
				</td>
           </tr>
  		</table>
  		<div class="table_footer ui-helper-clearfix">
            <span>添加单项条目</span>
            <a href="#" onclick="$('#modifyHouse')[0].submit();" class="btn_submit" id="add_reset">修改</a>
            <a href="#" onclick="$('#modifyHouse')[0].reset();" class="btn_submit" id="add_submit">重置</a>
        </div>
  	</form>
  	</div>

	<div class="spacer"></div>  	

  </body>
</html>
