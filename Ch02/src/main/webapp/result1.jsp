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
	//보내온 값을 읽기위해서는 내장객체인 request객체를 이용한다.
	int sum = Integer.parseInt(request.getParameter("num1")) + Integer.parseInt(request.getParameter("num2"));

%>
결과는 <%=sum%>입니다.
</body>
</html>