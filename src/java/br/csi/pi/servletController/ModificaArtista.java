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
        String confirmaSenha = req.getParameter("confirmaSenha");
        String email = req.getParameter("email");
        String idade = req.getParameter("idade");
        String pais = req.getParameter("pais");
        String cidade = req.getParameter("cidade");
        String tag = "@".concat(req.getParameter("tag"));
        String contato = req.getParameter("contato");
        String linguagem = req.getParameter("linguagem");
        String desc_artist_foto = req.getParameter("desc_artist_foto");       
        String cod_pg = req.getParameter("cod_pg");
        
        if(!confirmaSenha.equals(senha)){
            req.setAttribute("nome", "ERRO");
            req.setAttribute("tipoArt","art");
            req.setAttribute("mensagem", "Senha e confirmarSenha não são iguais!, tente novamente");
            RequestDispatcher disp = req.getRequestDispatcher("/WEB-INF/views/PaginasComuns/PaginaSucesso.jsp");
            disp.forward(req,resp);
        }else{
            ArtistaFotografo af = new ArtistaFotografo(cod_usuario, 
                                                       tag, 
                                                       contato, 
                                                       linguagem, 
                                                       nome, 
                                                       senha, 
                                                       email, 
                                                       idade,
                                                       pais,
                                                       cidade,
                                                       desc_artist_foto, 
                                                       "art");
                
            boolean retorno = new ArtistaDAO().update(af);
            if(retorno){
               if("2".equals(cod_pg)){
                    req.setAttribute("mensagem","Modificado com sucesso!");
                    req.setAttribute("usuarioModificado2","usuarioModificado2");
                    RequestDispatcher disp = req.getRequestDispatcher("/WEB-INF/views/PaginasComuns/PaginaSucesso.jsp");
                    disp.forward(req,resp);
               }else{
                    req.setAttribute("mensagem","Modificado com sucesso!");
                    req.setAttribute("usuarioModificado","usuarioModificado");
                    RequestDispatcher disp = req.getRequestDispatcher("/WEB-INF/views/PaginasComuns/PaginaSucesso.jsp");
                    disp.forward(req,resp);
                    }
            }else{
                  req.setAttribute("mensagem","Erro, Não é possivel modificar!");
                  req.setAttribute("usuarioModificado","usuarioModificado");
                  RequestDispatcher disp = req.getRequestDispatcher("/WEB-INF/views/PaginasComuns/PaginaSucesso.jsp");
                  disp.forward(req,resp);

                 }
        }
    }
}