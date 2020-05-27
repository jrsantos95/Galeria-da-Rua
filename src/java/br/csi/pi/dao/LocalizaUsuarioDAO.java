package br.csi.pi.dao;

import br.csi.pi.modelo.Cidade;
import br.csi.pi.modelo.LocalizaUsuario;
import br.csi.pi.modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Juan
 */
public class LocalizaUsuarioDAO {
    public boolean create(LocalizaUsuario lu) {
        try(Connection conn = new ConectaPostgres().getConexao()){
            String sql = "INSERT INTO localiza_usuario (cod_usuario, cod_cidade) VALUES (?,?)";
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, lu.getUsuario().getCod_usuario());
            pre.setInt(2, lu.getCidade().getCod_cidade());
            if (pre.executeUpdate() > 0){
                return true;
            };                        
        }catch(SQLException e){
            e.printStackTrace();
        }                
        return false;        
    }
    
    public LocalizaUsuario read(int cod_localiza_usuario) {
        try (Connection conn = new ConectaPostgres().getConexao()) {
            String sql = "SELECT * FROM localiza_usuario WHERE cod_localiza_usuario = ?";
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, cod_localiza_usuario);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                Usuario u = new UsuarioDAO().read(rs.getInt("cod_usuario"));
                Cidade c = new CidadeDAO().read(rs.getInt("cod_cidade"));
                LocalizaUsuario lu = new LocalizaUsuario(cod_localiza_usuario, u, c);
                return lu;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public boolean update(int cod_localiza_usuario, int cod_usuario, int cod_cidade) {
        try (Connection conn = new ConectaPostgres().getConexao()) {
            String sql = "UPDATE localiza_usuario SET cod_usuario = ?, cod_cidade = ? WHERE cod_localiza_usuario = ?";
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, cod_usuario);
            pre.setInt(2, cod_cidade);
            if (pre.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean delete(int cod, String tipo) {
        if(tipo == "u"){
            try (Connection conn = new ConectaPostgres().getConexao()) {
                String sql = "DELETE FROM localiza_usuario WHERE cod_usuario = ?";
                PreparedStatement pre = conn.prepareStatement(sql);
                pre.setInt(1, cod);
                if (pre.executeUpdate() > 0) {
                    return true;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else if(tipo == "c"){
                try (Connection conn = new ConectaPostgres().getConexao()) {
                    String sql = "DELETE FROM localiza_obra WHERE cod_cidade = ?";
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