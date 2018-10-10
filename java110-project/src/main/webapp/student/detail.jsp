<%@page import="bitcamp.java110.cms.domain.Student"%>
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
}
#photo-image {
    height: 100px;
}
</style>
</head>
<body>

<jsp:include page="../header.jsp"/>

<h1>학생 상세정보(MVC)</h1>
<table>
<tbody>
<tr><th>번호</th><td>${detail.no}</td></tr>
<tr><th>이름</th><td>${detail.name}</td></tr>
<tr><th>이메일</th><td>${detail.email}</td></tr>
<tr><th>암호</th><td>${detail.password}</td></tr>
<tr><th>전화</th><td>${detail.tel}</td></tr>
<tr><th>최종학력</th><td>${detail.school}</td></tr>
<tr><th>재직여부</th><td>${detail.working}</td></tr>
<tr>
<th>사진</th>
<c:choose>
<c:when test="${not empty detail.photo}">
<td><img id='photo-image' src='/upload/${detail.photo}'></td>
</c:when>
<c:otherwise>
<td><img id='photo-image' src='/img/anonymous.png'></td>
</c:otherwise>
</c:choose>
</tr>
</tbody>
</table>
<button type='button' onclick ='remove()'>삭제</button>
<script>
function remove() {
    location.href='delete?no=${detail.no}'}
</script>

<jsp:include page="../footer.jsp"/>

</body>
</html>
