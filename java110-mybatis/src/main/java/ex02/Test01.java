// factory 및 builder 디자인 패턴 적용

package ex02;

import java.util.List;

public class Test01 {

    public static void main(String[] args) throws Exception {
       
/*      
 *      MemberDaoFactory = new daoBuilder.build();
*       MemberDao memberDao = factory.createMemberDao();

 *      위의 문장을 풀은 것
        DaoBuilder daoBuilder = new DaoBuilder();
 *      MemberDaoFactory factory = new daoBuilder.build();
        // Factory method pattern. 보통은 build pattern or factory pattern 으로 사용
        MemberDao memberDao = factory.createMemberDao();
                    아래  문장을 풀은 것*/
        
        MemberDao memberDao = new DaoBuilder().build().createMemberDao();
        
        
        
       List<Member> list = memberDao.findAll();
       
       for(Member m : list) {
           System.out.printf("%d, %s, %s, %s\n",m.getNo(),m.getName(),m.getEmail(),m.getTel());
           
       }
       
    }
}
