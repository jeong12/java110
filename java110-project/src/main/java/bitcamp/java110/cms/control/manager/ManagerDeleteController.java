package bitcamp.java110.cms.control.manager;

import java.util.Scanner;

import bitcamp.java110.cms.App;
import bitcamp.java110.cms.annotation.Component;
import bitcamp.java110.cms.annotation.RequestMapping;

@Component
public class ManagerDeleteController {
        
    @RequestMapping("manager/delete")
    public void delete(Scanner keyIn) {
        System.out.print("input email to delete  ");
        String email=keyIn.nextLine();

        if(App.managerDao.delete(email)>0) {
            System.out.println("delete success!");            
        }else {
            System.out.println("can not find data");
        }
        
    }
    
    
    
}
