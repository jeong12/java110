package bitcamp.java110.cms.context;

import java.lang.reflect.Method;
import java.util.Collection;

import bitcamp.java110.cms.annotation.Autowired;
import bitcamp.java110.cms.annotation.Component;

@Component
public class AutoWiredAnnotationBeanPostProcessor implements BeanPostProcessor{

   ApplicationContext beanContatiner;

   
   public void postProcess(ApplicationContext beanContatiner) {
      
       Collection<Object> objList = ApplicationContext.objPool.values();

       /*얘랑 아래랑 같은 아이. 근데, 얘를 쓴 이유는, Application의 Context의 objPool은 static이니까,
        * 클래스 명으로도 바로 호출이 가능함. 그래서 beanContatiner를 쓰면 경고 표시가 뜬 거였음.  
        */ 
       //Collection<Object> objList = beanContatiner.objPool.values();
       
       for (Object obj : objList) {
           //목록에서 객체를 꺼내 @Autowired가 붙은 메서드를 찾는다.
           Method[] methods = obj.getClass().getDeclaredMethods();
           for (Method m : methods) {
               if (!m.isAnnotationPresent(Autowired.class)) continue;
               
               // setter 메서드의 파라미터 타입을 알아낸다.
               Class<?> paramType = m.getParameterTypes()[0];
               
               // 그 파라미터 타입과 일치하는 객체가 objPool에서 꺼낸다.
               Object dependency = beanContatiner.getBean(paramType);
               
               if (dependency == null) continue;
               
               try {
                   m.invoke(obj, dependency);
                   System.out.printf("%s() 호출됨\n", m.getName());
               } catch (Exception e) {}
           }
           
       }
   
}
}



