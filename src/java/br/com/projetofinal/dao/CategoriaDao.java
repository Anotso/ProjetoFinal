package br.com.projetofinal.dao;

import br.com.projetofinal.entidade.Categoria;
import java.sql.*;
import java.util.*;

public class CategoriaDao extends Dao{

    public void cadastrarcategoria(Categoria categoria) throws SQLException{
        open();
        try{
            String sql = "INSERT INTO categoria(nomecategoria, setor) VALUES(?,?)";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, categoria.getCategoria());
            stmt.setString(2, categoria.getSetor());
            stmt.execute();
            close();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    public List<Categoria> buscarcategoria() throws SQLException{
        open();
        String sql = "SELECT * FROM categoria";
        stmt = con.prepareStatement(sql);
        Categoria categoria = null;
        rs = stmt.executeQuery();
        List<Categoria> listacat1 = new ArrayList<Categoria>();
        while(rs.next()){
            categoria = new Categoria(rs.getInt("idcategoria"), rs.getString("nomecategoria"), rs.getString("setor"));
            listacat1.add(categoria);
        }
        close();
        return listacat1;
    }
    
}
