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
@WebServlet(name = "PgMostraObras", urlPatterns = {"/pg_MostraObras"})
public class PgMostraObras extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
                         throws ServletException, IOException {
        
        int cod_artisFoto = Integer.parseInt(req.getParameter("cod_artisFoto"));
        
        ArrayList<Obra> ob = new ObraDAO().getObras_contem_artista_foto(cod_artisFoto);
        
        if(ob.isEmpty()){
            req.setAttribute("obras", null);
            RequestDispatcher disp = req.getRequestDispatcher("WEB-INF/views/PaginasArtista/PaginaMostraObras.jsp");
            disp.forward(req, resp);  
        }else{
             req.setAttribute("obras", ob);
             RequestDispatcher disp = req.getRequestDispatcher("WEB-INF/views/PaginasArtista/PaginaMostraObras.jsp");
             disp.forward(req, resp);
             }
    }
}