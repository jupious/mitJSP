<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String chkVal = request.getParameter("val");

if (chkVal != null) {
    Cookie cookie = new Cookie(chkVal, "off");  
    cookie.setPath(request.getContextPath());  
    cookie.setMaxAge(60*60*24);  
    response.addCookie(cookie);  
    out.println("팝업"+chkVal+": 하루 동안 열지 않음");  
}
%>


  