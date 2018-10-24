// @RequestMapping 다루기 : URL 다루기 3
package ex02;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/ex02/test10")
@Controller
public class Test10 {

    // 클래스에 URL을 지정하고 메서드에 GET/POST .. 등을 지정할 수 있다.
    // 테스트: 
    //      : http://localhost:8888/ex02/Test10.html

    @RequestMapping(method=RequestMethod.GET)
    @ResponseBody
    public String m1() {
        System.out.println();
        return "ex02.Text10.m1()";
    }

    @RequestMapping(method=RequestMethod.POST)
    @ResponseBody
    public String m2() {
        System.out.println();
        return "ex02.Text10.m2()";
    }
    

    
}