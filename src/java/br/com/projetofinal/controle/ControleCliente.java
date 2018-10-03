package br.com.projetofinal.controle;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author graci
 */
@WebServlet(name = "ControleCliente", urlPatterns = {"/cadcliente.html"})
public class ControleCliente extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        executarcliente(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        executarcliente(request, response);
    }

    private void executarcliente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        
        try{
            String url = request.getServletPath();
            
            if (url.equalsIgnoreCase("/cadcliente.html")) {
                    cadastrar(request, response);
            } else if (url.equalsIgnoreCase("/carregafuncionario.html")) {
                    //carrega(request, response);
            } else if (url.equalsIgnoreCase("/buscafuncionario.html")) {
                    //buscar(request, response);
            } else if (url.equalsIgnoreCase("/editarfuncionario.html")) {
                    //editar(request, response);
            } else if (url.equalsIgnoreCase("/confirmarfornecedor.html")) {
                    //confirmar(request, response);
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

    //CADASTRAR CLIENTE
    private void cadastrar(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        boolean pf = Boolean.parseBoolean(request.getParameter("pf"));
        boolean pj = Boolean.parseBoolean(request.getParameter("pj"));
        String emailcli = request.getParameter("email");
        String senha = request.getParameter("senha");
        String tel = request.getParameter("tel");
        String cel = request.getParameter("cel");
        String cep = request.getParameter("cep");
        String end = request.getParameter("end");
        String num = request.getParameter("numero");
        String compl = request.getParameter("comp");
        String ref = request.getParameter("ref");
        String bairro = request.getParameter("bairro");
        String cid = request.getParameter("cid");
        String est = request.getParameter("est");
        
        if(pf == true){
            String nome = request.getParameter("nomecli");
            String snome = request.getParameter("sobrenome");
            String sexo = request.getParameter("sexo");
            String cpf = request.getParameter("cpf");
            String rg = request.getParameter("rg");
            String nasc = request.getParameter("nasc");
            //Calendar c = Calendar.getInstance();
            //SimpleDateFormat dt = new SimpleDateFormat("dd/MM/yyyy");
            //Date nasc = dt.parse(request.getParameter("nasc"));
        }
        if(pj == true){
            String razao = request.getParameter("rsocial");
            String fantasia = request.getParameter("fantasia");
            String cnpj = request.getParameter("cnpj");
            String insest = request.getParameter("insest");
        }
    }

}
