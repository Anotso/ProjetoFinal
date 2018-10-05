package br.com.projetofinal.controle;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ControleLogin", urlPatterns = {"/log.html", "/logout.html"})
public class ControleLogin extends HttpServlet {
    
    private static final long serialVersionUID = 1L;
    
    public ControleLogin(){
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        executarlogin(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        executarlogin(request, response);
    }

    private void executarlogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        try {
            String url = request.getServletPath();
            if (url.equalsIgnoreCase("/log.html")) {
                login(request, response);
            } else if (url.equalsIgnoreCase("/logout.html")) {
                //logout(request, response);
            }
        } catch (Exception e) {
            System.err.println("Erro cad: " + e.toString());
            response.sendRedirect("index.jsp");
            e.printStackTrace();
        }
    }

    private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, NoSuchAlgorithmException {
        String login = request.getParameter("usuario");
        //String sen = request.getParameter("senha");
        MessageDigest algorithm = MessageDigest.getInstance("MD5");
        byte messageDigest[] = algorithm.digest("senha".getBytes("UTF-8"));
        System.out.println("Esse é o valor do login: "+login);
        System.out.println("Esse é o valor da senha: "+messageDigest);
    }

    /*private void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, NoSuchAlgorithmException {
        String login = request.getParameter("nome");
        String sen = request.getParameter("senha");
        MessageDigest algorithm = MessageDigest.getInstance("MD5");
        byte messageDigest[] = algorithm.digest("senha".getBytes("UTF-8"));
        System.out.println("Esse é o valor de byte: "+messageDigest);
    }*/

}
