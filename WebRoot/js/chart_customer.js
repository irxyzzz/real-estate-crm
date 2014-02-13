$(document).ready(function() {

	jQuery("#jQueryUIAccordion").accordion({
				event : "click",
				collapsible : false,
				autoHeight : false
			});
	// 客户性别比例分布图
	var genderData = document.getElementById("genderContainer").innerHTML
			.trim();
	var genderDatas = genderData.split("#$");
	var genderArrayDate = new Array();
	var i;
	for (i = 0; i < genderDatas.length; i++) {
		genderArrayDate.push(eval(genderDatas[i]));
	}

	var myChart = new JSChart('genderContainer', 'bar');
	myChart.patchMbString();
	myChart.setDataArray(genderArrayDate);
	myChart.setLineColor('#ff0f0f', 'first line');
	myChart.setTitle("客户性别比例分布图");
	myChart.draw();

	// 客户年龄比例分布图
	var ageData = document.getElementById("ageContainer").innerHTML.trim();
	var ageDatas = ageData.split("#$");
	var ageArrayDate = new Array();
	var i;
	for (i = 0; i < ageDatas.length; i++) {
		ageArrayDate.push(eval(ageDatas[i]));
	}

	var myChart = new JSChart('ageContainer', 'bar');
	myChart.patchMbString();
	myChart.setDataArray(ageArrayDate);
	myChart.setSize(600, 350);
	myChart.setTitle("客户年龄比例分布图");
	myChart.draw();

	// 客户婚姻分布图
	var marryData = document.getElementById("marryContainer").innerHTML.trim();
	var marryDatas = marryData.split("#$");
	var marryArrayDate = new Array();
	var i;
	for (i = 0; i < marryDatas.length; i++) {
		marryArrayDate.push(eval(marryDatas[i]));
	}

	var myChart = new JSChart('marryContainer', 'bar');
	myChart.patchMbString();
	myChart.setDataArray(marryArrayDate);
	myChart.setTitle("客户婚姻比例分布图");
	myChart.draw();
	
	// 客户收入分布
	var incomeData = document.getElementById("incomeContainer").innerHTML.trim();
	var incomeDatas = incomeData.split("#$");
	var incomeArrayDate = new Array();
	var i;
	for (i = 0; i < incomeDatas.length; i++) {
		incomeArrayDate.push(eval(incomeDatas[i]));
	}
	var myColors = new Array('#0f0', '#ffaa0a', '#ff0f0f', '#00f', '#ff0', '#00ffff', '#ff0f0f', '#00f');
	var myChart = new JSChart('incomeContainer', 'pie');
	myChart.patchMbString();
	myChart.setDataArray(incomeArrayDate);
	myChart.colorizePie(myColors)
	myChart.setTitle("客户收入比例分布图");
	myChart.draw();
	
	// 客户职业分布
	var jobData = document.getElementById("jobContainer").innerHTML.trim();
	var jobDatas = jobData.split("#$");
	var jobArrayDate = new Array();
	var i;
	for (i = 0; i < jobDatas.length; i++) {
		jobArrayDate.push(eval(jobDatas[i]));
	}
	var myColors = new Array('#00ffff', '#ff0f0f', '#00f', '#0f0', '#ffaa0a');
	var myChart = new JSChart('jobContainer', 'pie');
	myChart.patchMbString();
	myChart.setDataArray(jobArrayDate);
	myChart.colorizePie(myColors)
	myChart.setTitle("客户职业比例分布图");
	myChart.draw();
	
	// 客户爱好分布
	var hobbyData = document.getElementById("hobbyContainer").innerHTML.trim();
	var hobbyDatas = hobbyData.split("#$");
	var hobbyArrayDate = new Array();
	var i;
	for (i = 0; i < hobbyDatas.length; i++) {
		hobbyArrayDate.push(eval(hobbyDatas[i]));
	}
	var myColors = new Array('#00ffff', '#ff0f0f', '#00f', '#0f0', '#ffaa0a');
	var myChart = new JSChart('hobbyContainer', 'bar');
	myChart.patchMbString();
	myChart.setDataArray(hobbyArrayDate);
	myChart.colorizeBars(myColors)
	myChart.setTitle("客户兴趣比例分布图");
	myChart.draw();
});