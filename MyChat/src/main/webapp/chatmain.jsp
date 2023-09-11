<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MyLittleChat</title>
<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
<style>
	head{
		width: 100%;
		height:15%;
	}
	nav{
		width: 30%;
		height:70%;
		float: left;
	}
	#chatContainer{
		width: 70%;
		height:70%;
		float:right;
	}
	.myMsg{
		text-align: right;
		margin-right: 5px;
	}
	.myText{
		background: rgb(253, 249, 125);

		padding: 3px;
	}
	.getText{
		background: rgb(255, 255, 255);

		padding: 3px;
	}
	.time{
		font-size: 7px;
	}

</style>
<script>
	var webSocket = new WebSocket("${initParam.CHAT_ADDR}/ChatSocket");
	var chatWindow, message, name;
	
	$(function() {
		chatWindow = $('#chatbox');
		message = $('#msg');
		name = "<c:out value = '${chatUser}' />";
		$('#send').on("click", function(){
			sendMessage();
		})
		$('#logOut').on("click", function(){
			webSocket.close();
		})
		$('#msg').on('keydown', function(e) {
			if (e.keyCode == 13)
		    	if (!e.shiftKey){
		        	e.preventDefault();
		           sendMessage();
		    	}
		});
		function sendMessage(){
			let today = new Date();
			var time = today.toLocaleTimeString();
			console.log(time);
			console.log(name);
			console.log(message.val());
			chatWindow.append("<div class='myMsg'>" + name + "<br/><pre><span class = 'time'>"+time+"</span><span class = 'myText'>" +  message.val() + "</span><pre></div>") //이거 확인해봐야함
			
			webSocket.send(name + "|" + message.val());
			message.val("");
			chatWindow.scrollTop(chatWindow.height());
		}
		
	})
	webSocket.onmessage = function(e){
		var getmessage = event.data.split("|"); 
	    var sender = getmessage[0]; 
	    var content = getmessage[1];
	    content = content.replaceAll("\n", "<br/>");
	    if (content != "") {
	        if (content.match("/")) {  
	            if (content.match(("/" + name))) {  
	                var temp = content.replace(("/" + name), "[귓속말] : ");
	                chatWindow.append("<div>" + sender + "" + temp + "</div>");
	            }
	        }
	        else {  
	            chatWindow.append("<div>" + sender + "<br><span class = 'getText'>" + content + "</span><span class = 'time'>"+time+"</span></div>");
	        }
	    }
	    chatWindow.scrollTop(chatWindow.height());
	}
</script>
</head>
<body>
<header><h3>간단한 채팅방연습</h3></header>
<nav>&nbsp;</nav>
<section id = "chatContainer">
	<div id = "chatbox"  style="overflow:auto; width:400px; height:600px; border-width: 1pt;border-style: solid; background: rgb(201, 201, 201);">
	<c:forEach items = "${chatlog}" var = "log">
		<c:if test = "${log.name != chatUser}" >
		<div>${log.name}<br/><pre><span class = 'getText'>${log.text}</span><span class = "time">${log.chattime}</span></pre></div>
		</c:if>
		<c:if test = "${log.name == chatUser}" >
		<div class='myMsg'>${log.name}<br/><pre><span class = "time">${log.chattime}</span><span class = 'myText'>${log.text}</span><pre></div>
		</c:if>
		
		</c:forEach>
	</div>
	<form >
		<textarea rows="2" name = "msg" id = "msg" style="overflow:auto; width:350px; height:100px; border-width: 1pt;border-style: solid;  resize: none;">
		
		</textarea>
		<input type = "button" value = "전송" id = "send" autofocus />
	</form>
	<a href = "logout.chat"><button id = "logOut">로그아웃</button></a>
	
</section>


</body>
</html>