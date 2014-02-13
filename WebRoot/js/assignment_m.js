$(document).ready(function() {
	
		// the show and modify dialog.
		var $dialogContent1 = $("#dialogContainer1");
		// the add dialog.
		var $dialogContent2 = $("#dialogContainer2");
	
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
			
			// 日期单击事件处理函数
			dayClick: function(date, allDay, jsEvent, view) {
				$dialogContent2.dialog("open");
			},
			
			// 任务事件单击处理事件函数
			eventClick: function(event, element) {
				$dialogContent1.find("#assignmentId").attr("value", event.id);
				$dialogContent1.find("#title").attr("value", event.title);
				$dialogContent1.find("#beginTime").attr("value", event.start);
				$dialogContent1.find("#endTime").attr("value", event.end);
				$dialogContent1.find("#content").html(event.content);
				$dialogContent1.find("#partEmployee").html(event.participant);
				$dialogContent1.dialog("open");
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
		
		
		$dialogContent1.dialog({
			autoOpen : false,
			title : '任务详细',
			modal: true,
			width : 600,
			height: 450,
			buttons: {
				"取消" : function() {
					$(this).dialog("close");
				},
				
				"修改" : function() {
					$('#modifyAssignmentForm')[0].submit();
					$(this).dialog("close");
				}
			}
		});
		
		$dialogContent2.dialog({
			autoOpen : false,
			title : '任务添加',
			modal: true,
			width : 600,
			height: 450,
			buttons: {
				
				"取消" : function() {
					$(this).dialog("close");
				},
				
				"提交" : function() {
					$('#addAssignmentForm')[0].submit();
					$(this).dialog("close");
				}
			}
		});
		
		// 通过jquery设定datepicker的default属性是datapicker显示于dialog层中
		$.datepicker.setDefaults({  
			beforeShow: function (i, e) {  
		      var z = jQuery(i).closest(".ui-dialog").css("z-index") + 1;  
		      e.dpDiv.css('z-index', z);  
		    }
		}); 
		$("#beginTime").datepicker();
		$("#endTime").datepicker();
		$("#beginTimeNew").datepicker();
		$("#endTimeNew").datepicker();
		
});
	
var AssignmentManage = {
	selectEmployee : function(value, showId) {
		var old = $(showId).html();
		old = old + " " + value;
		$(showId).html(old);
		$("#dialogContainer2").dialog("open");
	}
}