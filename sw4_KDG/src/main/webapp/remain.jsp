<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>그룹별 재고 수량</title>
<link type="text/css" rel="stylesheet" href="stylesheet.css"/>
</head>
<body>
<fieldset id = "fs">
	<legend>조회결과</legend>
	<table border = "1">
		<tr><th>그룹이름</th><th>재고 수량</th></tr>
		<c:forEach var = "remaindata" items = "${remainList}">
			<tr>
				<td>${remaindata.gname}</td>
				<td>${remaindata.jnum}</td>
			</tr>
		</c:forEach>
	</table>
	<br/>
	<a href="mainMenu.mst">
  <input class="buttonss" type="button" value="메인화면"></a>
</fieldset>
</body>
</html>