package br.csi.pi.servletPaginas;

import br.csi.pi.dao.ObraDAO;
import br.csi.pi.modelo.Obra;
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
@WebServlet(name = "PgDetalhesObraIndex", urlPatterns = {"/pg_detalhesObraIndex"})
public class PgDetalhesObraIndex extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
                     throws ServletException, IOException {
    
    int cod_obra = Integer.parseInt(req.getParameter("cod_obra"));
        
    ArrayList<Obra> ob = new ObraDAO().getObras(cod_obra);

    req.setAttribute("obras", ob);
    RequestDispatcher disp = req.getRequestDispatcher("/WEB-INF/views/PaginasComuns/PaginaDetalhesObra.jsp");
    disp.forward(req,resp);
    }
}
