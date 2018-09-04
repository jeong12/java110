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
    
    static Member [] members = new Member[100];
    static int index =0;

    static Scanner keyIn = new Scanner(System.in);

    public static void main(String[] args) {
        inputMembers();
        printMembers();
        keyIn.close();
    }

    static void printMembers() {
        for(int i=0; i<index; i++) {
            System.out.printf("%s, %s, %s\n",members[i].getName(), 
                    members[i].getEmial(), members[i].getPassword());
            //위치 이동할 때, alt 누르고 방향기로 위 아래!
            //method 앞에  static 붙이면 classmethod
        }
    }
    
    static void inputMembers() {
        while(true) {
            Member m = new Member();
            System.out.print("name? ");
            m.setName(keyIn.nextLine());
            System.out.print("email? ");
            m.setEmial(keyIn.nextLine());
            System.out.print("password? ");
            m.setPassword(keyIn.nextLine());
            
            members[index++] = m;
            /*index++; 이걸 안쓰려면 위에 방법처럼 [index ++]*/

            System.out.println("continue?(Y/n) ");
            String answer = keyIn.nextLine();
            if(answer.toLowerCase().equals("n"))
                break;
        } 

    }
}
