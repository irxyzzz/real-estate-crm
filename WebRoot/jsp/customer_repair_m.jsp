<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <link rel="stylesheet" type="text/css"  href="../style/table_jui.css" />
  <link rel="stylesheet" type="text/css"  href="../style/jquery-ui-1.7.2.custom.css" />
  <link rel="stylesheet" type="text/css"  href="../style/customer_repair.css" />
  <link rel="stylesheet" type="text/css" href="../style/SpryTabbedPanels.css" />
  <script type="text/javascript" src="../js/jquery-1.3.2.min.js"></script>
  <script type="text/javascript" src="../js/dataTables/jquery.dataTables.js"></script>
  <script type="text/javascript" src="../js/tabPanel/SpryTabbedPanels.js"></script>
  <script type="text/javascript" src="../js/repairRecord_m.js" ></script>
</head>
<body>
	<div id="TabbedPanels" class="TabbedPanels">
		<ul class="TabbedPanelsTabGroup">
		    <li class="TabbedPanelsTab" id="tab_left">未审核的报修信息</li>
		    <li class="TabbedPanelsTab" id="tab_right">已审核的报修信息</li>
	    </ul>
	    
	    <div class="TabbedPanelsContentGroup">
	    	<div class="TabbedPanelsContent">
	    		<div class="btn_controller"><span>${requestScope.errorMsg }</span></div>
	    		<table id="repairRecordTable1" class="display" cellpadding="0" cellspacing="0" border="0" >
			      <thead>
			        <tr align="center">
					  <th>编号</th>
					  <th>客户编号</th>
					  <th>客户姓名</th>
				  	  <th>故障描述</th>
				  	  <th>处理方案</th>
				  	  <th>开始时间</th>
				  	  <th>结束时间</th>
				  	  <th>审核</th>
				      <th>选项</th>
				    </tr>
			      </thead>
			      <tbody>
					<c:forEach items="${requestScope.unverifyRepairRecords}" var="repairRecord">
				  	  <tr align="center">
				        <td>${repairRecord.stringId}</td>
				    	<td>${repairRecord.customer.stringId}</td>
				    	<td>${repairRecord.customer.name}</td>
				    	<td>${repairRecord.decription}</td>
				    	<td>${repairRecord.handle}</td>
				    	<td>${repairRecord.stringBeginTime }</td>
				    	<td>${repairRecord.stringEndTime }</td>
				    	<td>
				    		<c:if test="${repairRecord.isVerify == true}">已审核</c:if>
				    		<c:if test="${repairRecord.isVerify == false}">
				    			等待<a href="customerManage.do?action=preVerify&id=${repairRecord.repairRecordId }">审核</a>
				    		</c:if> 
				    	</td>
				    	<td>
				    		<a href="customerManage.do?action=deleteRepair&id=${repairRecord.repairRecordId}">删除</a>
				    	</td>
				  	  </tr>
			        </c:forEach>
			      </tbody>
			    </table>
	    	</div>
	    	
	    	<div class="TabbedPanelsContent">
	    		<div class="btn_controller"><span>${requestScope.errorMsg }</span></div>
	    		<table id="repairRecordTable2" class="display" cellpadding="0" cellspacing="0" border="0" >
			      <thead>
			        <tr align="center">
					  <th>编号</th>
					  <th>客户编号</th>
					  <th>客户姓名</th>
				  	  <th>故障描述</th>
				  	  <th>处理方案</th>
				  	  <th>开始时间</th>
				  	  <th>结束时间</th>
				  	  <th>审核</th>
				  	  <th>审核意见</th>
				      <th>选项</th>
				    </tr>
			      </thead>
			      <tbody>
					<c:forEach items="${requestScope.verifyRepairRecords}" var="repairRecord">
				  	  <tr align="center">
				        <td>${repairRecord.stringId}</td>
				    	<td>${repairRecord.customer.stringId}</td>
				    	<td>${repairRecord.customer.name}</td>
				    	<td>${repairRecord.decription}</td>
				    	<td>${repairRecord.handle}</td>
				    	<td>${repairRecord.stringBeginTime }</td>
				    	<td>${repairRecord.stringEndTime }</td>
				    	<td>
				    		<c:if test="${repairRecord.isVerify == true}">已审核</c:if>
				    		<c:if test="${repairRecord.isVerify == false}">等待审核</c:if> 
				    	</td>
				    	<td>
				    		<c:if test="${repairRecord.isVerify == true}">${repairRecord.newHandle}</c:if>
				    		<c:if test="${repairRecord.isVerify == false}">等待审核</c:if> 
	    				</td>
				    	<td>
				    		<a href="customerManage.do?action=deleteRepair&id=${repairRecord.repairRecordId}">删除</a>
				    	</td>
				  	  </tr>
			        </c:forEach>
			      </tbody>
			    </table>
	    	</div>
	    </div>
	</div>  
</body>
</html>