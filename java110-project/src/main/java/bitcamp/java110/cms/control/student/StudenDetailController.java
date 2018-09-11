package bitcamp.java110.cms.control.student;

import java.util.Scanner;

import bitcamp.java110.cms.annotation.Autowired;
import bitcamp.java110.cms.annotation.Component;
import bitcamp.java110.cms.annotation.RequestMapping;
import bitcamp.java110.cms.dao.ManagerDao;
import bitcamp.java110.cms.dao.StudentDao;
import bitcamp.java110.cms.domain.Student;

@Component
public class StudenDetailController {
    
    StudentDao studentDao;
   
    @Autowired
    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }


    @RequestMapping("student/detail")
    public void detail(Scanner keyIn) {
        System.out.print("input email to show  ");
        String email=keyIn.nextLine();

        Student student=studentDao.findByEmail(email);
        
        if(student==null) {
            System.out.println("can not find data");
            return;
        }
        System.out.println("name: " + student.getName());
        System.out.println("email: " + student.getEmail());
        System.out.println("password: " + student.getPassword());
        System.out.println("tel: "+ student.getTel());
        System.out.println("working: "+ student.isWorking());
        System.out.println("school: " + student.getSchool());
    }

    
    
}
