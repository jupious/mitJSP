<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>오늘의 로또번호는</h2>
	<%
		List<Integer> list = new ArrayList<>();
		Random rand = new Random();
		int lnum, cnum = 0, min;
		for(int i = 0; i < 6; i++){	
		 	lnum = rand.nextInt(45)+1;
		 	do{
		 		for(int num : list){
		 			cnum = num;
					if(lnum == cnum){
						lnum = rand.nextInt(45)+1;
					}
				}
		 	}while(lnum == cnum);
			
		 	list.add(lnum);	
		}
		
		for(int i = 0; i < 6; i++){
			min = list.get(0);
			for(int sort : list){
				if(min >= sort){
					min = sort;
				}
			}
			list.remove(Integer.valueOf(min));%>
			
			<%=min %>
	<%	}
	%>
	
</body>
</html>