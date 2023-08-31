<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키주세요</title>
</head>
<body>
<p>쿠키 확인</p>
<%
	Cookie[] cookies=request.getCookies();
	if(cookies != null){//쿠키가 있을때만
		for(Cookie c : cookies){%>
			<%=c.getName()%> : <%=c.getValue()%><br/>
<%		}
	}
%>
</body>
</html>