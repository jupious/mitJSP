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
	int num1 = Integer.parseInt(request.getParameter("num1"));
	int num2 = Integer.parseInt(request.getParameter("num2"));
	int temp, sum = 0;
	
	if(num1 > num2){
		temp = num1;
		num1 = num2;
		num2 = temp;
	}

	for(int i = num1 ; i <= num2; i++){
		if(i%2 == 1)
			sum+=i;
	}
%>
홀수만 다 더한값은 <%=sum%><br/>
<a href = "index.jsp">처음으로</a>

</body>
</html>