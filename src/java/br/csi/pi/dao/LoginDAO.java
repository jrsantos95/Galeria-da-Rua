package br.csi.pi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO{
    public String autenticar(String login, String senha){
       try(Connection conn = new ConectaPostgres().getConexao() ){
           String sql = "SELECT tipo FROM usuario WHERE senha = ? AND email = ?";
           PreparedStatement pStmt = conn.prepareStatement(sql);
           pStmt.setString(1, senha);
           pStmt.setString(2, login);
           
           ResultSet rs = pStmt.executeQuery();
           while(rs.next()){
               String tipo = rs.getString("tipo");
               //System.out.println("O TIPO DO USUARIO É: "+tipo);
               return tipo;
           }   
       }catch(SQLException e){
           e.printStackTrace();
       }   
       return "null";
    }   
}