package bitcamp.java110.cms.control.teacher;

import java.util.Scanner;

import bitcamp.java110.cms.App;
import bitcamp.java110.cms.annotation.Component;
import bitcamp.java110.cms.annotation.RequestMapping;

@Component
public class TeacherDeleteController {
        
    @RequestMapping("teacher/delete")
    public void delete(Scanner keyIn) {
        System.out.print("input email to delete  ");
        String email=keyIn.nextLine();
        if(App.teacherDao.delete(email)>0) {
            System.out.println("delete success! ");
        }else {
            System.out.println("delete fail :(");
        }
 
    }
}
