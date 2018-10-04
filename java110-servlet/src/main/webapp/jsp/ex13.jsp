<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces = "true"
    isErrorPage="true"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP 액션 태그</title>
</head>
<body>
<h1>JSP:setProperty - 객체의 셋터 호출하기</h1>
<jsp:useBean scope="request" id="m1" class="bitcamp.java110.Member"/>

<jsp:setProperty name="m1" property="no" value="100"/>
<jsp:setProperty name="m1" property="name" value="홍길동"/>
<jsp:setProperty name="m1" property="email" value="hong@test.com"/>
<jsp:setProperty name="m1" property="tel" value="1111-2222"/>

<p>
번호:<%=m1.getNo()%>, ${m1.no}<br> <%-- 전자는 과거 기술. 후자가 최근이자 가장 많이 쓰는 것!(el) --%>
이름:<%=m1.getName()%><br>
이메일:<%=m1.getEmail()%><br>
전화:<%=m1.getTel()%><br>
</p>
</body>
</html>
