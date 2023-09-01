<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String popup1 = "on";
	String popup2 = "on";
	String popup3 = "on";
	System.out.println(popup1);
	System.out.println(popup2);
	System.out.println(popup3);
	Cookie[] cookies = request.getCookies();
	if(cookies != null){
		for(Cookie c : cookies){
			String cName = c.getName();
			String cValue = c.getValue();
			if(cName.equals("PopupClose1")){
				popup1 = cValue;
			}else if(cName.equals("PopupClose2")){
				popup2 = cValue;
			}else if(cName.equals("PopupClose3")){
				popup3 = cValue;
			}
		}
	}
	System.out.println(popup1);
	System.out.println(popup2);
	System.out.println(popup3);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	div#popup1{
        position: absolute; top:100px; left:100px; color:yellow;  
        width:300px; height:100px; background-color:gray;
    }
    div#popup2{
    	posistion: fixed; top: 300px; right: 0px; color:green;
    	width : 300px; height: 100px; background-color: black;
    }
    div#popup3{
    	position: fixed; top: 300px; right: 0px; color:blue;
    	width : 300px; height: 100px; background-color: silver;
    }
    div.pop{
    	 position: relative; background-color:white; top:0px;
         width: 300px;	border:1px solid gray; padding:0px; color:black;
    }
</style>
<script
    src="https://code.jquery.com/jquery-3.7.1.js">
</script>
<script>
	$(function() {
		$("#closeBtn1").click(function() {
			$("#popup1").hide();
	
	
		})
		$("#closeBtn2").click(function(){
			$("#popup2").hide();
	
			
		})
		$("#closeBtn3").click(function(){
			$("#popup3").hide();
			
			
		})
		$(".cButton").click(function(){
			if($("input:checkbox[id=inactiveToday1]:checked").is(":checked")){
				<%
				Cookie cookie1 = new Cookie("popup1","1");
				cookie1.setMaxAge(10);
				response.addCookie(cookie1);
				%>
			}
			if($("input:checkbox[id=inactiveToday2]:checked").val() == "2"){
				<%
				Cookie cookie2 = new Cookie("popup2","2");
				cookie2.setMaxAge(10);
				response.addCookie(cookie2);
				%>
			}
			if($("input:checkbox[id=inactiveToday3]:checked").val() == "2"){
				<%
				Cookie cookie3 = new Cookie("popup3","3");
				cookie3.setMaxAge(10);
				response.addCookie(cookie3);
				%>
			}
			//location.reload();
		})
	})
</script>
</head>
<body>
<%
        out.print("현재 팝업창 : " + popup1 + " 상태 <br/>");
    if (popup1.equals("on")) {
%>
    <div id="popup1" >
        <h2 align="center">공지사항 팝업입니다.</h2>
        <div align="right" class = "pop">
	        <form name="popFrm">
	            <input type="checkbox" id="inactiveToday1" value="1" />
	            하루 동안 열지 마라1
	            <input type="button" value="닫기" id="closeBtn1" class = "cButton" />
	        </form>
        </div>
    </div>
<%
    }
%>
<%
    out.print("현재 팝업창2 : " + popup2 + " 상태 <br/>");
    
    if (popup2.equals("on")) {
%>
    <div id="popup2" class = "pop">
        <h2 align="center">공지사항 아닙니다.</h2>
        <div align="right" class = "pop">
	        <form name="popFrm">
	            <input type="checkbox" id="inactiveToday2" value="2" />
	            하루 동안 열지 마라2
	            <input type="button" value="닫기" id="closeBtn2" class = "cButton" />
	        </form>
        </div>
    </div>
<%
    }
%>
<%
    out.print("현재 팝업창3 : " + popup3 + " 상태 <br/>");

    if (popup3.equals("on")) {
%>
    <div id="popup3" class = "pop">
        <h2 align="center">공지사항 인가?</h2>
        <div align="right" class = "pop">
	        <form name="popFrm">
	            <input type="checkbox" id="inactiveToday3" value="3" />
	            하루 동안 열지 마라3
	            <input type="button" value="닫기" id="closeBtn3" class = "cButton" />
	        </form>
        </div>
    </div>
<%
    }
%>
</body>
</html>