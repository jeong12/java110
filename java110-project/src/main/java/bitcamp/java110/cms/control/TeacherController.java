package bitcamp.java110.cms.control;
import java.util.Scanner;

import bitcamp.java110.cms.domain.Member;

public class TeacherController {

    static Teacher [] teachers = new Teacher[100];
    static int teacherIndex =0;
    public  static Scanner keyIn;

    static class Teacher extends Member{
        protected String tel;
        protected int pay;
        protected String subjects;

        public String getTel() {
            return tel;
        }
        public void setTel(String tel) {
            this.tel = tel;
        }
        public int getPay() {
            return pay;
        }
        public void setPay(int pay) {
            this.pay = pay;
        }
        public String getSubjects() {
            return subjects;
        }
        public void setSubjects(String subjects) {
            this.subjects = subjects;
        }
    }


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

    private static void printTeachers() {
        int count=0;
        for(Teacher s : teachers) {
            if(count++ == teacherIndex)
                break;
            else {
                System.out.printf("%d: %s, %s, %s, %s, %d, [%s]\n",
                        count-1, s.getName(),s.getEmail(), s.getPassword(), 
                        s.getTel(),s.getPay(), s.getSubjects());
                //위치 이동할 때, alt 누르고 방향기로 위 아래!
                //method 앞에  static 붙이면 classmethod
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

            if(teacherIndex == teachers.length) {
                increaseStorage();
            }
            
            teachers[teacherIndex++] = m;
            /*index++; 이걸 안쓰려면 위에 방법처럼 [index ++]*/

            System.out.println("continue?(Y/n) ");
            String answer = keyIn.nextLine();
            if(answer.toLowerCase().equals("n"))
                break;
        } 

    }
    
    private static void increaseStorage() {
        Teacher[] newList=new Teacher[teachers.length+3];
        for(int i=0;i<teachers.length;i++) {
            newList[i]=teachers[i];
        }
        teachers=newList;
    }
    private static void deleteTeacher() {
        System.out.print("input number to delete  ");
        int no=Integer.parseInt(keyIn.nextLine());

        if(no<0 || no>=teacherIndex) {
            System.out.println("unvailed number");
            return;
        }
        for(int i=no;i<teacherIndex-1;i++) {
            teachers[i]=teachers[i+1];
        }
        teacherIndex--;
        System.out.println("delete success!");
    }

    
    private static void detailTeacher() {
        System.out.print("input number to show  ");
        int no=Integer.parseInt(keyIn.nextLine());

        if(no<0 || no>=teacherIndex) {
            System.out.println("unvailed number");
            return;
        }
        System.out.println("name: "+ teachers[no].getName());
        System.out.println("email: "+ teachers[no].getEmail());
        System.out.println("password: "+ teachers[no].getPassword());
        System.out.println("tel: "+ teachers[no].getTel());
        System.out.println("psy: "+ teachers[no].getPay());
        System.out.println("subject: "+ teachers[no].getSubjects());
    }

    static {
        Teacher s=new Teacher();
        s.setName("a");
        teachers[teacherIndex++]=s;
        s=new Teacher();
        s.setName("b");
        teachers[teacherIndex++]=s;
        s=new Teacher();
        s.setName("c");
        teachers[teacherIndex++]=s;
        s=new Teacher();
        s.setName("d");
        teachers[teacherIndex++]=s;
        s=new Teacher();
        s.setName("e");
        teachers[teacherIndex++]=s;



    }

}
