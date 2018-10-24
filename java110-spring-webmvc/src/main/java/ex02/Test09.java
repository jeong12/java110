// @RequestMapping 다루기 : URL 다루기 2
package ex02;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/ex02/test09")
@Controller
public class Test09 {

    // 공통 URL은 클래스에 선언한다.
    
    @RequestMapping("/m1") // /빼도 가능함. 얘네가 알아서 처리해 줌
    @ResponseBody
    public String m1() {
        System.out.println();
        return "ex02.Text09.m1()";
    }

    @RequestMapping("m2")
    @ResponseBody
    public String m2() {
        System.out.println();
        return "ex02.Text09.m2()";
    }
    

    
}