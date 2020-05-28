package br.csi.pi.servletController;

import br.csi.pi.dao.ArtistaDAO;
import br.csi.pi.dao.UsuarioDAO;
import br.csi.pi.modelo.ArtistaFotografo;
import br.csi.pi.modelo.Usuario;
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
@WebServlet(name = "ModificaUsuario", urlPatterns = {"/ModificaUsuario"})
public class ModificaUsuario extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
                         throws ServletException, IOException {
        System.out.println("Chamou GET ....");
        
        int cod_usuario = Integer.parseInt(req.getParameter("cod_usuario"));
        Usuario u = new UsuarioDAO().read(cod_usuario);
        
        System.out.println("Cod_modifica: "+u.getCod_usuario());
        boolean retorno = false;

        if("ap".equals(u.getTipo())){
           req.setAttribute("cod_usuario", cod_usuario);
           req.setAttribute("nome",u.getNome());
           req.setAttribute("email",u.getEmail());
           req.setAttribute("idade",u.getIdade());
           req.setAttribute("senha",u.getSenha());
           
           System.out.println("Teste 1");
           RequestDispatcher disp = req.getRequestDispatcher("WEB-INF/views/ModificaApreciador.jsp");
           disp.forward(req, resp);
        }else if("art".equals(u.getTipo())){
                ArtistaFotografo af = new ArtistaDAO().read(cod_usuario);
                req.setAttribute("nome",af.getNome());
                req.setAttribute("email",af.getEmail());
                req.setAttribute("idade",af.getIdade());
                req.setAttribute("senha",af.getSenha());
                req.setAttribute("tag",af.getTag());
                req.setAttribute("contato",af.getContato());
                req.setAttribute("linguagem",af.getLinguagem());
                req.setAttribute("desc_artist_foto",af.getDescricao_artist_foto());
                
                RequestDispatcher disp = req.getRequestDispatcher("WEB-INF/views/ModificaArtista.jsp");
                disp.forward(req, resp);
              }else{
                    RequestDispatcher disp = req.getRequestDispatcher("index.html");
                    disp.forward(req, resp);
                   }
    }
}