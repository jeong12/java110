import java.util.Scanner;

public class App {
    public static void main(String[] args) {
     
       Scanner keyIn = new Scanner(System.in);
       
       while(true) {
       System.out.print("name? ");
       String name = keyIn.nextLine();
       System.out.print("email? ");
       String email = keyIn.nextLine();
       System.out.print("password? ");
       String password = keyIn.nextLine();
       System.out.printf("%s, %s, %s\n",name,email,password);
       
       System.out.println("continue?(Y/n) ");
       String answer = keyIn.nextLine();
       if(answer.toLowerCase().equals("n"))
           break;
       } 
       
       
    }
}
