<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Test26 - 4페이지</h1>

<form action="m5" method="post">
과목<br>
<input type="checkbox" name="language" value="java"> Java<br>
<input type="checkbox" name="language" value="c/c++"> C/C++<br>
<input type="checkbox" name="language" value="sql"> SQL<br>
<input type="checkbox" name="language" value="python"> Python<br>
<input type="checkbox" name="language" value="javascript"> JavsScript<br>
<!-- 만약 체크하지 않으면 null로 넘어감 -->
<button>다음</button>
</form>

</body>
</html>