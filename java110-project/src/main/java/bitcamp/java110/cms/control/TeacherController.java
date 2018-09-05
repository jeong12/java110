package bitcamp.java110.cms.control;
import java.util.Scanner;

import bitcamp.java110.cms.dao.TeacherList;
import bitcamp.java110.cms.domain.Member;
import bitcamp.java110.cms.domain.Teacher;

public class TeacherController {

    public  static Scanner keyIn;

      public static void serviceTeacherMenu() {
        while(true) {
            System.out.print("teacher menu> ");
            String command=keyIn.nextLine();
            if(command.equals("list")) {
                printTeachers();
            }
            else if(command.equals("add")) {
                inputTeachers();
            }
            else if(command.equals("delete")) {
                deleteTeacher();
            }
            else if(command.equals("detail")) {
                detailTeacher();
            }
            else if(command.equals("quit")) {
                break;
            }
            else {
                System.out.println("command is not vaild");
            }
        }
    }

    private static void inputTeachers() {
        while(true) {
            Teacher m = new Teacher();
            System.out.print("name? ");
            m.setName(keyIn.nextLine());
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

            TeacherList.add(m);

            System.out.println("continue?(Y/n) ");
            String answer = keyIn.nextLine();
            if(answer.toLowerCase().equals("n"))
                break;
        } 

    }
    
   
    private static void printTeachers() {
        for(int i=0; i<TeacherList.size();i++) {
            Teacher teacher=TeacherList.get(i);
                System.out.printf("%d: %s, %s, %s, %s, %d, [%s]\n",
                        i, teacher.getName(),teacher.getEmail(), 
                        teacher.getPassword(),teacher.getTel()
                        ,teacher.getPay(), teacher.getSubjects());
            }
        }
    
    private static void deleteTeacher() {
        System.out.print("input number to delete  ");
        int no=Integer.parseInt(keyIn.nextLine());
        TeacherList.remove(no);
        System.out.println("delete success!");
    }

    
    private static void detailTeacher() {
        System.out.print("input number to show  ");
        int no=Integer.parseInt(keyIn.nextLine());

        Teacher teacher=TeacherList.get(no);
        System.out.println("name: "+ teacher.getName());
        System.out.println("email: "+ teacher.getEmail());
        System.out.println("password: "+ teacher.getPassword());
        System.out.println("tel: "+ teacher.getTel());
        System.out.println("psy: "+ teacher.getPay());
        System.out.println("subject: "+ teacher.getSubjects());
    }

    static {
        Teacher s=new Teacher();
        s.setName("a");
        TeacherList.add(s);
        s=new Teacher();
        s.setName("b");
        TeacherList.add(s);
        s=new Teacher();
        s.setName("c");
        TeacherList.add(s);
        s=new Teacher();
        s.setName("d");
        TeacherList.add(s);
        s=new Teacher();
        s.setName("e");
        TeacherList.add(s);
    }
}
