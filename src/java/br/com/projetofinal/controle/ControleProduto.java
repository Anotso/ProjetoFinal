package br.com.projetofinal.controle;

import br.com.projetofinal.dao.ProdutoDao;
import br.com.projetofinal.entidade.Produto;
import br.com.projetofinal.util.Arquivo;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Integer.parseInt;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ControleProduto", urlPatterns = {"/cadproduto.html"})
public class ControleProduto extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    public ControleProduto(){
        super();
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        executarproduto(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        executarproduto(request, response);
    }
    
    protected void executarproduto(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        try {
            String url = request.getServletPath();

            if (url.equalsIgnoreCase("/cadproduto.html")) {
                cadastrar(request, response);
            } else if (url.equalsIgnoreCase("/editarfornecedor.html")) {
                //editar(request, response);
            } else if (url.equalsIgnoreCase("/buscarfornecedor.html")) {
                //buscar(request, response);
            } else if (url.equalsIgnoreCase("/fornecedorconsultado.html")) {
                //buscar(request, response);
            } else if (url.equalsIgnoreCase("/confirmarfornecedor.html")) {
                //confirmar(request, response);
            } else if (url.equalsIgnoreCase("/excluirfornecedor.html")) {
                //excluir(request, response);
            } else if (url.equalsIgnoreCase("/loadfuncao.html")) {
                //carregafuncao(request, response);
            } else {
                throw new Exception("URL Inválida!!!");
            }
        } catch (Exception e) {
            System.err.println("Erro cad: " + e.toString());
            response.sendRedirect("index.jsp");
            e.printStackTrace();
        }
    }
    
    //CADASTRAR PRODUTO
    private void cadastrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        Arquivo arq = new Arquivo();
        String caminhofoto = System.getProperty("user.home")+""+
                "NetBeansProjectes/ProjetoFinal/web/recursos/imgprod/";
        
        String nome = request.getParameter("nprod");
        String fornecedor = request.getParameter("forprod");
        String categoria = request.getParameter("catprod");
        String compra = request.getParameter("vcompprod");
        String venda = request.getParameter("vvendprod");
        int qtd = parseInt(request.getParameter("qtdprod"));
        String img1 = request.getParameter("foto01");
        String img2 = request.getParameter("foto02");
        String img3 = request.getParameter("foto03");
        String img4 = request.getParameter("foto04");
        String img5 = request.getParameter("foto05");
        
        Produto produto = new Produto();
        produto.setProduto(nome);
        produto.setFornecedor(fornecedor);
        produto.setCategoria(categoria);
        produto.setCompra(compra);
        produto.setVenda(venda);
        produto.setQtd(qtd);
        
        //UPLOAD DA FOTO
        if(!img1.equals("")){
        produto.setFoto1(arq.upload(caminhofoto, 
                request.getPart("foto01").getName(), 
                request.getPart("foto01").getInputStream()));
        }
        if(!img2.equals("")){
        produto.setFoto2(arq.upload(caminhofoto, 
                request.getPart("foto02").getName(), 
                request.getPart("foto02").getInputStream()));
        }
        if(!img3.equals("")){
        produto.setFoto3(arq.upload(caminhofoto, 
                request.getPart("foto03").getSubmittedFileName(), 
                request.getPart("foto03").getInputStream()));
        }
        if(img4.equals("")){}else{
            produto.setFoto4(arq.upload(caminhofoto, 
                request.getPart("foto04").getSubmittedFileName(), 
                request.getPart("foto04").getInputStream()));
        }
        if(img5.equals("")){}else{
        produto.setFoto4(arq.upload(caminhofoto, 
                request.getPart("foto04").getSubmittedFileName(), 
                request.getPart("foto04").getInputStream()));
        }
        
        try{
            produto.validar();
            ProdutoDao dao = new ProdutoDao();
            dao.cadastrarproduto(produto);
            response.sendRedirect("/ProjetoFinal/menufun.jsp");
        }catch(Exception e){
            request.setAttribute("erros", e.getMessage());
            //request.getRequestDispatcher("/loadsetor.html").forward(request, response);
            e.printStackTrace();
        }
        
    }

}
