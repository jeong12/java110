package bitcamp.java110.cms.control;

import java.util.Scanner;

public class HelloController implements Controller{

    public String name="4";
    
    @Override
    public void service(Scanner keyIn) {
        System.out.println("hello!");
        
    }

}
