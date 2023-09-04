<%@page import="kr.mit.c305.gdg.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Log-in to Board!</title>
<style>
	#fs{width: 100px;}
</style>
</head>
<body>

	<form action ="logincheck.board" method = "post">
		<fieldset id = "fs">
			<legend>로그인하기</legend>
			I D : <input type = "text" name = "id" autofocus required /><br/>
			PW : <input type = "password" name = "pw" required /><br/><br/>
			<input type = "submit" value = "로그인" /> <a href="SignUp.jsp"><input type = "button" value = "회원가입" /></a>
		</fieldset>	
	</form>

</body>
</html>