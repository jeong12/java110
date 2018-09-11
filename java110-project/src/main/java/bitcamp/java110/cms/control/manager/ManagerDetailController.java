package bitcamp.java110.cms.control.manager;

import java.util.Scanner;

import bitcamp.java110.cms.annotation.Autowired;
import bitcamp.java110.cms.annotation.Component;
import bitcamp.java110.cms.annotation.RequestMapping;
import bitcamp.java110.cms.dao.ManagerDao;
import bitcamp.java110.cms.domain.Manager;

@Component
<<<<<<< HEAD
public class ManagerDetailController {
    
    ManagerDao managerDao;
    @Autowired
    public void setManagerDao(ManagerDao managerDao) {
        this.managerDao=managerDao;
=======
public class ManagerDetailController { 

    ManagerDao managerDao;
    
    @Autowired
    public void setManagerDao(ManagerDao managerDao) {
        this.managerDao = managerDao;
>>>>>>> b1
    }

    @RequestMapping("manager/detail")
    public void detail(Scanner keyIn) {
<<<<<<< HEAD
        System.out.print("input email to show  ");
       String email=keyIn.nextLine();

     
        Manager manager=managerDao.findByEmail(email);
        System.out.println("name: "+ manager.getName());
        System.out.println("email: "+ manager.getEmail());
        System.out.println("password: "+ manager.getPassword());
        System.out.println("tel: "+ manager.getTel());
        System.out.println("position: " + manager.getPosition());
=======
        System.out.print("조회할 매니저의 이메일? ");
        String email = keyIn.nextLine();
        Manager m = managerDao.findByEmail(email);
        
        if (m == null) {
            System.out.println("해당 이메일의 매니저가 없습니다!");
            return;
        }
        
        System.out.printf("이름: %s\n", m.getName());
        System.out.printf("이메일: %s\n", m.getEmail());
        System.out.printf("암호: %s\n", m.getPassword());
        System.out.printf("직위: %s\n", m.getPosition());
        System.out.printf("전화: %s\n", m.getTel());
>>>>>>> b1
    }
    
}
