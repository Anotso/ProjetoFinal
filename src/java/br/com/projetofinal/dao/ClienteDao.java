package br.com.projetofinal.dao;

import java.sql.*;
import java.util.*;
import br.com.projetofinal.entidade.Cliente;

public class ClienteDao extends Dao {

    public void cadastrar(Cliente cliente) throws SQLException {
        open();
        int acesso = 2;
        try {
            String sql = "INSERT INTO"
                    + " cliente(cliente, snome, dtnasc, sexo, tipocli, cadfed, cadest, emailcli, senhacli,"
                    + " telcli, celcli, cepcli, endcli, numcli, complcli, refcli, bairrocli, cidcli, estcli, ativo)"
                    + " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, cliente.getCliente());
            stmt.setString(2, cliente.getSnome());
            stmt.setString(3, cliente.getDtnasc());
            stmt.setString(4, cliente.getSexo());
            stmt.setString(5, cliente.getTipocli());
            stmt.setString(6, cliente.getCadfed());
            stmt.setString(7, cliente.getCadest());
            stmt.setString(8, cliente.getEmailcli());
            stmt.setString(9, cliente.getSenhacli());
            stmt.setString(10, cliente.getTelcli());
            stmt.setString(11, cliente.getCelcli());
            stmt.setString(12, cliente.getCepcli());
            stmt.setString(13, cliente.getEndcli());
            stmt.setString(14, cliente.getNumcli());
            stmt.setString(15, cliente.getComplcli());
            stmt.setString(16, cliente.getRefcli());
            stmt.setString(17, cliente.getBairrocli());
            stmt.setString(18, cliente.getCidcli());
            stmt.setString(19, cliente.getEstcli());
            stmt.setBoolean(20, cliente.isAtivo());

            String sqllog = "INSERT INTO login(usuario, pass, tacess) VALUES(?,?,?)";
            stmtlog = con.prepareStatement(sqllog);
            stmtlog.setString(1, cliente.getEmailcli());
            stmtlog.setString(2, cliente.getSenhacli());
            stmtlog.setInt(3, acesso);

            stmt.execute();
            stmtlog.execute();
            close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Cliente> listaCliente(String cpf) throws SQLException {
        open();
        stmt = this.con.prepareStatement("SELECT * FROM cliente WHERE ativo = true AND cadfed like ?");
        stmt.setString(1, cpf + "%");
        Cliente cliente = null;
        rs = stmt.executeQuery();
        List<Cliente> lista = new ArrayList<Cliente>();
        while (rs.next()) {
            cliente = new Cliente(rs.getInt("idcli"),
                    rs.getString("cliente"),
                    rs.getString("snome"),
                    rs.getString("dtnasc"),
                    rs.getString("sexo"),
                    rs.getString("tipocli"),
                    rs.getString("cadfed"),
                    rs.getString("cadest"),
                    rs.getString("emailcli"),
                    rs.getString("senhacli"),
                    rs.getString("telcli"),
                    rs.getString("celcli"),
                    rs.getString("cepcli"),
                    rs.getString("endcli"),
                    rs.getString("numcli"),
                    rs.getString("complcli"),
                    rs.getString("refcli"),
                    rs.getString("bairrocli"),
                    rs.getString("cidcli"),
                    rs.getString("estcli"),
                    rs.getBoolean("ativo")
            );
            lista.add(cliente);
        }
        close();
        return lista;
    }

    public List<Cliente> carregacliente() throws SQLException {
        open();
        String sql = "SELECT * FROM cliente WHERE ativo = true";
        stmt = con.prepareStatement(sql);
        Cliente cliente = null;
        rs = stmt.executeQuery();
        List<Cliente> lista = new ArrayList<Cliente>();
        while (rs.next()) {
            cliente = new Cliente(rs.getInt("idcli"),
                    rs.getString("cliente"),
                    rs.getString("snome"),
                    rs.getString("dtnasc"),
                    rs.getString("sexo"),
                    rs.getString("tipocli"),
                    rs.getString("cadfed"),
                    rs.getString("cadest"),
                    rs.getString("emailcli"),
                    rs.getString("senhacli"),
                    rs.getString("telcli"),
                    rs.getString("celcli"),
                    rs.getString("cepcli"),
                    rs.getString("endcli"),
                    rs.getString("numcli"),
                    rs.getString("complcli"),
                    rs.getString("refcli"),
                    rs.getString("bairrocli"),
                    rs.getString("cidcli"),
                    rs.getString("estcli"),
                    rs.getBoolean("ativo")
            );
            lista.add(cliente);
        }
        close();
        return lista;
    }

    public Cliente logincli(String login, String sen) throws SQLException {
        open();
        String sql = "SELECT emailcli, senhacli FROM cliente WHERE emailcli=? AND senhacli=? AND ativo = true";
        stmt = con.prepareStatement(sql);
        stmt.setString(1, login);
        stmt.setString(2, sen);
        rs = stmt.executeQuery();
        Cliente cliente = null;

        if (rs.next()) {
            cliente = new Cliente(rs.getString("emailcli"), rs.getString("senhacli"));
            System.out.println("Entrou no if do login - ClienteDao");
        }
        close();
        return cliente;
    }

}
