package br.csi.pi.servletController;

import br.csi.pi.dao.ArtistaDAO;
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
@WebServlet(name = "CadastraImagemArtista", urlPatterns = {"/CadastraImagemArtista"})
public class CadastraImagemArtista extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
                         throws ServletException, IOException {
        System.out.println("Chamou GET ....");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
                          throws ServletException, IOException {
        System.out.println("Método post requisitado ....");
        
        String imagem = req.getParameter("imagem");
        
        boolean retorno = new ArtistaDAO().updateImagem(imagem);
        
        if(retorno == false){
            req.setAttribute("nome", "Erro!");
            req.setAttribute("tipoArt","art");
            req.setAttribute("mensagem", "Ocorreu algum erro, por favor tente novamente!");
            RequestDispatcher disp = req.getRequestDispatcher("/WEB-INF/views/PaginasComuns/PaginaSucesso.jsp");
            disp.forward(req,resp);
        }else{
                req.setAttribute("nome", "Sucesso!");
                req.setAttribute("tipoArt","art");
                req.setAttribute("mensagem", "Artista cadastrado com sucesso!");
                RequestDispatcher disp = req.getRequestDispatcher("/WEB-INF/views/PaginasComuns/PaginaSucesso.jsp");
                disp.forward(req,resp);
            }
    }
}
