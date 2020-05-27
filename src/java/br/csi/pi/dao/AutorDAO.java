package br.csi.pi.dao;

import br.csi.pi.modelo.Autor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Juan
 */
public class AutorDAO {    
    public int create(String nome, String tag){
        try (Connection conn = new ConectaPostgres().getConexao()) {
            String sql = "INSERT INTO autor(nome,autor) VALUES(?,?)";
            PreparedStatement pre = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pre.setString(1, nome);
            pre.setString(2,tag);
            pre.executeUpdate();
            ResultSet rs = pre.getGeneratedKeys();
            rs.next();                   
            if(rs.getInt(1) > 0){
               return rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    
    public Autor read(int cod_autor) {
        try (Connection conn = new ConectaPostgres().getConexao()) {
            String sql = "SELECT * FROM autor WHERE cod_autor = ?";
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, cod_autor);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                Autor at = new Autor(cod_autor, rs.getString("nome"),rs.getString("tag"));
                return at;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public boolean update(int cod_autor, String nome, String tag) {
        try (Connection conn = new ConectaPostgres().getConexao()) {
            String sql = "UPDATE autor SET nome = ?, tag = ? WHERE cod_autor = ?";
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, nome);
            pre.setString(2, tag);
            pre.setInt(3, cod_autor);
            if (pre.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean delete(int cod_autor) {
        boolean retorno = new CriaObraDAO().delete(cod_autor, "at");
        if(retorno){
            try (Connection conn = new ConectaPostgres().getConexao()) {
                String sql = "DELETE FROM autor WHERE cod_autor = ?";
                PreparedStatement pre = conn.prepareStatement(sql);
                pre.setInt(1, cod_autor);
                if (pre.executeUpdate() > 0) {
                    return true;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else{
                System.out.println("Falha ao excluir autor da tabela cria_obra");
             }
        return false;
    } 
}