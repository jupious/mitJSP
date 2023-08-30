<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	fieldset{
		width:110px;
		height:70px;
	}
	#in{
		width:60px;
	}
</style>
</head>
<body>
	<form action = "result1.jsp" method = "post">
		<fieldset>
			id : <input type="text" name = "id" id = "in" autofocus autocomplete="off" /><br/>
			pw : <input type="password" name = "pw" id = "in" /><br/>
			<input type="submit" value = "로그인" />
		</fieldset>
	</form>
</body>
</html>