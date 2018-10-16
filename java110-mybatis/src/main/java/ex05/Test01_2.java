// MyBatis - select 를 별도로 실행하여 가져오기
package ex05;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test01_2 {

    public static void main(String[] args) throws Exception {

        String resource = "ex05/mybatis-config-01.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory =
          new SqlSessionFactoryBuilder().build(inputStream);
       
       BoardDao boardDao = new BoardDao();
       boardDao.setSqlSessionFactory(sqlSessionFactory);
        
       MemberDao memberDao = new MemberDao();
       memberDao.setSqlSessionFactory(sqlSessionFactory);

       HashMap<String, Object> params = new HashMap<>();
       params.put("rowNo", 0);
       params.put("pageSize", 5);
       
       List<Board> boards = boardDao.findAll(params);
           for(Board b : boards) {
               Member member = memberDao.findByNo(b.getMemberNo());
               System.out.printf("%d, %s, %d, %s, %s\n", 
                       b.getNo(), 
                       b.getTitle(), 
                       b.getViewCount(), 
                       member.getName(), 
                       b.getCreadtedDate());
           }
      
       // 게시물 상세조회 같이 한 개의 데이터를 가져올 때는 다음가 같이 작성자의 정보를 가져오기 위해 별도로 select를 실행해도 된다.
       
    }
}
