package controller;

import dao.ProdutoDAO;
import java.util.List;
import model.Produto;

public class CtrlProduto {

    ProdutoDAO dao = null;

    public void cadastrar(Produto produto) throws Exception {
        dao = new ProdutoDAO();
        dao.create(produto);
    }

    public List<Produto> pesquisar(String dados) throws Exception {
        dao = new ProdutoDAO();
        return dao.findProdutos(dados);
    }

    public Produto buscaID(long id) throws Exception {
        dao = new ProdutoDAO();
        return dao.findProduto(id);
    }

}
