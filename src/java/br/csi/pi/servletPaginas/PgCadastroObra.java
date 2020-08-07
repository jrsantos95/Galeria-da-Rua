package br.csi.pi.servletPaginas;

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
@WebServlet(name = "PgCadastroObra", urlPatterns = {"/pg_cadastroObra"})
public class PgCadastroObra extends HttpServlet {

    protected void processRequest(HttpServletRequest req, HttpServletResponse resp) 
                                  throws ServletException, IOException{
        RequestDispatcher disp = req.getRequestDispatcher("WEB-INF/views/PaginasArtista/PaginaCadastroObra.jsp");
        disp.forward(req, resp);
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
                         throws ServletException, IOException{
        processRequest(req, resp);
    }
}