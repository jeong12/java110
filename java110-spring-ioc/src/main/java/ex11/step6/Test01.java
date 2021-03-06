/* AOP: 우너래 메서드의 파라미터 값 또는 리턴 값 받기
 * 
 */
package ex11.step6;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01 {
    
    public static void main(String[] args) {


        ApplicationContext iocContainer = 
                new ClassPathXmlApplicationContext("ex11/step6/app-context-1.xml");

        printObjectList(iocContainer);
        
        Service proxy = (Service)iocContainer.getBean(Service.class);
        int r = proxy.addPhoto("ok.jpg");
        System.out.println("리턴 값: " + r);
        System.out.println("==============================");
        r= proxy.addPhoto(null);
        System.out.println("리턴 값: " + r);

    }
    
    public static void printObjectList(ApplicationContext iocContainer) {
        System.out.println("================");

        int count = iocContainer.getBeanDefinitionCount();
        System.out.printf("bean 개수 = %d\n", count);

        String[] names = iocContainer.getBeanDefinitionNames();
        for (String name : names) {
            System.out.printf("=> %s : %s\n", 
                    name, 
                    iocContainer.getType(name).getName());
        }
        System.out.println("================");

    }//printObjectList

}









