$(document).ready(function() {

	jQuery("#jQueryUIAccordion").accordion({
				event : "click",
				collapsible : false,
				autoHeight : false
			});
	// 总体评价比例分布图
	var allData = document.getElementById("allContainer").innerHTML
			.trim();
	var allDatas = allData.split("#$");
	var allArrayDate = new Array();
	var i;
	for (i = 0; i < allDatas.length; i++) {
		allArrayDate.push(eval(allDatas[i]));
	}
	var myColors = new Array('#0f0', '#ffaa0a', '#ff0f0f', '#00f', '#ff0');
	var myChart = new JSChart('allContainer', 'bar');
	myChart.patchMbString();
	myChart.setDataArray(allArrayDate);
	myChart.colorizeBars(myColors);
	myChart.setTitle("客户反馈总体评价比例分布图");
	myChart.setTitleColor('#ff0f0f');
	myChart.setTitleFontSize(24);
	myChart.draw();

	// 环境评价比例分布图
	var environmentData = document.getElementById("environmentContainer").innerHTML.trim();
	var environmentDatas = environmentData.split("#$");
	var envArrayDate = new Array();
	var i;
	for (i = 0; i < environmentDatas.length; i++) {
		envArrayDate.push(eval(environmentDatas[i]));
	}
	var myColors = new Array('#ff0f0f', '#00f', '#ff0', '#0f0', '#ffaa0a');
	var myChart = new JSChart('environmentContainer', 'pie');
	myChart.patchMbString();
	myChart.setDataArray(envArrayDate);
	myChart.setSize(400, 400);
	myChart.colorizePie(myColors);
	myChart.setTitle("客户反馈小区环境比例分布图");
	myChart.setTitleColor('#ff0f0f');
	myChart.setTitleFontSize(24);
	myChart.draw();

	// 客户反馈小区物业评价分布图
	var tenementData = document.getElementById("tenementContainer").innerHTML.trim();
	var tenementDatas = tenementData.split("#$");
	var tenementArrayDate = new Array();
	var i;
	for (i = 0; i < tenementDatas.length; i++) {
		tenementArrayDate.push(eval(tenementDatas[i]));
	}
	var myColors = new Array('#ff0f0f', '#00f', '#ff0', '#0f0', '#ffaa0a');
	var myChart = new JSChart('tenementContainer', 'bar');
	myChart.patchMbString();
	myChart.setDataArray(tenementArrayDate);
	myChart.colorizeBars(myColors);
	myChart.setTitle("客户反馈物业评价比例分布图");
	myChart.setTitleColor('#ff0f0f');
	myChart.setTitleFontSize(24);
	myChart.draw();
	
	// 客户反馈周边交通评价图
	var trafficData = document.getElementById("trafficContainer").innerHTML.trim();
	var trafficDatas = trafficData.split("#$");
	var trafficArrayDate = new Array();
	var i;
	for (i = 0; i < trafficDatas.length; i++) {
		trafficArrayDate.push(eval(trafficDatas[i]));
	}
	var myColors = new Array('#ff0f0f', '#00f', '#ff0', '#0f0', '#ffaa0a');
	var myChart = new JSChart('trafficContainer', 'bar');
	myChart.patchMbString();
	myChart.setDataArray(trafficArrayDate);
	myChart.setSize(500, 400);
	myChart.colorizeBars(myColors);
	myChart.setTitle("客户反馈周边交通评价比例分布图");
	myChart.setTitleColor('#ff0f0f');
	myChart.setTitleFontSize(24);
	myChart.draw();
	
	//客户反馈销售部门评价比例分布图
	var saleData = document.getElementById("saleContainer").innerHTML.trim();
	var saleDatas = saleData.split("#$");
	var saleArrayDate = new Array();
	var i;
	for (i = 0; i < saleDatas.length; i++) {
		saleArrayDate.push(eval(saleDatas[i]));
	}
	var myColors = new Array('#ff0f0f', '#00f', '#ff0', '#0f0', '#ffaa0a');
	var myChart = new JSChart('saleContainer', 'pie');
	myChart.patchMbString();
	myChart.setDataArray(saleArrayDate);
	myChart.setSize(400, 400);
	myChart.colorizePie(myColors);
	myChart.setTitle("客户反馈销售部门评价比例分布图");
	myChart.setTitleFontSize(24);
	myChart.setTitleColor('#ff0f0f');
	myChart.draw();
	
	// 客户反馈销售员工评价分布图
	var indSaleData = document.getElementById("indSaleContainer").innerHTML
			.trim();
	var indSaleDatas = indSaleData.split("#$");
	var indSaleArrayDate = new Array();
	var i;
	for (i = 0; i < indSaleDatas.length; i++) {
		indSaleArrayDate.push(eval(indSaleDatas[i]));
	}
	var myChart = new JSChart('indSaleContainer', 'bar');
	myChart.patchMbString();
	myChart.setDataArray(indSaleArrayDate);
	myChart.setTitle("客户反馈销售员工评价分布图");
	myChart.setTitleColor('#ff0f0f');
	myChart.setTitleFontSize(24);
	myChart.draw();
});