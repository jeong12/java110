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
<h1>JSP:useBean - 보관소에 객체가 없을 떄?</h1>
<pre>
- 보관소에 객체가 없으면 class 속성에 지정된 타입으로 객체를 만든다.
        &lt;jsp:useBean
            scope="request"
            id="name"
            class="java.util.ArrayList"/>                        
</pre>
<%
ArrayList<String> list1 = new ArrayList<>();
list1.add("홍길동");
list1.add("임꺽정");
list1.add("유관순");
// pageContext 보관소
request.setAttribute("name",list1);
%>

<jsp:useBean scope="request" id="name" class="java.util.ArrayList"/>

<%--
위 태그는 다음과 같이 동작하는 자바 코드로 변환된다.
자바 코드:
java.util.ArrayList name=(java.util.ArrayList)pageContext.getAttribute("name");
if(name == null){
    name = new java.util.ArrayList();
    pageContext.setAttribute("name",name);
}
 --%>


<p>name[] : <%=name%></p>
<p>name.get(1): <%=name.get(1)%></p>

<hr>

<jsp:useBean scope="request" id="name2" class="java.util.ArrayList"/>

<%--
위 태그는 다음과 같이 동작하는 자바 코드로 변환된다.
자바 코드:
java.util.ArrayList name=(java.util.ArrayList)request.getAttribute("name2");
if(name2 == null){
    name2 = new java.util.ArrayList();
    request.setAttribute("name2",name2);
}
 --%>
 
 <p>name2의 크기: <%=name2.size()%></p>
</body>
</html>
