package br.com.projetofinal.controle;

import br.com.projetofinal.dao.ClienteDao;
import br.com.projetofinal.dao.FuncionarioDao;
import br.com.projetofinal.entidade.Cliente;
import br.com.projetofinal.entidade.Funcionario;
import br.com.projetofinal.util.Crypt;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Integer.parseInt;
import java.security.MessageDigest;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ControleCliente", urlPatterns = {"/cadcliente.html",
    "/buscacliente.html", "/carregacliente.html", "/log.html", "/logout.html",
    "/menucli.html","/excluircliente.html","/editarcliente.html"
})
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
            } else if (url.equalsIgnoreCase("/carregacliente.html")) {
                carrega(request, response);
            } else if (url.equalsIgnoreCase("/buscacliente.html")) {
                buscar(request, response);
            } else if (url.equalsIgnoreCase("/editarcliente.html")) {
                editar(request, response);
            } else if (url.equalsIgnoreCase("/confirmarcliente.html")) {
                //confirmar(request, response);
            } else if (url.equalsIgnoreCase("/excluircliente.html")) {
                excluir(request, response);
            } else if (url.equalsIgnoreCase("/menucli.html")) {
                menucli(request, response);
            }else if (url.equalsIgnoreCase("/log.html")) {
                login(request, response);
            } else if (url.equalsIgnoreCase("/logout.html")) {
                logout(request, response);
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
        String pessoa = request.getParameter("pessoa");
        String emailcli = request.getParameter("email");
        String senha = Crypt.md5(request.getParameter("senha"));
        //String senha = request.getParameter("senha");
        /*MessageDigest algorithm = MessageDigest.getInstance("MD5");
        byte messageDigest[] = algorithm.digest("senha".getBytes("UTF-8"));*/
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
        if (pessoa.trim().equalsIgnoreCase("pf")) {
            String nome = request.getParameter("nomecli");
            String snome = request.getParameter("sobrenome");
            String sexo = request.getParameter("sexo");
            String cpf = request.getParameter("cpf");
            String rg = request.getParameter("rg");
            String nasc = request.getParameter("nasc");
            //Calendar c = Calendar.getInstance();
            //SimpleDateFormat dt = new SimpleDateFormat("dd/MM/yyyy");
            //Date nasc = dt.parse(request.getParameter("nasc"));

            Cliente cliente = new Cliente();
            cliente.setCliente(nome);
            cliente.setSnome(snome);
            cliente.setDtnasc(nasc);
            cliente.setSexo(sexo);
            cliente.setTipocli(pessoa);
            cliente.setCadfed(cpf);
            cliente.setCadest(rg);
            cliente.setEmailcli(emailcli);
            //cliente.setSenhacli(messageDigest);
            cliente.setSenhacli(senha);
            cliente.setTelcli(tel);
            cliente.setCelcli(cel);
            cliente.setCepcli(cep);
            cliente.setEndcli(end);
            cliente.setNumcli(num);
            cliente.setComplcli(compl);
            cliente.setRefcli(ref);
            cliente.setBairrocli(bairro);
            cliente.setCidcli(cid);
            cliente.setEstcli(est);

            try {
                cliente.validar();
                ClienteDao dao = new ClienteDao();
                dao.cadastrar(cliente);
                response.sendRedirect("/ProjetoFinal/index.jsp");
            } catch (Exception e) {
                request.setAttribute("erros", e.getMessage().replace("\n", "<br>"));
                //request.getRequestDispatcher("/cadcliente.jsp").forward(request, response);
                e.printStackTrace();
            }
        }
        //if (pjuridica == true) {
        if (pessoa.trim().equalsIgnoreCase("pj")) {
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
            Cliente cliente = new Cliente();
            cliente.setCliente(razao);
            cliente.setSnome(fantasia);
            cliente.setDtnasc("-");
            cliente.setSexo("-");
            cliente.setTipocli(pessoa);
            cliente.setCadfed(cnpj);
            cliente.setCadest(insest);
            cliente.setEmailcli(emailcli);
            //cliente.setSenhacli(messageDigest);
            cliente.setSenhacli(senha);
            cliente.setTelcli(telpj);
            cliente.setCelcli(celpj);
            cliente.setCepcli(cep);
            cliente.setEndcli(end);
            cliente.setNumcli(num);
            cliente.setComplcli(compl);
            cliente.setRefcli(ref);
            cliente.setBairrocli(bairro);
            cliente.setCidcli(cid);
            cliente.setEstcli(est);

            try {
                cliente.validar();
                ClienteDao dao = new ClienteDao();
                dao.cadastrar(cliente);
                response.sendRedirect("/ProjetoFinal/index.jsp");
            } catch (Exception e) {
                request.setAttribute("erros", e.getMessage().replace("\n", "<br>"));
                request.getRequestDispatcher("/cadcliente.jsp").forward(request, response);
                e.printStackTrace();
            }

        }
    }

    private void buscar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String cpf = request.getParameter("bfunc");
            ClienteDao pd = new ClienteDao();

            List<Cliente> lista = pd.listaCliente(cpf);

            request.setAttribute("cpf", cpf);
            request.setAttribute("listaCliente", lista);
            request.getRequestDispatcher("/consultarcliente.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void carrega(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            ClienteDao pd = new ClienteDao();
            List<Cliente> lista = pd.carregacliente();
            request.setAttribute("listaCliente", lista);
            request.getRequestDispatcher("/consultarcliente.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        int lvl = 0;
        String login = request.getParameter("usuario");
        String sen = Crypt.md5(request.getParameter("senha"));

        Cliente c = new ClienteDao().logincli(login, sen);
        Funcionario f = new FuncionarioDao().loginfun(login, sen);
        try {
            if (c != null) {
                lvl = 2;
                request.getSession().setAttribute("c", c);
                request.getSession().setAttribute("c", lvl);
                request.getSession().setAttribute("login", login);
                
                /*HttpSession c = request.getSession(true);
                c.setAttribute("login", login);*/
                
                //response.sendRedirect("/menucli.html");
                request.getRequestDispatcher("/menucli.html").forward(request, response);
            } else {
                if (f != null) {
                    lvl = 1;
                    request.getSession().setAttribute("f", f);
                    request.getSession().setAttribute("f", lvl);
                    request.getSession().setAttribute("login", login);
                    
                    /*HttpSession f = request.getSession(true);
                    f.setAttribute("login", login);*/
                    System.out.println("Valor de f: "+f);
                    
                    response.sendRedirect("/ProjetoFinal/menufun.jsp");
                } else {
                    request.getRequestDispatcher("/login.html").forward(request, response);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
            request.getRequestDispatcher("/ProjetoFinal/index.jsp").forward(request, response);
        }
    }

    private void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        /*HttpSession cliente = request.getSession();
        HttpSession funcionario = request.getSession();
        HttpSession c = request.getSession();
        HttpSession f = request.getSession();
        c.invalidate();
        f.invalidate();*/
        request.getSession().setAttribute("c", null);
        request.getSession().setAttribute("f", null);
        response.sendRedirect("/ProjetoFinal/index.jsp");
    }

    private void menucli(HttpServletRequest request, HttpServletResponse response) {
        try {
            String login = (String) request.getSession().getAttribute("login");
            ClienteDao pd = new ClienteDao();

            List<Cliente> lista = pd.carCliente(login);
            System.out.println("Valor de login: "+login);

            request.setAttribute("login", login);
            request.setAttribute("listaCliente", lista);
            System.out.println("Valor de lista: "+lista);
            request.getRequestDispatcher("/menucli.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void excluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = parseInt(request.getParameter("id"));
        Cliente cliente = new Cliente();

        cliente.setIdcli(id);
        cliente.setAtivo(false);

        try {
            ClienteDao dao = new ClienteDao();
            dao.excluircliente(cliente);
            response.sendRedirect("/ProjetoFinal/index.jsp");
        } catch (Exception e) {
            //request.setAttribute("erros", e.getMessage().replace("\n", "<br>"));
            request.getRequestDispatcher("/index.html").forward(request, response);
            e.printStackTrace();
        }
    }

    private void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pessoa = request.getParameter("pessoa");
        String emailcli = request.getParameter("email");
        String senha = Crypt.md5(request.getParameter("senha"));
        //String senha = request.getParameter("senha");
        /*MessageDigest algorithm = MessageDigest.getInstance("MD5");
        byte messageDigest[] = algorithm.digest("senha".getBytes("UTF-8"));*/
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
        if (pessoa.trim().equalsIgnoreCase("pf")) {
            String nome = request.getParameter("nomecli");
            String snome = request.getParameter("sobrenome");
            String sexo = request.getParameter("sexo");
            String cpf = request.getParameter("cpf");
            String rg = request.getParameter("rg");
            String nasc = request.getParameter("nasc");
            //Calendar c = Calendar.getInstance();
            //SimpleDateFormat dt = new SimpleDateFormat("dd/MM/yyyy");
            //Date nasc = dt.parse(request.getParameter("nasc"));

            Cliente cliente = new Cliente();
            cliente.setCliente(nome);
            cliente.setSnome(snome);
            cliente.setDtnasc(nasc);
            cliente.setSexo(sexo);
            cliente.setTipocli(pessoa);
            cliente.setCadfed(cpf);
            cliente.setCadest(rg);
            cliente.setEmailcli(emailcli);
            //cliente.setSenhacli(messageDigest);
            cliente.setSenhacli(senha);
            cliente.setTelcli(tel);
            cliente.setCelcli(cel);
            cliente.setCepcli(cep);
            cliente.setEndcli(end);
            cliente.setNumcli(num);
            cliente.setComplcli(compl);
            cliente.setRefcli(ref);
            cliente.setBairrocli(bairro);
            cliente.setCidcli(cid);
            cliente.setEstcli(est);

            try {
                cliente.validar();
                ClienteDao dao = new ClienteDao();
                dao.cadastrar(cliente);
                response.sendRedirect("/ProjetoFinal/index.jsp");
            } catch (Exception e) {
                request.setAttribute("erros", e.getMessage().replace("\n", "<br>"));
                //request.getRequestDispatcher("/cadcliente.jsp").forward(request, response);
                e.printStackTrace();
            }
        }
        //if (pjuridica == true) {
        if (pessoa.trim().equalsIgnoreCase("pj")) {
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
            Cliente cliente = new Cliente();
            cliente.setCliente(razao);
            cliente.setSnome(fantasia);
            cliente.setDtnasc("-");
            cliente.setSexo("-");
            cliente.setTipocli(pessoa);
            cliente.setCadfed(cnpj);
            cliente.setCadest(insest);
            cliente.setEmailcli(emailcli);
            //cliente.setSenhacli(messageDigest);
            cliente.setSenhacli(senha);
            cliente.setTelcli(telpj);
            cliente.setCelcli(celpj);
            cliente.setCepcli(cep);
            cliente.setEndcli(end);
            cliente.setNumcli(num);
            cliente.setComplcli(compl);
            cliente.setRefcli(ref);
            cliente.setBairrocli(bairro);
            cliente.setCidcli(cid);
            cliente.setEstcli(est);

            try {
            ClienteDao dao = new ClienteDao();
            dao.atualizarcliente(cliente);
            response.sendRedirect("/ProjetoFinal/menucli.jsp");
        } catch (Exception e) {
            //request.setAttribute("erros", e.getMessage().replace("\n", "<br>"));
            request.getRequestDispatcher("/ProjetoFinal/menucli.jsp").forward(request, response);
            e.printStackTrace();
        }

        }
    }

}
