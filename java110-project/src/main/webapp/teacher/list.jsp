<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
<title>강사 관리</title>
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

<h1>강사 목록(MVC)</h1>
<p><a href='add'>추가하기</a></p> <!-- 바로 jsp로 연결하면 안됨. 항상 servlet을 경유하도록! -->
<table>
<thead>
<tr>
<th>번호</th><th>이름</th><th>이메일</th><th>시급</th><th>과목들</th>
</tr>
</thead>

<c:forEach items="${list}" var="t">
<tr>
<td>${t.no}</td>
<td><a href='detail?no=${t.no}'>${t.name}</a></td>
<td>${t.email}</td>
<td>${t.pay}</td>
<td>${t.subjects}</td>
</tr>
</c:forEach>
</tbody>
</table>
<jsp:include page="../footer.jsp"/>
</body>
</html>
