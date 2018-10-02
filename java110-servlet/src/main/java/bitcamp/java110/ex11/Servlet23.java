/*세션의 원리 - 타임 아웃
 *  타임아웃?
 *  => 서블릿 컨테이너의 설정 파일에서 세션 타임아웃 시간을 설정할 수 있다.
 *  => 각각의 세션 객체에 대해 타임아웃을 설정할 수 있다. 
 *  
 */

package bitcamp.java110.ex11;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ex11/servlet23")
public class Servlet23 extends HttpServlet{
    private static final long serialVersionUID = 1L;
    
    @Override
    protected void doGet(
            HttpServletRequest request, 
            HttpServletResponse response) 
                    throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    
    /* 세션 타임 아웃
 *  => 서블릿 컨테이너의 설정 파일에서 세션 타임아웃 시간을 설정할 수 있다.
 *      ex) 톰캣 서버인 경우, (web.xml파일)에서 설정
 *  => 각각의 세션 객체에 대해 타임아웃을 설정할 수 있다. 
 *  session.setMaxInactiveInterval(10);
     */    
    HttpSession session = request.getSession();
    //session.setMaxInactiveInterval(10); //단위는 초(second)
    
    //세션에 데이터 보관하기
    session.setAttribute("name", "임꺽정");
    
    //테스트:
    //=> 이 서블릿을 실행한 후 10초 이전에 /ex11/servlet22 실행하기
    //=> 그리고 다시 10초가 지난 후에 /ex11/servlet22 실행하기
    
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset='UTF-8'>");
    out.println("<title>session</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>세션 타임아웃</h1>");
    out.println("</body>");
    out.println("</html>");
    }
}

/* 테스트 결과
 * 1st servlet 22
 * response header
 * HTTP/1.1 200
 * Content-Type: text/html;charset=UTF-8
 * Content-Length: 162
 * Date: Tue, 02 Oct 2018 01:17:47 GMT

 * request Header
  * GET /ex11/servlet22 HTTP/1.1
  * Host: localhost:8888
  * Connection: keep-alive
  * Pragma: no-cache 
  * Cache-Control: no-cache 
  * Upgrade-Insecure-Requests: 1
  * User-Agent: Mozilla/5.0 (Windows NT 6.3; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.100 Safari/537.36
  * Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,
  * Accept-Encoding: gzip, deflate, br
  * Accept-Language: ko-KR,ko;q=0.9,en-US;q=0.8,en;q=0.7
  * Cookie: working=true; JSESSIONID=1B4D13CE15DB7482064A677AEE0BC400

2nd servlet 22
response header
 HTTP/1.1 200
 Set-Cookie: JSESSIONID=50C7330BE1EFAED3690244F3ED480E32; Path=/; HttpOnly
 Content-Type: text/html;charset=UTF-8
 Content-Length: 157
 Date: Tue, 02 Oct 2018 01:18:24 GMT

request header
Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,
Accept-Encoding: gzip, deflate, br
Accept-Language: ko-KR,ko;q=0.9,en-US;q=0.8,en;q=0.7
Cache-Control: no-cache
Connection: keep-alive
Cookie: working=true; JSESSIONID=1B4D13CE15DB7482064A677AEE0BC400
Host: localhost:8888
Pragma: no-cache
Upgrade-Insecure-Requests: 1
User-Agent: Mozilla/5.0 (Windows NT 6.3; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.100 Safari/537.36
 */ 
