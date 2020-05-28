package br.csi.pi.servletController;

import br.csi.pi.dao.UsuarioDAO;
import br.csi.pi.modelo.Usuario;
import java.io.IOException;
import java.util.ArrayList;
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
@WebServlet(name = "ListaUsuario", urlPatterns = {"/ListaUsuario"})
public class ListaUsuario extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
                         throws ServletException, IOException {
        System.out.println("Teste simples");
        ArrayList<Usuario> us = new UsuarioDAO().getUsuarios();
        
        req.setAttribute("usuarios", us);
        
        RequestDispatcher disp = req.getRequestDispatcher("WEB-INF/views/PaginaGerente.jsp");
        disp.forward(req, resp);
    }
}