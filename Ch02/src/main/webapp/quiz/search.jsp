<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#word{color: red;}
</style>
</head>
<body>
	<h1>검색사이트 가 아니라 글자수 세주는 사이트</h1>
	<form action = "result2.jsp" method = "post">
		<fieldset>
			<input type="text" name = "word" autofocus id = "word"/><input type="submit" value ="입력" />
		</fieldset>
	</form>
</body>
</html>