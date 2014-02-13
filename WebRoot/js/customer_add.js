$(function() {
			// 通过jquery设定datepicker的default属性是datapicker显示于dialog层中
			$.datepicker.setDefaults({
						beforeShow : function(i, e) {
							var z = jQuery(i).closest(".table_block")
									.css("z-index")
									+ 1;
							e.dpDiv.css('z-index', z);
						}
					});
			$('#birthInput').datepicker();
		});