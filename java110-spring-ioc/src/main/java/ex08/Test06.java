/* 의존 객체 자동 주입 : @Resource
 * => @Resource = @AutoWired + @Qualifier
 * => 이 애노테이션은 JSR-250 에서 제안한 annotation이다.
 *    Java에 기본으로 포함되어 있지 않기 떄문에 JSR-250 명세에 따라 작성된 외부 라이브러리를 추가해야 한다.
 *    
 * JSR?(Java Specification Request)?
 * => Java에서 JDK에 포함시키기를 요구 하는 명세이다. JCP에서 제안한다.
 * => JSR에 따라 외부 개발자들이 라이브러리를 만들어 사용하다가 많은 호응이 있으면 JDK에 정식으로 추가한다.
 * 
 * JCP? (Java Community Process)?
 * => 자바 기술에 대한 표준을 정의하는 모임
 * => 오라클, 마이크로소프트, IBM, 페이스북, 삼성, lG 등 유수 IR 기업이 참여하고 있다.
 */
package ex08;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test06 {

    public static void main(String[] args) {
        
        ApplicationContext iocContainer = 
                new ClassPathXmlApplicationContext("ex08/app-context-6.xml");
        
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
        
        Car4 c1 = (Car4)iocContainer.getBean("c1");
        System.out.println(c1);
        
        
    }

}









