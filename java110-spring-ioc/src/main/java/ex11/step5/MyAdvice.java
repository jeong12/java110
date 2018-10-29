package ex11.step5;

public class MyAdvice {
    
    public void before() {
        System.out.println("MyAdvice.before()!");
    }
    
    public void after() {
        System.out.println("MyAdvice.after()!");
    }
    
    public void afterReturning() {
        System.out.println("MyAdvice.afterReturning()!");
    }
    
    public void afterThrowing() {
        System.out.println("MyAdvice.afterThrowing()!");
    }
}
