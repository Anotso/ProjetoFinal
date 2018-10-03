package br.com.projetofinal.controle;

import br.com.projetofinal.dao.PfDao;
import br.com.projetofinal.dao.PjDao;
import br.com.projetofinal.entidade.Pf;
import br.com.projetofinal.entidade.Pj;
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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        try {
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
            } else if (url.equalsIgnoreCase("/excluirfuncionario.html")) {
                //excluir(request, response);
            } else {
                throw new Exception("URL Inválida!!!");
            }
        } catch (Exception e) {
            System.err.println("Erro cad: " + e.toString());
            response.sendRedirect("index.jsp");
            e.printStackTrace();
        }
    }

    //CADASTRAR CLIENTE
    private void cadastrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {
        String pfisica = request.getParameter("pessoa");
        String pjuridica = request.getParameter("pessoa");
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
        
        //if (pfisica == true) {
        if (pfisica.trim().equalsIgnoreCase("pf")) {
            String nome = request.getParameter("nomecli");
            String snome = request.getParameter("sobrenome");
            String sexo = request.getParameter("sexo");
            String cpf = request.getParameter("cpf");
            String rg = request.getParameter("rg");
            String nasc = request.getParameter("nasc");
            //Calendar c = Calendar.getInstance();
            //SimpleDateFormat dt = new SimpleDateFormat("dd/MM/yyyy");
            //Date nasc = dt.parse(request.getParameter("nasc"));

            Pf pf = new Pf();
            pf.setPf(nome);
            pf.setSnome(snome);
            pf.setDtnasc(nasc);
            pf.setSexo(sexo);
            pf.setCpfpf(cpf);
            pf.setRgpf(rg);
            pf.setEmailpf(emailcli);
            pf.setSenhapf(senha);
            pf.setTelpf(tel);
            pf.setCelpf(cel);
            pf.setCeppf(cep);
            pf.setEndpf(end);
            pf.setNumpf(num);
            pf.setComplpf(compl);
            pf.setRefpf(ref);
            pf.setBairropf(bairro);
            pf.setCidpf(cid);
            pf.setEstpf(est);

            try {
                pf.validar();
                PfDao dao = new PfDao();
                dao.cadastrarpf(pf);
                response.sendRedirect("/ProjetoFinal/index.jsp");
            } catch (Exception e) {
                request.setAttribute("erros", e.getMessage().replace("\n", "<br>"));
                //request.getRequestDispatcher("/cadcliente.jsp").forward(request, response);
                e.printStackTrace();
            }
        }
        //if (pjuridica == true) {
        if (pjuridica.trim().equalsIgnoreCase("pj")) {
            //System.out.println("Entrou no IF PJ - Controle");
            String razao = request.getParameter("rsocial");
            String fantasia = request.getParameter("fantasia");
            String cnpj = request.getParameter("cnpj");
            String insest = request.getParameter("insest");
            String telpj = request.getParameter("telpj");
            String celpj = request.getParameter("celpj");
            
            /*System.out.println("Razão: "+razao);
            System.out.println("fantásia: "+fantasia);
            System.out.println("CNPJ: "+cnpj);
            System.out.println("Inscrição: "+insest);
            System.out.println("E-mail: "+emailcli);
            System.out.println("Telefone: "+telpj);
            System.out.println("Celular: "+celpj);
            System.out.println("CEP: "+cep);
            System.out.println("Número: "+num);
            System.out.println("Complemento: "+compl);
            System.out.println("Referência: "+ref);
            System.out.println("Bairro: "+bairro);
            System.out.println("Cidade: "+cid);
            System.out.println("Estado: "+est);*/
            
            Pj pj = new Pj();
            pj.setRazao(razao);
            pj.setNomepj(fantasia);
            pj.setCnpjpj(cnpj);
            pj.setInsestpj(insest);
            pj.setEmailpj(emailcli);
            pj.setSenhapj(senha);
            pj.setTelpj(telpj);
            pj.setCelpj(celpj);
            pj.setCeppj(cep);
            pj.setEndpj(end);
            pj.setNumpj(num);
            pj.setComplpj(compl);
            pj.setRefpj(ref);
            pj.setBairropj(bairro);
            pj.setCidpj(cid);
            pj.setEstpj(est);
            
            try {
                pj.validar();
                PjDao dao = new PjDao();
                dao.cadastrarpj(pj);
                //response.sendRedirect("/ProjetoFinal/index.jsp");
            } catch (Exception e) {
                request.setAttribute("erros", e.getMessage().replace("\n", "<br>"));
                request.getRequestDispatcher("/cadcliente.jsp").forward(request, response);
                e.printStackTrace();
            }
            
        }
    }

}
