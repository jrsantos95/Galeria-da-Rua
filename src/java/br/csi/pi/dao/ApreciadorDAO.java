package br.csi.pi.dao;

import br.csi.pi.modelo.Apreciador;
import br.csi.pi.modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Juan
 */
public class ApreciadorDAO {
    public int create(Apreciador a) {
        int cod_usuario = new UsuarioDAO().create(a.getNome(),a.getSenha(),a.getEmail(),a.getIdade(),a.getPais(),a.getCidade(),a.getTipo());                        
       
        if(cod_usuario == 0){
            return 0;
        }else if(cod_usuario == -1){
                    return -1;
                  }else{
                        try(Connection conn = new ConectaPostgres().getConexao()){
                            String sql = "INSERT INTO apreciador (cod_usuario) VALUES (?)";
                            PreparedStatement pre = conn.prepareStatement(sql);
                            pre.setInt(1, cod_usuario);
                            if (pre.executeUpdate() > 0){
                                return 1;
                            };                        
                        }catch(SQLException e){
                            e.printStackTrace();
                        }   
                    }
        return 0;        
    }
    
    public Apreciador read(int cod_usuario) {
        Usuario u = new UsuarioDAO().read(cod_usuario);
        try (Connection conn = new ConectaPostgres().getConexao()) {
            String sql = "SELECT * FROM apreciador WHERE cod_usuario = ?";
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, cod_usuario);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                Apreciador a = new Apreciador(cod_usuario,
                                              rs.getInt("cod_apreciador"),
                                              u.getNome(), 
                                              u.getSenha(),        
                                              u.getEmail(),        
                                              u.getIdade(),
                                              u.getPais(),
                                              u.getCidade(),
                                              u.getTipo());
                return a;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public boolean update(Apreciador a){
        boolean retorno = new UsuarioDAO().update(a.getCod_usuario(),
                                                  a.getNome(),
                                                  a.getSenha(),
                                                  a.getEmail(),
                                                  a.getIdade(),
                                                  a.getPais(),
                                                  a.getCidade(),
                                                  a.getTipo());
        
        if(retorno){
            System.out.println("Apreciador atualizado com sucesso");
            return true;
        }else{
             System.out.println("Falha ao atualizar apreciador");
             return false;
             }
    }
    
    public boolean delete(Usuario a) {
        try (Connection conn = new ConectaPostgres().getConexao()) {
                String sql = "DELETE FROM apreciador WHERE cod_usuario = ?";
                PreparedStatement pre = conn.prepareStatement(sql);
                pre.setInt(1, a.getCod_usuario());
                
                if (pre.executeUpdate() > 0){
                    boolean retorno = new UsuarioDAO().delete(a.getCod_usuario());
                    if(retorno){
                        System.out.println("Apreciador deletado com sucesso");
                        return true;
                    }else{
                           System.out.println("Falha ao deletar apreciador");
                           return false;
                    }     
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        return false; 
    }
}