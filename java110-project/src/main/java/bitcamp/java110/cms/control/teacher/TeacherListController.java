package bitcamp.java110.cms.control.teacher;

import java.util.List;
import java.util.Scanner;

import bitcamp.java110.cms.App;
import bitcamp.java110.cms.annotation.Component;
import bitcamp.java110.cms.annotation.RequestMapping;
import bitcamp.java110.cms.domain.Teacher;

@Component
public class TeacherListController {

    @RequestMapping("teacher/list")
    public void list(Scanner keyIn) {
        List<Teacher> list=App.teacherDao.findAll();
        for(Teacher teacher:list) {
            System.out.printf("%s, %s, %s, %s, %d, [%s]\n",
                    teacher.getName(),teacher.getEmail(), 
                    teacher.getPassword(),teacher.getTel()
                    ,teacher.getPay(), teacher.getSubjects());
        }

    }
}
