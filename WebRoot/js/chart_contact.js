$(document).ready(function() {

	jQuery("#jQueryUIAccordion").accordion({
				event : "click",
				collapsible : false,
				autoHeight : false
			});
	// 房屋年度销售
	var contactData = document.getElementById("contactContainer").innerHTML
			.trim();
	var contactDatas = contactData.split("#$");
	var contactArrayDate = new Array();
	var i;
	for (i = 0; i < contactDatas.length; i++) {
		contactArrayDate.push(eval(contactDatas[i]));
	}
	var myChart = new JSChart('contactContainer', 'line');
	myChart.patchMbString();
	myChart.setDataArray(contactArrayDate);
	myChart.setLineColor('#ff0f0f', 'first line');
	myChart.setAxisNameX('日期');
	myChart.setAxisNameY('联系客户');
	myChart.setSize(600, 400);
	myChart.setTitle("上月度客户联系量线性图");
	myChart.draw();
	
});