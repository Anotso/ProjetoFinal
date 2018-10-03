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
        stmt=this.con.prepareStatement("SELECT * FROM funcionario WHERE cpffunc = ?");
        stmt.setString(1, cpf);
        Funcionario funcionario = null;
        rs = stmt.executeQuery();
        List<Funcionario> listafunc2 = new ArrayList<Funcionario>();
        while(rs.next()){
            funcionario = new Funcionario(rs.getInt("idfuncionario"),
                rs.getString("nomefunc"),
                rs.getString("emailfunc"),
                rs.getString("senhafunc"),
                rs.getString("telfunc"),
                rs.getString("celfunc"),
                rs.getString("cpffunc"),
                rs.getString("funcaofunc"),
                rs.getString("cepfunc"),
                rs.getString("ruafunc"),
                rs.getString("numfunc"),
                rs.getString("bairrofunc"),
                rs.getString("cidadefunc"),
                rs.getString("estadofunc"),
                rs.getString("complfunc"),
                rs.getBoolean("ativo")
            );
            listafunc2.add(funcionario);
        }
        close();
        return listafunc2;
    }

    public List<Funcionario> carregafuncionario() throws SQLException{
        open();
        String sql = "SELECT * FROM funcionario";
        stmt = con.prepareStatement(sql);
        Funcionario funcionario = null;
        rs = stmt.executeQuery();
        List<Funcionario> listafunc1 = new ArrayList<Funcionario>();
        while(rs.next()){
            funcionario = new Funcionario(rs.getInt("idfuncionario"),
                rs.getString("nomefunc"),
                rs.getString("emailfunc"),
                rs.getString("senhafunc"),
                rs.getString("telfunc"),
                rs.getString("celfunc"),
                rs.getString("cpffunc"),
                rs.getString("funcaofunc"),
                rs.getString("cepfunc"),
                rs.getString("ruafunc"),
                rs.getString("numfunc"),
                rs.getString("bairrofunc"),
                rs.getString("cidadefunc"),
                rs.getString("estadofunc"),
                rs.getString("complfunc"),
                rs.getBoolean("ativo")
            );
            listafunc1.add(funcionario);
        }
        close();
        return listafunc1;
    }
    
}
