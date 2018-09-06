package bitcamp.java110.cms.control;
import java.util.Scanner;

import bitcamp.java110.cms.domain.Student;
import bitcamp.java110.cms.util.ArrayList;

public class StudentController {

    public static Scanner keyIn;

    public static void serviceStudentMenu() {
        while(true) {
            System.out.print("student menu> ");
            String command=keyIn.nextLine();
            if(command.equals("list")) {
                printStudents();
            }
            else if(command.equals("add")) {
                inputStudents();
            }else if(command.equals("delete")) {
                deleteStudent();
            }else if(command.equals("detail")) {
                detailStudent();
            }
            else if(command.equals("quit")) {
                break;
            }
            else {
                System.out.println("command is not vaild");
            }
        }
    }

    private static void inputStudents() {
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

            ArrayList.add(m); //student 자체를 add

            System.out.println("continue?(Y/n) ");
            String answer = keyIn.nextLine();
            if(answer.toLowerCase().equals("n"))
                break;
        } 

    }

    private static void printStudents() {
        for(int i=0; i<ArrayList.size();i++) {
            Student s=(Student)ArrayList.get(i);
            System.out.printf("%d: %s, %s, %s, %s, %b, %s\n",
                    i, s.getName(), 
                    s.getEmail(), s.getPassword(), s.getSchool()
                    ,s.isWorking(), s.getTel());
        }
    }


    private static void deleteStudent() {
        System.out.print("input number to delete  ");
        int no=Integer.parseInt(keyIn.nextLine());

        if(no<0 || no>=ArrayList.size()) {
            System.out.println("unvailed number");
            return;
        }
        ArrayList.remove(no);
        System.out.println("delete success!");
    }

    private static void detailStudent() {
        System.out.print("input number to show  ");
        int no=Integer.parseInt(keyIn.nextLine());

        if(no<0 || no>=ArrayList.size()) {
            System.out.println("unvailed number");
            return;
        }
        Student student = (Student)ArrayList.get(no);
        System.out.println("name: " + student.getName());
        System.out.println("email: " + student.getEmail());
        System.out.println("password: " + student.getPassword());
        System.out.println("tel: "+ student.getTel());
        System.out.println("working: "+ student.isWorking());
        System.out.println("school: " + student.getSchool());
    }

    static {
        Student s=new Student();
        s.setName("a");
        ArrayList.add(s);
        s=new Student();
        s.setName("b");
        ArrayList.add(s);
        s=new Student();
        s.setName("c");
        ArrayList.add(s);
        s=new Student();
        s.setName("d");
        ArrayList.add(s);
        s=new Student();
        s.setName("e");
        ArrayList.add(s);


    }
}
