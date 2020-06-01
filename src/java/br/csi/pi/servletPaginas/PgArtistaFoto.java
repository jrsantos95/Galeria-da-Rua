package br.csi.pi.servletPaginas;

import br.csi.pi.dao.UsuarioDAO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import static sun.security.jgss.GSSUtil.login;

/**
 *
 * @author Juan
 */
@WebServlet(name = "PgArtistaFoto", urlPatterns = {"/pg_artistaFoto"})
public class PgArtistaFoto extends HttpServlet {

    protected void processRequest(HttpServletRequest req, HttpServletResponse resp) 
                                  throws ServletException, IOException{
        
        RequestDispatcher disp = req.getRequestDispatcher("WEB-INF/views/PaginaArtista.jsp");
        disp.forward(req, resp);
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
                         throws ServletException, IOException{
        processRequest(req, resp);
    }
}