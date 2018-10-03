package br.com.projetofinal.dao;

    import java.sql.*;
    import java.util.*;
    import br.com.projetofinal.entidade.Fornecedor;

public class FornecedorDao extends Dao{
    
    public void cadastrarfornecedor(Fornecedor fornecedor) throws SQLException{
        open();
        try{
            String sql = "INSERT INTO"+
                " fornecedor(nomefor, emailfor, sitefor, telfor, cnpjfor, cepfor, ruafor, numfor, complfor, bairrofor, cidadefor, estadofor)" +
                " VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
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

    public List<Fornecedor> buscarfornecedor(String dado) throws SQLException{
        open();
        String sql = "SELECT * FROM fornecedor WHERE cnpjfor = ? OR nomefor = ?";
        stmt = con.prepareStatement(sql);
        stmt.setString(1, dado);
        stmt.setString(2, dado);

        Fornecedor fornecedor = null;
        rs = stmt.executeQuery();
        List<Fornecedor> lista = new ArrayList<Fornecedor>();
        if(rs.next()){
            fornecedor = new Fornecedor(rs.getInt("idfor"),
                rs.getString("nomefor"),
                rs.getString("cnpjfor"),
                rs.getString("sitefor"),
                rs.getString("emailfor"),
                rs.getString("telfor"),
                rs.getString("cepfor"),
                rs.getString("ruafor"),
                rs.getString("numfor"),
                rs.getString("complfor"),
                rs.getString("bairrofor"),
                rs.getString("cidadefor"),
                rs.getString("estadofor"));
        }
        close();
        return lista;
    }

    public List<Fornecedor> loadfornecedor() throws SQLException {
        open();
        String sql = "SELECT * FROM fornecedor";
        stmt = con.prepareStatement(sql);
        Fornecedor fornecedor = null;
        rs = stmt.executeQuery();
        List<Fornecedor> listafor = new ArrayList<Fornecedor>();
        while(rs.next()){
            fornecedor = new Fornecedor(rs.getInt("idfor"),
                rs.getString("nomefor"),
                rs.getString("cnpjfor"),
                rs.getString("sitefor"),
                rs.getString("emailfor"),
                rs.getString("telfor"),
                rs.getString("cepfor"),
                rs.getString("ruafor"),
                rs.getString("numfor"),
                rs.getString("complfor"),
                rs.getString("bairrofor"),
                rs.getString("cidadefor"),
                rs.getString("estadofor"));
            listafor.add(fornecedor);
        }
        close();
        return listafor;
    }
    
}
