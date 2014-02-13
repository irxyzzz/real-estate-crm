$(document).ready(function() {
	
		var $dialogContent = $("#container");
	
		var date = new Date();
		var d = date.getDate();
		var m = date.getMonth();
		var y = date.getFullYear();
		
		$('#calendar').fullCalendar({
			theme: true,
			header: {
				left: 'prev,next today',
				center: 'title',
				right: 'month,agendaWeek,agendaDay'
			},
			height : 400,
			editable: true,
			events : "assignment.do?action=getEvent",
			buttonText : {
				prev : '昨天',
				next : '明天',
				prevYear : '去年',
				nextYear : '明年',
				today : '今天',
				month : '月',
				week : '周',
				day : '日'
			},
			monthNames:['一月','二月', '三月', '四月', '五月', '六月', '七月',
						'八月', '九月', '十月', '十一月', '十二月'],
			monthNamesShort:['一月','二月', '三月', '四月', '五月', '六月', '七月',
						'八月', '九月', '十月', '十一月', '十二月'],
			dayNames:['星期日', '星期一', '星期二', '星期三', '星期四', '星期五', '星期六'],
			dayNamesShort:['星期日', '星期一', '星期二', '星期三', '星期四', '星期五', '星期六'],
			titleFormat:{
				month: 'MMMM yyyy',                             // September 2009
				week: "MMM d[ yyyy]{ '&#8212;'[ MMM] d yyyy}", // Sep 7 - 13 2009
				day: 'dddd, MMM d, yyyy'                  // Tuesday, Sep 8, 2009
			},
			
			dayClick: function(date, allDay, jsEvent, view) {
				// alert(date);
				// alert(view.start);
//				$dialogContent.dialog("open");
			},
			
			eventClick: function(event, element) {
				$dialogContent.find("#title").attr("value", event.title);
				$dialogContent.find("#dateBRange").attr("value", event.start);
				$dialogContent.find("#dateERange").attr("value", event.end);
				$dialogContent.find("#content").html(event.content);
				$dialogContent.find("#partEmployee").html(event.participant);
				$dialogContent.dialog("open");
			},
			
			eventMouseover:function( event, jsEvent, view ) { 
				//alert("eventMouseover");
				/*
				$(".fc-state-default").hover(
					function(){
						$(this).addClass("calendar_hover");
					},
					function(){
						$(this).removeClass("calendar_hover");
					}
				);
				*/
			},
			eventMouseout:function( event, jsEvent, view ) { 
				//alert("eventMouseout");
				/*
				$(".fc-state-default").hover(
					function(){
						$(this).removeClass("calendar_hover");
					}
				);
				*/
			},
			// 拖拽事件引发的操作
			eventDragStart:function(event,jsEvent,ui,view) { 
			},
			eventDragStop:function( event, jsEvent, ui, view ) { 
			},	
			/*
			 *  当拖拽完成并且时间改变
			 *  dayDelta 保存日程向前或者向后移动了多少天
			 *  minuteDelta 这个值只有在agenda视图有效，移动的时间
			 * allDay 如果是月视图，或者是agenda视图的全天日程，此值为true,否则为false
			 */
			eventDrop:function( event, dayDelta, minuteDelta, allDay, revertFunc, jsEvent, ui, view ) { 
				/*
				alert(
					event.title + " was moved " +
					dayDelta + " days and " +
					minuteDelta + " minutes."
				);

				if (allDay) {
					alert("Event is now all-day");
				}else{
					alert("Event has a time-of-day");
				}

				// 确认是否更改
				if (!confirm("Are you sure about this change?")) {
					revertFunc();
				}*/
			},			
			// 改变大小的事件触发的操作
			eventResizeStart:function( event, jsEvent, ui, view ) {
				//alert("eventResizeStart");
			},
			eventResizeStop:function( event, jsEvent, ui, view ) { 
				//alert("eventResizeStop");
			},
			eventResize:function( event, dayDelta, minuteDelta, revertFunc, jsEvent, ui, view ) { 
				//alert("eventResize");
			}
		});
		
		
		$dialogContent.dialog({
			autoOpen : false,
			title : '任务详细',
			modal: true,
			width : 600,
			height: 410,
			buttons: {
				"关闭" : function() {
					$(this).dialog("close");
				}
			}
		});
		
		 $("#dateBRange").datepicker();
		 $("#dateERange").datepicker();
		
	});