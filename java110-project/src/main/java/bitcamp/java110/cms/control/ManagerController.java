package bitcamp.java110.cms.control;
import java.util.Scanner;

import bitcamp.java110.cms.dao.ManagerList;
import bitcamp.java110.cms.domain.Manager;

public class ManagerController {

    public static Scanner keyIn;

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

            ManagerList.add(m);

            System.out.println("continue?(Y/n) ");
            String answer = keyIn.nextLine();
            if(answer.toLowerCase().equals("n"))
                break;
        } 

    }


    private static void printManagers() {
        for(int i=0; i<ManagerList.size();i++) {
            Manager manager=ManagerList.get(i);
            System.out.printf("%d: %s, %s, %s, %s\n",i, manager.getName(), 
                    manager.getEmail(), manager.getPassword(), 
                    manager.getPosition(), manager.getTel());
        }
    }


private static void deleteManager() {
    System.out.print("input number to delete  ");
    int no=Integer.parseInt(keyIn.nextLine());
    ManagerList.remove(no);
    System.out.println("delete success!");
}

private static void detailManager() {
    System.out.print("input number to show  ");
    int no=Integer.parseInt(keyIn.nextLine());

    Manager manager=ManagerList.get(no);
    System.out.println("name: "+ manager.getName());
    System.out.println("email: "+ manager.getEmail());
    System.out.println("password: "+ manager.getPassword());
    System.out.println("tel: "+ manager.getTel());
    System.out.println("position: " + manager.getPosition());
}

static {
    Manager s=new Manager();
    s.setName("a");
    ManagerList.add(s);
    s=new Manager();
    s.setName("b");
    ManagerList.add(s);
    s=new Manager();
    s.setName("c");
    ManagerList.add(s);
    s=new Manager();
    s.setName("d");
    ManagerList.add(s);
    s=new Manager();
    s.setName("e");
    ManagerList.add(s);



}

}
