package bitcamp.java110.cms.control.manager;

import java.util.Scanner;

import bitcamp.java110.cms.annotation.Autowired;
import bitcamp.java110.cms.annotation.Component;
import bitcamp.java110.cms.annotation.RequestMapping;
import bitcamp.java110.cms.dao.ManagerDao;
import bitcamp.java110.cms.domain.Manager;

@Component
public class ManagerDetailController {
    
    ManagerDao managerDao;
    @Autowired
    public void setManagerDao(ManagerDao managerDao) {
        this.managerDao=managerDao;
    }

    @RequestMapping("manager/detail")
    public void detail(Scanner keyIn) {
        System.out.print("input email to show  ");
       String email=keyIn.nextLine();

     
        Manager manager=managerDao.findByEmail(email);
        System.out.println("name: "+ manager.getName());
        System.out.println("email: "+ manager.getEmail());
        System.out.println("password: "+ manager.getPassword());
        System.out.println("tel: "+ manager.getTel());
        System.out.println("position: " + manager.getPosition());
    }

    
    
}
