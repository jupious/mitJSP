<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ALRERT!</title>
<c:if test="${msg == 'logfail'}">
<script>
	alert('이름 또는 비밀번호를 확인해주세요'); 
	location.href= "login.chat";
</script>
</c:if>

<c:if test="${msg == 'signupsuccess' }">
<script>
	alert('회원가입을 완료했습니다. 로그인 해주세요!'); 
	location.href= "login.chat";
</script>
</c:if>

<c:if test="${msg == 'signupfail' }">
<script>
	alert('이미 존재하는 회원입니다 관리자에게 문의하세요'); 
	location.href= "signup.chat";
</script>
</c:if>
<c:if test="${msg == 'wrongAccess' }">
<script>
	alert('잘못된 접근입니다!'); 
	location.href= "login.chat";
</script>
</c:if>

</head>
<body>


</body>
</html>