import java.util.Scanner;

public class App {
    static String []names = new String[100];
    static String []emails = new String[100];
    static String []passwords = new String[100];

    static int index =0;

    static Scanner keyIn = new Scanner(System.in);

    public static void main(String[] args) {
        inputMembers();
        printMembers();
        keyIn.close();
    }

    static void printMembers() {
        for(int i=0; i<index; i++) {
            System.out.printf("%s, %s, %s\n",names[i],emails[i],passwords[i]);
            //위치 이동할 때, alt 누르고 방향기로 위 아래!
            //method 앞에  static 붙이면 classmethod
        }
    }
    static void inputMembers() {

        while(true) {
            System.out.print("name? ");
            names[index] = keyIn.nextLine();

            System.out.print("email? ");
            emails[index] = keyIn.nextLine();

            System.out.print("password? ");
            passwords[index] = keyIn.nextLine();

            index++;

            System.out.println("continue?(Y/n) ");
            String answer = keyIn.nextLine();
            if(answer.toLowerCase().equals("n"))
                break;
        } 

    }
}
