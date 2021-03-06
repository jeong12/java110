package bitcamp.java110.ex05;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public abstract class MyHttpServlet extends GenericServlet{

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        
        //여기서 ServletRequest와 ServletResponse를 HttpServletRequest와 HttpServletResponse로 타앱 캐스팅한다.
       
        HttpServletRequest httpReq = (HttpServletRequest)req;
       HttpServletResponse httpRes = (HttpServletResponse)res;
       
       this.service(httpReq, httpRes); 
       //이게 가능한 이유. 아래 추상 메서드를 상속받은 클래스에서 아래것을 완성. 그러면 그 완성된 것은 호출. (얘가 호출될 때는 이미 완성된 상태)
       
        
    }
    
    public abstract void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException;


}