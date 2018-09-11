package bitcamp.java110.cms.control.teacher;

import java.util.Scanner;

import bitcamp.java110.cms.annotation.Autowired;
import bitcamp.java110.cms.annotation.Component;
import bitcamp.java110.cms.annotation.RequestMapping;
import bitcamp.java110.cms.dao.TeacherDao;

@Component
public class TeacherDeleteController {
        
    TeacherDao teacherDao;

    @Autowired
    public void setTeacherDao(TeacherDao teacherDao) {
        this.teacherDao = teacherDao;
    }

    
    @RequestMapping("teacher/delete")
    public void delete(Scanner keyIn) {
        System.out.print("input email to delete  ");
        String email=keyIn.nextLine();
        if(teacherDao.delete(email)>0) {
            System.out.println("delete success! ");
        }else {
            System.out.println("delete fail :(");
        }
 
    }
}
