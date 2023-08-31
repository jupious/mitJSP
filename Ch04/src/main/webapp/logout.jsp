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
	//쿠키지우기
	Cookie cookie = new Cookie("id","");
	cookie.setMaxAge(0);//바로 만료
	response.addCookie(cookie);
%>
<script>
//페이지 자동이동
	location.href="login.jsp";
</script>
</body>
</html>