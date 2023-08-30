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
<%!
	BoardManager manager;
	BoardDBM db;
%>
	<form action ="" method = "post">
		<fieldset id = "fs">
			<legend>로그인하기</legend>
			I D : <input type = "text" name = "id" autofocus/><br/>
			PW : <input type = "password" name = "pw" /><br/><br/>
			<input type = "submit" value = "로그인" /> <a href="SignUp.jsp"><input type = "button" value = "회원가입" /></a>
		</fieldset>	
	</form>
<%
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	
	db = new BoardDBM();
	
	if(db.loginCheck(id, pw)){
		System.out.println("로그인 성공"+id+pw);
	}else{
		System.out.println("로그인 실패.."+id+pw);
	}
%>
</body>
</html>