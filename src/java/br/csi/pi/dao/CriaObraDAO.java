package br.csi.pi.dao;

import br.csi.pi.modelo.Autor;
import br.csi.pi.modelo.CriaObra;
import br.csi.pi.modelo.Obra;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Juan
 */
public class CriaObraDAO {
    public boolean create(CriaObra co) {
        try(Connection conn = new ConectaPostgres().getConexao()){
            String sql = "INSERT INTO cria_obra (cod_obra, cod_autor) VALUES (?,?)";
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, co.getObra().getCod_obra());
            pre.setInt(2, co.getAutor().getCod_autor());
            if (pre.executeUpdate() > 0){
                return true;
            };                        
        }catch(SQLException e){
            e.printStackTrace();
        }                
        return false;        
    }
    
    public CriaObra read(int cod_cria_obra) {
        try (Connection conn = new ConectaPostgres().getConexao()) {
            String sql = "SELECT * FROM cria_obra WHERE cod_cria_obra = ?";
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, cod_cria_obra);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                Obra o = new ObraDAO().read(rs.getInt("cod_obra"));
                Autor at = new AutorDAO().read(rs.getInt("cod_autor"));
                CriaObra co = new CriaObra(cod_cria_obra, o, at);
                return co;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public boolean update(int cod_cria_obra, int cod_obra, int cod_autor) {
        try (Connection conn = new ConectaPostgres().getConexao()) {
            String sql = "UPDATE cria_obra SET cod_obra = ?, cod_autor = ? WHERE cod_cria_obra = ?";
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, cod_obra);
            pre.setInt(2, cod_autor);
            if (pre.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean delete(int cod, String tipo) {
        if(tipo == "o"){
            try (Connection conn = new ConectaPostgres().getConexao()) {
                String sql = "DELETE FROM cria_obra WHERE cod_obra = ?";
                PreparedStatement pre = conn.prepareStatement(sql);
                pre.setInt(1, cod);
                if (pre.executeUpdate() > 0) {
                    return true;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else if(tipo == "at"){
                try (Connection conn = new ConectaPostgres().getConexao()) {
                    String sql = "DELETE FROM cria_obra WHERE cod_autor = ?";
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

    CriaObra create(Obra o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}