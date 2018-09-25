package br.com.projetofinal.logica;

import controller.CtrlCliente;
import controller.CtrlItem;
import controller.CtrlPedido;
import controller.CtrlProduto;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Cliente;
import model.Item;
import model.Pedido;
import model.Produto;

@MultipartConfig
public class Carrinho implements Logica {

    public String executa(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        String pagina = "index.jsp";
        String acao = request.getParameter("acao");

        List<Item> itens = null;
        Cliente cliente = null;
        double total = 0;
        double frete = 0;

        HttpSession carrinho = request.getSession(false);
        HttpSession user = request.getSession(false);

        CtrlProduto ctrlProduto = new CtrlProduto();

        //Adiciona produtos
        if (acao.equals("add")) {
            long id = Long.parseLong(request.getParameter("id"));
            Produto produto = ctrlProduto.buscaID(id);
            Item item = new Item();
            item.setProduto(produto);
            itens = (List<Item>) carrinho.getAttribute("itens");

            if (itens == null) {
                itens = new ArrayList<>();
            }

            int cont = 0;
            for (Item i : itens) {
                if (i.getProduto().equals(item.getProduto())) {
                    cont++;
                }
            }

            if (cont == 0) {
                item.setValorItens();
                itens.add(item);
            }

            pagina = "index.jsp?p=carrinho";
        }

        //Remove produto
        if (acao.equals("remove")) {
            int index = Integer.parseInt(request.getParameter("index"));
            itens = (List<Item>) carrinho.getAttribute("itens");

            //remove o item se o carrinho não estiver vazio
            if (!itens.isEmpty()) {
                itens.remove(index);
            }

            pagina = "index.jsp?p=carrinho";
        }

        //Calculo da quantidade
        if (acao.equals("calc")) {
            String quant[] = request.getParameterValues("quant");
            itens = (List<Item>) carrinho.getAttribute("itens");
            int index = 0;
            for (Item iten : itens) {
                iten.setQuant(Integer.parseInt(quant[index]));
                iten.setValorItens();
                index++;
            }

            pagina = "index.jsp?p=carrinho";
        }

        //Ação para Comprar Produtos 
        //<editor-fold>
        if (acao.equals("compra")) {
            cliente = (Cliente) user.getAttribute("cliente");
            CtrlPedido ctrlPedido = new CtrlPedido();
            CtrlItem ctrlItem = new CtrlItem();

            if (cliente == null) {
                pagina = "index.jsp?p=login";
            } else {
                //Cria uma lista com itens na sessão "itens"
                itens = (List<Item>) carrinho.getAttribute("itens");

                //Cria novo Pedido;
                Pedido pedido = new Pedido();

                //Adicionando: Cliente, total produto , frete e calculo de totaldo pedido
                pedido.setCliente(cliente);
                Calendar dt = new GregorianCalendar(Locale.ROOT);
                pedido.setDataPedido(dt);
                pedido.setFrete(total);
                pedido.setValor(frete);
                pedido.setTotal();
                pedido.setFechado(true);

                //Cadastrar Pedidos no Banco
                ctrlPedido.cadastrar(pedido);

                //Cadastrar no banco os itens da lista
                for (Item i : itens) {
                    i.setPedido(pedido);
                    ctrlItem.cadastrar(i);
                }
                carrinho.invalidate();
            }
        }//</editor-fold>

        //Total do carrinho
        if (itens != null) {
            total = calculaTotal(itens);
            frete = calculaFrete(itens);
        }
        //Atualiza session
        carrinho.setAttribute("itens", itens);
        carrinho.setAttribute("total", total);
        carrinho.setAttribute("frete", frete);

        //Retorna para a página
        return pagina;
    }

    // Funções
    private double calculaTotal(List<Item> itens) {
        double total = 0;
        for (Item i : itens) {
            total += i.getValorItens();
        }
        return total;
    }

    private double calculaFrete(List<Item> itens) {
        double frete = 0;
        for (Item i : itens) {
            frete += i.getProduto().getValor() * 0.10;
        }
        return frete;
    }

}
