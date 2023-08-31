<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%	//쿠키확인
	Cookie[] cookies = request.getCookies();
	//쿠키검사
	String idVal = "";	//"":로그아웃된 상태(로그인화면), ""이아니면 로그인된 사용자(로그인된 화면)
	int state = 2; //1로그인화면 2로그인성공 3로그인 실패
	String save = "";
	
	if(cookies != null){
		for(Cookie c : cookies){
			if(c.getName().equals("id")){
				idVal = c.getValue();
			}
		}
	}
	
	
	
	if(idVal.equals("")){// 로그인이 안돼있다면
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String[] saveID = request.getParameterValues("saveID");
		
		if(saveID != null){
			for(String str : saveID){
				if(str.equals("on")){%>
				<script>
					document.getElementById("id").value = "<%=id%>";
				</script>
<%					
				}
				
			}
		}
		
		
		
		if(id != null ){	//로그인 시도
			if(id.matches("^[\\w]+$")){
				if(pw.equals("1234")){
					Cookie cookie = new Cookie("id",id);
					response.addCookie(cookie);
				}else{	//로그인 실패
					state = 3;
				}
			}else{
				state = 1;%>
				<script>
					alert("아이디에 허용되지 않는 문자가 있습니다.")
				</script>
	<%
			}
			
		}else{
			state = 1;
		}
	}
	
%>
<%	
	if(state == 1 || state == 3){	//로그인 성공이 아니면
%>
<form action = "" method = "post">
	<fieldset style="width:90px;" >
			I D : <input type = "text" name = "id"  id = "id" autofocus required /><br/>
			PW : <input type = "password" name = "pw" required /><br/><br/>
			<input type = "submit" value = "로그인" /><br/>
			<input type="checkbox" id ="id" name = "saveID">
			<label for="id">아이디 기억하기</label>
	</fieldset>
</form>
<%	}else if(state == 2){%>
		<%=idVal%> 님 환영합니다.
		<a href = "logout.jsp" ><button >로그아웃</button></a>
<%	}
	if(state == 3){%>
	<script>
	alert("아이디 또는 패스워드를 확인해주세요")
	</script>
<%}%>
</body>
</html>