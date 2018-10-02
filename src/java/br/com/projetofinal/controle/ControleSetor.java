package br.com.projetofinal.controle;

import br.com.projetofinal.dao.SetorDao;
import br.com.projetofinal.entidade.Setor;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "/ControleSetor", urlPatterns = {"/cadsetor.html","/loadsetor.html"})
public class ControleSetor extends HttpServlet {
    
    private static final long serialVersionUID = 1L;
    
    public ControleSetor(){
        super();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        executarsetor(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        executarsetor(request, response);
    }
    
    protected void executarsetor(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        try{
            String url = request.getServletPath();
            
            if (url.equalsIgnoreCase("/cadsetor.html")) {
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
            }else if (url.equalsIgnoreCase("/loadsetor.html")){
                carregasetor(request, response);
            }else {
                throw new Exception("URL Inválida!!!");
            }
        }catch(Exception e){
            System.err.println("Erro cad: "+e.toString());
            response.sendRedirect("index.jsp");
            e.printStackTrace();
        }
    }
    
    //CADASTRAR SETOR
    private void cadastrar(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        
        String nome = request.getParameter("setor");
        Setor setor = new Setor();
        setor.setSetor(nome);
        
        try{
            SetorDao dao = new SetorDao();
            dao.cadastrarsetor(setor);
            response.sendRedirect("/ProjetoFinal/menufun.jsp");
        }catch(Exception e){
            System.err.println("Erro cad: "+e.toString());
            e.printStackTrace();
        }
        
    }
    
    //LISTAR FUNÇÕES NO CADCATEGORIA
    public void carregasetor(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        try{
            SetorDao pd = new SetorDao();
            List<Setor> lista = pd.buscarsetor();
            request.setAttribute("listaSetor", lista);
            request.getRequestDispatcher("cadcategoria.jsp").forward(request, response);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
