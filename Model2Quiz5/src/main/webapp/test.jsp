<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>궁합보기</h1>
<p>한글이름 - 자모획수계산 / 그외 - 랜덤처리</p>
<form action = "test" method = "post">
	<input type = "text" name = "name1" required /> + <input type = "text" name = "name2" required />
	<input type = "submit" value = "확인" />
</form>
<a href = "list">저장 데이터 확인</a>
<p>한글외 문자 예외처리안함</p>
</body>
</html>