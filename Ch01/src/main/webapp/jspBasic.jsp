<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>	
    <%--%@지시어(directive) p64--%>
    <!--HTML주석(소스보기로 보임)  -->
    <%--JSP주석(소스보기로 안보임) --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<pre>
		자바코드를 쓰고싶을때(p78)
		스크립트요소(script Elements)3가지를 이용해서 작성
<%-- 		1. 선언부(declaration)		<%! %> 전역변수or 메소드 선언		--%>
<%-- 		2. 스크립틀릿(scriptlet)	<%  %> 메소드 안에서 만들어짐		--%>
<%-- 		3. 표현식(expression)		<%= %> 자바 변수를 html에 찍기위해	--%>
		
		<%
			sum = 0;
			for(int i = 1; i <= 10; i++){
				sum += i;
			}
			System.out.println(sum); //이클립스 콘솔에 찍힘
			
		%>
		<%!
			int sum;
		%>
		<%
			sum+=10;
		%>
		<%=sum+10%>
	</pre>
</body>
</html>