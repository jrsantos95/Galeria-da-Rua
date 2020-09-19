package br.csi.pi.servletController;

import br.csi.pi.dao.ArtistaDAO;
import br.csi.pi.dao.ObraDAO;
import br.csi.pi.modelo.ArtistaFotografo;
import br.csi.pi.modelo.Obra;
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
@WebServlet(name = "CadastraObra", urlPatterns = {"/CadastraObra"})
public class CadastraObra extends HttpServlet {
   
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
                         throws ServletException, IOException {
        System.out.println("Chamou GET ....");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
                          throws ServletException, IOException {
        System.out.println("Método post requisitado ....");
        
        String nome = req.getParameter("nome");
        String pais = req.getParameter("pais");
        String autor = req.getParameter("autor");
        String linguagem = req.getParameter("linguagem");
        String cor_predominante = req.getParameter("cor_predominante");
        String descricao_obra = req.getParameter("descricao_obra");
        int cod_usuario = Integer.parseInt(req.getParameter("cod_usuario"));

        ArtistaFotografo af = new ArtistaDAO().read(cod_usuario);
        boolean retorno = new ObraDAO().getObras_teste_nome(af.getCod_artistFoto(), nome);
        
        if(retorno == true){
            Obra o = new Obra(af.getCod_artistFoto(),nome,cor_predominante,descricao_obra,linguagem,autor,pais);
            boolean retorno2 = new ObraDAO().create(o);

            if(retorno2 == false){
                req.setAttribute("nome", "ERRO");
                req.setAttribute("criaObra","criaObra");
                req.setAttribute("mensagem", "Algo deu errado no cadastro de sua obra, tente novamente!");
                RequestDispatcher disp = req.getRequestDispatcher("/WEB-INF/views/PaginasComuns/PaginaSucesso.jsp");
                disp.forward(req,resp);
            }else{
                    RequestDispatcher disp = req.getRequestDispatcher("/WEB-INF/views/PaginasArtista/PaginaCadastroObraImagem.html");
                    disp.forward(req,resp);
                }
        }else{
                req.setAttribute("nome", "ERRO");
                req.setAttribute("criaObra","criaObra");
                req.setAttribute("mensagem", "Já existe cadastro de obra com esse nome, tente outro por favor!");
                RequestDispatcher disp = req.getRequestDispatcher("/WEB-INF/views/PaginasComuns/PaginaSucesso.jsp");
                disp.forward(req,resp);
            }
    }
}