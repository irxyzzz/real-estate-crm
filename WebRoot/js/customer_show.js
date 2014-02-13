$(document).ready(function() {
	oInCustomerTable = $('#inCustomerTable').dataTable({
			"bJQueryUI": true,
			"sPaginationType": "full_numbers"
	});
	
	oAlCustomerTable = $('#alCustomerTable').dataTable({
			"bJQueryUI": true,
			"sPaginationType": "full_numbers"
	});
	
	var TabbedPanels1 = new Spry.Widget.TabbedPanels("TabbedPanels");
});