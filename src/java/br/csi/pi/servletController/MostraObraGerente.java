package br.csi.pi.servletController;

import br.csi.pi.dao.ArtistaDAO;
import br.csi.pi.dao.ObraDAO;
import br.csi.pi.dao.UsuarioDAO;
import br.csi.pi.modelo.ArtistaFotografo;
import br.csi.pi.modelo.Obra;
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
@WebServlet(name = "MostraObraGerente", urlPatterns = {"/MostraObraGerente"})
public class MostraObraGerente extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
                     throws ServletException, IOException {
    
    int cod_usuario = Integer.parseInt(req.getParameter("cod_usuario"));
    ArtistaFotografo af = new ArtistaDAO().read(cod_usuario);
        
    ArrayList<Obra> ob = new ObraDAO().getObras_contem_artista_foto(af.getCod_artistFoto());

    req.setAttribute("obras", ob);
    RequestDispatcher disp = req.getRequestDispatcher("/WEB-INF/views/PaginasGerente/PaginaMostraObras.jsp");
    disp.forward(req,resp);
    }
}
