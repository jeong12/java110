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
<h1>JSP:useBean - Type 속성</h1>
<pre>
- 지정한 타입의 객체가 보관소에 없으면 예외 발생! "객체를 만들지 않는다."
        &lt;jsp:useBean
            scope="request"
            id="name"
            type="java.util.ArrayList"/>                        
</pre>
<%
ArrayList<String> list1 = new ArrayList<>();
list1.add("홍길동");
list1.add("임꺽정");
list1.add("유관순");
// pageContext 보관소
request.setAttribute("name",list1);
%>

<jsp:useBean scope="request" id="name" type="java.util.ArrayList"/>

<%--
위 태그는 다음과 같이 동작하는 자바 코드로 변환된다.
자바 코드:
java.util.ArrayList name=(java.util.ArrayList)pageContext.getAttribute("name");
if(name == null){
    throw new Exception("해당 타입의 객체가 없습니다!");
}
 --%>


<p>name[] : <%=name%></p>
<p>name.get(1): <%=name.get(1)%></p>

<hr>

<jsp:useBean scope="request" id="name2" type="java.util.ArrayList"/>

<%--
위 태그는 다음과 같이 동작하는 자바 코드로 변환된다.
자바 코드:
java.util.ArrayList name=(java.util.ArrayList)request.getAttribute("name2");
if(name2 == null){
    throw new Exception("해당 타입의 객체가 없습니다!");
}
 --%>
 
 <p>name2의 크기: <%=name2.size()%></p>
</body>
</html>
