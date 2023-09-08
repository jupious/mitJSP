<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>일학습병행제 평가</title>
    <link type="text/css" rel="stylesheet" href="stylesheet.css"/>
</head>
<body>
    <h2>생산관리 등록화면</h2>
    
        <fieldset>
            <legend>생산관리 등록화면</legend>
            <form action="input.mst" method="get">
                <ul>
                    <li>제품코드 &nbsp;<input type="text" name = "code" autofocus /></li>
                    <li>제품이름 &nbsp;<input type="text" name = "pname"></li>
                    <li>제품원가 &nbsp;<input type="number" name = "cost" required /></li>
                    <li>목표수량 &nbsp;<input type="number" name = "pnum" required /></li>
                    <li>재고수량 &nbsp;<input type="number" name = "jnum" required /></li>
                    <li>출고가 &nbsp; &nbsp; <input type="number" name = "sale" required /></li>
                    <li>그룹이름&nbsp; <select name = "gname">
                    		<c:forEach var = "gname" items = "${gnameList}">
                    			<option value="${gname.gname}" >${gname.gname}</option>
                    		</c:forEach>
                    	</select></li>
                </ul>
                <input class = "buttonss" type="submit" value="등 록" id ="needed">
                <a href="mainMenu.mst">
                    <input class="buttonss" type="button" value="메인화면"></a>
            </form>
        </fieldset>
        
  
</body>
</html>