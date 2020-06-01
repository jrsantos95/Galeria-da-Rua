package br.csi.pi.dao;

import br.csi.pi.modelo.Gerente;
import br.csi.pi.modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Juan
 */
public class GerenteDAO {
    public static void main(String args[]){
        Gerente g = new Gerente("Gerente", "1234", "gerente@example.com", "1", "g");
        boolean retorno = new UsuarioDAO().create(g);
        
        if(retorno){
            System.out.println("Gerente cadastrado...");
        }else{
            System.out.println("Gerente não cadastrado...erro!");
        }
    }
    
    public boolean create(Gerente g) {
        int cod_usuario = new UsuarioDAO().create(g.getNome(),g.getSenha(),g.getEmail(),g.getIdade(),g.getTipo());                        
        if(cod_usuario < 1){
            return false;
        }
        try(Connection conn = new ConectaPostgres().getConexao()){
            String sql = "INSERT INTO gerente (cod_usuario) VALUES (?)";
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, cod_usuario);
            if (pre.executeUpdate() > 0){
                return true;
            };                        
        }catch(SQLException e){
            e.printStackTrace();
        }                
        return false;        
    }
    
    public Gerente read(int cod_usuario) {
        Usuario u = new UsuarioDAO().read(cod_usuario);
        try (Connection conn = new ConectaPostgres().getConexao()) {
            String sql = "SELECT * FROM usuario WHERE cod_usuario = ?";
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, cod_usuario);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                Gerente g = new Gerente(cod_usuario,
                                        rs.getInt("cod_gerente"),
                                        u.getNome(), 
                                        u.getSenha(),        
                                        u.getEmail(),        
                                        u.getIdade(),
                                        u.getTipo());
                return g;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public boolean update(Gerente g){
        boolean retorno = new UsuarioDAO().update(g.getCod_usuario(),
                                                  g.getNome(),
                                                  g.getSenha(),
                                                  g.getEmail(),
                                                  g.getIdade(),
                                                  g.getTipo());    
        if(retorno){
            System.out.println("Gerente atualizado com sucesso");
            return true;
        }else{
             System.out.println("Falha ao atualizar gerente");
             return false;
             }
    }
    
    public boolean delete(Gerente g) {
        try (Connection conn = new ConectaPostgres().getConexao()) {
                String sql = "DELETE FROM gerente WHERE cod_gerente = ?";
                PreparedStatement pre = conn.prepareStatement(sql);
                pre.setInt(1, g.getCod_gerente());
                
                if (pre.executeUpdate() > 0){
                    boolean retorno = new UsuarioDAO().delete(g.getCod_usuario());
                    if(retorno){
                        System.out.println("Gerente deletado com sucesso");
                        return true;
                    }else{
                           System.out.println("Falha ao deletar gerente");
                           return false;
                         }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        return false; 
    }
}