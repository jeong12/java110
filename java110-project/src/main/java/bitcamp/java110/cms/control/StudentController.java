package bitcamp.java110.cms.control;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import bitcamp.java110.cms.annotation.Component;
import bitcamp.java110.cms.annotation.RequestMapping;
import bitcamp.java110.cms.domain.Student;

@Component
public class StudentController{
   
    private List<Student> students=new ArrayList<>();
   
    public StudentController() {
        init();
    }
    
    @RequestMapping("student")
    public void student(Scanner keyIn) {
        while(true) {
            System.out.print("student menu> ");
            String command=keyIn.nextLine();
            if(command.equals("list")) {
                printStudents();
            }
            else if(command.equals("add")) {
                inputStudents(keyIn);
            }else if(command.equals("delete")) {
                deleteStudent(keyIn);
            }else if(command.equals("detail")) {
                detailStudent(keyIn);
            }
            else if(command.equals("quit")) {
                break;
            }
            else {
                System.out.println("command is not vaild");
            }
        }
    }

    private void inputStudents(Scanner keyIn) {
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

            students.add(m); //student 자체를 add

            System.out.println("continue?(Y/n) ");
            String answer = keyIn.nextLine();
            if(answer.toLowerCase().equals("n"))
                break;
        } 

    }

    private void printStudents() {
        for(int i=0; i<students.size();i++) {
            Student s=students.get(i);
            System.out.printf("%d: %s, %s, %s, %s, %b, %s\n",
                    i, s.getName(), 
                    s.getEmail(), s.getPassword(), s.getSchool()
                    ,s.isWorking(), s.getTel());
        }
    }


    private void deleteStudent(Scanner keyIn) {
        System.out.print("input number to delete  ");
        int no=Integer.parseInt(keyIn.nextLine());

        if(no<0 || no>=students.size()) {
            System.out.println("unvailed number");
            return;
        }
        students.remove(no);
        System.out.println("delete success!");
    }

    private void detailStudent(Scanner keyIn) {
        System.out.print("input number to show  ");
        int no=Integer.parseInt(keyIn.nextLine());

        if(no<0 || no>=students.size()) {
            System.out.println("unvailed number");
            return;
        }
        Student student = (Student)students.get(no);
        System.out.println("name: " + student.getName());
        System.out.println("email: " + student.getEmail());
        System.out.println("password: " + student.getPassword());
        System.out.println("tel: "+ student.getTel());
        System.out.println("working: "+ student.isWorking());
        System.out.println("school: " + student.getSchool());
    }

     private void init(){ 
        Student s=new Student();
        s.setName("a");
        students.add(s);
        s=new Student();
        s.setName("b");
        students.add(s);
        s=new Student();
        s.setName("c");
        students.add(s);
        s=new Student();
        s.setName("d");
        students.add(s);
        s=new Student();
        s.setName("e");
        students.add(s);


    } 
}
