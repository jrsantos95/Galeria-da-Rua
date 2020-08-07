/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.csi.pi.servletPaginas;

import br.csi.pi.dao.ArtistaDAO;
import br.csi.pi.dao.ObraDAO;
import br.csi.pi.modelo.ArtistaFotografo;
import br.csi.pi.modelo.Obra;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
@WebServlet(name = "PgDetalhesObra", urlPatterns = {"/pg_detalhesObra"})
public class PgDetalhesObra extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
                     throws ServletException, IOException {
    
    int cod_obra = Integer.parseInt(req.getParameter("cod_obra"));
        
    ArrayList<Obra> ob = new ObraDAO().getObras(cod_obra);

    req.setAttribute("obras", ob);
    RequestDispatcher disp = req.getRequestDispatcher("/WEB-INF/views/PaginasArtista/PaginaDetalhesObra.jsp");
    disp.forward(req,resp);
    }
}
