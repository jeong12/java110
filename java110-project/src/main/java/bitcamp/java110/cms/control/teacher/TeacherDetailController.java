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
<<<<<<< HEAD

=======
    
>>>>>>> b1
    @Autowired
    public void setTeacherDao(TeacherDao teacherDao) {
        this.teacherDao = teacherDao;
    }
<<<<<<< HEAD


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
=======

    @RequestMapping("teacher/detail")
    public void detail(Scanner keyIn) {
        System.out.print("조회할 강사의 이메일? ");
        String email = keyIn.nextLine();
        Teacher t = teacherDao.findByEmail(email);
        
        if (t == null) {
            System.out.println("해당 이메일의 강사 정보가 없습니다!");
            return;
        }
        
        System.out.printf("이름: %s\n", t.getName());
        System.out.printf("이메일: %s\n", t.getEmail());
        System.out.printf("암호: %s\n", t.getPassword());
        System.out.printf("전화: %s\n", t.getTel());
        System.out.printf("시급: %d\n", t.getPay());
        System.out.printf("강의과목: %s\n", t.getSubjects());
>>>>>>> b1
    }
}
