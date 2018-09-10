import java.lang.reflect.Method;
import java.util.Scanner;

import bitcamp.java110.cms.annotation.RequestMapping;
import bitcamp.java110.cms.context.ApplicationContext;
import bitcamp.java110.cms.context.RequestMappingHandlerMapping;
import bitcamp.java110.cms.context.RequestMappingHandlerMapping.RequestMappingHandler;

public class App {

    static Scanner keyIn = new Scanner(System.in);

    public static void main(String[] args) throws Exception {

        ApplicationContext iocContainer 
        = new ApplicationContext("bitcamp.java110.cms.control");
        
        RequestMappingHandlerMapping requestHandlerMap=
                new RequestMappingHandlerMapping();
        
        //=>IOC 컨테이너에 보관된 객체의 이름 목록을 가져온다.
        String[]names = iocContainer.getBeanDefinitionNames();
        for(String name:names) {
            Object obj=iocContainer.getBean(name);
            requestHandlerMap.addMapping(obj);
        }      
                
        while(true) {
            String menu=prompt();
            if(menu.equals("exit")) {
                System.out.println("good-bye!");
                break;
            }
            
            RequestMappingHandler mapping= requestHandlerMap.getMapping(menu);
            
            if(mapping == null) {
                System.out.println("invailed command!");
                continue;
            }
                mapping.getMethod().invoke(mapping.getInstatnce(), keyIn); 
                //첫번쨰 파라미터가 인스턴스 주소값. 만약, 클래스 메서드면 null. 두번쨰 파라미터가 메서드의 파라미터
        }
        keyIn.close();
    }   

    private static String prompt() {
        System.out.print("menu> ");
        return keyIn.nextLine();
        }   
}
