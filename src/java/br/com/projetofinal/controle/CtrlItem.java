package controller;

import dao.ItemDAO;
import java.util.List;
import model.Item;

public class CtrlItem {

    ItemDAO dao = null;

    public void cadastrar(Item item) throws Exception {
        dao = new ItemDAO();
        dao.create(item);
    }

    public List<Item> pesquisar(String dados) throws Exception {
        dao = new ItemDAO();
        return dao.findItems(dados);
    }

    public Item buscaID(long id) throws Exception {
        dao = new ItemDAO();
        return dao.findItem(id);
    }

}
