<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿸키</title>
</head>
<body>
<p>p141</p>
<p>쿠키 처리 및 확인</p>
<%
	//쿠키설정 (만들어서 보내준다.)
	Cookie cookie = new Cookie("urCookie", "네가만든쿠키"); //쿠키세팅(이름, 값)
	cookie.setMaxAge(3600);	//쿠키 유지시간(초)
	response.addCookie(cookie);//쿠키 응답
%>
</body>
</html>