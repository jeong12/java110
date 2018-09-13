package bitcamp.java110.cms.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bitcamp.java110.cms.annotation.Component;
import bitcamp.java110.cms.dao.DaoException;
import bitcamp.java110.cms.dao.ManagerDao;
import bitcamp.java110.cms.domain.Manager;

@Component
public class ManagerJdbcDao implements ManagerDao {
    private List<Manager> list = new ArrayList<>();
    
    public int insert(Manager manager) {
        return 0;
       
    }
    
    public List<Manager> findAll() {
        
        ArrayList<Manager> list = new ArrayList<>();

        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        // => java.sql.Driver 구현체를 로딩한다. 해당 클래스의 객체를 만들어 DriverManager에 등록.
      
      // DriverManager에게 java.sql.Connection 객체를 요구한다.
      // DriverManager는 등록된 Driver들 중에서 요구 사항에 맞는 드라이버를 찾아 connect()를 호출한다.
      // 그리고 connect() method의 return값을 그대로 리턴해줌.
      
      con=DriverManager.getConnection("jdbc:mariadb://localhost:3306/studydb",
              "study","1111");
      
      //=>질의 문을 작성할 객체를 준비한다.
      stmt = con.createStatement();
   
      rs=stmt.executeQuery(
              "  select   " + 
              "  m.name,  " +
              "  m.email, " +
              "  mr.posi  " + 
              " from p1_mgr as mr inner join p1_memb as m     "   + 
              " on mr.mrno = m.mno   ");
      
      //서버에 생성된 질의 결과를 한개씩 가져온다.
      while(rs.next()) {
          Manager mgr = new Manager();
          mgr.setEmail(rs.getString("email"));
          mgr.setName(rs.getString("name"));
          mgr.setPosition(rs.getString("posi"));
          
          list.add(mgr);
      }
        
      // 얘는 굳이 적을 필요가 없음. Class.forName하면 Drivermanager가 알아서 등록해줌!
      // 등록은 꼭 필요!! 다만, 내가 안하고 프로그램이 해줄 뿐..
      //DriverManager.registerDriver(new org.mariadb.jdbc.Driver());
    }catch(Exception e) {
        throw new DaoException(e);
    }finally {
        try {rs.close();} catch(Exception e) {}
        try {stmt.close();} catch(Exception e) {}
        try {con.close();} catch(Exception e) {}
    }
    return list;
    }
    
    public Manager findByEmail(String email) {
       
        return null;
    }
    
    public int delete(String email) {
       
        return 0;
    }
}