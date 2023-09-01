<%@page import="vo.ToDoVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
리퀘스트 영역에 이름이 id인 값 읽기
<h1>${id}</h1>
<%=request.getAttribute("id")%>
<br/>객체 데이터 읽기
<h2>${todo.todo} ${todo.todoDate} ${todo.name}</h2>
<%-- <%=((ToDoVO)request.getAttribute("todo")).getTodo() %> --%>
</body>
</html>