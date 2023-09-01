<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String popup1 = "on";
	String popup2 = "on";
	String popup3 = "on";

	Cookie[] cookies = request.getCookies();
	if(cookies != null){
		for(Cookie c : cookies){
			String cName = c.getName();
			String cValue = c.getValue();
			if(cName.equals("1")){
				popup1 = cValue;
			}else if(cName.equals("2")){
				popup2 = cValue;
			}else if(cName.equals("3")){
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
		//$(document).on("click",".cButton",function() {}) 이렇게도 사용가능(매개변수를 동적으로 이용하고 싶을때)
		$("#closeBtn1").click(function() {
			$("#popup1").hide();
	
	
		});
		$("#closeBtn2").click(function(){
			$("#popup2").hide();
	
			
		});
		$("#closeBtn3").click(function(){
			$("#popup3").hide();
			
			
		});
		$(".cButton").click(function(){
			var chkVal = $(this).siblings(".inactiveToday:checked").val();
			console.log(chkVal);
			var popupToday = {};
			popupToday.val = chkVal;
			if(chkVal >=1 && chkVal<=3){
				$.ajax({
		            url : 'PopupCookie.jsp',
		            type : 'get',
		            data : popupToday,
		            dataType : "text",
		            success : function(data) {
		            	//console.log(data);
		            }
		        });
			}
			
		});
	});
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
	            <input type="checkbox" class ="inactiveToday" value="1" id = "p1" />
	            <label for = "p1">하루 동안 열지 마라</label>
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
	            <input type="checkbox" class ="inactiveToday" value="2" id = "p2" />
	            <label for = "p2">하루 동안 열지 마라</label>
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
	            <input type="checkbox" class="inactiveToday" value="3" id = "p3" />
	            <label for = "p3">하루 동안 열지 마라</label>
	            
	            <input type="button" value="닫기" id="closeBtn3" class = "cButton" />
	        </form>
        </div>
    </div>
<%
    }
%>
</body>
</html>