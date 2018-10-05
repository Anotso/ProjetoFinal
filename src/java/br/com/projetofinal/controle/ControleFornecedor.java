package br.com.projetofinal.controle;

import br.com.projetofinal.dao.FornecedorDao;
import br.com.projetofinal.entidade.Fornecedor;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "/ControleFornecedor", urlPatterns = {"/cadastrarfornecedor.html","/loadfornecedor.html",
    "/buscafornecedor.html","/carregafornecedor.html"
})
public class ControleFornecedor extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    public ControleFornecedor(){
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        executarfornecedor(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        executarfornecedor(request, response);
    }

    protected void executarfornecedor(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        try{
            String url = request.getServletPath();
            
            if (url.equalsIgnoreCase("/cadastrarfornecedor.html")) {
                    cadastrar(request, response);
            } else if (url.equalsIgnoreCase("/editarfornecedor.html")) {
                    //editar(request, response);
            } else if (url.equalsIgnoreCase("/buscafornecedor.html")) {
                    buscar(request, response);
            } else if (url.equalsIgnoreCase("/carregafornecedor.html")) {
                    carrega(request, response);
            } else if (url.equalsIgnoreCase("/confirmarfornecedor.html")) {
                    //confirmar(request, response);
            }else if (url.equalsIgnoreCase("/excluirfornecedor.html")) {
                    //excluir(request, response);
            }else if (url.equalsIgnoreCase("/loadfornecedor.html")) {
                carregaforn(request, response);
            }else {
                throw new Exception("URL Inválida!!!");
            }
        }catch(Exception e){
            System.err.println("Erro cad: "+e.toString());
            response.sendRedirect("index.jsp");
            e.printStackTrace();
        } 
    }
    
    //CADASTRAR FORNECEDOR
    protected void cadastrar(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        
        String nome = request.getParameter("nfor");
        String emailfor = request.getParameter("emailfor");
        String sitefor = request.getParameter("sitefor");
        String telfor = request.getParameter("telfor");
        String cnpj = request.getParameter("cnpjfor");
        String cepfor = request.getParameter("cep");
        String endfor = request.getParameter("end");
        String numfor = request.getParameter("numfor");
        String complfor = request.getParameter("complfor");
        String bairrofor = request.getParameter("bairro");
        String cidfor = request.getParameter("cid");
        String estfor = request.getParameter("est");
        
        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setFornecedor(nome);
        fornecedor.setEmailfor(emailfor);
        fornecedor.setSitefor(sitefor);
        fornecedor.setTelfor(telfor);
        fornecedor.setCnpj(cnpj);
        fornecedor.setCepfor(cepfor);
        fornecedor.setEndfor(endfor);
        fornecedor.setNumfor(numfor);
        fornecedor.setComplfor(complfor);
        fornecedor.setBairrofor(bairrofor);
        fornecedor.setCidfor(cidfor);
        fornecedor.setEstfor(estfor);
        
        try{
            FornecedorDao dao = new FornecedorDao();
            dao.cadastrarfornecedor(fornecedor);
            response.sendRedirect("/ProjetoFinal/menufun.jsp");
        }catch(Exception e){
            System.err.println("Erro cad: "+e.toString());
            e.printStackTrace();
        }
    }
    
    //BUSCAR FORNECEDOR
    public void buscar(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        try{
            String dado = request.getParameter("dado");
            FornecedorDao forn = new FornecedorDao();
            
            List<Fornecedor> lista = forn.buscarfornecedor(dado);
            request.setAttribute("dado", dado);
            request.setAttribute("listafornecedor", lista);
            request.getRequestDispatcher("fornecedorconsultado.jsp").forward(request, response);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    //CARREGA FORNECEDOR - CADASTRO DE PRODUTOS
    public void carregaforn(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        try{
            FornecedorDao forn = new FornecedorDao();
            List<Fornecedor> listafor = forn.loadfornecedor();
            request.setAttribute("listaFornecedor", listafor);
            request.getRequestDispatcher("cadproduto.jsp").forward(request, response);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    private void carrega(HttpServletRequest request, HttpServletResponse response) {
        try{
            FornecedorDao forn = new FornecedorDao();
            List<Fornecedor> listafor = forn.loadfornecedor();
            request.setAttribute("listaFornecedor", listafor);
            request.getRequestDispatcher("/consultarfornecedor.jsp").forward(request, response);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
