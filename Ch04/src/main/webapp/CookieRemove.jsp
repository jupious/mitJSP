<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>쿠키를 삭제하기</p>
<%
	//1. 쿠키정보 확인
	//2. 쿠키 정보변경(지우기)
	Cookie cookie = new Cookie("urCookie",""); //빈값으로 변경
	//3. 보내기
	response.addCookie(cookie); 
%>
</body>
</html>