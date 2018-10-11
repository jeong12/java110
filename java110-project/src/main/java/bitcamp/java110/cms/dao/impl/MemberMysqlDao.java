package bitcamp.java110.cms.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import bitcamp.java110.cms.dao.DaoException;
import bitcamp.java110.cms.dao.MemberDao;
import bitcamp.java110.cms.domain.Member;
import bitcamp.java110.cms.util.DataSource;

public class MemberMysqlDao implements MemberDao {
    
    DataSource dataSource;
    
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public int insert(Member member) throws DaoException {
        Statement stmt = null;
        
        Connection con = null;
        
        try {
            con = dataSource.getConnection();
            stmt = con.createStatement();
            String sql = "insert into p1_memb(name,email,pwd,tel,cdt)"
                    + " values('" + member.getName()
                    + "','" + member.getEmail()
                    + "',password('" + member.getPassword()
                    + "'),'" + member.getTel()
                    + "',now())";
            
            stmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            
            ResultSet autogeneratedKeys = stmt.getGeneratedKeys();
            autogeneratedKeys.next();
            int no = autogeneratedKeys.getInt(1);
            autogeneratedKeys.close();
            
            member.setNo(no);
          
            return 1;
            
        } catch (Exception e) {
            throw new DaoException(e);
            
        } finally {
            try {stmt.close();} catch (Exception e) {}
            dataSource.returnConnection(con);
        }
    }
    
  
    @Override
    public int delete(int no) throws DaoException {
        Connection con = null;
        Statement stmt = null;
        
        try {
            con = dataSource.getConnection();
            
            stmt = con.createStatement();
            
            String sql = "delete from p1_memb where mno=" + no;
            return stmt.executeUpdate(sql);

            
        } catch (Exception e) {
            throw new DaoException(e);
            
        } finally {
            try {stmt.close();} catch (Exception e) {}
            dataSource.returnConnection(con);
        }
    }
   
}










