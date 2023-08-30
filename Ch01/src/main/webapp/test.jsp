<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	1에서 10까지 찍기<br/>
	<%
		
		for(int i = 1; i <= 10;i++){
	%>
			<b><%= i %></b>
	<%	}
	%>
	<%
		int a = 3;
		if(a == 3){%>
			<i>a는 3이 맞다</i>
	<%	}else{ %>
			<b>a는 3이 아닌듯</b>
	<%
		}
	%>
</body>
</html>