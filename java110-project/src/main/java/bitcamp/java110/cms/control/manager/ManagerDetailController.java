package bitcamp.java110.cms.control.manager;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import bitcamp.java110.cms.App;
import bitcamp.java110.cms.annotation.Component;
import bitcamp.java110.cms.annotation.RequestMapping;
import bitcamp.java110.cms.domain.Manager;
import bitcamp.java110.cms.domain.Student;

@Component
public class ManagerDetailController {

    @RequestMapping("manager/detail")
    public void detail(Scanner keyIn) {
        System.out.print("input email to show  ");
       String email=keyIn.nextLine();

     
        Manager manager=App.managerDao.findByEmail(email);
        System.out.println("name: "+ manager.getName());
        System.out.println("email: "+ manager.getEmail());
        System.out.println("password: "+ manager.getPassword());
        System.out.println("tel: "+ manager.getTel());
        System.out.println("position: " + manager.getPosition());
    }

    
    
}
