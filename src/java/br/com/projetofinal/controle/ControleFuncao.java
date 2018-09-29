package br.com.projetofinal.controle;

import br.com.projetofinal.entidade.Funcao;
import br.com.projetofinal.dao.FuncaoDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "/ControleFuncao", urlPatterns = {"/cadfuncao.html","cadfuncionario.jsp"})
public class ControleFuncao extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    public ControleFuncao(){
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        executarfuncao(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        executarfuncao(request, response);
    }
    
    protected void executarfuncao(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        try{
            String url = request.getServletPath();
            
            if (url.equalsIgnoreCase("/cadfuncao.html")) {
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

    //CADASTRAR FUNÇÃO
    private void cadastrar(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        
        String nome = request.getParameter("funcao");
        
        Funcao funcao = new Funcao();
        funcao.setFuncao(nome);
        
        try{
            FuncaoDao dao = new FuncaoDao();
            dao.cadastrarfuncao(funcao);
            //response.sendRedirect("../web/menu.jsp");
        }catch(Exception e){
            System.err.println("Erro cad: "+e.toString());
            e.printStackTrace();
        }
    }
    
    //LISTAR FUNÇÕES NO CADFUNCIONARIO
    public void carregafuncao(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		try {
                    FuncaoDao pd = new FuncaoDao();
                    List<Funcao> lista = pd.buscarfuncao();
                    request.setAttribute("listaFuncao", lista);
                    request.getRequestDispatcher("cadfuncionario.jsp").forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
