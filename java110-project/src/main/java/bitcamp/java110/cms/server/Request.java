package bitcamp.java110.cms.server;

import java.util.HashMap;
import java.util.Map;

public class Request {
    String command;
    String appPath;
    String queryString;
    Map<String,String> paramMap = new HashMap<>();

    public Request(String command) {
        this.command=command;


        //명령어에서 Query String을 분리한다.
        //ex)manager/add?name=aaa&email=aaa@text.com&password=1111
        String[] values = command.split("\\?"); 
        /// \를 붙이지 않으면 정규표현식 명령어인 ?로 취급 -> \?도 오류! 자바에서 \도 명령어니까
        // 결국 첫번째 \는 자바, 뒤의 \는 정규표현식

        this.appPath=values[0]; // ex)manager/add
        if(values.length>=2) { 
            queryString = values[1]; //ex)name=aaa&email=aaa@text.com&password=1111

            parseQueryString(queryString);
        }    
    }

    private void parseQueryString(String qs) {
        String[]values = qs.split("&");
        for(String value : values) {
            String[] kv = value.split("=");
            paramMap.put(kv[0], kv[1]);

        }

    }

    public String getParameter(String name) {
        return this.paramMap.get(name);
    }

    public String getCommand() {
        return this.command;
    }

    public String getApppath() { //servelet에서는 serveletpath
        return this.appPath;
    }

    public String getQueryString() {
        return this.queryString;
    }

    public static void main(String[]args) {
        String str="manager/add?name=abcd&email=abcd@test.com&password=1234&tel=1111-1112&position=대리";
        Request req=new Request(str);
        System.out.println("==================");
        System.out.println(req.getParameter("name"));
        System.out.println(req.getParameter("email"));
        System.out.println(req.getParameter("password"));        
        System.out.println("==================");
        System.out.println(req.getCommand());
        System.out.println(req.appPath);
        System.out.println(req.queryString);

     /*           assertEquals(req.getCommand(),"manager/detail?no=10");
        assertEquals(req.getApppath(),"manager/detail");
        assertEquals(req.queryString,"no=10");
        //만약 주장이 틀리면 오류, 맞으면 그냥 뜸. 단위테스트 할 때! 
*/
    }

}
