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
pageContext.setAttribute("scopeValue", "페이지영역");

pageContext.setAttribute("bb", "10");
request.setAttribute("bb", "20");
session.setAttribute("bb", "30");
application.setAttribute("bb", "40");


%>
<pre>

${aaa.scopeValue} 	<!-- 각각 값이 없으면 상위로 올라가서 다시 검색 -->
=> (전부형변환 필요)pageContext.getAttribute("aaa").getScopeValue(); 
=> request.getAttribute("aaa").getScopeValue();
=> session.getAttribute("aaa").getScopeValue();
=> application.getAttribute("aaa").getScopeValue();
<hr/>
${scopeValue}
=> (전부형변환 필요)pageContext.getAttribute("scopeValue"); 
=> request.getAttribute("scopeValue");
=> session.getAttribute("scopeValue");
=> application.getAttribute("scopeValue");
<hr/>
${bb} 순차적으로 읽어서 확인
각 영역별로 접근하고싶을때
페이지영역에 있는 값 : ${pageScope.bb}
리퀘스트영역에 있는 값 : ${requestScope.bb}
세션영역에 있는 값 : ${sessionScope.bb}
어플리케이션영역에 있는 값 : ${applicationScope.bb}
<hr>
</pre>

</body>
</html>