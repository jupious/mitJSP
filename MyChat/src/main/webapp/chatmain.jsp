<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MyLittleChat</title>
 <script
    src="https://code.jquery.com/jquery-3.7.1.js">
</script>
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

</style>
<script>
	$(function() {
		$('#send').on("click", function(){
			var sendData = {};
			sendData.text = $('#text').val();
			$.ajax({
				url:"sendchat.chat",
				type:"post",
				dataType:"text",
				data: sendData,
				success : function (){
					console.log("ajax통신성공");
				}
			})
		})
	})
</script>
</head>
<body>
<header><h3>간단한 채팅방연습</h3></header>
<nav>&nbsp;</nav>
<section id = "chatContainer">
	<div id = "chat"  style="overflow:auto; width:400px; height:600px; border-width: 1pt;border-style: solid;">
	</div>
	<form >
		<textarea rows="2" name = "text" id = "text" style="overflow:auto; width:350px; height:100px; border-width: 1pt;border-style: solid;">
		</textarea>
		<input type = "button" value = "전송" id = "send"/>
	</form>
	
</section>

<script>
	var user = "<c:out value = '${chatUser}' />";
	var text = "<c:out value = '${sendData.text}' />";
	console.log("user",user);
	console.log("text",text);
	$('#chat').text(text+"text");
</script>

</body>
</html>