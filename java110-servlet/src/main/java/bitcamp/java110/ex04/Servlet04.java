/* 클라이언트가 보낸 데이터 읽기 - 멀티파트 데이터 읽기 2
 *  
 */

package bitcamp.java110.ex04;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

 
//Servlet API 3.0부터 제공하는 멀티파트 처리기를 이용하기
// => 서블릿 선언부에 멀티파트 데이터를 처리함을 지정한다. 
@MultipartConfig(maxFileSize=10_000_000) //=10MB
@WebServlet("/ex04/servlet04")
public class Servlet04 extends GenericServlet{
    private static final long serialVersionUID = 1L;

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {      

        //멀티파트 데이터는 HTTPServletRequest의 getParts(), getPart() 메서드를 사용해서 꺼낸다.
        HttpServletRequest httpReq = (HttpServletRequest)req;
        String file1name="";
        Part part = httpReq.getPart("file1");
        if(part.getSize()>0) //만약 이걸 지정하지 않으면, 첨부하지 않은 파일도 0바이트로 파일이 생김
            file1name = UUID.randomUUID().toString();
        part.write(this.getServletContext().getRealPath("/upload/" + file1name));
        
        String file2name = "";
        part = httpReq.getPart("file2");
        file2name = UUID.randomUUID().toString();
        if(part.getSize()>0)
        part.write(this.getServletContext().getRealPath("/upload/"+file2name));
              
        
        res.setContentType("text/plain;charset=UTF-8");
        //res.setContentType("image/jpeg");
        PrintWriter out = res.getWriter();
        out.printf("name=%s\n",req.getParameter("name"));
        out.printf("age=%d\n",Integer.parseInt(req.getParameter("age")));
        out.printf("working=%b\n",Boolean.parseBoolean(req.getParameter("working")));
        out.printf("file1=%s\n", file1name);
        out.printf("file2=%s\n", file2name); 
        

    }
}

//멀티 파트 POST 요청
/*
 POST /ex04/servlet03 HTTP/1.1
Host: localhost:8888
Content-Length: 1490718
Pragma: no-cache
Cache-Control: no-cache
Origin: http://localhost:8888
Upgrade-Insecure-Requests: 1
Content-Type: multipart/form-data; boundary=----WebKitFormBoundarywRV0l4Gi6dFcHV5z
User-Agent: Mozilla/5.0 (Windows NT 6.3; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.100 Safari/537.36
Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,
Referer: http://localhost:8888/ex04/file.html
Accept-Encoding: gzip, deflate, br
Accept-Language: ko-KR,ko;q=0.9,en-US;q=0.8,en;q=0.7
Connection: keep-alive

------WebKitFormBoundarywRV0l4Gi6dFcHV5z
Content-Disposition: form-data; name="name"

홍길동
------WebKitFormBoundarywRV0l4Gi6dFcHV5z
Content-Disposition: form-data; name="age"

20
------WebKitFormBoundarywRV0l4Gi6dFcHV5z
Content-Disposition: form-data; name="working"

true
------WebKitFormBoundarywRV0l4Gi6dFcHV5z
Content-Disposition: form-data; name="file1"; filename="Dcwho.jpg"
Content-Type: image/jpeg

����
.
.
.
 
 
 */

