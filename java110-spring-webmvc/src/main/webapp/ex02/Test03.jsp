<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Test03 페이지 컨트롤러</title>
</head>
<body>
<h1>Test03 페이지 컨트롤러</h1>
<a href="/app/ex02/text03/m1">test03/m1 요청합니다.</a>
name: ${requestScope.name}<br>
age: ${requestScope.age}<br>
</body>
</html>