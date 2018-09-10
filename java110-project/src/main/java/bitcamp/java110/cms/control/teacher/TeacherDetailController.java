package bitcamp.java110.cms.control.teacher;

import java.util.Scanner;

import bitcamp.java110.cms.App;
import bitcamp.java110.cms.annotation.Component;
import bitcamp.java110.cms.annotation.RequestMapping;
import bitcamp.java110.cms.domain.Teacher;

@Component
public class TeacherDetailController {

    @RequestMapping("teacher/detail")
    public void detail(Scanner keyIn) {
        System.out.print("input number to show  ");
        int no=Integer.parseInt(keyIn.nextLine());

        if(no<0 || no>=App.teachers.size()) {
            System.out.println("unvailed number");
            return;
        }
        Teacher teacher=App.teachers.get(no);
        System.out.println("name: "+ teacher.getName());
        System.out.println("email: "+ teacher.getEmail());
        System.out.println("password: "+ teacher.getPassword());
        System.out.println("tel: "+ teacher.getTel());
        System.out.println("psy: "+ teacher.getPay());
        System.out.println("subject: "+ teacher.getSubjects());
    }

    
    
}
