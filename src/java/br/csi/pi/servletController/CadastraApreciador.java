package br.csi.pi.servletController;

import br.csi.pi.dao.ApreciadorDAO;
import br.csi.pi.modelo.Apreciador;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Juan
 */
@WebServlet(name = "CadastraApreciador", urlPatterns = {"/CadastraApreciador"})
public class CadastraApreciador extends HttpServlet {
   
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
                         throws ServletException, IOException {
        System.out.println("Chamou GET ....");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
                          throws ServletException, IOException {
        System.out.println("Método post requisitado ....");
        
        PrintWriter resposta = resp.getWriter();
        
        String nome = req.getParameter("nome");
        String senha = req.getParameter("senha");
        String confirmaSenha = req.getParameter("confirmaSenha");
        String email = req.getParameter("email");
        String idade = req.getParameter("idade");
        String pais = req.getParameter("pais");
        String cidade = req.getParameter("cidade");
  
        Apreciador ap = new Apreciador(nome, senha, email, idade, "ap");
        
        int retorno = new ApreciadorDAO().create(ap);
        if(retorno >= 1){
            System.out.println("Cadastrou!");
            req.setAttribute("mensagem","Sucesso no cadastro");
            RequestDispatcher disp = req.getRequestDispatcher("index.html");
            disp.forward(req,resp);
        }else if(retorno == -1){//FAZER PAGINA DE ERRO!!!!!   
                System.out.println("Já existe cadastro com esse user, Tente Novamente!");
                req.setAttribute("mensagem","Já existe cadastro com esse user, Tente Novamente!");
                RequestDispatcher disp = req.getRequestDispatcher("index.html");
                disp.forward(req,resp);
              }else {//FAZER PAGINA DE ERRO!!!!!  
                    System.out.println("Falha no cadastro, Tente Novamente!");
                    req.setAttribute("mensagem","Falha no cadastro, Tente Novamente!");
                    RequestDispatcher disp = req.getRequestDispatcher("index.html");
                    disp.forward(req,resp);
              }
    }
}