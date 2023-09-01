<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
MVC에서 화면담당 View<br/>
JSP로 만들어지고 화면에대한 내용만 만듬<br/>
화면을 만들때 필요한 내용은 컨트롤러에서 보내줌<br/>
컨트롤러에서는 내용을 request객체에 넣어서 보냄<br/>
보내온 데이터는 EL을 이용해서 사용합니다.
<hr/>
보내온 데이터 :
 ${data[0].content}
 ${data[1].content}
 ${data[2].content}

</body>
</html>