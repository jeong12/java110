// MyBatis - fk 컬럼으로 지정된 값 가져오기 해서 가져오기 - 첨부파일 가져오기 1
package ex08;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test02 {

    public static void main(String[] args) throws Exception {

        String resource = "ex08/mybatis-config-01.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory =
          new SqlSessionFactoryBuilder().build(inputStream);
       
       BoardDao boardDao = new BoardDao();
       boardDao.setSqlSessionFactory(sqlSessionFactory);

       Board board = boardDao.findByNo(4);
       System.out.printf("번호:%d\n", board.getNo());
       System.out.printf("제목:%s\n", board.getTitle());
       System.out.printf("내용:%s\n", board.getContent());
       System.out.printf("조회수:%d\n", board.getViewCount());
       System.out.printf("등록일:%s\n", board.getCreadtedDate());
      
       Member m= board.getMember();
       //System.out.printf("작성자 번호:%d\n", m.getNo());
       System.out.printf("작성자 번호:%d\n", board.getMemberNo());
       System.out.printf("작성자 이름:%s\n",m.getName());
       System.out.printf("작성자 이름:%s\n",m.getEmail());
       System.out.printf("작성자 전화:%s\n",m.getTel());
       
       // 게시물을 가져올 때 Mybatis는 첨부 파일 목록까지 준비해준다. 단지 꺼내 쓰기만 하면 된다.
       // 즉 게시물을 select 할 때 첨부파일 데이터까지 묶어서 처리한다.
       List<AttachFile> files = board.getAttachFiles();
       System.out.println("첨부파일:");
       for(AttachFile f : files) {
           System.out.printf("- %d,%s\n",f.getNo(),f.getFilename());
       }

    }
}
