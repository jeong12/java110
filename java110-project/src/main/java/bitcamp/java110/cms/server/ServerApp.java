package bitcamp.java110.cms.server;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import bitcamp.java110.cms.context.RequestMappingHandlerMapping;
import bitcamp.java110.cms.context.RequestMappingHandlerMapping.RequestMappingHandler;

public class ServerApp {

    ClassPathXmlApplicationContext iocContainer;
    RequestMappingHandlerMapping requestHandlerMap; 
    
    public ServerApp() throws Exception{
        createIoCContatiner();
        logBeansOfContatiner();
        processRequestMappingAnnotation();
    }

    private void createIoCContatiner() {
        iocContainer = new ClassPathXmlApplicationContext(
                "bitcamp/java110/cms/conf/Application-context.xml");
    }
    
    private void processRequestMappingAnnotation() {
        requestHandlerMap = new RequestMappingHandlerMapping();
        String[] names = iocContainer.getBeanDefinitionNames();
        for (String name : names) {
            Object obj = iocContainer.getBean(name);            
            requestHandlerMap.addMapping(obj);
        }
    }

    private void logBeansOfContatiner() {
        System.out.println(":::::::::::::::::::::");
        String[]nameList=iocContainer.getBeanDefinitionNames();
        for(String name:nameList) {
            System.out.println(name);
        }
        System.out.println(":::::::::::::::::::::");
    }

    public void service() throws Exception{
        //클라이언트 연결을 기다리는 서버 소켓 준비      포트번호,backlog(대기열 크기) : 대기열은 que방식!
        ServerSocket seversocket = new ServerSocket(8888);
        System.out.println("서버 실행 중...");

        while(true) {
            try(
                    Socket socket = seversocket.accept();
                    
                    //Servelt에서는 printStream이 아닌, PrintWrite를 씀.
                    PrintWriter out=new PrintWriter(
                            new BufferedOutputStream(
                                    socket.getOutputStream()));

                    BufferedReader in = new BufferedReader(
                            new InputStreamReader(
                                    socket.getInputStream()));
                    ){
                System.out.println(in.readLine());
                out.println("OK:희정"); out.flush();
                
                while(true) {
                    String requestLine = in.readLine();
                    if(requestLine.equals("EXIT")) {
                        out.println("goodbye");
                        out.println(); out.flush();
                        break;
                    }
                    
                    //요청 객체 준비
                    Request request = new Request(requestLine);
                    
                    //응답 객체 준비
                    Response response = new Response(out);
                    
                    RequestMappingHandler mapping = 
                            requestHandlerMap.getMapping(request.getApppath());
                    if (mapping == null) {
                        out.println("해당 요청을 처리할 수 없습니다.");
                        out.println(); out.flush();
                        continue;
                    }
                    try {                        
                        //요청 핸들러 호출
                    mapping.getMethod().invoke(mapping.getInstance(), request, response);
                    //mapping.getInstance() : method 주소를 줌.  만약 static일때는 null;
                    }catch(Exception e) {
                        e.printStackTrace();
                        out.println("요청 처리 중에 오류가 발생했습니다.");
                    }
                    out.println();
                    out.flush();
                }
            }
        }
    }

    
    public static void main(String[] args) throws Exception {

        ServerApp serverApp = new ServerApp();
        serverApp.service();
    }
}