package br.com.projetofinal.controle;

import br.com.projetofinal.dao.CategoriaDao;
import br.com.projetofinal.dao.FornecedorDao;
import br.com.projetofinal.dao.ProdutoDao;
import br.com.projetofinal.entidade.Categoria;
import br.com.projetofinal.entidade.Fornecedor;
import br.com.projetofinal.entidade.Produto;
import br.com.projetofinal.util.Arquivo;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Integer.parseInt;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@MultipartConfig
@WebServlet(name = "ControleProduto", urlPatterns = {"/cadproduto.html", "/carregacadprod.html",
    "/buscaproduto.html","/carregaproduto.html","/editarproduto.html","/confirmaproduto.html",
    "/pesquisaproduto.html","/telaprod.html"
})
public class ControleProduto extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public ControleProduto() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        executarproduto(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        executarproduto(request, response);
    }

    protected void executarproduto(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        try {
            String url = request.getServletPath();

            if (url.equalsIgnoreCase("/cadproduto.html")) {
                cadastrar(request, response);
            } else if (url.equalsIgnoreCase("/editarproduto.html")) {
                editar(request, response);
            } else if (url.equalsIgnoreCase("/buscaproduto.html")) {
                buscar(request, response);
            } else if (url.equalsIgnoreCase("/pesquisaproduto.html")) {
                pesquisa(request, response);
            } else if (url.equalsIgnoreCase("/carregaproduto.html")) {
                todos(request, response);
            } else if (url.equalsIgnoreCase("/confirmaproduto.html")) {
                confirmar(request, response);
            } else if (url.equalsIgnoreCase("/telaprod.html")) {
                loadesp(request, response);
            }else if (url.equalsIgnoreCase("/excluirfornecedor.html")) {
                //excluir(request, response);
            } else if (url.equalsIgnoreCase("/carregacadprod.html")) {
                carregacad(request, response);      //CHAMA A TELA DE CADASTRO
            } else {
                throw new Exception("URL Inválida!!!");
            }
        } catch (Exception e) {
            System.err.println("Erro cad: " + e.toString());
            response.sendRedirect("index.jsp");
            e.printStackTrace();
        }
    }

    //CADASTRAR PRODUTO
    private void cadastrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Arquivo arq = new Arquivo();
        //  CURSO
        //String caminhofoto = System.getProperty("user.home")+""+"\\Documents\\NetBeansProjects\\ProjetoFinal\\web\\recursos\\imgprod\\";
        //  CASA
        String caminhofoto = System.getProperty("user.home") + "" + "\\Pictures\\imgprod\\";
        float nc = 0;
        float nv = 0;
        int qtd = 0;

        String nome = request.getParameter("nprod");
        String fornecedor = request.getParameter("forprod");
        String categoria = request.getParameter("catprod");
        String compra = request.getParameter("vcompprod");
        String venda = request.getParameter("vvendprod");
        String q = request.getParameter("qtdprod");
        String desc = request.getParameter("descricao");
        String img1 = request.getPart("foto01").getSubmittedFileName();
        String img2 = request.getPart("foto02").getSubmittedFileName();
        String img3 = request.getPart("foto03").getSubmittedFileName();
        String img4 = request.getPart("foto04").getSubmittedFileName();
        String img5 = request.getPart("foto05").getSubmittedFileName();

        if (q.equals("")) {
            qtd = 0;
        } else {
            qtd = parseInt(q);
        }

        if (compra.equals("")) {
            nc = 0;
        } else {
            compra = compra.replace(".", "");
            compra = compra.replace(",", ".");
            nc = Float.parseFloat(compra);
        }
        if (venda.equals("")) {
            nv = 0;
        } else {
            venda = venda.replace(".", "");
            venda = venda.replace(",", ".");
            nv = Float.parseFloat(venda);
        }

        Produto produto = new Produto();
        produto.setProduto(nome);
        produto.setFornecedor(fornecedor);
        produto.setCategoria(categoria);
        produto.setDescricao(desc);
        produto.setCompra(nc);
        produto.setVenda(nv);
        produto.setQtd(qtd);

        //UPLOAD DA FOTO
        if (!img1.equals("")) {
            produto.setFoto1(arq.upload(caminhofoto,
                    request.getPart("foto01").getSubmittedFileName(),
                    request.getPart("foto01").getInputStream()));

            if (!img2.equals("")) {
                produto.setFoto2(arq.upload(caminhofoto,
                        request.getPart("foto02").getSubmittedFileName(),
                        request.getPart("foto02").getInputStream()));
            }
            if (!img3.equals("")) {
                produto.setFoto3(arq.upload(caminhofoto,
                        request.getPart("foto03").getSubmittedFileName(),
                        request.getPart("foto03").getInputStream()));
            }
            if (!img4.equals("")) {
                produto.setFoto4(arq.upload(caminhofoto,
                        request.getPart("foto04").getSubmittedFileName(),
                        request.getPart("foto04").getInputStream()));
            }
            if (!img5.equals("")) {
                produto.setFoto5(arq.upload(caminhofoto,
                        request.getPart("foto05").getSubmittedFileName(),
                        request.getPart("foto05").getInputStream()));
            }

            try {
                //produto.validar();
                ProdutoDao dao = new ProdutoDao();
                dao.cadastrarproduto(produto);
                response.sendRedirect("/ProjetoFinal/menufun.jsp");
            } catch (Exception e) {
                request.setAttribute("erros", e.getMessage());
                request.getRequestDispatcher("/carregacadprod.html").forward(request, response);
                e.printStackTrace();
            }

        }
    }

    public void carregacad(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            CategoriaDao pd = new CategoriaDao();
            List<Categoria> listacat1 = pd.buscarcategoria();
            request.setAttribute("listaCategoria", listacat1);

            FornecedorDao forn = new FornecedorDao();
            List<Fornecedor> listafor = forn.loadfornecedor();
            request.setAttribute("listaFornecedor", listafor);

            if ((listafor.equals(""))) {
                System.out.println("Erro ao carregar a lista de fornecedores.");
            } else {
                request.getRequestDispatcher("cadproduto.jsp").forward(request, response);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void todos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            ProdutoDao prod = new ProdutoDao();
            List<Produto> lista = prod.todosprodutos();
            request.setAttribute("listaProduto", lista);
            request.getRequestDispatcher("/consultaproduto.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void buscar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        try {
            String dado = request.getParameter("dado");
            ProdutoDao prod = new ProdutoDao();
            List<Produto> lista = prod.listaProduto(dado);
            request.setAttribute("dado", dado);
            request.setAttribute("listaProduto", lista);
            request.getRequestDispatcher("/consultaproduto.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            ProdutoDao prod = new ProdutoDao();
            List<Produto> lista = prod.carregaProduto(id);
            request.setAttribute("dado", id);
            request.setAttribute("listaProduto", lista);
            request.getRequestDispatcher("/carregacadprod.html").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void confirmar(HttpServletRequest request, HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void pesquisa(HttpServletRequest request, HttpServletResponse response) {
        try {
            String dado = request.getParameter("dado");
            ProdutoDao prod = new ProdutoDao();
            List<Produto> lista = prod.listaProduto(dado);
            request.setAttribute("dado", dado);
            request.setAttribute("listaProduto", lista);
            request.getRequestDispatcher("/resultadoproduto.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void loadesp(HttpServletRequest request, HttpServletResponse response) {
        try {
            int dado = Integer.parseInt(request.getParameter("id"));
            ProdutoDao prod = new ProdutoDao();
            List<Produto> lista = prod.carregaProduto(dado);
            request.setAttribute("dado", dado);
            request.setAttribute("listaProduto", lista);
            request.getRequestDispatcher("/telaprod.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
