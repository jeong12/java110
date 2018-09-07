package bitcamp.java110.cms.context;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
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
        // 현재 클래스를 실행하는 JVM이 java classpath에서 찾음! 
        System.out.println(file.getAbsolutePath());

        //2) 패키지 폴더에 들어 있는 파일 목록을 알아낸다. 패키지 폴더에 들어있는 클래스를 찾아 인스턴스를 생성하여 objPool에 보관한다.
        findClass(file,path);

        //해당 패기지에 있는 클래스는 찾아서 인스턴스를 생성한 후에 obj에 보관
        //1)인스턴스 생성
    }

    //objPool에서 주어진 객체를 이름으로 찾아 리턴
    public Object getBean(String name) {
        return objPool.get(name);
    }

    private void findClass(File path, String packagePath)throws Exception {
        //String[]filenames=path.list(); 
        //현재 폴더의 이름. 하위나 상위는 알려주지 않음. 이름만 리턴이라서 파일이랑 폴더랑 구분을 시켜주지 않음
        File[]files=path.listFiles(); 
        for(File file:files) {
            if(file.isDirectory()) {
                findClass(file,packagePath +"/" + file.getName()); //재귀호출
            }else {
                String className=(packagePath + "/" +file.getName())
                        .replace("/",".").replace(".class","");                
             
                //1)클래스 이름을 가지고 .class 파일을 찾아 메모리에 로딩한다.
                
              Class<?> clazz =Class.forName(className);
              //=> 인터페이스인 경우, 무시한다.
              if(clazz.isInterface()) continue;
              try {
              //2)로딩된 클래스 정보를 가지고 인스턴스를 생성
              //->먼저 해당 클래스의  생성자의 정보를 얻는다.
              Constructor<?> constructor=clazz.getConstructor();
              //->생성자를 가지고 인스턴스를 생성한다.
              Object instance=constructor.newInstance();
              
              // ->이름으로 인스턴스의 필드를 찾는다.
              Field field=clazz.getField("name");
              
              // ->"name"필드의 값을 꺼낸다.
              Object name=field.get(instance);
              //System.out.println(clazz.getName() + "==>" + name);
              
              // =>"name" 필드의 값으로 인스턴스를 objPool에 저장한다.
              objPool.put((String)name,instance);
              
              System.out.println(instance.getClass());
              }catch(Exception e) {
                  e.printStackTrace();
                  System.out.printf("%s class dosen't have default constructor\n",
                          clazz.getName());
              }
            }
        }
    }
}
