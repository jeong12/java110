package bitcamp.java110.cms.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bitcamp.java110.cms.dao.DaoException;
import bitcamp.java110.cms.dao.ManagerDao;
import bitcamp.java110.cms.domain.Manager;
import bitcamp.java110.cms.util.DataSource;

public class ManagerMysqlDao implements ManagerDao {
    
    DataSource dataSource;
    
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public int insert(Manager manager) throws DaoException {
        Statement stmt = null;
        
        Connection con = null;
        
        try {
            con = dataSource.getConnection();

            con.setAutoCommit(false);

            stmt = con.createStatement();
            String sql = "insert into p1_memb(name,email,pwd,tel,cdt)"
                    + " values('" + manager.getName()
                    + "','" + manager.getEmail()
                    + "',password('" + manager.getPassword()
                    + "'),'" + manager.getTel()
                    + "',now())";
            
            stmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            
            ResultSet autogeneratedKeys = stmt.getGeneratedKeys();
            autogeneratedKeys.next();
            int memberNo = autogeneratedKeys.getInt(1);
            autogeneratedKeys.close();
            
            String sql2 = "insert into p1_mgr(mrno,posi)"
                    + " values(" + memberNo
                    + ",'" + manager.getPosition()
                    + "')";
            stmt.executeUpdate(sql2);
            
            con.commit();
            return 1;
            
        } catch (Exception e) {
            try {con.rollback();} catch (Exception e2) {}
            throw new DaoException(e);
            
        } finally {
            try {stmt.close();} catch (Exception e) {}
        }
    }
    
    public List<Manager> findAll() throws DaoException {
        
        ArrayList<Manager> list = new ArrayList<>();
        
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        try {
            con = dataSource.getConnection();
            
            stmt = con.createStatement();
            
            rs = stmt.executeQuery(
                    "select" + 
                    " m.mno," +
                    " m.name," + 
                    " m.email," + 
                    " mr.posi" + 
                    " from p1_mgr mr" + 
                    " inner join p1_memb m on mr.mrno = m.mno");
            
            while (rs.next()) {
                Manager mgr = new Manager();
                mgr.setNo(rs.getInt("mno"));
                mgr.setEmail(rs.getString("email"));
                mgr.setName(rs.getString("name"));
                mgr.setPosition(rs.getString("posi"));
                
                list.add(mgr);
            }
        } catch (Exception e) {
            throw new DaoException(e);
            
        } finally {
            try {rs.close();} catch (Exception e) {}
            try {stmt.close();} catch (Exception e) {}
        }
        return list;
    }
    
    public Manager findByEmail(String email) throws DaoException {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        try {
            con = dataSource.getConnection();
            
            stmt = con.createStatement();
            rs = stmt.executeQuery(
                    "select" + 
                    " m.mno," +
                    " m.name," + 
                    " m.email," + 
                    " m.tel," + 
                    " mr.posi" + 
                    " from p1_mgr mr" + 
                    " inner join p1_memb m on mr.mrno = m.mno" +
                    " where m.email='" + email + "'");
            
            if (rs.next()) {
                Manager mgr = new Manager();
                mgr.setNo(rs.getInt("mno"));
                mgr.setEmail(rs.getString("email"));
                mgr.setName(rs.getString("name"));
                mgr.setTel(rs.getString("tel"));
                mgr.setPosition(rs.getString("posi"));
                
                return mgr;
            }
            return null;
            
        } catch (Exception e) {
            throw new DaoException(e);
            
        } finally {
            try {rs.close();} catch (Exception e) {}
            try {stmt.close();} catch (Exception e) {}
        }
    }
    
    public Manager findByNo(int no) throws DaoException {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        try {
            con = dataSource.getConnection();
            
            stmt = con.createStatement();
            rs = stmt.executeQuery(
                    "select" + 
                    " m.mno," +
                    " m.name," + 
                    " m.email," + 
                    " m.tel," + 
                    " mr.posi" + 
                    " from p1_mgr mr" + 
                    " inner join p1_memb m on mr.mrno = m.mno" +
                    " where m.mno=" + no);
            
            if (rs.next()) {
                Manager mgr = new Manager();
                mgr.setNo(rs.getInt("mno"));
                mgr.setEmail(rs.getString("email"));
                mgr.setName(rs.getString("name"));
                mgr.setTel(rs.getString("tel"));
                mgr.setPosition(rs.getString("posi"));
                
                return mgr;
            }
            return null;
            
        } catch (Exception e) {
            throw new DaoException(e);
            
        } finally {
            try {rs.close();} catch (Exception e) {}
            try {stmt.close();} catch (Exception e) {}
        }
    }
    
    public int delete(int no) throws DaoException {
        Connection con = null;
        Statement stmt = null;
        
        try {
            con = dataSource.getConnection();
            
            con.setAutoCommit(false);
            stmt = con.createStatement();
            
            String sql = "delete from p1_mgr where mrno=" + no ;
            int count = stmt.executeUpdate(sql);
            
            if (count == 0)
                return 0;
            
            String sql2 = "delete from p1_memb where mno=" + no;
            stmt.executeUpdate(sql2);
            con.commit();
            
            return 1;
            
        } catch (Exception e) {
            try {con.rollback();} catch (Exception e2) {}
            throw new DaoException(e);
            
        } finally {
            try {stmt.close();} catch (Exception e) {}
        }
    }
    
    @Override
    public Manager findByEmailPassword(String email, String password) throws DaoException {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        try {
            con = dataSource.getConnection();
            
            stmt = con.createStatement();
            rs = stmt.executeQuery(
                    "select" + 
                    " m.mno," +
                    " m.name," + 
                    " m.email," + 
                    " m.tel," + 
                    " mr.posi" + 
                    " from p1_mgr mr" + 
                    " inner join p1_memb m on mr.mrno = m.mno" +
                    " where m.email='" + email + 
                    "' and m.pwd=password('"+password+
                    "')");
            
            if (rs.next()) {
                Manager mgr = new Manager();
                mgr.setNo(rs.getInt("mno"));
                mgr.setEmail(rs.getString("email"));
                mgr.setName(rs.getString("name"));
                mgr.setTel(rs.getString("tel"));
                mgr.setPosition(rs.getString("posi"));
                
                return mgr;
            }
            return null;
            
        } catch (Exception e) {
            throw new DaoException(e);
            
        } finally {
            try {rs.close();} catch (Exception e) {}
            try {stmt.close();} catch (Exception e) {}
        }
    }
}









