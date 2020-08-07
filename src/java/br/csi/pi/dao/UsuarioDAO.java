package br.csi.pi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import br.csi.pi.modelo.Usuario;
import java.sql.Statement;
import java.util.ArrayList;

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
    
    public int read(String email) {
        try (Connection conn = new ConectaPostgres().getConexao()) {
            String sql = "SELECT * FROM usuario WHERE email = ?";
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, email);
            ResultSet rs = pre.executeQuery();
            while(rs.next()){
                Usuario u = new Usuario(rs.getInt("cod_usuario"), 
                                        rs.getString("nome"), 
                                        rs.getString("senha"), 
                                        rs.getString("email"), 
                                        rs.getString("idade"),
                                        rs.getString("pais"),
                                        rs.getString("cidade"),
                                        rs.getString("tipo"));
                return 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 1;
    }
    
    public Usuario read(int cod) {
        try (Connection conn = new ConectaPostgres().getConexao()) {
            String sql = "SELECT * FROM usuario WHERE cod_usuario = ?";
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, cod);
            ResultSet rs = pre.executeQuery();
            while(rs.next()){
                Usuario u = new Usuario(rs.getInt("cod_usuario"), 
                                        rs.getString("nome"), 
                                        rs.getString("senha"), 
                                        rs.getString("email"), 
                                        rs.getString("idade"),
                                        rs.getString("pais"),
                                        rs.getString("cidade"),
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
                                        rs.getString("pais"),
                                        rs.getString("cidade"),
                                        rs.getString("tipo"));
                return u;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public int create(String nome, String senha, String email, String idade, String pais, String cidade, String tipo){
        int u = new UsuarioDAO().read(email);
        
        if(u == 1){
            try (Connection conn = new ConectaPostgres().getConexao()) {
                String sql = "INSERT INTO usuario(nome, senha, email, idade,pais,cidade, tipo) "
                             +"VALUES(?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement pre = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                pre.setString(1, nome);
                pre.setString(2, senha);
                pre.setString(3, email);
                pre.setString(4, idade);
                pre.setString(5, pais);
                pre.setString(6, cidade);
                pre.setString(7, tipo);
                pre.executeUpdate();
                ResultSet rs = pre.getGeneratedKeys();
                rs.next();            

                if(rs.getInt(1) > 0){
                   return rs.getInt(1);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else{
               return -1;
              }
        return 0;
    }
    
    public boolean create(Usuario u) {
        try (Connection conn = new ConectaPostgres().getConexao()){
            String sql = "INSERT INTO usuario(nome, email, senha, idade, pais, cidade, tipo) "
                         +"VALUES(?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, u.getNome());
            pre.setString(2, u.getEmail());
            pre.setString(3, u.getSenha());
            pre.setString(4, u.getIdade());
            pre.setString(5, u.getPais());
            pre.setString(6, u.getCidade());
            pre.setString(7, u.getTipo());
            pre.setString(5, u.getTipo());
            if (pre.executeUpdate() > 0) {
                return true;
            };
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean update(int cod_usuario, String nome, String senha, String email, String idade, String pais, String cidade, String tipo) {
        try (Connection conn = new ConectaPostgres().getConexao()) {
            String sql = "UPDATE usuario SET nome = ?, senha = ?, email = ?, idade = ?, pais = ?, cidade = ?"
                         +", tipo = ? WHERE cod_usuario = ?";
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, nome);
            pre.setString(2, senha);
            pre.setString(3, email);
            pre.setString(4, idade);
            pre.setString(5, pais);
            pre.setString(6, cidade);
            pre.setString(7, tipo);
            pre.setInt(8, cod_usuario);
            if (pre.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean delete(int cod) {
        /*boolean retorno = new LocalizaUsuarioDAO().delete(cod, "u");
        if(retorno){*/
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
        return false;
    }

    public ArrayList<Usuario> getUsuariosGerente() {
        ArrayList<Usuario> usuarios = new ArrayList<>();
        try (Connection conn = new ConectaPostgres().getConexao()) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM usuario");
            while (rs.next()) {
                if(!"g".equals(rs.getString("tipo"))){
                    Usuario us = new Usuario(rs.getInt("cod_usuario"), 
                                             rs.getString("nome"), 
                                             rs.getString("senha"), 
                                             rs.getString("email"), 
                                             rs.getString("idade"),
                                             rs.getString("pais"),
                                             rs.getString("cidade"),
                                             rs.getString("tipo"));
                    usuarios.add(us);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return usuarios;
    }
    
        public ArrayList<Usuario> getUsuarioArtista(String nome) {
        ArrayList<Usuario> usuarios = new ArrayList<>();
        try (Connection conn = new ConectaPostgres().getConexao()) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM usuario");
            while (rs.next()) {
                System.out.println("Nome: "+nome);
                if(nome.equals(rs.getString("nome"))){
                    Usuario us = new Usuario(rs.getInt("cod_usuario"), 
                                             rs.getString("nome"), 
                                             rs.getString("senha"), 
                                             rs.getString("email"), 
                                             rs.getString("idade"),
                                             rs.getString("pais"),
                                             rs.getString("cidade"),
                                             rs.getString("tipo"));
                    usuarios.add(us);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return usuarios;
    }
}