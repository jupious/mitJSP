<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action = "odd.do" method = "post">
	<input type = "number" name = "num1" required /> ~
	<input type = "number" name = "num2" required /><br/>
	<input type = "submit" value = "홀수 다더하기" />
</form>

<form action = "even.do" method = "post">
	<input type = "number" name = "num1" required /> ~
	<input type = "number" name = "num2" required /><br/>
	<input type = "submit" value = "짝수 다더하기" />
</form>
</body>
</html>