package bitcamp.java110.cms.control;
import java.util.List;
import java.util.Scanner;

import bitcamp.java110.cms.domain.Manager;

public class ManagerController {
    
    private List<Manager> managers;
    public Scanner keyIn;
    public ManagerController(Scanner keyIn, List<Manager> managers){
        this.keyIn=keyIn;
        this.managers=managers;
        init();
    }

    public void serviceManagerMenu() {

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


    private void inputManagers() {
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

            managers.add(m);

            System.out.println("continue?(Y/n) ");
            String answer = keyIn.nextLine();
            if(answer.toLowerCase().equals("n"))
                break;
        } 

    }


    private void printManagers() {
        for(int i=0; i<managers.size();i++) {
            Manager manager=managers.get(i);
            System.out.printf("%d: %s, %s, %s, %s\n",i, manager.getName(), 
                    manager.getEmail(), manager.getPassword(), 
                    manager.getPosition(), manager.getTel());
        }
    }


    private void deleteManager() {
        System.out.print("input number to delete  ");
        int no=Integer.parseInt(keyIn.nextLine());
        managers.remove(no);
        System.out.println("delete success!");
    }

    private void detailManager() {
        System.out.print("input number to show  ");
        int no=Integer.parseInt(keyIn.nextLine());

        Manager manager=managers.get(no);
        System.out.println("name: "+ manager.getName());
        System.out.println("email: "+ manager.getEmail());
        System.out.println("password: "+ manager.getPassword());
        System.out.println("tel: "+ manager.getTel());
        System.out.println("position: " + manager.getPosition());
    }

     private void init(){
        Manager s=new Manager();
        s.setName("a");
        managers.add(s);
        s=new Manager();
        s.setName("b");
        managers.add(s);
        s=new Manager();
        s.setName("c");
        managers.add(s);
        s=new Manager();
        s.setName("d");
        managers.add(s);
        s=new Manager();
        s.setName("e");
        managers.add(s);
    }

}
