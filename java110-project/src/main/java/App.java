import java.util.Scanner;

import bitcamp.java110.cms.context.ApplicationContext;
import bitcamp.java110.cms.control.Controller;

public class App {

    static Scanner keyIn = new Scanner(System.in);

    public static void main(String[] args) throws Exception {

        ApplicationContext iocContainer 
        = new ApplicationContext("bitcamp.java110.cms.control");

        while(true) {
            String menu=promptMenu();
            if(menu.equals("0")) {
                System.out.println("good-bye!");
                break;
            }
            
            Controller controller = (Controller)iocContainer.getBean(menu);
            
            if(controller!=null) {
                controller.service(keyIn);
            }
            else {
                System.out.println("invailed number!");
            }
        }
        keyIn.close();
    }   

    private static String promptMenu() {
        System.out.println("menu");
        System.out.println("0. exit");
        System.out.println("1. student");
        System.out.println("2. teacher");
        System.out.println("3. manager");
        return keyIn.nextLine();
        }   

}
