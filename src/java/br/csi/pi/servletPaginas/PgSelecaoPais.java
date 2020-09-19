package br.csi.pi.servletPaginas;

import br.csi.pi.dao.PaisDAO;
import br.csi.pi.modelo.Pais;
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
@WebServlet(name = "PgSelecaoPais", urlPatterns = {"/pg_SelecaoPais"})
public class PgSelecaoPais extends HttpServlet {
    
    protected void processRequest(HttpServletRequest req, HttpServletResponse resp) 
                                  throws ServletException, IOException{
        
        ArrayList<Pais> p = new PaisDAO().getPais();
        
        req.setAttribute("paises", p);
        RequestDispatcher disp = req.getRequestDispatcher("WEB-INF/views/PaginasComuns/PaginaSelecaoPais.jsp");
        disp.forward(req, resp);
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
                         throws ServletException, IOException{
        processRequest(req, resp);
    }
}