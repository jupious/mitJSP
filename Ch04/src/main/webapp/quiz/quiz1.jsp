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
	int rs = 0;
	int num1 = 0, num2 = 0;
	String save = null, saven1 = null, saven2 = null;
	int flag = 0; //0은 값 없음 1은 값 있음
	Cookie[] cookies = request.getCookies();
	if(cookies != null){
		for(Cookie c : cookies){
			if(c.getName().equals("result")){
				save = c.getValue();
			}else if(c.getName().equals("nu1")){
				saven1 = c.getValue();
			}else if(c.getName().equals("nu2")){
				saven2 = c.getValue();
			}
			
		}
	}
	if(save != null && saven1 != null && saven2 != null){
		rs = Integer.parseInt(save);
		num1 = Integer.parseInt(saven1);
		num2 = Integer.parseInt(saven2);
		flag = 1;
	}
	
%>
<form action = "calc.jsp" method = "post">
	<fieldset>
		<input type="number" name = "n1" id = "num1" value = "<%=flag == 0 ? "" : num1%>"/> ~
		<input type="number" name = "n2" id = "num2" value = "<%=flag == 0 ? "" : num2%>"/><br/>
		 = <input type = "number" name = "result" id = "result" value = "<%=flag == 0 ? "" : rs%>"/>
		 <input type = "submit" value = "결과" />
	</fieldset>
</form>

</body>
</html>