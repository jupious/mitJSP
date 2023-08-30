<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>QUIZ1</title>
<style>
	#num{
		color: red;
		width:30px;
		height:20px;
	}
	fieldset{
		width:100px;
		height:80px;
	}
</style>
</head>
<body>
<form action="result/result1.jsp" method = "post" id = "form">
	<fieldset>
		<input type = "number" name = "n1" id = "num" /> ~ 
		<input type = "number" name = "n2" id = "num" /><br/><br/>
		<input type = "submit"  value = "모두 더해라" />
	</fieldset>		
</form>
</body>
</html>