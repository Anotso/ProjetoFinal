package br.com.projetofinal.dao;

import br.com.projetofinal.entidade.Categoria;
import java.sql.*;

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
    
}
