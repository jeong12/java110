package bitcamp.java110.cms.context;

import java.io.File;
import java.util.HashMap;

import org.apache.ibatis.io.Resources;

public class ApplicationContext {  
    HashMap<String,Object> objPool=new HashMap<>();
    
    public ApplicationContext(String packageName) throws Exception {
   
        //패키지 이름을 파일 경로로 바꾼다.
        String path=packageName.replace(".", "/");
        System.out.println(path);
   
        // 패키지 경로를 가지고 전체 파일 경로를 알아낸다. (Resouces가)
        File file = Resources.getResourceAsFile(path);
        System.out.println(file.getAbsolutePath());
        
        //해당 패기지에 있는 클래스는 찾아서 인스턴스를 생성한 후에 obj에 보관
        //1)인스턴스 생성
    }
    
    public Object getBean(String name) {
        //objPool에서 주어진 이름의 객체를 찾아 리턴
        return null;
    }
    
}
