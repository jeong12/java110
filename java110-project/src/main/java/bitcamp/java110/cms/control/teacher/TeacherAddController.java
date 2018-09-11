package bitcamp.java110.cms.control.teacher;

import java.util.Scanner;

import bitcamp.java110.cms.annotation.Autowired;
import bitcamp.java110.cms.annotation.Component;
import bitcamp.java110.cms.annotation.RequestMapping;
import bitcamp.java110.cms.dao.TeacherDao;
import bitcamp.java110.cms.domain.Teacher;

@Component
public class TeacherAddController {

    TeacherDao teacherDao;

    @Autowired
    public void setTeacherDao(TeacherDao teacherDao) {
        this.teacherDao = teacherDao;
    }



    @RequestMapping("teacher/add")
    public void add(Scanner keyIn) {
        while(true) {
            Teacher m = new Teacher();
            System.out.print("name? ");
            m.setName(keyIn.nextLine()); //argument
            System.out.print("email? ");
            m.setEmail(keyIn.nextLine());
            System.out.print("password? ");
            m.setPassword(keyIn.nextLine());
            System.out.print("tel? ");
            m.setTel(keyIn.nextLine());
            System.out.print("pay? ");
            m.setPay(Integer.parseInt(keyIn.nextLine()));
            System.out.print("subjects? (ex: java, c, c++) ");
            m.setSubjects(keyIn.nextLine());

            if(teacherDao.insert(m)>0) {
                System.out.println("success to insert!");
            }else {
                System.out.println("fail to insert :(");
            }

            
            System.out.println("continue?(Y/n) ");
            String answer = keyIn.nextLine();
            if(answer.toLowerCase().equals("n"))
                break;
        } 

    }
}
