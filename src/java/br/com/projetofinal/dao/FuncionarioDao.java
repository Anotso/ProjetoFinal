package br.com.projetofinal.dao;

import br.com.projetofinal.entidade.Funcionario;
import java.sql.*;

public class FuncionarioDao extends Dao{

    public void cadastrarfuncionario(Funcionario funcionario) throws SQLException{
        open();
        try{
            String sql = "INSERT INTO"+
                " funcionario(nomefunc, emailfunc, telfunc, celfunc, cpffunc, funcaofun, cepfunc, ruafunc, numfunc, bairrofunc, cidadefunc, estadofunc, complfunc, ativo)"+
                " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, funcionario.getFuncionario());
            stmt.setString(2, funcionario.getEmailfunc());
            stmt.setString(3, funcionario.getTelfunc());
            stmt.setString(4, funcionario.getCelfunc());
            stmt.setString(5, funcionario.getCpffunc());
            stmt.setString(6, funcionario.getFuncaofunc());
            stmt.setString(7, funcionario.getCepfunc());
            stmt.setString(8, funcionario.getEndfunc());
            stmt.setString(9, funcionario.getNumfunc());
            stmt.setString(10, funcionario.getBairrofunc());
            stmt.setString(11, funcionario.getCidfunc());
            stmt.setString(12, funcionario.getEstfunc());
            stmt.setString(13, funcionario.getComplfunc());
            stmt.setBoolean(14, funcionario.isAtivo());
            stmt.executeQuery();
            close();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
    
}
