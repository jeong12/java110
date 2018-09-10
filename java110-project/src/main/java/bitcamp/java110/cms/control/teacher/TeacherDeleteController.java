package bitcamp.java110.cms.control.teacher;

import java.util.Scanner;

import bitcamp.java110.cms.App;
import bitcamp.java110.cms.annotation.Component;
import bitcamp.java110.cms.annotation.RequestMapping;

@Component
public class TeacherDeleteController {
        
    @RequestMapping("teacher/delete")
    public void delete(Scanner keyIn) {
        System.out.print("input number to delete  ");
        int no=Integer.parseInt(keyIn.nextLine());

        if(no<0 || no>=App.teachers.size()) {
            System.out.println("unvailed number");
            return;
        }
        App.teachers.remove(no);
        System.out.println("delete success!");
    }
    
    
    
}
