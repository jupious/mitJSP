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
<%	//eltest1으로 요청이 왔음

	//리퀘스트영역에 id=test 값을 넣고
	request.setAttribute("id","test");
	request.setAttribute("todo", new ToDoVO("잠자기", "오늘", "나다"));
	//이동할 주소를 eltest2.jsp로 세팅하고
	RequestDispatcher rd = request.getRequestDispatcher("eltest2.jsp");	
	//보내기
	rd.forward(request, response); 
%>
</body>
</html>