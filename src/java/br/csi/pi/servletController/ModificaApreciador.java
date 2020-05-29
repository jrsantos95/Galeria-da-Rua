
package br.csi.pi.servletController;

import br.csi.pi.dao.ApreciadorDAO;
import br.csi.pi.modelo.Apreciador;
import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;
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
@WebServlet(name = "ModificaApreciador", urlPatterns = {"/ModificaApreciador"})
public class ModificaApreciador extends HttpServlet {
   
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
                         throws ServletException, IOException {
        System.out.println("Chamou GET ....");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
                          throws ServletException, IOException {
        System.out.println("Método post requisitado ....");
        
        PrintWriter resposta = resp.getWriter();
        
        //PEGAR ATRIBULO COD DO CLIENTE PARA DAR UPDATE
        int cod_usuario = Integer.parseInt(req.getParameter("cod_usuario"));
        String nome = req.getParameter("nome");
        String senha = req.getParameter("senha");
        String email = req.getParameter("email");
        String idade = req.getParameter("idade");
        
        Apreciador a = new Apreciador(cod_usuario , nome, senha, email, idade, "ap");
        boolean retorno = new ApreciadorDAO().update(a);

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