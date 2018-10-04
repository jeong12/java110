<%@page import="bitcamp.java110.cms.domain.Manager"%>
<%@page import="java.util.List"%>
<%@page import="bitcamp.java110.cms.dao.ManagerDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>

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
<p><a href='add'>추가하기</a></p> <!-- 바로 jsp로 연결하면 안됨. 항상 servlet을 경유하도록! -->
<table>
<thead>
<tr>
<th>번호</th><th>이름</th><th>이메일</th><th>직위</th>
</tr>
</thead>
<tbody>
<%
List<Manager> list =(List<Manager>) request.getAttribute("list");
for (Manager m : list) {
%>
<tr>
<td><%=m.getNo() %></td>
<td><a href='detail?no=<%=m.getNo()%>'><%=m.getName()%></a></td>
<td><%=m.getEmail() %></td>
<td><%=m.getPosition() %></td>
</tr>
<%
}
%>
</tbody>
</table>
<jsp:include page="../footer.jsp"/>
</body>
</html>
