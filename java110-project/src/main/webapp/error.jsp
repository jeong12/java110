<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>!실행 오류!</title>
<link rel='stylesheet' href='/css/common.css'>
</head>
<body>
<jsp:include page="/header.jsp"/>
<%
Exception e = (Exception) request.getAttribute("error");
String message = (String) request.getAttribute("message");
String refresh = (String) request.getAttribute("refresh");

if(refresh!=null) {
    response.setHeader("Refresh", refresh);
}       

%>

<h1><%=message %></h1> 
<p><%=e%></p>
<p>잠시 기다리시면 목록 페이지로 자동으로 이동합니다.</p>
<jsp:include page="/footer.jsp"/>
</body>
</html>