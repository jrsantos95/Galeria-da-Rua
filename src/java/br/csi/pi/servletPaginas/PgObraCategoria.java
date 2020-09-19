package br.csi.pi.servletPaginas;

import br.csi.pi.dao.ObraDAO;
import br.csi.pi.modelo.Obra;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "PgObraCategoria", urlPatterns = {"/pg_ObraCategoria"})
public class PgObraCategoria extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
                     throws ServletException, IOException {
        
    String categoria = req.getParameter("categoria");
    
    if(categoria.equals("VerTodas")){
        ArrayList<Obra> o = new ObraDAO().getObrasTotal();
        
        req.setAttribute("obras", o);
        RequestDispatcher disp = req.getRequestDispatcher("/WEB-INF/views/PaginasComuns/PaginaObrasCategoria.jsp");
        disp.forward(req,resp);
    }
    
    ArrayList<Obra> o = new ObraDAO().getObras_linguagem(categoria);
    
    req.setAttribute("obras", o);
    RequestDispatcher disp = req.getRequestDispatcher("/WEB-INF/views/PaginasComuns/PaginaObrasCategoria.jsp");
    disp.forward(req,resp);
    }
}