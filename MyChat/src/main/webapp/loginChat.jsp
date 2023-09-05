<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<style>
	#fs{width: 100px;}
</style>
</head>
<body>
<form action ="logincheck.chat" method = "post">
		<fieldset id = "fs">
			<legend>로그인하기</legend>
			이 름 : <input type = "text" name = "name" autofocus required /><br/>
			PW : <input type = "password" name = "pw" required /><br/><br/>
			<input type = "submit" value = "로그인" /> <a href="signup.chat"><input type = "button" value = "회원가입" /></a>
		</fieldset>	
	</form>
</body>
</html>