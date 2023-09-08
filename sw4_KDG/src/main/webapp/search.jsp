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
    <script src="https://code.jquery.com/jquery-3.7.1.slim.js" integrity="sha256-UgvvN8vBkgO0luPSUl2s8TIlOSYRoGFAX4jlCIm9Adc=" crossorigin="anonymous"></script>
</head>
<body>
    <h2>생산관리 조회 & 수정 화면</h2>
    
        <fieldset>
        	<legend>생산관리 조회화면</legend>
            <form action="search.mst" method="get" id = "mainform">
                <ul>
                    <li>제품코드 &nbsp;<input type="text" name = "code" id = "codestr" autofocus></li>
                    <li>제품이름 &nbsp;<input type="text" name = "pname" id = "pnamestr"></li>
                    <li>제품원가 &nbsp;<input type="text" name = "cost" id = "coststr"></li>
                    <li>목표수량 &nbsp;<input type="text" name = "pnum" id = "pnumstr"></li>
                    <li>재고수량 &nbsp;<input type="text" name = "jnum" id = "jnumstr"></li>
                    <li>출고가 &nbsp;&nbsp; <input type="text" name = "sale" id = "salestr"></li>
                    <li>그룹이름 <select name = "gname" id = "gnamestr">
                    	<c:forEach var = "gname" items = "${gnameList}">
                    		<option value="${gname.gname}" >${gname.gname}</option>
                    	</c:forEach>
                    </select></li>
                </ul>
                <input type = "text" name = "ogCode" id = "ogCode" hidden />
                <input class = "buttonss" type="submit" value = "조 회" id = "needed" />
                <input class = "buttonss" type="button" value="수 정" id = "modifier">
                <input class = "buttonss" type="button" value="삭 제" id = "deleter">
                <a href="mainMenu.mst">
                    <input class="buttonss" type="button" value="메인화면"></a>                
            </form>       	
        </fieldset>
 <form action = "delete.mst" method = "post" id = "deleteform" >
 	<input type = "text" name = "code" id = "code" hidden>
 </form>
 <script>
	
	
 	$(function (){
 		$('input#deleter').on("click", function(e) {
 			e.preventDefault;
 			var dform = $('#deleteform');
 			console.log("삭제 버튼 클릭됨")	
 			var pcode = $('#codestr').val();
 			console.log(pcode);
 			$('#code').val(pcode);
 			console.log($('#code').val())
 			dform.submit();
 		})
 		$('input#modifier').on("click", function(e) {
 			var mform = $('#mainform')
 			e.preventDefault;
 			mform.attr("method", "post");
 			mform.attr("action","modify.mst");
 			mform.submit();
 		})
 	})
 </script>

 <script>
 	var code = "<c:out value = '${result.code}' />";
	var pname = "<c:out value = '${result.pname}' />";
	var cost = "<c:out value = '${result.cost}' />";
	var pnum = "<c:out value = '${result.pnum}' />";
	var jnum = "<c:out value = '${result.jnum}' />";
	var sale = "<c:out value = '${result.sale}' />";
	var gname = "<c:out value = '${result.gname}' />";
	if(gname == "" ){
		gname = "<c:out value = '${gnameList[0].gname}' />";
		console.log(gname);
	}
			
	$('#codestr').val(code);
	$('#pnamestr').val(pname);
	$('#coststr').val(cost);
	$('#pnumstr').val(pnum);
	$('#jnumstr').val(jnum);
	$('#salestr').val(sale);
	$('#gnamestr option[value ='+ gname+']').prop('selected','selected').change();
	$('#ogCode').val(code);
	console.log(code,pname,cost,pnum,jnum,sale,gname);
		
 </script>
 
</body>
</html>