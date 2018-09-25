package br.com.projetofinal.dao;

    import java.sql.*;

public class Dao {
    
    protected Connection con;
    protected PreparedStatement stmt;
    protected ResultSet rs;
    
    String URL = "jdbc:mysql:https://www.db4free.net:3306/projeto_final";
    String USER = "profinal";
    String PASS = "adminroot";
    
    protected void open(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(URL, USER, PASS);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    protected void close(){
        try{
            if(con != null){
                con.close();
            }
            if(stmt != null){
                stmt.close();
            }
            if(rs != null){
                rs.close();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
