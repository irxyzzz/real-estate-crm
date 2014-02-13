$(document).ready(function() {
	oTable = $('#houseTable').dataTable({
			"bJQueryUI": true,
			"sPaginationType": "full_numbers"
	});
});

var HouseManage = {
	saleDetail : function (value, id) {
		var oTr = document.getElementById(id);
		if (value == "Y") {
			oTr.removeAttribute("disabled");
		}
		else {
			oTr.setAttribute("disabled","disabled");
		}
	},
	
	showAddDiv : function(id) {
		var oDiv = document.getElementById(id);
		oDiv.style.display = "block";
	},
	
	hiddenAddDiv : function(id) {
		var oDiv = document.getElementById(id);
		oDiv.style.display = "none";
	}
}