package br.com.projetofinal.dao;

    import java.sql.*;
    import java.util.*;
    import br.com.projetofinal.entidade.Fornecedor;

public class FornecedorDao extends Dao{
    
    public void cadastrarfornecedor(Fornecedor fornecedor) throws SQLException{
        open();
        try{
            String sql = "INSERT INTO"+
                " fornecedor(nomefor, emailfor, sitefor, telfor, cnpjfor, cepfor, ruafor, numfor, complfor, bairrofor, cidadefor, estadofor)"+
                "VALUES(?,?,?,?,?,?,?,?,?,?,?,?);";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, fornecedor.getFornecedor());
            stmt.setString(2, fornecedor.getEmailfor());
            stmt.setString(3, fornecedor.getSitefor());
            stmt.setString(4, fornecedor.getTelfor());
            stmt.setString(5, fornecedor.getCnpj());
            stmt.setString(6, fornecedor.getCepfor());
            stmt.setString(7, fornecedor.getEndfor());
            stmt.setString(8, fornecedor.getNumfor());
            stmt.setString(9, fornecedor.getComplfor());
            stmt.setString(10, fornecedor.getBairrofor());
            stmt.setString(11, fornecedor.getCidfor());
            stmt.setString(12, fornecedor.getEstfor());
            stmt.execute();
            close();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
    
}
