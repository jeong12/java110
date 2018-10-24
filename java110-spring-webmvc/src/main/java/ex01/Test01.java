//페이지 컨트롤러 만들기
package ex01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Test01 {
    @RequestMapping("/ex01/hello")
    @ResponseBody // JSP가 아니라 얘로 바로 출력하라는 뜻
    public String hello() {
        return "Hello!";
    }
    
}
