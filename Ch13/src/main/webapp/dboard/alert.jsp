<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix = "c" uri = "jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ALRERT!</title>
<c:if test="${msg == 'delete'}">
<script>
	var res = confirm('삭제 하시겠습니까?(실제 파일도 삭제됩니다.)');
	var idx = ${idx};
	if(res){
		alert("삭제되었습니다.");
		location.href = "delete.do?flag=true&idx="+idx;
		
	}else{
		alert("삭제를 취소합니다.");
		location.href = "delete.do?flag=false&idx="+idx;
	}
</script>
</c:if>


</head>
<body>

</body>
</html>