package br.com.projetofinal.dao;

import java.sql.*;

public class Dao {

    protected Connection con;
    protected PreparedStatement stmt, stmtlog = null;
    protected ResultSet rs = null;

    //Servidor db4free
    /*String URL = "jdbc:mysql:https://www.db4free.net:3306/projeto_final?useUnicode=yes&characterEncoding=UTF-8";
    String USER = "profinal";
    String PASS = "adminroot";*/
    //House
    String URL = "jdbc:mysql://127.0.0.1:3306/projetofinalweb";
    String USER = "root";
    String PASS = "";
    //USBServer
    /*String URL = "jdbc:mysql://127.0.0.1:3307/projetofinalweb";
    String USER = "root";
    String PASS = "usbw";*/

    protected void open() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(URL, USER, PASS);
            //System.out.println("conectado");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void close() {
        try {
            if (con != null) {
                con.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (rs != null) {
                rs.close();
            }

            //System.out.println("Desconectado");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
