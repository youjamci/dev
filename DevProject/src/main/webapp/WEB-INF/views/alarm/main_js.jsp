<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
window.onload = function(){
	var webSocket = new WebSocket("ws://도메인주소/${webPath}/ws-alarm");
	   
	webSocket.onopen = () => {
		webSocket.send("${loginUser.memId}");
		wsSend();
	}
	webSocket.onmessage = (e) => {
// 		console.log("핸들러에서 전송한 메세지",e.data);
		var v_alarmIcon = document.querySelector("#alarmIcon");
		v_alarmIcon.style.display = 'inline';

	}
	
	
	var wsSend=()=>{
		setInterval(function() {
			// 3초마다 클라이언트로 메시지 전송
			webSocket.send("${loginUser.memId}");
		}, 3000);
	}
}