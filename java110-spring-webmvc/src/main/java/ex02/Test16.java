// 커스텀 프로퍼티 에디터 2 - 글로벌 커스텀 프로퍼티 에디터 장착하기
package ex02;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/ex02/test16")
@Controller
public class Test16 {

    // 모든 페이지 컨트롤러가 사용할 커스텀 프로퍼티 에디터를 등록하고 싶다면, 
    // @ControllerAdvice 붙은 클래스에 @InitBinder(가 붙은) 메서드를 등록하라!
    // 
    // => 이 방법의 문제점은 커스텀 프로퍼티 에디터가 필요하지 않는 페이지 컨트롤러에 대해서도
    //    매번 @InitBinder 메서드를 호출한다는 것이다.
    @RequestMapping("m1")
    public String m1(String name, Date day, Model model ) {
       model.addAttribute("name",name);
       model.addAttribute("day", day);
        return "/ex02/Test15.jsp";
    }    
        
    @RequestMapping("m2")
    public String m2(
            // primitive type, String, java.util.Data, java.util.sqlDate 타입이 아닌 경우
            // 파라미터 변수 앞에 @RequestParam을 붙여야 한다.
            // 즉, 클라이언트가 보낸 데이터가 어떤 것인지 명시해야 한다.
            @RequestParam("car") Car car, 
            Model model ) {
       model.addAttribute("car", car);
        return "/ex02/Test15-2.jsp";
    } 
    
    
    
}