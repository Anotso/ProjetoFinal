package br.com.projetofinal.logica;

import controller.CtrlProduto;
import java.util.List;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Produto;
import br.com.projetofinal.util.Arquivo;

@MultipartConfig
//@WebServlet(name = "ProdutoServlet", urlPatterns = {"/Produto"})
public class ProdutoLog implements Logica {

    public String executa(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        String pagina = "index.jsp";
        String acao = request.getParameter("acao");
        String caminhoFoto = System.getProperty("user.home") + ""
                //+ "/Documents/NetBeansProjects/lomoj/web/img/produtos/";//windows
                + "/NetBeansProjects/lomoj/web/img/produtos/";//linux

        //Cadastro
        if (acao.equals("cad")) {
            try {
                Produto produto = new Produto();
                CtrlProduto ctrlProduto = new CtrlProduto();
                Arquivo arq = new Arquivo();

                produto.setNome(request.getParameter("nome"));
                produto.setDescricao(request.getParameter("descricao"));

                if (!request.getParameter("quant").equals("")) {
                    produto.setQuant(Integer.parseInt(request.getParameter("quant")));
                }

                if (!request.getParameter("valor").equals("")) {
                    produto.setValor(Float.parseFloat(request.getParameter("valor")));
                }

                produto.setFoto01(request.getPart("foto01").getSubmittedFileName());
                produto.setFoto02(request.getPart("foto02").getSubmittedFileName());
                produto.setFoto03(request.getPart("foto03").getSubmittedFileName());

                if (request.getParameter("ativo").equals("1")) {
                    produto.setAtivo(true);
                } else {
                    produto.setAtivo(false);
                }

                //Validação
                produto.validar();

                //Upload da Fotos
                if (!produto.getFoto01().equals("")) {
                    produto.setFoto01(arq.upload(caminhoFoto,
                            request.getPart("foto01").getSubmittedFileName(),
                            request.getPart("foto01").getInputStream()));
                }
                if (!produto.getFoto02().equals("")) {
                    produto.setFoto02(arq.upload(caminhoFoto,
                            request.getPart("foto02").getSubmittedFileName(),
                            request.getPart("foto02").getInputStream()));
                }
                if (!produto.getFoto03().equals("")) {
                    produto.setFoto03(arq.upload(caminhoFoto,
                            request.getPart("foto03").getSubmittedFileName(),
                            request.getPart("foto03").getInputStream()));
                }

                //Cadastra o produto
                ctrlProduto.cadastrar(produto);
                request.setAttribute("avisos", "Cadastrado");
            } catch (Exception ex) {
                request.setAttribute("erros", ex.getMessage().replace("\n", "<br>"));
            }
            pagina = "admin.jsp?p=formProduto";
        }

        //Pesquisar
        if (acao.equals("pesq")) {
            CtrlProduto ctrlProduto = new CtrlProduto();
            String dados = request.getParameter("dados").trim();
            try {
                List<Produto> produtos = ctrlProduto.pesquisar(dados);
                request.setAttribute("produtos", produtos);
            } catch (Exception ex) {
                request.setAttribute("erros", "Dados não encontrados.");
            }
            pagina = "admin.jsp?p=reportProduto";
        }

        //Busca por ID
        if (acao.equals("desc")) {
            CtrlProduto ctrlProduto = new CtrlProduto();
            long id = Long.parseLong(request.getParameter("id"));
            try {
                Produto produto = ctrlProduto.buscaID(id);
                request.setAttribute("produto", produto);
                pagina = "index.jsp?p=descProduto";
            } catch (Exception ex) {
                request.setAttribute("erros", "Produto não encontrados.");
                pagina = "index.jsp";
            }
        }

        //Retorna para a página
        return pagina;
    }

}
