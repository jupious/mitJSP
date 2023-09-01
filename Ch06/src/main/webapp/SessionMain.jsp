<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
세션id : <%=session.getId()%><br/>
세션유지시간 : <%=session.getMaxInactiveInterval()%><br/>
세션 최초 요청시간 : <%=session.getCreationTime()%><br/>
세션 마지막 요청시간 : <%=session.getLastAccessedTime()%>
<h1>세션값 : <%=session.getAttribute("aaa")%></h1>
<a href = "sessionMake.jsp">세션 값 세팅하기</a>
</body>
</html>