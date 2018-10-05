package br.com.projetofinal.controle;

import br.com.projetofinal.dao.CategoriaDao;
import br.com.projetofinal.entidade.Categoria;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Response;

@WebServlet(name = "ControleCategoria", urlPatterns = {"/cadcategoria.html", "/loadcat1.html", "/carreganav.html"})
public class ControleCategoria extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public ControleCategoria() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        executarcategoria(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        executarcategoria(request, response);
    }

    protected void executarcategoria(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        try {
            String url = request.getServletPath();

            if (url.equalsIgnoreCase("/cadcategoria.html")) {
                cadastrar(request, response);
            } else if (url.equalsIgnoreCase("/editarfornecedor.html")) {
                //editar(request, response);
            } else if (url.equalsIgnoreCase("/carreganav.html")) {
                carreganav(request, response);
            } else if (url.equalsIgnoreCase("/fornecedorconsultado.html")) {
                //buscar(request, response);
            } else if (url.equalsIgnoreCase("/confirmarfornecedor.html")) {
                //confirmar(request, response);
            } else if (url.equalsIgnoreCase("/excluirfornecedor.html")) {
                //excluir(request, response);
            } else if (url.equalsIgnoreCase("/loadcat1.html")) {
                carregacat1(request, response);
            } else {
                throw new Exception("URL Inválida!!!");
            }
        } catch (Exception e) {
            System.err.println("Erro cad: " + e.toString());
            response.sendRedirect("index.jsp");
            e.printStackTrace();
        }
    }

    //CADASTRAR CATEGORIA
    private void cadastrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nome = request.getParameter("categoria");
        String setor = request.getParameter("setor");

        Categoria categoria = new Categoria();
        categoria.setCategoria(nome);
        categoria.setSetor(setor);

        try {
            categoria.validar();
            CategoriaDao dao = new CategoriaDao();
            dao.cadastrarcategoria(categoria);
            response.sendRedirect("/ProjetoFinal/menufun.jsp");
        } catch (Exception e) {
            request.setAttribute("erros", e.getMessage());
            request.getRequestDispatcher("/loadsetor.html").forward(request, response);
            e.printStackTrace();
        }
    }

    //CARREGA CAT1
    public void carregacat1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            CategoriaDao pd = new CategoriaDao();
            List<Categoria> listacat1 = pd.buscarcategoria();
            request.setAttribute("listaCategoria", listacat1);
            request.getRequestDispatcher("loadfor.html").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //CONSULTAR CATEGORIA
    //EDITAR CATEGORIA
    //EXCLUIR CATEGORIA

    private void carreganav(HttpServletRequest request, HttpServletResponse response) {
        try {
            CategoriaDao pd = new CategoriaDao();
            List<Categoria> listacat1 = pd.buscarcategoria();
            request.setAttribute("listaCategoria", listacat1);
            request.getRequestDispatcher("menuprod.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
