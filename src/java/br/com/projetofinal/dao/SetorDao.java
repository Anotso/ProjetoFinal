package br.com.projetofinal.dao;

import br.com.projetofinal.entidade.Setor;
import java.sql.*;
import java.util.*;

public class SetorDao  extends Dao{

    public void cadastrarsetor(Setor setor) throws SQLException{
        open();
        try{
            String sql = "INSERT INTO setor(nomesetor) VALUES(?)";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, setor.getSetor());
            stmt.execute();
            close();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    public List<Setor> buscarsetor() throws SQLException{
        open();
        String sql = "SELECT * FROM setor";
        stmt = con.prepareStatement(sql);
        Setor setor = null;
        rs = stmt.executeQuery();
        List<Setor> lista = new ArrayList<Setor>();
        while(rs.next()){
            setor = new Setor(rs.getInt("idsetor"),rs.getString("nomesetor"));
            lista.add(setor);
        }
        close();
        return lista;
    }
    
}
