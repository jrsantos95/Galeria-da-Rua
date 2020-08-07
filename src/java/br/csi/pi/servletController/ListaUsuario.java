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
        ArrayList<Usuario> us = new UsuarioDAO().getUsuariosGerente();
        
        req.setAttribute("usuarios", us);
        req.setAttribute("art","");
        RequestDispatcher disp = req.getRequestDispatcher("WEB-INF/views/PaginasGerente/PaginaGerente.jsp");
        disp.forward(req, resp);
    }
}