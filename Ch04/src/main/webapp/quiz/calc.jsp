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
	String a = request.getParameter("n1");
	String b = request.getParameter("n2");
	int num1 = 0,num2 = 0,temp, sum=0, t1, t2;
	if(a != null && b != null){
		num1 = Integer.parseInt(a);
		num2 = Integer.parseInt(b);
	}
	t1 = num1;
	t2 = num2;
	if(t1 > t2){
		temp = t1;
		t1 = t2;
		t2 = temp;
	}
	for(int i = t1; i<=t2;i++){
		sum+=i;
	}
	
	Cookie cookie = new Cookie("result",Integer.toString(sum));
	Cookie cookie1 = new Cookie("nu1",Integer.toString(num1));
	Cookie cookie2 = new Cookie("nu2",Integer.toString(num2));
	response.addCookie(cookie);
	response.addCookie(cookie1);
	response.addCookie(cookie2);
	response.sendRedirect("quiz1.jsp");
%>
</body>
</html>