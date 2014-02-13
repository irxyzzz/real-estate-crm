$(document).ready(function() {
			$.featureList($("#tabs li a"), $("#output li"), {
						start_item : 0
					});
		});
function relocateContent() {
	var availHeight = window.innerHeight - 98;
	var contentHeight = document.getElementById('content').clientHeight;
	var availWidth = window.innerWidth;
	var contentWidth = document.getElementById('content').clientWidth;
	if (availHeight <= contentHeight) {
		document.getElementById('content').style.top = 49 + 'px';
	} else {
		document.getElementById('content').style.top = 49
				+ ((availHeight - contentHeight) / 2) + 'px';
	}
	if (availWidth <= 790) {
		document.getElementById('content').style.left = 0 + 'px';
	} else {
		document.getElementById('content').style.left = ((availWidth - contentWidth) / 2)
				+ 'px';
	}
}