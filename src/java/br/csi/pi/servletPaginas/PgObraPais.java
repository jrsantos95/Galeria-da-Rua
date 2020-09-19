package br.csi.pi.servletPaginas;

import br.csi.pi.dao.ObraDAO;
import br.csi.pi.modelo.Obra;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
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
@WebServlet(name = "PgObraPais", urlPatterns = {"/pg_ObraPais"})
public class PgObraPais extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
                     throws ServletException, IOException {
        System.out.println("Chamou GET ....");
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
                                  throws ServletException, IOException{
        String pais = req.getParameter("pais");

        ArrayList<Obra> o = new ObraDAO().getObras_pais(pais);
        Collections.reverse(o);

        req.setAttribute("obras", o);
        RequestDispatcher disp = req.getRequestDispatcher("/WEB-INF/views/PaginasComuns/PaginaObrasPais.jsp");
        disp.forward(req,resp);
    }
}