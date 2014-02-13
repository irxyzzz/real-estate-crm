$(document).ready(function() {

	jQuery("#jQueryUIAccordion").accordion({
				event : "click",
				collapsible : false,
				autoHeight : false
			});
	// 房屋年度销售
	var monthData = document.getElementById("monthContainer").innerHTML
			.trim();
	var monthDatas = monthData.split("#$");
	var monthArrayDate = new Array();
	var i;
	for (i = 0; i < monthDatas.length; i++) {
		monthArrayDate.push(eval(monthDatas[i]));
	}

	var myChart = new JSChart('monthContainer', 'line');
	myChart.patchMbString();
	myChart.setDataArray(monthArrayDate);
	myChart.setLineColor('#ff0f0f', 'first line');
	myChart.setAxisNameX('月份');
	myChart.setAxisNameY('销售量');
	myChart.setSize(600, 400);
	myChart.setTitle("房屋年度销售线性图");
	myChart.draw();

	// 房屋价格销售分布
	var priceData = document.getElementById("priceContainer").innerHTML.trim();
	var priceDatas = priceData.split("#$");
	var priceArrayDate = new Array();
	var i;
	for (i = 0; i < priceDatas.length; i++) {
		priceArrayDate.push(eval(priceDatas[i]));
	}
	var myColors = new Array('#00ffff', '#ff0f0f', '#00f', '#0f0', '#ffaa0a', '#f0ff0f');
	var myChart = new JSChart('priceContainer', 'bar');
	myChart.patchMbString();
	myChart.setDataArray(priceArrayDate);
	myChart.colorizeBars(myColors);
	myChart.setAxisNameX('价格区间');
	myChart.setAxisNameY('销售量');
	myChart.setSize(600, 400);
	myChart.setTitle("房屋价格比例销售分布图");
	myChart.draw();
	
	// 房屋面积比例销售分布
	var areaData = document.getElementById("areaContainer").innerHTML.trim();
	var areaDatas = areaData.split("#$");
	var areaArrayDate = new Array();
	var i;
	for (i = 0; i < areaDatas.length; i++) {
		areaArrayDate.push(eval(areaDatas[i]));
	}
	var myColors = new Array('#00ffff', '#ff0f0f', '#00f', '#0f0', '#ffaa0a','#f0ff0f');
	var myChart = new JSChart('areaContainer', 'pie');
	myChart.patchMbString();
	myChart.setDataArray(areaArrayDate);
	myChart.colorizePie(myColors);
	myChart.setSize(500, 500);
	myChart.setTitle("房屋面积比例销售分布图");
	myChart.draw();
	
	
});