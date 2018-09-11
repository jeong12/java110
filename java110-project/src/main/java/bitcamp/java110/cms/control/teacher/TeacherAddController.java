package bitcamp.java110.cms.control.teacher;

import java.util.Scanner;

import bitcamp.java110.cms.annotation.Autowired;
import bitcamp.java110.cms.annotation.Component;
import bitcamp.java110.cms.annotation.RequestMapping;
import bitcamp.java110.cms.dao.TeacherDao;
import bitcamp.java110.cms.domain.Teacher;

@Component
public class TeacherAddController {
<<<<<<< HEAD

    TeacherDao teacherDao;

=======
    
    TeacherDao teacherDao;
    
>>>>>>> b1
    @Autowired
    public void setTeacherDao(TeacherDao teacherDao) {
        this.teacherDao = teacherDao;
    }

<<<<<<< HEAD


=======
>>>>>>> b1
    @RequestMapping("teacher/add")
    public void add(Scanner keyIn) {
        while (true) {
            Teacher m = new Teacher();
            
            System.out.print("이름? ");
            m.setName(keyIn.nextLine());
            
            System.out.print("이메일? ");
            m.setEmail(keyIn.nextLine());
            
            System.out.print("암호? ");
            m.setPassword(keyIn.nextLine());
            
            System.out.print("전화? ");
            m.setTel(keyIn.nextLine());
            
            System.out.print("시급? ");
            m.setPay(Integer.parseInt(keyIn.nextLine()));
            
            System.out.print("강의과목?(예: 자바,C,C++) ");
            m.setSubjects(keyIn.nextLine());
<<<<<<< HEAD

            if(teacherDao.insert(m)>0) {
                System.out.println("success to insert!");
            }else {
                System.out.println("fail to insert :(");
=======
            
            if (teacherDao.insert(m) > 0) {
                System.out.println("저장하였습니다.");
            } else {
                System.out.println("같은 이메일의 강사가 존재합니다.");
>>>>>>> b1
            }
            
            System.out.print("계속 하시겠습니까?(Y/n) ");
            String answer = keyIn.nextLine();
            if (answer.toLowerCase().equals("n"))
                break;
        }
    }
}
