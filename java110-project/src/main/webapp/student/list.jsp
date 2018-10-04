<%@page import="bitcamp.java110.cms.domain.Student"%>
<%@page import="bitcamp.java110.cms.domain.Manager"%>
<%@page import="java.util.List"%>
<%@page import="bitcamp.java110.cms.dao.ManagerDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>

<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
<title>학생 관리</title>
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

<h1>학생 목록(MVC)</h1>
<p><a href='add'>추가하기</a></p> <!-- 바로 jsp로 연결하면 안됨. 항상 servlet을 경유하도록! -->
<table>
<thead>
<tr>
<th>번호</th><th>이름</th><th>이메일</th><th>최종학력</th><th>재직여부</th>
</tr>
</thead>
<tbody>
<%
List<Student> list =(List<Student>) request.getAttribute("list");
for (Student s : list) {
%>
<tr>
<td><%=s.getNo() %></td>
<td><a href='detail?no=<%=s.getNo()%>'><%=s.getName()%></a></td>
<td><%=s.getEmail() %></td>
<td><%=s.getSchool() %></td>
<td><%=s.isWorking() %></td>
</tr>
<%
}
%>
</tbody>
</table>
<jsp:include page="../footer.jsp"/>
</body>
</html>
