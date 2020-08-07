package br.csi.pi.servletPaginas;

import br.csi.pi.dao.CidadeDAO;
import br.csi.pi.dao.PaisDAO;
import br.csi.pi.modelo.Cidade;
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
@WebServlet(name = "PgCadastroApreciador", urlPatterns = {"/pg_cadastroApreciador"})
public class PgCadastroApreciador extends HttpServlet {
    protected void processRequest(HttpServletRequest req, HttpServletResponse resp)
                                  throws ServletException, IOException{
        ArrayList<Pais> p = new PaisDAO().getPais();
        ArrayList<Cidade> c = new CidadeDAO().getCidade();
        
        req.setAttribute("paises", p);
        req.setAttribute("cidades",c);
        RequestDispatcher disp = req.getRequestDispatcher("WEB-INF/views/PaginasComuns/PaginaCadastroApreciador.jsp");
        disp.forward(req, resp);
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
                         throws ServletException, IOException{
        processRequest(req, resp);
    }
}