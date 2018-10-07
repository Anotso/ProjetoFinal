package br.com.projetofinal.controle;

import br.com.projetofinal.dao.ProdutoDao;
import br.com.projetofinal.entidade.Item;
import br.com.projetofinal.entidade.Produto;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ControleVenda", urlPatterns = {"/addcarrinho.html"})
public class ControleVenda extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        executarvenda(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        executarvenda(request, response);
    }

    private void executarvenda(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        HttpSession carrinho = request.getSession(false);

        System.out.println("Entoru no servlet Venda");
        try {
            String url = request.getServletPath();

            if (url.equalsIgnoreCase("/addcarrinho.html")) {
                chamavalor(request, response);
            } else if (url.equalsIgnoreCase("/addcarrinho.html")) {
                //AdicionaItensCarrinho(request, response);
            } else if (url.equalsIgnoreCase("/buscaproduto.html")) {
                //finalizar(request, response);
            } else if (url.equalsIgnoreCase("/pesquisaproduto.html")) {
                //pesquisa(request, response);
            } else if (url.equalsIgnoreCase("/carregaproduto.html")) {
                //todos(request, response);
            } else if (url.equalsIgnoreCase("/confirmaproduto.html")) {
                //confirmar(request, response);
            } else if (url.equalsIgnoreCase("/telaprod.html")) {
                //loadesp(request, response);
            } else if (url.equalsIgnoreCase("/excluirfornecedor.html")) {
                //excluir(request, response);
            } else if (url.equalsIgnoreCase("/carregacadprod.html")) {
                //carregacad(request, response);      //CHAMA A TELA DE CADASTRO
            } else {
                throw new Exception("URL Inválida!!!");
            }
        } catch (Exception e) {
            System.err.println("Erro cad: " + e.toString());
            response.sendRedirect("index.jsp");
            e.printStackTrace();
        }
    }

    private void chamavalor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            String qtd = request.getParameter("qtd");

            ProdutoDao prod = new ProdutoDao();
            List<Produto> lista = prod.carregaProduto(id);
            request.setAttribute("carregaProduto", lista);

            //String dado = String.join("_", id, qtd);
            //System.out.println("Resultado do join: " + dado);
            /*System.out.println("Resultado do nome: " + nome);
            System.out.println("Resultado do venda: " + venda);
            HttpSession carrinho = request.getSession(true);
            ArrayList retornoLista = (ArrayList) carrinho.getAttribute("lista");
            retornoLista = new AdicionaItensCarrinho().AdicionaItensCarrinho(produto, retornoLista);
            carrinho.setAttribute("lista", retornoLista);*/
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static class AdicionaItensCarrinho {

        public ArrayList AdicionaItensCarrinho(Produto produto, ArrayList carrinho) {

            if (carrinho == null) {
                carrinho = new ArrayList();
            }
            carrinho.add(produto.getProduto());
            return carrinho;
        }

    }

}
