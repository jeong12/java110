/* 의존 객체 자동 주입 : @AutoWired에서 같은 타입의 객체가 여러 개일 떄
 * => 스프링 IoC 컨테이너는 어떤 객체를 주입해야 할지 모르기 때문에 예외를 발생시킨다.
 *    ex) cancelling refresh attempt: org.springframework.beans.factory.UnsatisfiedDependencyException: 
 *        Error creating bean with name 'c1': Unsatisfied dependency expressed through field 'engine'; 
 *        nested exception is org.springframework.beans.factory.NoUniqueBeanDefinitionException: 
 *        No qualifying bean of type 'ex08.Engine' available: expected single matching bean but found 2: e1,e2
 * => 해결 방법
 *    test05 & car3
 */    
package ex08;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test04 {

    public static void main(String[] args) {
        
        ApplicationContext iocContainer = 
                new ClassPathXmlApplicationContext("ex08/app-context-4.xml");
        
        System.out.println("------------------------------");
        
        // 컨테이너에 들어 있는 객체의 개수와 이름 알아내기
        int count = iocContainer.getBeanDefinitionCount();
        System.out.printf("bean 개수 = %d\n", count);
        
        String[] names = iocContainer.getBeanDefinitionNames();
        for (String name : names) {
            System.out.printf("=> %s : %s\n", 
                    name, 
                    iocContainer.getType(name).getName());
        }
        
        System.out.println("------------------------------");
        
        Car2 c1 = (Car2)iocContainer.getBean("c1");
        System.out.println(c1);
        
        
    }

}









