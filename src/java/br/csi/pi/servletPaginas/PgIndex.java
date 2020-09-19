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
        
        int tamanho = o.size();
        System.out.println("Tamanho: "+tamanho);
        
        if(tamanho > 4){
            tamanho = tamanho/3;
            
            int i = 1;
            int j = 0;
            for(;i<=tamanho;i++){
                while(j < (i*3)){
                    if(j < 3){
                       separador.remove(j);
                    }else{
                       o.remove(j-2);
                    }
                    j++;
                }
            }  
        }else if(tamanho == 4){
            o.remove(3);
        }
        
        req.setAttribute("obras", o);
        req.setAttribute("obras2", separador);
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