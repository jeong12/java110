<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL</title>
</head>
<body>
<h1>EL 표기법</h1>
<pre> 
- EL(Expression Language)
    콤마와(,) 대괄호([]) 등을 사용하여 객체의 프로퍼티나 list, set, Map 객체의
     값을 쉽게 꺼내고 설정하게 도와주는 문법이다. 
     특히 값을 꺼낼 때는 OGNL 표기법을 사용한다.
- OGNL(Object-Graph Navigation Language)
     객체의 프로터피 값을 가리는 문법이다.
     파일의 경로처럼 객체에 포함된 객체를 탐색하여 값을 쉽게 조회할 수 있다.
- 문법 ($ 다음에 띄우면 안되는데, 그러면 실행될 것 같아서 띄어씀)
    $ { 객체명.프로터티명.프로퍼티명.프로퍼티명 }
                or
    $ { 객체명["프로퍼티명"]["프로퍼티명"]["프로퍼티명"]} 

- EL에서 사용할 수 있는 객체? ($ 다음에 띄우면 안되는데, 그러면 실행될 것 같아서 띄어씀)
   pageContext : JSP의 PageContext 객체
   ServletContext : $ {pageContext.servletContext.프로퍼티명 }
          in java : pageContext.getServletContext().get프로퍼티();
   session : $ {pageContext.session.프로퍼티명 }
          in java : pageContext.getSession().get프로퍼티();
   request : $ {pageContext.request.프로퍼티명}
          in java : pageContext.getRequest().get프로퍼티();
   response
   param : $ {param.파라미터명 }
          in java : request.gerParameter("파라미터명");
   paramValues : $ {paramValues.파라미터명 }
          in java : request.ParameterValues("파라미터명");  
   header : $ {header.헤더명 }
          in java : request.gerHeader("헤더명");
   headerValues : $ {headerValues.헤더명 }
          in java : request.gerHeaders("헤더명");
   cookie : $ {cookie.헤더명 }
   initParam : $ {initParam.파라미터명}
   
   
   => 보관소에서 값을 꺼내는 문법 
   pageScope : $ {pageScope.객체이름}
          in java : pageContext.getAttribute("객체이름");
   requestScope : $ {requestScope.객체이름}
          in java : request.getAttribute("객체이름");
   sessionScope : $ {sessionScope.객체이름}
          in java : session.getAttribute("객체이름");
   applicationScope : $ {applicationScope.객체이름}
          in java : application.getAttribute("객체이름");   
</pre>
</body>
</html>