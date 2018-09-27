/* 서블릿 배치 정보 - XML 태그로 배치정보 설정하기
 * => 서블릿의 배치 정보를 설정하는 두가지 방법이 있다.
 *    1) annotation으로 배치하기
 *       @WebServlet annotation을 servlet class 에 선언한다.
 *    2) XML 태그로 배치하기
        /WEB-INF/web.xml에 서블릿 배치 정보를 설정한다.
        'web.xml'을 배치설정자(Deployment Descriptor 파일; DD파일)이라 부른다.
        
   => 주의!
      web.xml 파일을 사용할 때  web-app에서 metadata-complete 속성 값을 false로 설정하지 않으면
      annotation으로 배치한 정보를 인식하지 못한다. 
 */

package bitcamp.java110.ex06;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet03 extends HttpServlet{
    private static final long serialVersionUID = 1L;

  
    @Override
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        
        
        res.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = res.getWriter();
        
        out.println("/ex06/servlet03 실행!");
        
    }
}

