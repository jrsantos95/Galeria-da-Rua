/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.csi.pi.servletController;

import br.csi.pi.dao.LoginDAO;
import br.csi.pi.dao.UsuarioDAO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Juan
 */
@WebServlet(name = "Login", urlPatterns = {"/login"})
public class Login extends HttpServlet {
   
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
                         throws ServletException, IOException {
        System.out.println("Chamou GET ....");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
                          throws ServletException, IOException {
        System.out.println("Método post requisitado ....");
        
        String login = req.getParameter("login");
        String senha = req.getParameter("senha");
        
        System.out.println("TESTE1");
        String autenticado = new LoginDAO().autenticar(login, senha);
        RequestDispatcher disp;
        
        String apreciador = "ap";
        String artista = "art";
        String gerente = "g";
        if(autenticado.equals(apreciador)){
            HttpSession sessao = req.getSession();
            sessao.setAttribute("usuarioLogado", new UsuarioDAO().read(login, senha));
            
            disp = req.getRequestDispatcher("index.html");
            disp.forward(req, resp); 
        }else if(autenticado.equals(artista)){
                 HttpSession sessao = req.getSession();
                 sessao.setAttribute("usuarioLogado", new UsuarioDAO().read(login, senha));
                 
                 disp = req.getRequestDispatcher("index.html");
                 disp.forward(req, resp); 
              }else if(autenticado.equals(gerente)){
                        System.out.println("TESTE3");
                        HttpSession sessao = req.getSession();
                        sessao.setAttribute("usuarioLogado", new UsuarioDAO().read(login, senha));
                    
                        disp = req.getRequestDispatcher("WEB-INF/views/PaginaGerente.jsp");
                        disp.forward(req, resp);            
                    }else{
                          req.setAttribute("mensagem","Usuario ou senha incorretos!, Tente Novamente.");
                          disp = req.getRequestDispatcher("index.html");
                          disp.forward(req, resp); 
                         }
    }
}