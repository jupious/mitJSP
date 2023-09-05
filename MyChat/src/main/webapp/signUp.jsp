<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<style>
	#fs{width: 100px;}
</style>
</head>
<body>
<form action = "signuptry.chat" method = "post">
	<fieldset>
		<legend>회원가입</legend>
		이 름 : <input type = "text" name = "name" autofocus required />
		P W : <input type = "password" name = "pw" required />
		<input type ="submit" value = "가입" />
	</fieldset>
</form>
</body>
</html>