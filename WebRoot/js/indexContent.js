$(document).ready(function() {
			$('#weather_panel')
					.weatherfeed(['CHXX0141', 'CHXX0008', 'CHXX0448']);
		});
		
function resizeBoard() {
	var temp1 = document.getElementById('newsboard_company').clientWidth;
	var bodyWidth = document.body.clientWidth;
	document.getElementById('newsboard_system').style.width = bodyWidth - 410
			+ 'px';
	document.getElementById('newsboard_company').style.width = bodyWidth - 410
			+ 'px';
}