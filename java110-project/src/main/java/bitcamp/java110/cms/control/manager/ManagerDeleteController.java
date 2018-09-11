package bitcamp.java110.cms.control.manager;

import java.util.Scanner;

import bitcamp.java110.cms.annotation.Autowired;
import bitcamp.java110.cms.annotation.Component;
import bitcamp.java110.cms.annotation.RequestMapping;
import bitcamp.java110.cms.dao.ManagerDao;

@Component
<<<<<<< HEAD
public class ManagerDeleteController {
    
    ManagerDao managerDao;
    @Autowired
    public void setManagerDao(ManagerDao managerDao) {
        this.managerDao=managerDao;
    }
        
    @RequestMapping("manager/delete")
    public void delete(Scanner keyIn) {
        System.out.print("input email to delete  ");
        String email=keyIn.nextLine();

        if(managerDao.delete(email)>0) {
            System.out.println("delete success!");            
        }else {
            System.out.println("can not find data");
        }
=======
public class ManagerDeleteController { 

    ManagerDao managerDao;
    
    @Autowired
    public void setManagerDao(ManagerDao managerDao) {
        this.managerDao = managerDao;
    }
    
    @RequestMapping("manager/delete")
    public void delete(Scanner keyIn) {
        System.out.print("삭제할 매니저의 이메일? ");
        String email = keyIn.nextLine();
>>>>>>> b1
        
        if (managerDao.delete(email) > 0) {
            System.out.println("삭제하였습니다.");
        } else {
            System.out.println("해당 이메일의 매니저가 없습니다!");
        }
    }
    
}
