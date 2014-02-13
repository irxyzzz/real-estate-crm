$(document).ready(function() {
	oInCustomerTable = $('#customerCareTable').dataTable({
			"bJQueryUI": true,
			"sPaginationType": "full_numbers"
	});
	
	$.datepicker.setDefaults({
				beforeShow : function(i, e) {
					var z = jQuery(i).closest(".modify_block")
							.css("z-index")
							+ 1;
					e.dpDiv.css('z-index', z);
				}
			});
    		$("#activeTime").datepicker();
});