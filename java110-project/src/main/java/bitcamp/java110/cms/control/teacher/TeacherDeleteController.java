package bitcamp.java110.cms.control.teacher;

import java.util.Scanner;

import bitcamp.java110.cms.annotation.Autowired;
import bitcamp.java110.cms.annotation.Component;
import bitcamp.java110.cms.annotation.RequestMapping;
import bitcamp.java110.cms.dao.TeacherDao;

@Component
public class TeacherDeleteController {
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

    
    @RequestMapping("teacher/delete")
    public void delete(Scanner keyIn) {
        System.out.print("input email to delete  ");
        String email=keyIn.nextLine();
        if(teacherDao.delete(email)>0) {
            System.out.println("delete success! ");
        }else {
            System.out.println("delete fail :(");
=======
    
    @RequestMapping("teacher/delete")
    public void delete(Scanner keyIn) {
        System.out.print("삭제할 강사의 이메일? ");
        String email = keyIn.nextLine();
        
        if (teacherDao.delete(email) > 0) {
            System.out.println("삭제하였습니다.");
        } else {
            System.out.println("이메일에 해당하는 강사가 없습니다.");
>>>>>>> b1
        }
    }
}
