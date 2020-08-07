/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.csi.pi.servletController;

import br.csi.pi.dao.ObraDAO;
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
@WebServlet(name = "CadastraImagemObra", urlPatterns = {"/CadastraImagemObra"})
public class CadastraImagemObra extends HttpServlet {
   
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
        
        boolean retorno = new ObraDAO().updateImagem(imagem);
        
        if(retorno == false){
            req.setAttribute("nome", "ERRO");
            req.setAttribute("criaObra","criaObra");
            req.setAttribute("mensagem", "Algo deu errado no cadastro de sua obra, tente novamente!");
            RequestDispatcher disp = req.getRequestDispatcher("/WEB-INF/views/PaginasComuns/PaginaSucesso.jsp");
            disp.forward(req,resp);
        }else{
                req.setAttribute("nome", "Sucesso!");
                req.setAttribute("criaObra","criaObra");
                req.setAttribute("mensagem", "Obra cadastrada com sucesso!");
                RequestDispatcher disp = req.getRequestDispatcher("/WEB-INF/views/PaginasComuns/PaginaSucesso.jsp");
                disp.forward(req,resp);
            }
    }
}
