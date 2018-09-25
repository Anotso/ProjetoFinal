package controller;

import dao.FuncionarioDAO;
import java.util.List;
import model.Funcionario;

public class CtrlFuncionario {

    FuncionarioDAO dao = null;

    public void cadastrar(Funcionario funcionario) throws Exception {
        dao = new FuncionarioDAO();
        dao.create(funcionario);
    }
    
    public void alterar(Funcionario funcionario) throws Exception {
        dao = new FuncionarioDAO();
        dao.edit(funcionario);
    }

    public Funcionario login(String email, String senha) throws Exception {
        dao = new FuncionarioDAO();
        return dao.findFuncionario(email, senha);
    }

    public List<Funcionario> pesquisa(String dados) throws Exception {
        dao = new FuncionarioDAO();
        return dao.findFuncionarios(dados);
    }
}
