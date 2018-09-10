package bitcamp.java110.cms.control;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import bitcamp.java110.cms.annotation.Component;
import bitcamp.java110.cms.annotation.RequestMapping;
import bitcamp.java110.cms.domain.Teacher;

@Component
public class TeacherController{

    private List<Teacher> teachers = new ArrayList<>();
    public TeacherController(){
        init();
    }

      @RequestMapping("teacher")
      public void teacher(Scanner keyIn) {
        while(true) {
            System.out.print("teacher menu> ");
            String command=keyIn.nextLine();
            if(command.equals("list")) {
                printTeachers();
            }
            else if(command.equals("add")) {
                inputTeachers(keyIn);
            }
            else if(command.equals("delete")) {
                deleteTeacher(keyIn);
            }
            else if(command.equals("detail")) {
                detailTeacher(keyIn);
            }
            else if(command.equals("quit")) {
                break;
            }
            else {
                System.out.println("command is not vaild");
            }
        }
    }

    private void inputTeachers(Scanner keyIn) //parameter 
    {
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

            teachers.add(m);

            System.out.println("continue?(Y/n) ");
            String answer = keyIn.nextLine();
            if(answer.toLowerCase().equals("n"))
                break;
        } 

    }
    
   
    private void printTeachers() {
        for(int i=0; i<teachers.size();i++) {
            Teacher teacher=teachers.get(i);
                System.out.printf("%d: %s, %s, %s, %s, %d, [%s]\n",
                        i, teacher.getName(),teacher.getEmail(), 
                        teacher.getPassword(),teacher.getTel()
                        ,teacher.getPay(), teacher.getSubjects());
            }
        }
    
    private void deleteTeacher(Scanner keyIn) {
        System.out.print("input number to delete  ");
        int no=Integer.parseInt(keyIn.nextLine());
        teachers.remove(no);
        System.out.println("delete success!");
    }

    
    private void detailTeacher(Scanner keyIn) {
        System.out.print("input number to show  ");
        int no=Integer.parseInt(keyIn.nextLine());

        Teacher teacher=teachers.get(no);
        System.out.println("name: "+ teacher.getName());
        System.out.println("email: "+ teacher.getEmail());
        System.out.println("password: "+ teacher.getPassword());
        System.out.println("tel: "+ teacher.getTel());
        System.out.println("psy: "+ teacher.getPay());
        System.out.println("subject: "+ teacher.getSubjects());
    }

    private void init(){
        Teacher s=new Teacher();
        s.setName("a");
        teachers.add(s);
        s=new Teacher();
        teachers.add(s);
        s=new Teacher();
        s.setName("c");
        teachers.add(s);
        s=new Teacher();
        s.setName("d");
        teachers.add(s);
        s=new Teacher();
        s.setName("e");
        teachers.add(s);
    }
}
