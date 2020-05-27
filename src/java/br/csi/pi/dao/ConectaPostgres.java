package br.csi.pi.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Juan
 */
public class ConectaPostgres {
    private static final String url = "jdbc:postgresql://localhost:5432/ProjetoIntegradorGaleria";
    private static final String user = "postgres";
    private static final String pass = "1234";
     
    public static void main(String args[]){
        new ConectaPostgres().getConexao();
    }
    
    public Connection getConexao(){
        Connection conn = null;      
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(url, user, pass);
        }catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
        return conn;
    } 
}