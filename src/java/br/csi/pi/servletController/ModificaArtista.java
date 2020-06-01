package br.csi.pi.servletController;

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
@WebServlet(name = "ModificaArtista", urlPatterns = {"/ModificaArtista"})
public class ModificaArtista extends HttpServlet {
   
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
                         throws ServletException, IOException {
        System.out.println("Chamou GET ....");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
                          throws ServletException, IOException {
        System.out.println("Método post requisitado ....");
        
        int cod_usuario = Integer.parseInt(req.getParameter("cod_usuario"));
        String nome = req.getParameter("nome");
        String senha = req.getParameter("senha");
        String email = req.getParameter("email");
        String idade = req.getParameter("idade");
        String tag = req.getParameter("tag");
        String contato = req.getParameter("contato");
        String linguagem = req.getParameter("linguagem");
        String desc_artist_foto = req.getParameter("desc_artist_foto");
        
        ArtistaFotografo af = new ArtistaFotografo(cod_usuario, 
                                                   tag, 
                                                   contato, 
                                                   linguagem, 
                                                   nome, 
                                                   senha, 
                                                   email, 
                                                   idade, 
                                                   desc_artist_foto, 
                                                   "art");
        
        boolean retorno = new ArtistaDAO().update(af);
        if(retorno){
           req.setAttribute("mensagem","Modificado com sucesso");
           RequestDispatcher disp = req.getRequestDispatcher("/WEB-INF/views/SucessoG.jsp");
           disp.forward(req,resp);
        }else{
              req.setAttribute("mensagem","Não é possivel modificado!");
              RequestDispatcher disp = req.getRequestDispatcher("/WEB-INF/views/SucessoG.jsp");
              disp.forward(req,resp);
            
             }
    }
}