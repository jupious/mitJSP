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
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String rs = "";
	if(id.equals("admin") && pw.equals("1234")){
		rs = "로그인 성공";
	}else if(!(id.equals("admin"))&&!(pw.equals("1234"))){
		rs = "잘못된 아이디와 비밀번호 입니다.";
	}else if(!(pw.equals("1234"))){
		rs = "잘못된 비밀번호입니다.";
	}else if(!(id.equals("admin"))){
		rs = "잘못된 아이디입니다."; 
	}
%>
<%=rs%>
</body>
</html>