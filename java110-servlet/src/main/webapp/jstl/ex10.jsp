<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL</title>
</head>
<body>
	<h1>JSTL - c:import</h1>
	<pre> 
- HTTP 요청을 수행하는 코드를 만든다.
</pre>

	<h3>HTTP검색 요청하기</h3>
	
	<c:url value="http://localhost:8888/jstl/ex05.jsp" var="url1">
		<c:param name="name" value="홍길동"></c:param>
		<c:param name="age" value="20"></c:param>
		<c:param name="gender" value="man"></c:param>
	</c:url>

<%--지정된 URL을 요청하고 서버로부터 받은 콘텐츠를 contents라는 이름으로 PageContext 보관소에 저장한다. --%>
<c:import url="${url1}" var="contents"/>
<textarea cols="120" rows="20">${pageScope.contents}</textarea>

</body>
</html>