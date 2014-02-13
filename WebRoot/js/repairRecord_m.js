$(document).ready(function() {
	oFeedbackTable1 = $('#repairRecordTable1').dataTable({
			"bJQueryUI": true,
			"sPaginationType": "full_numbers"
	});
	oFeedbackTable2 = $('#repairRecordTable2').dataTable({
			"bJQueryUI": true,
			"sPaginationType": "full_numbers"
	});
	var TabbedPanels1 = new Spry.Widget.TabbedPanels("TabbedPanels");
});