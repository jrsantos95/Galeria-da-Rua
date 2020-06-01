/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
@WebServlet(name = "CadastraArtistaFotografo", urlPatterns = {"/CadastraArtistaFotografo"})
public class CadastraArtistaFotografo extends HttpServlet {
   
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
        String senha = req.getParameter("senha");
        String confirmaSenha = req.getParameter("confirmaSenha");
        String tag = req.getParameter("tag");
        String email = req.getParameter("email");
        String idade = req.getParameter("idade");
        String pais = req.getParameter("pais");
        String cidade = req.getParameter("cidade");
        String linguagem = req.getParameter("linguagem");
        String contato = req.getParameter("contato");
        String descricao_artist_foto = req.getParameter("descricao_artist_foto");
       
        ArtistaFotografo af = new ArtistaFotografo(tag, 
                                                   contato, 
                                                   linguagem, 
                                                   nome, 
                                                   senha, 
                                                   email, 
                                                   idade, 
                                                   descricao_artist_foto, 
                                                   "art");
        
        int retorno = new ArtistaDAO().create(af);
        
        if(retorno >= 1){
            req.setAttribute("nome", "Cadastrou!");
            req.setAttribute("mensagem", "Cadastro de Apreciador efetuado com sucesso!");
            RequestDispatcher disp = req.getRequestDispatcher("/WEB-INF/views/SucessoCadastro.jsp");
            disp.forward(req,resp);
        }else if(retorno == -1){
                req.setAttribute("nome", "Erro!");
                req.setAttribute("mensagem", "Já existe cadastro com esse e-mail, por favor tente outro!");
                RequestDispatcher disp = req.getRequestDispatcher("/WEB-INF/views/SucessoCadastro.jsp");
                disp.forward(req,resp);
              }else {
                    req.setAttribute("nome", "Erro!");
                    req.setAttribute("mensagem", "Ocorreu algum erro, por favor tente novamente!");
                    RequestDispatcher disp = req.getRequestDispatcher("/WEB-INF/views/SucessoCadastro.jsp");
                    disp.forward(req,resp);
              }
    }
}
