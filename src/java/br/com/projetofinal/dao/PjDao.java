package br.com.projetofinal.dao;

import br.com.projetofinal.entidade.Pj;
import java.sql.*;

public class PjDao extends Dao{
    
    public void cadastrarpj(Pj pj) throws SQLException{
        open();
        int acesso = 2;
        try{
            String sql = "INSERT INTO"+
                " pj(razao, nomepj, cnpjpj, insestpj, emailpj, senhapj, telpj, celpj, ceppj, endpj, numpj, complpj, refpj, bairropj, cidpj, estpj, ativo)"+
                " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, pj.getRazao());
            stmt.setString(2, pj.getNomepj());
            stmt.setString(3, pj.getCnpjpj());
            stmt.setString(4, pj.getInsestpj());
            stmt.setString(5, pj.getEmailpj());
            stmt.setString(6, pj.getSenhapj());
            stmt.setString(7, pj.getTelpj());
            stmt.setString(8, pj.getCelpj());
            stmt.setString(9, pj.getCeppj());
            stmt.setString(10, pj.getEndpj());
            stmt.setString(11, pj.getNumpj());
            stmt.setString(12, pj.getComplpj());
            stmt.setString(13, pj.getRefpj());
            stmt.setString(14, pj.getBairropj());
            stmt.setString(15, pj.getCidpj());
            stmt.setString(16, pj.getEstpj());
            stmt.setBoolean(17, pj.isAtivo());
            
            String sqllog = "INSERT INTO login(usuario, pass, tacess) VALUES(?,?,?)";
            stmtlog = con.prepareStatement(sqllog);
            stmtlog.setString(1, pj.getEmailpj());
            stmtlog.setString(2, pj.getSenhapj());
            stmtlog.setInt(3, acesso);
            
            stmt.execute();
            stmtlog.execute();
            close();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
    
}
