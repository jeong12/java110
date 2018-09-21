/* Get/POST 구분하기 3
 *  
 */

package bitcamp.java110.ex05;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// MyHttpServlet을 직접 상속받는 것보다 MyHttpServlet2 클래스를 상속받으면 
// Get/post 요청을 구분하여 처리할 수 있다.
// 그래서 프로그래밍 하기 편하다!
@WebServlet("/ex05/servlet03")
public class Servlet03 extends MyHttpServlet2{
    private static final long serialVersionUID = 1L;

@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
   
    // 테스트 :
    // => http://localhost:8888/ex05/test3.html
    
    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();       
    out.println("GET 요청입니다.");
}



}

