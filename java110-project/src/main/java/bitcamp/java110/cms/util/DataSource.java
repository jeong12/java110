package bitcamp.java110.cms.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;

public class DataSource {

    String url;
    String username;
    String password;
    ArrayList<Connection> connections = new ArrayList<>();
    
    ThreadLocal<Connection> local = new ThreadLocal<>();
    
    public DataSource(String driver, String url, String username, String password) throws Exception {
        Class.forName(driver);
        this.url=url;
        this.username=username;
        this.password=password;

    }

    public Connection getConnection() throws Exception{
        Connection con = local.get();
        if(con != null) {
            return con;
        }
        else {
            return getConnection(false);
        }
    }
    

    public Connection getConnection(boolean useTransaction) throws Exception {

        Connection con = null;
        while(connections.size() > 0) {
            con = connections.remove(0);
            if(!con.isClosed() && con.isValid(3)) {
                System.out.println("기존 커넥션 사용!");
                break;                
            }
            con=null;
        }
        if(con == null) {
            System.out.println("새 커넥션 사용!");
            con = DriverManager.getConnection(url, username, password);
        }
        
        if(useTransaction) {
            con.setAutoCommit(false);
            local.set(con);
        }else {
            con.setAutoCommit(true);
        }
        return con;
    }


    public void returnConnection(Connection con) {
        returnConnection(con,false);
        
    }

    public void returnConnection(Connection con, boolean useTransaction) {
        
        if(useTransaction) {
            local.remove();
        }
        if(local.get() == null) {
         //트랜잭션으로 사용하는 커넥션이 아닌 경우에만 커넥션풀에 반납한다.
            connections.add(con);
        }
    }
    
    /* 3가지 경우의 수
     * 1) DAO - 트랜잭션이 아닌 경우 => local이 null 이니까 반납됨
     * 2) DAO - 트랜잭션인 경우(아직 끝나지 않음) => null이 아니니까 반납되지 않음
     * 3) TM - 보내는 경우(true로) => local이 비워지고, 그럼 null이 되니까 반납 됨.
     */
    
    
    


}
