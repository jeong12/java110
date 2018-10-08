<%@page import="bitcamp.java110.cms.domain.Teacher"%>
<%@page import="bitcamp.java110.cms.domain.Manager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>

<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
<title>강사 관리</title>
<link rel='stylesheet' href='../css/common.css'>
<style>
table, td, th{
border : 1px solid gray;
}
</style>
</head>
<body>

<jsp:include page="../header.jsp"/>

<h1>강사 상세정보(MVC)</h1>

<table>
<tbody>
<tr><th>번호</th><td>${detail.no}</td></tr>
<tr><th>이름</th><td>${detail.name}</td></tr>
<tr><th>이메일</th><td>${detail.email}</td></tr>
<tr><th>암호</th><td>${detail.password}</td></tr>
<tr><th>전화</th><td>${detail.tel}</td></tr>
<tr><th>시급</th><td>${detail.pay}</td></tr>
<tr><th>과목들</th><td>${detail.subjects}</td></tr>
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
