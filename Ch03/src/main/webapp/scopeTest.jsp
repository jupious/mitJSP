<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<pre>
jsp에는 4개의 영역개체가 있다.
작은부분부터 큰부분으로 나열하면
page -> request -> session -> application
</pre>

<%
	RequestDispatcher rd = request.getRequestDispatcher("forward.jsp");//가고싶은 주소 세팅
	rd.forward(request, response); //주소 이동
%>
</body>
</html>