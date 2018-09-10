import java.lang.reflect.Method;
import java.util.Scanner;

import bitcamp.java110.cms.annotation.RequestMapping;
import bitcamp.java110.cms.context.ApplicationContext;

public class App {

    static Scanner keyIn = new Scanner(System.in);

    public static void main(String[] args) throws Exception {

        ApplicationContext iocContainer 
        = new ApplicationContext("bitcamp.java110.cms.control");

        while(true) {
            String menu=prompt();
            if(menu.equals("exit")) {
                System.out.println("good-bye!");
                break;
            }
            
            Object controller= iocContainer.getBean(menu);
            
            if(controller == null) {
                System.out.println("invailed command!");
                continue;
            }
            Method method = findRequestMapping(controller.getClass());
            if(method == null) {
                System.out.println("invailed command!");
                continue;
            }
                method.invoke(controller, keyIn); 
                //첫번쨰 파라미터가 인스턴스 주소값. 만약, 클래스 메서드면 null. 두번쨰 파라미터가 메서드의 파라미터
        }
        keyIn.close();
    }   

    private static Method findRequestMapping(Class<?> clazz) {
        
        //=> 클래스의 메서드 목록을 꺼낸다.
        Method[] methods = clazz.getDeclaredMethods(); // 상속받은 메서드 제외(ex. tostring, hashcode 등등을 제외한다)
        for(Method m: methods) {
            
            // 메서드에서 @requestMapping 정보를 추출한다.
            RequestMapping anno=m.getAnnotation(RequestMapping.class);
            if(anno!=null) //찾으면 이 메서드를 리턴
                return m;
        }
        return null;
    }

    private static String prompt() {
        System.out.print("menu> ");
        return keyIn.nextLine();
        }   

}
