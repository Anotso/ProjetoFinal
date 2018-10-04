package br.com.projetofinal.dao;

import br.com.projetofinal.entidade.Funcionario;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDao extends Dao{

    public void cadastrarfuncionario(Funcionario funcionario) throws SQLException{
        open();
        int acesso = 1;
        try{
            String sql = "INSERT INTO"+
                " funcionario(nomefunc, emailfunc, senhafunc, telfunc, celfunc, cpffunc, funcaofun, cepfunc, ruafunc, numfunc, bairrofunc, cidadefunc, estadofunc, complfunc, ativo)"+
                " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, funcionario.getFuncionario());
            stmt.setString(2, funcionario.getEmailfunc());
            stmt.setString(3, funcionario.getSenhafunc());
            stmt.setString(4, funcionario.getTelfunc());
            stmt.setString(5, funcionario.getCelfunc());
            stmt.setString(6, funcionario.getCpffunc());
            stmt.setString(7, funcionario.getFuncaofunc());
            stmt.setString(8, funcionario.getCepfunc());
            stmt.setString(9, funcionario.getEndfunc());
            stmt.setString(10, funcionario.getNumfunc());
            stmt.setString(11, funcionario.getBairrofunc());
            stmt.setString(12, funcionario.getCidfunc());
            stmt.setString(13, funcionario.getEstfunc());
            stmt.setString(14, funcionario.getComplfunc());
            stmt.setBoolean(15, funcionario.isAtivo());
            
            String sqllog = "INSERT INTO login(usuario, pass, tacess) VALUES(?,?,?)";
            stmtlog = con.prepareStatement(sqllog);
            stmtlog.setString(1, funcionario.getEmailfunc());
            stmtlog.setString(2, funcionario.getSenhafunc());
            stmtlog.setInt(3, acesso);
            
            stmt.execute();
            stmtlog.execute();
            close();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    public List<Funcionario> listaFuncionario(String cpf) throws SQLException{
        open();
        stmt=this.con.prepareStatement("SELECT * FROM funcionario WHERE cpffunc like ?");
        stmt.setString(1, cpf+"%");
        Funcionario funcionario = null;
        rs = stmt.executeQuery();
        List<Funcionario> lista = new ArrayList<Funcionario>();
        while(rs.next()){
            funcionario = new Funcionario(rs.getInt("idfunc"),
                rs.getString("nomefunc"),
                rs.getString("emailfunc"),
                rs.getString("senhafunc"),
                rs.getString("telfunc"),
                rs.getString("celfunc"),
                rs.getString("cpffunc"),
                rs.getString("funcaofun"),
                rs.getString("cepfunc"),
                rs.getString("ruafunc"),
                rs.getString("numfunc"),
                rs.getString("bairrofunc"),
                rs.getString("cidadefunc"),
                rs.getString("estadofunc"),
                rs.getString("complfunc"),
                rs.getBoolean("ativo")
            );
            lista.add(funcionario);
        }
        close();
        return lista;
    }

    public List<Funcionario> carregafuncionario() throws SQLException{
        open();
        String sql = "SELECT * FROM funcionario";
        stmt = con.prepareStatement(sql);
        Funcionario funcionario = null;
        rs = stmt.executeQuery();
        List<Funcionario> lista = new ArrayList<Funcionario>();
        while(rs.next()){
            funcionario = new Funcionario(rs.getInt("idfunc"),
                rs.getString("nomefunc"),
                rs.getString("emailfunc"),
                rs.getString("senhafunc"),
                rs.getString("telfunc"),
                rs.getString("celfunc"),
                rs.getString("cpffunc"),
                rs.getString("funcaofun"),
                rs.getString("cepfunc"),
                rs.getString("ruafunc"),
                rs.getString("numfunc"),
                rs.getString("bairrofunc"),
                rs.getString("cidadefunc"),
                rs.getString("estadofunc"),
                rs.getString("complfunc"),
                rs.getBoolean("ativo")
            );
            lista.add(funcionario);
        }
        close();
        return lista;
    }

    public List<Funcionario> editaFuncionario(String id) throws SQLException{
        open();
        stmt=this.con.prepareStatement("SELECT * FROM funcionario WHERE cpffunc like ?");
        stmt.setString(1, id+"%");
        Funcionario funcionario = null;
        rs = stmt.executeQuery();
        List<Funcionario> lista = new ArrayList<Funcionario>();
        while(rs.next()){
            funcionario = new Funcionario(rs.getInt("idfunc"),
                rs.getString("nomefunc"),
                rs.getString("emailfunc"),
                rs.getString("senhafunc"),
                rs.getString("telfunc"),
                rs.getString("celfunc"),
                rs.getString("cpffunc"),
                rs.getString("funcaofun"),
                rs.getString("cepfunc"),
                rs.getString("ruafunc"),
                rs.getString("numfunc"),
                rs.getString("bairrofunc"),
                rs.getString("cidadefunc"),
                rs.getString("estadofunc"),
                rs.getString("complfunc"),
                rs.getBoolean("ativo")
            );
            lista.add(funcionario);
        }
        close();
        return lista;
    }

    public void editarrfuncionario(Funcionario funcionario)  throws SQLException{
        open();
        //try{
            String sql = "UPDATE funcionario SET nomefunc = ?,"+
                " emailfunc = ?,"+
                " telfunc = ?,"+
                " celfunc = ?,"+
                " cpffunc = ?,"+
                " funcaofun = ?,"+
                " cepfunc = ?,"+
                " ruafunc = ?,"+
                " numfunc = ?,"+
                " bairrofunc = ?,"+
                " cidadefunc = ?,"+
                " estadofunc = ?,"+
                " complfunc = ?,"+
                " ativo = ? WHERE idfunc = ?";
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
            stmt.setInt(15, funcionario.getIdfuncionario());

            stmt.executeUpdate();
            close();
        //}catch(SQLException e){
            //throw new RuntimeException(e);
        //}
    }
    
}
