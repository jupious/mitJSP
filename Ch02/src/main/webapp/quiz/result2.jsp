<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#red{color: red;}
</style>
</head>
<body>
<%
	String word = request.getParameter("word");
	int length = word.length();
%>
검색어 : <span id = "red"><%=word%></span><br/>
결과<br/>
<span id = "red"><%=word%></span> 글자수(<span id = "red"><%=length%></span>)


</body>
</html>