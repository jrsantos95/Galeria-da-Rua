package br.csi.pi.servletPaginas;

import java.io.IOException;
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
@WebServlet(name = "PgApreciador", urlPatterns = {"/pg_apreciador"})
public class PgApreciador extends HttpServlet {

    protected void processRequest(HttpServletRequest req, HttpServletResponse resp) 
                                  throws ServletException, IOException{
        RequestDispatcher disp = req.getRequestDispatcher("WEB-INF/views/PaginasApreciador/PaginaApreciador.jsp");
        disp.forward(req, resp);
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
                         throws ServletException, IOException{
        processRequest(req, resp);
    }
}
