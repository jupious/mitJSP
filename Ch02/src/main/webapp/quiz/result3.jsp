<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.d{width : auto;}
</style>
</head>
<body>
<%
	int num = Integer.parseInt(request.getParameter("num"));%>
	<%=num%>단<br/>
	<table border="1" style="width: auto; text-align: center;">
<%	for(int i = 2; i <= 9; i++){%>
	
		<tr>
			<td class = "d"><%=num%>x<%=i%></td>
			<td class = "d"><%=num*i%></td>
		</tr>

<%	}
%>
	</table>	
</body>
</html>