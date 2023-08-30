<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
p93
<h2>요청 헤더 정보 출력하기</h2>
<%
	Enumeration headers = request.getHeaderNames(); //헤더 이름을 읽기
	while(headers.hasMoreElements()){	//다음 헤더이름이 있다면(next()랑 비슷한듯)
		String name = (String)headers.nextElement();//헤더이름 가져오기
		String value = request.getHeader(name);	//헤더 이름을 넣어서 값 가져오기
		System.out.println("헤더 : "+name+"="+value);
		%> <%=name%>=<%=value%><br/>
<%	}
%>
<%
	String ip = request.getRemoteAddr();

%>
너의 ip는 <%=ip%>
</body>
</html>