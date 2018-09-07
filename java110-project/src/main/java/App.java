import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

import bitcamp.java110.cms.control.Controller;
import bitcamp.java110.cms.control.ManagerController;
import bitcamp.java110.cms.control.StudentController;
import bitcamp.java110.cms.control.TeacherController;
import bitcamp.java110.cms.domain.Manager;
import bitcamp.java110.cms.domain.Student;
import bitcamp.java110.cms.domain.Teacher;

public class App {

    static Scanner keyIn = new Scanner(System.in);

    public static void main(String[] args) {

        HashMap<String,Controller> requestHandlerMapping = new HashMap<>();

        requestHandlerMapping.put("1", 
                new StudentController(new LinkedList<Student>()));
        requestHandlerMapping.put("2", 
                new TeacherController(new ArrayList<Teacher>()));
        requestHandlerMapping.put("3", 
                new ManagerController(new LinkedList<Manager>()));


        while(true) {
            String menu=promptMenu();
            if(menu.equals("0")) {
                System.out.println("good-bye!");
                break;
            }
            
            Controller controller = requestHandlerMapping.get(menu);
            
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

        while(true) {
            System.out.print("menu number> ");

            String menu=keyIn.nextLine();

            switch(menu) {
            case "1":
            case "2":
            case "3":
            case "0":
                return menu; //break 없어도 가능하네.
            default:
                System.out.println("menu number is not vaild ");
            }
        }   
    }


}
