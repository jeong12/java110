package bitcamp.java110.cms.context;

import java.lang.reflect.Method;
import java.util.Collection;

import bitcamp.java110.cms.annotation.Autowired;
import bitcamp.java110.cms.annotation.Component;

@Component
public class LogBeanPostProcessor implements BeanPostProcessor{

    ApplicationContext beanContatiner;


    public void postProcess(ApplicationContext beanContatiner) {
        Collection<Object> objList = beanContatiner.objPool.values();

        System.out.println("------------------");
        for (Object obj : objList) {
            System.out.println(obj.getClass().getName());
        }
        System.out.println("------------------");

    }
}



