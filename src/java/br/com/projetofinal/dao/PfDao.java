package br.com.projetofinal.dao;

import br.com.projetofinal.entidade.Pf;
import java.sql.*;

public class PfDao extends Dao{
    
    public void cadastrarpf(Pf pf) throws SQLException{
        open();
        int acesso = 2;
        try{
            String sql = "INSERT INTO"+
                " pf(pf, snome, dtnasc, sexo, cpfpf, rgpf, emailpf, senhapf, telpf, celpf, ceppf, endpf, numpf, complpf, refpf, bairropf, cidpf, estpf, ativo)"+
                " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, pf.getPf());
            stmt.setString(2, pf.getSnome());
            stmt.setString(3, pf.getDtnasc());
            stmt.setString(4, pf.getSexo());
            stmt.setString(5, pf.getCpfpf());
            stmt.setString(6, pf.getRgpf());
            stmt.setString(7, pf.getEmailpf());
            stmt.setString(8, pf.getSenhapf());
            stmt.setString(9, pf.getTelpf());
            stmt.setString(10, pf.getCelpf());
            stmt.setString(11, pf.getCeppf());
            stmt.setString(12, pf.getEndpf());
            stmt.setString(13, pf.getNumpf());
            stmt.setString(14, pf.getComplpf());
            stmt.setString(15, pf.getRefpf());
            stmt.setString(16, pf.getBairropf());
            stmt.setString(17, pf.getCidpf());
            stmt.setString(18, pf.getEstpf());
            stmt.setBoolean(19, pf.isAtivo());
            
            String sqllog = "INSERT INTO login(usuario, pass, tacess) VALUES(?,?,?)";
            stmtlog = con.prepareStatement(sqllog);
            stmtlog.setString(1, pf.getEmailpf());
            stmtlog.setString(2, pf.getSenhapf());
            stmtlog.setInt(3, acesso);
            
            stmt.execute();
            stmtlog.execute();
            close();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
    
}
