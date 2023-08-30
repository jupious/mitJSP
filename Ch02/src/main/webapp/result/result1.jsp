<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#n{ color: red;}
</style>
</head>
<body>
<%
	int a = Integer.parseInt(request.getParameter("n1"));
	int b = Integer.parseInt(request.getParameter("n2"));
	int sum = 0, temp;
	if(a > b){
		temp = a;
		a = b;
		b = temp;
	}
	for(int i = a; i <= b; i++){
		sum+=i;
	}
%>

	<span id = "n"><%=a%></span> 부터 <span id = "n"><%=b%></span>까지<br/>
	모두더하면<br/>
	<span id ="n"><%=sum%></span>입니다.

</body>
</html>