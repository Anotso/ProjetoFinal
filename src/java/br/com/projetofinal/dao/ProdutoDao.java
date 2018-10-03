package br.com.projetofinal.dao;

import br.com.projetofinal.entidade.Produto;
import java.sql.*;

public class ProdutoDao extends Dao{

    public void cadastrarproduto(Produto produto) {
        open();
        try{
            String sql = "INSERT INTO"+
            " produto(nomeprod,forprod,catprod,descprod,compraprod,vendaprod,qtdprod,foto1prod,foto2prod,foto3prod,foto4prod,foto5prod)"
            +"VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, produto.getProduto());
            stmt.setString(2, produto.getFornecedor());
            stmt.setString(3, produto.getCategoria());
            stmt.setString(4, produto.getDescricao());
            stmt.setFloat(5, produto.getCompra());
            stmt.setFloat(6, produto.getVenda());
            stmt.setInt(7, produto.getQtd());
            stmt.setString(8, produto.getFoto1());
            stmt.setString(9, produto.getFoto2());
            stmt.setString(10, produto.getFoto3());
            stmt.setString(11, produto.getFoto4());
            stmt.setString(12, produto.getFoto5());
            stmt.execute();
            close();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
    
}
