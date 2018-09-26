package br.com.projetofinal.logica;

import br.com.projetofinal.controle.CtrlFornecedor;
import java.util.List;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import br.com.projetofinal.entidade.Fornecedor;

@MultipartConfig
//@WebServlet(name = "FuncionarioServlet", urlPatterns = {"/Func"})
public class FornecedorLog implements Logica {

    public String executa(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        String pagina = "admin.jsp";
        String acao = request.getParameter("acao");

        //Cadastro e Alteração
        if (acao.equals("cad") || acao.equals("alt")) {
            Fornecedor fornecedor = new Fornecedor();
            try {
                CtrlFornecedor ctrlFornecedor = new CtrlFornecedor();
                fornecedor.setFornecedor(request.getParameter("nfor").trim());
                fornecedor.setEmailfor(request.getParameter("emailfor").trim());
                fornecedor.setSitefor(request.getParameter("sitefor").trim());
                fornecedor.setTelfor(request.getParameter("telfor").trim());
                fornecedor.setCnpj(request.getParameter("cnpjfor").trim());
                fornecedor.setCepfor(request.getParameter("cep").trim());
                fornecedor.setEndfor(request.getParameter("end").trim());
                fornecedor.setNumfor(request.getParameter("numfor").trim());
                fornecedor.setComplfor(request.getParameter("complfor").trim());
                fornecedor.setBairrofor(request.getParameter("bairro").trim());
                fornecedor.setCidfor(request.getParameter("cid").trim());
                fornecedor.setEstfor(request.getParameter("est").trim());

                if (request.getParameter("ativo").equals("1")) {
                    fornecedor.setAtivo(true);
                } else {
                    fornecedor.setAtivo(false);
                }

                if (acao.equals("cad")) {
                    fornecedor.validar(request.getParameter("pwsc").trim());
                    fornecedor.setPws(Crypt.md5(fornecedor.getPws()));
                    ctrlFornecedor.cadastrar(fornecedor);
                } else {
                    funcionario.validar();
                    ctrlFornecedor.alterar(funcionario);
                }
                fornecedor = null;
                request.setAttribute("avisos", "Cadastrado");
            } catch (Exception ex) {
                request.setAttribute("erros", ex.getMessage().replace("\n", "<br>"));
            }
            request.setAttribute("Fornecedor", fornecedor);
            pagina = "admin.jsp?p=formFuncionario";
        }

        //Login
        if (acao.equals("log")) {
            try {
                CtrlFornecedor ctrlFuncionario = new CtrlFornecedor();
                String email = request.getParameter("email").trim();
                String pws = Crypt.md5(request.getParameter("pws").trim());
                System.out.println("senha:" + Crypt.md5("pws"));
                Fornecedor funcionario = ctrlFuncionario.login(email, pws);
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
            CtrlFornecedor ctrlfuncionario = new CtrlFornecedor();
            String dados = request.getParameter("dados").trim();
            try {
                List<Fornecedor> funcionarios = ctrlfuncionario.pesquisa(dados);
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