package br.csi.pi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import br.csi.pi.modelo.Usuario;
import java.sql.Statement;

/**
 *
 * @author Juan
 */
public class UsuarioDAO {
    /*public static void main(String args[]){
        Usuario laulinha = new Usuario("Laulinha", "1234", "laulinha@ex.com", "8");
        boolean retorno = new UsuarioDAO().create(laulinha);
        retorno = new UsuarioDAO().delete(1);
        
        if(retorno){
            System.out.println("Usuario cadastrado...");
        }else{
            System.out.println("Usuario não cadastrado...erro!");
        }
    }*/ //main para testes de CRUD - cadastra e exclui objetos do banco
    
    public Usuario read(int cod) {
        try (Connection conn = new ConectaPostgres().getConexao()) {
            String sql = "SELECT * FROM usuario WHERE cod_usuario = ?";
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, cod);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                Usuario u = new Usuario(cod, 
                                        rs.getString("nome"), 
                                        rs.getString("senha"), 
                                        rs.getString("email"), 
                                        rs.getString("idade"),
                                        rs.getString("tipo"));
                return u;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public Usuario read(String email, String senha){
        try (Connection conn = new ConectaPostgres().getConexao()) {
            String sql = "SELECT * FROM usuario WHERE senha = ? and email = ?";
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, senha);
            pre.setString(2, email);
            ResultSet rs = pre.executeQuery();
            while(rs.next()){
                Usuario u = new Usuario(rs.getInt("cod_usuario"), 
                                        rs.getString("nome"), 
                                        rs.getString("senha"), 
                                        rs.getString("email"), 
                                        rs.getString("idade"),
                                        rs.getString("tipo"));
                return u;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public int create(String nome, String senha, String email, String idade, String tipo){       
         try (Connection conn = new ConectaPostgres().getConexao()) {
            String sql = "INSERT INTO usuario(nome, senha, email, idade, tipo) VALUES(?, ?, ?, ?, ?)";
            PreparedStatement pre = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pre.setString(1, nome);
            pre.setString(2, senha);
            pre.setString(3, email);
            pre.setString(4, idade);
            pre.setString(5, tipo);
            pre.executeUpdate();
            ResultSet rs = pre.getGeneratedKeys();
            rs.next();            
            
            if(rs.getInt(1) > 0){
               System.out.println("AQUI:"+rs.getInt(1));
               return rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    
    public boolean create(Usuario u) {
        try (Connection conn = new ConectaPostgres().getConexao()){
            String sql = "INSERT INTO usuario(nome, email, senha, idade, tipo) VALUES(?,?,?,?,?)";
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, u.getNome());
            pre.setString(2, u.getEmail());
            pre.setString(3, u.getSenha());
            pre.setString(4, u.getIdade());
            pre.setString(5, u.getTipo());
            if (pre.executeUpdate() > 0) {
                return true;
            };
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean update(int cod_usuario, String nome, String senha, String email, String idade, String tipo) {
        try (Connection conn = new ConectaPostgres().getConexao()) {
            String sql = "UPDATE usuario SET nome = ?, senha = ?, email = ?, idade = ?, tipo = ? WHERE cod_usuario = ?";
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, nome);
            pre.setString(2, senha);
            pre.setString(3, email);
            pre.setString(4, idade);
            pre.setString(5, tipo);
            pre.setInt(6, cod_usuario);
            if (pre.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean delete(int cod) {
        boolean retorno = new LocalizaUsuarioDAO().delete(cod, "u");
        if(retorno){
            try (Connection conn = new ConectaPostgres().getConexao()) {
                String sql = "DELETE FROM usuario WHERE cod_usuario = ?";
                PreparedStatement pre = conn.prepareStatement(sql);
                pre.setInt(1, cod);
                if (pre.executeUpdate() > 0) {
                    return true;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}