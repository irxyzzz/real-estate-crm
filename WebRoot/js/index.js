function resizeFrame() {
	document.getElementById('accordion').style.height = window.innerHeight - 98
			+ 'px';
	document.getElementById('func_content').style.height = window.innerHeight
			- 98 + 'px';
	document.getElementById('func_content').style.width = window.innerWidth
			- 192 + 'px';
}