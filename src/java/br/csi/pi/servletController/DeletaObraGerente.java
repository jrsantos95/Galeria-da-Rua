/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.csi.pi.servletController;

import br.csi.pi.dao.ObraDAO;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "DeletaObraGerente", urlPatterns = {"/DeletaObraGerente"})
public class DeletaObraGerente extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
                         throws ServletException, IOException {
    
    int cod_obra = Integer.parseInt(req.getParameter("cod_obra"));
    String pg_gerente = req.getParameter("pg_gerente");

    boolean retorno = new ObraDAO().delete(cod_obra);
    
    if(pg_gerente.equals("true")  || retorno == true){
        req.setAttribute("nome", "Excluiu!");
        req.setAttribute("mensagem", "Obra Excluida!");
        req.setAttribute("obraExcluidaGerente","obraExcluidaGerente");
        RequestDispatcher disp = req.getRequestDispatcher("/WEB-INF/views/PaginasComuns/PaginaSucesso.jsp");
        disp.forward(req,resp);               
    }
    }
}
