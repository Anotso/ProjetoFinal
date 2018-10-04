package br.com.projetofinal.controle;

import br.com.projetofinal.dao.FuncionarioDao;
import br.com.projetofinal.entidade.Funcionario;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Integer.parseInt;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "/ControleFuncionario", urlPatterns = {"/cadfuncionario.html","/buscafuncionario.html",
    "/excluirfuncionario.html","/editarfuncionario.html","/carregafuncionario.html",
    "/atualizafuncionario.html"
})
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
            } else if (url.equalsIgnoreCase("/carregafuncionario.html")) {
                    carrega(request, response);
            } else if (url.equalsIgnoreCase("/buscafuncionario.html")) {
                    buscar(request, response);
            } else if (url.equalsIgnoreCase("/editarfuncionario.html")) {
                    editar(request, response);
            } else if (url.equalsIgnoreCase("/atualizafuncionario.html")) {
                    confirmar(request, response);
            }else if (url.equalsIgnoreCase("/excluirfuncionario.html")) {
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
        String senhafunc = request.getParameter("senhafun");
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
        funcionario.setSenhafunc(senhafunc);
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
        
        System.out.println("Nome: "+nome);
        System.out.println("E-mail: "+emailfunc);
        System.out.println("Senha: "+senhafunc);
        System.out.println("Tel: "+telfunc);
        System.out.println("Cel: "+celfunc);
        System.out.println("CPF: "+cpffunc);
        System.out.println("Função: "+funcaofunc);
        System.out.println("CEP: "+cepfunc);
        System.out.println("End: "+endfunc);
        System.out.println("Número: "+numfunc);
        System.out.println("Complemento: "+complfunc);
        System.out.println("Bairro: "+bairrofunc);
        System.out.println("Cidade: "+cidfunc);
        System.out.println("Estado: "+estfunc);
        
        try{
            funcionario.validar();
            FuncionarioDao dao = new FuncionarioDao();
            dao.cadastrarfuncionario(funcionario);
            response.sendRedirect("/ProjetoFinal/menufun.jsp");
        }catch(Exception e){
            request.setAttribute("erros", e.getMessage().replace("\n", "<br>"));
            request.getRequestDispatcher("/loadfuncao.html").forward(request, response);
            e.printStackTrace();
        }
        
    }

    private void buscar(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        try{
            String cpf = request.getParameter("bfunc");
            FuncionarioDao pd = new FuncionarioDao();
            
            List<Funcionario> lista = pd.listaFuncionario(cpf);
            
            request.setAttribute("cpf", cpf);
            request.setAttribute("listaFuncionario", lista);
            request.getRequestDispatcher("/consultarfuncionario.jsp").forward(request, response);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    private void editar(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        try{
            String id = request.getParameter("id");
            
            FuncionarioDao pd = new FuncionarioDao();
            
            List<Funcionario> lista = pd.editaFuncionario(id);
            
            request.setAttribute("id", id);
            request.setAttribute("editaFuncionario", lista);
            request.getRequestDispatcher("/loadfuncao.html").forward(request, response);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    private void carrega(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        try{
            FuncionarioDao func = new FuncionarioDao();
            List<Funcionario> lista = func.carregafuncionario();
            request.setAttribute("listaFuncionario", lista);
            request.getRequestDispatcher("/consultarfuncionario.jsp").forward(request, response);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    private void confirmar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        int id = parseInt(request.getParameter("idfun"));
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
        String st = request.getParameter("statusfunc");
        
        boolean status = true;
        
        if(st.trim().equals("false")){
            status = false;
        }
        
        Funcionario funcionario = new Funcionario();
        funcionario.setIdfuncionario(id);
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
        funcionario.setAtivo(status);
        
        System.out.println("ID: "+id);
        System.out.println("Nome: "+nome);
        System.out.println("E-mail: "+emailfunc);
        System.out.println("Tel: "+telfunc);
        System.out.println("Cel: "+celfunc);
        System.out.println("CPF: "+cpffunc);
        System.out.println("Função: "+funcaofunc);
        System.out.println("CEP: "+cepfunc);
        System.out.println("End: "+endfunc);
        System.out.println("Número: "+numfunc);
        System.out.println("Complemento: "+complfunc);
        System.out.println("Bairro: "+bairrofunc);
        System.out.println("Cidade: "+cidfunc);
        System.out.println("Estado: "+estfunc);
        System.out.println("Status: "+status);
        
        try{
            funcionario.validarAtt();
            FuncionarioDao dao = new FuncionarioDao();
            dao.editarrfuncionario(funcionario);
            response.sendRedirect("/ProjetoFinal/menufun.jsp");
        }catch(Exception e){
            request.setAttribute("erros", e.getMessage().replace("\n", "<br>"));
            request.getRequestDispatcher("/loadfuncao.html").forward(request, response);
            e.printStackTrace();
        }
    }
    
}
