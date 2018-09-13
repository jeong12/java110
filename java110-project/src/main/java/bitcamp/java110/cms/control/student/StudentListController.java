package bitcamp.java110.cms.control.student;

import java.util.List;
import java.util.Scanner;

import bitcamp.java110.cms.annotation.Autowired;
import bitcamp.java110.cms.annotation.Component;
import bitcamp.java110.cms.annotation.RequestMapping;
import bitcamp.java110.cms.dao.StudentDao;
import bitcamp.java110.cms.domain.Student;

@Component
public class StudentListController {
    
    StudentDao studentDao;
    
    @Autowired
    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @RequestMapping("student/list")
    public void list(Scanner keyIn) {
        List<Student> list = studentDao.findAll();
        
        for (Student s : list) {
            System.out.printf("%d,%s, %s, %s, %s, %s, %b\n",
                    s.getNo(),
                    s.getEmail(), 
                    s.getName(), 
                    s.getPassword(), 
                    s.getSchool(),
                    s.getTel(),
                    s.isWorking());
        }
    }
}
