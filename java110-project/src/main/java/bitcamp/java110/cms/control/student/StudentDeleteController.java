package bitcamp.java110.cms.control.student;

import java.util.Scanner;

import bitcamp.java110.cms.App;
import bitcamp.java110.cms.annotation.Component;
import bitcamp.java110.cms.annotation.RequestMapping;

@Component
public class StudentDeleteController {
        
    @RequestMapping("student/delete")
    public void delete(Scanner keyIn) {
        System.out.print("input email to delete  ");
        String email=keyIn.nextLine();
        
        if(App.studentDao.delete(email)>0) {
        System.out.println("delete success!");
        }else {
         System.out.println("fail to delete!");   
        }
    }
}
