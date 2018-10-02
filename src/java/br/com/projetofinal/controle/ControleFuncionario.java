package br.com.projetofinal.controle;

import br.com.projetofinal.dao.FuncionarioDao;
import br.com.projetofinal.entidade.Funcionario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "/ControleFuncionario", urlPatterns = {"/cadfuncionario.html"})
public class ControleFuncionario extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        executarfuncionario(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        executarfuncionario(request, response);
    }

    protected void executarfuncionario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        try{
            String url = request.getServletPath();
            
            if (url.equalsIgnoreCase("/cadfuncionario.html")) {
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
            }else {
                throw new Exception("URL Inválida!!!");
            }
        }catch(Exception e){
            System.err.println("Erro cad: "+e.toString());
            response.sendRedirect("index.jsp");
            e.printStackTrace();
        }
    }
    
    //CADASTRAR FUNCIONARIO
    private void cadastrar(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        
        String nome = request.getParameter("nfun");
        String emailfunc = request.getParameter("emailfun");
        String telfunc = request.getParameter("telfun");
        String celfunc = request.getParameter("celfun");
        String cpffunc = request.getParameter("cpffu");
        String funcaofunc = request.getParameter("funcaofu");
        String cepfunc = request.getParameter("cep");
        String endfunc = request.getParameter("end");
        String numfunc = request.getParameter("numfu");
        String complfunc = request.getParameter("complfu");
        String bairrofunc = request.getParameter("bairro");
        String cidfunc = request.getParameter("cid");
        String estfunc = request.getParameter("est");
        
        Funcionario funcionario = new Funcionario();
        funcionario.setFuncionario(nome);
        funcionario.setEmailfunc(emailfunc);
        funcionario.setTelfunc(telfunc);
        funcionario.setCelfunc(celfunc);
        funcionario.setCpffunc(cpffunc);
        funcionario.setFuncaofunc(funcaofunc);
        funcionario.setCepfunc(cepfunc);
        funcionario.setEndfunc(endfunc);
        funcionario.setNumfunc(numfunc);
        funcionario.setComplfunc(complfunc);
        funcionario.setBairrofunc(bairrofunc);
        funcionario.setCidfunc(cidfunc);
        funcionario.setEstfunc(estfunc);
        
        try{
            FuncionarioDao dao = new FuncionarioDao();
            dao.cadastrarfuncionario(funcionario);
            response.sendRedirect("/ProjetoFinal/menufun.jsp");
        }catch(Exception e){
            System.err.println("Erro cad: "+e.toString());
            e.printStackTrace();
        }
        
    }
    
}
