package br.com.projetofinal.logica;

import controller.CtrlFuncionario;
import java.util.List;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Funcionario;
import util.Arquivo;
import util.Crypt;

@MultipartConfig
//@WebServlet(name = "FuncionarioServlet", urlPatterns = {"/Func"})
public class FuncionarioLog implements Logica {

    public String executa(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        String pagina = "admin.jsp";
        String acao = request.getParameter("acao");
        String caminhoFoto = System.getProperty("user.home") + ""
                //+ "/Documents/NetBeansProjects/lomoj/web/img/func/";//windows
                + "/NetBeansProjects/lomoj/web/img/func/";//linux

        //Cadastro e Alteração
        if (acao.equals("cad") || acao.equals("alt")) {
            Funcionario funcionario = new Funcionario();
            try {
                CtrlFuncionario ctrlFuncionario = new CtrlFuncionario();
                Arquivo arq = new Arquivo();
                funcionario.setNome(request.getParameter("nome").trim());
                funcionario.setEmail(request.getParameter("email").trim());
                funcionario.setPws(request.getParameter("pws").trim());
                funcionario.setFoto(request.getPart("fotoperfil").getSubmittedFileName());

                if (request.getParameter("ativo").equals("1")) {
                    funcionario.setAtivo(true);
                } else {
                    funcionario.setAtivo(false);
                }

                //Upload da Foto
                funcionario.setFoto(arq.upload(caminhoFoto,
                        request.getPart("fotoperfil").getSubmittedFileName(),
                        request.getPart("fotoperfil").getInputStream()));

                if (acao.equals("cad")) {
                    funcionario.validar(request.getParameter("pwsc").trim());
                    funcionario.setPws(Crypt.md5(funcionario.getPws()));
                    ctrlFuncionario.cadastrar(funcionario);
                } else {
                    funcionario.validar();
                    ctrlFuncionario.alterar(funcionario);
                }
                funcionario = null;
                request.setAttribute("avisos", "Cadastrado");
            } catch (Exception ex) {
                request.setAttribute("erros", ex.getMessage().replace("\n", "<br>"));
            }
            request.setAttribute("Funcionario", funcionario);
            pagina = "admin.jsp?p=formFuncionario";
        }

        //Login
        if (acao.equals("log")) {
            try {
                CtrlFuncionario ctrlFuncionario = new CtrlFuncionario();
                String email = request.getParameter("email").trim();
                String pws = Crypt.md5(request.getParameter("pws").trim());
                System.out.println("senha:" + Crypt.md5("pws"));
                Funcionario funcionario = ctrlFuncionario.login(email, pws);
                HttpSession user = request.getSession();
                funcionario.setPws("");
                user.setAttribute("funcionario", funcionario);
            } catch (Exception ex) {
                request.setAttribute("erros", "Usuário ou senha invalido");
                pagina = "admin.jsp?p=login";
            }
        }

        //Logoff(sair)
        if (acao.equals("off")) {
            HttpSession user = request.getSession();
            //Remove um item da session
            //user.removeAttribute("funcionario");
            //Apaga a session user
            user.invalidate();
        }

        //Pesquisar
        if (acao.equals("pesq")) {
            CtrlFuncionario ctrlfuncionario = new CtrlFuncionario();
            String dados = request.getParameter("dados").trim();
            try {
                List<Funcionario> funcionarios = ctrlfuncionario.pesquisa(dados);
                request.setAttribute("funcionarios", funcionarios);
            } catch (Exception ex) {
                request.setAttribute("erros", "Dados não encontrados.");
            }
            pagina = "admin.jsp?p=reportFuncionario";
        }

        //Retorna para a página
        return pagina;
    }

}
