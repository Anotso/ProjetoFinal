package br.com.projetofinal.dao;

import br.com.projetofinal.entidade.Funcao;
import java.sql.*;
import java.util.*;

public class FuncaoDao extends Dao{
    
    public void cadastrarfuncao(Funcao funcao)throws SQLException{
        open();
        try{
            String sql = "INSERT INTO funcao(nomefuncao) VALUES(?)";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, funcao.getFuncao());
            stmt.execute();
            close();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
    
    /*public List<Funcao> buscarfuncao(String funcao) throws SQLException{
        open();
        String sql = "SELECT * FROM funcao";
        stmt = con.prepareStatement(sql);
        Funcao funcao = null;
        rs = stmt.executeQuery()
    }*/

    public List<Funcao> buscarfuncao() throws SQLException {
        open();
        String sql = "SELECT * FROM funcao";
        stmt = con.prepareStatement(sql);
        Funcao funcao = null;
        rs = stmt.executeQuery();
        List<Funcao> lista = new ArrayList<Funcao>();
        if(rs.next()){
            funcao = new Funcao(rs.getInt("idfuncao"),rs.getString("nomefuncao"));
            lista.add(funcao);
        }
        close();
        return lista;
    }
    
}
