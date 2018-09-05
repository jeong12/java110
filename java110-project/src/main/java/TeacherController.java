import java.util.Scanner;

public class TeacherController {

    static Teacher [] teachers = new Teacher[100];
    static int teacherIndex =0;
    static Scanner keyIn;

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


    static void serviceTeacherMenu() {
        while(true) {
            System.out.print("teacher menu> ");
            String command=keyIn.nextLine();
            if(command.equals("list")) {
                printTeachers();
            }
            else if(command.equals("add")) {
                inputTeachers();
            }
            else if(command.equals("quit")) {
                break;
            }
            else {
                System.out.println("command is not vaild");
            }
        }
    }

    static void printTeachers() {
        int count=0;
        for(Teacher s : teachers) {
            if(count++ == teacherIndex)
                break;
            else {
                System.out.printf("%s, %s, %s, %s, %d, [%s]\n",
                        s.getName(),s.getEmial(), s.getPassword(), 
                        s.getTel(),s.getPay(), s.getSubjects());
                //위치 이동할 때, alt 누르고 방향기로 위 아래!
                //method 앞에  static 붙이면 classmethod
            }
        }
    }

    static void inputTeachers() {
        while(true) {
            Teacher m = new Teacher();
            System.out.print("name? ");
            m.setName(keyIn.nextLine());
            System.out.print("email? ");
            m.setEmial(keyIn.nextLine());
            System.out.print("password? ");
            m.setPassword(keyIn.nextLine());
            System.out.print("tel? ");
            m.setTel(keyIn.nextLine());
            System.out.print("pay? ");
            m.setPay(Integer.parseInt(keyIn.nextLine()));
            System.out.print("subjects? (ex: java, c, c++) ");
            m.setSubjects(keyIn.nextLine());

            teachers[teacherIndex++] = m;
            /*index++; 이걸 안쓰려면 위에 방법처럼 [index ++]*/

            System.out.println("continue?(Y/n) ");
            String answer = keyIn.nextLine();
            if(answer.toLowerCase().equals("n"))
                break;
        } 

    } 


}
