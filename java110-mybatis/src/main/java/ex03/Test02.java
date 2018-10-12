// MyBatis 적용 - 입력
package ex03;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test02 {

    public static void main(String[] args) throws Exception {
        // 1) mybatis 설정 파일 경로
        String resource = "ex03/mybatis-config.xml";
        
        // 2) 설정 파일을 읽을 InputStream 준비
        //    -> 자바 classpath에서 설정 파일을 찾는다.
        InputStream inputStream = Resources.getResourceAsStream(resource);
        
        // 3) sqlSession 객체를 생성해 줄 팩토리 객체를 준비
        //      -> mybatis 설정 파일에 정의된 대로 객체를 준비한다.
        
        SqlSessionFactory sqlSessionFactory =
          new SqlSessionFactoryBuilder().build(inputStream);
        
       MemberDao memberDao = new MemberDao();
       
       // 4) MyBatis 객체를 MemberDao에게 덤겨준다.
       memberDao.setSqlSessionFactory(sqlSessionFactory);
        
       // 5) 입력 테스트
       Member m= new Member();
       m.setName("honghonghong2");
       m.setEmail("honghong12345@test.com");
       m.setPassword("1111");
       m.setTel("1234-5678");
       System.out.println(m.getNo()); 
       memberDao.insert(m);
  
       System.out.println(m.getNo());     
    }
}
