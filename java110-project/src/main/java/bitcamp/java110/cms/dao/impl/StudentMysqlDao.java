package bitcamp.java110.cms.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bitcamp.java110.cms.annotation.Component;
import bitcamp.java110.cms.dao.DaoException;
import bitcamp.java110.cms.dao.StudentDao;
import bitcamp.java110.cms.domain.Student;

@Component
public class StudentMysqlDao implements StudentDao {

    public int insert(Student student) {
        Connection con = null;
        Statement stmt = null;

        try {         
            Class.forName("org.mariadb.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mariadb://localhost:3306/studydb", 
                    "study", "1111");

            con.setAutoCommit(false);

            stmt = con.createStatement();
            String sql = "insert into p1_memb(name,email,pwd,tel,cdt)"
                    + " values('" + student.getName()
                    + "','" + student.getEmail()
                    + "',password('" + student.getPassword()
                    + "'),'" + student.getTel()
                    + "',now())";

            stmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);

            ResultSet autogeneratedKeys = stmt.getGeneratedKeys();
            autogeneratedKeys.next();
            int memberNo = autogeneratedKeys.getInt(1);
            autogeneratedKeys.close();

            String n= null;
            if(student.isWorking()) {
                n="Y";
            }else {
                n="N";
            }
            
            String sql2 = "insert into p1_stud(sno,schl,work)"
                    + " values(" + memberNo+ ",'" + student.getSchool()
                    + "','" +n+"')";
                    System.out.println(sql2);
            stmt.executeUpdate(sql2);

            // 두 insert가 모두 성공했을 때만 서버에 완료 신호를 보낸다.
            con.commit();
            return 1;
        } catch (Exception e) {
            throw new DaoException(e);

        } finally {
            try {stmt.close();} catch (Exception e) {}
            try {con.close();} catch (Exception e) {}
        }

    }

    public List<Student> findAll() {
        ArrayList<Student> list = new ArrayList<>();

        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            Class.forName("org.mariadb.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mariadb://localhost:3306/studydb", 
                    "study", "1111");

            stmt = con.createStatement();
            rs = stmt.executeQuery(
                    "select" + 
                            " m.mno," +
                            " m.name," + 
                            " m.email," + 
                            " mr.schl," +
                            " mr.work" +
                            " from p1_stud mr" + 
                    " inner join p1_memb m on mr.sno = m.mno");

            // 서버에 생성된 질의 결과를 한 개씩 가져온다.
            while (rs.next()) {
                Student mgr = new Student();
                String an=null;
                mgr.setNo(rs.getInt("mno"));
                mgr.setEmail(rs.getString("email"));
                mgr.setName(rs.getString("name"));
                mgr.setSchool(rs.getString("schl"));
                
                if(rs.getString("work").equals("Y")) {
                    an="true";
                }else {
                    an="false";
                }                  

                mgr.setWorking(Boolean.parseBoolean(an));
                list.add(mgr);
            }
        } catch (Exception e) {
            throw new DaoException(e);
        } finally {
            try {rs.close();} catch (Exception e) {}
            try {stmt.close();} catch (Exception e) {}
            try {con.close();} catch (Exception e) {}
        }
        return list;
    }


public Student findByNo(int no) {
    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;
    
    try {
        Class.forName("org.mariadb.jdbc.Driver");
        con = DriverManager.getConnection(
                "jdbc:mariadb://localhost:3306/studydb", 
                "study", "1111");
        
        stmt = con.createStatement();
        rs = stmt.executeQuery(
                "select" + 
                " m.mno," +
                " m.name," + 
                " m.email," + 
                " m.tel," + 
                " mr.schl," +
                " mr.work" +
                " from p1_stud mr" + 
                " inner join p1_memb m on mr.sno = m.mno" +
                " where m.mno=" + no);
        
        if (rs.next()) {
            Student mgr = new Student();
            mgr.setNo(rs.getInt("mno"));
            mgr.setEmail(rs.getString("email"));
            mgr.setName(rs.getString("name"));
            mgr.setTel(rs.getString("tel"));
            mgr.setSchool(rs.getString("schl"));
            String an=null;
            if(rs.getString("work").equals("Y")){
                an="true";
            }else {
                an="false";
            }
            mgr.setWorking(Boolean.parseBoolean(an));
            
            return mgr;
        }
        return null;
        
    } catch (Exception e) {
        throw new DaoException(e);
        
    } finally {
        try {rs.close();} catch (Exception e) {}
        try {stmt.close();} catch (Exception e) {}
        try {con.close();} catch (Exception e) {}
    }
}

public Student findByEmail(String email) {
    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;
    
    try {
        Class.forName("org.mariadb.jdbc.Driver");
        con = DriverManager.getConnection(
                "jdbc:mariadb://localhost:3306/studydb", 
                "study", "1111");
        
        stmt = con.createStatement();
        rs = stmt.executeQuery(
                "select" + 
                " m.mno," +
                " m.name," + 
                " m.email," + 
                " m.tel," + 
                " mr.schl," +
                " mr.work" +
                " from p1_stud mr" + 
                " inner join p1_memb m on mr.sno = m.mno" +
                " where m.eamil=" + "'+email+'");
        
        if (rs.next()) {
            Student mgr = new Student();
            mgr.setNo(rs.getInt("mno"));
            mgr.setEmail(rs.getString("email"));
            mgr.setName(rs.getString("name"));
            mgr.setTel(rs.getString("tel"));
            mgr.setSchool(rs.getString("schl"));
            String an=null;
            if(rs.getString("work").equals("Y")){
                an="true";
            }else {
                an="false";
            }
            mgr.setWorking(Boolean.parseBoolean(an));
            
            return mgr;
        }
        return null;
        
    } catch (Exception e) {
        throw new DaoException(e);
        
    } finally {
        try {rs.close();} catch (Exception e) {}
        try {stmt.close();} catch (Exception e) {}
        try {con.close();} catch (Exception e) {}
    }
}
    



public int delete(int no) {
    Connection con = null;
    Statement stmt = null;
    
    try {
        Class.forName("org.mariadb.jdbc.Driver");
        con = DriverManager.getConnection(
                "jdbc:mariadb://localhost:3306/studydb", 
                "study", "1111");
        
        con.setAutoCommit(false);
        stmt = con.createStatement();
        
        String sql = "delete from p1_stud where sno=" + no ;
        int count = stmt.executeUpdate(sql);
        
        if (count == 0)
            return 0;
        
        String sql2 = "delete from p1_memb where mno=" + no;
        stmt.executeUpdate(sql2);
        con.commit();
        
        return 1;
        
    } catch (Exception e) {
        throw new DaoException(e);
        
    } finally {
        try {stmt.close();} catch (Exception e) {}
        try {con.close();} catch (Exception e) {}
    }
}

}







