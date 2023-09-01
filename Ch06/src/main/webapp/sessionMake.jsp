<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	session.setAttribute("aaa", "aaa의 세션값이다");//이름, 값(모든객체)
	session.setMaxInactiveInterval(15);//초단위
%>

</body>
</html>