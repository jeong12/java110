package bitcamp.java110.cms.client;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientApp {

    static Scanner keyIn = new Scanner(System.in);

    public static void main(String[] args) throws Exception {

        try(
                //서버에 연결하기
                Socket socket = new Socket("localhost",8888);

                //서버에 데이터를 보내고 읽을 도구 준비
                PrintStream out=new PrintStream(
                        new BufferedOutputStream(
                                socket.getOutputStream()));

                BufferedReader in = new BufferedReader(
                        new InputStreamReader(
                                socket.getInputStream()));
                ){
            out.println("HELLO"); //blocking 방식으도 동작. 서버가 응답이 오면 다음 작업 도입
            //반드시 응해야함. 만약 응하지 않고, 서로 말하면 망...
            out.flush();
            System.out.println(in.readLine());

            while (true) {
                String requestLine = prompt();
                out.println(requestLine); out.flush();                
                while(true) {
                    String responseLine = in.readLine();
                    System.out.println(responseLine);
                    if(responseLine.length()==0)
                        break;
                }
                if (requestLine.equals("EXIT")){
                    break;
                } 

            }
        }

        keyIn.close();
    }

    private static String prompt() {
        System.out.print("입력> ");
        return keyIn.nextLine();
    }
}