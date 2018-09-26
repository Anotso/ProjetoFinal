package br.com.projetofinal.dao;

    import java.sql.*;

public class Dao {
    
    protected Connection con;
    protected PreparedStatement stmt = null;
    protected ResultSet rs = null;
    
    /*String URL = "jdbc:mysql:https://www.db4free.net:3306/projeto_final";
    String USER = "profinal";
    String PASS = "adminroot";*/
    String URL = "jdbc:mysql://127.0.0.1:3306/projetofinalweb";
    String USER = "root";
    String PASS = "";
    
    protected void open(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("conectado");
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
            
              System.out.println("Desconectado");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
