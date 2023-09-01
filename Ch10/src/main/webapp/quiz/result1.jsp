<%@page import="model.MyNum"%>
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
	int num1 = Integer.parseInt(request.getParameter("num1"));
	int num2 = Integer.parseInt(request.getParameter("num2"));
	int sum = MyNum.sum(num1,num2);

%>
<%=num1%> 모두 더하기 <%=num2%> 는 <%=sum%> 이다.<br/>

</body>
</html>