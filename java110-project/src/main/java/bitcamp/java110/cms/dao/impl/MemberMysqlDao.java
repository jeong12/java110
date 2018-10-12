package bitcamp.java110.cms.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
        Connection con = null;
        PreparedStatement stmt = null;
        
        try {
            con = dataSource.getConnection();
            String sql = "insert into p1_memb(name,email,pwd,tel,cdt)"
                    + " values(?,?,?,?,now())";
            stmt = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, member.getName());
            stmt.setString(2, member.getEmail());
            stmt.setString(3, member.getPassword());
            stmt.setString(4, member.getTel());
            
            stmt.executeUpdate();
            
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
        PreparedStatement stmt = null;
        
        try {
            con = dataSource.getConnection();
            
            String sql = "delete from p1_memb where mno=?";
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, no);
            return stmt.executeUpdate();
            
        } catch (Exception e) {
            throw new DaoException(e);
            
        } finally {
            try {stmt.close();} catch (Exception e) {}
            dataSource.returnConnection(con);
        }
    }
}
























