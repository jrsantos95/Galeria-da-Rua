package br.csi.pi.dao;

import br.csi.pi.modelo.Pais;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Juan
 */
public class PaisDAO {
    public int create(String nome_pais){
        try (Connection conn = new ConectaPostgres().getConexao()) {
            String sql = "INSERT INTO pais(nome_pais) VALUES(?)";
            PreparedStatement pre = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pre.setString(1, nome_pais);
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
    
    public Pais read(int cod_pais) {
        try (Connection conn = new ConectaPostgres().getConexao()) {
            String sql = "SELECT * FROM pais WHERE cod_pais = ?";
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, cod_pais);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                Pais p = new Pais(cod_pais, rs.getString("nome_pais"));
                return p;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public boolean update(int cod_pais, String nome_pais) {
        try (Connection conn = new ConectaPostgres().getConexao()) {
            String sql = "UPDATE pais SET nome_pais = ? WHERE cod_pais = ?";
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, nome_pais);
            pre.setInt(2, cod_pais);
            if (pre.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean delete(int cod_pais) {//quando deletar um pais tem que deletar todas as cidades dele
        try (Connection conn = new ConectaPostgres().getConexao()) {
            boolean retorno = new CidadeDAO().delete(cod_pais, "p");
            if(retorno){
                String sql = "DELETE FROM pais WHERE cod_pais = ?";
                PreparedStatement pre = conn.prepareStatement(sql);
                pre.setInt(1, cod_pais);
                if (pre.executeUpdate() > 0) {
                    return true;
                }
            }else{
                    System.out.println("Erro ao excluir cidades do pais");
                 }
        } catch (SQLException e) {
                e.printStackTrace();
        }
        return false;
    }
}