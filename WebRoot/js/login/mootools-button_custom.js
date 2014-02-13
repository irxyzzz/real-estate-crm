window.addEvent('domready',function() {
	$$('.minibutton').addEvents({
		 focus: function() {
			this.addClass('mousedown');
		 },
		 mousedown: function() {
		   this.addClass('mousedown');
		 },
		 blur: function() {
		   this.removeClass('mousedown');
		 },
		 mouseup: function() {
		   this.removeClass('mousedown').blur();
		 }
	 });
}); 
