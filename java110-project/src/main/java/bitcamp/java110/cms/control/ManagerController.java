package bitcamp.java110.cms.control;
import java.util.Scanner;

import bitcamp.java110.domain.Member;

public class ManagerController {

    static Manager [] Managers = new Manager[100];
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
            else if(command.equals("delete")) {
                deleteManager();
            }
            else if(command.equals("detail")) {
                detailManager();
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
        for(Manager s : Managers) {
            if(count++ == managerIndex)
                break;
            else {
                System.out.printf("%d: %s, %s, %s, %s\n",count-1, s.getName(), 
                        s.getEmail(), s.getPassword(), s.getPosition()
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
            m.setEmail(keyIn.nextLine());
            System.out.print("password? ");
            m.setPassword(keyIn.nextLine());
            System.out.print("position? ");
            m.setPosition(keyIn.nextLine());
            System.out.print("tel? ");
            m.setTel(keyIn.nextLine());

            if(managerIndex == Managers.length) {
                increaseStorage();
            }
            
            Managers[managerIndex++] = m;
            /*index++; 이걸 안쓰려면 위에 방법처럼 [index ++]*/

            System.out.println("continue?(Y/n) ");
            String answer = keyIn.nextLine();
            if(answer.toLowerCase().equals("n"))
                break;
        } 

    }
   
   private static void increaseStorage() {
       Manager[] newList=new Manager[Managers.length+3];
       for(int i=0;i<Managers.length;i++) {
           newList[i]=Managers[i];
       }
       Managers=newList;
   }
   
   private static void deleteManager() {
       System.out.print("input number to delete  ");
       int no=Integer.parseInt(keyIn.nextLine());

       if(no<0 || no>=managerIndex) {
           System.out.println("unvailed number");
           return;
       }
       for(int i=no;i<managerIndex-1;i++) {
           Managers[i]=Managers[i+1];
       }
       managerIndex--;
       System.out.println("delete success!");
   }
   
   private static void detailManager() {
       System.out.print("input number to show  ");
       int no=Integer.parseInt(keyIn.nextLine());

       if(no<0 || no>=managerIndex) {
           System.out.println("unvailed number");
           return;
       }
       System.out.println("name: "+ Managers[no].getName());
       System.out.println("email: "+ Managers[no].getEmail());
       System.out.println("password: "+ Managers[no].getPassword());
       System.out.println("tel: "+ Managers[no].getTel());
       System.out.println("position: " + Managers[no].getPosition());
   }

   static {
       Manager s=new Manager();
       s.setName("a");
       Managers[managerIndex++]=s;
       s=new Manager();
       s.setName("b");
       Managers[managerIndex++]=s;
       s=new Manager();
       s.setName("c");
       Managers[managerIndex++]=s;
       s=new Manager();
       s.setName("d");
       Managers[managerIndex++]=s;
       s=new Manager();
       s.setName("e");
       Managers[managerIndex++]=s;



   }

}
