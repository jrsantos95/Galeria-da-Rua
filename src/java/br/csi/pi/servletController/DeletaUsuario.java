package br.csi.pi.servletController;

import br.csi.pi.dao.ApreciadorDAO;
import br.csi.pi.dao.ArtistaDAO;
import br.csi.pi.dao.GerenteDAO;
import br.csi.pi.dao.UsuarioDAO;
import br.csi.pi.modelo.ArtistaFotografo;
import br.csi.pi.modelo.Gerente;
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
@WebServlet(name = "DeletaUsuario", urlPatterns = {"/DeletaUsuario"})
public class DeletaUsuario extends HttpServlet {

@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
                     throws ServletException, IOException {
    
    int cod_usuario = Integer.parseInt(req.getParameter("cod_usuario"));
    Usuario u = new UsuarioDAO().read(cod_usuario);
    
    boolean retorno = false;

    if("ap".equals(u.getTipo())){
       retorno = new ApreciadorDAO().delete(u);
    }else if("art".equals(u.getTipo())){
             ArtistaFotografo af = new ArtistaDAO().read(u.getCod_usuario());
             retorno = new ArtistaDAO().delete(af);
         }else if("g".equals(u.getTipo())){
                  retorno = new GerenteDAO().delete((Gerente) u);
              }else{
                    retorno = false;
                   }
    
    if(retorno){
        req.setAttribute("nome", "Excluiu!");
        req.setAttribute("mensagem", "Usuario excluido!");
        req.setAttribute("usuarioExcluido","usuarioExcluido");
        RequestDispatcher disp = req.getRequestDispatcher("/WEB-INF/views/PaginasComuns/PaginaSucesso.jsp");
        disp.forward(req,resp);
    }else{            
        req.setAttribute("mensagem","Usuario relacionado a obra, Não é possivel excluir!");
        req.setAttribute("usuarioExcluido","usuarioExcluido");
        RequestDispatcher disp = req.getRequestDispatcher("/WEB-INF/views/PaginasComuns/PaginaSucesso.jsp");
        disp.forward(req,resp);
    }
}
}
