/* Get/POST 구분하기 4
 *  
 */

package bitcamp.java110.ex05;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ex05/servlet04")
public class Servlet04 extends HttpServlet{
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

