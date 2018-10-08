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
<h1>JSP:include - RequestDispatcher.include()</h1>
<pre>
- 다른 서블릿(또는 JSP)의 실행을 포함할 때 사용한다.
  &lt;jsp:include page="서블릿 또는 JSP URL">
cf) %lt;%@  %> 파일을 포함시키는 것. include는 파일은 각각있고 실행만 이루어짐
</pre>
<jsp:include page="ex14_header.jsp"></jsp:include>

<p>내용입니다.</p>

<jsp:include page="ex14_footer.jsp"></jsp:include>

</body>
</html>
