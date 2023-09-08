<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일 업로드</title>
</head>
<body>
<h3>파일 업로드</h3>
<form action="uploadpro.do" method = "post" enctype = "multipart/form-data">
	제목 : <input type = "text" name = "title" /><br/>
	카테고리(선택사항): 
	<input type = "checkbox" name = "cate" id = "photo" value = "사진" /><label for = "photo">사진</label>
	<input type = "checkbox" name = "cate" id = "task" value = "과제" /><label for = "task">과제</label>
	<input type = "checkbox" name = "cate" id = "word" value = "워드" /><label for = "word">워드</label>
	<input type = "checkbox" name = "cate" id = "music" value = "음원" /><label for = "music">음원</label><br/>
	첨부파일 : <input type = "file" name = "ofile" /><br/>
	<input type = "submit" value = "전송하기" />
</form>
</body>
</html>