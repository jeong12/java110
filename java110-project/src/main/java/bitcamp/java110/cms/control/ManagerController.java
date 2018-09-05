package bitcamp.java110.cms.control;
import java.util.Scanner;

import bitcamp.java110.cms.domain.Member;

public class ManagerController {

    static Manager [] students = new Manager[100];
    static int managerIndex =0;
    public static Scanner keyIn;

    static class Manager extends Member{
        protected String position;
        protected String tel;

        public String getPosition() {
            return position;
        }
        public void setPosition(String position) {
            this.position = position;
        }
        public String getTel() {
            return tel;
        }
        public void setTel(String tel) {
            this.tel = tel;
        }    
    }  

   public static void serviceManagerMenu() {
        while(true) {
            System.out.print("manager menu> ");
            String command=keyIn.nextLine();
            if(command.equals("list")) {
                printManagers();
            }
            else if(command.equals("add")) {
                inputManagers();
            }
            else if(command.equals("quit")) {
                break;
            }
            else {
                System.out.println("command is not vaild");
            }
        }
    }
    
   private static void printManagers() {
        int count=0;
        for(Manager s : students) {
            if(count++ == managerIndex)
                break;
            else {
                System.out.printf("%s, %s, %s, %s\n",s.getName(), 
                        s.getEmial(), s.getPassword(), s.getPosition()
                        , s.getTel());
            }
        }
    }
    
   private static void inputManagers() {
        while(true) {
            Manager m = new Manager();
            System.out.print("name? ");
            m.setName(keyIn.nextLine());
            System.out.print("email? ");
            m.setEmial(keyIn.nextLine());
            System.out.print("password? ");
            m.setPassword(keyIn.nextLine());
            System.out.print("position? ");
            m.setPosition(keyIn.nextLine());
            System.out.print("tel? ");
            m.setTel(keyIn.nextLine());

            students[managerIndex++] = m;
            /*index++; 이걸 안쓰려면 위에 방법처럼 [index ++]*/

            System.out.println("continue?(Y/n) ");
            String answer = keyIn.nextLine();
            if(answer.toLowerCase().equals("n"))
                break;
        } 

    }

}
