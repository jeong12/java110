import java.util.Scanner;

import bitcamp.java110.cms.control.ManagerController;
import bitcamp.java110.cms.control.StudentController;
import bitcamp.java110.cms.control.TeacherController;

public class App {

    static Scanner keyIn = new Scanner(System.in);

    public static void main(String[] args) {

        StudentController.keyIn=keyIn;
        TeacherController.keyIn=keyIn; //이렇게 해줘야 system.in을 scanner가 씀
        ManagerController.keyIn=keyIn;
        
        while(true) {
            String menu=promptMenu();
            if(menu.equals("1")) {
                StudentController.serviceStudentMenu();
            }
            else if(menu.equals("2")) {
                TeacherController.serviceTeacherMenu();
            }
            else if(menu.equals("3")) {
                ManagerController.serviceManagerMenu();
            }
            else if(menu.equals("0")) {
                System.out.println("good-bye!");
                break;
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
