<%@page import="my.MyCalc"%>
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
	int sum=0;
	String sNum1=request.getParameter("num1");
	String sNum2=request.getParameter("num2");
	boolean flag=true; //true:최초접속 , false:결과출력
	if(sNum1 != null && !sNum1.equals("")){
		MyCalc myCalc = new MyCalc(sNum1,sNum2);
		sum=myCalc.sum();
		flag=false;
	}

%>
<form method="get" >
<%if(flag){ %>
	<input type="number" name="num1"> ~ <input type="number" name="num2"> <br>
	=<input type="number"   > 
	<%}else{ %>
	<input type="number" name="num1" value="<%=sNum1%>"> ~ 
	<input type="number" name="num2" value="<%=sNum2%>"> <br>
	=<input type="number" value="<%=sum%>"  > 
	<%} %>
	<input type="submit" value="결과">
</form>
</body>
</html>
