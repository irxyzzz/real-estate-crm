$(document).ready(function() {

	jQuery("#jQueryUIAccordion").accordion({
				event : "click",
				collapsible : false,
				autoHeight : false
			});
	// 上月度客户报修量分布
	var contactData = document.getElementById("fixMonthContainer").innerHTML
			.trim();
	var contactDatas = contactData.split("#$");
	var contactArrayDate = new Array();
	var i;
	for (i = 0; i < contactDatas.length; i++) {
		contactArrayDate.push(eval(contactDatas[i]));
	}
	var myChart = new JSChart('fixMonthContainer', 'line');
	myChart.patchMbString();
	myChart.setDataArray(contactArrayDate);
	myChart.setLineColor('#ff0f0f', 'first line');
	myChart.setAxisNameX('日期');
	myChart.setAxisNameY('联系客户');
	myChart.setSize(600, 400);
	myChart.setTitle("上月度客户报修量线性图");
	myChart.draw();
	
	// 各小区报修分布
	var areaData = document.getElementById("fixRCContainer").innerHTML.trim();
	var areaDatas = areaData.split("#$");
	var areaArrayDate = new Array();
	var i;
	for (i = 0; i < areaDatas.length; i++) {
		areaArrayDate.push(eval(areaDatas[i]));
	}
	var myColors = new Array('#00ffff', '#ff0f0f', '#00f', '#0f0');
	var myChart = new JSChart('fixRCContainer', 'pie');
	myChart.patchMbString();
	myChart.setDataArray(areaArrayDate);
	myChart.colorizePie(myColors);
	myChart.setSize(400, 400);
	myChart.setTitle("各小区客户报修量分布图");
	myChart.draw();
});