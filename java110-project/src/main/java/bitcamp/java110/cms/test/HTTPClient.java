package bitcamp.java110.cms.test;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class HTTPClient {
    public static void main(String[]args) throws Exception{
        try(
        Socket socket = new Socket("www.zdnet.co.kr",80);
        PrintStream out = new PrintStream(socket.getOutputStream());
        Scanner in = new Scanner(socket.getInputStream());
        ){
        //HTTP 요청
        //1) request-line
        out.println("GET / HTTP/1.1");
        
        //2) request header
        //필수!
        out.println("Host: www.zdnet.co.kr"); 
        //연결유지 상태
        out.println("Connection: keep-alive");
        //서버에게 누군지 알려줌. (브라우저마다 자기가 밝힘)
        out.println("User-Agent: Mozilla/5.0 (Windows NT 6.3; Win64; x64) "
                + "AppleWebKit/537.36 (KHTML, like Gecko) Chrome/68.0.3440.106 "
                + "Safari/537.36"); 
      //파일 요구. ,는  대체제
        out.println("Accept: text/html,application/xhtml+xml,application/"
                + "xml;q=0.9,image/webp,image/apng,*/*;q=0.8"); 
      //언어
        out.println("Accept-Language: ko-KR,ko;q=0.9,en-US;q=0.8,en;q=0.7");
       
        //3) mark end of head
        out.println();
        
        //4) data to send to server (message-body) <= omit possible 
        
        while(true) {
            String str = in.nextLine();
            System.out.println(str);
        }
    }
    }

}
