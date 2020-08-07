package br.csi.pi.servletController;

import br.csi.pi.dao.ApreciadorDAO;
import br.csi.pi.modelo.Apreciador;
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
@WebServlet(name = "CadastraApreciador", urlPatterns = {"/CadastraApreciador"})
public class CadastraApreciador extends HttpServlet {
   
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
        
        String nome = req.getParameter("nome");
        String senha = req.getParameter("senha");
        String confirmaSenha = req.getParameter("confirmaSenha");
        String email = req.getParameter("email");
        String idade = req.getParameter("idade");
        String pais = req.getParameter("pais");
        String cidade = req.getParameter("cidade");
        
        System.out.println("Pais: "+pais);
        System.out.println("Cidade: "+cidade);
        
        if(!confirmaSenha.equals(senha)){
            req.setAttribute("nome", "ERRO!");
            req.setAttribute("tipoAp","ap");
            req.setAttribute("mensagem", "Senha e confirmarSenha não são iguais!, tente novamente");
            RequestDispatcher disp = req.getRequestDispatcher("/WEB-INF/views/PaginasComuns/PaginaSucesso.jsp");
            disp.forward(req,resp);
        }else{
                Apreciador ap = new Apreciador(nome, senha, email, idade, pais, cidade, "ap");

                int retorno = new ApreciadorDAO().create(ap);
                if(retorno >= 1){
                    req.setAttribute("nome", "Cadastrou!");
                    req.setAttribute("index","index");
                    req.setAttribute("mensagem", "Cadastro de Apreciador efetuado com sucesso!");
                    RequestDispatcher disp = req.getRequestDispatcher("/WEB-INF/views/PaginasComuns/PaginaSucesso.jsp");
                    disp.forward(req,resp);
                }else if(retorno == -1){
                        req.setAttribute("nome", "Erro!");
                        req.setAttribute("tipoAp","ap");
                        req.setAttribute("mensagem", "Já existe cadastro com esse e-mail, por favor tente outro!");
                        RequestDispatcher disp = req.getRequestDispatcher("/WEB-INF/views/PaginasComuns/PaginaSucesso.jsp");
                        disp.forward(req,resp);
                      }else {//FAZER PAGINA DE ERRO!!!!!  
                            req.setAttribute("nome", "Erro!");
                            req.setAttribute("tipoAp","ap");
                            req.setAttribute("mensagem", "Ocorreu algum erro, por favor tente novamente!");
                            RequestDispatcher disp = req.getRequestDispatcher("/WEB-INF/views/PaginasComuns/PaginaSucesso.jsp");
                            disp.forward(req,resp);
                      }
            }
    }
}