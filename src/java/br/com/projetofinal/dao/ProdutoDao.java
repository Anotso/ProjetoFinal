package br.com.projetofinal.dao;

import br.com.projetofinal.entidade.Fornecedor;
import br.com.projetofinal.entidade.Produto;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

    public List<Produto> todosprodutos() throws SQLException {
        open();
        String sql = "SELECT * FROM produto";
        stmt = con.prepareStatement(sql);
        Produto produto = null;
        rs = stmt.executeQuery();
        List<Produto> lista = new ArrayList<Produto>();
        while (rs.next()) {
            produto = new Produto(rs.getInt("idprod"),
                    rs.getString("nomeprod"),
                    rs.getString("forprod"),
                    rs.getString("catprod"),
                    rs.getString("descprod"),
                    rs.getFloat("compraprod"),
                    rs.getFloat("vendaprod"),
                    rs.getInt("qtdprod"),
                    rs.getString("foto1prod"),
                    rs.getString("foto2prod"),
                    rs.getString("foto3prod"),
                    rs.getString("foto4prod"),
                    rs.getString("foto5prod")
            );
            lista.add(produto);
        }
        close();
        return lista;
    }

    public List<Produto> listaProduto(String dado) throws SQLException{
        open();
        stmt = this.con.prepareStatement("SELECT * FROM produto WHERE idprod like ? OR nomeprod like ?");
        stmt.setString(1, dado + "%");
        stmt.setString(2, "%"+ dado + "%");
        Produto produto = null;
        rs = stmt.executeQuery();
        List<Produto> lista = new ArrayList<Produto>();
        while (rs.next()) {
            produto = new Produto(rs.getInt("idprod"),
                    rs.getString("nomeprod"),
                    rs.getString("forprod"),
                    rs.getString("catprod"),
                    rs.getString("descprod"),
                    rs.getFloat("compraprod"),
                    rs.getFloat("vendaprod"),
                    rs.getInt("qtdprod"),
                    rs.getString("foto1prod"),
                    rs.getString("foto2prod"),
                    rs.getString("foto3prod"),
                    rs.getString("foto4prod"),
                    rs.getString("foto5prod")
            );
            lista.add(produto);
        }
        close();
        return lista;
    }

    public List<Produto> carregaProduto(int id) throws SQLException{
        open();
        stmt = this.con.prepareStatement("SELECT * FROM produto WHERE idprod = ?");
        stmt.setInt(1, id);
        Produto produto = null;
        rs = stmt.executeQuery();
        List<Produto> lista = new ArrayList<Produto>();
        while (rs.next()) {
            produto = new Produto(rs.getInt("idprod"),
                    rs.getString("nomeprod"),
                    rs.getString("forprod"),
                    rs.getString("catprod"),
                    rs.getString("descprod"),
                    rs.getFloat("compraprod"),
                    rs.getFloat("vendaprod"),
                    rs.getInt("qtdprod"),
                    rs.getString("foto1prod"),
                    rs.getString("foto2prod"),
                    rs.getString("foto3prod"),
                    rs.getString("foto4prod"),
                    rs.getString("foto5prod")
            );
            lista.add(produto);
        }
        close();
        return lista;
    }
    
}
