<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Test14 페이지 컨트롤러</title>
</head>
<body>
<h1>Test14 페이지 컨트롤러</h1>
[Car]<br>
mode: ${requestScope.car.model}<br>
maker: ${car.maker}<br>
auto: ${car.auto}<br>
[Engine]<br>
name:${car.engine.name}<br>
cc:${car.engine.cc}<br>
valve:${car.engine.valve}<br>

</body>
</html>