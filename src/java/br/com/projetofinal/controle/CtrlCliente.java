package controller;

import dao.ClienteDAO;
import dao.EnderecoDAO;
import java.util.List;
import model.Cliente;

public class CtrlCliente {

    ClienteDAO dao = null;
    EnderecoDAO daoEnd = null;

    public void cadastrar(Cliente cliente) throws Exception {
        //Cliente
        dao = new ClienteDAO();
        dao.cadastrarfornecedor(cliente);
    }

    public Cliente login(String email, String senha) throws Exception {
        dao = new ClienteDAO();
        return dao.findCliente(email, senha);
    }

    public List<Cliente> pesquisa(String dados) throws Exception {
        dao = new ClienteDAO();
        return dao.findClientes(dados);
    }

    public Cliente buscaID(long id) throws Exception {
        dao = new ClienteDAO();
        return dao.findCliente(id);
    }

    public void alterar(Cliente cliente) throws Exception {
        //Endereço
        daoEnd = new EnderecoDAO();
        daoEnd.edit(cliente.getEndereco());
        //Cliente
        dao = new ClienteDAO();
        dao.edit(cliente);
    }

    public void remover(Long id) throws Exception {
        dao = new ClienteDAO();
        //dao.destroy(id);
        Cliente cliente = dao.findCliente(id);
        if (cliente.isAtivo()) {
            cliente.setAtivo(false);
            dao.edit(cliente);
        }
    }
}
