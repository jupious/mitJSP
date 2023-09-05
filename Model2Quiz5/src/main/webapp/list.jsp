<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix = "c" uri = "jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>저장된 궁합정보</title>
</head>
<body>
<h3>견우와 직녀는 원래 못만날 운명인듯</h3>
<table border = "1">
<tr><th colspan="2">이름</th><th>궁합</th></tr>
<c:forEach var = "nameData" items = "${Data}">
<tr>
	<td>${nameData.name1}</td>
	<td>${nameData.name2}</td>
	<td>${nameData.percent} %</td>
</tr>
</c:forEach>
</table>
</body>
</html>