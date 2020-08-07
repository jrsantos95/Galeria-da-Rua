package br.csi.pi.servletPaginas;

import br.csi.pi.dao.ArtistaDAO;
import br.csi.pi.modelo.ArtistaFotografo;
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
@WebServlet(name = "PgModificaPerfilArtista", urlPatterns = {"/pg_ModificaPerfilArtista"})
public class PgModificaPerfilArtista extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
                         throws ServletException, IOException {
        System.out.println("Chamou GET ....");
        
        int cod_usuario = Integer.parseInt(req.getParameter("cod_usuario"));

        ArtistaFotografo af = new ArtistaDAO().read(cod_usuario);
        req.setAttribute("cod_usuario", cod_usuario);
        req.setAttribute("nome", af.getNome());
        req.setAttribute("email", af.getEmail());
        req.setAttribute("idade", af.getIdade());
        req.setAttribute("senha", af.getSenha());
        req.setAttribute("tag", af.getTag());
        req.setAttribute("contato", af.getContato());
        req.setAttribute("linguagem", af.getLinguagem());
        req.setAttribute("pais", af.getPais());
        req.setAttribute("cidade", af.getCidade());
        req.setAttribute("desc_artist_foto", af.getDescricao_artist_foto());
                
        RequestDispatcher disp = req.getRequestDispatcher("WEB-INF/views/PaginasArtista/PaginaModificaPerfilArtista.jsp");
        disp.forward(req, resp);
    }
}

