<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix = "c" uri = "jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:set var = "aaa" value = "123" scope = "page"/>
<c:set var = "bbb" >321</c:set>
c:set - jstl 변수설정태그<br/>
var - 변수명<br/>
value - 값 태그 안에 써도됨<br/>
scope - 설정 영역(생략시 기본값 page)<br/>
${aaa}<br/>
${bbb}<br/>
<hr/>
<c:remove var="aaa" scope = "page"/>
c:remove - 변수삭제<br/>
var - 삭제할 변수명<br/>
scope - 삭제할 변수의 영역<b>(주의! 영역을 지정하지 않으면 모든 영역의 해당변수 삭제)</b><br/>
${aaa}<br/>
${bbb}<br/>
<hr/>

<c:if test = "${bbb == 321}" var = "result" scope = "page">
	참일때 나오는 문장<br/>
</c:if>
test - 조건<br/>
var - 결과를 저장할 변수이름<br/>
scope - 변수가 저장될 영역<br/>

<c:set var = "name" value = "확인용" scope = "request" />
<c:if test = '${name == "확인용"}' >
name은 확인용이 맞구나<br/>
</c:if>
<c:if test = '${name != "확인용"}' >
name은 확인용이 아니구나<br/>
</c:if>
<hr/>

<c:choose>
	<c:when test = "${200 > 300 }">bbb는 300보다 크구나<br/></c:when>
	<c:when test = "${32 == 32 }">321은 321이구나<br/></c:when>
	<c:when test = "${bbb == 300 }">bbb는 300이구나<br/></c:when>
	<c:when test = "${321 == 321 }">321은 321이구나<br/></c:when>
	<c:otherwise>bbb는 300보다 작구나<br/></c:otherwise>
</c:choose>
choose블록생성후 when태그로 조건과 참일때의 행동을 정할수있음<br/>
otherwise로 else처럼 사용가능<br/>
주의!> break문이 내장된 형태로 동작<br/>
<hr/>

<c:forEach var = "i"  begin = "1" end = "10" step = "1" >
${i}<br/>
</c:forEach>
c:forEach for(int i = 1; i &lt;= 10; i++)에 대응되도록 구현<br/>
step의 기본값 = 1<br/>

<table border="1px">
	<tr>
		<th>이름</th>
		<th>번호</th>
		<th>전화번호</th>
	</tr>
<c:forEach var = "stData" items = "${List}">
	<tr>
		<td>${stData.name}</td>
		<td>${stData.no}</td>
		<td>${stData.tel}</td>
	</tr>
</c:forEach>
</table>
<hr/>
</body>
</html>