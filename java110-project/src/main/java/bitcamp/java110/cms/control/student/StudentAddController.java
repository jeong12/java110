package bitcamp.java110.cms.control.student;

import java.util.Scanner;

import bitcamp.java110.cms.App;
import bitcamp.java110.cms.annotation.Component;
import bitcamp.java110.cms.annotation.RequestMapping;
import bitcamp.java110.cms.domain.Student;

@Component
public class StudentAddController {

    
    @RequestMapping("student/add")
    public void add(Scanner keyIn) {
        while(true) {
            Student m = new Student();
            System.out.print("name? ");
            m.setName(keyIn.nextLine());
            System.out.print("email? ");
            m.setEmail(keyIn.nextLine());
            System.out.print("password? ");
            m.setPassword(keyIn.nextLine());
            System.out.print("fianl grade? ");
            m.setSchool(keyIn.nextLine());
            System.out.print("work now? (true/false)");
            m.setWorking(Boolean.parseBoolean(keyIn.nextLine()));
            System.out.print("tel? ");
            m.setTel(keyIn.nextLine());

            App.students.add(m); //student 자체를 add

            System.out.println("continue?(Y/n) ");
            String answer = keyIn.nextLine();
            if(answer.toLowerCase().equals("n"))
                break;
        } 
    }
    
   { 
        Student s=new Student();
        s.setName("a");
        App.students.add(s);
        s=new Student();
        s.setName("b");
        App.students.add(s);
        s=new Student();
        s.setName("c");
        App.students.add(s);
        s=new Student();
        s.setName("d");
        App.students.add(s);
        s=new Student();
        s.setName("e");
        App.students.add(s);
    }   
}
