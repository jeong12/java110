<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%! 
int a;
private String b;
public String m1(){
    return "m1() 호출됨!";
}
%>
<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>
<h1>선언부(Declaration Element)</h1>
<pre>
- 자동으로 생성된 서블릿 클래스에 멤버를 추가할 때 사용한다.
  &lt;%! 멤버 선언 %>
  선언부에 작성한 코드는 그대로 클래스 블록 안에 복사될 것이기 때문에, 선언부를 작성하는 위치는 상관 없다.
  
- 자바코드: 멤버 선언 코드는 그대로 클래스 블록 안에 복사된다.
        class test_jsp ...{
        
                    여기에 복사 된다.(클래스 블록에)
        
        public void_jspService(){
        }
        }
- 멤버?
    - 클래스 필드 및 메서드(static field 및  method)
        static int a;
        static void m(){..}
    - 인스턴스 필드 및 메서드
        int a;
        void m() {}
    - 생성자
        class test_jsp... {
            public test_jsp(){
                 ....
            }
        }
    - 클래스 블록(static block), 인스턴스 블록
        static{
            ....
            }
</pre>
m1() : <%=m1() %><br>
m2() : <%=m2() %><br>
</body>
</html>

<%!
int c;
public String m2(){
    return "m2() 호출됨!";
}
static{ //스테틱 블록
    System.out.println("오호라.. 클래스 블록!");
}
{//인스턴스 블록
    System.out.println("이것은 인스턴스 블록!");}
%>