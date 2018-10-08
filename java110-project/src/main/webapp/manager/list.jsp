<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
<title>매니저 관리</title>
<link rel='stylesheet' href='../css/common.css'>
<style>
table, td, th{
border : 1px solid gray;
text-align : center;
}
a{
text-decoration: none;
color: black;
}
</style>
</head>
<body>

<jsp:include page="../header.jsp"/>

<h1>매니저 목록(MVC)</h1>

<%-- <${detail==null ? "없는 번호 입니다." : "} --%>

<p><a href='add'>추가하기</a></p> <!-- 바로 jsp로 연결하면 안됨. 항상 servlet을 경유하도록! -->
<table>
<thead>
<tr>
<th>번호</th><th>이름</th><th>이메일</th><th>직위</th>
</tr>
</thead>
<tbody>

<c:forEach items="${list}" var="m">
<tr>
<td>${m.no}</td>
<td><a href='detail?no=${m.no}'>${m.name}</a></td>
<td>${m.email}</td>
<td>${m.position}</td>
</tr>
</c:forEach>
</tbody>
</table>
<jsp:include page="../footer.jsp"/>
</body>
</html>
