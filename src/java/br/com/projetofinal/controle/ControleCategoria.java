package br.com.projetofinal.controle;

import br.com.projetofinal.dao.CategoriaDao;
import br.com.projetofinal.entidade.Categoria;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author graci
 */
@WebServlet(name = "ControleCategoria", urlPatterns = {"/cadcategoria.html"})
public class ControleCategoria extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    public ControleCategoria(){
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
            throws ServletException, IOException{
        try{
            String url = request.getServletPath();
            
            if (url.equalsIgnoreCase("/cadcategoria.html")) {
                    cadastrar(request, response);
            } else if (url.equalsIgnoreCase("/editarfornecedor.html")) {
                    //editar(request, response);
            } else if (url.equalsIgnoreCase("/buscarfornecedor.html")) {
                    //buscar(request, response);
            } else if (url.equalsIgnoreCase("/fornecedorconsultado.html")) {
                    //buscar(request, response);
            } else if (url.equalsIgnoreCase("/confirmarfornecedor.html")) {
                    //confirmar(request, response);
            }else if (url.equalsIgnoreCase("/excluirfornecedor.html")) {
                    //excluir(request, response);
            }else if (url.equalsIgnoreCase("/loadfuncao.html")){
                //carregafuncao(request, response);
            }else {
                throw new Exception("URL Inválida!!!");
            }
        }catch(Exception e){
            System.err.println("Erro cad: "+e.toString());
            response.sendRedirect("index.jsp");
            e.printStackTrace();
        }
    }
    
    //CADASTRAR CATEGORIA
    private void cadastrar(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        String nome = request.getParameter("categoria");
        String setor = request.getParameter("setorcat");
        
        Categoria categoria = new Categoria();
        categoria.setCategoria(nome);
        categoria.setSetor(setor);
        System.out.println("VALOR DO CARALHO DO SETOR: "+setor);
        
        try{
            CategoriaDao dao = new CategoriaDao();
            dao.cadastrarcategoria(categoria);
            response.sendRedirect("/ProjetoFinal/menufun.jsp");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    //CONSULTAR CATEGORIA
    //EDITAR CATEGORIA
    //EXCLUIR CATEGORIA

}
