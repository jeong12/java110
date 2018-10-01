/* 인클루드(Include) 
 * => 다른 서블릿의 작업을 포함하는 기술
 *    일종의 함수를 호출하듯이 다른 서블릿을 실행한 후 다시 이전 서블릿으로 돌아온다. 
 *    
 */

package bitcamp.java110.ex09;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

 
@WebServlet("/ex09/servlet06")
public class Servlet06 extends HttpServlet{
    private static final long serialVersionUID = 1L;

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        PrintWriter out = res.getWriter();
        
        out.println("<h1>Servlet 06</h1>");

    }
}

