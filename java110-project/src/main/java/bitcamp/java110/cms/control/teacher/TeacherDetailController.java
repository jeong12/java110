package bitcamp.java110.cms.control.teacher;

import java.util.Scanner;

import bitcamp.java110.cms.annotation.Autowired;
import bitcamp.java110.cms.annotation.Component;
import bitcamp.java110.cms.annotation.RequestMapping;
import bitcamp.java110.cms.dao.TeacherDao;
import bitcamp.java110.cms.domain.Teacher;

@Component
public class TeacherDetailController {
    
    TeacherDao teacherDao;

    @Autowired
    public void setTeacherDao(TeacherDao teacherDao) {
        this.teacherDao = teacherDao;
    }


    @RequestMapping("teacher/detail")
    public void detail(Scanner keyIn) {
        System.out.print("input email to show  ");
        String email=keyIn.nextLine();

        teacherDao.findByEmail(email);        
        Teacher teacher=teacherDao.findByEmail(email);
        System.out.println("name: "+ teacher.getName());
        System.out.println("email: "+ teacher.getEmail());
        System.out.println("password: "+ teacher.getPassword());
        System.out.println("tel: "+ teacher.getTel());
        System.out.println("psy: "+ teacher.getPay());
        System.out.println("subject: "+ teacher.getSubjects());
    }

    
    
}
