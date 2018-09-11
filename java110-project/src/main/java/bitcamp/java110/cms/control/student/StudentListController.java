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
<<<<<<< HEAD
=======
    
>>>>>>> b1
    @Autowired
    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @RequestMapping("student/list")
    public void list(Scanner keyIn) {
<<<<<<< HEAD
        List<Student> list=studentDao.findAll();
        for(Student s: list) {
=======
        List<Student> list = studentDao.findAll();
        
        for (Student s : list) {
>>>>>>> b1
            System.out.printf("%s, %s, %s, %s, %b, %s\n",
                    s.getName(), 
                    s.getEmail(), 
                    s.getPassword(), 
                    s.getSchool(),
                    s.isWorking(),
                    s.getTel());
        }
    }
}
