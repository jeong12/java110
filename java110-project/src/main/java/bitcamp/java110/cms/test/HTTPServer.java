package bitcamp.java110.cms.test;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class HTTPServer {
    public static void main(String[]args) throws Exception{
        ServerSocket serversocket = new ServerSocket(8080);
        while(true) {
            try(
                    Socket socket = serversocket.accept();
                    PrintStream out = new PrintStream(socket.getOutputStream());
                    Scanner in = new Scanner(socket.getInputStream());
                    ){
                //read data sent from client        
                while(true) {
                    String str = in.nextLine();
                    System.out.println(str);

                    if(str.length() ==0)
                        break;
                }
                // reply client
                out.println("HTTP/1.1 200 OK");
                //out.println("Content-Length: 6");
                out.println();
                out.print("Hello!");
            }
        }
    }
}
