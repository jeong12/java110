package bitcamp.java110.cms.control.manager;

import java.util.Scanner;

import bitcamp.java110.cms.App;
import bitcamp.java110.cms.annotation.Component;
import bitcamp.java110.cms.annotation.RequestMapping;
import bitcamp.java110.cms.domain.Manager;

@Component
public class ManagerAddController {

    
    @RequestMapping("manager/add")
    public void add(Scanner keyIn) {
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

            App.managerDao.insert(m);

            System.out.println("continue?(Y/n) ");
            String answer = keyIn.nextLine();
            if(answer.toLowerCase().equals("n"))
                break;
        } 
    }
     
}
