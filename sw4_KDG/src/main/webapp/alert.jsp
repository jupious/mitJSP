<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Alert!</title>
</head>
<body>
<c:choose>
	<c:when test="${msg == 'modify' }">
		<script>
			alert('정보수정이 완료되었습니다!'); 
			location.href= "search.mst";
		</script>
	</c:when>
	<c:when test="${msg == 'modifyerror' }">
		<script>
			alert('정보수정중 에러가 발생하였습니다!'); 
			location.href= "search.mst";
		</script>
	</c:when>
	<c:when test="${msg == 'insert' }">
		<script>
			alert('정보 입력이 완료되었습니다!'); 
			location.href= "productin.mst";
		</script>
	</c:when>
	<c:when test="${msg == 'inserterror' }">
		<script>
			alert('정보입력중 에러가 발생하였습니다!'); 
			location.href= "productin.mst";
		</script>
	</c:when>
	<c:when test="${msg == 'delete' }">
		<script>
			alert('정보삭제가 완료되었습니다!'); 
			location.href= "search.mst";
		</script>
	</c:when>
	<c:when test="${msg == 'deleteerror' }">
		<script>
			alert('정보삭제중 에러가 발생하였습니다!'); 
			location.href= "search.mst";
		</script>
	</c:when>
	<c:when test="${msg == 'listerror'}">
		<script>
			alert('목록을 불러오는 중 에러가 발생하였습니다!'); 
			location.href= "mainMenu.mst";
		</script>
	</c:when>
</c:choose>
</body>
</html>