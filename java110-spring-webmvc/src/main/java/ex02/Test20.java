// multipart/form-data 받기
package ex02;

import java.io.File;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@RequestMapping("/ex02/test20")
@Controller
public class Test20 {

    @Autowired ServletContext sc;

    /* 테스트:
     *       http://localhost:8888/ex02/Test20.html
     * 
     *
     *  주의!
     *  -> 프론트 컨트롤러가 멀티파트 데이터를 처리하려면,
     *    1) DD 파일에 프론트 컨트롤러를 선언할 때 다음의 태그를 설정한다.
     *         <multipart-config>
     *              <max-file-size>2000000</max-file-size>
     *         <multipart-config>
     *         
     *    2) Apache common fileupload를 이용하여 멀티파트 데이터를 처리하는
     *       스프링 제공 객체를 추가하면 된다.
     *    => multipartResolver라는 이름으로 다음과 같이 객체를 등록해야한다.
     *    => Apache commons-fileupload 의존 라이브러리를 추가해야 한다. <-안하면 오류
     *    2-1) XML 설정: 
     *      <beans:bean id="multipartResolver" 
     *      class="org.springframework.web.multipart.commons.CommonsMultipartResolver">
            <beans:property name="maxUploadSize" value="1000000" /> 
            </beans:bean>
     *    2-2) Java Config 설정 방법: AppConfig 클래스에 다음 메서드를 추가할 수 있다.
     *      @Bean(name="mulipartResolver")
     *      public CommonsMultipart
     */

    @RequestMapping(value="m1", produces="text/plain;charset=UTF-8")
    @ResponseBody
    public String m1(String name, int age, MultipartFile[] files) throws Exception{

        System.out.printf("name=%s\n", name);
        System.out.printf("age=%d\n",age);

        for(MultipartFile f : files) {
            if(f.getSize()== 0) continue;

            String filename = UUID.randomUUID().toString();
            f.transferTo(new File(sc.getRealPath("/upload/" + filename)));
            System.out.printf("file=%s(%s)\n", filename,f.getOriginalFilename());

        }
        return "ex02.test20.m1()!";
    }    
}