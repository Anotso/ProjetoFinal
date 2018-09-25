package controller;

import dao.PedidoDAO;
import java.util.List;
import model.Pedido;

public class CtrlPedido {

    PedidoDAO dao = null;

    public void cadastrar(Pedido pedido) throws Exception {
        dao = new PedidoDAO();
        dao.create(pedido);
    }

    public List<Pedido> pesquisar(String dados) throws Exception {
        dao = new PedidoDAO();
        return dao.findPedidos(dados);
    }

    public Pedido buscaID(long id) throws Exception {
        dao = new PedidoDAO();
        return dao.findPedido(id);
    }

}
