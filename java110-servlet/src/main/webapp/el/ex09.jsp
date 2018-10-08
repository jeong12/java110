<%@page import="bitcamp.java110.Member"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL</title>
</head>
<body>
<h1>EL - 연산자</h1>

<h3>산술 연산자</h3>
10 + 20 = ${10+20}<br>
10 - 20 = ${10-20}<br>
10 * 20 = ${10*20}<br>
10 / 20 = ${10/20}<br>
10 div 20 = ${10 div 20}<br>
10 % 20 = ${10%20}<br>
10 mod 20 = ${10 mod 20}<br>

<h3>논리 연산자</h3>
true && false = ${true && false }<br>
true and false = ${true and false }<br>
true || false = ${true || false }<br>
true or false = ${true or false }<br>
!true = ${!true }<br>
not true = ${not true }<br>

<h3>관계 연산자</h3>
100 == 200 = ${100 == 200}<br>
100 eq 200 = ${100 eq 200}<br>
100 != 200 = ${100 != 200}<br>
100 ne 200 = ${100 ne 200}<br>
100 > 200 = ${100 > 200}<br>
100 gt 200 = ${100 gt 200}<br>
100 >= 200 = ${100 >= 200}<br>
100 ge 200 = ${100 ge 200}<br>
100 &lt; 200 = ${100 < 200}<br>
100 lt 200 = ${100 lt 200}<br>
100 &lt;= 200 = ${100 <= 200}<br>
100 le 200 = ${100 le 200}<br>

<h3>empty</h3>
<p>보관소에 해당 객체가 없는지 검사한다.
   없으면 true, 있으면 false.</p>
<%
pageContext.setAttribute("name", new String("홍길동"));
%>
name 값이 없는가? ${empty name}<br>
name2 값이 없는가? ${empty name2}<br>

<h3>조건 연산자 - 조건 ? 식1 : 식2</h3>
name == "홍길동" : ${name == "홍길동" ? "맞다!" : "아니다!" }

<%
String a = "홍길동"; //상수 스트링
String b = new String("홍길동"); //힙 메모리 스트링

if(a == b){ //인스턴스 주소를 비교!
    out.println("==: 같다!<br>");
}else{
    out.println("==: 다르다!<br>");
}

if(a.equals(b)){ //인스턴스 값을 비교!
    out.println("equals() : 같다!<br>");
}else{
    out.println("equals() : 다르다!<br>");
}

%>



</body>
</html>