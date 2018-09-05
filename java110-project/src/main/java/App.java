import java.util.Scanner;

public class App {


    //여러 속성의 값을 관리하기 쉽도록 사용자 정의 데이터 타입을 만들어 사용함.
    static class Member{
        protected String name;
        protected String emial;
        protected String password;

        //인스턴스의 메모리는 다루는 operator=getter/setter=accessor=property=message
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public String getEmial() {
            return emial;
        }
        public void setEmial(String emial) {
            this.emial = emial;
        }
        public String getPassword() {
            return password;
        }
        public void setPassword(String password) {
            this.password = password;
        }
    }

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
    static Teacher [] teachers = new Teacher[100];
    static int studentIndex =0;
    static int teacherIndex =0;

    static Scanner keyIn = new Scanner(System.in);

    public static void main(String[] args) {

        while(true) {
            String menu=promptMenu();
            if(menu.equals("1")) {
                serviceStudentMenu();
            }
            else if(menu.equals("2")) {
                serviceTeacherMenu();
            }
            else if(menu.equals("0")) {
                System.out.println("good-bye!");
                break;
            }
        }
        keyIn.close();
    }

    private static void serviceStudentMenu() {
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

    private static void serviceTeacherMenu() {
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
    
    
    private static String promptMenu() {
        System.out.println("menu");
        System.out.println("0. exit");
        System.out.println("1. student");
        System.out.println("2. teacher");
        System.out.println("3. manager");

        while(true) {
            System.out.print("menu number> ");

            String menu=keyIn.nextLine();

            switch(menu) {
            case "1":
            case "2":
            case "3":
            case "0":
                return menu; //break 없어도 가능하네.
            default:
                System.out.println("menu number is not vaild ");
            }
        }   
    }

    static void printStudents() {
        int count=0;
        for(Student s : students) {
            if(count++ == studentIndex)
                break;
            else {
                System.out.printf("%s, %s, %s, %s, %b, %s\n",s.getName(), 
                        s.getEmial(), s.getPassword(), s.getSchool()
                        ,s.isWorking(), s.getTel());
                //위치 이동할 때, alt 누르고 방향기로 위 아래!
                //method 앞에  static 붙이면 classmethod
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


    static void inputStudents() {
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
