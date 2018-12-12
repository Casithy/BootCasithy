$(function () { 
	 window.onload = function(){
		setInterval(function(){
				var dateTime = new Date();
				var year=dateTime.getFullYear();
				var month=dateTime.getMonth()+1;
				var ri=dateTime.getDate();
				var hours = dateTime.getHours();
				var minutes = dateTime.getMinutes();
				if(minutes<10){minutes="0"+minutes}       
				var seconds = dateTime.getSeconds();
				if(seconds<10){seconds="0"+seconds}
				$("#time").html(year+"年"+month+"月"+ri+"日  "+hours + ":" + minutes + ":" + seconds);
			}
		,1000)
	}
});