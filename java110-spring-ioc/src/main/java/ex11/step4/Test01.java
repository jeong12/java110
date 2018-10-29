/* 메서드 호출 앞 또는 뒤에 필터 끼우는 기술 : AOP
 * 
 */
package ex11.step4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01 {

    /* AOP(Aspect-Oriented Programming)?
     * - 기존의 코드를 손대지 않고 특정 기능을 삽입하는 기술
     * - 메서드 호출 앞/뒤/값 리턴 뒤 에 코드를 삽입할 수 있다.
     * - 일종의 필터를 추가하는 기술
     * 
     * AOP 적용 방법
     * - AOP 관련 라이브러리를 추가
     *   - "aspectj weaver"로 검색
     * - 필터 역할을 할 클래스 정의
     * - XML 또는 Java Config로 필터 설정
     * 
     * AOP 용어
     *  - Advice : 필터링 대상이 되는 메서드(join point)의 
     *             호출 앞/뒤에 삽입하는 필터 객체
     *             ex)MyAdvice
     *             
     *  - Join Point : Advice가 삽입될 메서드이다.
     *                 ex)insert()/update()/delete()등의 메서드
     *  
     *  - Pointcut : Advice를 삽입해야하는 메서드에 대한 위치 정보이다.
     *              ex) excute("* ex11.step4.ServiceImpl.*(..)")
     *              
     *  - Target Object : Advice를 삽입해야 하는 메서드를 갖고 있는 클래스
     *                    ex) ServiceImpl, ManagerDao 등
     *                    
     *  - Aspect        : 어느 pointCut에 어떤 advice를 삽입할 것인지를 가르키는 정보이다.
     *                    ex) 설정 정보 
     */
    
    public static void main(String[] args) {


        ApplicationContext iocContainer = 
                new ClassPathXmlApplicationContext("ex11/step4/app-context-1.xml");

        /*ApplicationContext iocContainer = 
                new AnnotationConfigApplicationContext(AppConfig.class);


        // 이 시점에서 IoC 컨테이너에 들어있는 객체의 목록 출력하기
        AppConfig.printObjectList(iocContainer); */

      //IoC 컨테이너에 들어있는 객체의 목록 출력하기
        printObjectList(iocContainer);
        
        Service proxy = (Service)iocContainer.getBean(Service.class);
        proxy.add(); //proxy.xxx() =>MethodFilter.invoke() ==>original.xxx()
        proxy.update();
        proxy.delete();
        proxy.list();
        proxy.addPhoto();

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









