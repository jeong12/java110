package bitcamp.java110.cms.control;
import java.util.Scanner;
import bitcamp.java110.cms.domain.Member; //알려주는 것(링크정보)! compile할 때는 사라짐. 

public class StudentController {

    public static Scanner keyIn;

    static class Student extends Member{
        protected String school;
        protected boolean working;
        protected String tel;

        public String getSchool() {
            return school;
        }
        public void setSchool(String school) {
            this.school = school;
        }
        public boolean isWorking() {
            return working;
        }
        public void setWorking(boolean working) {
            this.working = working;
        }
        public String getTel() {
            return tel;
        }
        public void setTel(String tel) {
            this.tel = tel;
        }    
    }  

    static Student [] students = new Student[5];
    static int studentIndex =0;



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
    private static void printStudents() {
        int count=0;
        for(Student s : students) {
            if(count++ == studentIndex)
                break;
            else {
                System.out.printf("%d: %s, %s, %s, %s, %b, %s\n",
                        count-1, s.getName(), 
                        s.getEmail(), s.getPassword(), s.getSchool()
                        ,s.isWorking(), s.getTel());
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

            if(studentIndex == students.length) {
                increaseStorage();
            }

            students[studentIndex++] = m;
            /*index++; 이걸 안쓰려면 위에 방법처럼 [index ++]*/

            System.out.println("continue?(Y/n) ");
            String answer = keyIn.nextLine();
            if(answer.toLowerCase().equals("n"))
                break;
        } 

    }
    private static void increaseStorage() {
        Student[] newList=new Student[students.length+3];
        for(int i=0;i<students.length;i++) {
            newList[i]=students[i];
        }
        students=newList;
    }

    private static void deleteStudent() {
        System.out.print("input number to delete");
        int no=Integer.parseInt(keyIn.nextLine());

        if(no<0 || no>=studentIndex) {
            System.out.println("unvailed number");
            return;
        }
        for(int i=no;i<studentIndex-1;i++) {
            students[i]=students[i+1];
        }
        studentIndex--;
        System.out.println("delete success!");
    }

    private static void detailStudent() {
        System.out.print("input number to show");
        int no=Integer.parseInt(keyIn.nextLine());

        if(no<0 || no>=studentIndex) {
            System.out.println("unvailed number");
            return;
        }
        System.out.println("name: " + students[no].getName());
        System.out.println("email: " + students[no].getEmail());
        System.out.println("password: " + students[no].getPassword());
        System.out.println("tel: "+ students[no].getTel());
        System.out.println("working: "+ students[no].isWorking());
        System.out.println("school: " + students[no].getSchool());
    }

    static {
        Student s=new Student();
        s.setName("a");
        students[studentIndex++]=s;
        s=new Student();
        s.setName("b");
        students[studentIndex++]=s;
        s=new Student();
        s.setName("c");
        students[studentIndex++]=s;
        s=new Student();
        s.setName("d");
        students[studentIndex++]=s;
        s=new Student();
        s.setName("e");
        students[studentIndex++]=s;



    }
}
