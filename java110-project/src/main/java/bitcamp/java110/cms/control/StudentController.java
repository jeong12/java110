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

    static Student [] students = new Student[100];
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
                System.out.printf("%s, %s, %s, %s, %b, %s\n",s.getName(), 
                        s.getEmial(), s.getPassword(), s.getSchool()
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
            m.setEmial(keyIn.nextLine());
            System.out.print("password? ");
            m.setPassword(keyIn.nextLine());
            System.out.print("fianl grade? ");
            m.setSchool(keyIn.nextLine());
            System.out.print("work now? (true/false)");
            m.setWorking(Boolean.parseBoolean(keyIn.nextLine()));
            System.out.print("tel? ");
            m.setTel(keyIn.nextLine());

            students[studentIndex++] = m;
            /*index++; 이걸 안쓰려면 위에 방법처럼 [index ++]*/

            System.out.println("continue?(Y/n) ");
            String answer = keyIn.nextLine();
            if(answer.toLowerCase().equals("n"))
                break;
        } 

    }
}
