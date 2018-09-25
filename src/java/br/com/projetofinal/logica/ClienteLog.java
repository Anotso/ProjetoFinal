package br.com.projetofinal.logica;

import controller.CtrlCliente;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Cliente;
import br.com.projetofinal.util.Arquivo;
import br.com.projetofinal.util.Crypt;

@MultipartConfig
//@WebServlet(name = "ClienteServlet", urlPatterns = {"/Cliente"})
public class ClienteLog implements Logica {

    public String executa(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        String pagina = "index.jsp";
        String acao = request.getParameter("acao").trim();
        String caminhoFoto = System.getProperty("user.home") + ""
                //+ "/Documents/NetBeansProjects/lomoj/web/img/clientes/";//windows
                + "/NetBeansProjects/lomoj/web/img/clientes/";//linux

        //Cadastro e Alteração
        if (acao.equals("cad") || acao.equals("alt")) {
            Cliente cliente = new Cliente();
            try {
                CtrlCliente ctrlCliente = new CtrlCliente();
                Arquivo arq = new Arquivo();

                cliente.setNome(request.getParameter("nome").trim());
                cliente.setEmail(request.getParameter("email").trim());
                cliente.setFoto(request.getPart("fotoperfil").getSubmittedFileName().trim());
                cliente.setNumero(request.getParameter("numero").trim());
                cliente.setComplemento(request.getParameter("complemento").trim());
                cliente.getEndereco().setLogradouro(request.getParameter("logradouro").trim());
                cliente.getEndereco().setBairro(request.getParameter("bairro").trim());
                cliente.getEndereco().setCidade(request.getParameter("cidade").trim());
                cliente.getEndereco().setUf(request.getParameter("uf").trim());
                cliente.getEndereco().setCep(request.getParameter("cep").trim());

                if (request.getParameter("ativo").equals("1")) {
                    cliente.setAtivo(true);
                } else {
                    cliente.setAtivo(false);
                }

                //Data de Nascimento
                if (!request.getParameter("dataNasc").equals("")) {
                    //String para Data(Calendar)
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    Calendar cal = Calendar.getInstance();
                    cal.setTime(sdf.parse(request.getParameter("dataNasc").trim()));
                    cliente.setDataNasc(cal);
                }

                //Validação dos dados
                if (acao.equals("cad")) {
                    cliente.setPws(request.getParameter("pws").trim());
                    cliente.validar(request.getParameter("pwsc").trim());
                } else {
                    cliente.setId(Long.parseLong(request.getParameter("id")));
                    cliente.validar();
                }

                //Upload da Foto
                cliente.setFoto(arq.upload(caminhoFoto,
                        request.getPart("fotoperfil").getSubmittedFileName(),
                        request.getPart("fotoperfil").getInputStream()));

                //Cadastra ou altera no banco
                if (acao.equals("cad")) {
                    cliente.setPws(Crypt.md5(cliente.getPws()));
                    ctrlCliente.cadastrar(cliente);
                    request.setAttribute("avisos", "Cadastrado");
                } else {
                    ctrlCliente.alterar(cliente);
                    request.setAttribute("avisos", "Alterado");
                }
                
                //limpa o cliente
                cliente = null;
            } catch (Exception ex) {
                System.err.println("Erro: " + ex.toString());
                request.setAttribute("erros", ex.getMessage().replace("\n", "<br>"));
            }
            request.setAttribute("cliente", cliente);
            pagina = "index.jsp?p=formCliente";
        }

        //Login
        if (acao.equals("log")) {
            try {
                CtrlCliente ctrlCliente = new CtrlCliente();
                String email = request.getParameter("email").trim();
                String pws = Crypt.md5(request.getParameter("pws").trim());
                Cliente cliente = ctrlCliente.login(email, pws);
                HttpSession user = request.getSession();
                cliente.setPws("");
                user.setAttribute("cliente", cliente);
            } catch (Exception ex) {
                request.setAttribute("erros", "Usuário ou senha invalido");
                pagina = "index.jsp?p=login";
            }
        }

        //Logoff(sair)
        if (acao.equals("off")) {
            HttpSession user = request.getSession();
            //Remove um item da session
            //user.removeAttribute("cliente");
            //Apaga a session user
            user.invalidate();
        }

        //Pesquisar
        if (acao.equals("pesq")) {
            CtrlCliente ctrlcliente = new CtrlCliente();
            String dados = request.getParameter("dados").trim();
            try {
                List<Cliente> clientes = ctrlcliente.pesquisa(dados);
                request.setAttribute("clientes", clientes);
            } catch (Exception ex) {
                request.setAttribute("erros", "Dados não encontrados.");
            }
            pagina = "admin.jsp?p=reportCliente";
        }

        if (acao.equals("edit")) {
            long id = Long.parseLong(request.getParameter("id"));
            CtrlCliente ctrlCliente = new CtrlCliente();
            Cliente cliente;
            try {
                cliente = ctrlCliente.buscaID(id);
                request.setAttribute("cliente", cliente);
            } catch (Exception ex) {
                request.setAttribute("erros", "Cliente não localizado.");
            }

            pagina = "index.jsp?p=formCliente";
        }
        
        //Remover ou Apagar
        if (acao.equals("rem")) {
            CtrlCliente ctrlCliente = new CtrlCliente();
            try {
                ctrlCliente.remover(Long.parseLong(request.getParameter("id")));
                request.setAttribute("aviso", "Removido");
            } catch (Exception ex) {
                request.setAttribute("erros", ex.toString());
            }
            pagina = "admin.jsp?p=reportCliente";
        }

        //Retorna para a página
        return pagina;
    }

}
