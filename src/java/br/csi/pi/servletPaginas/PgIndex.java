/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.csi.pi.servletPaginas;

import br.csi.pi.dao.ObraDAO;
import br.csi.pi.modelo.Obra;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
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
@WebServlet(name = "PgCadastroIndex", urlPatterns = {"/pg_index"})
public class PgIndex extends HttpServlet {
    
    protected void processRequest(HttpServletRequest req, HttpServletResponse resp) 
                                  throws ServletException, IOException{
        
        ArrayList<Obra> o = new ObraDAO().getObrasTotal();
        ArrayList<Obra> separador = new ObraDAO().getObrasTotal();
        Collections.reverse(separador);
        
        int i = o.size()-1;
        for(;i>2;i--){
            separador.remove(i);
            o.remove(i);
        }

        req.setAttribute("obras", separador);
        req.setAttribute("obras2", o);
        //selecionar obras de 3 em 3
      
        RequestDispatcher disp = req.getRequestDispatcher("WEB-INF/views/PaginaInicial.jsp");
        disp.forward(req, resp);
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
                         throws ServletException, IOException{
        processRequest(req, resp);
    }
}