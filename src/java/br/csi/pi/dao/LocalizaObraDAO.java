package br.csi.pi.dao;

import br.csi.pi.modelo.Cidade;
import br.csi.pi.modelo.LocalizaObra;
import br.csi.pi.modelo.Obra;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Juan
 */
public class LocalizaObraDAO {
        public boolean create(LocalizaObra lo) {
        try(Connection conn = new ConectaPostgres().getConexao()){
            String sql = "INSERT INTO localiza_obra (cod_obra, cod_cidade) VALUES (?,?)";
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, lo.getObra().getCod_obra());
            pre.setInt(2, lo.getCidade().getCod_cidade());
            if (pre.executeUpdate() > 0){
                return true;
            };                        
        }catch(SQLException e){
            e.printStackTrace();
        }                
        return false;        
    }
    
    public LocalizaObra read(int cod_localiza_obra) {
        try (Connection conn = new ConectaPostgres().getConexao()) {
            String sql = "SELECT * FROM localiza_obra WHERE cod_localiza_obra = ?";
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, cod_localiza_obra);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                Obra o = new ObraDAO().read(rs.getInt("cod_obra"));
                Cidade c = new CidadeDAO().read(rs.getInt("cod_cidade"));
                LocalizaObra lo = new LocalizaObra(cod_localiza_obra, o, c);
                return lo;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public boolean update(int cod_localiza_obra, int cod_obra, int cod_cidade) {
        try (Connection conn = new ConectaPostgres().getConexao()) {
            String sql = "UPDATE localiza_obra SET cod_obra = ?, cod_cidade = ? WHERE cod_localiza_obra = ?";
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, cod_obra);
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
        if(tipo == "o"){
            try (Connection conn = new ConectaPostgres().getConexao()) {
                String sql = "DELETE FROM localiza_obra WHERE cod_obra = ?";
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