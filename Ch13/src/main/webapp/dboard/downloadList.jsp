<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix = "c" uri = "jakarta.tags.core" %>
 <%@ taglib prefix = "fmt" uri = "jakarta.tags.fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일목록</title>
<script src="https://code.jquery.com/jquery-3.7.1.slim.js" integrity="sha256-UgvvN8vBkgO0luPSUl2s8TIlOSYRoGFAX4jlCIm9Adc=" crossorigin="anonymous"></script>
</head>
<body>
<h2>DB에 등록된 파일 목록 보기</h2>

<a href = "upload.do" method = "get">파일등록1</a>
<table border = "1">
	<tr><th>No</th><th>제목</th><th>카테고리</th><th>원본 파일명</th><th>작성일</th><th>삭제</th></tr>
	<c:forEach var = "file" items = "${List}">
	<fmt:formatDate var="dateString" value="${file.postdate}" pattern="yyyy년MM월dd일 (E) HH:mm:ss" />
		<tr>
			<td id = "num">${file.idx}</td>
			<td><c:out value = "${file.title}" /></td>
			<td>${file.cate}</td>
			<td><a href ="upload/${file.sfile}">${file.ofile}</a></td>
			<td>${dateString}</td>
			<td><a href ="#" id = "delete_link">X</a></td>
		</tr>
	</c:forEach>
</table>
<form action = "delete.do" method = "post" id = "form1" >
	<input id = "idx" type = "number" name = "idx" hidden />
</form>
전체 글 수 : ${Count}<br/>
<script>
	$(function (){
		$('a#delete_link').on("click", function(e){
			e.preventDefault; //이 요소에 걸려있는 이벤트 무시(지금은 href링크 무시함)
			console.log("버튼클릭")
			var formObj = $('#form1'); //id가 form1인 요소를 읽어서 js변수에 저장
			var idx = $(this).parent().parent().children("#num").text();
			console.log(idx)
			$('#idx').val(idx);
			console.log($('#idxf').val())
			//formObj.number(${file.idx});
			formObj.submit();
		})
	})
	
</script>

</body>
</html>