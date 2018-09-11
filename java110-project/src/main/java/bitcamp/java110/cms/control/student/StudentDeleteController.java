package bitcamp.java110.cms.control.student;

import java.util.Scanner;

import bitcamp.java110.cms.annotation.Autowired;
import bitcamp.java110.cms.annotation.Component;
import bitcamp.java110.cms.annotation.RequestMapping;
import bitcamp.java110.cms.dao.StudentDao;

@Component
public class StudentDeleteController {
        
    StudentDao studentDao;
    @Autowired
    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }
        
    @RequestMapping("student/delete")
    public void delete(Scanner keyIn) {
        System.out.print("input email to delete  ");
        String email=keyIn.nextLine();
        
        if(studentDao.delete(email)>0) {
        System.out.println("delete success!");
        }else {
         System.out.println("fail to delete!");   
        }
    }
}
