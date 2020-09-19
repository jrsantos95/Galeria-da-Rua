package br.csi.pi.servletController;

import br.csi.pi.dao.ArtistaDAO;
import br.csi.pi.dao.LoginDAO;
import br.csi.pi.dao.ObraDAO;
import br.csi.pi.dao.UsuarioDAO;
import br.csi.pi.modelo.ArtistaFotografo;
import br.csi.pi.modelo.Obra;
import br.csi.pi.modelo.Usuario;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Juan
 */
@WebServlet(name = "Login", urlPatterns = {"/login"})
public class Login extends HttpServlet {
   
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
                         throws ServletException, IOException {
        System.out.println("Chamou GET ....");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
                          throws ServletException, IOException {
        System.out.println("Método post requisitado ....");
        
        String login = req.getParameter("login");
        String senha = req.getParameter("senha");

        String autenticado = new LoginDAO().autenticar(login, senha);
        RequestDispatcher disp;
        
        String apreciador = "ap";
        String artista = "art";
        String gerente = "g";
        if(autenticado.equals(apreciador)){
            HttpSession sessao = req.getSession();
            sessao.setAttribute("usuarioLogado", new UsuarioDAO().read(login, senha));
            ArrayList<Obra> o = new ObraDAO().getObrasTotal();
            Collections.reverse(o);
                    
            sessao.setAttribute("obras", o);
            resp.sendRedirect("http://localhost:8080/PI_GaleriaRua/pg_apreciador");
        }else if(autenticado.equals(artista)){
                 HttpSession sessao = req.getSession();
                 Usuario u = new UsuarioDAO().read(login, senha);
                 ArtistaFotografo af = new ArtistaDAO().read(u.getCod_usuario());
                 ArrayList<Obra> o = new ObraDAO().getObras_contem_artista_foto(af.getCod_artistFoto());
                 
                 if(o.size() > 3){//seleciona 3 obras principais
                    int i = o.size()-1;
                    for(;i>2;i--){
                        o.remove(i);
                    }
                 }
                 
                 sessao.setAttribute("obras", o);
                 sessao.setAttribute("usuarioLogado", new ArtistaDAO().read(u.getCod_usuario()));
                 
                 resp.sendRedirect("http://localhost:8080/PI_GaleriaRua/pg_artistaFoto");
              }else if(autenticado.equals(gerente)){
                        HttpSession sessao = req.getSession();
                        sessao.setAttribute("usuarioLogado", new UsuarioDAO().read(login, senha));
                        
                        resp.sendRedirect("http://localhost:8080/PI_GaleriaRua/ListaUsuario");
                    }else{
                          req.setAttribute("nome", "Erro Login");
                          req.setAttribute("falhaLogin","falhaLogin");
                          req.setAttribute("mensagem", "Erro ao logar, cadastro não encontrado, tente novamente!");
                          
                          disp = req.getRequestDispatcher("/WEB-INF/views/PaginasComuns/PaginaSucesso.jsp");
                          disp.forward(req,resp);
                         }
    }
}