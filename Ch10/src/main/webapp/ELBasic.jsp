<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- <%String 변수 = "변수";%> --%>
<!-- EL(Expression Language - 표현식) 기본 사용법<br/> -->
<%-- ${Attribute} <%=변수%><br/> --%>
<%-- ${aaa} 경우 page.getAttribute("aaa") ->request->session->application 영역을 타고 가면서 확인해서 출력<br/> --%>
<!-- [주의] java변수에 있는값을 읽는것이 아님<br/> -->
<%-- ${bbb.cc} 경우  page.getAttribute("bbb").getCc(); 마찬가지로 없으면 타고가면서확인함 --%>
</body>
</html>